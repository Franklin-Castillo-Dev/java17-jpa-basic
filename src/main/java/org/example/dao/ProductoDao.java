package org.example.dao;

import org.example.models.Producto;
import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProductoDao {

    private EntityManager em;

    public ProductoDao(EntityManager em) {
        this.em = em;
    }

    public void guardar(Producto producto){
        this.em.persist(producto);
    }

    public void actualizar(Producto producto){
        this.em.merge(producto);
    }

    public Producto buscarPorId(Long id){
        return this.em.find(Producto.class, id);
    }

    public void eliminar(Producto producto){
        this.em.remove(producto);
    }

    public List<Producto> consultarTodos(){
        //jpql es la forma de hacer consultas sql desde JPA
        String jpql = "SELECT P FROM Producto AS P";
        return em.createQuery(jpql, Producto.class)
                .getResultList();
    }

    public List<Producto> consultaPorNombre(String nombre){
        //jpql es la forma de hacer consultas sql desde JPA
        // ACA TIENE QUE SER EL NOMBRE DE LA ENTIDAD EN EL MODELO
        // si se coloca el nombre de la tabla en la base y es diferente al nombre del modelo, fallara el codigo.
        String jpql = "SELECT P FROM Producto AS P WHERE P.nombre =:nombre";
        return em.createQuery(jpql, Producto.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public List<Producto> consultaPorCategoria(String nombre){
        //jpql es la forma de hacer consultas sql desde JPA
        // ACA TIENE QUE SER EL NOMBRE DE LA ENTIDAD EN EL MODELO
        // si se coloca el nombre de la tabla en la base y es diferente al nombre del modelo, fallara el codigo.
        String jpql = "SELECT P FROM Producto AS P WHERE P.categoria.name =:nombre";
        return em.createQuery(jpql, Producto.class)
                .setParameter("nombre", nombre)
                .getResultList();
    }

    public BigDecimal consultaPrecioFiltrarPorNombreProducto(String nombre){
        //jpql es la forma de hacer consultas sql desde JPA
        // ACA TIENE QUE SER EL NOMBRE DE LA ENTIDAD EN EL MODELO
        // si se coloca el nombre de la tabla en la base y es diferente al nombre del modelo, fallara el codigo.
        String jpql = "SELECT P.precio FROM Producto AS P WHERE P.nombre =:nombre";
        return em.createQuery(jpql, BigDecimal.class)
                .setParameter("nombre", nombre)
                .getSingleResult();
    }
}
