package com.gulecugurcan.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Calendar;

public class DayOfWeekInterceptor extends HandlerInterceptorAdapter {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        Calendar calendar=Calendar.getInstance();
        int dayOfWeek=calendar.get(calendar.DAY_OF_WEEK);
        if (dayOfWeek==7) {  //Yani bugün Pazar günü ise sistem çalışmayacak.
            //1 Pazar
            //2 Pazartesi
            //3 Salı
            //4 Çarşamba
            //.......

            response.getWriter().write("Web sitemiz Pazar gunleri hizmet vermemektedir. Haftanin diger gunleri " +
                    "tekrar deneyebilirsiniz. Ilginize tesekkur ederiz.");

            return false;

        }
        return true;



    }

}
