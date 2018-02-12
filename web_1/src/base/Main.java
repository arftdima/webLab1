package base;

import base.DAOC.DAO;
import base.DAOC.DAOQueries;
import base.DAOC.DAOUser;
import base.dbC.User;

import java.sql.*;
import java.util.ResourceBundle;

public class Main {

    public static void main(String[] args) {
        try {
            DAOQueries queries = new DAOQueries();
            queries.q4_2(1,"coffe1", "ing1");

        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
