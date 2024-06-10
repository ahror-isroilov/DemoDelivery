package demo.delivery_project.user.adapter.out.persistence.repository;

import demo.delivery_project.jooq.tables.Users;
import demo.delivery_project.jooq.tables.records.UsersRecord;
import demo.delivery_project.region.application.usecase.in.response.RegionResponse;
import demo.delivery_project.user.application.usecase.in.request.SetCarrierRegionsRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.jooq.Result;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static demo.delivery_project.jooq.Tables.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserJooqRepository {
    private final DSLContext ctx;

    public UsersRecord create(UsersRecord record) {
        Record1<UsersRecord> user = ctx.insertInto(USERS)
                .set(record)
                .returningResult(Users.USERS)
                .fetchOne();
        return user.component1();
    }

    public Optional<UsersRecord> get(UUID id) {
        UsersRecord record = ctx.fetchOne(USERS, Users.USERS.ID.eq(id));
        return Optional.ofNullable(record);
    }

    public Optional<UsersRecord> getByUsernameOrEmail(String value) {
        UsersRecord record = ctx.fetchOne(USERS, Users.USERS.USERNAME.eq(value).or(Users.USERS.EMAIL.eq(value)));
        return Optional.ofNullable(record);
    }

    public Boolean existsByEmailAndUsername(String email, String username) {
        return ctx.fetchExists(USERS, Users.USERS.USERNAME.eq(username).and(Users.USERS.EMAIL.eq(email)));
    }

    public Boolean existsByUsernameOrEmail(String value) {
        return ctx.fetchExists(USERS, Users.USERS.USERNAME.eq(value).or(Users.USERS.EMAIL.eq(value)));
    }

    public List<UsersRecord> findAll(Pageable pageable) {
        Result<Record1<UsersRecord>> fetch = ctx.select(USERS).from(USERS)
                .limit((pageable.getPageSize() != 0) ? pageable.getPageSize() : Integer.MAX_VALUE)
                .offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).fetch();
        return fetch.stream().map(u -> u.component1()).toList();
    }

    public List<UsersRecord> findAllByRegion(String region) {
        Result<Record1<UsersRecord>> fetch = ctx.select(USERS)
                .from(USERS)
                .join(REGIONS).on(REGIONS.NAME.eq(region))
                .join(CARRIER_REGIONS).on(CARRIER_REGIONS.REGION_ID.eq(REGIONS.ID))
                .where(USERS.ID.eq(CARRIER_REGIONS.CARRIER_ID))
                .fetch();
        return fetch.stream().map(u -> u.component1()).toList();
    }

    public Optional<UsersRecord> update(UsersRecord record) {
        Record1<UsersRecord> usersRecordRecord1 = ctx.update(USERS)
                .set(record).returningResult(USERS)
                .fetchOne();
        return Optional.of(usersRecordRecord1.component1());
    }

    public void delete(UUID id) {
        ctx.delete(USERS)
                .where(USERS.ID.eq(id))
                .execute();
    }

    public List<RegionResponse> storeCarrierRegions(SetCarrierRegionsRequest request) {
        UUID userId = ctx.select(USERS.ID)
                .from(USERS)
                .where(USERS.USERNAME.eq(request.getUsername()))
                .fetchOne(USERS.ID);

        Map<UUID, String> regionMap = ctx.select(REGIONS.ID, REGIONS.NAME)
                .from(REGIONS)
                .where(REGIONS.NAME.in(request.getRegions()))
                .orderBy(REGIONS.NAME.asc())
                .fetchMap(REGIONS.ID, REGIONS.NAME);
        regionMap.keySet().forEach(id ->
                ctx.insertInto(CARRIER_REGIONS, CARRIER_REGIONS.CARRIER_ID, CARRIER_REGIONS.REGION_ID)
                        .values(userId, id).execute());

        return regionMap.entrySet().stream().map(
                e -> new RegionResponse(e.getKey(), e.getValue())
        ).toList();
    }
}
