package modelo;

public abstract class Producto {
    private String id;
    private String nombre;
    private String descripcion;
    private double precio;

    // Constructor completo
    public Producto(String id, String nombre, String descripcion, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    // Constructor vacío
    public Producto() {
    }

    // Getters
    public String getId()          { return id; }
    public String getNombre()      { return nombre; }
    public String getDescripcion() { return descripcion; }
    public double getPrecio()      { return precio; }

    // Setters
    public void setId(String id)               { this.id = id; }
    public void setNombre(String nombre)       { this.nombre = nombre; }
    public void setDescripcion(String d)       { this.descripcion = d; }
    public void setPrecio(double precio)       { this.precio = precio; }

    @Override
    public String toString() {
        return "Producto{id='" + id + "', nombre='" + nombre +
               "', precio=" + precio + "}";
    }
}
