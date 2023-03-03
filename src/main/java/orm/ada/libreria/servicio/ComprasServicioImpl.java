package orm.ada.libreria.servicio;

import orm.ada.libreria.dao.ComprasDao;
import orm.ada.libreria.dao.ComprasDaoJPAImpl;
import orm.ada.libreria.model.ComprasEntity;

import java.util.List;

public class ComprasServicioImpl implements ComprasServicio{

    private ComprasDao comprasDao;

    public ComprasServicioImpl(){
        this.comprasDao = new ComprasDaoJPAImpl();
    }


    @Override
    public List<ComprasEntity> findAll() {
        return this.comprasDao.findAll();
    }

    @Override
    public boolean create(ComprasEntity compra) {
        this.comprasDao.create(compra);
        return true;
    }

    @Override
    public ComprasEntity findOne(Integer id) {
        return this.comprasDao.findOne(id);
    }

    @Override
    public boolean update(ComprasEntity compra) {
        this.comprasDao.update(compra);
        return true;
    }

    @Override
    public boolean delete(int id) {
        this.comprasDao.delete(id);
        return true;
    }
}
