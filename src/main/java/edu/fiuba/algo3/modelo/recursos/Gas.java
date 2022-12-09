package edu.fiuba.algo3.modelo.recursos;

import java.util.Objects;

public class Gas {
    private int gasProducido;

    public Gas(int gasProducido) {
        this.gasProducido = gasProducido;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gas that = (Gas) o;
        return gasProducido == that.gasProducido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gasProducido);
    }
}
