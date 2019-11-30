package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App
{
	public static void main(String[] args) {
		//Old direct instantiate version
//		IBookService bookService = new BookService();

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		IBookService bookService1 = context.getBean("bookService", IBookService.class);
//		IBookService bookService2 = context.getBean("bookService", IBookService.class);
//		IBookService bookService3 = context.getBean("bookService", IBookService.class);
//		IBookService bookService4 = context.getBean("bookService", IBookService.class);


		bookService1.buy(new Book("123433267", "Harry Potter and the Order of the Phoenix", "J.K. Rowling"));
		System.out.println(bookService1);
        bookService1.buy(new Book("888832678", "Harry Potter and the Sorcerer's Stone" , "J.K. Rowling"));
		System.out.println(bookService1);
		bookService1.buy(new Book("999923156", "Harry Potter and the Goblet of Fire" ,"J.K. Rowling"));

		System.out.println(bookService1);
//		System.out.println(bookService2);
//		System.out.println(bookService3);
//		System.out.println(bookService4);

	}
}
