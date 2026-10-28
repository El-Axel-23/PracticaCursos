package com.example.practicacursos.Presentador

import com.example.practicacursos.Modelo.RegistrocursosModelo
import com.example.practicacursos.Registro_Curso
import com.example.practicacursos.Vista.RegistrocursosVista
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlin.coroutines.coroutineContext

class RegistrocursosPresentador(private val vista: RegistrocursosVista) {

   private val modelo = RegistrocursosModelo()

    fun registrarCurso(matricula: String,cursoId: Int,fechaRegistro: String){
        if(!modelo.validarDatos(matricula,cursoId,fechaRegistro)){
            vista.mostrarMensaje("Completa todos los datos correctamente")
            return
        }

        CoroutineScope(Dispatchers.Main).launch {
            try{
                val alumno=modelo.obtenerAlumno(matricula)
                if (!alumno.exito){
                    vista.mostrarMensaje(alumno.mensaje)
                    return@launch
                }
                val respuesta=modelo.registrarInscripcion(matricula,cursoId,fechaRegistro)
                vista.mostrarMensaje(respuesta.mensaje)
            }catch (e: Exception){
                vista.mostrarMensaje("Error al registrarse:"+(e.localizedMessage?:"Error desconocido"))
            }
        }

    }
}