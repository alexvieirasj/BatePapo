package br.edu.ifsul.converter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "converterCalendar")
public class ConversorHora implements Converter{
    
    SimpleDateFormat sdf = new SimpleDateFormat("(HH:mm:ss)");

    @Override //converte da tela para o objeto
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {
            Calendar retorno = Calendar.getInstance();
            retorno.setTime(sdf.parse(string));
            return retorno;
        } catch(Exception e) {
            return null;
        }
    }

    @Override //converte do objeto para a tela
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        Calendar obj = (Calendar) o;
        return sdf.format(obj.getTime());
    }
}
