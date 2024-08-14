package Animals;

public class Elephant extends Animal{
    public Elephant(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Elephant(int age, char gender, int health){
        super( age,  gender,  new String[] {"hay","fruit"},  health,  36);
    }

    public Elephant() {super(START_AGE,'m', new String[]{"hay","fruit"},MAX_HEALTH,36);}

    @Override
    public void treat(){
        details.append("has a bath; ");
        bath();
    }

    public void bath(){
        increaseHealth(5);
    }
}
