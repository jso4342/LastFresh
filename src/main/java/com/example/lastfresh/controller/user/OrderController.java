package com.example.lastfresh.controller.user;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/* 장바구니 */

@Controller
@Slf4j
@RequestMapping("/user/order/*")
public class OrderController {

    @GetMapping("/order")
    public void order(){}

    @GetMapping("/orderCart")
    public void orderCart(){}

}
