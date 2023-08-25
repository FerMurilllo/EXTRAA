package com.example.extraa

fun main() {
    val encriptador = Encriptador()

    println("Ingrese una palabra:")
    val palabra = readLine().orEmpty()

    val palabraEncriptada = encriptador.encriptar(palabra)
    println("encriptada: $palabraEncriptada")

    val palabraDesencriptada = encriptador.desencriptar(palabraEncriptada)
    println("desencriptada: $palabraDesencriptada")
}

