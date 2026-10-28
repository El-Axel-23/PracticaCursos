package com.example.practicacursos.Modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataRespuestaInscripcion(val exito: Boolean=false,val mensaje: String="")
