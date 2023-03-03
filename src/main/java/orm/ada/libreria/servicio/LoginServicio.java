package orm.ada.libreria.servicio;

import orm.ada.libreria.model.LoginEntity;

import java.util.List;

public interface LoginServicio {

    List<LoginEntity> findAll();

    LoginEntity findOne(String usuario);

    boolean create(LoginEntity user);

    boolean update(LoginEntity usuario);

    boolean delete(String usuario);
}
