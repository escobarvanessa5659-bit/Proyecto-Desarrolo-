package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Compra {
    private String id;
    private LocalDateTime fecha;
    private double total;
    private List<Producto> productos;

    // Constructor completo
    public Compra(String id, LocalDateTime fecha) {
        this.id = id;
        this.fecha = fecha;
        this.productos = new ArrayList<>();
        this.total = 0;
    }

    // Constructor vacío
    public Compra() {
        this.productos = new ArrayList<>();
    }

    // Agrega un producto y recalcula el total
    public void agregarProducto(Producto producto) {
        productos.add(producto);
        this.total += producto.getPrecio();
    }

    // Recalcula el total desde la lista de productos
    public double calcularTotal() {
        total = 0;
        for (Producto p : productos) {
            total += p.getPrecio();
        }
        return total;
    }

    // Getters
    public String getId()               { return id; }
    public LocalDateTime getFecha()     { return fecha; }
    public double getTotal()            { return total; }
    public List<Producto> getProductos(){ return productos; }

    // Setters (necesarios para Jackson)
    public void setId(String id)                        { this.id = id; }
    public void setFecha(LocalDateTime fecha)           { this.fecha = fecha; }
    public void setTotal(double total)                  { this.total = total; }
    public void setProductos(List<Producto> productos)  { this.productos = productos; }

    @Override
    public String toString() {
        return "Compra{id='" + id + "', fecha=" + fecha +
               ", total=" + total + ", productos=" + productos + "}";
    }
}
