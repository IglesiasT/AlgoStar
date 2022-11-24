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
        super();
        this.cantidadDeMineral = mineralInicial;
        this.cantidadDeGas = gasInicial;
        this.construccionesRealizadas = new LinkedList<>();
    }

    public void nuevoTurno(){
        for (ConstruccionProtoss construccion: construccionesRealizadas){
            construccion.nuevoTurno();
        }
    }

    public void construir(ConstruccionProtoss construccion, Casillero casilleroAConstruir){

        if(!construccion.recursosSuficientes(this.cantidadDeMineral, this.cantidadDeGas)){
            throw new NoSePuedeConstruir();
        }

        construccion.construirEnCasillero(casilleroAConstruir);

        //Se pudo construir
        this.cantidadDeMineral = construccion.consumirMineral(this.cantidadDeMineral);
        this.cantidadDeGas = construccion.consumirGas(this.cantidadDeGas);
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
        Asimilador asimilador = new Asimilador();

        this.construir(asimilador, casilleroAConstruir);
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

        if ((suministro + zealot.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }
        this.construir(zealot, casilleroAConstruir);
        this.suministro = zealot.consumirSuministro(this.suministro) ;

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

        if ((suministro + dragon.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.construir(dragon, casilleroAConstruir);
        this.suministro = dragon.consumirSuministro(this.suministro) ;

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

        if ((suministro + scout.consumirSuministro(0)) > this.maximoSuministro) {
            throw new SuministroAgotado() ;
        }

        this.construir(scout, casilleroAConstruir);
        this.suministro = scout.consumirSuministro(this.suministro) ;

        return scout;
    }

    public int construcciones() {
        return construccionesRealizadas.size();
    }
}
