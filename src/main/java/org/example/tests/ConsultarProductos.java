package org.example.tests;

import org.example.dao.CategoriaDao;
import org.example.dao.ProductoDao;
import org.example.models.Categoria;
import org.example.models.Producto;
import org.example.utils.JPAUtils;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ConsultarProductos {
    public static void main(String[] args) {
        //Consultas a Tabla
        // Obtenemos EntityManager desde el Utilitario
        EntityManager em = JPAUtils.getEntityManager();

        // Instanciamos DAO
        ProductoDao productoDao = new ProductoDao(em);

        //Inicia Transaccion Base
        em.getTransaction().begin();

        List<Producto> productosPorCategoria = productoDao.consultaPorCategoria("Software");
        productosPorCategoria.forEach(producto -> System.out.println(producto.getNombre()));

        System.out.println("-----------------");

        BigDecimal precioProducto = productoDao.consultaPrecioFiltrarPorNombreProducto("Windows");
        System.out.println(precioProducto + " .");
    }
}
