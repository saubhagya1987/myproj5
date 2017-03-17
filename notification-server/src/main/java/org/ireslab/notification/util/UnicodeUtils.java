package org.ireslab.notification.util;

import java.io.UnsupportedEncodingException;


public class UnicodeUtils {

  public static String text2Utf16BE(String text) throws UnsupportedEncodingException {

    byte[] byteArry = text.getBytes("UTF-16BE");
    StringBuilder builder = new StringBuilder();
    for (final byte b : byteArry) {
      String s = String.format("%1$02X", b);
      builder.append(s);
    }
    return builder.toString();
  }

}
