package com.example.claseanidadas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity_ListView : AppCompatActivity() {

    private var lvLenguajes: ListView?=null
    private var tvSeleccion: TextView?=null

    private val lenguajes = arrayOf("Kotlin","Java","C#","C++","PHP","VB.Net")
    private val posiciones = arrayOf("1","3","6","4","2","5")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_app)

        lvLenguajes = findViewById(R.id.lv_Lenguajes)
        tvSeleccion = findViewById(R.id.tv_Seleccion)

        var adaptador: ArrayAdapter<String> = ArrayAdapter<String>(this,R.layout.list_item_claseprogramacion,lenguajes)
        lvLenguajes?.adapter=adaptador

        lvLenguajes?.onItemClickListener = object : AdapterView.OnItemClickListener{
            override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long
            ) {
                tvSeleccion?.text = "La posición del lenguaje ${lvLenguajes?.getItemAtPosition(position)} es ${posiciones[position]}"
            }


        }

    }

}