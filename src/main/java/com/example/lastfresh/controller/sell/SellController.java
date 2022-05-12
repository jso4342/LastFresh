package com.example.lastfresh.controller.sell;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequestMapping("/sell/*")
public class SellController {

    @GetMapping("/pos")
    public void pos(){}

    @GetMapping("/sellMain")
    public void sellMain(){}

    @GetMapping("/sellMenuList")
    public void sellMenuList(){}

    @GetMapping("/sellMenuRegister")
    public void sellMenuRegister(){}

    @GetMapping("/test")
    public RedirectView test(){
        return new RedirectView("/main/main.html");
    }

}
