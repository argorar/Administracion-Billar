package exception;

/**
 * Clase que contiene la excepcion personalizada que se usara para las
 * validaciones necesarias
 * 
 */
public class ExcepcionPersonalizada extends Exception {

	private static final long serialVersionUID = 1L;
	private ErrorVo errorVo;

	/**
	 * Constructor que recibira un objeto de tipo ErrorVo
	 * 
	 * @param errorVo
	 *            Objeto que contiene los mensajes
	 */
	public ExcepcionPersonalizada(ErrorVo errorVo) {
		super();
		this.errorVo = errorVo;
	}

	/**
	 * Método get de objeto ErrorVo
	 * 
	 * @return Objeto ErrorVO
	 */
	public ErrorVo getErrorVo() {
		return errorVo;
	}

	/**
	 * Método set de objeto ErrorVo
	 * 
	 * @param errorVo
	 */
	public void setErrorVo(ErrorVo errorVo) {
		this.errorVo = errorVo;
	}

}
