package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.construcciones.Construccion;

public interface Elemento {
    void aceptar(Visitante visitante, Construccion construccionAAtacar);
}
