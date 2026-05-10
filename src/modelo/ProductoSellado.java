package modelo;

public class ProductoSellado extends Producto {

    // Constructor completo
    public ProductoSellado(String id, String nombre, String descripcion, double precio) {
        super(id, nombre, descripcion, precio);
    }

    // Constructor vacío
    public ProductoSellado() {
    }

    @Override
    public String toString() {
        return "ProductoSellado{id='" + getId() + "', nombre='" + getNombre() +
               "', precio=" + getPrecio() + "}";
    }
}
