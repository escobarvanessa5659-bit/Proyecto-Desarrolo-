package modelo;

public class Booster extends Producto {
    private int cantidadCartas;

    // Constructor completo
    public Booster(String id, String nombre, String descripcion, double precio, int cantidadCartas) {
        super(id, nombre, descripcion, precio);
        this.cantidadCartas = cantidadCartas;
    }

    // Constructor vacío
    public Booster() {
    }

    // Getters
    public int getCantidadCartas() { return cantidadCartas; }

    // Setters
    public void setCantidadCartas(int cantidadCartas) { this.cantidadCartas = cantidadCartas; }

    @Override
    public String toString() {
        return "Booster{id='" + getId() + "', nombre='" + getNombre() +
               "', cantidadCartas=" + cantidadCartas + ", precio=" + getPrecio() + "}";
    }
}
