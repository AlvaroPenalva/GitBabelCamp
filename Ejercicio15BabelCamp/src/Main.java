import java.util.Scanner;

import Entidades.Vestuario;
import Entidades.Personas.Persona;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		String menu = "Elija una opcion:     1. Combate     2. Salir\n";
		System.out.println(menu);
		int opcion = scan.nextInt();

		Persona combatiente1;
		Persona combatiente2;
		while (opcion == 1) {
			System.out.println("ĦĦĦĦBienvenidos a la gran arena de BABElll!!!!!!\n");
			System.out.println("ĦDemos comienzo a nuestro combate!\n");
			combatiente1 = Vestuario.getGuerrero("Combatiente 1");
			combatiente2 = Vestuario.getGuerrero("Combatiente 2");
			combate(combatiente1, combatiente2);
			System.out.println(menu);
			opcion = scan.nextInt();
		}
		scan.close();
	}

	public static void combate(Persona uno, Persona dos) {
		double danio = 0;
		int i = 1;
		while (uno.vivo && dos.vivo) {
			System.out.println("-----------------\nTurno: " + i + "\n---------------------");
			danio = uno.atacar();
			dos.encajarGolpe(danio);
			danio = dos.atacar();
			uno.encajarGolpe(danio);
			System.out.println(uno);
			System.out.println(dos);
			i++;
		}
		if (!uno.vivo && !dos.vivo)
			System.out.println("Tenemos un empate.\n");
		else if (!dos.vivo)
			System.out.println("Ha ganado " + uno.getNombre() + "\n");
		else
			System.out.println("Ha ganado " + dos.getNombre() + "\n");
	}

}
