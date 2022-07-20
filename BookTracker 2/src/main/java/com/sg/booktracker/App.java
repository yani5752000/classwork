package com.sg.booktracker;

import com.sg.booktracker.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        BookView view = new BookView(io);
//        
//        BookDao dao = new BookDaoMemoryImpl();
//        BookService service = new BookService(dao);
//        
//        BookController controller = new BookController(service, view);
//        controller.run();

        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.booktracker");
        appContext.refresh();

        BookController controller = appContext.getBean("bookController", BookController.class);
        controller.run();
    }
}
