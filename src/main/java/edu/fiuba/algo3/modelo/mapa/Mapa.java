package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.areas.*;
import java.util.ArrayList;

public class Mapa {
    private Casillero[][] tablero;

    public Mapa(){
        this.tablero = new Casillero[20][20];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                this.tablero[i][j] = new Casillero(new AreaTerrestre(), i, j, this);
            }
        }
    }

    public ArrayList<?extends Casillero> obtenerCasilleros(int radio, int fila, int columna){

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