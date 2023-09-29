package org.example.tests;

import org.example.dao.CategoriaDao;
import org.example.models.Categoria;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;

public class UpdateCategoria {

    public static void main(String[] args) {

            //Update a Tabla
            // Obtenemos EntityManager desde el Utilitario
            EntityManager em = JPAUtils.getEntityManager();

            // Instanciamos DAO
            CategoriaDao categoriaDao = new CategoriaDao(em);

            //Inicia Transaccion Base
            em.getTransaction().begin();

            //Buscamos Categoria por ID
            Categoria busquedaCategoria = categoriaDao.buscarPorId(5l);

            // Modificamos Categoria
            busquedaCategoria.setName("cambiocategoriaaooo");

            categoriaDao.actualizar(busquedaCategoria);

            //Commit a base
            em.getTransaction().commit();
            em.close();

    }

}
