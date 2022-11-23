package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.NoSePuedeEngendrar;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.*;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.LinkedList;

public class Zerg extends Raza{
    private LinkedList<ConstruccionZerg> construccionesRealizadas;
    private LinkedList<UnidadZerg> unidadesEngendradas;
    public Zerg(){
        super();
        this.construccionesRealizadas = new LinkedList<>();
        this.unidadesEngendradas = new LinkedList<>();
    }

    public Zerg(int mineralInicial, int gasInicial){
        super(mineralInicial, gasInicial);
        this.construccionesRealizadas = new LinkedList<>();
        this.unidadesEngendradas = new LinkedList<>();
    }

    private void construir(ConstruccionZerg construccion, Casillero casilleroAConstruir){

        construccion.construir(casilleroAConstruir, this.recursos);
        this.construccionesRealizadas.add(construccion);
    }

    public void nuevoTurno(){
        LinkedList<ConstruccionZerg> construccionesTotales = new LinkedList<>();
        construccionesTotales.addAll(this.construccionesRealizadas);
        construccionesTotales.addAll(this.unidadesEngendradas);
        for (ConstruccionZerg construccion: construccionesTotales){
            construccion.nuevoTurno();
        }
    }
    public void construirCriadero(Casillero casilleroAConstruir){
        this.construir(new Criadero(), casilleroAConstruir);
    }

    public void construirExtractor(Casillero casilleroAConstruir) {
        Extractor extractor = new Extractor();

        this.construir(extractor, casilleroAConstruir);
    }

    public void construirReservaDeReproduccion(Casillero casilleroAConstruir){
        ReservaDeReproduccion reserva = new ReservaDeReproduccion();

        this.construir(reserva, casilleroAConstruir);
    }

    public void construirGuarida(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionZerg construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == ReservaDeReproduccion.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }
        Guarida guarida = new Guarida();

        this.construir(guarida, casilleroAConstruir);
    }

    public void construirEspiral(Casillero casilleroAConstruir){
        if (! this.construccionesRealizadas.contains(new Guarida())){
            throw new NoSePuedeConstruir();
        }

        this.construir(new Espiral(), casilleroAConstruir);
    }

    public Mutalisco engendrarMutalisco(Criadero criaderoAUsar){
        boolean flag = false;
        for (ConstruccionZerg construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Espiral.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeEngendrar();
        }
        Mutalisco unidad = new Mutalisco();
//        if(!unidad.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
//            throw new NoSePuedeConstruir();
//        }
//        unidad = criaderoAUsar.engendrarMutalisco();
//
//        //Se pudo engendrar
//        this.unidadesEngendradas.add(unidad);
//        this.cantidadDeMineral = unidad.consumirMineral(this.cantidadDeMineral);
//        this.cantidadDeGas = unidad.consumirGas(this.cantidadDeGas);



        return unidad;
    }

    public Hidralisco engendrarHidralisco(Criadero criaderoAUsar){
        boolean flag = false;
        for (ConstruccionZerg construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Guarida.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeEngendrar();
        }
        Hidralisco unidad = new Hidralisco();
//        if(!unidad.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
//            throw new NoSePuedeConstruir();
//        }
//        unidad = criaderoAUsar.engendrarHidralisco();
//
//        //Se pudo engendrar
//        this.unidadesEngendradas.add(unidad);
//        this.cantidadDeMineral = unidad.consumirMineral(this.cantidadDeMineral);
//        this.cantidadDeGas = unidad.consumirGas(this.cantidadDeGas);

        return unidad;
    }

    public Zerling engendrarZerling(Criadero criaderoAUsar){
        boolean flag = false;
        for (ConstruccionZerg construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == ReservaDeReproduccion.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeEngendrar();
        }
        Zerling unidad = new Zerling();
//        if(!unidad.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
//            throw new NoSePuedeConstruir();
//        }
//        unidad = criaderoAUsar.engendrarZerling();
//
//        //Se pudo engendrar
//        this.unidadesEngendradas.add(unidad);
//        this.cantidadDeMineral = unidad.consumirMineral(this.cantidadDeMineral);
//        this.cantidadDeGas = unidad.consumirGas(this.cantidadDeGas);

        return unidad;
    }

    public Guardian evolucionarMutalisco(Mutalisco mutaliscoAEvolucionar){
        Guardian unidad = new Guardian();
//        if(!unidad.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
//            throw new NoSePuedeEngendrar();
//        }
        unidad = mutaliscoAEvolucionar.evolucionar();
        //esto lo deberia hacer el mutalisco creo
        this.unidadesEngendradas.remove(mutaliscoAEvolucionar);
        this.unidadesEngendradas.add(unidad);

        return unidad;
    }
}
