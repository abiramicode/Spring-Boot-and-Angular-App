package in.abiramiit.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import in.abiramiit.binding.Book;

@RestController
public class BookRestController {

	@GetMapping("/book{id}")
	public Book getBook(@PathVariable("id") Integer id) {
		Book b = new Book(id,"",2500.00);
		return b;
	}
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		
		Book b1 = new Book(501, "Java", 2500.00);
		Book b2 = new Book(502, "Python", 2500.00);
		Book b3 = new Book(503, "Devops", 2500.00);
		
		List<Book> books = Arrays.asList(b1,b2,b3);
		return books;
		
	}
	
	@PostMapping("/book")
	public ResponseEntity<String> saveBook(Book book) {
		System.out.println(book);
		return new ResponseEntity<>("Book Saved", HttpStatus.CREATED);
	}
}
