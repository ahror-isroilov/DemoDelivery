package demo.delivery_project.transaction.adapter.out.persistence.repository;

import demo.delivery_project.jooq.Tables;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.transaction.application.usecase.in.response.DeliveryRegionsPerTransactionCount;
import demo.delivery_project.transaction.application.usecase.in.response.TotalTransactionScorePerCarrier;
import demo.delivery_project.transaction.application.usecase.in.response.TransactionCountPerProduct;
import lombok.RequiredArgsConstructor;
import org.jooq.DSLContext;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static demo.delivery_project.jooq.Tables.*;
import static org.jooq.impl.DSL.count;
import static org.jooq.impl.DSL.sum;

@Repository
@RequiredArgsConstructor
public class TransactionJooqRepository {
    private final DSLContext ctx;

    public Boolean checkIfTwoPlacesHaveSameRegion(String carrierName, String requestCode, String offerCode) {
        var userRegions = ctx.select(Tables.CARRIER_REGIONS.REGION_ID)
                .from(Tables.CARRIER_REGIONS)
                .join(USERS).on(USERS.ID.eq(CARRIER_REGIONS.CARRIER_ID))
                .where(USERS.USERNAME.eq(carrierName));

        boolean checkOfferPlace = ctx.fetchExists(
                ctx.selectOne()
                        .from(PLACES)
                        .join(OFFERS).on(OFFERS.CODE.eq(offerCode))
                        .where(PLACES.NAME.eq(OFFERS.PLACE_NAME)
                                .and(PLACES.REGION_ID.in(userRegions))
                        ));

        boolean checkRequestPlace = ctx.fetchExists(
                ctx.selectOne()
                        .from(PLACES)
                        .join(REQUESTS).on(REQUESTS.CODE.eq(requestCode))
                        .where(PLACES.NAME.eq(REQUESTS.PLACE_NAME)
                                .and(PLACES.REGION_ID.in(userRegions))
                        ));
        return checkOfferPlace && checkRequestPlace;
    }

    public List<DeliveryRegionsPerTransactionCount> getTransactionCountPerRegion() {
        return ctx.select(
                        count(TRANSACTIONS.REQUEST_CODE).as("tCount"),
                        REGIONS.NAME,
                        REGIONS.ID
                ).from(REGIONS)
                .join(PLACES).on(PLACES.REGION_ID.eq(REGIONS.ID))
                .join(REQUESTS).on(REQUESTS.PLACE_NAME.eq(PLACES.NAME))
                .join(TRANSACTIONS).on(TRANSACTIONS.REQUEST_CODE.eq(REQUESTS.CODE))
                .groupBy(REGIONS.NAME, REGIONS.ID)
                .orderBy(count(TRANSACTIONS.REQUEST_CODE).desc(), REGIONS.NAME.asc())
                .fetch().stream()
                .collect(Collectors.groupingBy(record ->
                                record.get("tCount", Integer.class),
                        Collectors.mapping(
                                record -> new RegionResponse(record.get(REGIONS.ID), record.get(REGIONS.NAME)),
                                Collectors.toList()
                        ))).entrySet().stream()
                .map(entry -> new DeliveryRegionsPerTransactionCount(entry.getKey(), entry.getValue()))
                .toList();
    }

    public List<TotalTransactionScorePerCarrier> getTotalTransactionScorePerCarrier(Integer minScore) {
        return ctx.select(
                        USERS.ID,
                        USERS.USERNAME,
                        sum(TRANSACTIONS.SCORE).as("totalScore")
                ).from(USERS)
                .join(TRANSACTIONS).on(TRANSACTIONS.CARRIER_USERNAME.eq(USERS.USERNAME))
                .groupBy(USERS.USERNAME, USERS.ID)
                .having(sum(TRANSACTIONS.SCORE).ge(BigDecimal.valueOf(minScore)))
                .orderBy(USERS.USERNAME.asc()).fetch()
                .stream().map(record -> new TotalTransactionScorePerCarrier(record.get(USERS.ID),
                        record.get(USERS.USERNAME),
                        record.get("totalScore", Integer.class))).toList();
    }

    public List<TransactionCountPerProduct> getTransactionCountPerProduct() {
        return ctx.select(
                        PRODUCTS.CODE,
                        count(TRANSACTIONS).as("tCount")
                ).from(PRODUCTS)
                .join(OFFERS).on(OFFERS.PRODUCT_ID.eq(PRODUCTS.ID))
                .join(REQUESTS).on(REQUESTS.PRODUCT_ID.eq(PRODUCTS.ID))
                .join(TRANSACTIONS).on(TRANSACTIONS.REQUEST_CODE.eq(REQUESTS.CODE).and(TRANSACTIONS.OFFER_CODE.eq(OFFERS.CODE)))
                .groupBy(PRODUCTS.CODE)
                .having(count(TRANSACTIONS).greaterThan(0))
                .orderBy(PRODUCTS.CODE).fetch()
                .stream().map(record -> new TransactionCountPerProduct(
                        record.get(PRODUCTS.CODE),
                        record.get("tCount", Integer.class)
                )).toList();
    }
}
