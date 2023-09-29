package org.example.tests;

import org.example.dao.CategoriaDao;
import org.example.dao.ProductoDao;
import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroCategoria {
    public static void main(String[] args) {
        Categoria categoria = new Categoria("CELULARES");
        Categoria categoria2 = new Categoria("Consolas");
        Categoria categoria3 = new Categoria("Software");


        // Obtenemos EntityManager desde el Utilitario
        EntityManager em = JPAUtils.getEntityManager();

        // Instanciamos DAO
        CategoriaDao categoriaDao = new CategoriaDao(em);

        //Inicia Transaccion Base
        em.getTransaction().begin();

        //guardamos categoria
        categoriaDao.guardar(categoria);
        //guardamos categoria
        categoriaDao.guardar(categoria2);
        //guardamos categoria
        categoriaDao.guardar(categoria3);

        //Finalizamos con Commit
        em.getTransaction().commit();

        // Cerramos Conexion
        em.close();
    }
}
