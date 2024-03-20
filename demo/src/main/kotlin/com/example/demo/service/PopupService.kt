package com.example.demo.service

import com.example.demo.model.PopupItem
import org.springframework.ui.Model

interface Popup {
    fun render(model: Model)
}


abstract class PopupService(private val popupItem: PopupItem) : Popup {
    override fun render(model: Model) {
        model.addAttribute("popupItem", popupItem)
    }
}

class AlertPopupService(private val popupItem: PopupItem) : PopupService(popupItem) {
    override fun render(model: Model) {
        super.render(model)
    }
}

class AlertRedirectPopupService(private val popupItem: PopupItem, private val redirectPath: String) :
    PopupService(popupItem) {
    init {
        popupItem.alertRedirectPath = "component/alert_redirect"
        popupItem.redirectPath = redirectPath

    }

    override fun render(model: Model) {
        super.render(model)
    }
}