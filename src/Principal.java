import java.util.Arrays;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Declarar variables
		Scanner lectura = new Scanner(System.in);

		// Arrego con los candidatos
		String[][] candidatos = { { "1", "Jose Duarte" }, { "2", "Marisol Linares" }, { "3", "Victor Sosa" },
				{ "4", "Kiara Salgado" } };

		int votosC1 = 0;
		int votosC2 = 0;
		int votosC3 = 0;
		int votosC4 = 0;
		int votosNulos = 0;

		;
		int[] votantes;
		votantes = new int[8];
		int opc = 0;

		System.out.println("\n[].[].[].[].[].[].[].[]  BIENVENIDO A LA CASILLA ELECTORAL  [].[].[].[].[].[].[].[] \n");
		System.out.println("CANDIDATOS:");
		System.out.println("----------------------------");

		for (String[] candidato : candidatos) {
			System.out.println(candidato[0] + ". " + candidato[1]);
		}
		System.out.println("5. Anular voto");
		System.out.println("----------------------------");
		System.out.println("\nNOTA: Recuerda que tu voto es libre, secreto y confidencial. ¡Participa con responsabilidad!\n");
		for (int i = 0; i < votantes.length; i++) {
			
			//Validamos que la elección sea valida
			boolean entradaValida = false;
			while (!entradaValida) {
				System.out.println("\nVotante número " + (i + 1));
				System.out.print("¿A quién desea apoyar (Ingresa el número del candidato o 5 para anular su voto)?: ");

				try {
					opc = lectura.nextInt();

					if (opc >= 1 && opc <= 5) { // Validamps del 1 al 5
						entradaValida = true;
						switch (opc) {
						case 1:
							votosC1++;
							break;
						case 2:
							votosC2++;
							break;
						case 3:
							votosC3++;
							break;
						case 4:
							votosC4++;
							break;
						case 5:
							votosNulos++;
							System.out.println("Voto anulado.");
							break;
						}
					} else {
						System.out.println("Opción no válida. Por favor, ingresa un número entre 1 y 5.");
					}

				} catch (Exception e) {
					System.out.println("Entrada no válida. Por favor, ingresa un número entre 1 y 5.");
					lectura.next();
				}
			}
		}
		int ganador = votosC1;
		String candidatoGanador = candidatos[0][1];
		boolean hayEmpate = false;

		// Verificamos si el candidato 2 tiene más votos o igual en caso de empate
		if (votosC2 > ganador) {
			ganador = votosC2;
			candidatoGanador = candidatos[1][1];
			hayEmpate = false;
		} else if (votosC2 == ganador) {
			candidatoGanador += ", " + candidatos[1][1];
			hayEmpate = true;
		}

		// Verificamos si el candidato 3 tiene más votos o igual en caso de empate
		if (votosC3 > ganador) {
			ganador = votosC3;
			candidatoGanador = candidatos[2][1];
			hayEmpate = false;
		} else if (votosC3 == ganador) {
			candidatoGanador += ", " + candidatos[2][1];
			hayEmpate = true;
		}

		// Verificamos si el candidato 4 tiene más votos o igual en caso de empate
		if (votosC4 > ganador) {
			ganador = votosC4;
			candidatoGanador = candidatos[3][1];
			hayEmpate = false;
		} else if (votosC4 == ganador) {
			candidatoGanador += ", " + candidatos[3][1];
			hayEmpate = true;
		}

		String[][] resultados = { { candidatos[0][1], String.valueOf(votosC1) },
				{ candidatos[1][1], String.valueOf(votosC2) }, { candidatos[2][1], String.valueOf(votosC3) },
				{ candidatos[3][1], String.valueOf(votosC4) } };

		// Ordenamos los resultados de mayor a menor
		Arrays.sort(resultados, (a, b) -> Integer.compare(Integer.parseInt(b[1]), Integer.parseInt(a[1])));

		System.out.println("\nResultados de las elecciones: \n");
		// Ciclo: Recorremos el arreglo para mostrar un resultado
		for (String[] resultado : resultados) {
			System.out.println(resultado[0] + " : " + resultado[1] + " votos");
		}
		// Imprime el resultado si es empate
		if (hayEmpate) {
			System.out.println("\nHay un empate entre los candidatos: " + candidatoGanador + " con " + ganador
					+ " votos cada uno.");
		} else { //De lo contrario se imprime el ganador
			System.out.println("\nEl candidato ganador es: " + candidatoGanador + " con " + ganador + " votos.");
		}

	}

}
