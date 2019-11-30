package edu.mum.cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan("edu.mum.cs544")
public class Config {
    @Bean
    @Scope("prototype")
    public BookService bookService(){
        return new BookService();
    }

    @Bean
    @Scope("prototype")
    public List<IBookSupplier> suppliers(){
        List<IBookSupplier> suppliers = new ArrayList<>();
        suppliers.add(new Amazon());
        suppliers.add(new BarnesAndNoble());
        suppliers.add(new EBooks());
        suppliers.add(new Borders());
        return suppliers;
    }
}
