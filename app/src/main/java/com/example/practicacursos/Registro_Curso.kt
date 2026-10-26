package com.example.practicacursos

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Calendar

class Registro_Curso : AppCompatActivity() {
    private lateinit var txtFechaRegistro: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_registro_curso)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        txtFechaRegistro=findViewById(R.id.txtFechaRegistro)
        txtFechaRegistro.setOnClickListener(this::mostrarcalendario)
    }
    fun mostrarcalendario(v: View){
        val calendario=Calendar.getInstance()
        val ano=calendario.get(Calendar.YEAR)
        val mes=calendario.get(Calendar.MONTH)
        val dia=calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog=DatePickerDialog(this, object : DatePickerDialog.OnDateSetListener
        {
            override fun onDateSet(view: DatePicker, ano: Int, mes: Int, dia: Int) {
                txtFechaRegistro.setText(String.format("%02d/%02d/%04d", dia, mes + 1, ano))
            }
        }, ano, mes, dia)
        datePickerDialog.show()
    }

}
