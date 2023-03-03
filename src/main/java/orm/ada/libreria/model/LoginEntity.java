package orm.ada.libreria.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "login", schema = "libreria", catalog = "")
public class LoginEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "usuario")
    private String usuario;
    @Basic
    @Column(name = "contrasenya")
    private String contrasenya;
    @Column(name = "privilegios")
    private Boolean privilegios;
    @OneToMany(mappedBy = "loginByLoginUsuario")
    private Collection<UsuariosEntity> usuariosByUsuario;

    public LoginEntity(String usuario, String contrasenya, Boolean privilegios) {
        this.usuario = usuario;
        this.contrasenya = contrasenya;
        this.privilegios = privilegios;
    }

    public LoginEntity() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenya() {
        return contrasenya;
    }

    public void setContrasenya(String contrasenya) {
        this.contrasenya = contrasenya;
    }

    public Boolean getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Boolean privilegios) {
        this.privilegios = privilegios;
    }

    public Collection<UsuariosEntity> getUsuariosByUsuario() {
        return usuariosByUsuario;
    }

    public void setUsuariosByUsuario(Collection<UsuariosEntity> usuariosByUsuario) {
        this.usuariosByUsuario = usuariosByUsuario;
    }
}
