package com.example.SkillExperiment6;

import java.util.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
	
	@GetMapping("/welcome")
	public String show()
	{
		return "Welcome to Spring Controller";
	}
	
	@GetMapping("/count")
	public int totalBooks()
	{
		return 100;
	}

	@GetMapping("/price")
	public double bookPrice()
	{
		return 1000.d;
	}

	String booknames[] = {"java", "dotnet", "react"};

	@GetMapping("/books")
	public List<String> bookTitles()
	{
		return Arrays.asList(booknames);
	}

	@GetMapping("/books/{id}")
	public String bookDetails(@PathVariable int id)
	{
		return "The book details are " + id;
	}

	@GetMapping("/search")
	public String display(@RequestParam String title)
	{
		return "The title is " + title;
	}

	@GetMapping("/author/{name}")
	public String displayAuthor(@PathVariable String name)
	{
		return "The author name is " + name;
	}

	List<Book> booklist = new ArrayList<>();

	@PostMapping("/addbook")
	public void addBook(@RequestBody Book b)
	{
		booklist.add(b);
	}
}
