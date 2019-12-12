package io.github.ovso.koreadigit

class DigitNameProvider {

    private var listener: ((String) -> Unit)? = null
    fun setListener(l: ((String) -> Unit)? = null) {
        listener = l
    }

    fun toKoreaDigit(inputDigit: String) {
        val digitStrBuilder = StringBuilder()
        val digitList = mutableListOf<String>()
        val digitNameList = mutableListOf<String>()
        val fullDigit: String = getFullDigit(inputDigit)
        fullDigit.forEach {
            digitStrBuilder.append(it)
            if (digitStrBuilder.count() == 4) {
                digitList.add(digitStrBuilder.toString())
                digitStrBuilder.clear()
            }
        }
        digitList.reverse()
        digitList.forEachIndexed { index, digit ->
            val name =
                if (digitSymbols.count() > index) {
                    if (digit.toInt() != 0) {
                        // 리스트의 첫번째 인덱스 값에서 문자열이 0으로 시작하면 0을 잘라내기 위해 toInt()를 사용한다.
                        if (digitList.lastIndex == index) "${digit.toInt()}${digitSymbols[index]}" else "$digit${digitSymbols[index]}"
                    } else {
                        "" // 단위가 0000이라면 무시하기 위한 문자열을 반환
                    }
                } else { // 심볼은 18개이다. 그것을 넘어갔을 경우다.
                    digit.toInt().toString()

                }
            digitNameList.add(name)
        }
        digitNameList.reverse()
        val displayDigit = StringBuilder()
        digitNameList.forEach { s ->
            displayDigit.append(s)
        }
        displayDigit.append("원")
        println(displayDigit.toString())
        listener?.invoke(displayDigit.toString())
    }

    private fun getFullDigit(inputDigit: String) =
        when (inputDigit.count() % 4) {
            1 -> "000$inputDigit"
            2 -> "00$inputDigit"
            3 -> "0$inputDigit"
            else -> inputDigit
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