package com.example.hw.repository.post;

import com.example.hw.domain.Post;
import com.example.hw.repository.MDBAbstractRepository;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostRepository extends MDBAbstractRepository implements PostRepositoryInterface {

    @Override
    public Post addPost(Post post) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = this.newConnection();

            String[] generatedColumns = {"id"};

            preparedStatement = connection.prepareStatement("INSERT INTO posts (title, author, text, date) VALUES(?, ?, ?, ?)", generatedColumns);
            preparedStatement.setString(1, post.getTitle());
            preparedStatement.setInt(2, post.getAuthorName());
            preparedStatement.setString(3, post.getContent());
            java.util.Date date = new java.util.Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM:dd:yyyy,hh:mm");
            preparedStatement.setString(4,  simpleDateFormat.format(date));
            preparedStatement.executeUpdate();
            resultSet = preparedStatement.getGeneratedKeys();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return post;
    }

    @Override
    public List<Post> getAllPosts() {
        List<Post> posts = new ArrayList<>();

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = this.newConnection();

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM posts");
            while (resultSet.next()) {
                posts.add(new Post(resultSet.getInt("id"), resultSet.getInt("author"), resultSet.getString("title"), resultSet.getString("text"), resultSet.getString("date")));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(statement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return posts;
    }

    @Override
    public Post findPostById(Integer id) {
        Post post = null;

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM posts where id = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                int subjectId = resultSet.getInt("id");
                String title = resultSet.getString("title");
                int author = resultSet.getInt("author");
                String content = resultSet.getString("text");
                String createdDate = resultSet.getString("date");
                post = new Post(subjectId, author, title, content, createdDate);
            }

            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
        return post;
    }
}
