package com.netcracker.libra.service;

/**
 * Checks the input values by administrator ​​to the possibility of their absence or redundancy
 * (for the database table Users)
 * @author Alexander Lebed
 */
public class LengthService {
    
    private final static int NAME_LENGTH = 20;
    private final static int AUTH_LENGTH = 40;    
    private final static String FIRSTNAME_TOO_LONG = "Длина имени не должна превышать "+ NAME_LENGTH +" символов<br/>";
    private final static String LASTNAME_TOO_LONG = "Длина фамилии не должна превышать "+ NAME_LENGTH +" символов<br/>";
    private final static String EMAIL_TOO_LONG = "Длина электронной почты не должна превышать "+ AUTH_LENGTH +" символов<br/>";
    private final static String PASSWORD_TOO_LONG = "Длина пароля не должна превышать "+ AUTH_LENGTH +" символов<br/>";
    private final static String OK = "";
    
    /**
     * Checks the length of the first name
     * If the length satisfies the database - returns an empty string
     */
    public static String checkFirstNameLength(String firstName) {
        int length = firstName.length();
        return (length > NAME_LENGTH) ? FIRSTNAME_TOO_LONG :
                (length == 0) ? "Пожалуйста, введите имя<br/>" : OK;
    }
    
    /**
     * Checks the length of the last name
     * If the length satisfies the database - returns an empty string
     */
    public static String checkLastNameLength(String lastName) {
        int length = lastName.length();
        return (length > NAME_LENGTH) ? LASTNAME_TOO_LONG :
                (length == 0) ? "Пожалуйста, введите фамилию<br/>" : OK;
    }
    
    /**
     * Checks the length of the email
     * If the length satisfies the database - returns an empty string
     */
    public static String checkEmailLength(String email) {
        int length = email.length();
        return (length > AUTH_LENGTH) ? EMAIL_TOO_LONG :
                (length == 0) ? "Пожалуйста, введите электронную почту<br/>" : OK;
    }
    
    /**
     * Checks the length of the password
     * If the length satisfies the database - returns an empty string
     */
    public static String checkPasswordLength(String password) {
        int length = password.length();
        return (length > AUTH_LENGTH) ? PASSWORD_TOO_LONG :
                (length == 0) ? "Пожалуйста, введите пароль<br/>" : OK;
    }
    
}
