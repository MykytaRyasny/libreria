package orm.ada.libreria.servicio;

import orm.ada.libreria.dao.UsuariosDAOJPAImpl;
import orm.ada.libreria.dao.UsuariosDao;
import orm.ada.libreria.model.LoginEntity;
import orm.ada.libreria.model.UsuariosEntity;

import java.util.List;

public class UsuariosServiceImpl implements UsuariosServicio{

    private UsuariosDao usuariosDao;

    public UsuariosServiceImpl(){
        this.usuariosDao = new UsuariosDAOJPAImpl();
    }

    @Override
    public String nombreUsuario(String user) {
        return usuariosDao.nombreUsuario(user);
    }

    @Override
    public List<UsuariosEntity> findAll() {
        return usuariosDao.findAll();
    }

    @Override
    public UsuariosEntity findOne(String dni) {
        return usuariosDao.findOne(dni);
    }

    @Override
    public boolean create(UsuariosEntity user) {
        usuariosDao.create(user);
        return true;
    }

    @Override
    public boolean update(UsuariosEntity usuario) {
        usuariosDao.update(usuario);
        return true;
    }

    @Override
    public boolean delete(String usuario) {
        usuariosDao.delete(usuario);
        return true;
    }
}
