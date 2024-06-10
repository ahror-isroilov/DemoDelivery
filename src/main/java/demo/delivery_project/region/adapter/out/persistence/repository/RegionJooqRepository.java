package demo.delivery_project.region.adapter.out.persistence.repository;

import demo.delivery_project.jooq.Tables;
import demo.delivery_project.jooq.tables.Regions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.JSON;
import org.jooq.Record3;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

import static org.jooq.impl.DSL.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RegionJooqRepository {
    private final DSLContext ctx;

    public List<Record3<UUID, String, JSON>> getAllWithPlaces() {
        return ctx.select(
                        Regions.REGIONS.ID,
                        Regions.REGIONS.NAME,
                        jsonArrayAgg(
                                jsonObject(
                                        key("id").value(Tables.PLACES.ID),
                                        key("name").value(Tables.PLACES.NAME)
                                )
                        ).orderBy(Tables.PLACES.NAME.desc()).as("places")
                ).from(Tables.REGIONS)
                .leftJoin(Tables.PLACES).on(Tables.REGIONS.ID.eq(Tables.PLACES.REGION_ID))
                .groupBy(Tables.REGIONS.ID, Tables.REGIONS.NAME)
                .orderBy(Tables.REGIONS.NAME.asc())
                .fetch().stream().toList();
    }
}
