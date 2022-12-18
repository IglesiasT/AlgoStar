package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.areas.*;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {

    private final int tamanio;
    private final Casillero[][] tablero;
    private final ArrayList<Area> areas;
    private final ArrayList<Base> bases;

    public Mapa(){
        this.areas = new ArrayList<Area>();
        this.areas.add(new AreaTerrestre());
        this.areas.add(new AreaEspacial());
        this.bases = new ArrayList<>();
        int cantidadDeBasesPorLado =2 + (new Random()).nextInt(3);
        this.tamanio=cantidadDeBasesPorLado*2*10;
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
        int fila = 7 + ((new Random()).nextInt(tamanio - 8));
        int columna = ((new Random()).nextInt(fila - 6));
        Base baseUno = new Base(this.tablero[fila][columna]);

        Base baseDos = new Base(this.tablero[columna][fila]);

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
        return this.bases.get(0);
    }
    public Base obtenerBaseDos(){
        return this.bases.get(1);
    }

    public int obtenerTamanio(){
        return tamanio;
    }
}
