package automanage_user.automagane_user.infraestructure.configuration;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ConvertDate {


    public Date obtenerLocalDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = Date.valueOf(dateFormat.format(new java.util.Date()));
        return date;
    }

    public Date obtenerLocalDateTime(){

        LocalDateTime datetime = LocalDateTime.now();
        Date date = Date.valueOf(datetime.toString());
        return date;
    }


}
