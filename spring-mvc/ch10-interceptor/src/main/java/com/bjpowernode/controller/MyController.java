package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MyController {



    @RequestMapping(value ="/some.do")
    public ModelAndView doSome(HttpSession session,String name, Integer age)  {
        System.out.println("执行了MyController的doSome方法");

        //添加一个临时数据
        session.setAttribute("attr", "在controller中增加的临时数据");

        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("myname", name);
        mv.addObject("myage",age);

        mv.setViewName("show");

        //返回结果
        return mv;

    }



}
