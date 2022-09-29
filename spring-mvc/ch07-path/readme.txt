ch04-return-result: 控制器方法的返回值是请求的处理结果（数据和视图）

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

4.创建一个jsp，发起请求

5.创建一个普通的类，作为控制器使用（代替之前的servlet）
  1）在类的上面加入@Controller注解
  2）在类中定义方法， 方法的上面加入@RequestMapping 注解
     方法处理请求的，相当于servlet的doGet, doPost

6.创建作为结果的jsp页面

7.创建springmvc的配置文件（spring的配置文件一样）
  1）声明组件扫描器，指定@Controller注解所在的包名
  2）声明视图解析器对象

8.使用逻辑视图名称
