package com.example.demo.model

data class PopupItem(
    var title: String? = "알림",
    var content: String? = null,
    var type: PopupType? = null,
    var openPath: String? = null,
    var alertRedirectPath: String? = null,
    var redirectPath: String? = null,
    var name: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var top: String? = null,
    var left: String? = null,
    var menubar: String? = null,
    var toolbar: String? = null,
    var location: String? = null,
    var status: String? = null,
    var scrollbars: String? = null,
    var resizable: String? = null,
) {
    /**
     * 'alert' -> 기본 Alert
     *
     * 'alert_redirect' -> Alert 후 Redirect
     *
     * 'confirm' -> 확인, 취소 버튼의 알림 팝업
     *
     * 'layer' -> 광고처럼 층을 쌓는 팝업
     *
     * 'form' -> form 태그로 입력을 위한 팝업
     */
    fun convertType(to: String): PopupItem {
        when (to.uppercase()) {
            "ALERT" -> type = PopupType.ALERT
            "ALERT_REDIRECT" -> type = PopupType.ALERT_REDIRECT
            "CONFIRM" -> type = PopupType.CONFIRM
            "LAYER" -> type = PopupType.LAYER
            "FORM" -> type = PopupType.FORM
            else -> println("지원하지 않는 PopupType")
        }
        return this
    }

    fun features(): String {
        val featuresList = mutableListOf<String>()
        width?.let { featuresList.add("width=$it") }
        height?.let { featuresList.add("height=$it") }
        top?.let { featuresList.add("top=$it") }
        left?.let { featuresList.add("left=$it") }
        menubar?.let { featuresList.add("menubar=$it") }
        toolbar?.let { featuresList.add("toolbar=$it") }
        location?.let { featuresList.add("location=$it") }
        status?.let { featuresList.add("status=$it") }
        scrollbars?.let { featuresList.add("scrollbars=$it") }
        resizable?.let { featuresList.add("resizable=$it") }
        return featuresList.joinToString(", ")
    }
}

enum class PopupType {
    ALERT,
    ALERT_REDIRECT,
    CONFIRM,
    LAYER,
    FORM
}