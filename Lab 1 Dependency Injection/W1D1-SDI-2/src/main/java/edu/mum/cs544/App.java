package edu.mum.cs544;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {

		//Old code
//		IProductService productService = new ProductService();

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		//Below 2 line codes same
//		ProductService productService = context.getBean("productService", ProductService.class);
		IProductService productService = context.getBean("productService", IProductService.class);


//		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//
//		IProductService productService = context.getBean("productService", IProductService.class);

		Product product1 = productService.getProduct(423);
		if (product1 != null) {
			System.out.println(product1.toString());
		}
		Product product2 = productService.getProduct(239);
		if (product2 != null) {
			System.out.println(product2.toString());
		}


		//SDI.2
		System.out.println("We have " + productService.getNumberInStock(423) + " products with 423");
		System.out.println("We have " + productService.getNumberInStock(239) + " products with 239");
	}
}
