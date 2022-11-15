package edu.fiuba.algo3.modelo.unidades;

import edu.fiuba.algo3.modelo.construcciones.ConstruccionProtoss;

public class Zerling {
    private int danioBase;

    public Zerling(){
        this.danioBase = 4;
    }
    public void atacar(ConstruccionProtoss construccionEnemiga){
        construccionEnemiga.recibirDanio(this.danioBase);
    }
}
