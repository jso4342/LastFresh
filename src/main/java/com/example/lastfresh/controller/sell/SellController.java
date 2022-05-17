package com.example.lastfresh.controller.sell;

import com.example.lastfresh.domain.dto.ImageDTO;
import com.example.lastfresh.domain.dto.ProductDTO;
import com.example.lastfresh.domain.vo.ProductVO;
import com.example.lastfresh.service.owner.OwnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.coobird.thumbnailator.Thumbnailator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

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
    public RedirectView register(ProductVO productVO, HttpServletRequest request){
        log.info("-----------------------------------------------------");
        log.info("등록 들어옴");
        log.info("DTO : " + productVO);
        log.info("-----------------------------------------------------");

//        HttpSession session = request.getSession();
//        session.setAttribute();
//        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNum")));

        ownerService.register(productVO, 3L);

        return new RedirectView("sellMenuList");
    }

//    @PostMapping("/sellMenuRegister")
//    public RedirectView register(ProductVO productVO, HttpServletRequest request){
//        log.info("-----------------------------------------------------");
//        log.info("등록 들어옴");
//        log.info("DTO : " + productVO);
//        log.info("-----------------------------------------------------");
//
////        HttpSession session = request.getSession();
////        session.setAttribute();
////        Long userNum = Long.valueOf(String.valueOf(session.getAttribute("userNum")));
//
//        ownerService.register(productVO, 0L);
//
//        return new RedirectView("sellMenuList");
//    }

    @PostMapping("/uploadAjaxAction")
    @ResponseBody
    public ImageDTO uploadAjaxPost(MultipartFile[] uploadFile) throws IOException {
        String uploadFolder = "C:/upload";
//        UUID(Universally unique identifier) : 범용 고유 식별자
//        네트워크 상에서 각각의 개체들을 식별하기 위하여 사용되었다.
//        중복될 가능성이 거의 없다고 인정되기 때문에 많이 사용된다.
//        UUID의 개수는 10의 38승입니다.

        String uploadFolderPath = this.getPath();
        File uploadPath = new File(uploadFolder, uploadFolderPath);
        if(!uploadPath.exists()){
            uploadPath.mkdirs();
        }

        UUID uuid = UUID.randomUUID();
        String uploadFileName1 = uuid.toString() + "_" + uploadFile[0].getOriginalFilename();
        String uploadFileName2 = uuid.toString() + "_" + uploadFile[1].getOriginalFilename();

        ImageDTO imgDTO = new ImageDTO();
        imgDTO.setSellProductThumbnail(uploadFileName1);
        imgDTO.setSellProductImage(uploadFileName2);
        imgDTO.setSellProductImageUuid(uuid.toString());
        imgDTO.setSellProductImageUploadPath(uploadFolderPath);
        log.info(imgDTO.toString());

        //저장할 경로와 파일의 이름을 File객체에 담는다.
        File saveFile1 = new File(uploadPath, uploadFileName1);
        File saveFile2 = new File(uploadPath, uploadFileName2);

        try {
            //설정한 경로에 해당 파일을 업로드한다.
            uploadFile[0].transferTo(saveFile1);
            uploadFile[1].transferTo(saveFile2);
            return imgDTO;

        } catch (IOException e) {
            log.error(e.getMessage());
            throw new IOException("서버 오류입니다. 다시 시도해주세요.");
        }
    }

//    @PostMapping("/upload_ok3")
//    public String upload3(@RequestParam("file") List<MultipartFile> list) {
//
//        return "fileupload/upload_ok";
//    }

    private String getPath(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date today = new Date();
        return sdf.format(today);
    }
}
