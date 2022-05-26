package com.example.lastfresh.controller.product;


import com.example.lastfresh.domain.dto.ProductPageDTO;
import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/product/*")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/proDelivery")
    public void proDelivery(CriteriaProduct criteriaProduct, Model model) {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        model.addAttribute("deliveryList", productService.getDeliveryList(criteriaProduct));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getDeliveryTotal(criteriaProduct)));
        model.addAttribute("getDeliveryTotal",productService.getDeliveryTotal(criteriaProduct));
    }

    @GetMapping("/proDetail")
    public void proDetail(Long sellProductNum, Model model){
        model.addAttribute("proDetail", productService.get(sellProductNum));
    }

    @GetMapping("/proNew")
    public void list(CriteriaProduct criteriaProduct, Model model) {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        model.addAttribute("list", productService.getList(criteriaProduct));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getTotal(criteriaProduct)));
        model.addAttribute("getTotal",productService.getTotal(criteriaProduct));
    }

    @GetMapping("/proPickup")
    public void proPickup(CriteriaProduct criteriaProduct, Model model) {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        model.addAttribute("pickupList", productService.getPickupList(criteriaProduct));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getPickupTotal(criteriaProduct)));
        model.addAttribute("getPickupTotal",productService.getPickupTotal(criteriaProduct));
    }

    @GetMapping("/proShipping")
    public void proShipping(CriteriaProduct criteriaProduct, Model model) {
        criteriaProduct = new CriteriaProduct(criteriaProduct.getPageNum(), criteriaProduct.getAmount());
        model.addAttribute("shippingList", productService.getShippingList(criteriaProduct));
        model.addAttribute("ProductPageDTO", new ProductPageDTO(criteriaProduct, productService.getShippingTotal(criteriaProduct)));
        model.addAttribute("getShippingTotal",productService.getShippingTotal(criteriaProduct));
    }

    ///////////////////////////////
    @PostMapping("/productToBasketNew")
    public RedirectView productToBasketNew(ProductVO productVO, BasketVO basketVO, HttpServletRequest request) {
        HttpSession session = request.getSession();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));
//        productService.productToBasket(userNum,basketVO,productVO);
//        밑에꺼 쓰고 버려주세요
        productService.productToBasket(1L,basketVO,productVO);
        return new RedirectView("proNew");
    }
    @PostMapping("/productToBasketPickup")
    public RedirectView productToBasketPickup(ProductVO productVO,BasketVO basketVO,HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(1L,basketVO,productVO);
        return new RedirectView("proPickup");
    }
    @PostMapping("/productToBasketShipping")
    public RedirectView productToBasketShipping(ProductVO productVO, BasketVO basketVO, HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(1L,basketVO,productVO);
        return new RedirectView("proShipping");
    }

    @PostMapping("/productToBasketShippingDetail")
    public void productToBasketShippingDetail(ProductVO productVO,BasketVO basketVO,HttpServletRequest request) {
//    Long productNum=productVO.getSellProductNum();
//
//        HttpSession session = request.getSession();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(1L,basketVO,productVO);
    }
    //    private final ProductService productService;
    @RequestMapping("/productToBasket")
    public RedirectView productToBasket(Long sellProductDiscountPrice, Long sellProductNum,String basketDeliveryMethod,Long basketQuantity,
                                        HttpServletRequest request) {
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        log.info(String.valueOf(sellProductDiscountPrice));
        log.info(String.valueOf(sellProductNum));
        log.info(basketDeliveryMethod);
        log.info(String.valueOf(basketQuantity));
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        log.info("666666666666666666666666666666666666666666666666666666666666666666666666666666666666");
        BasketVO basketVO=new BasketVO();
        ProductVO productVO=new ProductVO();
        basketVO.setBasketPrice(sellProductDiscountPrice);
        productVO.setSellProductNum(sellProductNum);
        basketVO.setBasketDeliveryMethod(basketDeliveryMethod);
        basketVO.setBasketQuantity(basketQuantity);
//        HttpSession session = request.getSession();
//                Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(1L, basketVO, productVO);
        return new RedirectView("proNew");
    }
}
