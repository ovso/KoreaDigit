package io.github.ovso.koreadigit

class DigitNameProvider {

    private var listener: ((String) -> Unit)? = null
    fun setListener(l: ((String) -> Unit)? = null) {
        listener = l
    }

    fun toKoreaDigit(inputDigit: String) {
    }

    private val digitSymbols = mutableListOf(
        "",
        "만",
        "억",
        "조",
        "경",
        "해",
        "자",
        "양",
        "구",
        "간",
        "정",
        "재",
        "극",
        "항하사",
        "아승기",
        "나유타",
        "불가사의",
        "무량대수"
    )
}