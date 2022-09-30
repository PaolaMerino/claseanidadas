package com.example.claseanidadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //var etn_Valor1: EditText?=null
    lateinit var etn_Valor1: EditText
    lateinit var etn_Valor2:EditText
    lateinit var tv_Resultado: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Enum class o clases enumeradas
          //claseEnumeradas()
        //seguridadNula()
        //funciones()
        //clases()
        //claseAnidadayInterna()

        etn_Valor1 = findViewById(R.id.etn_Valor1)
        etn_Valor2 = findViewById(R.id.etn_Valor2)
        tv_Resultado = findViewById(R.id.tv_Resultado)

    }



    enum class Direccion (val dir:Int){
        NORTE(1),SUR(-1),ESTE(1),OESTE(-1);

        fun descripcion():String{
            return when(this){
                NORTE -> "La dirección es Norte"
                SUR -> "La dirección es Norte"
                ESTE -> "La dirección es Norte"
                OESTE -> "La dirección es Norte"
            }
        }
    }

    private fun claseEnumeradas(){
        var direccionUsurario:Direccion?=null
        println(direccionUsurario)
        println("Dirección actual: $direccionUsurario")

        direccionUsurario = Direccion.NORTE
        println("Dirección actual: $direccionUsurario")
        direccionUsurario = Direccion.OESTE
        println("Dirección actual: $direccionUsurario")

        //Propiedades por def
        println("Propiedad name: ${direccionUsurario.name}")
        println("Propiedad Ordinal: ${direccionUsurario.ordinal}")

    }

    //Veremos seguridad contra nulos(null safety)
    fun seguridadNula(){
        var miString = "Programacion IV (20/09/2022)"
        // miString = null Esto daria un error de compilación
        println(miString)

        var miSeguridadNula:String?= "valor de seguridad nula"
        println(miSeguridadNula)
        miSeguridadNula = null
        println(miSeguridadNula)

        //miSeguridadNula = "Le volvemos a cambiar el valor"
        //println(miSeguridadNula)
/*
        if(miSeguridadNula!=null){
            println(miSeguridadNula!!.toString())
        }else{
            println(miSeguridadNula!!.toString())
        }*/

        //llamadas seguras (safe call)
        println(miSeguridadNula?.length)
        miSeguridadNula?.let {
            println(it.toString())
        }?: kotlin.run {
            println(miSeguridadNula.toString())
        }
    }

    fun funciones(){
        decirHola()
        decirHola()
        decirHola()

        decirNombre("kevin")
        decirNombre("Mario")
        decirNombre("Paola")

        val resultadoSuma = sumarDosNumeros(4,6)
        println(resultadoSuma)

        println(sumarDosNumeros(9,8))

        println(sumarDosNumeros(3,sumarDosNumeros(7,5)))

        decirNombreEdad("Valeria", 21)

    }
    //Funcion Simple
    fun decirHola(){
        println("Hola Estudiantes!")
    }

    //funciones con un parametro de entrada
    fun decirNombre(nombre:String){
        println("Hola, tu nombre es ${nombre}")
    }
    fun decirNombreEdad(nombre:String,edad:Int){
        println("Hola, tu nombre es ${nombre} y mi edad es $edad")
    }

    //funciones con un valor de retorno
    fun sumarDosNumeros(num1:Int,num2:Int):Int{
        val suma = num1+num2
        return suma
    }

     fun clases(){
        val persona1 = Estudiantes("Victor",22, arrayOf(Estudiantes.progra.PHP,Estudiantes.progra.JAVA))
        println(persona1.nombre)
        persona1.edad = 24
        println(persona1.edad)
        persona1.codigo()

        val persona2 = Estudiantes("Mariel",20, arrayOf(Estudiantes.progra.PYTHON), arrayOf(persona1))
        persona2.edad = 24
        println(persona2.edad)
        persona2.codigo()

        println("${persona2.amigo?.first()?.nombre} es amigo de ${persona2.nombre}")


    }

    private fun claseAnidadayInterna(){
        val miClaseAnidada=MiClaseAnidadaInterna.miClaseAnidada()
        val sumar= miClaseAnidada.suma(10,5)
        println("El resultado de la suma es: $sumar")
        val miClaseInterna = MiClaseAnidadaInterna().miClaseInterna()
        val sumarDos = miClaseInterna.sumarUno(10)
        println("El resultado de la suma es: $sumarDos")
        val sumarTres = miClaseInterna.sumarDos(5)
        println("El resultado de sumar uno es $sumarTres")
    }

    fun calcular(Vista: View){
        val valor1_String = etn_Valor1?.text.toString()
        val valor2_String = etn_Valor2.text.toString()


        val valor1_Int = valor1_String.toInt()
        val valor2_Int = Integer.parseInt(valor2_String)

        val suma = valor1_Int+valor2_Int
        val resultado = suma.toString()
        tv_Resultado.setText(resultado)



    }

}
