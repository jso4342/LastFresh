package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.domain.dto.OrderDTO;
import com.example.lastfresh.domain.vo.UserVO;
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
        log.info("############# userNum" +  userNum);
        log.info("############# totalPrice" +  orderDTO.getFinalPrice());
        log.info("############# userName" +  orderDTO.getUserName());

        rttr.addFlashAttribute("userNum", userNum);
        rttr.addFlashAttribute("totalPrice", totalPrice);
        rttr.addFlashAttribute("userName", userName);

        orderService.insert(orderDTO, userNum);
        return new RedirectView("orderFinish");
    }

    @GetMapping("/orderCart")
    public void orderCart(){}

    @GetMapping("/orderFinish")
    public void orderFinish(){
    }


    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("/Users/macintoshhd/Desktop/upload/" + fileName));
      //  return FileCopyUtils.copyToByteArray(new File("C:/upload/" + fileName));
    }

}
