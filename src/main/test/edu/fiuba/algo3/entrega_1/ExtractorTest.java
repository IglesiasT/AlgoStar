package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.EdificioNoEstaOperativo;
import edu.fiuba.algo3.modelo.Extractor;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExtractorTest {

    @Test
    public void extractorNoEstaOperativoAntesDeSeisTurnos(){
        //Arrange
        Extractor extractor = new Extractor();

        //Act
        extractor.nuevoTurno();
        extractor.nuevoTurno();
        extractor.nuevoTurno();

        //Assert
        assertThrows(EdificioNoEstaOperativo.class, extractor::obtenerGasProducido);
    }
}
