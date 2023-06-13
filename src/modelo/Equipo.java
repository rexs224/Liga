package modelo;

import java.util.ArrayList;

/**
 * @author Javi
 */

public class Equipo {

	private int partidosJugados = 0;
	private int puntos = 0;
	private String _nombreEquipo;
	private ArrayList<Jugador> _plantilla = new ArrayList<Jugador>();

	public Equipo(String _nombreEquipo) {
		super();
		this._nombreEquipo = _nombreEquipo;
	}

	public String get_nombreEquipo() {
		return _nombreEquipo;
	}

	public void set_nombreEquipo(String _nombreEquipo) {
		this._nombreEquipo = _nombreEquipo;
	}

	public ArrayList<Jugador> get_plantilla() {
		return _plantilla;
	}

	public void set_plantilla(ArrayList<Jugador> _plantilla) {
		this._plantilla = _plantilla;
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

	public int getPartidosJugados() {
		return partidosJugados;
	}

	public void setPartidosJugados(int partidosJugados) {
		this.partidosJugados = partidosJugados;
	}

	@Override
	public String toString() {
		return _nombreEquipo;
	}

	public void mostrarPlantilla() {

		for (Jugador jugador : _plantilla) {
			System.out.println(jugador);
		}

	}

	public void addIntegrante(Jugador item) {

		_plantilla.add(item);

	}

	public Jugador getJugador(int posicion) {

		return _plantilla.get(posicion);

	}

	public void removeIntegrante(int posicion) {

		_plantilla.remove(posicion);

	}

}
