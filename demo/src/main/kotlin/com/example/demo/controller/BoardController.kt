package com.example.demo.controller

import com.example.demo.model.Board
import com.example.demo.model.PopupItem
import com.example.demo.repository.BoardRepository
import com.example.demo.service.AlertPopupService
import com.example.demo.service.AlertRedirectPopupService
import com.example.demo.validator.BoardValidator
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/board")
class BoardController(val boardRepository: BoardRepository, val boardValidator: BoardValidator) {

    @GetMapping("/list")
    fun list(model: Model): String {
        model.addAttribute("boards", boardRepository.findAll())
        return "board/list"
    }

    @GetMapping("/form")
    fun form(model: Model, @RequestParam(required = false) id: Long?): String {
        val board = id?.let { boardRepository.findById(it) } ?: Board()
        model.addAttribute("board", board)
        return "board/form"
    }

    @PostMapping("/form")
    fun greetingSubmit(@ModelAttribute board: Board, bindingResult: BindingResult, model: Model): String {
        boardValidator.validate(board, bindingResult)
        if (bindingResult.hasErrors()) {
            val popupItem: PopupItem = PopupItem(content = "입력한 양식이 올바르지 않습니다.")
            AlertPopupService(popupItem = popupItem).render(model)
            return "board/form"
        }

        boardRepository.save(board)
        val popupItem: PopupItem = PopupItem(content = "등록이 완료되었습니다.")
        AlertRedirectPopupService(popupItem = popupItem, redirectPath = "/board/list").render(model)
        return popupItem.alertRedirectPath!!
    }
}