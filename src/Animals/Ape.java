package Animals;

public abstract class Ape extends Animal{
    public Ape(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Ape(int age, char gender, int health, int lifeExpectancy){
        super( age,  gender,  new String[] {"fruit","ice cream"},  health,  lifeExpectancy);
    }

    public Ape() {super(START_AGE,'m', new String[]{ "fruit", "ice cream"},MAX_HEALTH,28);}
}
