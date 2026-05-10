package Servicio;

public class ServicioCambio {
    /*
     * NOTA: En producción esta tasa debe obtenerse de una API externa.
     * Por ejemplo: https://api.exchangerate-api.com/v4/latest/USD
     * Por ahora se usa una tasa fija como valor por defecto.
     */
    private String urlAPI = "https://api.exchangerate-api.com/v4/latest/USD";
    private double tasaActual = 4200.0; // 1 USD = 4200 COP (valor por defecto)

    // Retorna la tasa de cambio actual (en implementación real, consulta la API)
    public double obtenerTasa() {
        return tasaActual;
    }

    // Convierte de USD a COP
    public double convertirUSDaCOP(double montoUSD) {
        return montoUSD * tasaActual;
    }

    // Convierte de COP a USD
    public double convertirCOPaUSD(double montoCOP) {
        return montoCOP / tasaActual;
    }

    // Getters y Setters
    public String getUrlAPI()           { return urlAPI; }
    public void setUrlAPI(String url)   { this.urlAPI = url; }
    public void setTasaActual(double t) { this.tasaActual = t; }
}
