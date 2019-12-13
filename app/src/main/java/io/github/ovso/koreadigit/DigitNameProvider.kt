package io.github.ovso.koreadigit

class DigitNameProvider {

    private var listener: ((String?) -> Unit)? = null
    fun setListener(l: ((String?) -> Unit)? = null) {
        listener = l
    }

    fun toKoreaDigit(inputDigit: String) {
        digitSymbols?.let {
            val divList = getDivList(inputDigit)
            val divNameList = getDivNameList(divList)
            val text = getDigitString(divNameList)
            listener?.invoke(text)
        } ?: listener?.invoke(null)
    }

    private fun getDigitString(divNameList: MutableList<String>): String {
        val finalBuilder = StringBuilder()
        divNameList.reverse()
        divNameList.forEachIndexed { _, s ->
            finalBuilder.append(s)
        }
        return finalBuilder.toString() + "원"
    }

    private fun getDivNameList(divList: MutableList<String>): MutableList<String> {
        val divNameList = mutableListOf<String>()
        divList.forEachIndexed { index, s ->
            if (index < digitSymbols!!.count())
                if (s.toInt() == 0 && index < digitSymbols!!.lastIndex) {
                    divNameList.add("")
                } else {
                    divNameList.add("$s${digitSymbols!![index]}")
                }
            else
                divNameList.add(s)
        }

        return divNameList

    }

    private fun getDivList(text: String): MutableList<String> {
        val sb = StringBuilder()
        val divList = mutableListOf<String>()
        text.reversed().forEachIndexed { index, c ->
            sb.append(c)
            if (sb.count() == 4) {
                divList.add(sb.toString().reversed())
                sb.clear()
            }
        }
        divList.add(sb.toString().reversed())
        sb.clear()
        return divList
    }

    var digitSymbols: MutableList<String>? = mutableListOf(
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