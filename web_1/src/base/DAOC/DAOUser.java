package base.DAOC;

import base.DAOC.DAO;
import base.dbC.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOUser extends DAO {
    public DAOUser() throws Exception {
        super();
    }

    public User readUser(Integer id) throws Exception {
        User user;
        Connection conn =  cpr.getConnection();
        final String read = "SELECT * FROM web1.users where id_user = ?";
        PreparedStatement prst = conn.prepareStatement(read);
        prst.setInt(1, id);
        ResultSet rs = prst.executeQuery();
        user = new User();
        rs.next();
        user.id_user = rs.getInt(1);
        user.name = rs.getString(2);
        user.value = rs.getInt(3);
        cpr.closeConnectin(conn);
        return user;
    }

    public void createUser(User user) throws Exception{
        try {
         cnr.getConnection();
         final String h = "SELECT * FROM web1.users";
         PreparedStatement prst = cnr.getConn().prepareStatement(h);
         ResultSet rs = prst.executeQuery();
         int newid = 1;
         rs.next();
         do {
             newid = rs.getInt(1);
         }while (rs.next());
         final String create = "INSERT INTO `web1`.`users` (`id_user`, `name`, `value`) VALUES (?, ?, ?)";
         prst = cnr.getConn().prepareStatement(create);
         prst.setInt(1,newid+1);
         prst.setString(2,user.name);
         prst.setInt(3,user.value);
         prst.executeUpdate();
        }
        catch (Exception e) {
            throw  new  Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }

    public void deleteUser(String name) throws Exception{
        try {
            cnr.getConnection();
            final String delete = "DELETE FROM `web1`.`users` WHERE `name`=?";
            PreparedStatement prst = cnr.getConn().prepareStatement(delete);
            prst.setString(1,name);
            prst.executeUpdate();
        }
        catch (Exception e) {
            throw  new  Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }

    public void updateUser(User user) throws Exception{
        try {
            cnr.getConnection();
            final String update = "UPDATE `web1`.`users` SET `name`=?, `value`=? WHERE `id_user`=?";
            PreparedStatement prst = cnr.getConn().prepareStatement(update);
            prst.setString(1,user.name);
            prst.setInt(2, user.value);
            prst.setInt(3,user.id_user);
            prst.executeUpdate();
        }
        catch (Exception e) {
            throw  new  Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }
}
