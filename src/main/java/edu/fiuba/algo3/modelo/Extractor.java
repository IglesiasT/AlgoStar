package edu.fiuba.algo3.modelo;

public class Extractor extends GeneradorDeGas{
    private int capacidadMaximaDeZanganos;
    private int zanganosAsignados;
    public Extractor(){
        this.turnosParaSerConstruido = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = 0;
    }

    @Override
    public void recibirDanio(int danioInflingido) {
        this.vida -= danioInflingido;
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos >= turnosParaSerConstruido ){
            this.producirGas();
        }

        this.regenerar();
    }

    protected void regenerar(){
        if (this.vida < 100){
            this.vida += 5;
        }
    }

    protected void producirGas(){
        this.gasProducido += this.zanganosAsignados * 10;
    }

    public void asignarZangano() throws MaximoDeZanganosAsignados{
        if (this.zanganosAsignados >= this.capacidadMaximaDeZanganos){
            throw new MaximoDeZanganosAsignados();
        }
        this.zanganosAsignados++;
    }
}
