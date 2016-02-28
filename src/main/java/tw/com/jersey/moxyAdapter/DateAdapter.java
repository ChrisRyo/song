package tw.com.jersey.moxyAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import tw.com.logic.enums.DateStyle;
 
/**
 * 
 * @author chrisryo
 *
 */
public class DateAdapter extends XmlAdapter<String, Date> {
 
    private final SimpleDateFormat dateFormat = new SimpleDateFormat(DateStyle.YYYY_MM_DD.getFormat());
 
    @Override
    public String marshal(Date date) throws Exception {
        return dateFormat.format(date);
    }
 
    @Override
    public Date unmarshal(String string) throws Exception {
        return dateFormat.parse(string);
    }
 
}