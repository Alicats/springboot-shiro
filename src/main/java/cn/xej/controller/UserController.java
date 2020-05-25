package cn.xej.controller;

import cn.xej.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/toLogin")
    public String toLogin(String userId, String password, Model model, HttpSession session){

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userId,password);

        try {
            subject.login(token);
            session.setAttribute("currentUser",(User)subject.getPrincipal());
            return "redirect:/index";
        } catch (UnknownAccountException e) {
            System.out.println("账号错误");
            model.addAttribute("msg","账号错误");
            return "login";
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
            model.addAttribute("msg","密码错误");
            return "login";
        }

    }

    @RequestMapping("/add")
    public String add(){
        return "pages/add";
    }

    @RequestMapping("/update")
    public String update(){
        return "pages/update";
    }
}
