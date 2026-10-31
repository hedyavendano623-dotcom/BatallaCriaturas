public class Batalla {
private static final int MAX_TURNOS = 50;

public static void simular(Criatura a, Criatura b) {
System.out.println("==== Batalla: " + a.getNombre() + " vs " + b.getNombre() + " ====");
int turno = 1;

while (a.estaViva() && b.estaViva() && turno <= MAX_TURNOS) {
System.out.println("\n-- Turno " + turno + " --");

a.atacar(b);
mostrarSalud(a, b);
if (!b.estaViva()) {
break;
            }

b.atacar(a);
mostrarSalud(a, b);
 turno++;
        }

 System.out.println("\n==== Resultado ====");
 if (!b.estaViva()) {
 System.out.println("Gana " + a.getNombre() + " con " + a.getSalud() + " de salud.");
 } else if (!a.estaViva()) {
 System.out.println("Gana " + b.getNombre() + " con " + b.getSalud() + " de salud.");
        } else {
 System.out.println("Empate: se alcanzo el limite de " + MAX_TURNOS + " turnos.");
        }
    }

 private static void mostrarSalud(Criatura a, Criatura b) {
  System.out.println("Salud de " + a.getNombre() + ": " + a.getSalud()
   + " | Salud de " + b.getNombre() + ": " + b.getSalud());
    }
}