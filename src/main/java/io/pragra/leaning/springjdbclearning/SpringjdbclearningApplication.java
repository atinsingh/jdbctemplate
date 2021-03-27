package io.pragra.leaning.springjdbclearning;

import io.pragra.leaning.springjdbclearning.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjdbclearningApplication {


    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringjdbclearningApplication.class, args);

        UserDAO dao = context.getBean(UserDAO.class);
        dao.readAndPrintUsers();

    }

}
