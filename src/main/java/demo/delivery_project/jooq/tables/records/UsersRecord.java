/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq.tables.records;


import demo.delivery_project.jooq.tables.Users;

import java.time.LocalDateTime;
import java.util.UUID;

import org.jooq.Field;
import org.jooq.Record1;
import org.jooq.Record12;
import org.jooq.Row12;
import org.jooq.impl.UpdatableRecordImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class UsersRecord extends UpdatableRecordImpl<UsersRecord> implements Record12<UUID, String, String, String, String, UUID, String, String, String, UUID, LocalDateTime, UUID> {

    private static final long serialVersionUID = 1L;

    /**
     * Setter for <code>public.users.id</code>.
     */
    public void setId(UUID value) {
        set(0, value);
    }

    /**
     * Getter for <code>public.users.id</code>.
     */
    public UUID getId() {
        return (UUID) get(0);
    }

    /**
     * Setter for <code>public.users.username</code>.
     */
    public void setUsername(String value) {
        set(1, value);
    }

    /**
     * Getter for <code>public.users.username</code>.
     */
    public String getUsername() {
        return (String) get(1);
    }

    /**
     * Setter for <code>public.users.firstname</code>.
     */
    public void setFirstname(String value) {
        set(2, value);
    }

    /**
     * Getter for <code>public.users.firstname</code>.
     */
    public String getFirstname() {
        return (String) get(2);
    }

    /**
     * Setter for <code>public.users.lastname</code>.
     */
    public void setLastname(String value) {
        set(3, value);
    }

    /**
     * Getter for <code>public.users.lastname</code>.
     */
    public String getLastname() {
        return (String) get(3);
    }

    /**
     * Setter for <code>public.users.email</code>.
     */
    public void setEmail(String value) {
        set(4, value);
    }

    /**
     * Getter for <code>public.users.email</code>.
     */
    public String getEmail() {
        return (String) get(4);
    }

    /**
     * Setter for <code>public.users.image_id</code>.
     */
    public void setImageId(UUID value) {
        set(5, value);
    }

    /**
     * Getter for <code>public.users.image_id</code>.
     */
    public UUID getImageId() {
        return (UUID) get(5);
    }

    /**
     * Setter for <code>public.users.password</code>.
     */
    public void setPassword(String value) {
        set(6, value);
    }

    /**
     * Getter for <code>public.users.password</code>.
     */
    public String getPassword() {
        return (String) get(6);
    }

    /**
     * Setter for <code>public.users.password_hash</code>.
     */
    public void setPasswordHash(String value) {
        set(7, value);
    }

    /**
     * Getter for <code>public.users.password_hash</code>.
     */
    public String getPasswordHash() {
        return (String) get(7);
    }

    /**
     * Setter for <code>public.users.status</code>.
     */
    public void setStatus(String value) {
        set(8, value);
    }

    /**
     * Getter for <code>public.users.status</code>.
     */
    public String getStatus() {
        return (String) get(8);
    }

    /**
     * Setter for <code>public.users.role_id</code>.
     */
    public void setRoleId(UUID value) {
        set(9, value);
    }

    /**
     * Getter for <code>public.users.role_id</code>.
     */
    public UUID getRoleId() {
        return (UUID) get(9);
    }

    /**
     * Setter for <code>public.users.created_at</code>.
     */
    public void setCreatedAt(LocalDateTime value) {
        set(10, value);
    }

    /**
     * Getter for <code>public.users.created_at</code>.
     */
    public LocalDateTime getCreatedAt() {
        return (LocalDateTime) get(10);
    }

    /**
     * Setter for <code>public.users.created_by</code>.
     */
    public void setCreatedBy(UUID value) {
        set(11, value);
    }

    /**
     * Getter for <code>public.users.created_by</code>.
     */
    public UUID getCreatedBy() {
        return (UUID) get(11);
    }

    // -------------------------------------------------------------------------
    // Primary key information
    // -------------------------------------------------------------------------

    @Override
    public Record1<UUID> key() {
        return (Record1) super.key();
    }

    // -------------------------------------------------------------------------
    // Record12 type implementation
    // -------------------------------------------------------------------------

    @Override
    public Row12<UUID, String, String, String, String, UUID, String, String, String, UUID, LocalDateTime, UUID> fieldsRow() {
        return (Row12) super.fieldsRow();
    }

    @Override
    public Row12<UUID, String, String, String, String, UUID, String, String, String, UUID, LocalDateTime, UUID> valuesRow() {
        return (Row12) super.valuesRow();
    }

    @Override
    public Field<UUID> field1() {
        return Users.USERS.ID;
    }

    @Override
    public Field<String> field2() {
        return Users.USERS.USERNAME;
    }

    @Override
    public Field<String> field3() {
        return Users.USERS.FIRSTNAME;
    }

    @Override
    public Field<String> field4() {
        return Users.USERS.LASTNAME;
    }

    @Override
    public Field<String> field5() {
        return Users.USERS.EMAIL;
    }

    @Override
    public Field<UUID> field6() {
        return Users.USERS.IMAGE_ID;
    }

    @Override
    public Field<String> field7() {
        return Users.USERS.PASSWORD;
    }

    @Override
    public Field<String> field8() {
        return Users.USERS.PASSWORD_HASH;
    }

    @Override
    public Field<String> field9() {
        return Users.USERS.STATUS;
    }

    @Override
    public Field<UUID> field10() {
        return Users.USERS.ROLE_ID;
    }

    @Override
    public Field<LocalDateTime> field11() {
        return Users.USERS.CREATED_AT;
    }

    @Override
    public Field<UUID> field12() {
        return Users.USERS.CREATED_BY;
    }

    @Override
    public UUID component1() {
        return getId();
    }

    @Override
    public String component2() {
        return getUsername();
    }

    @Override
    public String component3() {
        return getFirstname();
    }

    @Override
    public String component4() {
        return getLastname();
    }

    @Override
    public String component5() {
        return getEmail();
    }

    @Override
    public UUID component6() {
        return getImageId();
    }

    @Override
    public String component7() {
        return getPassword();
    }

    @Override
    public String component8() {
        return getPasswordHash();
    }

    @Override
    public String component9() {
        return getStatus();
    }

    @Override
    public UUID component10() {
        return getRoleId();
    }

    @Override
    public LocalDateTime component11() {
        return getCreatedAt();
    }

    @Override
    public UUID component12() {
        return getCreatedBy();
    }

    @Override
    public UUID value1() {
        return getId();
    }

    @Override
    public String value2() {
        return getUsername();
    }

    @Override
    public String value3() {
        return getFirstname();
    }

    @Override
    public String value4() {
        return getLastname();
    }

    @Override
    public String value5() {
        return getEmail();
    }

    @Override
    public UUID value6() {
        return getImageId();
    }

    @Override
    public String value7() {
        return getPassword();
    }

    @Override
    public String value8() {
        return getPasswordHash();
    }

    @Override
    public String value9() {
        return getStatus();
    }

    @Override
    public UUID value10() {
        return getRoleId();
    }

    @Override
    public LocalDateTime value11() {
        return getCreatedAt();
    }

    @Override
    public UUID value12() {
        return getCreatedBy();
    }

    @Override
    public UsersRecord value1(UUID value) {
        setId(value);
        return this;
    }

    @Override
    public UsersRecord value2(String value) {
        setUsername(value);
        return this;
    }

    @Override
    public UsersRecord value3(String value) {
        setFirstname(value);
        return this;
    }

    @Override
    public UsersRecord value4(String value) {
        setLastname(value);
        return this;
    }

    @Override
    public UsersRecord value5(String value) {
        setEmail(value);
        return this;
    }

    @Override
    public UsersRecord value6(UUID value) {
        setImageId(value);
        return this;
    }

    @Override
    public UsersRecord value7(String value) {
        setPassword(value);
        return this;
    }

    @Override
    public UsersRecord value8(String value) {
        setPasswordHash(value);
        return this;
    }

    @Override
    public UsersRecord value9(String value) {
        setStatus(value);
        return this;
    }

    @Override
    public UsersRecord value10(UUID value) {
        setRoleId(value);
        return this;
    }

    @Override
    public UsersRecord value11(LocalDateTime value) {
        setCreatedAt(value);
        return this;
    }

    @Override
    public UsersRecord value12(UUID value) {
        setCreatedBy(value);
        return this;
    }

    @Override
    public UsersRecord values(UUID value1, String value2, String value3, String value4, String value5, UUID value6, String value7, String value8, String value9, UUID value10, LocalDateTime value11, UUID value12) {
        value1(value1);
        value2(value2);
        value3(value3);
        value4(value4);
        value5(value5);
        value6(value6);
        value7(value7);
        value8(value8);
        value9(value9);
        value10(value10);
        value11(value11);
        value12(value12);
        return this;
    }

    // -------------------------------------------------------------------------
    // Constructors
    // -------------------------------------------------------------------------

    /**
     * Create a detached UsersRecord
     */
    public UsersRecord() {
        super(Users.USERS);
    }

    /**
     * Create a detached, initialised UsersRecord
     */
    public UsersRecord(UUID id, String username, String firstname, String lastname, String email, UUID imageId, String password, String passwordHash, String status, UUID roleId, LocalDateTime createdAt, UUID createdBy) {
        super(Users.USERS);

        setId(id);
        setUsername(username);
        setFirstname(firstname);
        setLastname(lastname);
        setEmail(email);
        setImageId(imageId);
        setPassword(password);
        setPasswordHash(passwordHash);
        setStatus(status);
        setRoleId(roleId);
        setCreatedAt(createdAt);
        setCreatedBy(createdBy);
        resetChangedOnNotNull();
    }
}
