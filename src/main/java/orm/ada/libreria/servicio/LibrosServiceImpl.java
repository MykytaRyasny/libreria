package orm.ada.libreria.servicio;

import orm.ada.libreria.dao.LibrosDAOJPAImpl;
import orm.ada.libreria.dao.LibrosDao;
import orm.ada.libreria.model.LibrosEntity;

import java.util.List;

public class LibrosServiceImpl implements LibrosServicio{

    private LibrosDao librosdao;

    public LibrosServiceImpl() {
        this.librosdao = new LibrosDAOJPAImpl();
    }

    @Override
    public List<LibrosEntity> findAll() {
        return this.librosdao.findAll();
    }

    @Override
    public boolean create(LibrosEntity libro) {
        this.librosdao.create(libro);
        return true;
    }
    @Override
    public LibrosEntity findOne(Integer id){
        return librosdao.findOne(id);
    }

    @Override
    public boolean update(LibrosEntity libros) {
        librosdao.update(libros);
        return true;
    }

    @Override
    public boolean delete(int id) {
        librosdao.delete(id);
        return true;
    }
}
