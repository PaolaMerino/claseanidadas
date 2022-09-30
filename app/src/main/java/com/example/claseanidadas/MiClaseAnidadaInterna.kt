package com.example.claseanidadas

class MiClaseAnidadaInterna{
    //clase anidada (Nested Class), es una clase que puede contener otra clase dentro de ella.

    private val uno = 1

    private fun retornaUno():Int{
        return uno
    }

    class miClaseAnidada{

        fun suma(n1:Int,n2:Int):Int{
            return n1+n2
        }

    }

    //clase interna (Inner Class)
    inner class miClaseInterna{

        fun sumarUno(num:Int):Int{
            return num + uno
        }
        fun sumarDos(num:Int):Int{
            return num + uno + retornaUno()
        }


    }



}