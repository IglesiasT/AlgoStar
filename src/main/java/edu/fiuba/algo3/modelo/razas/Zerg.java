package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.LinkedList;

public class Zerg extends Raza{
    private ListadoDeConstruccionesZerg construccionesRealizadas;
    private LinkedList<UnidadZerg> unidadesEngendradas;
    public Zerg(){
        super();
        this.construccionesRealizadas = new ListadoDeConstruccionesZerg();
        this.unidadesEngendradas = new LinkedList<>();
    }

    public Zerg(int mineralInicial, int gasInicial){
        super(mineralInicial, gasInicial);
        this.construccionesRealizadas = new ListadoDeConstruccionesZerg();
        this.unidadesEngendradas = new LinkedList<>();
    }

    private void construir(ConstruccionZerg construccion, Casillero casilleroAConstruir){

        construccion.construir(casilleroAConstruir, this.recursos);
        this.construccionesRealizadas.agregar(construccion);
    }

    public void nuevoTurno(){
        this.construccionesRealizadas.nuevoTurno(this.recursos);
        for (UnidadZerg unidad : this.unidadesEngendradas) {    //delegar for en nueva clase ListadoUnidades
            unidad.nuevoTurno();
        }
    }
    public void construirCriadero(Casillero casilleroAConstruir){
        this.construir(new Criadero(), casilleroAConstruir);
    }

    public void construirExtractor(Casillero casilleroAConstruir) {
        this.construir(new Extractor(), casilleroAConstruir);
    }

    public ReservaDeReproduccion construirReservaDeReproduccion(Casillero casilleroAConstruir){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();
        this.construir(reserva, casilleroAConstruir);
        return reserva;
    }

    public void construirGuarida(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new ReservaDeReproduccion())){
            throw new ConstruccionPreviaNoConstruida();
        }

        this.construir(new Guarida(), casilleroAConstruir);
    }

    public void construirEspiral(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contiene(new Guarida())){
            throw new ConstruccionPreviaNoConstruida();
        }

        this.construir(new Espiral(), casilleroAConstruir);
    }

    public Mutalisco engendrarMutalisco(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new Espiral())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Mutalisco mutalisco = criaderoAUsar.engendrarMutalisco(this.recursos);

        if ((suministro + mutalisco.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.unidadesEngendradas.add(mutalisco);
        this.suministro = mutalisco.consumirSuministro(this.suministro) ;

        return mutalisco;
    }

    public Hidralisco engendrarHidralisco(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new Guarida())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Hidralisco hidralisco = criaderoAUsar.engendrarHidralisco(this.recursos);

        if ((suministro + hidralisco.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.suministro = hidralisco.consumirSuministro(this.suministro) ;
        this.unidadesEngendradas.add(hidralisco);

        return hidralisco;
    }

    public Zerling engendrarZerling(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new ReservaDeReproduccion())){
            throw new ConstruccionPreviaNoConstruida();
        }

        Zerling zerling = criaderoAUsar.engendrarZerling(this.recursos);

        if ((suministro + zerling.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.suministro = zerling.consumirSuministro(this.suministro) ;
        this.unidadesEngendradas.add(zerling);

        return zerling;
    }

//    public Guardian evolucionarMutalisco(Mutalisco mutaliscoAEvolucionar){
//        Guardian unidad = new Guardian();
//        if(!unidad.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
//            throw new NoSePuedeEngendrar();
//        }
//        unidad = mutaliscoAEvolucionar.evolucionar();
        //esto lo deberia hacer el mutalisco creo
//        this.unidadesEngendradas.remove(mutaliscoAEvolucionar);
//        this.unidadesEngendradas.add(unidad);

//        return unidad;
//    }

    public void evolucionarMutaliscoAGuardian(Mutalisco mutaliscoAEvolucionar){
        mutaliscoAEvolucionar.evolucionarAGuardian(recursos);
    }
    public void evolucionarMutaliscoADevorador(Mutalisco mutaliscoAEvolucionar){
        mutaliscoAEvolucionar.evolucionarADevorador(recursos);
    }

    public int construcciones() {
        return construccionesRealizadas.size();
    }
}
