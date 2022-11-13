package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Tablero {
    private Casillero[][] tablero;

    public Tablero(){
        this.tablero = new Casillero[20][20];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                this.tablero[i][j] = new Casillero(i, j, this);
            }
        }
    }

    public ArrayList<Casillero> obtenerCasilleros(int radio, int fila, int columna){

        ArrayList<Casillero> casilleros = new ArrayList<>();

        for (int i = fila - radio; i <= fila + radio; i++) {
            if(! (i < 0 || i > 20)){
                for (int j = columna - radio; j <= columna + radio; j++) {
                    if(! (j < 0 || j > 20)){
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
}
