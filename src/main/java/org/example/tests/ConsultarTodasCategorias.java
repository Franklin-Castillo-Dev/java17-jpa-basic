package org.example.tests;

import org.example.dao.CategoriaDao;
import org.example.models.Categoria;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.util.List;

public class ConsultarTodasCategorias {
    public static void main(String[] args) {
        //Consultas a Tabla
        // Obtenemos EntityManager desde el Utilitario
        EntityManager em = JPAUtils.getEntityManager();

        // Instanciamos DAO
        CategoriaDao categoriaDao = new CategoriaDao(em);

        //Inicia Transaccion Base
        em.getTransaction().begin();

        List<Categoria> categoriasList = categoriaDao.consultarTodos();
        categoriasList.forEach(categoria -> System.out.println(categoria.getName()));

        System.out.println("-----------------");


    }
}
