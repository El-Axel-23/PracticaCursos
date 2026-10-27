package com.example.practicacursos.Modelo

class clsDetalleMateriaModelo {

    suspend fun obtenerDetalleMateria(materiaId: Int): dataDetalleMateria {
        return RetrofitCliente.apiService.detalleMateria(materiaId)
    }
}