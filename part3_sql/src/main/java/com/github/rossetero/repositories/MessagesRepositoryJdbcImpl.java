package com.github.rossetero.repositories;

import com.github.rossetero.exceptions.NotSavedSubEntityException;
import com.github.rossetero.models.ChatRoom;
import com.github.rossetero.models.Message;
import com.github.rossetero.models.User;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Optional;

public class MessagesRepositoryJdbcImpl implements MessagesRepository {
    private final DataSource dataSource;

    public MessagesRepositoryJdbcImpl(DataSource dataSource){
        this.dataSource=dataSource;
    }


    @Override
    public void update(Message message){
        String query = "update messages set message=?, date_time=? where id="+ message.getId();
        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)){
            preparedStatement.setString(1,message.getText());
            preparedStatement.setTimestamp(2,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void save(Message message){
        String query = "insert into messages (author, room, message, date_time) values(?,?,?,?)";
        try(Connection connection = dataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(query)){
            Optional<User> author = findUserById(connection, message.getAuthor().getId());
            Optional<ChatRoom> chatRoom = findChatRoomById(connection, message.getRoom().getId());
            preparedStatement.setLong(1, author.orElseThrow(NotSavedSubEntityException::new).getId() );
            preparedStatement.setLong(2,chatRoom.orElseThrow(NotSavedSubEntityException::new).getId());
            preparedStatement.setString(3, message.getText());
            preparedStatement.setTimestamp(4, Timestamp.valueOf(message.getDateTime()));
            preparedStatement.executeUpdate();
            message.setId(getLastMessageId(connection));
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    private Long getLastMessageId(Connection connection){
        String query = "select id from messages order by id desc limit 1";
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return rs.getLong("id");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public Optional<Message> findById(Long id){
        String query = "SELECT * FROM messages WHERE id = "+id;
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                Optional<User> user = findUserById(connection,rs.getLong("author"));
                Optional <ChatRoom> chatRoom = findChatRoomById(connection, rs.getLong("room"));
                String text = rs.getString("message");
                LocalDateTime dateTime = rs.getTimestamp("date_time").toLocalDateTime();
                Message message = new Message(rs.getLong("id"), user.get(), chatRoom.get(), text, dateTime);
                return Optional.of(message);
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private Optional<User> findUserById(Connection connection,Long id){
        String query = "SELECT * FROM users WHERE id = "+id;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                return Optional.of(new User(id,
                        rs.getString("login"),
                        rs.getString("password")));

            }
        }catch (SQLException e){
            throw new NotSavedSubEntityException();
        }
        return Optional.empty();
    }

    private Optional<ChatRoom> findChatRoomById(Connection connection,Long id){
        String query = "SELECT * FROM chatrooms WHERE id = "+id;
        try(Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(query);
            if(rs.next()){
                Optional<User> owner = findUserById(connection,rs.getLong("owner"));
                return Optional.of(new ChatRoom(id,
                        rs.getString("name"),
                        owner.orElse(null)));

            }
        }catch (SQLException e){
            throw new NotSavedSubEntityException();
        }
        return Optional.empty();
    }
}
