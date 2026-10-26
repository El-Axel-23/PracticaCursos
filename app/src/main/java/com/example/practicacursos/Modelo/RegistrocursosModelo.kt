package com.example.practicacursos.Modelo

class RegistrocursosModelo {
    fun validarDatos(matricula: String, cursoId: Int, fechaRegistro: String): Boolean {
        if (matricula.isEmpty()) {
            return false
        }
        if (cursoId <= 0) {
            return false
        }
        if (fechaRegistro.isEmpty()) {
            return false
        }
        return true
    }
}