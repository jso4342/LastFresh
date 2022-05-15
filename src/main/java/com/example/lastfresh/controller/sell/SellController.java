package com.example.lastfresh.controller.sell;

import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.service.owner.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/sell/*")
public class SellController {
    private final OwnerService ownerService;

    @GetMapping("/pos")
    public void pos(){}

    @GetMapping("/sellMain")
    public void sellMain(){}

    @GetMapping("/sellMenuList")
    public void sellMenuList(){}

    @GetMapping("/sellMenuRegister")
    public void sellMenuRegister(){}

    @PostMapping("/sellMenuRegister")
    public RedirectView register(ProductVO productVO){

        ownerService.register(productVO);

        return new RedirectView("sellMenuList");
    }

}
