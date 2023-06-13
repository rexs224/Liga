package modelo;

import vista.Grafico;

/**
 * @author Miguel
 */
public class Enfrentamiento {

	private Equipo equipo1;
	private Equipo equipo2;
	private Equipo ganador;
	private Equipo perdedor;
	private boolean empate;
	private int golesEquipo1;
	private int golesEquipo2;
	private int faltas;
	private int tarjetaAmarilla;
	private int tarjetaRoja;

	public Enfrentamiento() {
		super();
	}

	public Enfrentamiento(Equipo equipo1, Equipo equipo2) {
		super();
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
	}

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public Equipo getGanador() {
		return ganador;
	}

	public void setGanador(Equipo ganador) {
		this.ganador = ganador;
	}

	public Equipo getPerdedor() {
		return perdedor;
	}

	public void setPerdedor(Equipo perdedor) {
		this.perdedor = perdedor;
	}

	public boolean isEmpate() {
		return empate;
	}

	public void setEmpate(boolean empate) {
		this.empate = empate;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public int getTarjetaAmarilla() {
		return tarjetaAmarilla;
	}

	public void setTarjetaAmarilla(int tarjetaAmarilla) {
		this.tarjetaAmarilla = tarjetaAmarilla;
	}

	public int getTarjetaRoja() {
		return tarjetaRoja;
	}

	public void setTarjetaRoja(int tarjetaRoja) {
		this.tarjetaRoja = tarjetaRoja;
	}

	@Override
	public String toString() {
		return "Enfrentamiento [equipo1=" + equipo1 + ", equipo2=" + equipo2 + ", ganador=" + ganador + ", perdedor="
				+ perdedor + ", empate=" + empate + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2
				+ ", faltas=" + faltas + ", tarjetaAmarilla=" + tarjetaAmarilla + ", tarjetaRoja=" + tarjetaRoja + "]";
	}

	public void simularEnfrentamiento() {

		golesEquipo1 = (int) (Math.random() * (Math.random() * 10));
		golesEquipo2 = (int) (Math.random() * (Math.random() * 10));

		if (golesEquipo1 > golesEquipo2) {

			setGanador(equipo1);
			setPerdedor(equipo2);
			setEmpate(false);
			equipo1.setPuntos(equipo1.getPuntos() + 3);

		} else if (golesEquipo2 > golesEquipo1) {

			setGanador(equipo2);
			setPerdedor(equipo1);
			setEmpate(false);
			equipo2.setPuntos(equipo2.getPuntos() + 3);

		} else if (golesEquipo1 == golesEquipo2) {

			setGanador(null);
			setPerdedor(null);
			setEmpate(true);
			equipo1.setPuntos(equipo1.getPuntos() + 1);
			equipo2.setPuntos(equipo2.getPuntos() + 1);

		}

		crearFaltas();

	}

	public void crearResultado() {

		System.out.println("Introduzca los goles del " + equipo1.get_nombreEquipo());
		golesEquipo1 = Grafico.pideEnteroRango(0, 10, "Goles: ");

		System.out.println("Introduzca los goles del " + equipo2.get_nombreEquipo());
		golesEquipo2 = Grafico.pideEnteroRango(0, 10, "Goles: ");

		if (golesEquipo1 > golesEquipo2) {

			setGanador(equipo1);
			setPerdedor(equipo2);
			setEmpate(false);
			equipo1.setPuntos(equipo1.getPuntos() + 3);

		} else if (golesEquipo2 > golesEquipo1) {

			setGanador(equipo2);
			setPerdedor(equipo1);
			setEmpate(false);
			equipo2.setPuntos(equipo2.getPuntos() + 3);

		} else if (golesEquipo1 == golesEquipo2) {

			setGanador(null);
			setPerdedor(null);
			setEmpate(true);
			equipo1.setPuntos(equipo1.getPuntos() + 1);
			equipo2.setPuntos(equipo2.getPuntos() + 1);

		}

		crearFaltas();

		System.out.println("El resultado es: " + equipo1.get_nombreEquipo() + ":" + golesEquipo1 + "---"
				+ equipo2.get_nombreEquipo() + ":" + golesEquipo2);

	}

	public void crearFaltas() {

		faltas = (int) (Math.random() * (Math.random() * 40));
		tarjetaAmarilla = (int) (Math.random() * faltas);
		tarjetaRoja = (int) (Math.random() * (Math.random() * (tarjetaAmarilla)));

	}

	public Equipo[] getEnfrentamiento() {

		Equipo[] enfrentamiento = new Equipo[2];

		enfrentamiento[0] = equipo1;
		enfrentamiento[1] = equipo2;

		return enfrentamiento;

	}

//METODOS PARA TABLA
	public int DarGolesFavorables(String nombreEquipo) {
		int golesFavorablesTabla = 0;
		try {

			if (nombreEquipo.equals(equipo1.get_nombreEquipo())) {
				golesFavorablesTabla = golesEquipo1;
			} else {
				golesFavorablesTabla = golesEquipo2;
			}

		} catch (Exception e) {
			System.out.println("Error al recoger goles favorables");
		}
		return golesFavorablesTabla;
	}

	public int darGolesContra(String nombreEquipo) {
		int golesContra = 0;
		try {
			if (nombreEquipo.equals(equipo1.get_nombreEquipo())) {
				golesContra = golesEquipo2;
			} else {
				golesContra = golesEquipo1;
			}
		} catch (Exception e) {
			System.out.println("Error al recoger goles en contra");
		}

		return golesContra;
	}

	public int darPuntos(String nombreEquipo) {
		int puntos = 0;
		try {
			if (nombreEquipo.equals(equipo1.get_nombreEquipo())) {
				if (equipo1 == ganador) {
					puntos = puntos + 2;
				}
				if (equipo1 == perdedor) {
					puntos = puntos + 0;
				} else {
					puntos++;
				}
			} else {
				if (equipo2 == ganador) {
					puntos = puntos + 2;
				}
				if (equipo2 == perdedor) {
					puntos = puntos + 0;
				} else {
					puntos++;
				}
			}
		} catch (Exception e) {
			System.out.println("Error al recoger puntos");
		}

		return puntos;

	}

	public int darDiferencia(String nombreEquipo) {
		int diferencia = 0;
		try {
			if (nombreEquipo.equals(equipo1.get_nombreEquipo())) {
				diferencia = golesEquipo1 - golesEquipo2;
			} else {
				diferencia = golesEquipo2 - golesEquipo1;
			}
		} catch (Exception e) {
			System.out.println("Error al calcular diferencia de goles");
		}
		return diferencia;

	}

}
