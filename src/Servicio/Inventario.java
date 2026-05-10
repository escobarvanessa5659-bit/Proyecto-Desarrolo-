package Servicio;

import modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;

    // Constructor
    public Inventario() {
        this.productos = new ArrayList<>();
    }

    // Agrega un producto al inventario
    public void agregar(Producto producto) {
        productos.add(producto);
    }

    // Lista todos los productos disponibles
    public List<Producto> listar() {
        return productos;
    }

    // Busca un producto por su ID; retorna null si no existe
    public Producto buscarProducto(String id) {
        for (Producto p : productos) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    // Elimina un producto por ID
    public boolean eliminarProducto(String id) {
        return productos.removeIf(p -> p.getId().equals(id));
    }

    // Getter y Setter para persistencia
    public List<Producto> getProductos()              { return productos; }
    public void setProductos(List<Producto> productos){ this.productos = productos; }
}
