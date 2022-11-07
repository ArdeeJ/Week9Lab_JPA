package services;

import dataaccess.UserDB;
import dataaccess.RoleDB;
import java.util.List;
import models.User;
import models.Role;

/**
 *
 * @author ardee
 */
public class UserService {

    public User get(String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        return user;
    }

    public List<User> getAll(String email) throws Exception {
        UserDB userDB = new UserDB();
        List<User> users = userDB.getAll();
        return users;
    }
    
    public void insert(String email, String first_name, String last_name, String password, int roleId) throws Exception {
        User user = new User(email, first_name, last_name, password);
        UserDB userdb = new UserDB();
        RoleDB roledb = new RoleDB();
        Role role = roledb.getRole(roleId);
        user.setRole(role);
        userdb.insert(user);
    }
    
    public void update(String email, String first_name, String last_name, String password, int roleId) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        user.setFirstName(first_name);
        user.setLastName(last_name);
        user.setPassword(password);
        userDB.update(user);
    }
    
    public void delete (String email) throws Exception {
        UserDB userDB = new UserDB();
        User user = userDB.get(email);
        userDB.delete(user);
    }
}
