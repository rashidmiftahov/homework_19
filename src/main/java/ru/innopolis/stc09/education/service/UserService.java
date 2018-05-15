package ru.innopolis.stc09.education.service;

import org.apache.commons.codec.digest.DigestUtils;
import ru.innopolis.stc09.education.dao.UserDAO;
import ru.innopolis.stc09.education.obj.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

public class UserService {
    private static UserDAO userDao = new UserDAO();

    public int checkAuthorization(String login, String password) {
        User user = null;
        try {
            user = userDao.getUserByLogin(login);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String passHash = DigestUtils.md5Hex(password);

        if ((user != null) && (user.getPassword().equals(passHash))) {
            return user.getRole_id();
        } else {
            return -1;
        }
    }

}
