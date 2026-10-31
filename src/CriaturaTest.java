import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/** Pruebas unitarias del juego de criaturas (JUnit 5). */
class CriaturaTest {

    @Test
    void criaturaNuevaEstaViva() {
        Criatura g = new Guerrero("Arturo", 100, 20, "espada");
        assertTrue(g.estaViva());
    }

    @Test
    void criaturaConDanoLetalEstaMuerta() {
        Criatura g = new Guerrero("Arturo", 10, 20, "espada");
        g.defender(1000);
        assertFalse(g.estaViva());
    }

    @Test
    void saludNuncaQuedaEnNegativo() {
        Criatura g = new Guerrero("Arturo", 10, 20, "espada");
        g.defender(1000);
        assertEquals(0, g.getSalud());
    }

    @Test
    void dragonAtacaConElDobleDeFuerza() {
        Dragon d = new Dragon("Smaug", 150, 20, "escamas");
        Guerrero g = new Guerrero("Arturo", 200, 10, "espada");
        d.atacar(g); // dano 40, la armadura absorbe 5 -> pierde 35
        assertEquals(165, g.getSalud());
    }

    @Test
    void magoAtacaConSuFuerza() {
        Mago m = new Mago("Merlin", 100, 25);
        Dragon d = new Dragon("Smaug", 150, 20, "escamas");
        m.atacar(d); // dano 25, escamas reducen a la mitad -> 12
        assertEquals(138, d.getSalud());
    }

    @Test
    void guerreroAtacaConSuFuerza() {
        Guerrero g = new Guerrero("Arturo", 120, 20, "espada");
        Mago m = new Mago("Merlin", 100, 25);
        g.atacar(m); // dano 20, la barrera absorbe 2 -> 18
        assertEquals(82, m.getSalud());
    }

    @Test
    void polimorfismoTodasLasCriaturasAtacanComoCriatura() {
        Criatura[] atacantes = {
                new Dragon("D", 100, 20, "escamas"),
                new Mago("M", 100, 20),
                new Guerrero("G", 100, 20, "espada")
        };
        for (Criatura atacante : atacantes) {
            Criatura objetivo = new Guerrero("Blanco", 500, 5, "palo");
            atacante.atacar(objetivo);
            assertTrue(objetivo.getSalud() < 500);
        }
    }

    @Test
    void batallaTerminaConGanadorVivoYPerdedorMuerto() {
        Criatura c1 = new Dragon("Smaug", 150, 20, "escamas");
        Criatura c2 = new Guerrero("Arturo", 120, 20, "espada");
        Criatura ganador = Main.simularBatalla(c1, c2);
        Criatura perdedor = (ganador == c1) ? c2 : c1;
        assertTrue(ganador.estaViva());
        assertFalse(perdedor.estaViva());
    }
}