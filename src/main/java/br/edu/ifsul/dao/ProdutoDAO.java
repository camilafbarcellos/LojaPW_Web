package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Produto;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author camila
 */
@Stateful // inicializado automaticamente pelo container
public class ProdutoDAO<TIPO> extends DAOGenerico<Produto> implements Serializable {
    
    public ProdutoDAO() {
        super();
        classePersistente = Produto.class;
        // lista de ordenações do dao
        listaOrdem.add(new Ordem("id", "ID", "=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
        listaOrdem.add(new Ordem("valor", "Valor", "like")); // elemento 2
        listaOrdem.add(new Ordem("estoque", "Estoque", "like")); // elemento 3
        listaOrdem.add(new Ordem("fornecedor.nome", "Fornecedor", "like")); // elemento 4
        // definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
