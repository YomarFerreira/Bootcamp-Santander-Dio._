package one.digitalinnovation.gof.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Adress;
import one.digitalinnovation.gof.model.AdressRepository;
import one.digitalinnovation.gof.model.Client;
import one.digitalinnovation.gof.model.ClientRepository;
import one.digitalinnovation.gof.service.ClientService;
import one.digitalinnovation.gof.service.ViaCepService;


/**
 * Implementação da <b>Strategy</b> {@link ClientService}, a qual pode ser
 * injetada pelo spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author Yomar following steps FalvoJr class in Dio's course
 *
 */
@Service
public class ClientServiceImpl implements ClientService{

	// Singleton: Inject Spring components with @Autowired.
	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private AdressRepository adressRepository;
	@Autowired
	private ViaCepService viaCepService;
	
	// Strategy: Implement the methods defined in the interface.
	// Facade: Abstract integrations with subsystems, providing a simple interface.
	
	@Override
	public Iterable<Client> searchAll(){
		// Search All Clients
		return clientRepository.findAll();
	}
	
	@Override
	public Client searchById(Long id){
		// Search Clients by ID
		Optional<Client> client = clientRepository.findById(id);
		return client.get();
	}
	
	private void saveCustomerWithZipCode(Client client) {
		// Check if the Customer Address already exists (by zip code).
		String zipCode = client.getEndereco().getCep();
		Adress adress = adressRepository.findById(zipCode).orElseGet(()->{
			// Case not, integrate with 'viaCEP' and persist the return.
			Adress newAdress = viaCepService.consultarCep(zipCode);
			adressRepository.save(newAdress);
			return newAdress;
		});
		client.setEndereco(adress);
		//Insert Customer, linking Address (new or existing).
		clientRepository.save(client);
	}

	@Override
	public void insert (Client client){
		saveCustomerWithZipCode(client);
	}
	
	@Override
	public void update(Long id, Client client){
		// Search Customer by ID, if any
		Optional<Client> clientDb = clientRepository.findById(id);
		if(clientDb.isPresent()) {
			saveCustomerWithZipCode(client);
		}
	}
		
	@Override
	public void delete (Long id){
		// Delete Customer by ID
		clientRepository.deleteById(id);
	}

	
}
