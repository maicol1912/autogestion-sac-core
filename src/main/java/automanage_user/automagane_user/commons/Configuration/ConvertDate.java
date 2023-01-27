package automanage_user.automagane_user.commons.Configuration;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class ConvertDate {

    public Date convertStringToDate(String dateString){
        Date utilDate = Date.valueOf(dateString);
        return utilDate;
    }



}
