package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Casillero {
    private int fila;
    private int columna;
    private Tablero tablero;
    private Recurso recurso;
    private EspacioDeConstruccion espacio;
    private Construccion construccion;

    public Casillero(int fila, int columna, Tablero tablero){
        this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
        this.recurso = new SinRecurso();
        this.espacio = new SinEspacio();
        this.construccion = null;
    }
    public Casillero(Recurso recurso, int fila, int columna, Tablero tablero){
        this.fila = fila;
        this.columna = columna;
        this.tablero = tablero;
        this.recurso = recurso;
        this.espacio = new SinEspacio();
        this.construccion = null;
    }

    public void setEspacioDeConstruccion(EspacioDeConstruccion espacio){
        this.espacio = espacio;
    }
    public void establecerConstruccion(Construccion construccionAEstablecer){

        if (this.construccion != null || (this.recurso.estaOcupado())){
            throw new NoSePuedeConstruir();
        }

        this.construccion = construccionAEstablecer;
        this.recurso.ocupar();
    }

    public void destruirConstruccion(){
        this.construccion = null;
        this.recurso.liberar();
    }

    public Recurso obtenerRecurso() {
        return this.recurso;
    }

    public boolean contiene (Recurso recurso){
        return (this.recurso.getClass() == recurso.getClass());
    }
    public boolean contiene (EspacioDeConstruccion espacio){
        return (this.espacio.getClass() == espacio.getClass());
    }
    public ArrayList<? extends Casillero> obtenerCasilleros(int radio) {
        return this.tablero.obtenerCasilleros(radio, this.fila, this.columna);
    }
}
