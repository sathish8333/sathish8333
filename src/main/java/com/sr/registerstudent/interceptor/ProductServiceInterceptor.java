package com.sr.registerstudent.interceptor;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sr.registerstudent.entity.Student;
import com.sr.registerstudent.filter.validatateRequestFilter;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductServiceInterceptor implements HandlerInterceptor {
    public  static final Logger logger = LoggerFactory.getLogger(ProductServiceInterceptor.class);

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<String> duplicateKeys = new ArrayList<>();
        logger.info("inside ProductServiceInterceptor class preHandle method");

        /*if ("POST".equalsIgnoreCase(request.getMethod())) {
            String test23 = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            String jsonString = test23.substring(2, test23.length() - 2);
            JSONObject obj = new JSONObject();
            List<String> pair = Arrays.asList(jsonString.split(","));
            for (String values : pair) {
                String[] value = values.trim().split(":");
                if (!obj.has(value[0])) {
                    if (value.length>2){
                    obj.put(value[0], value[1]);
                    }else {
                        obj.put(value[0], "null");
                    }
                } else {
                    duplicateKeys.add(value[0]);
                }
            }

            System.out.println("inside interceptor");
        }*/
        return true;
    }

    public void getDuplicate(String jsonString) {
        //String jsonString = jsonIn.substring(2, jsonIn.length() - 2);
       /*
               ObjectMapper mapper = new ObjectMapper();
        mapper.enable(JsonParser.Feature.STRICT_DUPLICATE_DETECTION);
        Student str;
        String test;
       for (String values : jsonString.split("\",\"")) {
                String[] keyValue = values.split("\":\"");
                String key = keyValue[0];
                String value = "";
                if (keyValue.length > 1) value = keyValue[1];

                if (!obj.has(key)) {
                    obj.put(key, value);
                } else {
                    Object Oold = obj.get(key);
                    ArrayList<String> newlist = new ArrayList<String>();


                }
            }

        try {
            request.getMethod();
            str = mapper.readValue(request.getReader(), Student.class);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }*/

    }

    @Override
    public void postHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        logger.info("inside ProductServiceInterceptor class postHandle method");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        logger.info("inside ProductServiceInterceptor class afterCompletion method");
    }
}
