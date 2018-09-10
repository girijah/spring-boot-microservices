package com.nyl.CSSpringBootJPA;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication 
public class App {
	
	
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("application.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty("database"));
            System.out.println(prop.getProperty("spring.datasource.username"));
            System.out.println(prop.getProperty("spring.datasource.password"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        
        SpringApplication.run(App.class, args);
    }
    
    
}
