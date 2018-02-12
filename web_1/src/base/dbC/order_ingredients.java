package base.dbC;

public class order_ingredients {
    public Integer id_order_ingredient;
    public  Integer id_order;
    public  Integer id_ingredient;

    public  order_ingredients(){}
    public  order_ingredients(Integer id_order, Integer id_ingredient, Integer id_order_ingredient)
    {
        this.id_ingredient = id_ingredient;
        this.id_order = id_order;
        this.id_order_ingredient = id_order_ingredient;
    }

}
