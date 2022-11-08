package edu.fiuba.algo3.modelo;

public class Extractor {
    private int turnos;
    public Extractor(){
        this.turnos = 0;
    }

    public void nuevoTurno(){
        this.turnos++;
    }

    public void obtenerGasProducido() throws EdificioNoEstaOperativo{
        if (this.turnos < 6){
            throw new EdificioNoEstaOperativo();
        }

    }
}
