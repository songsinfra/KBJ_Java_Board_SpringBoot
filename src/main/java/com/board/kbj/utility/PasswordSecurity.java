package com.board.kbj.utility;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class PasswordSecurity {

	/**
     * SALT를 얻어온다.
     * @return
     */
    public static String generateSalt() {
    	
    	Random random = new Random();
        byte[] salt = new byte[8];
        random.nextBytes(salt);
         
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < salt.length; i++) {
            sb.append(String.format("%02x",salt[i])); // byte 값을 Hex 값으로 바꾸기.
        }
        return sb.toString();
    }
	
	/**
     * SHA-256 암호화 함
     * @param password 원본
     * @param salt(String) SALT 값
     * @return
     */
    public static String getEncrypt(String password, String salt) {
        return getEncrypt(password, salt.getBytes());
    }
     
    /**
     * SHA-256 암호화 함
     * @param password 원본
     * @param salt(byte[]) SALT 값
     * @return
     */
    private static String getEncrypt(String password, byte[] salt) {
         
        String result = "";
         
        byte[] a = password.getBytes();
        byte[] bytes = new byte[a.length + salt.length];
         
        System.arraycopy(a, 0, bytes, 0, a.length);
        System.arraycopy(salt, 0, bytes, a.length, salt.length);
         
        try {
            // 암호화 방식 지정 메소드, SHA-256 말고도 있음
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
             
            byte[] byteData = md.digest();
             
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
            }
            result = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return result;
    }
     
}
