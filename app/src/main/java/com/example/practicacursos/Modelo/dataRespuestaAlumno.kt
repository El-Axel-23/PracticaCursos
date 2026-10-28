package com.example.practicacursos.Modelo

import kotlinx.serialization.Serializable

@Serializable
data class dataRespuestaAlumno(val exito: Boolean=false,val mensaje: String="")
