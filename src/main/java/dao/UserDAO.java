package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class UserDAO {
    private final String jdbcUrl;
    private final String dbUser;
    private final String dbPass;

    public UserDAO(String jdbcUrl, String dbUser, String dbPass) {
        this.jdbcUrl = jdbcUrl;
        this.dbUser = dbUser;
        this.dbPass = dbPass;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User findByUserName(String username) throws SQLException {
        String sql = "SELECT id, username, password, full_name, email, role FROM users WHERE username=?";

        try (Connection con = DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, username);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    User u = new User();

                    u.setId(rs.getInt("id"));
                    u.setUsername(rs.getString("username"));
                    u.setPassword(rs.getString("password"));
                    u.setFullName(rs.getString("full_name"));
                    u.setEmail(rs.getString("email"));
                    u.setRole(rs.getString("role"));

                    return u;
                }
            }
        }

        return null;
    }
}