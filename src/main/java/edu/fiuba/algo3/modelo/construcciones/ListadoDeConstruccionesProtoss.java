package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;

import java.util.LinkedList;

public class ListadoDeConstruccionesProtoss {
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

    public void nuevoTurno(ListadoDeRecursos recursos){
        for (ConstruccionProtoss construccion: construcciones){
            construccion.nuevoTurno();  //delegar recursos y que se vayan acumulando en caso de producir
        }
    }

    public int size() {
        return this.construcciones.size();
    }

    /*public void destruir (ConstruccionProtoss construccionADestruir, int maximoSuministro) {
        for (ConstruccionProtoss construccion : this.construcciones) {
            if (construccion.getClass() == construccionADestruir.getClass()) {
                construccion.destruir();
            }
            if (construccion.getClass() == Pilon.class){
                maximoSuministro = maximoSuministro - 5 ;
            }
        }
    }*/
    public int destruir (ConstruccionProtoss construccionADestruir, int maximoSuministro) {
        int i = maximoSuministro;
        for (ConstruccionProtoss construccion : this.construcciones) {
            if (construccion.getClass() == construccionADestruir.getClass()) {
                construccion.destruir();
            }
            if (construccion.getClass() == Pilon.class){
                i -= 5 ;
            }
        }
        return i;
    }
}
