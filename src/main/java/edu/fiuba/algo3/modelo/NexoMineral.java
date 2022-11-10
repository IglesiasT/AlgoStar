package edu.fiuba.algo3.modelo;

public class NexoMineral extends Construccion {
    int turnos;
    private int produccionPorTurno;

    public NexoMineral(){
        this.produccionPorTurno = 20;
        this.turnos = 0;
        this.turnosParaConstruirse = 4;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Mineral()) && !casillero.contiene(new Moho()));
    }

    @Override
    public void recibirDanio(int danioInflingido) {

    }

    @Override
    protected void regenerar() {

    }

    public int recolectarMineral(){
        if (this.turnos < this.turnosParaConstruirse ){
            throw new EdificioNoEstaOperativo();
        }
        return produccionPorTurno;
    }

    public void nuevoTurno(){
        this.turnos++;
    }
}
