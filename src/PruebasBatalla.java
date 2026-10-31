public class PruebasBatalla {
    private static int fallos = 0;

    public static void main(String[] args) {
        probarBatallaTerminaConGanador();
        probarCriaturaMuertaNoSeRecupera();

        System.out.println();
        if (fallos == 0) {
            System.out.println("Todas las pruebas pasaron.");
        } else {
            System.out.println("Pruebas fallidas: " + fallos);
        }
    }

    private static void probarBatallaTerminaConGanador() {
        Mago a = new Mago("Merlin", 10, 4);
        Mago b = new Mago("Gandalf", 10, 4);
        Batalla.simular(a, b);
        verificar(!a.estaViva() || !b.estaViva(), "La batalla termina con al menos una criatura muerta");
    }

    private static void probarCriaturaMuertaNoSeRecupera() {
        Mago muerto = new Mago("Muerto", 0, 4);
        Mago vivo = new Mago("Vivo", 10, 4);
        Batalla.simular(muerto, vivo);
        verificar(muerto.getSalud() == 0, "Una criatura sin salud no recibe mas dano");
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