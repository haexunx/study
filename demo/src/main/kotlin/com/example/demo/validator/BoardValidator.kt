package com.example.demo.validator

import com.example.demo.model.Board
import org.springframework.stereotype.Component
import org.springframework.validation.Errors
import org.springframework.validation.Validator

@Component
class BoardValidator : Validator {
    override fun supports(clazz: Class<*>): Boolean {
        return Board::class.java.isAssignableFrom(clazz)
    }

    override fun validate(target: Any, errors: Errors) {
        val b: Board = target as Board
        if (b.title.isEmpty()) {
            errors.rejectValue("title", "empty", "제목을 입력하세요.")
        } else if (b.title.length !in 2..30) {
            errors.rejectValue("title", "length", "제목의 길이는 2에서 30 사이여야 합니다.")
        }
        if (b.content.isEmpty()) {
            errors.rejectValue("content", "empty", "내용을 입력하세요.")
        }
    }
}