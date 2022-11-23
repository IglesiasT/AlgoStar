package edu.fiuba.algo3.modelo.construcciones;

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
}
