package com.example.lastfresh.controller.product;


import com.example.lastfresh.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/proDelivery")
    public void proDelivery() {
    }

    @GetMapping("/proDetail")
    public void proDetail() {
    }

    @GetMapping("/proNew")
    public void list(Model model) {
        log.info("----------------------------------------------------------------------");
        log.info("list");
        log.info("----------------------------------------------------------------------");
        model.addAttribute("list", productService.getList());
    }

    @GetMapping("/proPickup")
    public void proPickup() {
    }

    @GetMapping("/proShipping")
    public void proShipping() {
    }

    //    private final ProductService productService;
//    @GetMapping("/proNew")
//    public void list(Model model){
//        log.info("----------------------------------------------------------------------");
//        log.info("list");
//        log.info("----------------------------------------------------------------------");
//        model.addAttribute("list", productService.getList());
//    }
}
