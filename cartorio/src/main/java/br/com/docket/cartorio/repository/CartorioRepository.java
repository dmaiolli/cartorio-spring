package br.com.docket.cartorio.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.docket.cartorio.model.Cartorio;

@Repository
@Transactional
public interface CartorioRepository extends CrudRepository<Cartorio, Long>{

	
}
