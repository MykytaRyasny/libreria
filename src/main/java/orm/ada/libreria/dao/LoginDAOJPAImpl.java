package orm.ada.libreria.dao;


import jakarta.persistence.EntityManager;
import orm.ada.libreria.model.LibrosEntity;
import orm.ada.libreria.model.LoginEntity;
import orm.ada.libreria.util.JpaUtil;

import java.util.List;

public class LoginDAOJPAImpl implements LoginDao {



    @Override
    public List<LoginEntity> findAll() {
        EntityManager em = JpaUtil.getEntityManager();
        List<LoginEntity> listaLogin = em.createQuery("select l from LoginEntity l", LoginEntity.class).getResultList();
        return listaLogin;
    }

    @Override
    public LoginEntity findOne(String usuario){
        EntityManager em = JpaUtil.getEntityManager();
        LoginEntity user = em.find(LoginEntity.class, usuario);
        em.close();
        return user;
    }

    @Override
    public boolean create(LoginEntity user) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(LoginEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(String usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(findOne(usuario));
        return true;
    }
}
