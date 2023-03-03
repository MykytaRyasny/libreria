package orm.ada.libreria.servicio;

import orm.ada.libreria.dao.LoginDAOJPAImpl;
import orm.ada.libreria.dao.LoginDao;
import orm.ada.libreria.model.LoginEntity;

import java.util.List;

public class LoginServicioImpl implements LoginServicio{

    private LoginDao loginDao;

    public LoginServicioImpl(){
        this.loginDao = new LoginDAOJPAImpl();
    }

    @Override
    public List<LoginEntity> findAll() {
        return loginDao.findAll();
    }

    @Override
    public LoginEntity findOne(String usuario) {
        return loginDao.findOne(usuario);
    }

    @Override
    public boolean create(LoginEntity user) {
        loginDao.create(user);
        return true;
    }

    @Override
    public boolean update(LoginEntity usuario) {
        loginDao.update(usuario);
        return true;
    }

    @Override
    public boolean delete(String usuario) {
        loginDao.delete(usuario);
        return true;
    }
}
