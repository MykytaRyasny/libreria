package orm.ada.libreria.dao;

import orm.ada.libreria.model.LoginEntity;
import orm.ada.libreria.model.UsuariosEntity;

import java.util.List;

public interface UsuariosDao {

    String nombreUsuario(String user);

    List<UsuariosEntity> findAll();

    UsuariosEntity findOne(String dni);

    boolean create(UsuariosEntity usuario);

    boolean update(UsuariosEntity usuario);

    boolean delete(String dni);
}
