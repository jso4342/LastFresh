package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.MyPageService;
import com.example.lastfresh.service.user.OrderService;
import com.example.lastfresh.service.user.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

/* 장바구니 */

@Controller
//@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/order/*")
public class BasketController {
    private final OrderService orderService;
    private final MyPageService myPageService;
    private final ReviewService reviewService;

    // 주문서 페이지
    @GetMapping("/order")
    public void order(Long userNum, Model model) throws Exception {
        model.addAttribute("list", orderService.getListByDTO(userNum));
        model.addAttribute("user", myPageService.get(userNum));
    }

  /*  @GetMapping("/order2")
    public List<BasketDTO> getListByDTO(@PathVariable("userNum") Long userNum){
        return orderService.getListByDTO(userNum);
    }*/


    // 주문 완료 시
    @PostMapping("/order")
        public RedirectView orderProceed(OrderDTO orderDTO, RedirectAttributes rttr){
        Long userNum = orderDTO.getUserNum();
        int totalPrice = orderDTO.getFinalPrice();
        String userName = orderDTO.getUserName();
        /*log.info("############# userNum" +  userNum);
        log.info("############# totalPrice" +  orderDTO.getFinalPrice());
        log.info("############# userName" +  orderDTO.getUserName());*/

        rttr.addFlashAttribute("userNum", userNum);
        rttr.addFlashAttribute("totalPrice", totalPrice);
        rttr.addFlashAttribute("userName", userName);

        orderService.insert(orderDTO, userNum);
        // sellProduct_stock decrease !!!!!!!!!!!!!!!!!!!!!!!!!
       // reviewService.insert(orderDTO, userNum)
        return new RedirectView("orderFinish");
    }

    @GetMapping("/orderCart")
    public void orderCart(Long userNum, Model model) throws Exception {
       /* model.addAttribute("pickUpList", orderService.getListPickUp(userNum));
        model.addAttribute("deliveryList", orderService.getListDelivery(userNum));
        model.addAttribute("shippingList", orderService.getListShipping(userNum));*/
        model.addAttribute("user", myPageService.get(userNum));
        model.addAttribute("userNum", userNum);
    }

    @GetMapping("/orderFinish")
    public void orderFinish(){
    }


    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
       // return FileCopyUtils.copyToByteArray(new File("/Users/macintoshhd/Desktop/upload/" + fileName));
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

}
