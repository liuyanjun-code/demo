package com.liuyanjun.dao;

import com.liuyanjun.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDao implements IUserDao{

    @Override
    public boolean saveUser(Connection conn, User user) throws SQLException {
        //insert ..into usertable --write code yourself

        String sql = "insert into register(id, username, password, email, gender, birthdate) values (?,?,?,?,?,?);";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,user.getID());
        preparedStatement.setString(2, user.getUsername());
        preparedStatement.setString(3, user.getPassword());
        preparedStatement.setString(4, user.getEmail());
        preparedStatement.setString(5, user.getGender());
        preparedStatement.setDate(6, (java.sql.Date)user.getBirthdate());
        preparedStatement.executeUpdate();
        return true;
    }

    @Override
    public int deleteUser(Connection conn, User user) throws SQLException {
        String sql = "delete from register where id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,user.getID());
        ps.executeUpdate();
        return 0;
        //TODO 5.1-write update sql where id=?
        //TODO 5.2-create prepared statement
        //TODO 5.2-executeUpdate()
        //TODO 5.3 return int
    }

    @Override
    public int updateUser(Connection conn, User user) throws SQLException {
        String sql = "update register set username ="+user.getUsername()+
                ", password = "+user.getPassword()+
                ", email = "+user.getEmail()+
                ", gender = "+user.getGender()+
                ", birthdate = "+user.getBirthdate()+" where id="+user.getID();
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.executeUpdate();
        return 0;
    }

    @Override
    public User findById(Connection conn, Integer id) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where id = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setInt(1,id);

        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public User findByUsernamePassword(Connection conn, String username, String password) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where username=? and password=?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,username);
        st.setString(2,password);
        ResultSet rs = st.executeQuery();
        User user = null;
        if (rs.next()){
            user = new User();
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
        }
        return user;
    }

    @Override
    public List<User> findByUsername(Connection conn, String username) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where username = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,username);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByPassword(Connection conn, String password) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where password = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,password);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByEmail(Connection conn, String email) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where email = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,email);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByGender(Connection conn, String gender) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where gender = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setString(1,gender);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findByBirthdate(Connection conn, Date birthDate) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register where birthdate = ?";
        PreparedStatement st = conn.prepareStatement(sql);
        st.setDate(1, (java.sql.Date) birthDate);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

    @Override
    public List<User> findAllUser(Connection conn) throws SQLException {
        String sql = "select id ,username,password,email,gender,birthdate from register";
        PreparedStatement st = conn.prepareStatement(sql);
        ResultSet rs = st.executeQuery();
        User user = new User();
        List<User> list = new ArrayList<User>();
        while (rs.next()){
            user.setID(rs.getString("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setGender(rs.getString("gender"));
            user.setBirthdate(rs.getDate("birthdate"));
            list.add(user);
        }
        return list;
    }

}
