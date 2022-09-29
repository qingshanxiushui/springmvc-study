package com.bjpowernode.handle;

import com.bjpowernode.exception.AgeException;
import com.bjpowernode.exception.NameException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * @ControllerAdvice: 表示当前类是异常的处理类。 给controller增加功能的
 *               位置：在类的上面
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    //定义处理异常的方法，当异常发生后，执行这个方法
    //方法定义和Controller类中方法的定义


    /**
     * 处理NameException类型的异常
     * 参数：
     *   Exception：表示Controller抛出的异常对象
     *
     * @ExceptionHandler: 表示此方法处理异常
     *           属性： value 异常的类型。
     *           位置： 方法的上面
     */
    @ExceptionHandler(value = NameException.class)
    public ModelAndView  doNameException(Exception e){
        System.out.println("doNameException==="+e);
        /*
           发生异常：
           1.记录异常，记录到日志文件。
           2.发送通知， 邮件，短信等等
           3.给用户友好的提示
         */
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "姓名只能是zs");
        mv.setViewName("nameError");
        return mv;
    }


    //处理AgeException
    @ExceptionHandler(value = AgeException.class)
    public ModelAndView  doAgeException(Exception e){
        System.out.println("doAgeException==="+e);
        /*
           发生异常：
           1.记录异常，记录到日志文件。
           2.发送通知， 邮件，短信等等
           3.给用户友好的提示
         */
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "年龄不能大于80");
        mv.setViewName("ageError");
        return mv;
    }



    //处理其他异常
    @ExceptionHandler
    public ModelAndView  doOtherException(Exception e){
        System.out.println("doOtherException==="+e);
        /*
           发生异常：
           1.记录异常，记录到日志文件。
           2.发送通知， 邮件，短信等等
           3.给用户友好的提示
         */
        ModelAndView mv  = new ModelAndView();
        mv.addObject("tips", "请稍后重试");
        mv.setViewName("defaultError");
        return mv;
    }
}
