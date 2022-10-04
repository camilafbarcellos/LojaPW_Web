package br.edu.ifsul.dao;

import br.edu.ifsul.converters.ConverterOrdem;
import br.edu.ifsul.modelo.Cliente;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author camila
 */
@Stateful // inicializado automaticamente pelo container
public class ClienteDAO<TIPO> extends DAOGenerico<Cliente> implements Serializable {
    
    public ClienteDAO() {
        super();
        classePersistente = Cliente.class;
        // lista de ordenações do dao
        listaOrdem.add(new Ordem("id", "ID", "=")); // elemento 0
        listaOrdem.add(new Ordem("nome", "Nome", "like")); // elemento 1
        listaOrdem.add(new Ordem("cpf", "CPF", "like")); // elemento 2
        listaOrdem.add(new Ordem("dataCad", "Data de Cadastro", "like")); // elemento 3
        listaOrdem.add(new Ordem("email", "E-mail", "like")); // elemento 4
        listaOrdem.add(new Ordem("telefone", "Telefone", "like")); // elemento 5
        listaOrdem.add(new Ordem("dataNasc", "Data de Nascimento", "like")); // elemento 6
        // definição da ordem atual
        ordemAtual = listaOrdem.get(1);
        converterOrdem = new ConverterOrdem();
        converterOrdem.setListaOrdem(listaOrdem);
    }
}
