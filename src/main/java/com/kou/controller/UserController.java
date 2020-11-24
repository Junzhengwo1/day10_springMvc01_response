package com.kou.controller;

import com.kou.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author JIAJUN KOU
 */
@Controller
@RequestMapping("/user")
public class UserController {

    //model对象可以存数据 底层时是map 它是存在request域中的
    @RequestMapping("/testString")
    public String testString(Model model){
        System.out.println("testString.....");
        //模拟从数据库中查询出User对象
        User user=new User();
        user.setUsername("我的王妃");
        user.setPassword("123");
        user.setAge(21);
        model.addAttribute("user",user);

        return "success";
    }


    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("testVoid........");

        //转发方式：
        //request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向方式:
        //response.sendRedirect(request.getContextPath()+"/index.jsp");
        //直接响应的方式；
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        response.getWriter().print("hello我的王妃");
        return;
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        System.out.println("testModelAndView.....");
        //模拟从数据库中查询出User对象
        ModelAndView mv=new ModelAndView();
        User user=new User();
        user.setUsername("我的嫔妃");
        user.setPassword("123");
        user.setAge(21);
        //把user对象存储到mv对象中，也会把user对象存入到request对象域中
        mv.addObject("user",user);
        //跳转到那个页面// 它使用了视图解析器
        mv.setViewName("success");
        return mv;
    }

    @RequestMapping("/testAjax")
    public @ResponseBody User testAjax(@RequestBody User user){
        System.out.println("testAjax.......");
        //拿到json数据
        System.out.println(user);
        //响应
        user.setUsername("haha");
        user.setAge(50);
        return user;
    }

}
