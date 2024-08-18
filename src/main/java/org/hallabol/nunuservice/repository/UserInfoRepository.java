package org.hallabol.nunuservice.repository;

import jakarta.annotation.PostConstruct;
import org.hallabol.nunuservice.model.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
public class UserInfoRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserInfoRepository(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<User> getAllUsers() {
        List<User> users = jdbcTemplate.query("select * from user_info", (rs, rowNum) -> new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("user_email"),
                rs.getString("user_address"),
                rs.getString("user_region")
        ));

        return users;
    }

    public User getUser(int userId) {
        User user = jdbcTemplate.queryForObject("select * from user_info where user_id = " + userId, (rs, rowNum) -> new User(
                rs.getInt("user_id"),
                rs.getString("user_name"),
                rs.getString("user_email"),
                rs.getString("user_address"),
                rs.getString("user_region")
        ));

        return user;
    }
}
