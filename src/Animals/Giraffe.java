package Animals;

public class Giraffe extends Animal{
    public Giraffe(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Giraffe(int age, char gender, int health){
        super( age,  gender,  new String[] {"hay","fruit"},  health,  28);
    }

    public Giraffe() {super(START_AGE,'m', new String[]{"hay","fruit"},MAX_HEALTH,28);}

    @Override
    public void treat(){
        details.append("has a neck massage; ");
        neckMassage();
    }

    public void neckMassage(){
        increaseHealth(4);
    }
}
