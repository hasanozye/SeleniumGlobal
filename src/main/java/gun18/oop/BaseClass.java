package gun18.oop;

import java.util.Random;

public class BaseClass {

    protected int i;

    {
        i = new Random().nextInt(10);
    }

    protected int getNum() {
        return i;
    }
}
