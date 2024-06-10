/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq.tables;


import demo.delivery_project.jooq.Keys;
import demo.delivery_project.jooq.Public;
import demo.delivery_project.jooq.tables.records.RolesRecord;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function5;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row5;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Roles extends TableImpl<RolesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.roles</code>
     */
    public static final Roles ROLES = new Roles();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<RolesRecord> getRecordType() {
        return RolesRecord.class;
    }

    /**
     * The column <code>public.roles.id</code>.
     */
    public final TableField<RolesRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.roles.name</code>.
     */
    public final TableField<RolesRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR.nullable(false), this, "");

    /**
     * The column <code>public.roles.is_deleted</code>.
     */
    public final TableField<RolesRecord, Boolean> IS_DELETED = createField(DSL.name("is_deleted"), SQLDataType.BOOLEAN.defaultValue(DSL.field(DSL.raw("false"), SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.roles.created_at</code>.
     */
    public final TableField<RolesRecord, LocalDateTime> CREATED_AT = createField(DSL.name("created_at"), SQLDataType.LOCALDATETIME(6), this, "");

    /**
     * The column <code>public.roles.created_by</code>.
     */
    public final TableField<RolesRecord, UUID> CREATED_BY = createField(DSL.name("created_by"), SQLDataType.UUID, this, "");

    private Roles(Name alias, Table<RolesRecord> aliased) {
        this(alias, aliased, null);
    }

    private Roles(Name alias, Table<RolesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.roles</code> table reference
     */
    public Roles(String alias) {
        this(DSL.name(alias), ROLES);
    }

    /**
     * Create an aliased <code>public.roles</code> table reference
     */
    public Roles(Name alias) {
        this(alias, ROLES);
    }

    /**
     * Create a <code>public.roles</code> table reference
     */
    public Roles() {
        this(DSL.name("roles"), null);
    }

    public <O extends Record> Roles(Table<O> child, ForeignKey<O, RolesRecord> key) {
        super(child, key, ROLES);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<RolesRecord> getPrimaryKey() {
        return Keys.ROLES_PKEY;
    }

    @Override
    public List<ForeignKey<RolesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.ROLES__ROLES_CREATED_BY_FKEY);
    }

    private transient Users _users;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.ROLES__ROLES_CREATED_BY_FKEY);

        return _users;
    }

    @Override
    public Roles as(String alias) {
        return new Roles(DSL.name(alias), this);
    }

    @Override
    public Roles as(Name alias) {
        return new Roles(alias, this);
    }

    @Override
    public Roles as(Table<?> alias) {
        return new Roles(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Roles rename(String name) {
        return new Roles(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Roles rename(Name name) {
        return new Roles(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Roles rename(Table<?> name) {
        return new Roles(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row5 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row5<UUID, String, Boolean, LocalDateTime, UUID> fieldsRow() {
        return (Row5) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function5<? super UUID, ? super String, ? super Boolean, ? super LocalDateTime, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function5<? super UUID, ? super String, ? super Boolean, ? super LocalDateTime, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
