package com.example.practicacursos.Vista

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.ViewParent
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.practicacursos.Adaptador.Adaptador_Registro
import com.example.practicacursos.Modelo.dataCarreras
import com.example.practicacursos.Modelo.dataRegistro
import com.example.practicacursos.Presentador.clsVerRegistrosPresentador
import com.example.practicacursos.R
import kotlin.jvm.java

class Activity_VerRegistro : AppCompatActivity() {
    private lateinit var txtTotal: TextView
    private lateinit var rvRegistros: RecyclerView
    private lateinit var btnVolver: Button
    private lateinit var spnCarreras: Spinner
    private lateinit var adaptador: Adaptador_Registro
    private lateinit var presenter: clsVerRegistrosPresentador

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ver_registro)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtTotal = findViewById(R.id.txtTotal)
        rvRegistros = findViewById(R.id.rvRegistros)
        btnVolver = findViewById(R.id.btnVolverCatalogo)
        rvRegistros.layoutManager = LinearLayoutManager(this)
        adaptador = Adaptador_Registro(emptyList())
        rvRegistros.adapter = adaptador

        presenter= clsVerRegistrosPresentador(this)
        ConfiguracionListener()
        presenter.iniciar()

        btnVolver.setOnClickListener {
            startActivity(Intent(this, Activity_VerRegistro::class.java))
        }


    }
    private fun ConfiguracionListener(){
        spnCarreras.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                presenter.seleccionarCarreras(position)
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        btnVolver.setOnClickListener { finish() }
    }
    fun mostrarCarreras(carreras: List<dataCarreras>) {
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, carreras)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spnCarreras.adapter = adapter
    }
    fun mostrarRegistros(registros: List<dataRegistro>, total: Int) {
        adaptador.actualizarLista(registros)
        txtTotal.text = "Total: $total"
    }
    fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
    }
}