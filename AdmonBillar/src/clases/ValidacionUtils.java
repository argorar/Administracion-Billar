package clases;

import exception.ErrorVo;
import exception.ExcepcionPersonalizada;

/**
 * Clase que contiene m�todos los cuales se encargaran de hacer diferentes
 * validaciones a variables resividas por parametro, si el resultado de las
 * validaciones es negativo se lanzara un mensaje de error personalizado
 * dirigido al usuario.
 * 
 */
public class ValidacionUtils {

	/**
	 * M�todo que se encarga de validar una cadena de n�meros recibida por
	 * parametros
	 * 
	 * @param cantidad
	 *            Cadena que sera validada
	 * @throws ExcepcionPersonalizada
	 *             Lanzara un mensaje personalizado dirigido al usuario
	 */
	public void validarCantidad(String cantidad) throws ExcepcionPersonalizada {
		// Validamos que la variable no este vacia
		if (((cantidad == null) || (cantidad.equals("")))) {
			// Lanzamos el mensaje personalizado
			throw new ExcepcionPersonalizada(new ErrorVo(
					"La cantidad es incorrecta.", null));
		} else {
			int n = 0;
			try {
				n = Integer.parseInt(cantidad);
				// numero m�ximo de productos por grupo es de 70
				if (n < 0 && n > 70) {
					throw new ExcepcionPersonalizada(
							new ErrorVo(
									"Esa cantidad no es correcta",
									null));
				}

			} catch (Exception e) {// Lanzamos el mensaje personalizado
				throw new ExcepcionPersonalizada(new ErrorVo(
						"La cantidad de productos  debe estar en n�meros.",
						e.getMessage()));
			}
		}
	}


	@SuppressWarnings("null")
	public void validarDescripcion(String nombre)
			throws ExcepcionPersonalizada {
		// Desici�n que verifica que no este vacio las variables
		if (nombre == null && nombre.equals("")) {
			// Lanzamos el mensaje personalizado
			throw new ExcepcionPersonalizada(new ErrorVo(
					"La descrpc�n del producto es necesario.", null));
		} else {
			if (nombre.matches("[a-zA-z]*")) {
			} else {
				// Lanzamos el mensaje personalizado sobre error de validaci�n
				throw new ExcepcionPersonalizada(
						new ErrorVo(
								"La descripci�n solo se permite en  caracteres alfabeticos.",
								null));
			}
		}
	}

	/**
	 * M�todo que se encarga de validar el n�mero de documento
	 * 
	 * @param numero
	 *            Variable que contiene el n�mero a validar
	 * @throws ExcepcionPersonalizada
	 *             Lanzara un mensaje personalizado dirigido al usuario
	 */
	public void validarPrecio(String numero) throws ExcepcionPersonalizada {
		// Validamos que la variable no este vacia
		if (((numero == null) || (numero.equals("")))) {
			// Lanzamos el mensaje personalizado
			throw new ExcepcionPersonalizada(new ErrorVo(
					"El precio esta vacio.", null));
		} else {

			int n = 0;
			try {// Hacemos la converci�n
				n = Integer.parseInt(numero);
				// El n�mero tiene que ser mayor a 0
				if (n > 0) {

				}

			} catch (Exception e) {
				// Lanzamos el mensaje personalizado
				throw new ExcepcionPersonalizada(new ErrorVo(
						"El precio  debe estar en n�meros.", e.getMessage()));
			}
		}
	}

}
