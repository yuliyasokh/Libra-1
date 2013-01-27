package com.netcracker.libra.model.registration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author MorrDeck
 */
public class RegistrationService {
    public static boolean checkName(String name){
        Pattern p = Pattern.compile("[a-zA-Zа-яА-Я,-]*");
        Matcher m = p.matcher(name);
        boolean res = m.matches();
        return res;
    }
    
    public static boolean checkSurname(String surname){
        Pattern p = Pattern.compile("[a-zA-Zа-яА-Я,-]*");
        Matcher m = p.matcher(surname);
        boolean res = m.matches();
        return res;
    }
    
    public static boolean checkEmail(String email){
        Pattern p = Pattern.compile("(\\s+[a-z][a-z0-9._%-]+@[a-z0-9._%-]+\\.[a-z]{2,4})|(^[a-z][a-z0-9._%-]+@[a-z0-9._%-]+\\.[a-z]{2,4})");
        Matcher m = p.matcher(email);
        boolean res = m.matches();
        return res;
    }
    
    public static boolean checkPassword(String password){
        Pattern p = Pattern.compile("([_]|[-]|[a-z]|[A-Z]|\\d){6,25}");
        Matcher m = p.matcher(password);
        boolean res = m.matches();
        return res;
    }

}
