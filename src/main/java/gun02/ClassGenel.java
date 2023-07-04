package gun02;

public class ClassGenel {

    public int number;

    //     instance initializer, constructordan hemen önce calisir.
    {
        System.out.println("instance initializer calisti");
    }

    static {
        System.out.println("static initializer");
    }

    public ClassGenel() {
        number = 3;
        System.out.println("Constructor çalıştı.\nnumber: " + number);
    }


    public static void main(String[] args) {

        ClassGenel cg = new ClassGenel();

    }


    /*
    Bir class çalıştırıldığında;
    1. static var variable okunur
    2. static initializer calisir
    3. main'e gelir, nesne new yapildiginda
    4. instance var okunur
    5. instance initializer calisir
    6. consturctor calisir -> nesne crea edilmiş olur -> new tamamlanır
    7. yapılacak islemler yürütülür
     */
}
