package orm.ada.libreria.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import orm.ada.libreria.model.LoginEntity;
import orm.ada.libreria.model.UsuariosEntity;
import orm.ada.libreria.util.JpaUtil;

import java.util.List;

public class UsuariosDAOJPAImpl implements  UsuariosDao{

    @Override
    public String nombreUsuario(String user) {
        EntityManager em = JpaUtil.getEntityManager();
        UsuariosEntity nombreUsuario = em.createQuery("SELECT u FROM UsuariosEntity u WHERE u.login_Usuario = :loginUsuario", UsuariosEntity.class)
                .setParameter("loginUsuario", user)
                .getSingleResult();
        return nombreUsuario.getNombre();
    }

    @Override
    public List<UsuariosEntity> findAll(){
        EntityManager em = JpaUtil.getEntityManager();
        List<UsuariosEntity> UsuariosList = em.createQuery("select u from UsuariosEntity u", UsuariosEntity.class).getResultList();
        em.close();
        return UsuariosList;
    }

    @Override
    public UsuariosEntity findOne(String dni) {
        EntityManager em = JpaUtil.getEntityManager();
        UsuariosEntity user = em.find(UsuariosEntity.class, dni);
        em.close();
        return user;
    }

    @Override
    public boolean create(UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean update(UsuariosEntity usuario) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(usuario);
        em.getTransaction().commit();
        em.close();
        return true;
    }

    @Override
    public boolean delete(String dni) {
        EntityManager em = JpaUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(findOne(dni));
        return true;
    }
}
