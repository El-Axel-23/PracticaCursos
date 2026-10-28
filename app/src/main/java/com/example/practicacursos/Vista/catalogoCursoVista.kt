
package com.example.practicacursos.Vista

import com.example.practicacursos.Modelo.dataCurso

interface catalogoCursoVista {
    fun mostrarCursos(listaCursos: List<dataCurso>)
    fun mostrarError(mensaje: String)
}