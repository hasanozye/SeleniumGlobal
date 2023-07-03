package utils;

public class Utils {
    public static void bekle(long milis) {
        try {
            Thread.sleep(milis);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
