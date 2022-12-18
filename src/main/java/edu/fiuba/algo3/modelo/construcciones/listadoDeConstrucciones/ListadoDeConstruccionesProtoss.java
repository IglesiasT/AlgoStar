package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.ConstruccionProtoss;
import edu.fiuba.algo3.modelo.construcciones.construccionesProtoss.Pilon;
import edu.fiuba.algo3.modelo.razas.Protoss;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListadoDeConstruccionesProtoss implements ListadoDeConstrucciones {
    private LinkedList<ConstruccionProtoss> construcciones;
    public ListadoDeConstruccionesProtoss(){
        this.construcciones = new LinkedList<>();
    }
    public void agregar(ConstruccionProtoss construccion){
        this.construcciones.add(construccion);
    }
    public boolean contiene(ConstruccionProtoss construccionBuscada) {
        for (ConstruccionProtoss construccion : this.construcciones) {
            if (construccion.getClass() == construccionBuscada.getClass()) {
                return true;
            }
        }
        return false;
    }
    public void nuevoTurno(Raza raza){
        for (ConstruccionProtoss construccion: construcciones){
            construccion.nuevoTurno(raza);  //delegar recursos y que se vayan acumulando en caso de producir
        }
    }
    public int size() {
        return this.construcciones.size();
    }
    public int destruir (ConstruccionProtoss construccionADestruir, int maximoSuministro) {

        construccionADestruir.destruir();
        construcciones.remove(construccionADestruir);

        if (construccionADestruir.getClass() == Pilon.class){
            maximoSuministro -= 5 ;
        }

        return maximoSuministro;
    }
    public List<Construccion> obtenerConstrucciones(){
        return new LinkedList<>(construcciones);
    }

    public void eliminarConstruccionesDestruidas(Protoss raza){
        for (ConstruccionProtoss construccion: construcciones){
            if (construccion.obtenerVida()<=0){
                raza.destruir(construccion);
            }
        }
    }
}
