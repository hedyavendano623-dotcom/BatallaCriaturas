/**
 * Dragon: criatura que ataca con el doble de su fuerza.
 * Sus escamas reducen a la mitad el dano que recibe.
 */
public class Dragon extends Criatura {

    private String escamas; // Tipo de escamas que lo protegen

    /**
     * Constructor del dragon.
     * @param nombre  nombre del dragon
     * @param salud   salud inicial
     * @param fuerza  fuerza base
     * @param escamas descripcion de sus escamas
     */
    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza);
        this.escamas = escamas;
    }

    /** El dragon lanza una llamarada: dano igual a fuerza x 2. */
    @Override
    public void atacar(Criatura objetivo) {
        int danio = getFuerza() * 2;
        System.out.println(getNombre() + " (Dragon) lanza una llamarada y causa "
                + danio + " de dano a " + objetivo.getNombre());
        objetivo.defender(danio);
    }

    /** Las escamas absorben la mitad del dano (minimo 1). */
    @Override
    public void defender(int danio) {
        int danioReal = Math.max(1, danio / 2);
        reducirSalud(danioReal);
        System.out.println("   " + getNombre() + " resiste con sus " + escamas
                + " y recibe " + danioReal + " de dano");
    }
}