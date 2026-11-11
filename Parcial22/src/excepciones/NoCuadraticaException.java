package excepciones;

public class NoCuadraticaException extends EcuacionException {
	
	private static final long serialVersionUID = 1L;

	public NoCuadraticaException() {
		super("El coeficiente 'a' no puede ser 0 porque entonces no es cuadractica.");
	}
}
