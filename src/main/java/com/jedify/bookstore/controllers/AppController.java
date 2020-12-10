package com.jedify.bookstore.controllers;

import com.jedify.bookstore.classes.*;
import com.jedify.bookstore.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.codec.cbor.Jackson2CborEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class AppController {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    StoreBookRepository storeBookRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    UserRepository userRepository;
//    @Autowired
//    PasswordEncoder passwordEncoder;

    // G E T

    @GetMapping("/authors")
    public List<Map<String,Object>> getAuthors(){
        return authorRepository.findAll().stream().map(Author::authorDTO).collect(Collectors.toList());
    }

    @GetMapping("/books")
    public List<Map<String,Object>> getBooks(){
        return bookRepository.findAll().stream().map(Book::bookDTO).collect(Collectors.toList());
    }

    @GetMapping("/stores")
    public List<Map<String,Object>> getStores(){
        return storeRepository.findAll().stream().map(Store::storeDTO).collect(Collectors.toList());
    }

    @GetMapping("/books/{bookId}")
    public List<Map<String,Object>> getBookById(@PathVariable long bookId){
        return bookRepository.findAll().stream().filter(book -> (book.getId())==bookId)
                .map(Book::bookDTO).collect(Collectors.toList());
    }

    @GetMapping("/stores/{storeId}")
    public List<Map<String,Object>> getStoreById(@PathVariable long storeId){
        return storeRepository.findAll().stream().filter(store -> (store.getId())==storeId)
                .map(Store::storeDTO).collect(Collectors.toList());
    }

    @GetMapping("/customers/{customerId}")
    public List<Map<String,Object>> getCustomerById(@PathVariable long customerId){
        return customerRepository.findAll().stream().filter(customer -> (customer.getId())==customerId)
                .map(Customer::customerDTO).collect(Collectors.toList());
    }

    @GetMapping("/stores/{storeId}/books")
    public List<Map<String,Object>> getBooksOnStoreByStoreId(@PathVariable long storeId){
        return storeBookRepository.findAll().stream().filter(aStore -> (aStore.getStore().getId())==storeId)
                .map(StoreBook::storeBookDTO).collect(Collectors.toList());
    }

    @GetMapping("/customers/{customerId}/books")
    public List<Map<String,Object>> getBooksOnCustomerByCustomerId(@PathVariable long customerId){
        return purchaseRepository.findAll().stream().filter(aCustomer -> (aCustomer.getCustomer().getId())==customerId)
                .map(Purchase::purchaseDTO).collect(Collectors.toList());
    }

    @GetMapping("/authors/{authorId}/books")
    public List<Map<String,Object>> getBooksOnAuthorByAuthorId(@PathVariable long authorId){
        return bookRepository.findAll().stream().filter(anAuthor -> (anAuthor.getAuthor().getId())==authorId)
                .map(Book::bookDTO).collect(Collectors.toList());
    }

    @GetMapping("/stores/{storeId}/books/{storeBooksId}")
    public List<Map<String,Object>> getOneBookOnStoreByBookId(@PathVariable long storeId, @PathVariable long storeBooksId){
        return storeBookRepository.findAll().stream().filter(aStore -> (aStore.getStore().getId())==storeId).filter(aBook -> (aBook.getBook().getId())==storeBooksId)
                .map(StoreBook::storeBookDTO).collect(Collectors.toList());
    }

    // P O S T (falta)

    @PostMapping("/authors")
    public void addAuthor(@RequestBody Author author){
        authorRepository.save(author);
    }

    @PostMapping("/stores")
    public void addStore(@RequestBody Store store){
        storeRepository.save(store);
    }

    @PostMapping("/customers")
    public void addCustomer(@RequestBody Customer customer){
        customerRepository.save(customer);
    }

    @PostMapping("/authors/{authorId}/books")
    public void addBookInAuthor(@PathVariable Author authorId ,@RequestBody Book book) {
        Book prueba_1 = new Book(book.getTitle(), authorId, book.getCategory());
        bookRepository.save(prueba_1);
    }

    @PostMapping("/customers/{customerId}/books")
    public void addBookInCustomer(@PathVariable Customer customerId ,@RequestBody Book book) {
        Purchase prueba_1 = new Purchase(customerId);
        purchaseRepository.save(prueba_1);
    }

    @PostMapping("/stores/{storeId}/books/{bookId}")
    public void addBookInCustomer(@PathVariable Store storeId , @PathVariable Book bookId) {
        StoreBook prueba_2 = new StoreBook(storeId, bookId, 5);
        storeBookRepository.save(prueba_2);
    }

    // P A T C H (falta)

    @PatchMapping("/stores/{storeId}/books/{storeBooksId}")
    public void modifyBookStockInLibrary(@RequestBody StoreBook storeBook) {
        storeBookRepository.save(storeBook);
    }

//    @RequestMapping(path = "/users", method = RequestMethod.POST)
//    public ResponseEntity<Map<String, Object>> createUser(@RequestParam String username, @RequestParam String password) {
//        ResponseEntity<Map<String, Object>> response;
//        User user = userRepository.findByUsername(username);
//        if(username.isEmpty() || password.isEmpty()) {
//            response = new ResponseEntity<>(makeMap("error", "No name"), HttpStatus.FORBIDDEN);
//        } else if (user != null) {
//            response = new ResponseEntity<>(makeMap("error", "Username already exists"), HttpStatus.FORBIDDEN);
//        } else {
//            User newUser = userRepository.save(new User(username,passwordEncoder.encode(password)));
//            response = new ResponseEntity<>(makeMap("id", newUser.getId()), HttpStatus.CREATED);
//        }
//        return response;
//    }
//
//    private Map<String, Object> makeMap(String key, Object value) {
//        Map<String, Object> map = new HashMap<>();
//        map.put(key, value);
//        return map;
//    }

}