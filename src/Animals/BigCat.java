package Animals;

public abstract class BigCat extends Animal {
    public BigCat(int age, char gender, String[] eats, int health, int lifeExpectancy){
        super( age,  gender,  eats,  health,  lifeExpectancy);
    }

    public BigCat(int age, char gender, int health){
        super( age,  gender,  new String[] {"steak","celery"},  health,  24);
    }

    public BigCat() {super(START_AGE,'m', new String[]{"steak","celery"},MAX_HEALTH,24);}

    public void treat(){
        stroked();
    }
    protected abstract void stroked();
}
