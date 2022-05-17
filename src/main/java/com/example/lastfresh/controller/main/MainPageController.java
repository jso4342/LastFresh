package com.example.lastfresh.controller.main;


import com.example.lastfresh.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

/*메인페이지 및 GNB로 페이지이동 관련 전반적 페이지 이동*/

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainPageController {
    private final ProductService productService;

    @GetMapping("/main")
    public void main(Model model){
        model.addAttribute("newList", productService.getListByNew());
        model.addAttribute("saleList", productService.getListBySale());
    }
    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException{
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }
    @GetMapping("/mainTerm")
    public void mainTerm(){}


    @GetMapping("/mainHowToUser")
    public void mainHowToUser(){}




}
