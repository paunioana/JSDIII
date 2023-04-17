package devmind.springinitializr.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class TimeService {
    public String getTime(String timeZone) {
        Date timeStamp = new java.util.Date();

        //String format = new SimpleDateFormat("HH:mm:ss").format(timeStamp);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        // set timezone to SimpleDateFormat
        sdf.setTimeZone(TimeZone.getTimeZone(timeZone));
        // return Date in required format with timezone as String
        return sdf.format(timeStamp);
    }
}
