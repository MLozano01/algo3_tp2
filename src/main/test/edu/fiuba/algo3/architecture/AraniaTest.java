package edu.fiuba.algo3.architecture;

import edu.fiuba.algo3.modelo.Arania;
import edu.fiuba.algo3.modelo.Jugador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AraniaTest {
    @Test
    public void Test01UnaAraniaComienzaEnUnEstadoValido() {
        Arania arania = new Arania();

        assertEquals(arania.Vida(), 2);
    }

    @Test
    public void Test02UnaAraniaRecibeElDanioCorrecto() {
        Jugador jugador = new Jugador(20, 100);

        Arania arania = new Arania();

        arania.recibirDanio(1, jugador);
        assertEquals(arania.Vida(), 1);
    }

    //TODO: test03 se puede testear el metodo destruir?
}