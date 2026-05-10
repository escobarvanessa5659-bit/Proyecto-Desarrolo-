package modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente extends Usuario {

    private List<Compra> historialCompras;
    private List<Torneo> torneosInscritos;

    // Constructor completo
    public Cliente(String id, String nombre, String email, String contrasenia) {
        super(id, nombre, email, contrasenia, Rol.CLIENTE);
        this.historialCompras = new ArrayList<>();
        this.torneosInscritos = new ArrayList<>();
    }

    // Constructor vacío
    public Cliente() {
        super();
        this.historialCompras = new ArrayList<>();
        this.torneosInscritos = new ArrayList<>();
    }

    // Registra una compra en el historial del cliente
    public void comprar(Compra compra) {
        historialCompras.add(compra);
    }

    // Registra un torneo en la lista del cliente
    public void inscribirse(Torneo torneo) {
        torneosInscritos.add(torneo);
    }

    // Getters
    public List<Compra> getHistorialCompras()   { return historialCompras; }
    public List<Torneo> getTorneosInscritos()   { return torneosInscritos; }

    // Setters (necesarios para Jackson)
    public void setHistorialCompras(List<Compra> historialCompras) {
        this.historialCompras = historialCompras;
    }
    public void setTorneosInscritos(List<Torneo> torneosInscritos) {
        this.torneosInscritos = torneosInscritos;
    }

    @Override
    public String toString() {
        return "Cliente{id='" + getId() + "', nombre='" + getNombre() +
               "', email='" + getEmail() + "'}";
    }
}
