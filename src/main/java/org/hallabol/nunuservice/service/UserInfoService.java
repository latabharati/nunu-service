package org.hallabol.nunuservice.service;

import jakarta.annotation.PostConstruct;
import org.hallabol.nunuservice.model.User;
import org.hallabol.nunuservice.repository.UserInfoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;

    public UserInfoService(final UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public List<User> getAllUsers() {
        List<User> users = userInfoRepository.getAllUsers();

        return users;
    }

    public User getUser(int userId) {
        User user = userInfoRepository.getUser(userId);

        return user;
    }
}
