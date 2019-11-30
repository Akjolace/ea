package edu.mum.cs544;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("edu.mum.cs544")
public class Config {
    private List<IBookSupplier> suppliers = new ArrayList<IBookSupplier>();


    @Bean
    @Scope("prototype")
    public BookService bookService(List<IBookSupplier> suppliers){
        return new BookService(suppliers);
    }

//    @Qualifier
    @Bean
    public IBookSupplier amazon() {
        return new Amazon();
    }
    @Bean
    public IBookSupplier eBooks() {
        return new EBooks();
    }
    @Bean
    public IBookSupplier borders() {
        return new Borders();
    }
    @Bean
    public IBookSupplier barnesAndNoble() {
        return new BarnesAndNoble();
    }

    //    @Bean
//    @Scope("prototype")
//    public List<IBookSupplier> suppliers(){
//        List<IBookSupplier> suppliers = new ArrayList<>();
//        suppliers.add(new Amazon());
//        suppliers.add(new BarnesAndNoble());
//        suppliers.add(new EBooks());
//        suppliers.add(new Borders());
//        return suppliers;
//    }
}
