/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utiles;

import java.security.MessageDigest;

/**
 *
 * @author Alekhius
 */
public class Encript {
    public static String md5(String clear)throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] b = md.digest(clear.getBytes());
        
        int size = b.length;
        StringBuffer h = new StringBuffer(size);
        for (int i = 0; i<size; i++){
            int u = b[i] & 255;
            if(u < 16){
                h.append("0"+ Integer.toHexString(u));                
            }else {
                h.append(Integer.toHexString(u));
            }
        }
       //System.out.println(h.toString());
        return h.toString();
    }
}
