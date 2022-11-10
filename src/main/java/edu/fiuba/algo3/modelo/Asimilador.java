package edu.fiuba.algo3.modelo;

public class Asimilador extends GeneradorDeGas{

    public Asimilador(){
        this.turnosParaSerConstruido = 6;
    }

    @Override
    public void recibirDanio(int danioInflingido) {

    }

    @Override
    protected void regenerar() {

    }

    public void nuevoTurno(){   //Solucionar
        this.turnos++;
        if (this.turnos >= turnosParaSerConstruido ){
            this.producirGas();
        }
    }

    protected void producirGas(){
        this.gasProducido += 20;
    }
}
