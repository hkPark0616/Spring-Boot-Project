package com.project.portfolio.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.project.portfolio.domain.entity.Board;
import com.project.portfolio.dto.BoardDto;
import com.project.portfolio.service.BoardService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.apache.commons.io.FileUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;




@Controller
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService){
        this.boardService = boardService;
    }

    // Board List Page with Pageable
    @GetMapping("/list")
    public String list(Model model,
                       @PageableDefault(page = 0,
                                        size = 9,
                                        sort = "createdDate",
                                        direction = Sort.Direction.DESC) Pageable pageable){

        model.addAttribute("boardList", boardService.getBoardlist(pageable));

        return "/list";
    }

    // Home Get Post List
    @GetMapping("/getList")
    @ResponseBody
    public List<BoardDto> getList(Model model,
                                @PageableDefault(sort = "createdDate",
                                direction = Sort.Direction.DESC) Pageable pageable){

        return boardService.getHomelist(pageable);
    };


    // Validate Admin
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.GET)
    public Map<String, String> write(HttpServletRequest request){

        Map<String, String> resultMap = new HashMap<>();
        HttpSession session = request.getSession(false);
        if(boardService.hasWriteAccess(request) && session != null){

            resultMap.put("success", "true");
            return resultMap;

        }else{
            resultMap.put("success", "false");
            return resultMap;
        }

    }

    // Go Write Page
    @GetMapping("/write")
    public String goWrite(Model model) {
        model.addAttribute("boardDto", new BoardDto());
        return "write";
    }


    // Write
    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    public Map<String, String> write(@ModelAttribute(name = "boardDto") BoardDto boardDto){


        return boardService.validateWrite(boardDto);
    }

    // Detail Page
    @GetMapping("/post/detail/{no}")
    public String detail(@PathVariable("no") Integer id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        // htmlUnescape
        String escapedHtml = HtmlUtils.htmlUnescape(boardDto.getContent());
        boardDto.setContent(escapedHtml);

        model.addAttribute("boardDto", boardDto);
        return "detail";
    }


    // Post Edit Page
    @GetMapping("/post/edit/{no}")
    public String edit(@PathVariable("no") Integer id, Model model){
        BoardDto boardDto = boardService.getPost(id);

        model.addAttribute("boardDto", boardDto);
        return "update";
    }


     //Post Update
    @ResponseBody
    @PutMapping("/post/edit/{no}")
    public Map<String, String> update(@ModelAttribute(name = "boardDto") BoardDto boardDto){

        return boardService.validateUpdate(boardDto);
    }
//    @PutMapping("/post/edit/{no}")
//    public String update(BoardDto boardDto) {
//        boardService.savePost(boardDto);
//
//        return "redirect:/list";
//    }

    // Post Delete
//    @ResponseBody
//    @DeleteMapping(value = "/post/delete/{no}")
//    public Map<String, String> delete(@PathVariable("no") Integer id){
//
//        return boardService.deletePost(id);
//    }

    @RequestMapping(value = "/post/delete/{no}", method = RequestMethod.DELETE)
    public String delete(@PathVariable("no") Integer id) {
        boardService.deletePost(id);

        return "redirect:/list";
    }

    // Session Check
    @ResponseBody
    @RequestMapping(value = "/sessionCheck", method = RequestMethod.GET)
    public Map<String, String> sessionCheck(HttpServletRequest request){

        Map<String, String> resultMap = new HashMap<>();
        HttpSession session = request.getSession(false);
        if(boardService.sessionCheck(request) && session != null){

            resultMap.put("success", "true");
            return resultMap;

        }else{
            resultMap.put("success", "false");
            return resultMap;
        }

    }
}
