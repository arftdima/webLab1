package base.dbC;

public class User {
    public  Integer id_user;
    public  Integer value;
    public  String name;

    public  User(){}
    public  User(User user)
    {
        this.id_user = user.id_user;
        this.value = user.value;
        this.name = user.name;
    }
    public  User(Integer id_user, Integer value, String name)
    {
        this.id_user = id_user;
        this.value = value;
        this.name = name;
    }

}
