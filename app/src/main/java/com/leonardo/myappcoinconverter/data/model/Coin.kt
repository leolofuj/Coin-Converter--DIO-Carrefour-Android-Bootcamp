package com.leonardo.myappcoinconverter.data.model

import java.util.*

enum class Coin(val locale: Locale) {
    USD(Locale.US),
    CAD(Locale.CANADA),
    BRL(Locale("pt", "BR")),
    ARS(Locale("es", "AR")),
    GBP(Locale.UK),
    JPY(Locale.JAPAN),
    AUD(Locale("en","AU"))
    ;

    companion object {
        fun getByName(name: String) = values().find { it.name == name } ?: BRL

    }
}