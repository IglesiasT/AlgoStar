package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.recursos.Gas;

public interface ProductorDeGas {
    void producirGas();
    Gas obtenerGasProducido();
}
