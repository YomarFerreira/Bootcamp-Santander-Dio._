package one.digitalinnovation.gof.service;

import one.digitalinnovation.gof.model.Client;

/**
 * Interface que define o padrão <b>Strategy</b> do domínio de cliente. Com
 * isso, se necessário, podemos ter multiplas implementações dessa mesma
 * interface.
 * 
 * @author Yomar following steps FalvoJr class in Dio's course
 * */

public interface ClientService {

	Iterable<Client> searchAll();
	
	Client searchById(Long id);
	
	void insert(Client client);
	
	void update(Long id, Client client);
	
	void delete(Long id);

}
