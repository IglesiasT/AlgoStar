package edu.fiuba.algo3.modelo.recursos;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class Mineral extends Recurso{
    public Mineral(){
        super();
        setText("❖");
        setFill(Color.BLACK);
        setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        this.cantidad = 2000;
    }

    public Mineral(int cantidad){
        super();
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        return this.getClass() == o.getClass();
    }
}
