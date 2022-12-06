package edu.fiuba.algo3.modelo.recursos;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Gas extends Recurso{

    public Gas(){
        super();
        setText("Δ");
        setFill(Color.RED);
        setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        this.cantidad = 5000;
    }
    public Gas(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
