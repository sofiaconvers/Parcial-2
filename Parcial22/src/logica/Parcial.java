package logica;

import excepciones.CoeficienteInvalidoException;
import excepciones.NoCuadraticaException;
import excepciones.RaicesException;

public class Parcial {
	
	public String resolver(double a, double b, double c) 
			throws CoeficienteInvalidoException, NoCuadraticaException, RaicesException {
	    double[] raices = calcularRaices(a, b, c);
	    return "x1 = " + raices[0] + ", x2 = " + raices[1];
	}
	
	public double[] calcularRaices(double a, double b, double c)
	        throws CoeficienteInvalidoException, NoCuadraticaException, RaicesException {

	    validarNumero(a, "a");
	    validarNumero(b, "b");
	    validarNumero(c, "c");

	    if (a == 0) {
	        throw new NoCuadraticaException();
	    }

	    double discriminante = b * b - 4 * a * c;
	    if (Double.isNaN(discriminante) || Double.isInfinite(discriminante)) {
	        throw new CoeficienteInvalidoException(
	                "Los valores son demasiado grandes: el cálculo del discriminante se desbordó.");
	    }

	    if (discriminante < 0) {
	        throw new RaicesException(discriminante);
	    }

	    double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
	    double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);

	    return new double[] { x1, x2 };
	}
	
	private void validarNumero(double valor, String nombre) throws CoeficienteInvalidoException {
		if (Double.isNaN(valor) || Double.isInfinite(valor)) {
			throw new CoeficienteInvalidoException(
					"El coeficiente '" + nombre + "' no es un número válido.");
		}
		
	}
	
}
