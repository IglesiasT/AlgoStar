package edu.fiuba.algo3.modelo.areas;
import edu.fiuba.algo3.modelo.Visitante;
import edu.fiuba.algo3.modelo.construcciones.Construccion;

public interface Area {
    void aceptar(Visitante visitante, Construccion construccionAAtacar);

}
