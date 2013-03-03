/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcracker.libra.service;

import java.text.SimpleDateFormat;

/**
 *
 * @author Admin
 */
public class TimeService {
    
    public String toDateAndTime(java.util.Date date) {
        SimpleDateFormat ft = new SimpleDateFormat ("dd.MM.yyyy  H:mm");
        String time = ft.format(date);
        return time;
    }
    
}
