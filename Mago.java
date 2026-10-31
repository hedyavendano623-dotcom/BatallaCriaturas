
public class Mago extends Criatura {

public Mago(String nombre, int salud, int fuerza) {
        super(nombre, salud, fuerza);
    }

    @Override
public void atacar(Criatura objetivo) {
System.out.println(nombre + " lanza un hechizo a " + objetivo.getNombre() + " con " + fuerza + " de poder.");
        objetivo.defender(fuerza);
    }

    @Override
    public void defender(int danio) {
  // Barrera magica: absorbe 2 puntos de danio
   int recibido = Math.max(0, danio - 2);
    reducirSalud(recibido);
   System.out.println(nombre + " levanta una barrera magica y recibe " + recibido + " de danio.");
    }
}
// use danio para evitar la letra ñ, fue sugerencia de una inteligencia artificial, en caso de que la "ñ" no se leyera bien.