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

    private String title;

    private String content;


    private String writer;

    @Builder
    public Board(String title, Integer id,  String content, String writer){
        this.id = id;

        this.title = title;

        this.content = content;

        this.writer = writer;

    }
}
