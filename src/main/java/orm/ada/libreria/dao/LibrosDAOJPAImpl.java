package orm.ada.libreria.dao;

import jakarta.persistence.EntityManager;
import orm.ada.libreria.model.LibrosEntity;
import orm.ada.libreria.util.JpaUtil;

import java.util.List;

public class LibrosDAOJPAImpl implements LibrosDao {

    @Override
    public List<LibrosEntity> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<LibrosEntity> librosList = em.createQuery("select l from LibrosEntity l", LibrosEntity.class).getResultList();
        em.close();
        return librosList;
    }

    @Override
    public LibrosEntity findOne(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        LibrosEntity libro = em.find(LibrosEntity.class, id);
        em.close();
        return libro;
    }

    @Override
    public boolean create(LibrosEntity libro) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(libro);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(LibrosEntity libro) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(libro);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        LibrosEntity libro = em.find(LibrosEntity.class, id);
        if (libro != null) {
            em.remove(libro);
            em.getTransaction().commit();
            em.close();
            return true;
        } else {
            em.getTransaction().rollback();
            em.close();
            return false;
        }
    }
}
