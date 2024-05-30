package edu.itstep.barber_db.converter;

import org.springframework.core.convert.converter.Converter;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SQLTimeConverter implements Converter<String, Time> {

    private static final String TIME_PATTERN = "HH:mm:ss";
    private static final SimpleDateFormat timeFormat = new SimpleDateFormat(TIME_PATTERN);

    @Override
    public Time convert(String source) {
        try {
            long ms = timeFormat.parse(source).getTime();
            return new Time(ms);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid time format. Please use " + TIME_PATTERN);
        }
    }

}
