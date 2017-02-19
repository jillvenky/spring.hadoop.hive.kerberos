package sagar.waghunde.spring.hadoop.integration;

import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World, let's play!" );
        String[] springConfig = {"spring-hadoop.xml"};
        ApplicationContext context = new ClassPathXmlApplicationContext(springConfig);
        AccessHdfs accessHdfs = context.getBean(AccessHdfs.class);
        accessHdfs.createDir();
        accessHdfs.countRecords();
    }
}
