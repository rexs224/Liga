package modelo;

import java.util.ArrayList;

/**
 * @author Javi
 */
public class Jornada {

	private int numeroJornada;
	private ArrayList<Enfrentamiento> enfrentamientos = new ArrayList<>();

	public Jornada(int numeroJornada) {
		super();
		this.numeroJornada = numeroJornada;
	}

	public int getNumeroJornada() {
		return numeroJornada;
	}

	public void setNumeroJornada(int numeroJornada) {
		this.numeroJornada = numeroJornada;
	}

	public ArrayList<Enfrentamiento> getEnfrentamientos() {
		return enfrentamientos;
	}

	public void setEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {
		this.enfrentamientos = enfrentamientos;
	}

	@Override
	public String toString() {
		return "Jornada [numeroJornada=" + numeroJornada + ", enfrentamientos=" + enfrentamientos + "]";
	}

	public void añadirEnfrentamiento(Enfrentamiento enfrentamiento) {

		enfrentamientos.add(enfrentamiento);

	}

}
