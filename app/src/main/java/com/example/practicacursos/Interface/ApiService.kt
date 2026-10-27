package com.example.practicacursos.Interface

import com.example.practicacursos.Modelo.dataCarreras
import com.example.practicacursos.Modelo.dataDetalleMateria
import com.example.practicacursos.Modelo.dataRegistro
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {

@GET("obtener_carreras.php")
suspend fun obtenerCarreras(): List<dataCarreras>

@GET("obtener_registros.php")
suspend fun obtenerRegistros(@Query("carrera_id") carreraId: Int): List<dataRegistro>

    @GET("detalle_curso.php")
    suspend fun detalleMateria(@Query("curso_id") cursoId: Int): dataDetalleMateria
}