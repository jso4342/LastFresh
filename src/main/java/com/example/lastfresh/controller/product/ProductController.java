package com.example.lastfresh.controller.product;


import com.example.lastfresh.domain.dto.ProductPageDTO;
import com.example.lastfresh.domain.vo.CriteriaProduct;
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

    //    private final ProductService productService;
//    @GetMapping("/proNew")
//    public void list(Model model){
//        log.info("----------------------------------------------------------------------");
//        log.info("list");
//        log.info("----------------------------------------------------------------------");
//        model.addAttribute("list", productService.getList());
//    }
}
