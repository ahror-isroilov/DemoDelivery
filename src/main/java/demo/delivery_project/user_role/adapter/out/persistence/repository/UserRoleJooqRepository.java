package demo.delivery_project.user_role.adapter.out.persistence.repository;

import demo.delivery_project.jooq.Tables;
import demo.delivery_project.jooq.tables.Roles;
import demo.delivery_project.jooq.tables.records.RolesRecord;
import demo.delivery_project.user_role.application.domain.model.UserRole;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jooq.Record;
import org.jooq.*;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.jooq.impl.DSL.arrayAgg;

@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRoleJooqRepository {
    private final DSLContext ctx;

    public Optional<Record> get(UUID id) {
        Record4<UUID, String, String[], Boolean> fetched = ctx.select(
                        Roles.ROLES.ID,
                        Roles.ROLES.NAME,
                        arrayAgg(Tables.ROLE_PERMISSIONS.PERMISSION).as("permissions"),
                        Roles.ROLES.IS_DELETED)
                .from(Tables.ROLES)
                .leftJoin(Tables.ROLE_PERMISSIONS).on(Tables.ROLE_PERMISSIONS.ROLE_ID.eq(id))
                .where(Tables.ROLES.ID.eq(id))
                .groupBy(Tables.ROLES.ID, Tables.ROLES.NAME)
                .fetchOne();
        return Optional.ofNullable(fetched);
    }

    public Optional<Record> getByUserId(UUID userId) {
        Record4<UUID, String, String[], Boolean> fetched = ctx.select(
                        Roles.ROLES.ID,
                        Roles.ROLES.NAME,
                        arrayAgg(Tables.ROLE_PERMISSIONS.PERMISSION).as("permissions"),
                        Roles.ROLES.IS_DELETED)
                .from(Tables.ROLES)
                .leftJoin(Tables.ROLE_PERMISSIONS).on(Tables.ROLE_PERMISSIONS.ROLE_ID.eq(Tables.ROLES.ID))
                .leftJoin(Tables.USERS).on(Tables.USERS.ID.eq(userId))
                .where(Tables.ROLES.ID.eq(Tables.USERS.ROLE_ID))
                .groupBy(Tables.ROLES.ID, Tables.ROLES.NAME)
                .fetchOne();
        return Optional.ofNullable(fetched);
    }

    public List<RolesRecord> getAll(Pageable pageable) {
        Result<Record1<RolesRecord>> fetch = ctx.select(Tables.ROLES).from(Tables.ROLES)
                .limit((pageable.getPageSize() != 0 ? pageable.getPageSize() : Integer.MAX_VALUE))
                .offset((pageable.getPageNumber() - 1) * pageable.getPageSize()).fetch();
        return fetch.stream().map(r -> r.component1()).toList();
    }

    @Transactional
    public RolesRecord create(RolesRecord record, UserRole domain) {
        Record1<RolesRecord> fetched = ctx.insertInto(Tables.ROLES)
                .set(record)
                .returningResult(Tables.ROLES).fetchOne();
        ctx.batchInsert(domain.getPermissions().stream()
                        .map(permission -> ctx.newRecord(Tables.ROLE_PERMISSIONS)
                                .values(domain.getId(), permission)).toList())
                .execute();
        return fetched.component1();
    }

    public void delete(UUID id) {
        ctx.delete(Tables.ROLES)
                .where(Tables.ROLES.ID.eq(id))
                .execute();
    }

    public RolesRecord update(RolesRecord record) {
        Record1<RolesRecord> fetched = ctx.update(Tables.ROLES)
                .set(record).returningResult(Tables.ROLES)
                .fetchOne();
        return fetched.component1();
    }
}
