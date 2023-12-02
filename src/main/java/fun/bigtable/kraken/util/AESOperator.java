package fun.bigtable.kraken.util;


import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Properties;

/**
 */
public class AESOperator {

    private static final Properties PROPERTIES = PropertiesUtil.readProperties("properties/config-base.properties");

    /*
     * 加密用的Key 可以用26个字母和数字组成 此处使用AES-128-CBC加密模式，key需要为16位。
     */
    private static final String KEY = PROPERTIES.getProperty("aesKey");
    private static final  String VECTOR = PROPERTIES.getProperty("aesVector");
    private static AESOperator instance = null;

    private AESOperator() {

    }



    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String encrypt(String content) throws Exception {
        return encrypt(content, KEY, VECTOR);
    }
    /**
     * 加密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String encrypt(String content,String key) throws Exception {
        return encrypt(content, key, VECTOR);
    }

    /**
     * 加密
     *
     * @param content
     * @param key
     * @param vector
     * @return
     * @throws Exception
     */
    public  static String encrypt(String content, String key, String vector) throws Exception {
        if (key == null) {
            return null;
        }
        if (key.length() != 16) {
            return null;
        }
        SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        IvParameterSpec iv = new IvParameterSpec(vector.getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);
        byte[] encrypted = cipher.doFinal(content.getBytes("UTF-8"));
        return new BASE64Encoder().encode(encrypted);// 此处使用BASE64做转码。
    }

    /**
     * 解密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String decrypt(String content) throws Exception {
        return decrypt(content, KEY, VECTOR);
    }
    /**
     * 解密
     *
     * @param content
     * @return
     * @throws Exception
     */
    public static String decrypt(String content,String key) throws Exception {
        return decrypt(content, key, VECTOR);
    }
    /**
     * 解密
     *
     * @param content
     * @param key
     * @param vector
     * @return
     * @throws Exception
     */
    public static String decrypt(String content, String key, String vector) throws Exception {
        try {
            if (key == null) {
                return null;
            }
            if (key.length() != 16) {
                return null;
            }
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
            IvParameterSpec iv = new IvParameterSpec(vector.getBytes());
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(content);// 先用base64解密
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "UTF-8");
            return originalString;
        } catch (Exception ex) {
            return null;
        }
    }
}