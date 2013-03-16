package com.netcracker.libra.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MorrDeck
 */
@Controller
public class ReportController {

    /**
     * Генерация отчета: График записи студентов
     *
     * @return
     */
    @RequestMapping(value = "/showStudentRecords", method = RequestMethod.GET)
    public ModelAndView StudRecReport() {
        ModelAndView mav = new ModelAndView("StudentRecordsView");
        String data = "";
        int val[] = {15, 24, 11, 18, 10};
        String lab[] = {"2012-04-16", "2012-04-17", "2012-04-18", "2012-04-19", "2012-04-20"};// y/m/d
        data = "[";
        for (int i = 0; i < val.length; i++) {
            data += "['" + lab[i] + "'," + val[i] + "],";
        }
        data = data.substring(1, data.length() - 1);

        mav.addObject("data", data);
        return mav;
    }

    /**
     * Генерация отчета: зарегистрировались/пришли
     *
     * @return
     */
    @RequestMapping(value = "/showRegReport", method = RequestMethod.GET)
    public ModelAndView RegReport() {
        ModelAndView mav = new ModelAndView("RegReportView");
        String data = "['Зарегестрировались',78],['Пришли',52]";
        mav.addObject("data", data);
        return mav;
    }

    /**
     * Генерация отчета: эффективность рекламы
     *
     * @return
     */
    @RequestMapping(value = "/showAdvertise", method = RequestMethod.GET)
    public ModelAndView AdvertiseView() {
        ModelAndView mav = new ModelAndView("AdvertiseActivity");

        int val[] = {15, 11, 24, 10, 18};
        String lab[] = {"Друг привел", "Флаер", "На стенде в УЗ", "Телереклама", "Другое"};
        String data = "[";
        for (int i = 0; i < lab.length; i++) {
            data += "['" + lab[i] + "'," + val[i] + "],";
        }
        data = data.substring(1, data.length() - 1);
        mav.addObject("data", data);

        return mav;
    }

    /**
     * Генерация отчета: все студенты пришли/не пришли
     *
     * @return
     */
    @RequestMapping(value = "/showStudentActivity", method = RequestMethod.GET)
    public ModelAndView StudentsActivity() {
        ModelAndView mav = new ModelAndView("StudentsActivityView");
        String data = "['Записалось', 74],['Пришло', 52]";
        mav.addObject("data", data);
        return mav;
    }
}
