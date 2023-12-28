package com.posco.web.user;

import com.posco.web.auth.LoginDTO;
import com.posco.web.auth.TokenDTO;
import com.posco.web.auth.TokenEntity;
import org.springframework.stereotype.Service;


public interface UserService {
    boolean isExistById(String id);

    boolean isExistByNickName(String nickName);

    boolean isExistByEmail(String email);

    UserEntity createUser(UserDTO signUpDTO);

    UserEntity readUser(String id);

    boolean updateUser(UserDTO userDTO);

    boolean checkPassword(String id, String password);

    void deleteUser(String id);

    TokenDTO loginUser(LoginDTO loginDTO);

    TokenEntity saveToken(String refreshToken, String userId);

    String getToken(String userId);

    void deleteToken(String userId);
}
