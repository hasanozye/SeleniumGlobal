package gun18.oop;

import java.util.Random;

public class BaseStatic {
    static int i;

    static {
        i = new Random().nextInt(10);
    }

    public static int getNum(){
        return i;
    }
}
