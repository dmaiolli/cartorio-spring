package br.com.docket.cartorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.docket.cartorio.model.Certidao;

@Repository
@Transactional
public interface CertidaoRepository extends CrudRepository<Certidao, Long> {
	
	@Query(value = "from Certidao c WHERE c.cartorio.id=:cartorioId")
	public List<Certidao> findAllByCartorioId(@Param("cartorioId") Long cartorioId);

}
