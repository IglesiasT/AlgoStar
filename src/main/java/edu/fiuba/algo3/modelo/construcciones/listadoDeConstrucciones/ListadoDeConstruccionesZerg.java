package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

import java.util.LinkedList;

public class ListadoDeConstruccionesZerg {
    private LinkedList<ConstruccionZerg> construcciones;

    public ListadoDeConstruccionesZerg(){
        this.construcciones = new LinkedList<>();
    }

    public void agregar(ConstruccionZerg construccion){
        this.construcciones.add(construccion);
    }

    public boolean contiene(ConstruccionZerg construccionBuscada) {
        for (ConstruccionZerg construccion : this.construcciones) {
            if (construccion.getClass() == construccionBuscada.getClass()) {
                return true;
            }
        }
        return false;
    }

    public void nuevoTurno(ListadoDeRecursos recursos){
        for (ConstruccionZerg construccion: construcciones){
            construccion.nuevoTurno();  //delegar recursos y que se vayan acumulando en caso de producir
        }
    }

    public int size() {
        return this.construcciones.size();
    }

    public void destruir (ConstruccionZerg construccionADestruir) {
        for (ConstruccionZerg construccion : this.construcciones) {
            if (construccion.getClass() == construccionADestruir.getClass()) {
                construccion.destruir();
            }
        }
    }
}
