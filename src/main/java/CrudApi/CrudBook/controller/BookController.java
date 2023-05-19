package CrudApi.CrudBook.controller;

import CrudApi.CrudBook.entity.Book;
import CrudApi.CrudBook.exception.NotFoundException;
import CrudApi.CrudBook.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/api/v1/books")
public class BookController {
    @Autowired
    private IBookRepository bookRepository;
    @GetMapping
    //Tìm tất cả sách
    public List<Book> getAllBook()
    {
        return bookRepository.findAll();
    }
    //them 1 quyển sách
    @PostMapping
    public Book createBook(@RequestBody Book book){

        return bookRepository.save(book);
    }
    //
    @GetMapping("{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id){
        Book book = bookRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Không tìm thấy mã sách: "+id));
        return ResponseEntity.ok(book);
    }
    //upadte chỉnh sủa 1 quyển sách
    @PutMapping("{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id,@RequestBody Book bookDetail){
        Book updateBook = bookRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Không tìm thấy mã sách: "+id));
        updateBook.setTitle(bookDetail.getTitle());
        updateBook.setAuthor(bookDetail.getAuthor());
        updateBook.setPrice(bookDetail.getPrice());
        updateBook.setImage(bookDetail.getImage());
        bookRepository.save(updateBook);
        return ResponseEntity.ok(updateBook);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable Long id)
    {
        Book deleteBook = bookRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Không tìm thấy mã sách: "+id));
        bookRepository.delete(deleteBook);
        return ResponseEntity.ok(deleteBook);
    }
}
