package com.freightcom.clickship.model.util;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.freightcom.clickship.model.v2.Date;

public class DateDeserializer extends JsonDeserializer<Date> {

    @Override
    public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {
    	
        String dateString = jsonParser.getText().trim();
        LocalDateTime dateTime = LocalDateTime.parse(dateString, DateTimeFormatter.ISO_DATE_TIME);

        Date date = new Date();
        date.setYear(dateTime.getYear());
        date.setMonth(dateTime.getMonthValue());
        date.setDay(dateTime.getDayOfMonth());
        return date;
    }
}