package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.tablero.Casillero;

import java.util.LinkedList;

public class Zerg extends Raza{
    private LinkedList<ConstruccionZerg> construccionesRealizadas;
    public Zerg(){
        super();
        this.construccionesRealizadas = new LinkedList<>();
    }

    public Zerg(int mineralInicial, int gasInicial){
        super();
        this.cantidadDeMineral = mineralInicial;
        this.cantidadDeGas = gasInicial;
        this.construccionesRealizadas = new LinkedList<>();
    }

    public void construir(ConstruccionZerg construccion, Casillero casilleroAConstruir){

        if(!construccion.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
            throw new NoSePuedeConstruir();
        }

        construccion.construirEnCasillero(casilleroAConstruir);

        //Se pudo construir
        construccion.consumirMineral(this.cantidadDeMineral);
        construccion.consumirGas(this.cantidadDeGas);
        this.construccionesRealizadas.add(construccion);
    }
    public void construirCriadero(Casillero casilleroAConstruir){
        Criadero criadero = new Criadero();

        this.construir(criadero, casilleroAConstruir);
    }

    public void construirExtractor(Casillero casilleroAConstruir) {
        Extractor extractor = new Extractor();

        this.construir(extractor, casilleroAConstruir);
    }

    public void construirReservaDeProduccion(Casillero casilleroAConstruir){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        this.construir(reserva, casilleroAConstruir);
    }

    public void construirGuarida(Casillero casilleroAConstruir){
        Guarida guarida = new Guarida();

        this.construir(guarida, casilleroAConstruir);
    }

    public void construirEspiral(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionZerg construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Guarida.class ) {
                flag = true;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }

        Espiral espiral = new Espiral();

        this.construir(espiral, casilleroAConstruir);
    }
}
