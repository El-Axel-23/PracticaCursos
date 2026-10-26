package com.example.practicacursos.Presentador

import com.example.practicacursos.Modelo.RegistrocursosModelo
import com.example.practicacursos.Vista.RegistrocursosVista

class RegistrocursosPresentador(private val vista: RegistrocursosVista) {

    private val modelo = RegistrocursosModelo()

    fun registrarCurso(matricula: String, cursoId: Int, fechaRegistro: String) {
        if (modelo.validarDatos(matricula, cursoId, fechaRegistro)) {
            vista.mostrarMensaje("Los datos son correctos")
        } else {
            vista.mostrarMensaje("Completa todos los datos correctamente")
        }
    }
}