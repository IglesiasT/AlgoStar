package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;

import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.ConstruccionZerg;
import edu.fiuba.algo3.modelo.construcciones.construccionesZerg.Criadero;
import edu.fiuba.algo3.modelo.construcciones.unidades.unidadesZerg.AmoSupremo;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.razas.Zerg;

import java.util.LinkedList;
import java.util.List;

public class ListadoDeConstruccionesZerg implements ListadoDeConstrucciones{
    private final LinkedList<ConstruccionZerg> construcciones;

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

    public void nuevoTurno(Raza raza){
        for (ConstruccionZerg construccion: construcciones){
            construccion.nuevoTurno(raza);  //delegar recursos y que se vayan acumulando en caso de producir
        }
    }

    public int size() {
        return this.construcciones.size();
    }

    public void destruir (ConstruccionZerg construccionADestruir) {
        construccionADestruir.destruir();
    }
    public List<Construccion> obtenerConstrucciones(){
        return new LinkedList<>(construcciones);
    }

    public void eliminarConstruccionesDestruidas(Zerg raza){
        for (ConstruccionZerg construccion: construcciones){
            if (construccion.obtenerVida()<=0){
                if (construccion.getClass() == Criadero.class)
                    raza.destruir((Criadero) construccion);
                else if (construccion.getClass() == AmoSupremo.class)
                    raza.destruir((AmoSupremo) construccion);
                else raza.destruir(construccion);
            }
        }
    }
}
