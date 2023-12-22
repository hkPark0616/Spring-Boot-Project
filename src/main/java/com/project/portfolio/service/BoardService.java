package com.project.portfolio.service;

import com.project.portfolio.domain.entity.Board;
import com.project.portfolio.domain.entity.UserEntity;
import com.project.portfolio.domain.repository.BoardRepository;
import com.project.portfolio.dto.BoardDto;
import com.project.portfolio.dto.UserDto;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.*;

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


    // Board List Get Controller
    @Transactional
    public List<BoardDto> getBoardlist(){
        List<Board> boards = boardRepository.findAll();


        List<BoardDto> boardDtoList = new ArrayList<>();

        for(Board board : boards){
            BoardDto boardDto = BoardDto.builder()
                    .id(board.getId())
                    .createdDate(board.getCreatedDate())
                    .modifiedDate(board.getModifiedDate())
                    .content(board.getContent())
                    .title(board.getTitle())
                    .writer(board.getWriter())
                    .build();

            boardDtoList.add(boardDto);
        }

        return boardDtoList;
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

    @Transactional
    public Map<String, String> validateWrite(BoardDto boardDto) {
        Map<String, String> resultMap = new HashMap<>();


        if (boardDto.getTitle() == null || boardDto.getTitle().isEmpty() ||
                boardDto.getContent() == null || boardDto.getContent().isEmpty()) {

            resultMap.put("success", "false");

        } else {
            resultMap.put("success", "true");
            savePost(boardDto);
        }

        return resultMap;
    }

    @Transactional
    public Map<String, String> validateUpdate(BoardDto boardDto) {
        Map<String, String> resultMap = new HashMap<>();


        if (boardDto.getTitle() == null || boardDto.getTitle().isEmpty() ||
                boardDto.getContent() == null || boardDto.getContent().isEmpty()) {

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
