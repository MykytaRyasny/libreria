package orm.ada.libreria.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "usuarios", schema = "libreria", catalog = "")
public class UsuariosEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "DNI")
    private int dni;
    @Basic
    @Column(name = "Nombre")
    private String nombre;
    @Basic
    @Column(name = "Apellido")
    private String apellido;
    @Basic
    @Column(name = "Telefono")
    private Integer telefono;
    @Basic
    @Column(insertable=false, updatable=false)
    private String login_Usuario;
    @OneToMany(mappedBy = "usuariosByUsuariosDni")
    private Collection<ComprasEntity> comprasByDni;
    @ManyToOne
    @JoinColumn(name = "login_usuario", referencedColumnName = "usuario", nullable = false)
    private LoginEntity loginByLoginUsuario;

    public UsuariosEntity(int dni, String nombre, String apellido, Integer telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    public UsuariosEntity() {
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public String getLoginUsuario() {
        return login_Usuario;
    }

    public void setLoginUsuario(String loginUsuario) {
        this.login_Usuario = loginUsuario;
    }

    public Collection<ComprasEntity> getComprasByDni() {
        return comprasByDni;
    }

    public void setComprasByDni(Collection<ComprasEntity> comprasByDni) {
        this.comprasByDni = comprasByDni;
    }

    public LoginEntity getLoginByLoginUsuario() {
        return loginByLoginUsuario;
    }

    public void setLoginByLoginUsuario(LoginEntity loginByLoginUsuario) {
        this.loginByLoginUsuario = loginByLoginUsuario;
    }
}
