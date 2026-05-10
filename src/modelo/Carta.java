package modelo;

import Servicio.ServicioCambio;

public class Carta extends Producto {
    private String rareza;
    private double precioUSD; // precio base en dólares

    // Constructor completo
    public Carta(String id, String nombre, String descripcion, double precioUSD, String rareza) {
        super(id, nombre, descripcion, precioUSD);
        this.precioUSD = precioUSD;
        this.rareza = rareza;
    }

    // Constructor vacío
    public Carta() {
    }

    // Convierte el precio de USD a COP usando el servicio de cambio
    public double calcularPrecioCOP(ServicioCambio servicio) {
        return servicio.convertirUSDaCOP(precioUSD);
    }

    // Getters
    public String getRareza()    { return rareza; }
    public double getPrecioUSD() { return precioUSD; }

    // Setters
    public void setRareza(String rareza)       { this.rareza = rareza; }
    public void setPrecioUSD(double precioUSD) { this.precioUSD = precioUSD; }

    @Override
    public String toString() {
        return "Carta{id='" + getId() + "', nombre='" + getNombre() +
               "', rareza='" + rareza + "', precioUSD=" + precioUSD + "}";
    }
}
