
package br.edu.ifsul.converters;

import br.edu.ifsul.modelo.Fornecedor;
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
@Named(value = "converterFornecedor")
@RequestScoped
public class ConverterFornecedor implements Serializable, Converter {

    @PersistenceContext(unitName = "LojaPW_WebPU")
    private EntityManager em;
    
    // da tela para o objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if(string == null || string.equals("Selecione um registro")) {
            return null; // indica que não selecionou nada
        }
        return  em.find(Fornecedor.class, Integer.parseInt(string));
    }

    // do objeto para a tela
    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object t) {
        if(t == null) {
            return  null;
        }
        Fornecedor obj = (Fornecedor) t;
        return obj.getId().toString();
    }
    
}
