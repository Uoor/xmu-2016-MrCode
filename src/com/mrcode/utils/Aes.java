package com.mrcode.utils;

import java.util.Random;
import java.util.UUID;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Aes对称密钥加密
 * @author 羽中
 *
 */
public class Aes {
	public static final String ZFMPWD="FoodProject2015_";
	public static final String iv="FoodProject2015%";
	public static String encrypt(String data){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            int blockSize = cipher.getBlockSize();

            byte[] dataBytes = data.getBytes();
            int plaintextLength = dataBytes.length;
            if (plaintextLength % blockSize != 0) {
                plaintextLength = plaintextLength + (blockSize - (plaintextLength % blockSize));
            }

            byte[] plaintext = new byte[plaintextLength];
            System.arraycopy(dataBytes, 0, plaintext, 0, dataBytes.length);
             
            SecretKeySpec keyspec = new SecretKeySpec(ZFMPWD.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());

            cipher.init(Cipher.ENCRYPT_MODE, keyspec, ivspec);
            byte[] encrypted = cipher.doFinal(plaintext);

            return new BASE64Encoder().encode(encrypted);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String desEncrypt(String data){
        try
        {
       	 if(data==null||data.equals("")){
       		 return "";
       	 }
       	 data=data.trim();
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(data);
             
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            SecretKeySpec keyspec = new SecretKeySpec(ZFMPWD.getBytes(), "AES");
            IvParameterSpec ivspec = new IvParameterSpec(iv.getBytes());
             
            cipher.init(Cipher.DECRYPT_MODE, keyspec, ivspec);

            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original);
            return originalString.trim();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    } 
    public static void main(String[] args){
    	/*for (int i = 0; i < 10; i++) {*/
    		//System.out.println(Integer.parseInt(UUID.randomUUID().toString().replaceAll("[^0-9]", "9")));
		//}
    	Random random = new Random();
    	int a = random.nextInt();
    	System.out.println(a);
    	//System.out.println(encrypt("做一个测试"));
    	/*System.out.println(desEncrypt1(encrypt1("做一个测试")));
    	System.out.println(desEncrypt2(encrypt2("做一个测试")));*/
    	//System.out.println(desEncrypt("5DF44E2D5E02"));
    }
}
