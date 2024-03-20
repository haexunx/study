package com.example.demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HomeController {
    //    @GetMapping("/index")
    @GetMapping
    fun index(model: Model): String? {
        return "index"
    }
}