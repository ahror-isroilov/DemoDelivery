/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq.tables.records;


import demo.delivery_project.jooq.tables.Roles;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Row5;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class RolesRecord extends UpdatableRecordImpl<RolesRecord> implements Record5<UUID, String, Boolean, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.roles.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.roles.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.roles.name</code>.
     */
    public void setName(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.roles.name</code>.
     */
    public String getName() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.roles.is_deleted</code>.
     */
    public void setIsDeleted(Boolean value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.roles.is_deleted</code>.
     */
    public Boolean getIsDeleted() {
        return (Boolean) get(2);
    }

    /**
     * Setter for <code>public.roles.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.roles.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(3);
    }

    /**
     * Setter for <code>public.roles.created_by</code>.
     */
    public void setCreatedBy(UUID value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.roles.created_by</code>.
     */
    public UUID getCreatedBy() {
        return (UUID) get(4);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record5 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, String, Boolean, LocalDateTime, UUID> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    @Override
    public Row5<UUID, String, Boolean, LocalDateTime, UUID> valuesRow() {
        return (Row5) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Roles.ROLES.ID;
    }

    @Override
    public Field<String> field2() {
        return Roles.ROLES.NAME;
    }

    @Override
    public Field<Boolean> field3() {
        return Roles.ROLES.IS_DELETED;
    }

    @Override
    public Field<LocalDateTime> field4() {
        return Roles.ROLES.CREATED_AT;
    }

    @Override
    public Field<UUID> field5() {
        return Roles.ROLES.CREATED_BY;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getName();
    }

    @Override
    public Boolean component3() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime component4() {
        return getCreatedAt();
    }

    @Override
    public UUID component5() {
        return getCreatedBy();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getName();
    }

    @Override
    public Boolean value3() {
        return getIsDeleted();
    }

    @Override
    public LocalDateTime value4() {
        return getCreatedAt();
    }

    @Override
    public UUID value5() {
        return getCreatedBy();
    }

    @Override
    public RolesRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public RolesRecord value2(String value) {
        setName(value);
        return this;
    }

    @Override
    public RolesRecord value3(Boolean value) {
        setIsDeleted(value);
        return this;
    }

    @Override
    public RolesRecord value4(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public RolesRecord value5(UUID value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public RolesRecord values(UUID value1, String value2, Boolean value3, LocalDateTime value4, UUID value5) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached RolesRecord
     */
    public RolesRecord() {
        super(Roles.ROLES);
    }

    /**
     * Create a detached, initialised RolesRecord
     */
    public RolesRecord(UUID id, String name, Boolean isDeleted, LocalDateTime createdAt, UUID createdBy) {
        super(Roles.ROLES);

        setId(id);
        setName(name);
        setIsDeleted(isDeleted);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        resetChangedOnNotNull();
    }
}