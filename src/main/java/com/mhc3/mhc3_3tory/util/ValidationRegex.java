package com.mhc3.mhc3_3tory.util;

import java.util.regex.Pattern;

public class ValidationRegex {

    public static Boolean isValidPhone(String phone){
        String pattern = "^\\d{3}-\\d{3,4}-\\d{4}$";
        return Pattern.matches(pattern, phone);
    }

    public static Boolean isValidEmail(String email){
        String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
        return Pattern.matches(pattern, email);
    }

}