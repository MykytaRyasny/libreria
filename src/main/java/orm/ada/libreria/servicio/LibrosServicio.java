package orm.ada.libreria.servicio;

import orm.ada.libreria.model.LibrosEntity;

import java.util.List;

public interface LibrosServicio {

    List<LibrosEntity> findAll();

    boolean create(LibrosEntity libro);

    LibrosEntity findOne(Integer id);

    boolean update(LibrosEntity libros);

    boolean delete(int id);
}
