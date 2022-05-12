package com.example.lastfresh.controller.product;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/product/*")
public class ProductController {

    @GetMapping("/proDelivery")
    public void proDelivery(){}

    @GetMapping("/proDetail")
    public void proDetail(){}

    @GetMapping("/proNew")
    public void proNew(){}

    @GetMapping("/proPickup")
    public void proPickup(){}

    @GetMapping("/proShipping")
    public void proShipping(){}
}
