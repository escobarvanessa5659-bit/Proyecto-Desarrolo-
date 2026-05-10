package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Torneo {
    private String id;
    private String nombre;
    private LocalDateTime fecha;
    private int maxParticipantes;
    private List<Cliente> participantes;

    // Constructor completo
    public Torneo(String id, String nombre, LocalDateTime fecha, int maxParticipantes) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.maxParticipantes = maxParticipantes;
        this.participantes = new ArrayList<>();
    }

    // Constructor vacío
    public Torneo() {
        this.participantes = new ArrayList<>();
    }

    // Verifica si hay cupo disponible
    public boolean hayCupo() {
        return participantes.size() < maxParticipantes;
    }

    // Agrega un participante si hay cupo y no está inscrito ya
    public boolean agregarParticipante(Cliente cliente) {
        if (!hayCupo()) {
            return false; // sin cupo
        }
        for (Cliente c : participantes) {
            if (c.getId().equals(cliente.getId())) {
                return false; // ya inscrito
            }
        }
        participantes.add(cliente);
        return true;
    }

    // Getters
    public String getId()                     { return id; }
    public String getNombre()                 { return nombre; }
    public LocalDateTime getFecha()           { return fecha; }
    public int getMaxParticipantes()          { return maxParticipantes; }
    public List<Cliente> getParticipantes()   { return participantes; }

    // Setters
    public void setId(String id)                              { this.id = id; }
    public void setNombre(String nombre)                      { this.nombre = nombre; }
    public void setFecha(LocalDateTime fecha)                 { this.fecha = fecha; }
    public void setMaxParticipantes(int maxParticipantes)     { this.maxParticipantes = maxParticipantes; }
    public void setParticipantes(List<Cliente> participantes) { this.participantes = participantes; }

    @Override
    public String toString() {
        return "Torneo{id='" + id + "', nombre='" + nombre +
               "', fecha=" + fecha + ", maxParticipantes=" + maxParticipantes +
               ", participantes=" + participantes.size() + "}";
    }
}
