package orm.ada.libreria.dao;

import orm.ada.libreria.model.LibrosEntity;

import java.util.List;

public interface LibrosDao {

    List<LibrosEntity> findAll();

    LibrosEntity findOne(int id);

    boolean create(LibrosEntity libros);

    boolean update(LibrosEntity libros);

    boolean delete(int id);
}
