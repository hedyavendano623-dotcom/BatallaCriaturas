public abstract class Criatura {
private String nombre;
private int vida;

public Criatura(String nombre, int vida){
this.nombre = nombre;
this.vida = vida;
}
public String getNombre() {
return nombre;
}
public int getVida() {
return vida;
}
public abstract void atacar(Criatura objetivo);
}