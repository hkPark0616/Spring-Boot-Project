package com.project.portfolio.dto;


import com.project.portfolio.domain.entity.Board;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDto {
    private Integer id;


    private String title;

    private String content;

    private LocalDateTime createdDate;

    private LocalDateTime modifiedDate;

    private String writer;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .build();

        return build;

    }
        @Builder
        public BoardDto(String title, Integer id,  String content, LocalDateTime createdDate, LocalDateTime modifiedDate, String writer) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.createdDate = modifiedDate;
            this.modifiedDate = modifiedDate;
            this.writer = writer;

        }
}
