package edu.fiuba.algo3.modelo;

public class Extractor extends ConstruccionZerg{
    private int gasProducido;
    private int capacidadMaximaDeZanganos;
    private int zanganosAsignados;
    public Extractor(){
        this.turnosParaConstruirse = 6;
        this.capacidadMaximaDeZanganos = 3;
        this.zanganosAsignados = 0;
        this.gasProducido = 0;
        this.mineralNecesarioParaConstruir = 100;
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero){
        return (casillero.contiene(new Gas()) && casillero.contiene(new Moho()));
    }

    public void nuevoTurno(){
        super.nuevoTurno();
        if (this.turnos >= turnosParaConstruirse ){
            this.producirGas();
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

    public int obtenerGasProducido() throws EdificioNoEstaOperativo{
        if(this.turnos < turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return this.gasProducido;

    }
    public GasProducido obtenerGasProducido2() throws EdificioNoEstaOperativo{
        if(this.turnos < turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        return new GasProducido(this.gasProducido);

    }
}
