package Animals;

public class Penguin extends Animal{

    public Penguin(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Penguin(int age, char gender, int health){
        super( age,  gender,  new String[]  {"fish", "ice cream"},  health,  15);
    }

    public Penguin() {super(START_AGE,'m', new String[] {"fish", "ice cream"},MAX_HEALTH,15);}

    @Override
    public void treat(){
        details.append("watches a film; ");
        watchAFilm();
    }

    public void watchAFilm(){
        increaseHealth(2);
    }
}
