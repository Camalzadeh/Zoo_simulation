package Zookeeper;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public abstract class Zookeeper {
    public static final Set<String> zookeeperTypes = new HashSet<String>(Arrays.asList(
            "zookeeper",
            "playzookeeper",
            "phisiozookeeper")
    );
    public abstract void aMonthPasses();
}
