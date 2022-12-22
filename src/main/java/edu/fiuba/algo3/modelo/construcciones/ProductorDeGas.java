package edu.fiuba.algo3.modelo.construcciones;

import edu.fiuba.algo3.modelo.espaciosDeConstruccion.EspacioDeConstruccion;
import edu.fiuba.algo3.modelo.recursos.Gas;
import edu.fiuba.algo3.modelo.recursos.Recurso;
import edu.fiuba.algo3.modelo.visitante.VisitanteConstruccion;

public interface ProductorDeGas {
    void producirGas();
    Gas obtenerGasProducido();

    void visitar(VisitanteConstruccion visitante , EspacioDeConstruccion espacio , Recurso recurso);
}
