package Animals;

public class Tiger extends BigCat{
    public Tiger(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Tiger(int age, char gender, int health){
        super( age,  gender,  health);
    }

    public Tiger(){
        super();
    }

    @Override
    protected void stroked() {
        details.append("gets stroked; ");
        increaseHealth(3);
    }
}
