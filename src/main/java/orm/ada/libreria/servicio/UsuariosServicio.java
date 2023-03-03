package orm.ada.libreria.servicio;

import orm.ada.libreria.model.LoginEntity;
import orm.ada.libreria.model.UsuariosEntity;

import java.util.List;

public interface UsuariosServicio {

    String nombreUsuario(String user);

    List<UsuariosEntity> findAll();

    UsuariosEntity findOne(String usuario);

    boolean create(UsuariosEntity user);

    boolean update(UsuariosEntity usuario);

    boolean delete(String usuario);
}
