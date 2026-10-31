public abstract class Criatura {
 protected String nombre;
 protected int salud;
protected int fuerza;

 public Criatura(String nombre, int salud, int fuerza) {
  this.nombre = nombre;
  this.salud = salud;
  this.fuerza = fuerza;
    }

 public String getNombre() {
  return nombre;
    }

 public int getSalud() {
  return salud;
    }

 public int getFuerza() {
    return fuerza;
    }

 public boolean estaViva() {
  return salud > 0;
    }

 protected void reducirSalud(int cantidad) {
  salud = Math.max(0, salud - cantidad);
    }

 public abstract void atacar(Criatura objetivo);

 public abstract void defender(int danio);
}