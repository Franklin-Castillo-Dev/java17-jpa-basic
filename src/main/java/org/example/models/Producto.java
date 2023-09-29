package org.example.models;

/*Importar javax.Persistence (JPA), y no directamente hibernate porque si queremos cambiar a otra
* Nos tocaria cambiar esa importacion e implementacion en todo el codigo.
*/
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "producto")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;

    private LocalDate fechaDeRegistro = LocalDate.now();

    // Se utiliza ENUM cuando tenemos un conjunto LIMITADO YA ESTABLECIDO
    // EnumType.STRING lo ocupamos para que en la base se guarde el STRING, y no la POSICION.
    //@Enumerated(EnumType.STRING)
    //private CategoriaAntiguo categoria;

    // ManyToOne
    // En este contexto significa:
    // Muchos productos, tienen una categoria.
    @ManyToOne
    private Categoria categoria;


    public Producto(){

    }
    public Producto(String nombre, String descripcion, BigDecimal precio, Categoria categoria) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.categoria = categoria;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }
}
