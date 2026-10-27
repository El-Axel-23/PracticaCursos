package com.example.practicacursos.Presentador

import com.example.practicacursos.Modelo.clsVerRegistrosModelo
import com.example.practicacursos.Modelo.dataCarreras
import com.example.practicacursos.Vista.Activity_VerRegistro
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher

class clsVerRegistrosPresentador(private val vista: Activity_VerRegistro) {

    private val modelo = clsVerRegistrosModelo()
    private var carrerasLista: List<dataCarreras> = emptyList()

    fun iniciar(){
        CoroutineScope(Dispatchers.Main).launch{
            try{
                carrerasLista = modelo.obtenerCarreras()
                vista.mostrarCarreras(carrerasLista)
            }catch (e:Exception){
                vista.mostrarError("Error: "+e.localizedMessage)
            }
        }
    }
    fun seleccionarCarreras(position: Int){
        if(position>=0 && position<carrerasLista.size){
            cargoRegistros(carrerasLista[position].id)
        }
    }
    private fun cargoRegistros (carreraid: Int){
        CoroutineScope(Dispatchers.Main).launch{
            try {
                val registros = modelo.obtenerRegistros(carreraid)
                val totalInscritos = registros.sumOf { it.inscritos }
                vista.mostrarRegistros(registros,totalInscritos)
            }catch (e: Exception){
                vista.mostrarError("Error al mostrar registros: "+e.localizedMessage)
            }
        }
    }

}