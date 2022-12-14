package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.construcciones.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.*;
import edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones.ListadoDeConstruccionesZerg;
import edu.fiuba.algo3.modelo.construcciones.unidades.Unidad;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.List;

public class Zerg extends Raza{
    private final ListadoDeConstruccionesZerg construccionesRealizadas;
    public Zerg(){
        super();
        this.construccionesRealizadas = new ListadoDeConstruccionesZerg();
    }
    public Zerg(int mineralInicial, int gasInicial){
        super(mineralInicial, gasInicial);
        this.construccionesRealizadas = new ListadoDeConstruccionesZerg();
    }

    private void construir(ConstruccionZerg construccion, Casillero casilleroAConstruir){

        construccion.construir(casilleroAConstruir, this.recursos);
        this.construccionesRealizadas.agregar(construccion);
    }
    public void nuevoTurno(){
        this.construccionesRealizadas.eliminarConstruccionesDestruidas(this);
        this.construccionesRealizadas.nuevoTurno(this);
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
        this.construccionesRealizadas.agregar(amoSupremo);
        this.suministro = amoSupremo.consumirSuministro(this.suministro) ;
        this.maximoSuministro = this.maximoSuministro + 5 ;
        return amoSupremo;
    }
    public void engendrarZangano(Criadero criaderoAUsar) {
        if ((suministro + (new Zangano()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        Zangano zangano = criaderoAUsar.engendrarZangano(this.recursos);
        this.construccionesRealizadas.agregar(zangano);

        this.suministro = zangano.consumirSuministro(this.suministro) ;
    }
    public MutaliscoBase engendrarMutalisco(Criadero criaderoAUsar){
        if (! this.construccionesRealizadas.contiene(new Espiral())){
            throw new ConstruccionPreviaNoConstruida();
        }

        if ((suministro + (new MutaliscoBase()).consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        MutaliscoBase mutalisco = criaderoAUsar.engendrarMutalisco(this.recursos);
        this.construccionesRealizadas.agregar(mutalisco);
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
        this.construccionesRealizadas.agregar(hidralisco);

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
        this.construccionesRealizadas.agregar(zerling);

        return zerling;
    }
    public void evolucionarMutaliscoAGuardian(MutaliscoBase mutaliscoAEvolucionar){
        mutaliscoAEvolucionar.evolucionarAGuardian(recursos);
    }
    public void evolucionarMutaliscoADevorador(MutaliscoBase mutaliscoAEvolucionar){
        mutaliscoAEvolucionar.evolucionarADevorador(recursos);
    }
    public int construccionesRealizadas() {
        return construccionesRealizadas.size();
    }
    @Override
    public void construir(String construccion, Casillero casillero) {
        if (construccion.contains("Criadero")){ construirCriadero(casillero);}
        else if (construccion.contains("Extractor")){ construirExtractor(casillero);}
        else if (construccion.contains("Reserva de reproduccion")){construirReservaDeReproduccion(casillero);}
        else if (construccion.contains("Espiral")) {construirEspiral(casillero);}
        else if (construccion.contains("Guarida")) {construirGuarida(casillero);}
        else {throw new NoSePuedeConstruir();}
    }
    public void destruir(Construccion construccionADestruir){
        this.construccionesRealizadas.destruir(construccionADestruir);
    }
    public void destruir(Criadero construccionADestruir){
        this.construccionesRealizadas.destruir(construccionADestruir);
        this.maximoSuministro = this.maximoSuministro -5 ;
    }
    public void destruir (AmoSupremo unidadZerg) {
        this.construccionesRealizadas.destruir(unidadZerg) ;
        this.maximoSuministro = this.maximoSuministro -5;
    }
    public void engendrar(String construccion, Casillero casillero) {
        if (construccion.contains("Zangano")){ engendrarZangano((Criadero)casillero.obtenerConstruccion());}
        else if (construccion.contains("Zerling")){ engendrarZerling((Criadero)casillero.obtenerConstruccion());}
        else if (construccion.contains("Mutalisco")){engendrarMutalisco((Criadero)casillero.obtenerConstruccion());}
        else if (construccion.contains("Amo Supremo")) {engendrarAmoSupremo((Criadero)casillero.obtenerConstruccion());}
        else if (construccion.contains("Hidralisco")) {engendrarHidralisco((Criadero)casillero.obtenerConstruccion());}
        else {throw new NoSePuedeConstruir();}
    }
    public void evolucionar(String construccion, MutaliscoBase mutalisco) {
        if (construccion.contains("Guardian")) {evolucionarMutaliscoAGuardian(mutalisco);}
        else if (construccion.contains("Devorador")) {evolucionarMutaliscoADevorador(mutalisco);}
        else {throw new NoSePuedeConstruir();}
    }
    public void atacar(Unidad atacante, Construccion objetivo){((UnidadZerg)atacante).atacar((ConstruccionProtoss)objetivo);}
    @Override
    public List<Construccion> obtenerConstrucciones() {return construccionesRealizadas.obtenerConstrucciones();}
}
