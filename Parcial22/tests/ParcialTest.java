package logica;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import excepciones.CoeficienteInvalidoException;
import excepciones.NoCuadraticaException;
import excepciones.RaicesException;

public class ParcialTest {

    private Parcial parcial;

    @BeforeEach
    public void setUp() {
        parcial = new Parcial();
    }

    @Test
    public void testResolverRaicesReales() throws Exception {
        String resultado = parcial.resolver(1.0, -5.0, 6.0);
        assertNotNull(resultado);
        assertTrue(resultado.contains("x1 = 3.0"));
        assertTrue(resultado.contains("x2 = 2.0"));
    }

    @Test
    public void testCalcularRaicesRealesDirecto() throws Exception {

        double[] raices = parcial.calcularRaices(1.0, -5.0, 6.0);
        assertEquals(2, raices.length);
        assertEquals(3.0, raices[0], 0.0001);
        assertEquals(2.0, raices[1], 0.0001);
    }

    @Test
    public void testExcepcionNoCuadratica() {

        NoCuadraticaException exception = assertThrows(NoCuadraticaException.class, () -> {
            parcial.calcularRaices(0.0, 2.0, 1.0);
        });
        assertNotNull(exception.getMessage());
    }

    @Test
    public void testExcepcionRaicesComplejas() {

        RaicesException exception = assertThrows(RaicesException.class, () -> {
            parcial.calcularRaices(1.0, 1.0, 1.0);
        });
        assertTrue(exception.getMessage().contains("discriminante es negativo"));
        assertEquals(-3.0, exception.getDiscriminante(), 0.0001);
    }

    @Test
    public void testExcepcionCoeficienteInvalidoNaN() {

        CoeficienteInvalidoException exception = assertThrows(CoeficienteInvalidoException.class, () -> {
            parcial.calcularRaices(Double.NaN, 2.0, 3.0);
        });
        assertTrue(exception.getMessage().contains("no es un número válido"));
    }

    @Test
    public void testExcepcionCoeficienteInvalidoInfinito() {

        CoeficienteInvalidoException exception = assertThrows(CoeficienteInvalidoException.class, () -> {
            parcial.calcularRaices(1.0, Double.POSITIVE_INFINITY, 3.0);
        });
        assertTrue(exception.getMessage().contains("no es un número válido"));
    }

    @Test
    public void testExcepcionDesbordamientoDiscriminante() {

        CoeficienteInvalidoException exception = assertThrows(CoeficienteInvalidoException.class, () -> {
            parcial.calcularRaices(1e308, 1e308, 1e308);
        });
        assertTrue(exception.getMessage().contains("demasiado grandes"));
    }
}
