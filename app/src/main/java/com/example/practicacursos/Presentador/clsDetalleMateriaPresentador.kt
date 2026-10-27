package com.example.practicacursos.Presentador

import com.example.practicacursos.Modelo.clsDetalleMateriaModelo
import com.example.practicacursos.Modelo.dataDetalleMateria
import com.example.practicacursos.Vista.DetalleMateriaActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class clsDetalleMateriaPresentador(private val vista: DetalleMateriaActivity) {
    private val modelo = clsDetalleMateriaModelo()

    fun cargarDetalle(materiaId: Int) {
        CoroutineScope(Dispatchers.Main).launch {
            try {
                val materia: dataDetalleMateria = modelo.obtenerDetalleMateria(materiaId)
                vista.mostrarDetalle(materia)
            } catch (e: Exception) {
                vista.mostrarError("Error al cargar detalle: " + e.localizedMessage)
            }
        }
    }
}