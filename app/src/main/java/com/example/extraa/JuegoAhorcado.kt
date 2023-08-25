package com.example.extraa

open class palabra(palabra: String, tipo: Any) {
    var palabra = palabra
    var tipo = tipo

    fun rpalabra(): String {
        return  palabra
    }

    fun comprobar(){
        when(tipo){
            is aguda -> println("La palabra es aguda")
            is grave -> println("La palabra es grave")
        }
    }
}

class aguda constructor(palabraAguda : String): palabra(palabraAguda, tipo = "aguda"){
    fun retPalA(): String {
        return  palabra
    }
}

class grave constructor(palabraGrave : String): palabra(palabraGrave, "grave"){
    fun retPalG(): String {
        return  palabra
    }
}


fun palabra.juegar(){
    println("juegemos")
    println("Bienvenido al juego del ahorcado")

    val encriptador = Encriptador()

    var palabrota =  encriptador.encriptar(palabra)
    var palespecio = palabrota.encriptar().split("").filter { it.isNotEmpty()}


    println("INGRESA UNA LTERIA")
    while (true) {
        var vidas = 4
        val listaLetras = mutableSetOf<Char>()

        val adivinada = MutableList(palabrota.encriptar().length){'_'}

        while (vidas > 0) {

            val letra = leerletra()[0]
            listaLetras.add(letra)

            if (letra.toString() !in  palespecio){
                vidas -= 1
                val monito = Monito(vidas)
                println("Vidas restantes $vidas")
                // println(monito.toString())
            } else {
                for(i in palespecio.indices){
                    if (palespecio[i] == letra.toString() && adivinada[i] == '_'){
                        adivinada[i] = letra
                    }
                }
            }
            println("Plabara adivinada: ${adivinada.joinToString(" ")}")

            if (adivinada.joinToString("") == palabrota.encriptar()){
                println("Ganaste!")
                comprobar()
                break
            }

            if (vidas == 0){
                println("perdiste lapalbra era: $palabrota")
                comprobar()

            }
        }
    }
}

fun palabra.leerletra(): String {
    val letra= readLine().toString()
    if (letra.length == 1)  {
        return letra
    }  else {
        var txt = "nomas uno"
        return  txt
    }
}

fun palabra.Monito(vidas : Int) {
    when (vidas){
        4 -> {
            println("------")
            println("|   ")
        }
        3 -> {
            println("------")
            println("|   ")
            println("O")
            println("|   ")
        }
        2 -> {
            println("   ------")
            println("   |   ")
            println("   O")
            println("   |   ")
            println("*--|--*   ")

        }
        1 -> {
            println("   ------")
            println("   |   ")
            println("   O")
            println("   |   ")
            println("*--|--*   ")
            println("   |   ")
            println("   |   ")
        }
        else -> {
            println("--MUELTO----")
            println("   |   ")
            println("   O  D")
            println("   |  E ")
            println("*--|--A  ")
            println("   |  D ")
            println("  _|_   ")
        }

    }
}


fun main(args: Array<String>) {

    println("Ingrese una palabra:")
    val palabra = readLine().orEmpty()
    val traerPalabraA = aguda(palabra).retPalA()



    var pal1 = grave(palabraGrave = "$traerPalabraA")



    val lista = listOf(pal1)
    var random = lista.random()



    var retPal = random.rpalabra()



    var sendpalabra = palabra(retPal, random)

    println("La palabra que ingresaste fue encriptada adivinala")

    sendpalabra.juegar()
}

