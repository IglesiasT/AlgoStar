package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public abstract class Raza {
    int cantidadDeMineral;
    int cantidadDeGas;
    LinkedList<Construccion> construcciones;
    HashMap listadoConstrucciones = new HashMap<String, Integer>();

    protected Raza(){
        this.cantidadDeMineral = 100;
        this.cantidadDeGas = 0;
    }

    public void construir(String construccion, Casillero casilleroAConstruir){
         /*
        Verificar que si no se tienen los recursos no se pueden construir los edificios (Para cada
        edificio para cada raza)
         */
    }
}
