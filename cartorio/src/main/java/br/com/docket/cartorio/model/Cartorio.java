package br.com.docket.cartorio.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "sq_cartorio", sequenceName = "sq_cartorio", initialValue = 1, allocationSize = 1)
public class Cartorio implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cd_cartorio")
	private Long id;

	@Column(name = "ds_nome", length = 80)
	private String nome;

	@Column(name = "ds_endereco", length = 150)
	private String endereco;
	
	@OneToMany(mappedBy = "cartorio", fetch = FetchType.EAGER)
	private List<Certidao> certidoes;
	
	public void addCertidao(Certidao certidao) {
		if(certidoes == null) {
			new ArrayList<>();
		}
		
		certidoes.add(certidao);
		certidao.setCartorio(this);
	}
	
	public Cartorio() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Certidao> getCertidoes() {
		return certidoes;
	}

	public void setCertidoes(List<Certidao> certidoes) {
		this.certidoes = certidoes;
	}
}
