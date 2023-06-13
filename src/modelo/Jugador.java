package modelo;

/**
 * @author Javi
 */
public class Jugador {

	private String _nombre;
	private int _dorsal;
	private String _posicion;

	public Jugador(String _nombre, int _dorsal, String _posicion) {
		super();
		this._nombre = _nombre;
		this._dorsal = _dorsal;
		this._posicion = _posicion;
	}

	public Jugador() {
		super();
	}

	public Jugador(String _nombre) {
		super();
		this._nombre = _nombre;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

	public int get_dorsal() {
		return _dorsal;
	}

	public void set_dorsal(int _dorsal) {
		this._dorsal = _dorsal;
	}

	public String get_posicion() {
		return _posicion;
	}

	public void set_posicion(String _posicion) {
		this._posicion = _posicion;
	}

	@Override
	public String toString() {
		return _nombre + ", Dorsal " + _dorsal + ", Posicion " + _posicion;
	}

}
