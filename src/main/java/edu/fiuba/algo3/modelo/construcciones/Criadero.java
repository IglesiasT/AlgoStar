package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.unidades.Mutalisco;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.Zangano;
import edu.fiuba.algo3.modelo.recursos.SinRecurso;
import edu.fiuba.algo3.modelo.tablero.Casillero;

import java.util.ArrayList;

public class Criadero extends ConstruccionZerg {
    private int rangoMoho;
    private int maximoDeLarvas;
    private int larvas;
    private int turnos;

    public Criadero (){
        super();
        this.maximoDeLarvas = 3;
        this.larvas = this.maximoDeLarvas;
        this.turnosParaConstruirse = 4;
        this.mineralNecesarioParaConstruir = 50;
        this.rangoMoho = 4;
        this.vida = 500;
    }

    public int larvasRestantes() {
        return this.larvas;
    }

    public Zangano engendrarZangano() throws EdificioNoEstaOperativo {
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        this.larvas--;
        return new Zangano();
    }

    public void nuevoTurno(){
        super.nuevoTurno();

        this.turnos++;
        if (this.larvas < this.maximoDeLarvas){
            this.larvas++;
        }

        if (this.turnos % 2 == 0 && this.turnos >= this.turnosParaConstruirse){
            this.rangoMoho++;
            this.expandirMoho();
        }
    }

    @Override
    public boolean sePuedeConstruirEn(Casillero casillero) {
        return (casillero.contiene(new SinRecurso()));
    }
    public void expandirMoho(){
        ArrayList<Casillero> casillerosInfectados = new ArrayList<>(this.ubicacion.obtenerCasilleros(this.rangoMoho));

        for (Casillero casillero: casillerosInfectados) {
            casillero.setEspacioDeConstruccion(new Moho());

        }
    }

    public Mutalisco engendrarMutalisco() throws EdificioNoEstaOperativo {
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }
        this.larvas--;
        return new Mutalisco();
    }


}
