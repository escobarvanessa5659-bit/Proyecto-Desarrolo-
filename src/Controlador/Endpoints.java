package Controlador;

import Servicio.Sistema;

/*
 * Esta clase define los endpoints de la API REST.
 * Debe conectarse al microframework que se use (ej: Javalin, Spark, etc.)
 *
 * Endpoints sugeridos:
 *
 * POST   /auth/login                          → autenticar usuario
 * POST   /clientes                            → registrar cliente
 * GET    /clientes                            → listar clientes (ADMIN)
 * GET    /clientes/{id}/historial             → historial de compras del cliente
 *
 * GET    /inventario                          → listar productos
 * POST   /inventario/cartas                   → agregar carta (ADMIN)
 * POST   /inventario/boosters                 → agregar booster (ADMIN)
 * POST   /inventario/sellados                 → agregar producto sellado (ADMIN)
 * POST   /inventario/accesorios               → agregar accesorio (ADMIN)
 * DELETE /inventario/{id}                     → eliminar producto (ADMIN)
 *
 * GET    /torneos                             → listar torneos
 * POST   /torneos                             → crear torneo (ADMIN)
 * POST   /torneos/{id}/inscribir/{clienteId}  → inscribir cliente en torneo
 *
 * POST   /compras                             → registrar compra
 */
public class Endpoints {
    private Sistema sistema;

    public Endpoints(Sistema sistema) {
        this.sistema = sistema;
    }

    public Sistema getSistema() { return sistema; }
}
