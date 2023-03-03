package orm.ada.libreria.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(name = "compras", schema = "libreria", catalog = "")
public class ComprasEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_C", nullable = false)
    private Integer idC;
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Usuarios_DNI", referencedColumnName = "DNI", nullable = false)
    private UsuariosEntity usuariosByUsuariosDni;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "ID_L_FK", nullable = false)
    private LibrosEntity libro;


    public ComprasEntity() {
    }

    public ComprasEntity(Integer idC, UsuariosEntity usuariosByUsuariosDni, LibrosEntity libro) {
        this.idC = idC;
        this.usuariosByUsuariosDni = usuariosByUsuariosDni;
        this.libro = libro;
    }

    public Integer getIdC() {
        return idC;
    }

    public void setIdC(Integer idC) {
        this.idC = idC;
    }

    public UsuariosEntity getUsuariosByUsuariosDni() {
        return usuariosByUsuariosDni;
    }

    public void setUsuariosByUsuariosDni(UsuariosEntity usuariosByUsuariosDni) {
        this.usuariosByUsuariosDni = usuariosByUsuariosDni;
    }


    public LibrosEntity getLibro() {
        return libro;
    }
    public void setLibro(LibrosEntity libro) {
        this.libro = libro;
    }

}
