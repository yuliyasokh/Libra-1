package com.netcracker.libra.service;

import com.netcracker.libra.model.User;
import java.util.List;

/**
 * Сортировка списка объектов.
 * Т.е. сортировка служащих по должности, ID, имени, фамилии, эл.почте, паролю
 * от меньшего к большему или в алфавитном порядке и наоборот.
 * 
 * @author Alexander Lebed
 */
public class SortService {
    
    /**
     * Сортировка служащих по должности в порядке HR, Tech, Admin
     * @param list список служащих
     */
    public static void orderByRoleASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if(list.get(i).getRoleId() > list.get(i+1).getRoleId()) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);
                }      
            }
        }
    }
    
    /**
     * Сортировка служащих по должности в порядке Admin, Tech, HR
     * @param list список служащих
     */
    public static void orderByRoleDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getRoleId() < list.get(i+1).getRoleId()) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);    
                }
            }
        }
    }

    /**
     * Сортировка служащих по ID от меньшего к большому
     * @param list список служащих
     */
    public static void orderByIdASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if(list.get(i).getUserId() > list.get(i+1).getUserId()) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);
                }      
            }
        }
    }   
    
    /**
     * Сортировка служащих по ID  от большого к меньшому
     * @param list список служащих
     */
    public static void orderByIdDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getUserId() < list.get(i+1).getUserId()) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);    
                }
            }
        }
    }

    /**
     * Сортировка служащих по имени в алфавитном порядке (a-z, а-я)
     * @param list список служащих
     */
    public static void orderByFirstNameASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getFirstName().compareToIgnoreCase(list.get(i+1).getFirstName()) > 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по имени в обратном алфавитном порядке (я-а, z-a)
     * @param list список служащих
     */
    public static void orderByFirstNameDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getFirstName().compareToIgnoreCase(list.get(i+1).getFirstName()) < 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по фамилии в алфавитном порядке (a-z, а-я)
     * @param list список служащих
     */
    public static void orderByLastNameASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getLastName().compareToIgnoreCase(list.get(i+1).getLastName()) > 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }

    /**
     * Сортировка служащих по фамилии в обратном алфавитном порядке (я-а, z-a)
     * @param list список служащих
     */
    public static void orderByLastNameDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getLastName().compareToIgnoreCase(list.get(i+1).getLastName()) < 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по email в алфавитном порядке (a-z)
     * @param list список служащих
     */
    public static void orderByEmailASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getEmail().compareToIgnoreCase(list.get(i+1).getEmail()) > 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по email в обратном алфавитном порядке (z-a)
     * @param list список служащих
     */
    public static void orderByEmailDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getEmail().compareToIgnoreCase(list.get(i+1).getEmail()) < 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по паролю в алфавитном порядке (a-z, а-я)
     * @param list список служащих
     */
    public static void orderByPasswordASC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getPassword().compareToIgnoreCase(list.get(i+1).getPassword()) > 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
    
    /**
     * Сортировка служащих по паролю в обратном алфавитном порядке (я-а, z-a)
     * @param list список служащих
     */
    public static void orderByPasswordDESC(List <User> list) {
        User user;
        for(int x=0; x < list.size(); x++) {
            for(int i=0; i < list.size() - x - 1; i++) {
                if (list.get(i).getPassword().compareToIgnoreCase(list.get(i+1).getPassword()) < 0) {
                    user = list.get(i);
                    list.set(i,list.get(i+1) );
                    list.set(i+1, user);     
                }
            }
        }
    }
 
}
