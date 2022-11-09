package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Casillero;
import edu.fiuba.algo3.modelo.NoSePuedeConstruir;
import edu.fiuba.algo3.modelo.Zerg;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ZergTest {

    @Test
    public void sinRecursosNoSePuedeConstruir(){
        //Arrange
        Zerg razaZerg = new Zerg();
        Casillero casilleroAConstruir1 = new Casillero();
        Casillero casilleroAConstruir2 = new Casillero();

        //Act
        razaZerg.construir("Criadero", casilleroAConstruir1);
        razaZerg.construir("Criadero", casilleroAConstruir2);   //Se gastan todos los recursos

        //Assert
        assertThrows(NoSePuedeConstruir.class, () -> razaZerg.construir("Criadero", casilleroAConstruir1));
    }
}
