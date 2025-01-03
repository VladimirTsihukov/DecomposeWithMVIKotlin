package com.tishukoff.decomposewithmvikotlin

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform