package edu.fiuba.algo3.modelo;

public class Asimilador extends ConstruccionProtoss{
    private int gasProducido;
    private int produccionPorTurno;

    public Asimilador(){
        super();
        this.gasProducido = 0;
        this.turnosParaConstruirse = 6;
        this.mineralNecesarioParaConstruir = 100;
        this.produccionPorTurno = 20;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new Gas()) && !casillero.contiene(new Moho()));
    }

    public void nuevoTurno(){
        this.turnos++;
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
        }
    }

    public int obtenerGasProducido(){ return this.gasProducido;}

    protected void producirGas(){
        this.gasProducido += this.ubicacion.obtenerRecurso().recolectar(this.produccionPorTurno);
    }
}
