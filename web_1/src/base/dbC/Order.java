package base.dbC;

public class Order {
    public Integer id_order;
    public  Integer id_user;
    public Integer id_coffe;

    public Order(){}
    public  Order(Integer id_coffe, Integer id_user, Integer id_order)
    {
        this.id_coffe = id_coffe;
        this.id_order = id_order;
        this.id_user = id_user;
    }
}
