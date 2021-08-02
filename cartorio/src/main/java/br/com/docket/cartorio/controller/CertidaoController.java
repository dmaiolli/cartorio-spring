package br.com.docket.cartorio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.model.Certidao;
import br.com.docket.cartorio.service.CartorioService;
import br.com.docket.cartorio.service.CertidaoService;

@Controller
public class CertidaoController {

	@Autowired
	private CertidaoService certidaoService;
	
	@Autowired
	private CartorioService cartorioService;
	
	/**
	 * List all Certidoes witch pertences a same Cartorio
	 * @param cartorioId
	 * @param model
	 * @return redirect to list all Certidoes 
	 */
	@GetMapping("/certidao/all/{id}")
	public String getAllCertidoesByCartorio(@PathVariable("id") Long cartorioId, Model model) {
		List<Certidao> certidoes = certidaoService.findAllByCartorioId(cartorioId);
		model.addAttribute("certidoes", certidoes);
		model.addAttribute("cartorio", cartorioService.findById(cartorioId));
		return "listCertidoes";
	}
	
    /**
     * Edit Form
     * @param id        Certidao Id
     * @param model     Certidao object
     * @return          template for save a new Certidao
     */
	@GetMapping("/certidao/add/{id}")
	public String newCertidaoForm(@PathVariable("id")Long id, Model model) {
		Cartorio cartorio = cartorioService.findById(id);
        model.addAttribute("certidao", new Certidao());
        model.addAttribute("cartorio", cartorio);
        return "newCertidao";
	}
	
	/**
	 * Saves Certidao details from edit template for an existing Certidao in DB
	 * @param cartorioId
	 * @param model 
	 * @param certidao
	 * @return redirection to list view of all Cartorios
	 */
	@PostMapping("/certidao/add/{cartorioId}")
	public String saveNewCertidao(@PathVariable("cartorioId")Long cartorioId, Model model, @Validated Certidao certidao) {
		Cartorio cartorio = cartorioService.findById(cartorioId);
		cartorio.addCertidao(certidao);
		certidaoService.create(certidao);
		return "redirect:/";
	}

    /**
     * deletes existing Certidao from DB
     * @param id        Certidao Id
     * @return          redirection to list view of all Cartorios
     */
    @GetMapping(path = "/certidao/delete/{id}")
    public String deleteCertidao(@PathVariable("id") Long id, Model model) {
        certidaoService.delete(id);
    	return "redirect:/";
    }
}
