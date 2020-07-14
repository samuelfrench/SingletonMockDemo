import java.util.Random;

public class Singleton {
    static Singleton singleton;
    static {
        singleton = new Singleton();
    }

    public static Singleton getSingleton(){
        return singleton;
    }

    public Boolean getBool(){
        return new Random().nextBoolean();
    }
}