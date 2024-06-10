package demo.delivery_project.token.adapter.out.persistence.repository;

import demo.delivery_project.jooq.Tables;
import demo.delivery_project.jooq.tables.records.AccessTokensRecord;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.Record1;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
@Slf4j
public
class AccessTokenJooqRepository {
    private final DSLContext ctx;

    public AccessTokensRecord create(AccessTokensRecord record) {
        Record1<AccessTokensRecord> returnigRecord = ctx.insertInto(Tables.ACCESS_TOKENS)
                .set(record)
                .returningResult(Tables.ACCESS_TOKENS)
                .fetchOne();
        return returnigRecord.component1();
    }

    public Optional<AccessTokensRecord> get(String token) {
        return Optional.ofNullable(ctx.fetchOne(Tables.ACCESS_TOKENS, Tables.ACCESS_TOKENS.TOKEN.eq(token)));
    }

    public void delete(String token) {
        ctx.delete(Tables.ACCESS_TOKENS)
                .where(Tables.ACCESS_TOKENS.TOKEN.eq(token))
                .execute();
    }
}
