package modelo;

public class Usuario {
    private String id;
    private String nombre;
    private String email;
    private String contrasenia;
    private Rol rol;

    // Constructor completo
    public Usuario(String id, String nombre, String email, String contrasenia, Rol rol) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
        this.rol = rol;
    }

    // Constructor vacío
    public Usuario() {
    }

    // Verifica si las credenciales coinciden
    public boolean autenticar(String email, String contrasenia) {
        return this.email.equals(email) && this.contrasenia.equals(contrasenia);
    }

    // Indica si el usuario es administrador
    public boolean esAdmin() {
        return this.rol == Rol.ADMIN;
    }

    // Getters
    public String getId()          { return id; }
    public String getNombre()      { return nombre; }
    public String getEmail()       { return email; }
    public String getContrasenia() { return contrasenia; }
    public Rol getRol()            { return rol; }

    // Setters
    public void setId(String id)               { this.id = id; }
    public void setNombre(String nombre)       { this.nombre = nombre; }
    public void setEmail(String email)         { this.email = email; }
    public void setContrasenia(String c)       { this.contrasenia = c; }
    public void setRol(Rol rol)                { this.rol = rol; }

    @Override
    public String toString() {
        return "Usuario{id='" + id + "', nombre='" + nombre +
               "', email='" + email + "', rol=" + rol + "}";
    }
}
