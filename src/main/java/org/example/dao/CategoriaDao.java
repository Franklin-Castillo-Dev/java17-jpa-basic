package org.example.dao;

import org.example.models.Categoria;
import javax.persistence.EntityManager;
import java.util.List;

public class CategoriaDao {

    private EntityManager em;

    public CategoriaDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Categoria categoria){
        this.em.persist(categoria);
    }

    public void actualizar(Categoria categoria){
        this.em.merge(categoria);
    }

    public Categoria buscarPorId(Long id){
        return this.em.find(Categoria.class, id);
    }

    public void eliminar(Categoria categoria){
        this.em.remove(categoria);
    }

    public List<Categoria> consultarTodos(){
        //jpql es la forma de hacer consultas sql desde JPA
        String jpql = "SELECT C FROM Categoria AS C";
        return em.createQuery(jpql, Categoria.class)
                .getResultList();
    }
}
