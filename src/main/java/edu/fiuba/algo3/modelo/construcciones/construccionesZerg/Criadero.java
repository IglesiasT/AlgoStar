package edu.fiuba.algo3.modelo.construcciones.construccionesZerg;

import edu.fiuba.algo3.modelo.construcciones.NoSePuedeEngendrar;
import edu.fiuba.algo3.modelo.areas.AreaTerrestre;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.*;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.espaciosDeConstruccion.Moho;
import edu.fiuba.algo3.modelo.estados.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import edu.fiuba.algo3.modelo.recursos.Mineral;
import edu.fiuba.algo3.modelo.mapa.Casillero;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

import java.util.ArrayList;
import java.util.LinkedList;
public class Criadero extends ConstruccionZerg {
    private int rangoMoho;
    private int maximoDeLarvas;
    private LinkedList<Larva> larvas;

    public Criadero (){
        super();
        this.maximoDeLarvas = 3;
        this.larvas = new LinkedList<>();

        for (int i = 0 ; i < this.maximoDeLarvas ; i++) {
            this.larvas.add(new Larva());
        }

        this.turnosParaConstruirse = 4;
        this.recursosNecesarios.agregar(new Mineral(100));
        this.rangoMoho = 4;
        this.vida = 500;
        this.vidaMaxima = 500;
    }
    public int larvasRestantes() {
        return this.larvas.size();
    }
    public Zangano engendrarZangano(ListadoDeRecursos recursos) {
        return (Zangano)this.engendrar(new Zangano(), recursos);
    }
    public void nuevoTurno(Raza raza){
        super.nuevoTurno(raza);
        if (this.larvas.size() < this.maximoDeLarvas){
            this.larvas.add(new Larva());
        }

        if (this.turnos % 2 == 0 && activa()){
            this.rangoMoho++;
            this.expandirMoho();
        }
    }
    private UnidadZerg engendrar(UnidadZerg unidad, ListadoDeRecursos recursos){
        estado.jugar();

        if (this.larvas.size() == 0){
            throw new NoSePuedeEngendrar();
        }
        unidad = this.larvas.getFirst().evolucionar(unidad, this.ubicacion, recursos);
        this.larvas.remove();

        return unidad;
    }
    private void expandirMoho(){
        ArrayList<Casillero> casillerosInfectados = new ArrayList<>(this.ubicacion.obtenerCasilleros(this.rangoMoho));
        Casillero aux ;

        for (Casillero casillero: casillerosInfectados) {

            aux = casillero.mover(casillero, new AreaTerrestre());

            if (aux != null){
                casillero.setEspacioDeConstruccion(new Moho());
            }
        }
    }
    public AmoSupremo engendrarAmoSupremo(ListadoDeRecursos recursos) {
        return (AmoSupremo) this.engendrar(new AmoSupremo(), recursos);
    }
    public MutaliscoBase engendrarMutalisco(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (MutaliscoBase) this.engendrar(new MutaliscoBase(), recursos);
    }
    public Hidralisco engendrarHidralisco(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Hidralisco) this.engendrar(new Hidralisco(), recursos);
    }
    public Zerling engendrarZerling(ListadoDeRecursos recursos) throws EdificioNoEstaOperativo {
        return (Zerling) this.engendrar(new Zerling(), recursos);
    }
    @Override
    public void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso){
        visitante.construir(this);
        recurso.visitar (visitante);
    }
}
