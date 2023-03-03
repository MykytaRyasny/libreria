package orm.ada.libreria.servicio;

import orm.ada.libreria.model.ComprasEntity;

import java.util.List;

public interface ComprasServicio {
    List<ComprasEntity> findAll();

    boolean create(ComprasEntity compra);

    ComprasEntity findOne(Integer id);

    boolean update(ComprasEntity compra);

    boolean delete(int id);
}
