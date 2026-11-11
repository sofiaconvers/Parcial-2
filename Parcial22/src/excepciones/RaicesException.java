package excepciones;

public class RaicesException extends EcuacionException {
	
	private static final long serialVersionUID = 1L;

	private final double discriminante;

	public RaicesException(double discriminante) {
		super("El discriminante es negativo (" + discriminante + "), entonces la ecuación tiene raíces complejas.");
		this.discriminante = discriminante;
	}

	public double getDiscriminante() {
		return discriminante;
	}

}
