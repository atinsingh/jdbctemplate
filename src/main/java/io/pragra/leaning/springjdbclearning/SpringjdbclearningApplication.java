package io.pragra.leaning.springjdbclearning;

import io.pragra.leaning.springjdbclearning.dao.UserDAO;
import io.pragra.leaning.springjdbclearning.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjdbclearningApplication {


    public static void main(String[] args) {
        ApplicationContext context =  SpringApplication.run(SpringjdbclearningApplication.class, args);

        UserDAO dao = context.getBean(UserDAO.class);
       // dao.readAndPrintUsers();

        //System.out.println(dao.addUser(new User(3, "Joel","Raj")));

        User user = dao.findUserById(2);
        user.setLastName("Makhijani");
        dao.updateUser(user);

        //dao.createStudentTable();

        dao.findAllByLastName("Kaur").forEach(System.out::println);



    }

}
