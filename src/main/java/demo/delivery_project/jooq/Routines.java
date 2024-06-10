/*
 * This file is generated by jOOQ.
 */
package demo.delivery_project.jooq;


import demo.delivery_project.jooq.routines.Armor1;
import demo.delivery_project.jooq.routines.Armor2;
import demo.delivery_project.jooq.routines.Crypt;
import demo.delivery_project.jooq.routines.Dearmor;
import demo.delivery_project.jooq.routines.Decrypt;
import demo.delivery_project.jooq.routines.DecryptIv;
import demo.delivery_project.jooq.routines.Digest1;
import demo.delivery_project.jooq.routines.Digest2;
import demo.delivery_project.jooq.routines.Encrypt;
import demo.delivery_project.jooq.routines.EncryptIv;
import demo.delivery_project.jooq.routines.GenRandomBytes;
import demo.delivery_project.jooq.routines.GenRandomUuid;
import demo.delivery_project.jooq.routines.GenSalt1;
import demo.delivery_project.jooq.routines.GenSalt2;
import demo.delivery_project.jooq.routines.Hmac1;
import demo.delivery_project.jooq.routines.Hmac2;
import demo.delivery_project.jooq.routines.PgpKeyId;
import demo.delivery_project.jooq.routines.PgpPubDecrypt1;
import demo.delivery_project.jooq.routines.PgpPubDecrypt2;
import demo.delivery_project.jooq.routines.PgpPubDecrypt3;
import demo.delivery_project.jooq.routines.PgpPubDecryptBytea1;
import demo.delivery_project.jooq.routines.PgpPubDecryptBytea2;
import demo.delivery_project.jooq.routines.PgpPubDecryptBytea3;
import demo.delivery_project.jooq.routines.PgpPubEncrypt1;
import demo.delivery_project.jooq.routines.PgpPubEncrypt2;
import demo.delivery_project.jooq.routines.PgpPubEncryptBytea1;
import demo.delivery_project.jooq.routines.PgpPubEncryptBytea2;
import demo.delivery_project.jooq.routines.PgpSymDecrypt1;
import demo.delivery_project.jooq.routines.PgpSymDecrypt2;
import demo.delivery_project.jooq.routines.PgpSymDecryptBytea1;
import demo.delivery_project.jooq.routines.PgpSymDecryptBytea2;
import demo.delivery_project.jooq.routines.PgpSymEncrypt1;
import demo.delivery_project.jooq.routines.PgpSymEncrypt2;
import demo.delivery_project.jooq.routines.PgpSymEncryptBytea1;
import demo.delivery_project.jooq.routines.PgpSymEncryptBytea2;
import demo.delivery_project.jooq.tables.PgpArmorHeaders;
import demo.delivery_project.jooq.tables.records.PgpArmorHeadersRecord;

import java.util.UUID;

import org.jooq.Configuration;
import org.jooq.Field;
import org.jooq.Result;


