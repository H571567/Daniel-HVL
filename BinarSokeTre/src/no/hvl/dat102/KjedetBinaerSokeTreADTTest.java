package no.hvl.dat102;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

public class KjedetBinaerSokeTreADTTest {   

    private KjedetBinaerSokeTre<Integer> bs;  
    // Testdata som legges inn i treet
    private Integer e0 = 1;
    private Integer e1 = 2;
    private Integer e2 = 3;
    private Integer e3 = 4;
    private Integer e4 = 5;
    private Integer e5 = 6;
    private Integer e6 = 7;
    
    //Data som ikke legges inn i treet
    private Integer e7 = 8;

    
    public KjedetBinaerSokeTreADTTest () {
    	bs = null;
    }
    /**
     * Opprett en tomt tre for hver test.
     * 
     * @throws Exception exception
     */
    @Before
    public final void setup() throws Exception {
      bs = new KjedetBinaerSokeTre<Integer>();
    }
           
     //Tester  finn
    
    @Test
    public final void erElementIBSTre() { 
    /* Her legger du inn e0...e6 i treet i en vilkårlig rekkefølge.
     * Etterpå sjekker du om elementene fins og til slutt sjekker du
     * at e7 ikke fins
     */    
    
    	bs.leggTil(e0);
    	bs.leggTil(e1);
    	bs.leggTil(e2);
    	bs.leggTil(e3);
    	bs.leggTil(e4);
    	bs.leggTil(e5);
    	bs.leggTil(e6);
    	
    	assertTrue(bs.finn(e0).equals(e0));
    	assertTrue(bs.finn(e1).equals(e1));
    	assertTrue(bs.finn(e2).equals(e2));
    	assertTrue(bs.finn(e3).equals(e3));
    	assertTrue(bs.finn(e4).equals(e4));
    	assertTrue(bs.finn(e5).equals(e5));
    	assertTrue(bs.finn(e6).equals(e6));
    	assertFalse(bs.finnMaks().equals(e7));
    	
                       
   }
        
    /**
     *1.  Tester ordning  ved å legge til elementer og fjerne minste
     * 
     */
     @Test
    public final void erBSTreOrdnet() { 
     /* Her legge du først inn e0...e6 i en vilkårlig rekkefølge
      * og så fjerne du minste hele tiden               
    /**
     * 2 Tester ordning ved å bruke en inordeniterator
     *  Her studerer du alt om bruk av inordeniterator.
     */
    	
    
    	 bs.leggTil(e0);
    	 bs.leggTil(e1);
    	 bs.leggTil(e2);
    	 bs.leggTil(e3);
    	 bs.leggTil(e4);
    	 bs.leggTil(e5);
    	 bs.leggTil(e6);
    	 
    	 assertTrue(bs.finnMin().equals(e0));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e1));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e2));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e3));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e4));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e5));
    	 bs.fjernMin();
    	 assertTrue(bs.finnMin().equals(e6));
    	 bs.fjernMin();
    	 assertTrue(bs.erTom());
    	 
    	 
     }
     
     @Test
    public final void erBSTreOrdnet2() { 
     bs.leggTil(e3); 
     bs.leggTil(e2); 
     bs.leggTil(e4); 
     bs.leggTil(e1); 
     bs.leggTil(e5); 
     bs.leggTil(e0);
     bs.leggTil(e6);
     
     Integer el[] = {e0, e1, e2, e3, e4, e5, e6};
     int i = 0;
     for (Integer e : bs ) {
       assertEquals(el[i], e);
       i++;
     }
              
   }
         
     
}//class

