package day05;

import org.junit.Test;

public class C01_Notasyon {

    //javadaki gibi seleniumda da belirli islevleri yapan methodlar olusturabiliriz
    //ancak bu methodlar cagirilmadikca calismazlar
    public void ilkTestMethodu(){
        System.out.println("ilk test methodumuz"); //-> call olmadigi icin bu calismaz
    }

    //Junit ile notasyon kullanarak siradan method'lari test method'una donusturebiliriz
    // bir test methodu bagimsiz olarak calisabilen test yapmamiza imkan verir
    //@Test notasyonu sayesinde main method mecburiyeti ortadan kalkar
    @Test
    public void notasyonluIlkTestim(){
        System.out.println("notasyonlu ilk test methodumuz");//->@Test sayesinde call olmadan bagimsiz calisti
    }
}
