package org.example.tests;

import org.example.dao.CategoriaDao;
import org.example.dao.ProductoDao;
import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

public class RegistroDeProducto {

    public static void main(String[] args) {


        Categoria celularCategoria = new Categoria("Software");

        Producto celular = new Producto(
                "Windows",
                "Windows Nuevo",
                new BigDecimal(400),
                celularCategoria
        );


        // Obtenemos EntityManager desde el Utilitario
        EntityManager em = JPAUtils.getEntityManager();

        // Instanciamos DAO
        ProductoDao productoDao = new ProductoDao(em);
        CategoriaDao categoriaDao = new CategoriaDao(em);

        //Inicia Transaccion Base
        em.getTransaction().begin();

        //guardamos categoria
        categoriaDao.guardar(celularCategoria);

        // Guardamos Producto
        productoDao.guardar(celular);

        //Finalizamos con Commit
        em.getTransaction().commit();

        // Cerramos Conexion
        em.close();

    }
}
