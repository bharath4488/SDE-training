package com.basics.amazon.learnJava8;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Base64EncodeDecode {
    public static void main(String[] args) {
        /*
        provides 3 encoding types
            1. Basic - for encoding basic strings
            2. URL - for encoding urls & filename safe. ex - replaces space " " with %20% as in urls
            3. MIME - for text encoding binary data. ex - image, text, file that is transfered on smtp & http protocols.
        While it's technically possible to use normal encoding for transmitting binary data over HTTP protocols,
        MIME encoding, particularly Base64 MIME encoding, is more suitable and commonly used due to its compatibility,
        ease of use, and widespread adoption. It ensures reliable transmission of binary data over text-based
        protocols without corruption or loss of information.
         */

        String data = "This is a test string.";
        String basicEncodedString = encodeString(data);
        String basicDecodedString = decodeString(basicEncodedString);
        System.out.println(basicEncodedString);
        System.out.println(basicDecodedString);

        String Url = "https://stackoverflow.com/how to map entity to table in spring-data-jdbc";

        // url encoder replaces special charaters with %numbers like / is %2f
        String urlEncodedString2 = URLEncoder.encode(Url, StandardCharsets.UTF_8);
        String urlDecodedString2 = URLDecoder.decode(urlEncodedString2, StandardCharsets.UTF_8);

        System.out.println(urlEncodedString2);
        System.out.println(urlDecodedString2);

        String urlEncodedString = encodeUrl(urlDecodedString2);
        String urlDecodedString = decodeUrl(urlEncodedString);

        System.out.println(urlEncodedString);
        System.out.println(urlDecodedString);

    }
    public static String encodeString(String str) {
        return Base64.getEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }
    public static String decodeString(String str) {
        return new String(Base64.getDecoder().decode(str), StandardCharsets.UTF_8);
    }
    public static String encodeUrl(String str) {
        return Base64.getUrlEncoder().encodeToString(str.getBytes(StandardCharsets.UTF_8));
    }
    public static String decodeUrl(String str) {
        return new String(Base64.getUrlDecoder().decode(str), StandardCharsets.UTF_8);
    }
}
