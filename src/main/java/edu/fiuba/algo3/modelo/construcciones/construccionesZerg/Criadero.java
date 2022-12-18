package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.recursos.Nodo;
import edu.fiuba.algo3.modelo.mapa.Casillero;

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
        this.recursosNecesarios.agregar(new Mineral(100));
        this.rangoMoho = 4;
        this.vida = 500;
        this.vidaMaxima = 500;
    }
    public int larvasRestantes() {
        return this.larvas;
    }
    public Zangano engendrarZangano(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Zangano)this.engendrar(new Zangano(), recursos);
    }
    public void nuevoTurno(Raza raza){
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
    private UnidadZerg engendrar(UnidadZerg unidad, ListadoDeRecursos recursos) throws EdificioNoEstaOperativo{
        if (turnos < this.turnosParaConstruirse){
            throw new EdificioNoEstaOperativo();
        }

        unidad.construir(this.ubicacion, recursos);
        this.larvas--;

        return unidad;
    }
    public void expandirMoho(){
        ArrayList<Casillero> casillerosInfectados = new ArrayList<>(this.ubicacion.obtenerCasilleros(this.rangoMoho));

        for (Casillero casillero: casillerosInfectados) {
            if (casillero.puedeMoverse(new AreaTerrestre()))
                casillero.setEspacioDeConstruccion(new Moho());

        }
    }
    public AmoSupremo engendrarAmoSupremo(ListadoDeRecursos recursos) {
        return (AmoSupremo) this.engendrar(new AmoSupremo(), recursos);
    }
    public Mutalisco engendrarMutalisco(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Mutalisco) this.engendrar(new Mutalisco(), recursos);
    }
    public Hidralisco engendrarHidralisco(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Hidralisco) this.engendrar(new Hidralisco(), recursos);
    }
    public Zerling engendrarZerling(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Zerling) this.engendrar(new Zerling(), recursos);
    }
}
