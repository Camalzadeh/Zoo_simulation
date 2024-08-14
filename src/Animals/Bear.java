package Animals;

public class Bear extends Animal{

    public Bear(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Bear(int age, char gender, int health){
        super( age,  gender,  new String[] {"fish","steak"},  health,  24);
    }

    public Bear() {super(START_AGE,'m', new String[]{ "fish","steak"},MAX_HEALTH,24);}
    @Override
    public void treat(){
        details.append("gets a hug; ");
        hug();
    }

    public void hug(){
        increaseHealth(3);
    }
}
