ch12-permissioninterceptor: 使用拦截器验证登录的用户


步骤：
1.新建web 应用
2.加入web依赖
  spring-webmvc依赖（springmvc框架依赖）， servlet依赖。

3.声明springmvc核心对象DispatcherServlet.
  1)DispatcherServlet是一个Servlet对象。
  2)DispatcherServlet叫做前端控制器（front controller）
  3)DispatcherServlet作用：
     1.在servlet的init（）方法中，创建springmvc中的容器对象。
       WebApplicationContext ctx = new ClassPathXmlApplicationContext("appliationContext.xml")


     2.作为servlet，接收请求。

4.创建一个jsp，发起请求， 有参数name ，age


5.创建一个普通的类，作为控制器使用（代替之前的servlet）
  1）在类的上面加入@Controller注解
  2）在类中定义方法.

6.创建作为结果的jsp页面


7.创建login.jsp 模拟登录， 把一个账号存放到session。
  创建logout.jsp 模拟退出系统， 把session中数据删除


8.创建普通类，实现HandlerInterceptor
  在preHandle()方法中， 获取登录的账号信息，判断账号是否可以访问系统。
  如果能访问系统， preHandle返回true ，其他情况返回false

9.创建一个jsp，显示处理结果。

10.创建springmvc的配置文件（spring的配置文件一样）
  1）声明组件扫描器，指定@Controller注解所在的包名
  2）声明视图解析器对象
  3）声明拦截器对象，指定拦截的uri地址


