/**
 * Guerrero: ataca con su arma (dano igual a su fuerza).
 * Su armadura absorbe 5 puntos de dano.
 */
public class Guerrero extends Criatura {

    private String arma; // Arma que usa el guerrero

    /**
     * Constructor del guerrero.
     * @param nombre nombre del guerrero
     * @param salud  salud inicial
     * @param fuerza fuerza base
     * @param arma   arma que utiliza
     */
    public Guerrero(String nombre, int salud, int fuerza, String arma) {
        super(nombre, salud, fuerza);
        this.arma = arma;
    }

    /** El guerrero golpea con su arma: dano igual a su fuerza. */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = getFuerza();
        System.out.println(getNombre() + " (Guerrero) golpea con su " + arma
                + " y causa " + danio + " de dano a " + objetivo.getNombre());
        objetivo.defender(danio);
    }

    /** La armadura absorbe 5 puntos de dano (minimo 1). */
    @Override
    public void defender(int danio) {
        int danioReal = Math.max(1, danio - 5);
        reducirSalud(danioReal);
        System.out.println("   " + getNombre() + " bloquea con su armadura y recibe "
                + danioReal + " de dano");
    }
}