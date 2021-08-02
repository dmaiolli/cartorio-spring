package br.com.docket.cartorio.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.repository.CartorioRepository;

@Service
public class CartorioServiceImpl implements CartorioService {

    @Autowired
    private CartorioRepository cartorioRepository;

    /**
     * gets all Cartorios from Database
     * @return  a Set containing Cartorios
     */
    @Override
    public List<Cartorio> getAll(){
        List<Cartorio> CartorioSet = new ArrayList<>();
        cartorioRepository.findAll().iterator().forEachRemaining(CartorioSet::add);
        return CartorioSet;
    }

    /**
     * finds a Cartorio in DB by its ID
     * @param CartorioId    Database ID of Cartorio
     * @return          Cartorio with ID = CartorioId
     */
    @Override
    public Cartorio findById(Long cartorioId){
        Optional<Cartorio> cartorioOptional = cartorioRepository.findById(cartorioId);

        if (!cartorioOptional.isPresent()) {
            throw new RuntimeException("Cartorio Not Found!");
        }
        return cartorioOptional.get();
    }

    /**
     * Updates a Cartorio with
     * @param CartorioId                ID of Cartorio
     * @param CartorioDetails           Cartorio details from EDIT FORM
     */
    @Override
    public void update(Long cartorioId, Cartorio cartorioDetails){
        Cartorio currentCartorio = findById(cartorioId);
        currentCartorio.setNome(cartorioDetails.getNome());
        currentCartorio.setEndereco(cartorioDetails.getEndereco());

        cartorioRepository.save(currentCartorio);
    }

    /**
     * delete a Cartorio from DB
     * @param CartorioId     ID of Cartorio
     */
    @Override
    public void delete(Long CartorioId){
        cartorioRepository.deleteById(CartorioId);
    }

    /**
     * creates and inserts a new Cartorio in DB
     * @param CartorioDetails      Cartorio details from NEW Cartorio FROM
     * @return                 id of new Cartorio
     */
    @Override
    public Long create(Cartorio CartorioDetails){
        cartorioRepository.save(CartorioDetails);
        return CartorioDetails.getId();
    }
}
