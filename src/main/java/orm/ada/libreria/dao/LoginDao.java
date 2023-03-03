package orm.ada.libreria.dao;

import orm.ada.libreria.model.LoginEntity;

import java.util.List;

public interface LoginDao {

    List<LoginEntity> findAll();

    LoginEntity findOne(String usuario);

    boolean create(LoginEntity user);

    boolean update(LoginEntity usuario);

    boolean delete(String usuario);
}
