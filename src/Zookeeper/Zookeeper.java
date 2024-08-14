package Zookeeper;
import Enclosures.Enclosure;
import Zoos.Zoo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Zookeeper {
    public static final Set<String> zookeeperTypes = new HashSet<String>(Arrays.asList(
            "zookeeper",
            "playzookeeper",
            "phisiozookeeper")
    );
    private ArrayList<Enclosure> enclosures;
    private Zoo zoo;
    public abstract void aMonthPasses();
    public void setZoo(Zoo zoo){
        this.zoo = zoo;
    }
}
