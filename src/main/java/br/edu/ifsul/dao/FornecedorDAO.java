package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Fornecedor;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author camila
 */
@Stateful // inicializado automaticamente pelo container
public class FornecedorDAO<TIPO> extends DAOGenerico<Fornecedor> implements Serializable {
    
    public FornecedorDAO() {
        super();
        classePersistente = Fornecedor.class;
        // lista de ordenações do dao
        listaOrdem.add(new Ordem("id", "ID", "=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
        listaOrdem.add(new Ordem("cnpj", "CNPJ", "like")); // elemento 2
        listaOrdem.add(new Ordem("vendedor", "Vendedor", "like")); // elemento 3
        listaOrdem.add(new Ordem("email", "E-mail", "like")); // elemento 4
        listaOrdem.add(new Ordem("setor", "Setor", "like")); // elemento 5
        // definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
