package com.example.demo.utils;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Password {
    public Password() {
    }

    public Boolean isPasswordStrong (String password){


        int n = password.length();
        boolean hasLower = false, hasUpper = false,
                hasDigit = false, specialChar = false;
        Set<Character> set = new HashSet<Character>(
                Arrays.asList('!', '@', '#', '$', '%', '^', '&',
                        '*', '(', ')', '-', '+'));
        for (char i : password.toCharArray())
        {
            if (Character.isLowerCase(i))
                hasLower = true;
            if (Character.isUpperCase(i))
                hasUpper = true;
            if (Character.isDigit(i))
                hasDigit = true;
            if (set.contains(i))
                specialChar = true;
        }

        System.out.print("Strength of password:- ");
        if (hasDigit && hasLower && hasUpper && specialChar && (n >= 8))
            return true;
        else
        return false;

    }

    public String passwordEncrypt(String password, Integer age) {


        StringBuilder passwordEncrypt = new StringBuilder();
        passwordEncrypt.append(password);
        passwordEncrypt.reverse();

//        System.out.println("eeeee"+passwordEncrypt);
        return "**"+passwordEncrypt.toString()+age+"**";
    }
}
