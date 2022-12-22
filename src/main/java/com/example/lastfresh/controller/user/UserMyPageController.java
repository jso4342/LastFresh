package com.example.lastfresh.controller.user;


import com.example.lastfresh.domain.repository.UserRepository;
import com.example.lastfresh.domain.vo.CriteriaProduct;
import com.example.lastfresh.domain.vo.ReviewVO;
import com.example.lastfresh.domain.vo.UserVO;
import com.example.lastfresh.service.user.MyPageService;
import com.example.lastfresh.service.user.ReviewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONObject;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
/*유저 마이 페이지*/

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/user/myPage/*")
public class UserMyPageController {
    private final MyPageService myPageService;
    private final ReviewService reviewService;
    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    //회원 정보 수정 페이지
    @GetMapping("/myChangeInfo")
    public void myChangeInfo(Long userNum, HttpServletRequest request, Model model, CriteriaProduct criteriaProduct) throws Exception {
        model.addAttribute("user", myPageService.get(userNum));
    };

    //탈퇴
    @GetMapping("/exit")
    public RedirectView exit(Long userNum, HttpServletRequest request) throws Exception {
        myPageService.exit(userNum);
        return new RedirectView("/main/main");
    };

    //정보 수정
    @PostMapping("/modify")
    public RedirectView modify(UserVO userVO, RedirectAttributes rttr) throws Exception {
        Long userNum = userVO.getUserNum();
        String encodedPassword = passwordEncoder.encode(userVO.getUserPw());
        userVO.setUserPw(encodedPassword);

        rttr.addAttribute("userNum", userNum);
        rttr.addAttribute("result", myPageService.modify(userVO, userNum) ? "success" : "failure");

        return new RedirectView("/main/moveMain");
    };


    @PostMapping("/write")
    public RedirectView write(Long reviewNum, String reviewTitle, String reviewContent, Long userNum, RedirectAttributes rttr) throws Exception{
        ReviewVO reviewVO = new ReviewVO();

        reviewVO.setReviewNum(reviewNum);
        reviewVO.setReviewTitle(reviewTitle);
        reviewVO.setReviewContent(reviewContent);
        reviewService.update(reviewVO);

        rttr.addAttribute("list", reviewService.getReview(userNum));
        rttr.addAttribute("userNum", userNum);
        return new RedirectView("myReviewWritten");
    }

    @GetMapping("/delete")
    public RedirectView delete(Long reviewNum, Long userNum, RedirectAttributes rttr) throws Exception{
        reviewService.delete(reviewNum);

        rttr.addAttribute("list", reviewService.getReview(userNum));
        rttr.addAttribute("userNum", userNum);
        return new RedirectView("myReviewWritten");
    }

    @PostMapping("/pwCheck/{password}/{userNum}")
    @ResponseBody
    public JSONObject checkPw(HttpServletRequest req, @PathVariable("password") String password, @PathVariable("userNum") Long userNum) {
        JSONObject obj = new JSONObject();
        String userPw = userRepository.getById(userNum).getUserPw();

        if(passwordEncoder.matches(password, userPw)){
            obj.put("status", "ok");
        }else{
            obj.put("status", "not-ok");
        }
        return obj;
    }

    // 비밀번호 확인 페이지
    @GetMapping("/myCheckPw")
    public void myCheckPw(Long userNum, Model model) throws Exception {
        model.addAttribute("user", myPageService.get(userNum));
    }

    @GetMapping("/myOrder")
    public void myOrder(Long userNum, Model model) throws Exception{
        model.addAttribute("bills", myPageService.getBills(userNum));
        model.addAttribute("userNum", userNum);
    }

    @GetMapping("/myOrderDetail")
    public void myOrderDetail(Long userNum, Long billOrderNum, Model model) throws Exception{
        model.addAttribute("bill", myPageService.getBill(billOrderNum));
        model.addAttribute("userNum", userNum);
        model.addAttribute("user", myPageService.get(userNum));
        model.addAttribute("billOrderNum", billOrderNum);
    }

    //cancel one item
    @GetMapping("/cancelOrder")
    public RedirectView cancelOrder(Long billProductNum, Long userNum, Long billOrderNum, RedirectAttributes rttr) throws Exception {
        myPageService.cancelOrder(billProductNum);
        rttr.addAttribute("bill", myPageService.getBill(billOrderNum));
        rttr.addAttribute("userNum", userNum);
        rttr.addAttribute("user", myPageService.get(userNum));
        rttr.addAttribute("billOrderNum", billOrderNum);
        return new RedirectView("myOrderDetail");
    };

    @GetMapping("/myReviewUnwritten")
    public void myReviewUnwritten(Long userNum, Model model) throws Exception{
        model.addAttribute("list", reviewService.getReview(userNum));
        model.addAttribute("userNum", userNum);
        }

    @GetMapping("/myReviewWrite")
    public void myRevieWrite(Long userNum, Long reviewNum, Model model) throws Exception{
        model.addAttribute("userNum", userNum);
        model.addAttribute("productVO", reviewService.getProduct(reviewNum));
        model.addAttribute("review", reviewService.getOneReview(reviewNum));
        model.addAttribute("reviewNum", reviewNum);
       }

    @GetMapping("/myReviewWritten")
    public void myReviewWritten(Long userNum, Model model) throws Exception{
        model.addAttribute("list", reviewService.getReview(userNum));
        model.addAttribute("userNum", userNum);
       }

    @GetMapping("/display")
    @ResponseBody
    public byte[] getFile(String fileName) throws IOException {
        return FileCopyUtils.copyToByteArray(new File("/home/ubuntu/C:/upload/" + fileName));
    }
}