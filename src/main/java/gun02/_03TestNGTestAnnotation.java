package gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _03TestNGTestAnnotation {

//    @Test Annotation'i her metodu executable hale getirir, main gibi
//    test calistirildiginda o class'dan nesne oluşturularak çalıştırılır.


    @Test
    public void test1(){
        Assert.assertTrue(true);
    }

    @Test
    public void test2(){
        Assert.assertEquals(1,2,"Sayilar eşit değil");
    }


}
