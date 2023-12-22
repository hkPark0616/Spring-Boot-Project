package com.project.portfolio.domain.repository;

import com.project.portfolio.domain.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;


public interface BoardRepository extends JpaRepository<Board, Integer> {
}
