package com.note.util;

import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * <p></p>
 * <p>
 * <PRE>
 * <BR>	修改记录
 * <BR>-----------------------------------------------
 * <BR>	修改日期			修改人			修改内容
 * </PRE>
 *
 * @author lvxz5
 * @version 1.0
 * @date 2017/11/21
 * @since 1.0
 */
public class PasswordUtil {

    private PasswordUtil() {
    }

    /**
     * 密码摘要生成
     * @param password
     * @param salt
     * @return
     */
    public static String encrypt(String password,String salt){
        String strMD5 = password;
        String md5 = new Md5Hash(strMD5, salt).toString();
        return md5;
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtil.encrypt("123","note"));;
    }

}
