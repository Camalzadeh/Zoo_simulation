package Zookeepers;

import Animals.Elephant;
import Animals.Giraffe;
import Enclosures.Enclosure;

public class PhysioZookeeper extends Zookeeper {
    public PhysioZookeeper(Enclosure enclosure) {
        super(enclosure);
        canTreat.add(Elephant.class);
        canTreat.add(Giraffe.class);

    }

    public PhysioZookeeper() {
        super();
        canTreat.add(Elephant.class);
        canTreat.add(Giraffe.class);
    }
}
