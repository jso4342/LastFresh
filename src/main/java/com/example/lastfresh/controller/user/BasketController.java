package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.dto.ProductPageDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.service.product.ProductService;
import com.example.lastfresh.service.user.MyPageService;
import com.example.lastfresh.service.user.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;

/* 장바구니 */

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/order/*")
public class BasketController {
    private final OrderService orderService;
    private final MyPageService myPageService;
    private final ProductService productService;

    // 주문서 페이지
    @GetMapping("/order")
    public void order(Long userNum, Model model, CriteriaProduct criteriaProduct) throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        model.addAttribute("list", orderService.getListByDTO(userNum));
        model.addAttribute("user", myPageService.get(userNum));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));
    }

    // 주문 완료 시
    @PostMapping("/order")
    public RedirectView orderProceed(OrderDTO orderDTO, Model model, RedirectAttributes rttr, CriteriaProduct criteriaProduct){
        int totalPrice = orderDTO.getFinalPrice();
        Long userNum = orderDTO.getUserNum();
        String userName = orderDTO.getUserName();
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        rttr.addFlashAttribute("userNum", userNum);
        rttr.addFlashAttribute("totalPrice", totalPrice);
        rttr.addFlashAttribute("userName", userName);
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));

        orderService.insert(orderDTO, userNum);
        return new RedirectView("orderFinish");
    }

    @GetMapping("/orderCart")
    public void orderCart(Long userNum, Model model, CriteriaProduct criteriaProduct) throws Exception {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());

        model.addAttribute("user", myPageService.get(userNum));
        model.addAttribute("userNum", userNum);
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));
    }

    @GetMapping("/orderFinish")
    public void orderFinish(Long userNum, RedirectAttributes rttr){
        rttr.addFlashAttribute("userNum", userNum);
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("/home/ubuntu/C:/upload/" + fileName));
    }

}
