package edu.fiuba.algo3.modelo.construcciones.listadoDeConstrucciones;
import edu.fiuba.algo3.modelo.construcciones.Construccion;
import edu.fiuba.algo3.modelo.razas.Raza;
import edu.fiuba.algo3.modelo.recursos.ListadoDeRecursos;
import java.util.LinkedList;
import java.util.List;

public abstract class ListadoDeConstrucciones {
    protected LinkedList<Construccion> construcciones;

    public ListadoDeConstrucciones(){
        this.construcciones = new LinkedList<>();
    }

    public void agregar(Construccion construccion){
        this.construcciones.add(construccion);
    }

    public boolean contiene(Construccion construccionBuscada) {
        for (Construccion construccion : this.construcciones) {
            if (construccion.getClass() == construccionBuscada.getClass() && construccion.activa()) {
                return true;
            }
        }
        return false;
    }


    public void nuevoTurno(Raza raza){
        for (Construccion construccion: construcciones){
            construccion.nuevoTurno(raza);  //delegar recursos y que se vayan acumulando en caso de producir
        }
    }

    public int size() {
        return this.construcciones.size();
    }

    public int destruir(Construccion construccionADestruir, int maximoSuministro) {
        return maximoSuministro;
    }
    public List<Construccion> obtenerConstrucciones(){
        return new LinkedList<>(construcciones);
    }

    public void eliminarConstruccionesDestruidas(Raza raza){
        for (Construccion construccion: construcciones){
            if (construccion.obtenerVida()<=0){
                raza.destruir(construccion);
            }
        }
    }
}

