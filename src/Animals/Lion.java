package Animals;

public class Lion extends BigCat{
    public Lion(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Lion(int age, char gender, int health){
        super( age,  gender,  health);
    }

    public Lion(){
        super();
    }

    @Override
    protected void stroked(){
        details.append("gets stroked; ");
        increaseHealth(2);
    }
}
