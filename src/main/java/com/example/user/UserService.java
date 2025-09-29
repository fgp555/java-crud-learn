package com.example.user;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final List<UserItem> usersMock = new ArrayList<>();

    public UserService() {
        usersMock.add(new UserItem(1, "Frank", "frank@gmail.com"));
        usersMock.add(new UserItem(2, "Ana", "ana@gmail.com"));
    }

    public List<UserItem> getAll() {
        return usersMock;
    }

    public Optional<UserItem> getById(Integer idParam) {
        return usersMock.stream().filter(user -> user.getId().equals(idParam)).findFirst();
    }

    public UserItem create(UserItem userBody) {
        System.out.println("userBody " + userBody);
        Integer newId = usersMock.stream().mapToInt(UserItem::getId).max().orElse(0) + 1;
        userBody.setId(newId);
        usersMock.add(userBody);
        return userBody;
    }

    public Optional<UserItem> update(Integer idParam, UserItem newUserBody) {
        Optional<UserItem> userOpt = getById(idParam);
        userOpt.ifPresent(item -> {
            item.setName(newUserBody.getName());
            item.setEmail(newUserBody.getEmail());
        });
        return userOpt;
    }

    public boolean delete(Integer idParam) {
        return usersMock.removeIf(item -> item.getId().equals(idParam));
    }

}
