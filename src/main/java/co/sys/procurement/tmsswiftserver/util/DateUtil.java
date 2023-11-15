package co.sys.procurement.tmsswiftserver.util;

import java.util.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class DateUtil {
    public static Timestamp parseDate(String date) throws ParseException {
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyyMMddHHMMSS");
        Date parsedDate =  dateFormat.parse(date);
        return new Timestamp(parsedDate.getTime());
    }
}
