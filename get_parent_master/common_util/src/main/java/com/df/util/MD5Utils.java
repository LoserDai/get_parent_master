package com.df.util;

import java.security.MessageDigest;

/**
 * @Author feng.dai
 * @package com.df.util
 * @project get_parent_master
 * @Date 2022/9/19 9:19
 */
public class MD5Utils {
    public static String digest(String source) {
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");

            byte[] temp = digest.digest(source.getBytes());

            StringBuilder builder = new StringBuilder("");

            for (byte b : temp) {
                String s = Integer.toHexString(0xFF & b);
                if (s.length() == 1) {
                    s = "0" + s;
                }
                builder.append(s);
            }

            return builder.toString();
        } catch (Exception e) {
            return null;
        }
    }
}
