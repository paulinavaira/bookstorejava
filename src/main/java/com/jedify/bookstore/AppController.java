package com.jedify.bookstore;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.codec.cbor.Jackson2CborEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
@RestController
@RequestMapping("/api")
public class AppController {

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

    @GetMapping("/stores/{storeId}/books/{storeBooksId}")
    public List<Map<String,Object>> getOneBookOnStoreByBookId(@PathVariable long storeId, @PathVariable long storeBooksId){
        return storeBookRepository.findAll().stream().filter(aStore -> (aStore.getStore().getId())==storeId).filter(aBook -> (aBook.getBook().getId())==storeBooksId)
                .map(StoreBook::storeBookDTO).collect(Collectors.toList());
    }

    // P O S T (falta)

    @PostMapping("/books")
    public void addBook(@RequestBody Book book){
        bookRepository.save(book);
    }

    @PostMapping("/stores")
    public void addStore(@RequestBody Store store){
        storeRepository.save(store);
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