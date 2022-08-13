
import java.time.*;
import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class digital_wachTest {
  //4 unit tests
  //1 integration tests 
 //..............................................................................
 //test display method trival one.
    @Test
    public void testDisplay() {
        LocalDate expResult = LocalDate.now();
       digital_wach tryial = new digital_wach();
       tryial.display();
       assertEquals(expResult, tryial.display());
    }
//...............................................................
     //Test of diplay_zoon method.
    //test if zone of the system equal area zoneid.
     
    @Test
    public void testDiplay_zoon() {
        digital_wach expected = new digital_wach();
         // create ZoneId object
        ZoneId zoneId= expected.diplay_zoon();
        System.out.println("diplay_zoon"); 
       // ZoneId Zone_ID = any_offset_to_test.normalized(); 
      assertEquals("Africa/Cairo",zoneId.toString());
          
    }
//........................................................................
     // Test of updat method
     //i choose test the day only you can test any other variable using same way
    @Test
    public void testUpdat() {
        System.out.println("updat");
        digital_wach instance = new digital_wach();
        DayOfWeek result=instance.updat(ZoneId.of("Africa/Cairo")).getDayOfWeek();
       // DayOfWeek result = ZonedDateTime.now().getDayOfWeek();
        assertEquals("WEDNESDAY", result.toString());  
    }
//............................................................................
     // test of alarm method the output have to be positive 
    //user input should be  this region 13<=clock <=24
    @Test
    public void testAlarm() {
        System.out.println("alarm");
        digital_wach instance = new digital_wach();
        assertEquals(false,instance.isnegative(instance.alarm(true)));
    }
//................................................................
    // test two methods together as integration test.
    //1)the display method return zoneid 
    //2)we take this zone id to use it in update function 
    @Test
    public void integration_test() {
        System.out.println("hi in itegration test");
        digital_wach output_1 = new digital_wach();
         // create ZoneId object
        ZoneId zoneId= output_1.diplay_zoon();
        ZonedDateTime output_2 = output_1.updat(ZoneId.of("Africa/Cairo"));
        assertEquals(10,output_2.getHour());
    }
}
