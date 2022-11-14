package edu.fiuba.algo3.modelo;

import java.util.Objects;

public class GasProducido {
    private int gasProducido;

    public GasProducido(int gasProducido) {
        this.gasProducido = gasProducido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GasProducido that = (GasProducido) o;
        return gasProducido == that.gasProducido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasProducido);
    }
}
