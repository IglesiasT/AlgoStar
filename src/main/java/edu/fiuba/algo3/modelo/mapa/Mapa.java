package edu.fiuba.algo3.modelo.mapa;

import edu.fiuba.algo3.modelo.areas.*;
import java.util.ArrayList;
import java.util.Random;

public class Mapa {
    public static final int FILAS = 20;
    public static final int COLUMNAS = 20;
    private Casillero[][] tablero;

    private Base baseUno;
    private Base baseDos;

    public Mapa(){
        this.tablero = new Casillero[20][20];
        for (int i = 0; i < 20; i++){
            for (int j = 0; j < 20; j++){
                this.tablero[i][j] = new Casillero(new AreaTerrestre(), i, j, this);
            }
        }
        cargarBases();
    }

    private void cargarBases(){
        int filaUno = (int)((new Random()).nextDouble() * 5 + 0);
        int columnaUno = (int)((new Random()).nextDouble() * 5 + 0);
        this.baseUno = new Base(this.tablero[filaUno][columnaUno]);

        int filaDos = 19 - filaUno;
        int columnaDos = 19 - columnaUno;
        this.baseDos = new Base(this.tablero[filaDos][columnaDos]);
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

    public Base obtenerBaseUno(){
        return baseUno;
    }
    public Base obtenerBaseDos(){
        return baseDos;
    }
}
