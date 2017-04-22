package exception;

/**
 * Clase que alojara objetos que contienen mensajes
 * 
 */
public class ErrorVo {
	private String msjError;

	private String msjException;

	/**
	 * Recibimos los mensajes
	 * 
	 * @param msjError
	 *            Variable que contiene el mesaje personalizado
	 * @param msjException
	 *            variable que contendra la Exception
	 */
	public ErrorVo(String msjError, String msjException) {
		super();
		this.msjError = msjError;
		this.msjException = msjException;
	}

	/**
	 * M�todo set Mensaje Error
	 * 
	 * @return Mensaje Error
	 */
	public String getMsjError() {
		return msjError;
	}

	/**
	 * M�todo get Mensaje Error
	 * 
	 * @param msjError
	 *            Mensaje Error
	 */
	public void setMsjError(String msjError) {
		this.msjError = msjError;
	}

	/**
	 * M�todo get Mensaje Exception
	 * 
	 * @return Mensaje Exception
	 */
	public String getMsjException() {
		return msjException;
	}

	/**
	 * M�todo get Mensaje Exception
	 * 
	 * @param msjException
	 *            Mensaje Exception
	 */
	public void setMsjException(String msjException) {
		this.msjException = msjException;
	}

}
