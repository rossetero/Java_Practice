package org.example.repositories;

import org.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UsersRepositoryStatementImpl implements UsersRepository<User>{

    private final DataSource dataSource;
    @Autowired
    public UsersRepositoryStatementImpl(@Qualifier("hikariDataSource") DataSource dataSource){
        this.dataSource=dataSource;
    }
    @Override
    public Optional<User> findById(Long id){
        String query = "select * from users where id=?;";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)){
            ps.setLong(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
        }catch(SQLException e){
            e.printStackTrace();;
        }

        return Optional.empty();}
    @Override
    public List<User> findAll(){
        List<User> users=new ArrayList<>();
        String query = "select * from users;";
        try (Connection connection = dataSource.getConnection();
             Statement s = connection.createStatement()){
            ResultSet rs = s.executeQuery(query);
            while (rs.next()){
                users.add(
                        new User(rs.getLong("id"),
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("password"))
                );
            }

        }catch(SQLException e){
            e.printStackTrace();;
        }
        return users;
    }
    @Override
    public void save(User entity) {
        String query = "INSERT INTO users (name,email, password) VALUES (?,?,?)";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            if (ps.executeUpdate() > 0) {
                System.out.println("New data inserted to db successfully");
            }
            entity.setId(getLastUserId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User entity) {
        String query = "UPDATE users SET name=? email=?, password=? WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(4, entity.getId());
            ps.setString(1, entity.getName());
            ps.setString(2, entity.getEmail());
            ps.setString(3, entity.getPassword());
            if (ps.executeUpdate() > 0) {
                System.out.println("User with id " + entity.getId() + " updated successfully");
            }
            entity.setId(getLastUserId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Long id) {
        String query = "DELETE FROM users WHERE id=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setLong(1, id);
            if (ps.executeUpdate() > 0) {
                System.out.println("User with id " + id + " deleted");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Optional<User> findByEmail(String email) {
        String query = "SELECT id, email, password FROM users WHERE email=?";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return Optional.of(new User(rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("password")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        throw new NullPointerException("User with email: '" + email + "' not found");
    }

    private long getLastUserId() {
        String query = "SELECT id from users ORDER BY id DESC LIMIT 1";
        try (Connection connection = dataSource.getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getLong("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1L;
    }
}
