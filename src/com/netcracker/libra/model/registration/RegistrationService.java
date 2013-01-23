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
        Pattern p = Pattern.compile("[a-zA-Z]{1}[a-zA-Z\\d\\u002E\\u005F]+@([a-zA-Z]+\\u002E){1,2}((net)|(com)|(org))");
        Matcher m = p.matcher(email);
        boolean res = m.matches();
        return res;
    }
    
    public static boolean checkPassword(String password){
        Pattern p = Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
//  (			# Начало группы
//  (?=.*\d)		#   должен содержать хотя бы одну цифру
//  (?=.*[a-z])	#   должен содержать хотябы одну букву в нижнем регистре
//  (?=.*[A-Z])	#   должен содержать хотябы одну букву в верхнем регистре
//  (?=.*[@#$%])	#   должен содержать один специальный символ из "@#$%"
//  .		        #     любое совпадение с предыдущими условиями  
//  {6,20}	        #     длина от 6 до 20 символов
//   )			# Конец группы
        Matcher m = p.matcher(password);
        boolean res = m.matches();
        return res;
    }

}
