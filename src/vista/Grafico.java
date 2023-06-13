package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Enfrentamiento;
import modelo.Equipo;
import modelo.Jornada;
import modelo.Tabla;

/**
 * @author Joaquin
 */
public class Grafico {

	private static Scanner sc = new Scanner(System.in);
	private static final String ANSI_RESET = "\033[0m";
	private static final String ANSI_BLANCO = "\033[38;5;15m";

	public static int pideEnteroRango(int inicio, int fin, String mensaje) {

		boolean valido = false;
		int numero = 0;

		do {

			try {

				System.out.print(mensaje);
				numero = sc.nextInt();

				if (numero >= inicio && numero <= fin) {

					valido = true;

				} else {

					System.out.println("No está en el rango pedido");

				}

			} catch (InputMismatchException e) {

				System.out.println("Primo, pon un número porfa");

			} catch (Exception e) {

				System.out.println("Error to random");

			} finally {

				sc.nextLine();
				System.out.println();

			}

		} while (!valido);

		return numero;

	}

	public static String pideString(String mensaje, String mensajeUsuario) {

		String cadena;

		System.out.println(mensaje);
		System.out.print(mensajeUsuario);
		cadena = sc.nextLine();
		System.out.println();

		return cadena;

	}

	public static int bienvenida() {

		int numeroEquipos;

		// aunque no parezca, es el mensaje de bienvenida
		System.out.print("\033[1;92m"); // un verde más claro
		System.out.println("  ____  _                           _     _               _                         \r\n"
				+ " |  _ \\(_)                         (_)   | |             | |                        \r\n"
				+ " | |_) |_  ___ _ ____   _____ _ __  _  __| | ___     __ _| |                        \r\n"
				+ " |  _ <| |/ _ \\ '_ \\ \\ / / _ \\ '_ \\| |/ _` |/ _ \\   / _` | |                        \r\n"
				+ " | |_) | |  __/ | | \\ V /  __/ | | | | (_| | (_) | | (_| | |                        \r\n"
				+ " |____/|_|\\___|_| |_|\\_/ \\___|_| |_|_|\\__,_|\\___/   \\__,_|_|                        \r\n"
				+ "      _                 _           _                  _        _ _                 \r\n"
				+ "     (_)               | |         | |                | |      | (_)                \r\n"
				+ "  ___ _ _ __ ___  _   _| | __ _  __| | ___  _ __    __| | ___  | |_  __ _  __ _ ___ \r\n"
				+ " / __| | '_ ` _ \\| | | | |/ _` |/ _` |/ _ \\| '__|  / _` |/ _ \\ | | |/ _` |/ _` / __|\r\n"
				+ " \\__ \\ | | | | | | |_| | | (_| | (_| | (_) | |    | (_| |  __/ | | | (_| | (_| \\__ \\\r\n"
				+ " |___/_|_| |_| |_|\\__,_|_|\\__,_|\\__,_|\\___/|_|     \\__,_|\\___| |_|_|\\__, |\\__,_|___/\r\n"
				+ "                                                                     __/ |          \r\n"
				+ "                                                                    |___/           ");
		System.out.println(ANSI_RESET);
		System.out.println(ANSI_BLANCO);
		System.out.println("En este programa podrás gestionar equipos y jugadores, simular enfrentamientos, ");
		System.out.println("jornadas o la liga entera y mucho más.");
		System.out.println();
		System.out.println("************************************");
		System.out.println(" ¿Cuántos equipos habrá en la liga?");
		System.out.println("************************************");

		numeroEquipos = pideEnteroRango(3, 50, "3 - 50: ");

		return numeroEquipos;

	}

	// muestra las jornadas por consola
	public static void mostrarJornadas(ArrayList<Jornada> jornadas) {

		int tamaño = jornadas.size();

		if (tamaño > 2) {

			// muestra cuantas jornadas hay
			System.out.println("hay " + tamaño + " jornadas");
			System.out.println();

			// va mostrando las jornadas
			for (Jornada jornada : jornadas) {

				// muestra el numero de jornada
				System.out.println("jornada " + jornada.getNumeroJornada() + ":");
				System.out.println();
				// muestra los enfrentamientos de cada jornada
				mostrarEnfrentamientos(jornada.getEnfrentamientos());
				System.out.println();

			}

		} else {

			// muestra esto si no hay jornadas
			System.out.println("no hay jornadas formadas");
			System.out.println();

		}

	}

