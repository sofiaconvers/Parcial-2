package excepciones;

public class CoeficienteInvalidoException extends EcuacionException{
	
	private static final long serialVersionUID = 1L;

	public CoeficienteInvalidoException(String mensaje) {
		super(mensaje);
	}

}
