package com.example.lastfresh.controller.sell;

import com.example.lastfresh.domain.dto.PosDTO;
import com.example.lastfresh.service.owner.PosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pos/*")
public class PosController {
    private final PosService posService;

//    @GetMapping("/list/{pageNum}/{amount}/{limit}")
//    public PosDTO getList(@PathVariable("pageNum") int pageNum, @PathVariable("amount") int amount, @PathVariable("limit") int limit) {
//        return new
//    }
}
