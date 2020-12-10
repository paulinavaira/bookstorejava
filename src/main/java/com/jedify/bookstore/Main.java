package com.jedify.bookstore;

import com.jedify.bookstore.classes.*;
import com.jedify.bookstore.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner initData(PurchaseRepository purchaseRepository, CustomerRepository customerRepository, AuthorRepository authorRepository, BookRepository bookRepository, StoreRepository storeRepository, StoreBookRepository storeBookRepository) {
        return args -> {

            // Authors
            Author fiodor_dostoievsky = new Author("Fiodor", "Dostoievsky", Nationality.RU);
            Author leon_tolstoi = new Author("Leon", "Tolstoi", Nationality.RU);
            Author jorge_luis_borges = new Author("Jorge Luis", "Borges", Nationality.AR);
            Author ernest_hemingway = new Author("Ernest", "Hemingway", Nationality.US);
            Author isabel_allende = new Author("Isabel", "Allende", Nationality.PE);
            Author gabriel_garcia_marquez = new Author("Gabriel", "García Márquez", Nationality.CO);
            Author j_r_r_tolkien = new Author("J.R.R.", "Tolkien", Nationality.ZA);
            Author isaac_asimov = new Author("Isaac", "Asimov", Nationality.RU);

            // Books
            Book crimen_y_castigo = new Book("Crimen y Castigo", fiodor_dostoievsky, Category.literatura_universal);
            Book los_hermanos_karamazov = new Book("Los Hermanos Karamazov", fiodor_dostoievsky, Category.literatura_universal);
            Book ana_karenina = new Book("Ana Karenina", leon_tolstoi, Category.literatura_universal);
            Book por_quien_doblan_las_campanas = new Book("Por quién doblan las campanas", ernest_hemingway, Category.literatura_universal);
            Book la_casa_de_los_espiritus = new Book("La casa de los espíritus", isabel_allende, Category.literatura_latinoamericana);
            Book cien_anos_de_soledad = new Book("Cien años de soledad", gabriel_garcia_marquez, Category.literatura_latinoamericana);
            Book el_aleph = new Book("El Aleph", jorge_luis_borges, Category.literatura_argentina);
            Book ficciones = new Book("Ficciones", jorge_luis_borges, Category.literatura_argentina);
            Book la_comunidad_del_anillo = new Book("La comunidad del Anillo", j_r_r_tolkien, Category.literatura_fantastica);
            Book las_dos_torres = new Book("Las dos torres", j_r_r_tolkien, Category.literatura_fantastica);
            Book el_retorno_del_rey = new Book("El retorno del rey", j_r_r_tolkien, Category.literatura_fantastica);
            Book yo_robot = new Book("Yo robot", isaac_asimov, Category.ciencia_ficcion);

            // Customers
            Customer prueba1 = new Customer("prueba1@gmail.com", "123456");
            Customer prueba2 = new Customer("prueba2@gmail.com", "1234567");

            // Stores
            Store buholibrosmicrocentro = new Store("Buho Libros Microcentro", "Av. Corrientes 823");
            Store buholibrosbelgrano = new Store("Buho Libros Belgrano", "Av. Cabildo 2537");
            Store buholibroscaballito = new Store("Buho Libros Caballito", "Av. Rivadavia 4815");
            Store libreriaflores = new Store("Librería Flores", "Av. Nazca 405");


            // Purchase
            Purchase primera = new Purchase(prueba1);
            Purchase segunda = new Purchase(prueba2);

            authorRepository.save(fiodor_dostoievsky);
            authorRepository.save(leon_tolstoi);
            authorRepository.save(jorge_luis_borges);
            authorRepository.save(jorge_luis_borges);
            authorRepository.save(ernest_hemingway);
            authorRepository.save(isabel_allende);
            authorRepository.save(gabriel_garcia_marquez);
            authorRepository.save(j_r_r_tolkien);
            authorRepository.save(isaac_asimov);

            bookRepository.save(crimen_y_castigo);
            bookRepository.save(los_hermanos_karamazov);
            bookRepository.save(ana_karenina);
            bookRepository.save(por_quien_doblan_las_campanas);
            bookRepository.save(la_casa_de_los_espiritus);
            bookRepository.save(cien_anos_de_soledad);
            bookRepository.save(el_aleph);
            bookRepository.save(ficciones);
            bookRepository.save(la_comunidad_del_anillo);
            bookRepository.save(las_dos_torres);
            bookRepository.save(el_retorno_del_rey);
            bookRepository.save(yo_robot);

            prueba1.addPurchasedBooks(crimen_y_castigo);
            prueba1.addPurchasedBooks(el_aleph);
            prueba2.addPurchasedBooks(ana_karenina);
            prueba2.addPurchasedBooks(los_hermanos_karamazov);

            customerRepository.save(prueba1);
            customerRepository.save(prueba2);

            storeRepository.save(buholibrosmicrocentro);
            storeRepository.save(buholibrosbelgrano);
            storeRepository.save(buholibroscaballito);
            storeRepository.save(libreriaflores);

            purchaseRepository.save(primera);
            purchaseRepository.save(segunda);

            StoreBook crimen_y_castigo_1 = new StoreBook(buholibrosmicrocentro, crimen_y_castigo, 5);
            StoreBook crimen_y_castigo_2 = new StoreBook(buholibrosbelgrano, crimen_y_castigo, 7);
            StoreBook crimen_y_castigo_3 = new StoreBook(buholibroscaballito, crimen_y_castigo, 3);
            StoreBook crimen_y_castigo_4 = new StoreBook(libreriaflores, crimen_y_castigo, 0);
            StoreBook los_hermanos_karamazov_1 = new StoreBook(buholibrosmicrocentro, los_hermanos_karamazov, 2);
            StoreBook los_hermanos_karamazov_2 = new StoreBook(buholibrosbelgrano, los_hermanos_karamazov, 4);
            StoreBook los_hermanos_karamazov_3 = new StoreBook(buholibroscaballito, los_hermanos_karamazov, 1);
            StoreBook los_hermanos_karamazov_4 = new StoreBook(libreriaflores, los_hermanos_karamazov, 5);
            StoreBook ana_karenina_1 = new StoreBook(buholibrosmicrocentro, ana_karenina, 0);
            StoreBook ana_karenina_2 = new StoreBook(buholibrosbelgrano, ana_karenina, 0);
            StoreBook ana_karenina_3 = new StoreBook(buholibroscaballito, ana_karenina, 0);
            StoreBook ana_karenina_4 = new StoreBook(libreriaflores, ana_karenina, 1);
            StoreBook el_aleph_1 = new StoreBook(buholibrosmicrocentro, el_aleph, 7);
            StoreBook el_aleph_2 = new StoreBook(buholibrosbelgrano, el_aleph, 4);
            StoreBook el_aleph_3 = new StoreBook(buholibroscaballito, el_aleph, 6);
            StoreBook el_aleph_4 = new StoreBook(libreriaflores, el_aleph, 3);

            storeBookRepository.save(crimen_y_castigo_1);
            storeBookRepository.save(crimen_y_castigo_2);
            storeBookRepository.save(crimen_y_castigo_3);
            storeBookRepository.save(crimen_y_castigo_4);
            storeBookRepository.save(los_hermanos_karamazov_1);
            storeBookRepository.save(los_hermanos_karamazov_2);
            storeBookRepository.save(los_hermanos_karamazov_3);
            storeBookRepository.save(los_hermanos_karamazov_4);
            storeBookRepository.save(ana_karenina_1);
            storeBookRepository.save(ana_karenina_2);
            storeBookRepository.save(ana_karenina_3);
            storeBookRepository.save(ana_karenina_4);
            storeBookRepository.save(el_aleph_1);
            storeBookRepository.save(el_aleph_2);
            storeBookRepository.save(el_aleph_3);
            storeBookRepository.save(el_aleph_4);
        };
    }
}
