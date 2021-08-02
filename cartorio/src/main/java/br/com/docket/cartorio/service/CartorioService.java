package br.com.docket.cartorio.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.docket.cartorio.model.Cartorio;

@Service
public interface CartorioService extends CrudService<Cartorio, Long> {

	/**
	 * gets all Cartorios from Database
	 * 
	 * @return a List containing Cartorios
	 */
	List<Cartorio> getAll();

	/**
	 * finds a Cartorio in DB by its ID
	 * 
	 * @param CartorioId Database ID of Cartorio
	 * @return Cartorio with ID = CartorioId
	 */
	Cartorio findById(Long CartorioId);

	/**
	 * creates and inserts a new Cartorio in DB
	 * 
	 * @param CartorioDetails Cartorio details from NEW Cartorio FROM
	 * @return id of new Cartorio
	 */
	Long create(Cartorio CartorioDetails);

	/**
	 * Updates a Cartorio with
	 * 
	 * @param CartorioId      ID of Cartorio
	 * @param CartorioDetails Cartorio details from EDIT FORM
	 */
	void update(Long CartorioId, Cartorio CartorioDetails);

	/**
	 * delete a Cartorio from DB
	 * 
	 * @param CartorioId ID of Cartorio
	 */
	void delete(Long CartorioId);
}
