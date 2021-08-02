package br.com.docket.cartorio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.docket.cartorio.model.Certidao;

@Service
public interface CertidaoService extends CrudService<Certidao, Long>{

	/**
	 * gets all Certidoes from Database
	 * 
	 * @return a List of Certidoes
	 */
	List<Certidao> getAll();
	/**
	 * finds a Certidao in DB by its ID
	 * 
	 * @param CertidaoId Database ID of Certidoes
	 * @return Certidao with ID = CertidaoId
	 */
	Certidao findById(Long CertidaoId);

	/**
	 * creates and inserts a new Certidao in DB
	 * 
	 * @param CertidaoDetails Certidao details from NEW Certidao FROM
	 * @return id of new Certidao
	 */
	Long create(Certidao CertidaoDetails);

	/**
	 * Updates a Certidao with
	 * 
	 * @param CertidaoId      ID of Certidao
	 * @param CertidaoDetails Certidao details from EDIT FORM
	 */
	void update(Long CertidaoId, Certidao CertidaoDetails);

	/**
	 * delete a Certidao from DB
	 * 
	 * @param CertidaoId ID of Certidao
	 */
	void delete(Long CertidaoId);
	
	public List<Certidao> findAllByCartorioId(Long cartorioId);

}
