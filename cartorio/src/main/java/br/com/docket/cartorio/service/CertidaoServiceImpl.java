package br.com.docket.cartorio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docket.cartorio.model.Certidao;
import br.com.docket.cartorio.repository.CertidaoRepository;

@Service
public class CertidaoServiceImpl implements CertidaoService {

	@Autowired
	private CertidaoRepository certidaoRepository;

	/**
	 * gets all Certidaos from Database
	 * 
	 * @return a Set containing Certidaos
	 */
	@Override
	public List<Certidao> getAll() {
		List<Certidao> certidaoSet = new ArrayList<>();
		certidaoRepository.findAll().iterator().forEachRemaining(certidaoSet::add);
		return certidaoSet;
	}

	/**
	 * finds a Certidao in DB by its ID
	 * 
	 * @param CertidaoId Database ID of Certidao
	 * @return Certidao with ID = CertidaoId
	 */
	@Override
	public Certidao findById(Long certidaoId) {
		Optional<Certidao> certidaoOptional = certidaoRepository.findById(certidaoId);
        if (!certidaoOptional.isPresent()) {
            throw new RuntimeException("Cartorio Not Found!");
        }
		return certidaoOptional.get();
	}

	/**
	 * Updates a Certidao with
	 * 
	 * @param CertidaoId      ID of Certidao
	 * @param CertidaoDetails Certidao details from EDIT FORM
	 */
	@Override
	public void update(Long certidaoId, Certidao certidaoDetails) {
		Certidao currentCertidao = findById(certidaoId);
		currentCertidao.setNome(certidaoDetails.getNome());
		currentCertidao.setCartorio(certidaoDetails.getCartorio());
		certidaoRepository.save(certidaoDetails);
	}

	/**
	 * delete a Certidao from DB
	 * 
	 * @param CertidaoId ID of Certidao
	 */
	@Override
	public void delete(Long certidaoId) {
		certidaoRepository.deleteById(certidaoId);
	}

	/**
	 * creates and inserts a new Certidao in DB
	 * 
	 * @param CertidaoDetails Certidao details from NEW Certidao FROM
	 * @return id of new Certidao
	 */
	@Override
	public Long create(Certidao certidaoDetails) {
		certidaoRepository.save(certidaoDetails);
		return certidaoDetails.getId();
	}

	@Override
	public List<Certidao> findAllByCartorioId(Long cartorioId) {
		return certidaoRepository.findAllByCartorioId(cartorioId);
	}
}
