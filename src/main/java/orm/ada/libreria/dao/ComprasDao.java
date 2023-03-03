package orm.ada.libreria.dao;


import orm.ada.libreria.model.ComprasEntity;

import java.util.List;

public interface ComprasDao {

    List<ComprasEntity> findAll();

    ComprasEntity findOne(int id);

    boolean create(ComprasEntity compras);

    boolean update(ComprasEntity compras);

    boolean delete(int id);
}
