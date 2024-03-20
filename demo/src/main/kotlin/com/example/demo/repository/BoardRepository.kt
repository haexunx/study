package com.example.demo.repository

import com.example.demo.model.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository : JpaRepository<Board, Long> {

}