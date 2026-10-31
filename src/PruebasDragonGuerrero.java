public class PruebasDragonGuerrero {
    private static int fallos = 0;

    public static void main(String[] args) {
        probarDragonAtacaConDobleFuerza();
        probarDragonEscamasReducenALaMitad();
        probarGuerreroArmaduraRestaCinco();

        System.out.println();
        if (fallos == 0) {
            System.out.println("Todas las pruebas pasaron.");
        } else {
            System.out.println("Pruebas fallidas: " + fallos);
        }
    }

    private static void probarDragonAtacaConDobleFuerza() {
        Dragon atacante = new Dragon("Smaug", 30, 5, "rojas");
        Dragon objetivo = new Dragon("Drogon", 30, 4, "negras");
        atacante.atacar(objetivo);
        verificar(objetivo.getSalud() == 25, "El dragon ataca con el doble de su fuerza");
    }

    private static void probarDragonEscamasReducenALaMitad() {
        Dragon objetivo = new Dragon("Drogon", 30, 4, "negras");
        objetivo.defender(10);
        verificar(objetivo.getSalud() == 25, "Las escamas del dragon reducen el dano a la mitad");
    }

    private static void probarGuerreroArmaduraRestaCinco() {
        Guerrero objetivo = new Guerrero("Jon", 25, 6, "espada");
        objetivo.defender(9);
        verificar(objetivo.getSalud() == 21, "La armadura del guerrero absorbe 5 puntos de dano");
    }

    private static void verificar(boolean condicion, String descripcion) {
        if (condicion) {
            System.out.println("OK: " + descripcion);
        } else {
            System.out.println("FALLO: " + descripcion);
            fallos++;
        }
    }
}
