package com.project.portfolio.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "board")
public class Board extends TimeEntity {

    @Id  @GeneratedValue
    private Integer id;

    @Column(length = 255)
    private String title;

    @Column(length = 4000)
    private String content;

    @Column(length = 255)
    private String writer;

    @Column(length = 255)
    private String thumbnail;

    @Builder
    public Board(String title,
                 Integer id,
                 String content,
                 String writer,
                 String thumbnail){
        this.id = id;

        this.title = title;

        this.content = content;

        this.writer = writer;

        this.thumbnail = thumbnail;

    }
}
