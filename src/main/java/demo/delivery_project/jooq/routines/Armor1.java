/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq.routines;


import demo.delivery_project.jooq.Public;

import org.jooq.Field;
import org.jooq.Parameter;
import org.jooq.impl.AbstractRoutine;
import org.jooq.impl.Internal;
import org.jooq.impl.SQLDataType;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Armor1 extends AbstractRoutine<String> {

    private static final long serialVersionUID = 1L;

    /**
     * The parameter <code>public.armor.RETURN_VALUE</code>.
     */
    public static final Parameter<String> RETURN_VALUE = Internal.createParameter("RETURN_VALUE", SQLDataType.CLOB, false, false);

    /**
     * The parameter <code>public.armor._1</code>.
     */
    public static final Parameter<byte[]> _1 = Internal.createParameter("_1", SQLDataType.BLOB, false, true);

    /**
     * Create a new routine call instance
     */
    public Armor1() {
        super("armor", Public.PUBLIC, SQLDataType.CLOB);

        setReturnParameter(RETURN_VALUE);
        addInParameter(_1);
        setOverloaded(true);
    }

    /**
     * Set the <code>_1</code> parameter IN value to the routine
     */
    public void set__1(byte[] value) {
        setValue(_1, value);
    }

    /**
     * Set the <code>_1</code> parameter to the function to be used with a
     * {@link org.jooq.Select} statement
     */
    public void set__1(Field<byte[]> field) {
        setField(_1, field);
    }
}
