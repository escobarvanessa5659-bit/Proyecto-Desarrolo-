package Servicio;

import modelo.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Sistema {
    private List<Usuario> usuarios;
    private Inventario inventario;
    private List<Torneo> torneos;

    // Constructor: inicializa el sistema con un admin por defecto
    public Sistema() {
        this.usuarios = new ArrayList<>();
        this.inventario = new Inventario();
        this.torneos = new ArrayList<>();

        // Usuario administrador por defecto (requerido por el enunciado)
        Usuario admin = new Usuario("admin-001", "Administrador", "admin@cards4play.com", "admin123", Rol.ADMIN);
        usuarios.add(admin);
    }

    // ─── Autenticación ────────────────────────────────────────────────────────

    public Usuario login(String email, String contrasenia) {
        for (Usuario u : usuarios) {
            if (u.autenticar(email, contrasenia)) {
                return u;
            }
        }
        return null; // credenciales inválidas
    }

    // ─── Gestión de usuarios ──────────────────────────────────────────────────

    public boolean registrarCliente(String nombre, String email, String contrasenia) {
        for (Usuario u : usuarios) {
            if (u.getEmail().equals(email)) {
                return false; // email ya registrado
            }
        }
        String id = UUID.randomUUID().toString();
        Cliente cliente = new Cliente(id, nombre, email, contrasenia);
        usuarios.add(cliente);
        return true;
    }

    public List<Usuario> getUsuarios() { return usuarios; }

    public Cliente buscarCliente(String id) {
        for (Usuario u : usuarios) {
            if (u instanceof Cliente && u.getId().equals(id)) {
                return (Cliente) u;
            }
        }
        return null;
    }

    // ─── Inventario ───────────────────────────────────────────────────────────

    public Inventario getInventario() { return inventario; }

    // ─── Torneos ──────────────────────────────────────────────────────────────

    public Torneo crearTorneo(String nombre, LocalDateTime fecha, int maxParticipantes) {
        String id = UUID.randomUUID().toString();
        Torneo torneo = new Torneo(id, nombre, fecha, maxParticipantes);
        torneos.add(torneo);
        return torneo;
    }

    public boolean inscribirClienteEnTorneo(String clienteId, String torneoId) {
        Cliente cliente = buscarCliente(clienteId);
        Torneo torneo = buscarTorneo(torneoId);
        if (cliente == null || torneo == null) return false;
        boolean inscrito = torneo.agregarParticipante(cliente);
        if (inscrito) {
            cliente.inscribirse(torneo);
        }
        return inscrito;
    }

    public Torneo buscarTorneo(String id) {
        for (Torneo t : torneos) {
            if (t.getId().equals(id)) return t;
        }
        return null;
    }

    public List<Torneo> getTorneos() { return torneos; }

    // ─── Compras ──────────────────────────────────────────────────────────────

    public Compra registrarCompra(String clienteId, List<String> productosIds) {
        Cliente cliente = buscarCliente(clienteId);
        if (cliente == null) return null;

        String id = UUID.randomUUID().toString();
        Compra compra = new Compra(id, LocalDateTime.now());

        for (String pid : productosIds) {
            Producto p = inventario.buscarProducto(pid);
            if (p != null) {
                compra.agregarProducto(p);
            }
        }
        cliente.comprar(compra);
        return compra;
    }

    // Setters para persistencia
    public void setUsuarios(List<Usuario> usuarios)    { this.usuarios = usuarios; }
    public void setInventario(Inventario inventario)   { this.inventario = inventario; }
    public void setTorneos(List<Torneo> torneos)       { this.torneos = torneos; }
}
