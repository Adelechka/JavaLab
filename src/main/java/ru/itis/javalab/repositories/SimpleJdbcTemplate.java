package ru.itis.javalab.repositories;

import ru.itis.javalab.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {

    private Connection connection;

    public SimpleJdbcTemplate(Connection connection) {
        this.connection = connection;
    }

    public <T> List<T> query(String sql, RowMapper<T> rowMapper, Object ... args) {

        try {
            ResultSet resultSet = null;
            PreparedStatement statement = connection.prepareStatement(sql);
            for (int i = 1; i < args.length + 1; i++) {
                statement.setObject(i, args[i]);
            }
            resultSet = statement.executeQuery();

            if (resultSet == null) {
                throw new IllegalArgumentException();
            }

            List<T> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(rowMapper.mapRow(resultSet));
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalArgumentException();
        }
    }
}
