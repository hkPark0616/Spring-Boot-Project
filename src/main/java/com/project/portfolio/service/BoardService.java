package com.project.portfolio.service;

import com.project.portfolio.domain.entity.Board;
import com.project.portfolio.domain.entity.UserEntity;
import com.project.portfolio.domain.repository.BoardRepository;
import com.project.portfolio.dto.BoardDto;
import com.project.portfolio.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.util.HtmlUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.stream;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository){
        this.boardRepository = boardRepository;
    }


    // Post Write Controller
    @Transactional
    public Integer savePost(BoardDto boardDto){

        return boardRepository.save(boardDto.toEntity()).getId();

    }

    // Home Board List Get Controller
    public List<BoardDto> getHomelist(Pageable pageable){
        Page<Board> boards = boardRepository.findAll(pageable);


        List<BoardDto> boardList = new ArrayList<>();

        for(Board board : boards){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .createdDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .content(board.getContent())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .build();

            boardList.add(boardDto);
        }

        return boardList;
    }

    // Post Get Controller with Pageable
    @Transactional
    public Page<BoardDto> getBoardlist(Pageable pageable){
        Page<Board> boards = boardRepository.findAll(pageable);
        System.out.println(boards);
        List<BoardDto> boardDtoList = new ArrayList<>();

        for (Board board : boards) {
            BoardDto result = BoardDto.builder()
                    .id(board.getId())
                    .createdDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .content(board.getContent())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .thumbnail(board.getThumbnail())
                    .build();
            boardDtoList.add(result);
        }

        return new PageImpl<>(boardDtoList, pageable, boards.getTotalElements());
    }

    // Board Detail Controller
    @Transactional
    public BoardDto getPost(Integer id){
        Optional<Board> boardWrapper = Optional.ofNullable(boardRepository.findById(id).orElse(null));
        Board board = boardWrapper.get();

            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .createdDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .content(board.getContent())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .build();

        return boardDto;
    }

    //리뷰 중 첫번째 사진 썸네일로 지정
    public String getImgSrc(String content) {
        Pattern nonValidPattern = Pattern
                .compile("(?i)< *[IMG][^\\>]*[src] *= *[\"\']{0,1}([^\"\'\\ >]*)");
        int imgCnt = 0;
        String img = "";
        Matcher matcher = nonValidPattern.matcher(content);
        while (matcher.find()) {
            img = matcher.group(1);
            imgCnt++;
            if(imgCnt == 1){
                break;
            }
        }
        return img;
    }

    @Transactional
    public Map<String, String> validateWrite(BoardDto boardDto) {
        Map<String, String> resultMap = new HashMap<>();

            // title
        if (boardDto.getTitle() == null || boardDto.getTitle().isEmpty() ||
                // content
                boardDto.getContent() == null || boardDto.getContent() == "" ||boardDto.getContent().equals("&nbsp;") ||
                boardDto.getContent().equals("<p>&nbsp;</p>") || boardDto.getContent().equals("<br>")
                || boardDto.getContent().equals("<br/>") || boardDto.getContent().isEmpty()) {

            resultMap.put("success", "false");

        } else {

            // Thumbnail Check
            String content = boardDto.getContent();
            String imgSrc = getImgSrc(content);
            System.out.println(imgSrc);

            // 게시글에 이미지가 없으면 empty 썸네일로 대체
            if(imgSrc.isEmpty() || imgSrc == ""){
                imgSrc = "/images/emptyThumbnail.png";
                boardDto.setThumbnail(imgSrc);
            }
            // 게시글에 이미지가 존재하면 첫번째 이미지를 썸네일로
            else{
                boardDto.setThumbnail(imgSrc);
            }


            // HTML 이스케이프 처리
            String escapedHtml = HtmlUtils.htmlEscape(boardDto.getContent());
            boardDto.setContent(escapedHtml);

            resultMap.put("success", "true");
            savePost(boardDto);
        }

        return resultMap;
    }

    @Transactional
    public Map<String, String> validateUpdate(BoardDto boardDto) {
        Map<String, String> resultMap = new HashMap<>();

        // title
        if (boardDto.getTitle() == null || boardDto.getTitle().isEmpty() ||
                // content
                boardDto.getContent() == null || boardDto.getContent().equals("&nbsp;") ||
                boardDto.getContent().equals("<p>&nbsp;</p>") || boardDto.getContent().equals("<br>")
                || boardDto.getContent().equals("<br/>") || boardDto.getContent().isEmpty()) {

            resultMap.put("success", "false");

        } else {
            resultMap.put("success", "true");
            savePost(boardDto);
            System.out.println(boardDto);
        }

        return resultMap;
    }

    @Transactional
    public boolean hasWriteAccess(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        return session != null && "admin".equals(session.getAttribute("userId"));
    }

    @Transactional
    public boolean sessionCheck(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        return session != null && "admin".equals(session.getAttribute("userId"));
    }

//    @Transactional
//    public Map<String, String> deletePost(Integer id){
//        Map<String, String> resultMap = new HashMap<>();
//
//        resultMap.put("success", "true");
//        boardRepository.deleteById(id);
//
//
//        return resultMap;
//    }

    @Transactional
    public void deletePost(Integer id) {
        boardRepository.deleteById(id);
    }
}
