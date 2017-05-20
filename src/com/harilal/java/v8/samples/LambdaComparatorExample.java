package com.harilal.java.v8.samples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections.ListUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

public class LambdaComparatorExample {
	public static void main(String[] args) {
		Book book1 = new Book("Head First Java", 38.9f, "John");
		Book book2 = new Book("Thinking in Java", 30.0f, "McMillan");
		Book book3 = new Book("Effective Java", 50.0f, "James Gosling");
		Book book4 = new Book("Code Complete", 42.5f, "Uncle Bob");
		Book book11 = new Book("Java8", 150.0f, "Alan");
		Book book21 = new Book("Complete Reference: Java", 130.0f, "Bryan");
		Book book31 = new Book("Spring in Action", 150.0f, "James Gosling");
		Book book41 = new Book("AngularJS in Action", 142.5f, "Beck");

		List<Book> listBooks = Arrays.asList(book1, book2, book3, book4, book11, book21, book31, book41);
		List<Book> listBooks1 = Arrays.asList(book1, book2, book3, book4, book11, book21, book31, book41);
		System.out.println("Before sorting:");
		System.out.println(listBooks);

		Comparator<Book> customComparator = new Comparator<Book>() {
			public int compare(Book book1, Book book2) {
				int n = 0;
				n = (int) (book2.getPrice() - book1.getPrice());
				if (n == 0) {
					n = book1.getTitle().compareTo(book2.getTitle());
				}
				if (n == 0) {
					n = book1.getAuthor().compareTo(book2.getAuthor());
				}
				return n;
			}
		};

		Collections.sort(listBooks, customComparator);
		
		listBooks1.sort(Comparator.comparing(Book::getPrice).reversed().thenComparing(Book::getAuthor).thenComparing(Book::getTitle));

		System.out.println("\nAfter sorting by Custom Comparator:");
		System.out.println(StringUtils.join(listBooks, "\n"));
		System.out.println("\n\n"+StringUtils.join(listBooks1, "\n"));

		Comparator<Book> descPriceComp = (Book b1, Book b2) -> (int) (b2.getPrice() - b1.getPrice());

		Collections.sort(listBooks, descPriceComp);

		System.out.println("\nAfter sorting by descending price:");
		System.out.println(StringUtils.join(listBooks, "\n"));
		
		Collections.sort(listBooks, (b1, b2) -> (int) (b1.getPrice() - b2.getPrice()));

		System.out.println("\nAfter sorting by ascending price:");
		System.out.println(StringUtils.join(listBooks, "\n"));
	}
}

class Book {
	private String title;
	private float price;
	private String author;

	Book(String title, float price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}

	String getTitle() {
		return this.title;
	}

	void setTitle(String title) {
		this.title = title;
	}

	float getPrice() {
		return this.price;
	}

	void setPrice(float price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]";
	}

}