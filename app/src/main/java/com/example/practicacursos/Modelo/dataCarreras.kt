package com.example.practicacursos.Modelo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class dataCarreras(val id: Int,val carrera: String){
    override fun toString(): String = carrera
}
@Serializable
data class dataRegistro(val id: Int,val nombre: String,@SerialName("url_imagen") val urlImagen: String ?= null,
                        val cupo: Int, val inscritos: Int)
