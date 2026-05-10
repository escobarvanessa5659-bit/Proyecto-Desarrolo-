package App;

import Servicio.Sistema;
import Servicio.ServicioCambio;
import modelo.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        // Inicializar el sistema (ya incluye admin por defecto)
        Sistema sistema = new Sistema();
        ServicioCambio servicioCambio = new ServicioCambio();

        // ─── Registrar clientes ───────────────────────────────────────────────
        sistema.registrarCliente("Vanessa", "vanessa@gmail.com", "1234");
        sistema.registrarCliente("Oscar", "oscar@gmail.com", "5678");

        // ─── Agregar productos al inventario ──────────────────────────────────
        Carta carta1 = new Carta("c1", "Charizard", "Carta de fuego legendaria", 45.0, "Legendaria");
        Booster booster1 = new Booster("b1", "Booster Scarlet", "Sobre de 10 cartas", 12.0, 10);
        Accesorio accesorio1 = new Accesorio("a1", "Deck Box", "Caja para guardar cartas", 8.0);
        ProductoSellado sellado1 = new ProductoSellado("ps1", "Elite Trainer Box", "Caja sellada con accesorios", 55.0);

        sistema.getInventario().agregar(carta1);
        sistema.getInventario().agregar(booster1);
        sistema.getInventario().agregar(accesorio1);
        sistema.getInventario().agregar(sellado1);

        // ─── Convertir precio de carta de USD a COP ───────────────────────────
        double precioCOP = carta1.calcularPrecioCOP(servicioCambio);
        System.out.println("Precio de " + carta1.getNombre() + " en COP: $" + precioCOP);

        // ─── Crear torneo ─────────────────────────────────────────────────────
        Torneo torneo = sistema.crearTorneo("Torneo Regional", LocalDateTime.of(2025, 8, 15, 10, 0), 3);
        System.out.println("Torneo creado: " + torneo.getNombre());

        // ─── Listar inventario ────────────────────────────────────────────────
        System.out.println("\n── Inventario ──");
        for (Producto p : sistema.getInventario().listar()) {
            System.out.println(p);
        }

        // ─── Login ────────────────────────────────────────────────────────────
        Usuario u = sistema.login("admin@cards4play.com", "admin123");
        if (u != null) {
            System.out.println("\nLogin exitoso: " + u.getNombre() + " | Admin: " + u.esAdmin());
        }
    }
}
