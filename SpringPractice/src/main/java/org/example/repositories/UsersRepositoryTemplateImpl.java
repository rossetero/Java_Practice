package org.example.repositories;

import org.example.mappers.UserMapper;
import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryTemplateImpl implements UsersRepository<User> {
    private JdbcTemplate jdbcTemplate;
    @Autowired
    public UsersRepositoryTemplateImpl(@Qualifier("springDataSource") DataSource dataSource){
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jdbcTemplate.query("SELECT * FROM users where email=?;", new Object[]{email},new UserMapper())
                .stream().findAny();
    }

    @Override
    public Optional<User> findById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users where id=?;", new Object[]{id},new UserMapper())
                .stream().findAny();
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users;",new UserMapper());
    }

    @Override
    public void save(User entity) {
        String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?) RETURNING id";
        Long newId = jdbcTemplate.queryForObject(query, new Object[]{entity.getName(),entity.getEmail(), entity.getPassword()}, Long.class);
        entity.setId(newId);
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update("UPDATE users SET name=?, password=? WHERE id=?",entity.getName(),entity.getPassword());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?",id);
    }
}
