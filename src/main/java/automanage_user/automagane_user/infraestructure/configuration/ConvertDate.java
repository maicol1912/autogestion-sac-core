package automanage_user.automagane_user.infraestructure.configuration;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class ConvertDate {


    public Date obtenerLocalDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.valueOf(dateFormat.format(new java.util.Date()));
        return date;
    }



}
