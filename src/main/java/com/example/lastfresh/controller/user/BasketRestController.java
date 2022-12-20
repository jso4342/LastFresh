package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.dto.BasketDTO;
import com.example.lastfresh.service.user.BasketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/* 장바구니 */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/cart/*")
public class BasketRestController {
    private final BasketService basketService;

    @GetMapping("/orderCart/count/{userNum}")
    public int count(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.count(userNum);
    }

    // get list for delivery items
    @GetMapping("/orderCart/pickUp/{userNum}")
    public List<BasketDTO> getPickUpList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListPickUp(userNum);
    }

    // get list for pick up items
    @GetMapping("/orderCart/delivery/{userNum}")
    public List<BasketDTO> getDeliveryList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListDelivery(userNum);
    }

    // get list for shipping items
    @GetMapping("/orderCart/shipping/{userNum}")
    public List<BasketDTO> getShippingList(@PathVariable("userNum") Long userNum) throws Exception {
        return basketService.getListShipping(userNum);
    }

    // delete product
    @DeleteMapping("/orderCart/{basketNum}")
    public void remove(@PathVariable("basketNum") Long basketNum){
        basketService.remove(basketNum);
    }

    // deleteAll products
    @DeleteMapping("/orderCart/removeAll/{userNum}")
    public void removeAll(@PathVariable("userNum") Long userNum){
        basketService.removeAll(userNum);
    }

    @PatchMapping("/orderCart/add/{basketNum}")
    public void quantityAdd(@PathVariable("basketNum") Long basketNum){
        basketService.addQuantity(basketNum);
    }

    @PatchMapping("/orderCart/subtract/{basketNum}")
    public void quantitySubtract(@PathVariable("basketNum") Long basketNum){
        basketService.subtractQuantity(basketNum);
    }

    @PatchMapping("/orderCart/check/{basketNum}")
    public void check(@PathVariable("basketNum") Long basketNum){
        basketService.check(basketNum);
    }

    @PatchMapping("/orderCart/checkAll/{userNum}")
    public void checkAll(@PathVariable("userNum") Long userNum){
        basketService.checkAll(userNum);
    }

    @PatchMapping("/orderCart/unCheckAll/{userNum}")
    public void unCheckAll(@PathVariable("userNum") Long userNum){
        basketService.unCheckAll(userNum);
    }
}
