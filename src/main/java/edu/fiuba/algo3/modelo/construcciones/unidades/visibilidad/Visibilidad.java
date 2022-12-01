package edu.fiuba.algo3.modelo.construcciones.unidades.visibilidad;


public interface Visibilidad {
    void recibirDanio(int danioInflingido);

    int obtenerEscudo();

    Visibilidad hacerVisible();

    Visibilidad hacerInvisible();

    int obtenerVida();
}
