package com.bjpowernode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Controller： 创建控制器（处理器）对象
 *    控制器：叫做后端控制器（back controller）,自定义的类处理请求的。
 *    位置： 在类的上面， 表示创建此类的对象， 对象放在springmvc的容器中。
 *
 * @RequestMapping
 *   属性 value ：表示所有请求地址的公共前缀， 相当于是模块名称。
 *   位置 在类的上面
 */
@Controller
public class MyController {

    /**
     * @RequestMapping: 请求映射
     *          属性： value  请求中的uri地址， 唯一值， 以"/"开头。
     *                method 请求的方式， 使用RequestMethod类的枚举值。
     *                       例如get方式， RequestMethod.GET
     *
     *          位置： 1.在方法的上面（必须的） 2.在类定义的上面（可选）
     *          作用：把指定的请求，交给指定的方法处理 ，等同于url-pattern
     */

    //请求方式不一样， 错误码是405 ， 请求方式不支持
    //指定some.do使用get请求方式
    @RequestMapping(value ="/some.do", method = RequestMethod.GET)
    public ModelAndView doSome(){
        System.out.println("执行了MyController的doSome方法");
        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("fun", "执行了doSome方法");
        mv.setViewName("show");


        //返回结果
        return mv;

    }

    //指定other.do使用 post请求方式
    @RequestMapping(value ="/other.do",method = RequestMethod.POST)
    public ModelAndView doOther(){
        System.out.println("执行了MyController的doOther方法");

        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了other.do请求");
        mv.addObject("fun", "执行了doOther方法");
        mv.setViewName("other");
        //返回结果
        return mv;

    }

    //不指定method属性， 请求方式没有限制
    @RequestMapping(value ="/first.do")
    public ModelAndView doFirst(HttpServletRequest request, HttpServletResponse response,
                                HttpSession session){
        System.out.println("执行了MyController的doFirst方法");

        String name=request.getParameter("name");

        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了other.do请求,name="+name);
        mv.addObject("fun", "执行了doFirst方法");
        mv.setViewName("other");
        //返回结果
        return mv;

    }
}
