package br.com.ada.bookstore;

import br.com.ada.bookstore.dao.impl.*;
import br.com.ada.bookstore.model.*;
import br.com.ada.bookstore.service.*;
import br.com.ada.bookstore.service.impl.*;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class BookStore {

    public static void main(String[] args) {
        // ALBUM
        Album album1 = new Album("Physical Graffiti", new BigDecimal("55"));
        album1.setGenres(Arrays.asList("Rock"));
        Album album2 = new Album("Led Zeppelin IV", new BigDecimal("45"));
        AlbumService albumService = new AlbumServiceImpl(new AlbumDaoImpl());
        System.out.println("\n=== SAVE ALBUM ===");
        albumService.save(album1);
        albumService.save(album2);

        /*System.out.println("\n=== UPDATING ALBUM ===");
        Album updatedAlbum1 = new Album("Physical Graffiti", new BigDecimal("60"));
        updatedAlbum1.setId(album1.getId());
        Album updatedAlbum2 = new Album("Physical Graffiti", new BigDecimal("48"));
        updatedAlbum2.setId(album2.getId());
        albumService.update(updatedAlbum1);
        albumService.update(updatedAlbum2);
        List<Album> list = albumService.findAll();
        list.stream().forEach(System.out::println);

        System.out.println("\n=== SEARCHING ALBUM ===");
        Product foundedAlbum1 = albumService.findById(1L);
        System.out.println("Album encontrado: " + foundedAlbum1);
        Product foundedAlbum2 = albumService.findById(2L);
        System.out.println("Album encontrado: " + foundedAlbum2);*/

        System.out.println("\n=== SEARCHING ALL ===");
        List<Album> list = albumService.findAll();
        list.stream().forEach(System.out::println);

//        System.out.println("\n=== REMOVING ===");
//        albumService.remove(1L);
//        list.stream().forEach(System.out::println);

        // BOOK
        Book book1 = new Book("Dom Casmurro", new BigDecimal("30"));
        Book book2 = new Book("Iracema", new BigDecimal("25"));
        System.out.println("\n=== SAVE BOOK ===");
        BookService bookService = new BookServiceImpl(new BookDaoImpl());
        bookService.save(book1);
        bookService.save(book2);

//        System.out.println("\n=== SEARCHING ALL ===");
//        List<Book> bookList = bookService.findAll();
//        bookList.stream().forEach(System.out::println);

        System.out.println("\n=== SEARCHING ALL PRODUCTS ===");
        ProductService productService = new ProductServiceImpl(new ProductDaoImpl());
        List<Product> allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        Product book3 = new Book("O Irmão Alemão", new BigDecimal("15"));
        productService.save(book3);
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        // GAME
        Product game1 = new Game("Warcraft", new BigDecimal("300"));
        Product game2 = new Game("Fifa 2022", new BigDecimal("400"));
        //GameService gameService = new GameServiceImpl(new GameDaoImpl());
        productService.save(game1);
        productService.save(game2);
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        // MOVIE
        Movie movie1 = new Movie("Rambo", new BigDecimal("10"));
        Movie movie2 = new Movie("O Predador", new BigDecimal("15"));
//        MovieService movieService = new MovieServiceImpl(new MovieDaoImpl());
//        movieService.save(movie1);
//        movieService.save(movie2);
        productService.save(movie1);
        productService.save(movie2);
        System.out.println("");
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        // TOY
        Toy toy1 = new Toy("Bicicleta Caloi", new BigDecimal("250"));
        Toy toy2 = new Toy("PlayStation 5", new BigDecimal("500"));
//        ToyService toyService = new ToyServiceImpl(new ToyDaoImpl());
//        toyService.save(toy1);
//        toyService.save(toy2);
        System.out.println("");
        productService.save(toy1);
        productService.save(toy2);
        System.out.println("");
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        Product foundedItem = productService.findById(7L);
        System.out.println(foundedItem);

        System.out.println("");
        movie1.setProducers(Arrays.asList("Silverter Stalone"));
        productService.update(movie1);
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

        productService.remove(5L);
        allList = productService.findAll();
        allList.stream().forEach(System.out::println);

    }
}
