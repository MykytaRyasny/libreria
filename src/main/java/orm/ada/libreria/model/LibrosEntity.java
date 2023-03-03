package orm.ada.libreria.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "libros", schema = "libreria", catalog = "")
public class LibrosEntity implements Serializable {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID_L")
    private Integer idL;
    @Basic
    @Column(name = "Titulo")
    private String titulo;
    @Basic
    @Column(name = "Autor")
    private String autor;
    @Basic
    @Column(name = "Editorial")
    private String editorial;
    @Basic
    @Column(name = "Anyo_edicion")
    private Integer anyoEdicion;

    @Lob
    @Column(name = "Image")
    private byte[] image;


    public LibrosEntity(Integer idL, int anyoEdicion, String autor, String editorial, String titulo, byte[] image) {
        this.anyoEdicion = anyoEdicion;
        this.autor = autor;
        this.editorial = editorial;
        this.titulo = titulo;
        this.image = image;
    }

    public LibrosEntity() {
    }

    public Integer getIdL() {
        return idL;
    }

    public void setIdL(Integer idL) {
        this.idL = idL;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getAnyoEdicion() {
        return anyoEdicion;
    }

    public void setAnyoEdicion(Integer anyoEdicion) {
        this.anyoEdicion = anyoEdicion;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
