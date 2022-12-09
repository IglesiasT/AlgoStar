package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.areas.*;
import edu.fiuba.algo3.modelo.recursos.Recurso;

import java.util.ArrayList;
import java.util.Random;

public class Mapa {

    private int tamanio;
    private Casillero[][] tablero;
    private ArrayList<Area> areas;

    private ArrayList<Base> bases;

    private Base baseUno;
    private Base baseDos;

    public Mapa(){
        this.areas = new ArrayList<Area>();
        this.areas.add(new AreaTerrestre());
        this.areas.add(new AreaEspacial());
        this.bases = new ArrayList<>();
        int cantidadDeBasesPorLado =1 + (new Random()).nextInt(4);
        this.tamanio=cantidadDeBasesPorLado*2*5;
        this.tablero = new Casillero[tamanio][tamanio];

        for (int i = 0; i < tamanio; i++){
            for (int j = 0; j < tamanio; j++){
                this.tablero[i][j] = new Casillero(asignarArea(), i, j, this);
            }
        }
        cargarBases(cantidadDeBasesPorLado);
    }

    private void cargarBases(int cantidad){

        cargarBasesJugadores();

        for (int i = 2; i <= cantidad; i++) {
            int fila = 1 + ((new Random()).nextInt(tamanio-2));
            int columna = ((new Random()).nextInt(fila/*-1-*/)); //esto a veces rompe, pero no se por que
                                                                 //sin el -1 no rompe
            this.bases.add(new Base(this.tablero[fila][columna]));
            this.bases.add(new Base(this.tablero[columna][fila]));
        }
    }

    private void cargarBasesJugadores(){
        int fila = tamanio/2 + ((new Random()).nextInt(tamanio/2 - 1));
        int columna = ((new Random()).nextInt(tamanio/2 - 1 ));
        this.baseUno = new Base(this.tablero[fila][columna]);

        this.baseDos = new Base(this.tablero[columna][fila]);

        this.bases.add(baseUno);
        this.bases.add(baseDos);

    }

    private Area asignarArea(){
        return areas.get(new Random().nextInt(areas.size()));

    }

    public ArrayList<?extends Casillero> obtenerCasilleros(int radio, int fila, int columna){

        ArrayList<Casillero> casilleros = new ArrayList<>();

        for (int i = fila - radio; i <= fila + radio; i++) {
            if(! (i < 0 || i > tamanio-1)){
                for (int j = columna - radio; j <= columna + radio; j++) {
                    if(! (j < 0 || j > tamanio-1)){
                        casilleros.add(this.tablero[i][j]);
                    }
                }
            }
        }
        return casilleros;
    }

    public Casillero obtenerCasillero(int i, int j) {
        return this.tablero[i][j];
    }

    public Base obtenerBaseUno(){
        return baseUno;
    }
    public Base obtenerBaseDos(){
        return baseDos;
    }

    public int obtenerTamanio(){
        return tamanio;
    }
}
