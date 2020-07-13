import java.util.Random;

public class StaticSingleton {
    static StaticSingleton singleton;
    static {
        singleton = new StaticSingleton();
    }

    public static StaticSingleton getSingleton(){
        return singleton;
    }

    public Boolean getBool(){
        return new Random().nextBoolean();
    }
}
