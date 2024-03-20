package com.example.demo.controller

import com.example.demo.model.PopupItem
import com.example.demo.service.AlertPopupService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/popup")
class PopupController {
    @GetMapping("/alert")
    fun alert(model: Model): String {
        println("test")
        val popupItem: PopupItem = PopupItem(title = "Test Title", content = "Test Content")
        AlertPopupService(popupItem).render(model)
        return "component/alert"
    }
}