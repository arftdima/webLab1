package base.dbC;

public class CoffeMachine {
    public  Integer id_coffe;
    public  String name;
    public Integer amount;
    public  Integer price;

    public CoffeMachine()
    {}
    public CoffeMachine(Integer id_coffe, Integer amount, Integer price, String name)
    {
        this.id_coffe = id_coffe;
        this.amount = amount;
        this.price = price;
        this.name = name;
    }
}
