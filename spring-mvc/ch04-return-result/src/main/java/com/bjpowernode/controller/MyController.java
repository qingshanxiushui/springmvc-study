package com.bjpowernode.controller;

import com.bjpowernode.vo.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MyController {

    /**
     * 控制器方法返回String，表示逻辑名称。 需要项目中配置视图解析器
     */
    @RequestMapping(value ="/return-string-view.do")
    public String doReturnStringView1(HttpServletRequest request,String name, Integer age) {
        System.out.println("执行了MyController的doReturnStringView1方法name=" + name+",age="+age);
        //处理数据，
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        //返回结果,forward,转发到show.jsp
        return "show";

    }

    /**
     * 控制器方法返回String，表示完整视图路径。 项目中不能配置视图解析器
     */
    @RequestMapping(value ="/return-string-view2.do")
    public String doReturnStringView2(HttpServletRequest request,String name, Integer age) {
        System.out.println("执行了MyController的doReturnStringView2方法name=" + name+",age="+age);
        //处理数据，
        request.setAttribute("myname", name);
        request.setAttribute("myage", age);
        //返回结果,forward,转发到show.jsp
        //使用视图解析器  /WEB-INF/view/WEB-INF/view/show.jsp.jsp
        return "/WEB-INF/view/show.jsp";

    }

    /**
     * 控制器方法返回是void ，响应ajax请求。 使用HttpServletResponse输出数据
     */
    @RequestMapping("/return-void-ajax.do")
    public void returnVoidAjax(HttpServletResponse response,String name,Integer age) throws IOException {
        System.out.println("处理void返回类型， name="+name+",age="+age);
        //调用service得到结果对象
        Student  student = new Student();
        student.setName(name+"同学");
        student.setAge(age);

        //把对象转为json
        ObjectMapper om  = new ObjectMapper();
        String json  = om.writeValueAsString(student);
        System.out.println("服务器端对象转为的json==="+json);

        //输出json，响应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }


    @RequestMapping("/return-void-ajax1.do")
    public void returnVoidAjax1(HttpServletResponse response,String name,Integer age) throws IOException {
        System.out.println("处理void返回类型， name="+name+",age="+age);
        //调用service得到结果对象
        List<Student> student = new ArrayList<>();
        student.add( new Student());
        student.add( new Student());
        student.add( new Student());
        student.add( new Student());
        student.add( new Student());
        student.add( new Student());

        //把对象转为json
        ObjectMapper om  = new ObjectMapper();
        String json  = om.writeValueAsString(student);
        System.out.println("服务器端对象转为的json==="+json);

        //输出json，响应ajax
        response.setContentType("application/json;charset=utf-8");
        PrintWriter pw  = response.getWriter();
        pw.println(json);
        pw.flush();
        pw.close();
    }


    /**
     * 控制器方法返回Student--json
     * application/json;charset=utf-8
     *
     * 框架的处理模式：
     *  1. 框架根据控制器方法的返回值类型， 找到HttpMessageConverter接口的实现类。
     *     最后找到的是MappingJackson2HttpMessageConverter.
     *
     *  2.使用实现类MappingJackson2HttpMessageConverter.执行他的write()方法，把
     *     student对象转为了json格式的数据
     *
     *  3.框架使用@ResponseBody注解，把2中的json输出给浏览器。
     *
     *  设置的content-type: application/json;charset=utf-8
     */
    @RequestMapping("/doStudentJson.do")
    @ResponseBody
    public Student doAjaxJson(String name,Integer age){
        System.out.println("控制器方法返回自定义对象Student,转为json。"+name+"=="+age);

        Student student = new Student();
        student.setName("同学"+name);
        student.setAge(age);

        return student;

    }

    /**
     * 控制器方法返回是List<Student>--json array
     * 框架的处理模式：
     *  1. 框架根据控制器方法的返回值类型， 找到HttpMessageConverter接口的实现类。
     *     最后找到的是MappingJackson2HttpMessageConverter.
     *
     *  2.使用实现类MappingJackson2HttpMessageConverter.执行他的write()方法，把
     *     student对象转为了json格式的数据
     *
     *  3.框架使用@ResponseBody注解，把2中的json输出给浏览器。
     *
     */
    @RequestMapping("/doListJsonArray.do")
    @ResponseBody
    public List<Student> doAjaxJsonArray(String name,Integer age){
        System.out.println("控制器方法返List<Student>,转为jsonarray。"+name+"=="+age);

        Student student = new Student();
        student.setName("张三同学");
        student.setAge(20);

        Student student1 = new Student();
        student1.setName("李四同学");
        student1.setAge(26);

        List<Student> list = new ArrayList<>();
        list.add(student1);//李四
        list.add(student);//张三

        return list;

    }

    /**
     * 控制器方法返回String--数据
     *
     * 区分返回值String是数据还是视图。
     * 1.方法上面有@ReponseBody注解就是数据
     * 2.方法上面没有@ResponseBody注解就是视图
     *
     *
     * Content-Type: text/plain;charset=ISO-8859-1
     *
     * 解决中文，需要使用@RequestMapping的produces属性。
     * produces属性： 指定content-type的值
     *
     *
     * 框架处理String返回值
     * 1. 框架使用的StringHttpMessageConverter
     * 2. StringHttpMessageConverter使用的是text/plain;charset=ISO-8859-1。
     *
     *
     *   content-type: 告诉浏览器， 怎么显示服务器返回的数据
     */
    @RequestMapping(value = "/doStringData.do",produces = "text/plain;charset=utf-8")
    @ResponseBody
    public String doStringData(String name,Integer age){
        System.out.println("控制器方法返回String,是数据");
        return "Hello SpringMVC注解式开发";
    }

}
