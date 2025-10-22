package run;

import entities.Autor;
import entities.Categoria;
import entities.Libro;
import services.interfaces.ICRUD;
import services.dao.MyDao;

import java.util.List;

public class Main {
    public static final ICRUD dao = new MyDao();

    public static void insertarAutor() {
        Autor a = new Autor();
        a.setNombre("Gabriel Garcia Marquez");
        a.setNacionalidad("Mexicana");
        dao.insert(a);

        Autor r = new Autor();
        r.setNombre("Ruben Dario");
        r.setNacionalidad("Nicaraguense");
        dao.insert(r);
    }

    public static void listarAutores() {
        System.out.println("Registro Almacenados:");
        List<Autor> autores = dao.getAll("autores.All", Autor.class);
        autores.forEach(autor -> System.out.println(autor.getNombre()));
    }

    public static void editarAutor() {
        Autor a = new Autor();
        a = dao.findById(1, Autor.class);
        a.setNacionalidad("Colombiana");
        dao.update(a);
    }

    public static void eliminarAutor() {
        Autor a = new Autor();
        a = dao.findById(2, Autor.class);
        dao.delete(a);
    }

    public static void insertarCategoria() {
        Categoria c = new Categoria();
        c.setNombre("Novela");
        dao.insert(c);

        Categoria c2 = new Categoria();
        c.setNombre("Ficcion");
        dao.insert(c2);
    }

    public static void listarCategorias() {
        System.out.println("Registro Almacenados:");
        List<Categoria> categorias = dao.getAll("categorias.All", Categoria.class);
        categorias.forEach(categoria -> System.out.println(categoria.getNombre()));
    }

    public static void editarCategoria() {
        Categoria c = new Categoria();
        c = dao.findById(1, Categoria.class);
        c.setNombre("Romance");
        dao.update(c);
    }

    public static void eliminarCategoria() {
        Categoria c = new Categoria();
        c = dao.findById(2, Categoria.class);
        dao.delete(c);
    }

    public static void insertarLibro() {
        Libro l = new Libro();
        l.setTitulo("Las Siete Moralejas del Perro");
        l.setAutor(dao.findById(1, Autor.class));
        l.setCategoria(dao.findById(1, Categoria.class));
        dao.insert(l);

        Libro l2 = new Libro();
        l2.setTitulo("El perro y Cangrejo");
        l2.setAutor(dao.findById(2, Autor.class));
        l2.setCategoria(dao.findById(2, Categoria.class));
        dao.insert(l2);
    }

    public static void listarLibros() {
        System.out.println("Registro Almacenados:");
        List<Libro> libros = dao.getAll("libros.All", Libro.class);
        libros.forEach(libro -> System.out.println(libro.getTitulo()));
    }

    public static void editarLibro() {
        Libro l = new Libro();
        l = dao.findById(1, Libro.class);
        l.setTitulo("Guia de POO");
        dao.update(l);
    }

    public static void eliminarLibro() {
        Libro l = new Libro();
        l = dao.findById(2, Libro.class);
        dao.delete(l);
    }

    public static void main(String[] args) {
        insertarAutor();
        listarAutores();
        editarAutor();
        listarAutores();
        eliminarAutor();
        listarAutores();

        insertarCategoria();
        listarCategorias();
        editarCategoria();
        listarCategorias();
        eliminarCategoria();
        listarCategorias();

        insertarLibro();
        listarLibros();
        editarLibro();
        listarLibros();
        eliminarLibro();
        listarLibros();
    }
}
