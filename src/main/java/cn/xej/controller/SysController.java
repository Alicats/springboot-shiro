package cn.xej.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SysController {

    @RequestMapping({"/","/welcome"})
    public String welcome(){
        return "login";
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}
