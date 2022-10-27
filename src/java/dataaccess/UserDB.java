package dataaccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.User;
import models.Role;

/**
 *
 * @author ardee
 */
public class UserDB {
    
    public List<User> getAll (String owner) throws Exception {
        List<User> user = new ArrayList<>();
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE owner=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, owner);
            rs = ps.executeQuery();
            while (rs.next()) {
                int userId = rs.getInt(1);
                String title = rs.getString(2);
                String contents = rs.getString(3);
                User user = new User(userId, title, contents owner);
                user.add(user);
            } 
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return user;
    }
    
    public User get(int userId) throws Exception {
        User user = null;
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String sql = "SELECT * FROM user WHERE user_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userId);
            rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString(2);
                String contents = rs.getString(3);
                String owner = rs.getString(4);
                user = new User(userId, title, contents, owner);
            }
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
        
        return user;
    }
    
    public void insert (User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "INSERT INTO user (title, contents, owner) VALUES (?, ?, ?)";
        
        try {
         ps = con.prepareStatement(sql);
         ps.setString(1, user.getTitle());
         ps.setString(2, user.getContents());
         ps.setString(3, user.getOwner());
         ps.executeUpdate();
    } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void update(User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "UPDATE user SET title=?, contents=? WHERE note_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setString (1, user.getTitle());
            ps.setString (2, user.getContents());
            ps.setInt(3, user.getUserId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
    
    public void delete (User user) throws Exception {
        ConnectionPool cp = ConnectionPool.getInstance();
        Connection con = cp.getConnection();
        PreparedStatement ps = null;
        String sql = "DELETE FROM user WHERE user_id=?";
        
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user.getUserId());
            ps.executeUpdate();
        } finally {
            DBUtil.closePreparedStatement(ps);
            cp.freeConnection(con);
        }
    }
}
