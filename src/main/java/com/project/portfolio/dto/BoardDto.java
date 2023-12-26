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

    private String thumbnail;

    public Board toEntity(){
        Board build = Board.builder()
                .id(id)
                .title(title)
                .content(content)
                .writer(writer)
                .thumbnail(thumbnail)
                .build();

        return build;

    }
        @Builder
        public BoardDto(String title,
                        Integer id,
                        String content,
                        LocalDateTime createdDate,
                        LocalDateTime modifiedDate,
                        String writer,
                        String thumbnail) {
            this.id = id;
            this.title = title;
            this.content = content;
            this.createdDate = createdDate;
            this.modifiedDate = modifiedDate;
            this.writer = writer;
            this.thumbnail = thumbnail;
        }
}
