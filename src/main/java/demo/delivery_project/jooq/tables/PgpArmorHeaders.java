/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq.tables;


import demo.delivery_project.jooq.Public;
import demo.delivery_project.jooq.tables.records.PgpArmorHeadersRecord;

import java.util.function.Function;

import org.jooq.Field;
import org.jooq.Function2;
import org.jooq.Name;
import org.jooq.Records;
import org.jooq.Row2;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class PgpArmorHeaders extends TableImpl<PgpArmorHeadersRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.pgp_armor_headers</code>
     */
    public static final PgpArmorHeaders PGP_ARMOR_HEADERS = new PgpArmorHeaders();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<PgpArmorHeadersRecord> getRecordType() {
        return PgpArmorHeadersRecord.class;
    }

    /**
     * The column <code>public.pgp_armor_headers.key</code>.
     */
    public final TableField<PgpArmorHeadersRecord, String> KEY = createField(DSL.name("key"), SQLDataType.CLOB, this, "");

    /**
     * The column <code>public.pgp_armor_headers.value</code>.
     */
    public final TableField<PgpArmorHeadersRecord, String> VALUE = createField(DSL.name("value"), SQLDataType.CLOB, this, "");

    private PgpArmorHeaders(Name alias, Table<PgpArmorHeadersRecord> aliased) {
        this(alias, aliased, new Field[] {
            DSL.val(null, SQLDataType.CLOB)
        });
    }

    private PgpArmorHeaders(Name alias, Table<PgpArmorHeadersRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.function());
    }

    /**
     * Create an aliased <code>public.pgp_armor_headers</code> table reference
     */
    public PgpArmorHeaders(String alias) {
        this(DSL.name(alias), PGP_ARMOR_HEADERS);
    }

    /**
     * Create an aliased <code>public.pgp_armor_headers</code> table reference
     */
    public PgpArmorHeaders(Name alias) {
        this(alias, PGP_ARMOR_HEADERS);
    }

    /**
     * Create a <code>public.pgp_armor_headers</code> table reference
     */
    public PgpArmorHeaders() {
        this(DSL.name("pgp_armor_headers"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public PgpArmorHeaders as(String alias) {
        return new PgpArmorHeaders(DSL.name(alias), this, parameters);
    }

    @Override
    public PgpArmorHeaders as(Name alias) {
        return new PgpArmorHeaders(alias, this, parameters);
    }

    @Override
    public PgpArmorHeaders as(Table<?> alias) {
        return new PgpArmorHeaders(alias.getQualifiedName(), this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public PgpArmorHeaders rename(String name) {
        return new PgpArmorHeaders(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public PgpArmorHeaders rename(Name name) {
        return new PgpArmorHeaders(name, null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public PgpArmorHeaders rename(Table<?> name) {
        return new PgpArmorHeaders(name.getQualifiedName(), null, parameters);
    }

    // -------------------------------------------------------------------------
    // Row2 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row2<String, String> fieldsRow() {
        return (Row2) super.fieldsRow();
    }

    /**
     * Call this table-valued function
     */
    public PgpArmorHeaders call(
          String __1
    ) {
        PgpArmorHeaders result = new PgpArmorHeaders(DSL.name("pgp_armor_headers"), null, new Field[] {
            DSL.val(__1, SQLDataType.CLOB)
        });

        return aliased() ? result.as(getUnqualifiedName()) : result;
    }

    /**
     * Call this table-valued function
     */
    public PgpArmorHeaders call(
          Field<String> __1
    ) {
        PgpArmorHeaders result = new PgpArmorHeaders(DSL.name("pgp_armor_headers"), null, new Field[] {
            __1
        });

        return aliased() ? result.as(getUnqualifiedName()) : result;
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function2<? super String, ? super String, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}