	// muestra los equipos por consola
	public static void mostrarEquipos(ArrayList<Equipo> equipos) {

		int tamaño = equipos.size();
		String plural = "";

		if (tamaño > 0) {

			if (tamaño > 1) {

				// capricho mio
				plural += "s";

			}

			// muestra cuantos equipos hay
			System.out.println("hay " + tamaño + " equipo" + plural + ":");
			System.out.println();

			for (Equipo equipo : equipos) {

				// muestra el nombre de cada equipo
				System.out.println(equipo.get_nombreEquipo());

			}

			System.out.println(ANSI_BLANCO);

		} else {

			// muestra esto si no hay equipos
			System.out.println("no hay equipos formados");
			System.out.println();

		}

	}

	public static int menu(String[] opciones, String mensaje) {

		int opcion;

		imprimeMenu(opciones);

		opcion = pideEnteroRango(1, opciones.length, mensaje);

		return opcion;

	}

	// parte javi
	public static void imprimeTabla(Tabla tabla) {

		int mayor;
		int ascienden;
		int playoff;
		int descienden;
		int[][] stats = tabla.getEstadisticas();
		String margen = "   ";
		String margenNombre = "══";
		String mayorStr;
		String posicion;
		String[] equipos = tabla.getNombresEquipos();

		ascienden = (int) (0.2 * equipos.length);
		playoff = (int) (0.1 * equipos.length) + ascienden;
		descienden = (int) (0.85 * equipos.length);// 0.85 es el 15% de los ultimos
		mayorStr = "1." + equipos[0];
		mayor = mayorStr.length();

		for (int i = 0; i < equipos.length; i++) {

			if (((i + 1) + "." + equipos[i]).length() > mayor) {

				mayorStr = (i + 1) + "." + equipos[i];
				mayor = mayorStr.length();

			}

		}

		for (int i = 0; i < mayor; i++) {

			margen += " ";
			margenNombre += "═";

		}

		System.out.println(margen + "╔═════╤═════╤═════╤═════╗");
		System.out.println(margen + "║ G.F │ G.C │ D.G │ PTS ║");
		System.out.println("╔" + margenNombre + "╬═════╪═════╪═════╪═════╣");

		for (int i = 0; i < equipos.length; i++) {

			if (i < ascienden) {

				posicion = "\u001B[42m" + (i + 1) + ".\u001B[0m";

			} else if (i < playoff) {

				posicion = "\u001B[43m" + (i + 1) + ".\u001B[0m";

			} else if (i > descienden) {

				posicion = "\u001B[41m" + (i + 1) + ".\u001B[0m";

			} else {

				posicion = (i + 1) + ".";

			}

			System.out.println("║ " + posicion + equipos[i]
					+ margen.substring(0, mayor - ((i + 1) + "." + equipos[i]).length()) + " ║ " + stats[i][0]
					+ margen.substring(0, stats[i][0] / 100 >= 1 ? 0 : stats[i][0] / 10 >= 1 ? 1 : 2) + " │ "
					+ stats[i][1] + margen.substring(0, stats[i][1] / 100 >= 1 ? 0 : stats[i][1] / 10 >= 1 ? 1 : 2)
					+ " │ " + stats[i][2]
					+ margen.substring(0, stats[i][2] / 100 >= 1 ? 0 : stats[i][2] / 10 >= 1 ? 1 : 2) + " │ "
					+ stats[i][3] + margen.substring(0, stats[i][3] / 100 >= 1 ? 0 : stats[i][3] / 10 >= 1 ? 1 : 2)
					+ " ║");

		}

		System.out.println("╚" + margenNombre + "╩═════╧═════╧═════╧═════╝");

	}

	private static void imprimeMenu(String[] opciones) {

		for (String opcion : opciones) {

			System.out.println(opcion);

		}

	}

	public static boolean nombreODorsal(String mensaje) {

		int opcion;

		imprimeNombreODorsal(mensaje);

		opcion = pideEnteroRango(1, 2, "Opcion: ");

		return opcion == 1;

	}

	private static void mostrarEnfrentamientos(ArrayList<Enfrentamiento> enfrentamientos) {

		for (Enfrentamiento enfrentamiento : enfrentamientos) {

			if (!enfrentamiento.getEquipo1().get_nombreEquipo().equals("Descansa")) {

				System.out.println(enfrentamiento.getEquipo1().get_nombreEquipo() + " vs "
						+ enfrentamiento.getEquipo2().get_nombreEquipo());

			} else {

				System.out.println(enfrentamiento.getEquipo1().get_nombreEquipo()
						+ enfrentamiento.getEquipo2().get_nombreEquipo());

			}

		}

	}

	private static void imprimeNombreODorsal(String mensaje) {

		System.out.println("1. " + mensaje + " por nombre");
		System.out.println("2. " + mensaje + " por dorsal");
		System.out.println();

	}

}