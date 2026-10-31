public class PruebasMago {
    private static int fallos = 0;

    public static void main(String[] args) {
        probarDanioAlDefender();
        probarSaludNoNegativa();
        probarEstaViva();

        System.out.println();
        if (fallos == 0) {
            System.out.println("Todas las pruebas pasaron.");
        } else {
            System.out.println("Pruebas fallidas: " + fallos);
        }
    }

    private static void probarDanioAlDefender() {
        Mago atacante = new Mago("Merlin", 20, 6);
        Mago objetivo = new Mago("Gandalf", 20, 6);
        atacante.atacar(objetivo);
        // La barrera absorbe 2: 6 - 2 = 4 de dano, 20 - 4 = 16
        verificar(objetivo.getSalud() == 16, "El mago recibe 4 de dano (6 menos la barrera)");
    }

    private static void probarSaludNoNegativa() {
        Mago objetivo = new Mago("Debil", 3, 1);
        objetivo.defender(10);
        verificar(objetivo.getSalud() == 0, "La salud nunca baja de 0");
    }

    private static void probarEstaViva() {
        Mago vivo = new Mago("Vivo", 5, 1);
        Mago muerto = new Mago("Muerto", 0, 1);
        verificar(vivo.estaViva(), "Una criatura con salud mayor que 0 esta viva");
        verificar(!muerto.estaViva(), "Una criatura con salud 0 no esta viva");
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