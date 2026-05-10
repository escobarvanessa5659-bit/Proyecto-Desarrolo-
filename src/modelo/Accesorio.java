package modelo;

public class Accesorio extends Producto {

    // Constructor completo
    public Accesorio(String id, String nombre, String descripcion, double precio) {
        super(id, nombre, descripcion, precio);
    }

    // Constructor vacío
    public Accesorio() {
    }

    @Override
    public String toString() {
        return "Accesorio{id='" + getId() + "', nombre='" + getNombre() +
               "', precio=" + getPrecio() + "}";
    }
}