/**
 * Convenience access to all stored procedures and functions in public.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Routines {

    /**
     * Call <code>public.armor</code>
     */
    public static String armor1(
          Configuration configuration
        , byte[] __1
    ) {
        Armor1 f = new Armor1();
        f.set__1(__1);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.armor</code> as a field.
     */
    public static Field<String> armor1(
          byte[] __1
    ) {
        Armor1 f = new Armor1();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Get <code>public.armor</code> as a field.
     */
    public static Field<String> armor1(
          Field<byte[]> __1
    ) {
        Armor1 f = new Armor1();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Call <code>public.armor</code>
     */
    public static String armor2(
          Configuration configuration
        , byte[] __1
        , String[] __2
        , String[] __3
    ) {
        Armor2 f = new Armor2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.armor</code> as a field.
     */
    public static Field<String> armor2(
          byte[] __1
        , String[] __2
        , String[] __3
    ) {
        Armor2 f = new Armor2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.armor</code> as a field.
     */
    public static Field<String> armor2(
          Field<byte[]> __1
        , Field<String[]> __2
        , Field<String[]> __3
    ) {
        Armor2 f = new Armor2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.crypt</code>
     */
    public static String crypt(
          Configuration configuration
        , String __1
        , String __2
    ) {
        Crypt f = new Crypt();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.crypt</code> as a field.
     */
    public static Field<String> crypt(
          String __1
        , String __2
    ) {
        Crypt f = new Crypt();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.crypt</code> as a field.
     */
    public static Field<String> crypt(
          Field<String> __1
        , Field<String> __2
    ) {
        Crypt f = new Crypt();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.dearmor</code>
     */
    public static byte[] dearmor(
          Configuration configuration
        , String __1
    ) {
        Dearmor f = new Dearmor();
        f.set__1(__1);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.dearmor</code> as a field.
     */
    public static Field<byte[]> dearmor(
          String __1
    ) {
        Dearmor f = new Dearmor();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Get <code>public.dearmor</code> as a field.
     */
    public static Field<byte[]> dearmor(
          Field<String> __1
    ) {
        Dearmor f = new Dearmor();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Call <code>public.decrypt</code>
     */
    public static byte[] decrypt(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        Decrypt f = new Decrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.decrypt</code> as a field.
     */
    public static Field<byte[]> decrypt(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        Decrypt f = new Decrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.decrypt</code> as a field.
     */
    public static Field<byte[]> decrypt(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        Decrypt f = new Decrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.decrypt_iv</code>
     */
    public static byte[] decryptIv(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , byte[] __3
        , String __4
    ) {
        DecryptIv f = new DecryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.decrypt_iv</code> as a field.
     */
    public static Field<byte[]> decryptIv(
          byte[] __1
        , byte[] __2
        , byte[] __3
        , String __4
    ) {
        DecryptIv f = new DecryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Get <code>public.decrypt_iv</code> as a field.
     */
    public static Field<byte[]> decryptIv(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<byte[]> __3
        , Field<String> __4
    ) {
        DecryptIv f = new DecryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Call <code>public.digest</code>
     */
    public static byte[] digest1(
          Configuration configuration
        , String __1
        , String __2
    ) {
        Digest1 f = new Digest1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.digest</code> as a field.
     */
    public static Field<byte[]> digest1(
          String __1
        , String __2
    ) {
        Digest1 f = new Digest1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.digest</code> as a field.
     */
    public static Field<byte[]> digest1(
          Field<String> __1
        , Field<String> __2
    ) {
        Digest1 f = new Digest1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.digest</code>
     */
    public static byte[] digest2(
          Configuration configuration
        , byte[] __1
        , String __2
    ) {
        Digest2 f = new Digest2();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.digest</code> as a field.
     */
    public static Field<byte[]> digest2(
          byte[] __1
        , String __2
    ) {
        Digest2 f = new Digest2();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.digest</code> as a field.
     */
    public static Field<byte[]> digest2(
          Field<byte[]> __1
        , Field<String> __2
    ) {
        Digest2 f = new Digest2();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.encrypt</code>
     */
    public static byte[] encrypt(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        Encrypt f = new Encrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.encrypt</code> as a field.
     */
    public static Field<byte[]> encrypt(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        Encrypt f = new Encrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.encrypt</code> as a field.
     */
    public static Field<byte[]> encrypt(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        Encrypt f = new Encrypt();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.encrypt_iv</code>
     */
    public static byte[] encryptIv(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , byte[] __3
        , String __4
    ) {
        EncryptIv f = new EncryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.encrypt_iv</code> as a field.
     */
    public static Field<byte[]> encryptIv(
          byte[] __1
        , byte[] __2
        , byte[] __3
        , String __4
    ) {
        EncryptIv f = new EncryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Get <code>public.encrypt_iv</code> as a field.
     */
    public static Field<byte[]> encryptIv(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<byte[]> __3
        , Field<String> __4
    ) {
        EncryptIv f = new EncryptIv();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Call <code>public.gen_random_bytes</code>
     */
    public static byte[] genRandomBytes(
          Configuration configuration
        , Integer __1
    ) {
        GenRandomBytes f = new GenRandomBytes();
        f.set__1(__1);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_random_bytes</code> as a field.
     */
    public static Field<byte[]> genRandomBytes(
          Integer __1
    ) {
        GenRandomBytes f = new GenRandomBytes();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Get <code>public.gen_random_bytes</code> as a field.
     */
    public static Field<byte[]> genRandomBytes(
          Field<Integer> __1
    ) {
        GenRandomBytes f = new GenRandomBytes();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Call <code>public.gen_random_uuid</code>
     */
    public static UUID genRandomUuid(
          Configuration configuration
    ) {
        GenRandomUuid f = new GenRandomUuid();

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_random_uuid</code> as a field.
     */
    public static Field<UUID> genRandomUuid() {
        GenRandomUuid f = new GenRandomUuid();

        return f.asField();
    }

    /**
     * Call <code>public.gen_salt</code>
     */
    public static String genSalt1(
          Configuration configuration
        , String __1
    ) {
        GenSalt1 f = new GenSalt1();
        f.set__1(__1);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_salt</code> as a field.
     */
    public static Field<String> genSalt1(
          String __1
    ) {
        GenSalt1 f = new GenSalt1();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Get <code>public.gen_salt</code> as a field.
     */
    public static Field<String> genSalt1(
          Field<String> __1
    ) {
        GenSalt1 f = new GenSalt1();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Call <code>public.gen_salt</code>
     */
    public static String genSalt2(
          Configuration configuration
        , String __1
        , Integer __2
    ) {
        GenSalt2 f = new GenSalt2();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.gen_salt</code> as a field.
     */
    public static Field<String> genSalt2(
          String __1
        , Integer __2
    ) {
        GenSalt2 f = new GenSalt2();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.gen_salt</code> as a field.
     */
    public static Field<String> genSalt2(
          Field<String> __1
        , Field<Integer> __2
    ) {
        GenSalt2 f = new GenSalt2();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.hmac</code>
     */
    public static byte[] hmac1(
          Configuration configuration
        , String __1
        , String __2
        , String __3
    ) {
        Hmac1 f = new Hmac1();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.hmac</code> as a field.
     */
    public static Field<byte[]> hmac1(
          String __1
        , String __2
        , String __3
    ) {
        Hmac1 f = new Hmac1();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.hmac</code> as a field.
     */
    public static Field<byte[]> hmac1(
          Field<String> __1
        , Field<String> __2
        , Field<String> __3
    ) {
        Hmac1 f = new Hmac1();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.hmac</code>
     */
    public static byte[] hmac2(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        Hmac2 f = new Hmac2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.hmac</code> as a field.
     */
    public static Field<byte[]> hmac2(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        Hmac2 f = new Hmac2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.hmac</code> as a field.
     */
    public static Field<byte[]> hmac2(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        Hmac2 f = new Hmac2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_key_id</code>
     */
    public static String pgpKeyId(
          Configuration configuration
        , byte[] __1
    ) {
        PgpKeyId f = new PgpKeyId();
        f.set__1(__1);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_key_id</code> as a field.
     */
    public static Field<String> pgpKeyId(
          byte[] __1
    ) {
        PgpKeyId f = new PgpKeyId();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_key_id</code> as a field.
     */
    public static Field<String> pgpKeyId(
          Field<byte[]> __1
    ) {
        PgpKeyId f = new PgpKeyId();
        f.set__1(__1);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt</code>
     */
    public static String pgpPubDecrypt1(
          Configuration configuration
        , byte[] __1
        , byte[] __2
    ) {
        PgpPubDecrypt1 f = new PgpPubDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt1(
          byte[] __1
        , byte[] __2
    ) {
        PgpPubDecrypt1 f = new PgpPubDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt1(
          Field<byte[]> __1
        , Field<byte[]> __2
    ) {
        PgpPubDecrypt1 f = new PgpPubDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt</code>
     */
    public static String pgpPubDecrypt2(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubDecrypt2 f = new PgpPubDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt2(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubDecrypt2 f = new PgpPubDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt2(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        PgpPubDecrypt2 f = new PgpPubDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt</code>
     */
    public static String pgpPubDecrypt3(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
        , String __4
    ) {
        PgpPubDecrypt3 f = new PgpPubDecrypt3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt3(
          byte[] __1
        , byte[] __2
        , String __3
        , String __4
    ) {
        PgpPubDecrypt3 f = new PgpPubDecrypt3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt</code> as a field.
     */
    public static Field<String> pgpPubDecrypt3(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
        , Field<String> __4
    ) {
        PgpPubDecrypt3 f = new PgpPubDecrypt3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt_bytea</code>
     */
    public static byte[] pgpPubDecryptBytea1(
          Configuration configuration
        , byte[] __1
        , byte[] __2
    ) {
        PgpPubDecryptBytea1 f = new PgpPubDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea1(
          byte[] __1
        , byte[] __2
    ) {
        PgpPubDecryptBytea1 f = new PgpPubDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea1(
          Field<byte[]> __1
        , Field<byte[]> __2
    ) {
        PgpPubDecryptBytea1 f = new PgpPubDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt_bytea</code>
     */
    public static byte[] pgpPubDecryptBytea2(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubDecryptBytea2 f = new PgpPubDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea2(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubDecryptBytea2 f = new PgpPubDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea2(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        PgpPubDecryptBytea2 f = new PgpPubDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_decrypt_bytea</code>
     */
    public static byte[] pgpPubDecryptBytea3(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
        , String __4
    ) {
        PgpPubDecryptBytea3 f = new PgpPubDecryptBytea3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea3(
          byte[] __1
        , byte[] __2
        , String __3
        , String __4
    ) {
        PgpPubDecryptBytea3 f = new PgpPubDecryptBytea3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubDecryptBytea3(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
        , Field<String> __4
    ) {
        PgpPubDecryptBytea3 f = new PgpPubDecryptBytea3();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);
        f.set__4(__4);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_encrypt</code>
     */
    public static byte[] pgpPubEncrypt1(
          Configuration configuration
        , String __1
        , byte[] __2
    ) {
        PgpPubEncrypt1 f = new PgpPubEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpPubEncrypt1(
          String __1
        , byte[] __2
    ) {
        PgpPubEncrypt1 f = new PgpPubEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpPubEncrypt1(
          Field<String> __1
        , Field<byte[]> __2
    ) {
        PgpPubEncrypt1 f = new PgpPubEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_encrypt</code>
     */
    public static byte[] pgpPubEncrypt2(
          Configuration configuration
        , String __1
        , byte[] __2
        , String __3
    ) {
        PgpPubEncrypt2 f = new PgpPubEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpPubEncrypt2(
          String __1
        , byte[] __2
        , String __3
    ) {
        PgpPubEncrypt2 f = new PgpPubEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpPubEncrypt2(
          Field<String> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        PgpPubEncrypt2 f = new PgpPubEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_encrypt_bytea</code>
     */
    public static byte[] pgpPubEncryptBytea1(
          Configuration configuration
        , byte[] __1
        , byte[] __2
    ) {
        PgpPubEncryptBytea1 f = new PgpPubEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubEncryptBytea1(
          byte[] __1
        , byte[] __2
    ) {
        PgpPubEncryptBytea1 f = new PgpPubEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubEncryptBytea1(
          Field<byte[]> __1
        , Field<byte[]> __2
    ) {
        PgpPubEncryptBytea1 f = new PgpPubEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_pub_encrypt_bytea</code>
     */
    public static byte[] pgpPubEncryptBytea2(
          Configuration configuration
        , byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubEncryptBytea2 f = new PgpPubEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_pub_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubEncryptBytea2(
          byte[] __1
        , byte[] __2
        , String __3
    ) {
        PgpPubEncryptBytea2 f = new PgpPubEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_pub_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpPubEncryptBytea2(
          Field<byte[]> __1
        , Field<byte[]> __2
        , Field<String> __3
    ) {
        PgpPubEncryptBytea2 f = new PgpPubEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_decrypt</code>
     */
    public static String pgpSymDecrypt1(
          Configuration configuration
        , byte[] __1
        , String __2
    ) {
        PgpSymDecrypt1 f = new PgpSymDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_decrypt</code> as a field.
     */
    public static Field<String> pgpSymDecrypt1(
          byte[] __1
        , String __2
    ) {
        PgpSymDecrypt1 f = new PgpSymDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_decrypt</code> as a field.
     */
    public static Field<String> pgpSymDecrypt1(
          Field<byte[]> __1
        , Field<String> __2
    ) {
        PgpSymDecrypt1 f = new PgpSymDecrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_decrypt</code>
     */
    public static String pgpSymDecrypt2(
          Configuration configuration
        , byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymDecrypt2 f = new PgpSymDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_decrypt</code> as a field.
     */
    public static Field<String> pgpSymDecrypt2(
          byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymDecrypt2 f = new PgpSymDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_decrypt</code> as a field.
     */
    public static Field<String> pgpSymDecrypt2(
          Field<byte[]> __1
        , Field<String> __2
        , Field<String> __3
    ) {
        PgpSymDecrypt2 f = new PgpSymDecrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_decrypt_bytea</code>
     */
    public static byte[] pgpSymDecryptBytea1(
          Configuration configuration
        , byte[] __1
        , String __2
    ) {
        PgpSymDecryptBytea1 f = new PgpSymDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymDecryptBytea1(
          byte[] __1
        , String __2
    ) {
        PgpSymDecryptBytea1 f = new PgpSymDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymDecryptBytea1(
          Field<byte[]> __1
        , Field<String> __2
    ) {
        PgpSymDecryptBytea1 f = new PgpSymDecryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_decrypt_bytea</code>
     */
    public static byte[] pgpSymDecryptBytea2(
          Configuration configuration
        , byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymDecryptBytea2 f = new PgpSymDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymDecryptBytea2(
          byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymDecryptBytea2 f = new PgpSymDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_decrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymDecryptBytea2(
          Field<byte[]> __1
        , Field<String> __2
        , Field<String> __3
    ) {
        PgpSymDecryptBytea2 f = new PgpSymDecryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_encrypt</code>
     */
    public static byte[] pgpSymEncrypt1(
          Configuration configuration
        , String __1
        , String __2
    ) {
        PgpSymEncrypt1 f = new PgpSymEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpSymEncrypt1(
          String __1
        , String __2
    ) {
        PgpSymEncrypt1 f = new PgpSymEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpSymEncrypt1(
          Field<String> __1
        , Field<String> __2
    ) {
        PgpSymEncrypt1 f = new PgpSymEncrypt1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_encrypt</code>
     */
    public static byte[] pgpSymEncrypt2(
          Configuration configuration
        , String __1
        , String __2
        , String __3
    ) {
        PgpSymEncrypt2 f = new PgpSymEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpSymEncrypt2(
          String __1
        , String __2
        , String __3
    ) {
        PgpSymEncrypt2 f = new PgpSymEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_encrypt</code> as a field.
     */
    public static Field<byte[]> pgpSymEncrypt2(
          Field<String> __1
        , Field<String> __2
        , Field<String> __3
    ) {
        PgpSymEncrypt2 f = new PgpSymEncrypt2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_encrypt_bytea</code>
     */
    public static byte[] pgpSymEncryptBytea1(
          Configuration configuration
        , byte[] __1
        , String __2
    ) {
        PgpSymEncryptBytea1 f = new PgpSymEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymEncryptBytea1(
          byte[] __1
        , String __2
    ) {
        PgpSymEncryptBytea1 f = new PgpSymEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymEncryptBytea1(
          Field<byte[]> __1
        , Field<String> __2
    ) {
        PgpSymEncryptBytea1 f = new PgpSymEncryptBytea1();
        f.set__1(__1);
        f.set__2(__2);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_sym_encrypt_bytea</code>
     */
    public static byte[] pgpSymEncryptBytea2(
          Configuration configuration
        , byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymEncryptBytea2 f = new PgpSymEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        f.execute(configuration);
        return f.getReturnValue();
    }

    /**
     * Get <code>public.pgp_sym_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymEncryptBytea2(
          byte[] __1
        , String __2
        , String __3
    ) {
        PgpSymEncryptBytea2 f = new PgpSymEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Get <code>public.pgp_sym_encrypt_bytea</code> as a field.
     */
    public static Field<byte[]> pgpSymEncryptBytea2(
          Field<byte[]> __1
        , Field<String> __2
        , Field<String> __3
    ) {
        PgpSymEncryptBytea2 f = new PgpSymEncryptBytea2();
        f.set__1(__1);
        f.set__2(__2);
        f.set__3(__3);

        return f.asField();
    }

    /**
     * Call <code>public.pgp_armor_headers</code>.
     */
    public static Result<PgpArmorHeadersRecord> pgpArmorHeaders(
          Configuration configuration
        , String __1
    ) {
        return configuration.dsl().selectFrom(demo.delivery_project.jooq.tables.PgpArmorHeaders.PGP_ARMOR_HEADERS.call(
              __1
        )).fetch();
    }

    /**
     * Get <code>public.pgp_armor_headers</code> as a table.
     */
    public static PgpArmorHeaders pgpArmorHeaders(
          String __1
    ) {
        return demo.delivery_project.jooq.tables.PgpArmorHeaders.PGP_ARMOR_HEADERS.call(
            __1
        );
    }

    /**
     * Get <code>public.pgp_armor_headers</code> as a table.
     */
    public static PgpArmorHeaders pgpArmorHeaders(
          Field<String> __1
    ) {
        return demo.delivery_project.jooq.tables.PgpArmorHeaders.PGP_ARMOR_HEADERS.call(
            __1
        );
    }
}