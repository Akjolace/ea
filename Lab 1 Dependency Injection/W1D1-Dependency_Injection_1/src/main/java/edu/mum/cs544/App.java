package edu.mum.cs544;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    //	Run|Debug;
    public static void main(String[] args) {

//        //Java Config
//        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
//        Greeting greeting = context.getBean("greeting", Greeting.class);
//        greeting.sayHello();

        //XML config
        ApplicationContext contextXml = new ClassPathXmlApplicationContext("springconfig.xml");
        Greeting greetingXml = contextXml.getBean("greeting", Greeting.class);
        greetingXml.sayHello();


//	public static void main(String[] args) {
//		IProductService productService = new ProductService();
//
//		Product product1 = productService.getProduct(423);
//		if (product1 != null) {
//			System.out.println(product1.toString());
//		}
//		Product product2 = productService.getProduct(239);
//		if (product2 != null) {
//			System.out.println(product2.toString());
//		}
//	}


    }


}
