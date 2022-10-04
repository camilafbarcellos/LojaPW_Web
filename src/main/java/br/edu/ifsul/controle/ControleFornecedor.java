package br.edu.ifsul.controle;

import br.edu.ifsul.dao.FornecedorDAO;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author camila
 */
@Named(value = "controleFornecedor")
@ViewScoped
public class ControleFornecedor implements Serializable {
    
    @EJB // instancia automaticamente o EJB
    private FornecedorDAO<Fornecedor> dao;
    private Fornecedor objeto;
    
    public ControleFornecedor() {
        
    }
    
    public String listar() {
        return "/privado/fornecedor/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Fornecedor();
    }
    
    public void alterar(Object id) {
        try {
            objeto = dao.getObjectByID(id);
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void remover(Object id) {
        try {
            objeto = dao.getObjectByID(id);
            dao.remover(objeto);
            Util.mensagemInformacao("Objeto removido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto: " + Util.getMensagemErro(e));
        }
    }
    
    public void salvar() {
        try {
            if(objeto.getId() == null) {
                dao.persist(objeto);
            } else {
                dao.merge(objeto);
            }
            Util.mensagemInformacao("Objeto persistido com sucesso!");
        } catch (Exception e) {
            Util.mensagemErro("Erro ao persistir objeto: " + Util.getMensagemErro(e));
        }
    }

    public FornecedorDAO<Fornecedor> getDao() {
        return dao;
    }

    public void setDao(FornecedorDAO<Fornecedor> dao) {
        this.dao = dao;
    }

    public Fornecedor getObjeto() {
        return objeto;
    }

    public void setObjeto(Fornecedor objeto) {
        this.objeto = objeto;
    }
}
