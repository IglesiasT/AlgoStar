package edu.fiuba.algo3.modelo;

public class RangoPilon extends EspacioDeConstruccion{
    //MODIFICAR
    public void construirEdificioZerg(Construccion construccion, Recurso recurso) throws NoSePuedeConstruir{
        throw new NoSePuedeConstruir();
    }

    public void construirEdificioProtoss(Construccion construccion, Recurso recurso){
        recurso.construirEdificio(construccion);
    }


}
