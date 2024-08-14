package Animals;

public class Chimpanzee extends Ape{
    public Chimpanzee(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public Chimpanzee(int age, char gender, int health){
        super( age,  gender,  health,  24);
    }

    public Chimpanzee(){
        super();
    }

    @Override
    public void treat(){
        details.append("plays chase; ");
        playChase();
    }

    public void playChase(){
        increaseHealth(4);
    }
}
