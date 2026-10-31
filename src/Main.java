/**
 * Clase principal: crea criaturas y simula batallas entre ellas.
 */
public class Main {

    /**
     * Simula una batalla por turnos hasta que una criatura se quede sin salud.
     * Usa polimorfismo: recibe Criatura sin importar su tipo concreto.
     * @param criatura1 primera combatiente (ataca primero)
     * @param criatura2 segunda combatiente
     * @return la criatura ganadora
     */
    public static Criatura simularBatalla(Criatura criatura1, Criatura criatura2) {
        System.out.println("=== BATALLA: " + criatura1.getNombre()
                + " vs " + criatura2.getNombre() + " ===");
        int ronda = 1;

        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("\n--- Ronda " + ronda + " ---");

            criatura1.atacar(criatura2);
            if (criatura2.estaViva()) { // solo contraataca si sigue viva
                criatura2.atacar(criatura1);
            }

            System.out.println("Salud -> " + criatura1.getNombre() + ": " + criatura1.getSalud()
                    + " | " + criatura2.getNombre() + ": " + criatura2.getSalud());
            ronda++;
        }

        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        System.out.println("\n>>> Ganador: " + ganador.getNombre()
                + " con " + ganador.getSalud() + " de salud\n");
        return ganador;
    }

    public static void main(String[] args) {
        // Batalla 1: Dragon vs Guerrero
        simularBatalla(
                new Dragon("Smaug", 150, 20, "escamas de fuego"),
                new Guerrero("Arturo", 120, 20, "espada"));

        // Batalla 2: Mago vs Guerrero
        simularBatalla(
                new Mago("Merlin", 100, 25, "bola de fuego"),
                new Guerrero("Conan", 120, 20, "hacha"));

        // Batalla 3: Dragon vs Mago
        simularBatalla(
                new Dragon("Drogon", 150, 20, "escamas negras"),
                new Mago("Gandalf", 100, 25, "rayo arcano"));
    }
}