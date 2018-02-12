package base.DAOC;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOQueries extends DAO{
    public  DAOQueries() throws Exception
    {
        super();
    }

//  Вывести список доступных напитков.
    public void q1() throws Exception{
        try {
            cnr.getConnection();
            final String question = "SELECT name FROM web1.coffemachine where web1.coffemachine.amount != 0";
            PreparedStatement prst = cnr.getConn().prepareStatement(question);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }

//  Вывести список доступных ингредиентов.
    public  void q2() throws Exception {
        try {
            cnr.getConnection();
            final String question = "SELECT name FROM web1.ingredients";
            PreparedStatement prst = cnr.getConn().prepareStatement(question);
            ResultSet rs = prst.executeQuery();
            while (rs.next()){
                System.out.println(rs.getString(1));
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }

//  Вывести сумму счета заданного пользователя.
    public void q3(String name) throws Exception{
        try {
            cnr.getConnection();
            final String question = "SELECT value FROM `web1`.`users` WHERE `name`=?";
            PreparedStatement prst = cnr.getConn().prepareStatement(question);
            prst.setString(1,name);
            ResultSet rs = prst.executeQuery();
            rs.next();
            System.out.println(rs.getInt(1));
        }
        catch (Exception e) {
            throw  new  Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }

//  Наполнить кофе-машину, купить напиток (напитки).
    public void q4_1(String nameCoffe, Integer addSize) throws Exception{
        try {
            cnr.getConnection();
            final String addCoffeSize = "update web1.coffemachine set amount = amount + ? where name = ?";
            PreparedStatement prst = cnr.getConn().prepareStatement(addCoffeSize);
            prst.setString(2, nameCoffe);
            prst.setInt(1, addSize);
            prst.executeUpdate();
        }
        catch (Exception e){
            throw new Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }
    public void q4_2(Integer userId, String coffeName, String ingredientName) throws Exception {
        try {
            cnr.getConnection();

            final String getUserValue = "SELECT value FROM web1.users where web1.users.id_user = ?";
            PreparedStatement p1 = cnr.getConn().prepareStatement(getUserValue);
            p1.setInt(1, userId);
            ResultSet r1 = p1.executeQuery();
            r1.next();
            Integer userValue = r1.getInt(1);
            System.out.println("Before userValue: " + userValue);
            System.out.println();
            final String getCoffeValue = "SELECT price FROM web1.coffemachine where web1.coffemachine.name = ?";
            PreparedStatement p2 = cnr.getConn().prepareStatement(getCoffeValue);
            p2.setString(1, coffeName);
            ResultSet r2 = p2.executeQuery();
            r2.next();
            Integer coffePrice = r2.getInt(1);
            System.out.println("Coffe price: " + coffePrice);
            System.out.println();
            final String getIngredientValue = "SELECT value FROM web1.ingredients where web1.ingredients.name = ?";
            Integer allPriceIngredients = 0;
            PreparedStatement p3 = cnr.getConn().prepareStatement(getIngredientValue);
            p3.setString(1, ingredientName);
            ResultSet r3 = p3.executeQuery();
            r3.next();
            allPriceIngredients += r3.getInt(1);
            System.out.println("Ingredient " + ingredientName + " price: " + r3.getInt(1));
            Integer allPrice = allPriceIngredients + coffePrice;
            System.out.println("\nallPrice: "+allPrice);
            if(userValue >= allPrice){
                final String upd1 = "UPDATE `web1`.`users` SET `value`= value - ? WHERE `id_user`=?";
                PreparedStatement prst1 = cnr.getConn().prepareStatement(upd1);
                prst1.setInt(1,allPrice);
                prst1.setInt(2,userId);
                prst1.executeUpdate();
                final String upd2 = "UPDATE `web1`.`coffemachine` SET `amount`= amount - 1 WHERE `name`=?";
                PreparedStatement prst2 = cnr.getConn().prepareStatement(upd2);
                prst2.setString(1,coffeName);
                prst2.executeUpdate();
            }
            else {
                System.out.println("\ninsufficient funds");
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        finally {
            cnr.close();
        }
    }
}
