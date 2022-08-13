
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
//.............................................................................
           //documentation 
//The watch has three methods 
//1) display  date,
//2)display zone (we need this function when changing the time from country to another)
//3)update the time depends on zone region. 
//4)adjust alarm 
//5)chech if the number negative (needed in test)
//.............................................................................
public class digital_wach {
    private static final String DATE_FORMAT = "dd-M-yyyy hh:mm:ss a";
//.............................................................................
    LocalDate display ()
   {
    LocalDate myObj = LocalDate.now(); // Create a date object
    System.out.println(myObj); // Display the current date
    return myObj;
   }
//.............................................................................
//take the output of updte method as input
ZoneId diplay_zoon() {
    ZoneId zone = ZoneId.systemDefault();
        return zone.systemDefault();
}   
//.............................................................................
    ZonedDateTime updat (ZoneId perefer_zon_id){
        //lets imagen that the user choose this data and time 
         String dateInString = "08-09-2021 10:15:55 AM";
        LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
        ZonedDateTime prefer_ZonedDateTime = ldt.atZone(perefer_zon_id);
        ZoneId newYokZoneId = ZoneId.of("America/New_York");
        ZonedDateTime nyDateTime = prefer_ZonedDateTime.withZoneSameInstant(newYokZoneId);
        DateTimeFormatter format = DateTimeFormatter.ofPattern(DATE_FORMAT);
         System.out.println(prefer_ZonedDateTime);
        return prefer_ZonedDateTime;
    }
//..............................................................................
      int  alarm(boolean flag){      
          int i=0;
          LocalDateTime timenow  = LocalDateTime.now(); // Create a date object
        if (flag == true )
        {
         System.out.println("please adjust the time you want \n"); 
         //let say that user choose 13 means 01:00 pm
          System.out.println("13:00"); 
          System.out.println("the alarm will ring after  " + (timenow.getHour()-13)+"hours");             
        }
        //if there is no alarm do nothing 
        else 
        {}
        return (timenow.getHour()-13);
      }
//...............................................................................
      boolean isnegative(int num){
    if (num<0)
        return true;
    else 
        return false;
    }
//..............................................................................
      //main
      public static void main(String[] args) {
     digital_wach tryial = new digital_wach();
      tryial.display();
      tryial.diplay_zoon();
      tryial.updat(ZoneId.of("Africa/Cairo"));
      tryial.alarm(true);
     
 }
}
