package com.example.practicacursos.Interface
import com.example.practicacursos.Modelo.dataCarreras
import com.example.practicacursos.Modelo.dataRegistro
import retrofit2.http.GET
import retrofit2.http.Query
interface ApiService {

@GET("obtener_carreras.php")
suspend fun obtenerCarreras(): List<dataCarreras>

@GET("obtner_registros.php")
suspend fun obtenerRegistros(@Query("carrera_id") carreraId: Int): List<dataRegistro>
}