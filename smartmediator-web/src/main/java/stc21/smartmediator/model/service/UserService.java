package stc21.smartmediator.model.service;

import stc21.smartmediator.model.entity.UsersEntity;

import java.util.List;

public interface UserService {
    List<UsersEntity> findAll();

    UsersEntity findById(String uuid);

    UsersEntity create(String email, String pass, String full_name);

    UsersEntity searchByEmail(String email);
}
