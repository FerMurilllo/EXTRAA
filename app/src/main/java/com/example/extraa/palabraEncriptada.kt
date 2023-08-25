package com.example.extraa
import java.lang.StringBuilder

class PalabraEncriptada( palabra: String) {
    val letras = arrayOf('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z')

    val palabraa = palabra

    override fun toString(): String {
        return """
        Palabra original: $palabraa
        Encriptación: ${encriptar()}
    """.trimIndent()
    }


}

fun PalabraEncriptada.encriptar(): String {
    val encriptacion = StringBuilder()
    for (letra in palabraa) {
        val encriptado = when {
            letras.contains(letra) -> {
                val nuevoIndice = (letras.indexOf(letra) + 2)
                letras[nuevoIndice]
            }
            else -> letra
        }
        encriptacion.append(encriptado)
    }
    return encriptacion.toString()
}

fun PalabraEncriptada.desencriptar(): String {
    val desencriptacion = StringBuilder()
    for (letra in encriptar()) {
        val desencriptado = when {
            letras.contains(letra) -> {
                val nuevoIndice = (letras.indexOf(letra) - 2)
                letras[nuevoIndice]
            }
            else -> letra
        }
        desencriptacion.append(desencriptado)
    }
    return desencriptacion.toString()
}



interface Encriptacion {
    fun encriptar(palabra: String): PalabraEncriptada
    fun desencriptar(encriptacion: PalabraEncriptada): String
}

class Encriptador : Encriptacion {
    override fun encriptar(palabra: String): PalabraEncriptada {
        return PalabraEncriptada(palabra)
    }
    override fun desencriptar(encriptacion: PalabraEncriptada): String {
        return encriptacion.desencriptar()
    }
}
