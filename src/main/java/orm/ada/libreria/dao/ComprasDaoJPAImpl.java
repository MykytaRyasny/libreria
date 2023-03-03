package orm.ada.libreria.dao;

import jakarta.persistence.EntityManager;
import orm.ada.libreria.model.ComprasEntity;
import orm.ada.libreria.util.JpaUtil;

import java.util.List;

public class ComprasDaoJPAImpl implements ComprasDao{
    @Override
    public List<ComprasEntity> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<ComprasEntity> comprasLista = em.createQuery("select c from ComprasEntity c", ComprasEntity.class).getResultList();
        return comprasLista;
    }

    @Override
    public ComprasEntity findOne(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        ComprasEntity compras = em.find(ComprasEntity.class, id);
        return compras;
    }

    @Override
    public boolean create(ComprasEntity compras) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(compras);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(ComprasEntity compras) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(compras);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(int id) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(findOne(id));
        em.getTransaction().commit();
        em.close();
        return true;
    }
}
