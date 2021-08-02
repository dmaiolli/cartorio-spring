package br.com.docket.cartorio.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@SequenceGenerator(name = "sq_certidao", sequenceName = "sq_certidao", initialValue = 1, allocationSize = 1)
public class Certidao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "sq_certidao", strategy = GenerationType.SEQUENCE)
	@Column(name = "cd_certidao")
	private Long id;

	@Column(name = "ds_nome", length = 80)
	private String nome;

	@ManyToOne(fetch = FetchType.LAZY, optional = true)
	@JoinColumn(name = "cd_cartorio")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Cartorio cartorio;

	public Certidao() {
		super();
	}

	public Certidao(String nome, Cartorio cartorio) {
		super();
		this.nome = nome;
		this.cartorio = cartorio;
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

	public Cartorio getCartorio() {
		return cartorio;
	}

	public void setCartorio(Cartorio cartorio) {
		this.cartorio = cartorio;
	}

}
