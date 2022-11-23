package edu.fiuba.algo3.modelo.razas;

import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.construcciones.*;
import edu.fiuba.algo3.modelo.construcciones.unidades.Dragon;
import edu.fiuba.algo3.modelo.construcciones.unidades.Scout;
import edu.fiuba.algo3.modelo.construcciones.unidades.Zealot;
import edu.fiuba.algo3.modelo.mapa.Casillero;

import java.util.LinkedList;

public class Protoss extends Raza{
    private LinkedList<ConstruccionProtoss> construccionesRealizadas;
    public Protoss(){
        super();
        this.construccionesRealizadas = new LinkedList<>();
    }

    public Protoss(int mineralInicial, int gasInicial){
        super(mineralInicial, gasInicial);
        this.construccionesRealizadas = new LinkedList<>();
    }

    public void nuevoTurno(){
        for (ConstruccionProtoss construccion: construccionesRealizadas){
            construccion.nuevoTurno();
        }
    }

    private void construir(ConstruccionProtoss construccion, Casillero casilleroAConstruir){

        construccion.construir(casilleroAConstruir, this.recursos);
        this.construccionesRealizadas.add(construccion);
    }
    public void construirPilon(Casillero casilleroAConstruir){
        Pilon pilon = new Pilon();

        this.construir(pilon, casilleroAConstruir);
    }

    public void construirNexoMineral(Casillero casilleroAConstruir) {
        NexoMineral nexo = new NexoMineral();

        this.construir(nexo, casilleroAConstruir);
    }

    public void construirAsimilador(Casillero casilleroAConstruir) {
        this.construir(new Asimilador(), casilleroAConstruir);
    }

    public void construirAcceso(Casillero casilleroAConstruir){
        Acceso acceso = new Acceso();

        this.construir(acceso, casilleroAConstruir);
    }

    public void construirPuertoEstelar(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionProtoss construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Acceso.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }

        PuertoEstelar puertoEstelar = new PuertoEstelar();

        this.construir(puertoEstelar, casilleroAConstruir);
    }
    public Zealot construirZealot(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionProtoss construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Acceso.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }

        Zealot zealot = new Zealot();

        this.construir(zealot, casilleroAConstruir);
        return zealot;
    }

    public Dragon construirDragon(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionProtoss construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == Acceso.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }

        Dragon dragon = new Dragon();

        this.construir(dragon, casilleroAConstruir);
        return dragon;
    }

    public Scout construirScout(Casillero casilleroAConstruir){
        boolean flag = false;
        for (ConstruccionProtoss construccion : this.construccionesRealizadas) {
            if (construccion.getClass() == PuertoEstelar.class) {
                flag = true;
                break;
            }

        }
        if (! flag){
            throw new NoSePuedeConstruir();
        }

        Scout scout = new Scout();

        this.construir(scout, casilleroAConstruir);
        return scout;
    }
}
