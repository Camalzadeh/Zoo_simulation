package Zookeepers;

import Animals.Chimpanzee;
import Animals.Gorilla;
import Animals.Penguin;
import Enclosures.Enclosure;

public class PlayZookeeper extends Zookeeper {
    public PlayZookeeper(Enclosure enclosure){
        super(enclosure);
        canTreat.add(Chimpanzee.class);
        canTreat.add(Gorilla.class);
        canTreat.add(Penguin.class);
    }
    public PlayZookeeper(){
        super();
        canTreat.add(Chimpanzee.class);
        canTreat.add(Gorilla.class);
        canTreat.add(Penguin.class);
    }
}
