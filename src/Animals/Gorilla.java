package Animals;

public class Gorilla extends Ape {
    public Gorilla(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Gorilla(int age, char gender, int health){
        super( age,  gender,  health,  32);
    }

    public Gorilla(){
        super();
    }

    @Override
    public void treat(){
        details.append("gets to paint; ");
        painting();
    }

    public void painting(){
        increaseHealth(4);
    }
}
