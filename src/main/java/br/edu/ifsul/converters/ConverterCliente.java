
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author camila
 */
@Named(value = "converterCliente")
@RequestScoped
public class ConverterCliente implements Serializable, Converter {

    @PersistenceContext(unitName = "LojaPW_WebPU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")) {
            return null; // indica que não selecionou nada
        }
        return  em.find(Cliente.class, Integer.parseInt(string));
    }

    // do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t == null) {
            return  null;
        }
        Cliente obj = (Cliente) t;
        return obj.getId().toString();
    }
    
}
