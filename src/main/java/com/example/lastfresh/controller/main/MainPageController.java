package com.example.lastfresh.controller.main;


import com.example.lastfresh.domain.vo.BasketVO;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*메인페이지 및 GNB로 페이지이동 관련 전반적 페이지 이동*/

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/main/*")
public class MainPageController {
    private final ProductService productService;

    @GetMapping("/main")
    public void main(Model model) {
        model.addAttribute("newListPercents", getPercentOfNew());
        model.addAttribute("saleListPercents", getListBySale());
        model.addAttribute("bestReviewListPercents", getListByReview());
        model.addAttribute("newList", productService.getListByNew());
        model.addAttribute("saleList", productService.getListBySale());
        model.addAttribute("bestReviewList", productService.getListByReview());
    }

    @GetMapping("/getAttachList")
    @ResponseBody
    public List<ProductVO> getAttachList(Long pno) {
        return productService.getImages(pno);
    }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String sellProductThumbnail) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("C:/upload/" + sellProductThumbnail));
    }

    @GetMapping("/mainTerm")
    public void mainTerm() {
    }

    @GetMapping("/mainHowToUser")
    public void mainHowToUser() {
    }

    public List<Double> getPercentOfNew() {
        Long originalPrice = 0L;
        Long salePrice = 0L;
        Double percent = 0.0;
        Double roundedNumber = 0.0;

        List<Double> percents = new ArrayList<>();

        List<ProductVO> listByNew = productService.getListByNew();
        for (ProductVO product : listByNew) {
            originalPrice = product.getSellProductOriginPrice();
            salePrice = product.getSellProductDiscountPrice();
            percent = (double)((((double)originalPrice) - salePrice) / originalPrice) * 100;
            roundedNumber = (double)(Math.round(percent*1000)/1000);

            percents.add(roundedNumber);
        }
        return percents;
    }

    public List<Double> getListBySale() {
        Long originalPrice = 0L;
        Long salePrice = 0L;
        Double percent = 0.0;
        Double roundedNumber = 0.0;

        List<Double> percents = new ArrayList<>();
        List<ProductVO> listBySale = productService.getListBySale();
        for (ProductVO product : listBySale) {
            originalPrice = product.getSellProductOriginPrice();
            salePrice = product.getSellProductDiscountPrice();
            percent = (double)((((double)originalPrice) - salePrice) / originalPrice) * 100;
            roundedNumber = (double)(Math.round(percent*1000)/1000);

            percents.add(roundedNumber);
        }
        return percents;
    }

    public List<Double> getListByReview() {
        Long originalPrice = 0L;
        Long salePrice = 0L;
        Double percent = 0.0;
        Double roundedNumber = 0.0;
        List<Double> percents = new ArrayList<>();
        List<ProductVO> listByReview = productService.getListByReview();
        for (ProductVO product : listByReview) {
            originalPrice = product.getSellProductOriginPrice();
            salePrice = product.getSellProductDiscountPrice();
            percent = (double)((((double)originalPrice) - salePrice) / originalPrice) * 100;
            roundedNumber = (double)(Math.round(percent*1000)/1000);
            percents.add(roundedNumber);
        }
        return percents;
    }
    @PostMapping("/productToBasket")
    public RedirectView productToBasket(ProductVO productVO,BasketVO basketVO,HttpServletRequest request) {
                HttpSession session = request.getSession();
                Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNumber")));

        productService.productToBasket(userNum,basketVO,productVO);
        return new RedirectView("main");
    }

}
