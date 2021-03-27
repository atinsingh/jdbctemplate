package io.pragra.leaning.springjdbclearning.dao;

import io.pragra.leaning.springjdbclearning.domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserDAO {
    private JdbcTemplate jdbcTemplate;

    public UserDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void readAndPrintUsers() {
        String sql = "SELECT * FROM user_detail";
        List<User> users = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(User.class));
        users.forEach(System.out::println);
    }

    public int addUser(User user) {
        String sql = "INSERT into user_detail values(?,?,?)";
        return jdbcTemplate.update(sql, user.getId(), user.getFirstName(), user.getLastName());
    }
    public int updateUser(User user) {
        String sql = "UPDATE user_detail set last_name = ?  where id =  ? ";
        return jdbcTemplate.update(sql, user.getLastName(), user.getId());
    }

    public User findUserById(int id) {
        String sql = "SELECT * FROM user_detail WHERE ID = ? ";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
    }

    public List<Integer> findAllByLastName(String lastname) {
        return jdbcTemplate.queryForList(
                "select id from user_detail where last_name = ? ",
                 Integer.class, lastname) ;
    }

    public void createStudentTable() {
        String sql = "CREATE TABLE STUDENT (id int PRIMARY KEY , first_name varchar(50)," +
                " last_name varchar(50), course_name varchar(50),rnk int)";
        jdbcTemplate.execute(sql);
    }
}
