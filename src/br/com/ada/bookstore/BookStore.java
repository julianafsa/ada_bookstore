package br.com.ada.bookstore;

import br.com.ada.bookstore.dao.impl.AlbumDaoImpl;
import br.com.ada.bookstore.model.Album;
import br.com.ada.bookstore.service.AlbumService;
import br.com.ada.bookstore.service.impl.AlbumServiceImpl;

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
        /*Book book1 = new Book("Dom Casmurro", new BigDecimal("30"));
        Book book2 = new Book("Iracema", new BigDecimal("25"));
        System.out.println("\n=== SAVE BOOK ===");
        BookService bookService = new BookServiceImpl(new BookDaoImpl());
        bookService.save(book1);
        bookService.save(book2);

        System.out.println("\n=== SEARCHING ALL ===");
        List<Book> list2 = bookService.findAll();
        list2.stream().forEach(System.out::println);

        // GAME
        Game game1 = new Game("Warcraft", new BigDecimal("300"));
        Game game2 = new Game("Fifa 2022", new BigDecimal("400"));
        GameService gameService = new GameServiceImpl(new GameDaoImpl());
        gameService.save(game1);
        gameService.save(game2);

        // MOVIE
        Movie movie1 = new Movie("Rambo", new BigDecimal("10"));
        Movie movie2 = new Movie("O Predador", new BigDecimal("15"));
        MovieService movieService = new MovieServiceImpl(new MovieDaoImpl());
        movieService.save(movie1);
        movieService.save(movie2);

        // TOY
        Toy toy1 = new Toy("Bicicleta Caloi", new BigDecimal("250"));
        Toy toy2 = new Toy("PlayStation 5", new BigDecimal("500"));
        ToyService toyService = new ToyServiceImpl(new ToyDaoImpl());
        toyService.save(toy1);
        toyService.save(toy2);*/

    }
}
