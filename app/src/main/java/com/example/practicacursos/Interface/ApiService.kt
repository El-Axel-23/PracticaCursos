package com.example.practicacursos.Interface

import com.example.practicacursos.Modelo.dataCarreras
import com.example.practicacursos.Modelo.dataDetalleMateria
import com.example.practicacursos.Modelo.dataRegistro
import com.example.practicacursos.Modelo.dataRespuestaAlumno
import com.example.practicacursos.Modelo.dataRespuestaInscripcion
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
interface ApiService {

@GET("obtener_carreras.php")
suspend fun obtenerCarreras(): List<dataCarreras>

@GET("obtener_registros.php")
suspend fun obtenerRegistros(@Query("carrera_id") carreraId: Int): List<dataRegistro>

    @GET("detalle_curso.php")
    suspend fun detalleMaterial(@Query("curso_id") cursoId: Int): dataDetalleMateria


    @FormUrlEncoded
    @POST("obtener_alumno.php")
    suspend fun obtenerAlumno(@Field("matricula")matricula: String): dataRespuestaAlumno

    @FormUrlEncoded
    @POST("registrar_cursos.php")
    suspend fun registrarInscripcion(@Field("matricula")matricula: String,
                                     @Field("curso_id")cursoId: Int,
                                     @Field("fecha_registro")fechaRegistro: String): dataRespuestaInscripcion
}