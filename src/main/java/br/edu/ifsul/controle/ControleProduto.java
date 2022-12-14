package br.edu.ifsul.controle;

import br.edu.ifsul.dao.FornecedorDAO;
import br.edu.ifsul.modelo.Fornecedor;
import br.edu.ifsul.dao.ProdutoDAO;
import br.edu.ifsul.modelo.Produto;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author camila
 */
@Named(value = "controleProduto")
@ViewScoped
public class ControleProduto implements Serializable {
    
    @EJB // instancia automaticamente o EJB
    private ProdutoDAO<Produto> dao;
    private Produto objeto;
    @EJB
    private FornecedorDAO<Fornecedor> daoFornecedor;
    
    public ControleProduto() {
        
    }
    
    public String listar() {
        return "/privado/produto/listar?faces-redirect=true";
    }
    
    public void novo() {
        objeto = new Produto();
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

    public ProdutoDAO<Produto> getDao() {
        return dao;
    }

    public void setDao(ProdutoDAO<Produto> dao) {
        this.dao = dao;
    }

    public Produto getObjeto() {
        return objeto;
    }

    public void setObjeto(Produto objeto) {
        this.objeto = objeto;
    }

    public FornecedorDAO<Fornecedor> getDaoFornecedor() {
        return daoFornecedor;
    }

    public void setDaoFornecedor(FornecedorDAO<Fornecedor> daoFornecedor) {
        this.daoFornecedor = daoFornecedor;
    }
}
