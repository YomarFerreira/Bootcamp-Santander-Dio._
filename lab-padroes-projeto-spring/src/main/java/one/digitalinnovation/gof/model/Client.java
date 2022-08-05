package one.digitalinnovation.gof.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	@ManyToOne
	private Adress endereco;
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) { this.id = id; }
	public void setNome(String nome) { this.nome = nome; }
	public void setEndereco(Adress endereco) { this.endereco = endereco; }
	public String getNome() { return nome; }
	public Adress getEndereco() { return endereco; }
		
}
