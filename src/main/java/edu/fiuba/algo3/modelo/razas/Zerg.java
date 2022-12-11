package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones.ListadoDeConstruccionesZerg;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesProtoss.AmoSupremo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.LinkedList;

public class Zerg extends Raza{
    private ListadoDeConstruccionesZerg construccionesRealizadas;
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
        for (Unidad unidad : this.unidadesEngendradas) {    //delegar for en nueva clase ListadoUnidades
            unidad.nuevoTurno();
        }
    }
    public void construirCriadero(Casillero casilleroAConstruir){
        this.construir(new Criadero(), casilleroAConstruir);
        this.maximoSuministro = this.maximoSuministro +5;
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
    public AmoSupremo engendrarAmoSupremo(Criadero criaderoAUsar) {
        if ((suministro + (new AmoSupremo()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }
        AmoSupremo amoSupremo = criaderoAUsar.engendrarAmoSupremo(this.recursos);
        this.unidadesEngendradas.add(amoSupremo);
        this.suministro = amoSupremo.consumirSuministro(this.suministro) ;
        this.maximoSuministro = this.maximoSuministro + 5 ;
        return amoSupremo;
    }
    public Zangano engendrarZangano(Criadero criaderoAUsar) {
        if ((suministro + (new Zangano()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        Zangano zangano = criaderoAUsar.engendrarZangano(this.recursos);
        this.unidadesEngendradas.add(zangano);

        this.suministro = zangano.consumirSuministro(this.suministro) ;

        return zangano;
    }
    public Mutalisco engendrarMutalisco(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new Espiral())){
            throw new ConstruccionPreviaNoConstruida();
        }

        if ((suministro + (new Mutalisco()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        Mutalisco mutalisco = criaderoAUsar.engendrarMutalisco(this.recursos);
        this.unidadesEngendradas.add(mutalisco);
        this.suministro = mutalisco.consumirSuministro(this.suministro) ;

        return mutalisco;
    }
    public Hidralisco engendrarHidralisco(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new Guarida())){
            throw new ConstruccionPreviaNoConstruida();
        }

        if ((suministro + (new Hidralisco()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        Hidralisco hidralisco = criaderoAUsar.engendrarHidralisco(this.recursos);
        this.suministro = hidralisco.consumirSuministro(this.suministro) ;
        this.unidadesEngendradas.add(hidralisco);

        return hidralisco;
    }
    public Zerling engendrarZerling(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new ReservaDeReproduccion())){
            throw new ConstruccionPreviaNoConstruida();
        }

        if ((suministro + (new Zerling()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        Zerling zerling = criaderoAUsar.engendrarZerling(this.recursos);
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
    public int construccionesRealizadas() {
        return construccionesRealizadas.size();
    }
    public void destruir(ConstruccionZerg construccionADestruir){
        this.construccionesRealizadas.destruir(construccionADestruir);
    }
    public void destruir(Criadero construccionADestruir){
        this.construccionesRealizadas.destruir(construccionADestruir);
        this.maximoSuministro = this.maximoSuministro -5 ;
    }
    public void destruir (UnidadZerg unidadZerg) {
        this.unidadesEngendradas.remove(unidadZerg) ;
    }
    public void destruir (AmoSupremo unidadZerg) {
        this.unidadesEngendradas.remove(unidadZerg) ;
        this.maximoSuministro = this.maximoSuministro -5;
    }

}
