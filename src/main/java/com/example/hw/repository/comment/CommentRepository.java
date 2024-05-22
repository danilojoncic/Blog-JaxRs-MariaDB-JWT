package com.example.hw.repository.comment;

import com.example.hw.domain.Comment;
import com.example.hw.dto.CommentDTO;
import com.example.hw.repository.MDBAbstractRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentRepository extends MDBAbstractRepository implements CommentRepositoryInterface {
    @Override
    public void addComment(CommentDTO comment) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT id FROM users WHERE name = ?");
            preparedStatement.setString(1,comment.getAuthor());
            resultSet = preparedStatement.executeQuery();
            int author_id = 1;
            if (resultSet.next()) {
                author_id = resultSet.getInt("id");
                System.out.println(author_id);

                // Rest of your code to insert the comment
            } else {
                // Handle the case where no user with the given name was found
            }

            preparedStatement = connection.prepareStatement("INSERT INTO comments (id,post, author, text) VALUES(NULL,?, ?, ?)");
            preparedStatement.setInt(1, comment.getPost_id());
            preparedStatement.setInt(2, author_id);
            preparedStatement.setString(3, comment.getText());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }
    }

    @Override
    public List<Comment> findCommentsForPost(Integer id) {
        List<Comment> comments = new ArrayList<>();

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = this.newConnection();

            preparedStatement = connection.prepareStatement("SELECT * FROM comments WHERE post = ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                comments.add(new Comment(resultSet.getInt("id"), resultSet.getInt("post"), resultSet.getInt("author"), resultSet.getString("text")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.closeStatement(preparedStatement);
            this.closeResultSet(resultSet);
            this.closeConnection(connection);
        }

        return comments;
    }
}
