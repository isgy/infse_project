/**
 * 
 */
package roms;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author pbj
 *
 */
public class MoneyTest {
    
    @Test
    public void testZero() {
        Money zero = new Money();
        assertEquals("0.00", zero.toString());
    }
     
    @Test
    public void testStr() {
        Money m = new Money("30");
        assertEquals(m.toString(), "30.00");
    }
    
    @Test
    public void testAdd() {
        Money d = new Money("30");
        Money f = new Money("40");
        assertEquals("70.00", d.add(f).toString());
    }
    
        @Test
    public void testMult() {
        Money d = new Money("3");
        assertEquals("21.00", d.multiply(7).toString());
    }
        
         @Test
    public void testPerc() {
        Money d = new Money("2");
        assertEquals("7.00", d.addPercent(250).toString());
    }
        
  
      
      
      /*
     ***********************************************************************
     * BEGIN MODIFICATION AREA
     ***********************************************************************
     * Add all your JUnit tests for the Money class below.
     */
    

   /*
    * Put all class modifications above.
    ***********************************************************************
    * END MODIFICATION AREA
    ***********************************************************************
    */


}
