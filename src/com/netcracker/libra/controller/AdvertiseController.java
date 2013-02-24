package com.netcracker.libra.controller;

import com.netcracker.libra.util.mail.data;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author MorrDeck
 */
@Controller
public class AdvertiseController {
        @RequestMapping(value = "/showAdvertise", method = RequestMethod.GET)
	   public ModelAndView AdvertiseView() {
                ModelAndView mav = new ModelAndView("AdvertiseActivity");
                
                int val[] = {10,20,30,40,50};
                String lab[] = {"1","2","3","4","5"};
                String data = "[";
                for (int i = 0; i < lab.length; i++){
                    data += "['"+lab[i]+"',"+val[i]+"],";
                }
                data = data.substring(1, data.length()-1);
                System.out.println(data);
                mav.addObject("data", data);
	      return mav;
	   }
}
