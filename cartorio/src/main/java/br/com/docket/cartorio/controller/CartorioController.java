package br.com.docket.cartorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.docket.cartorio.model.Cartorio;
import br.com.docket.cartorio.service.CartorioService;

@Controller
public class CartorioController {

    @Autowired
    private CartorioService cartorioService;
    
    /**
     * 
     * @param model
     * @return index page
     */
    @GetMapping("/")
    public String getAllCartorios(Model model) {
    	model.addAttribute("cartorios", cartorioService.getAll());
    	return "index";
    }

    /**
     * New Cartorio Form
     * @param model     Cartorio object
     * @return template form for new Cartorio
     */
    @GetMapping("/cartorio/add")
    public String newCartorioForm(Model model) {
        model.addAttribute("cartorio", new Cartorio());
        return "newCartorio";
    }

    /**
     * saves the details of "Cartorio/create" to DB
     * @param Cartorio      field values
     * @return          redirection to list view of all index
     */
    @PostMapping("/cartorio/add")
    public String saveNewCartorio(Cartorio cartorio, Model model) {
    	model.addAttribute("cartorio", cartorio);
        cartorioService.create(cartorio);
    	model.addAttribute("cartorios", cartorioService.getAll());
    	return "index";
    }

    /**
     * Edit Form
     * @param id        Cartorio Id
     * @param model     Cartorio object
     * @return          template for editing a Cartorio
     */
    @GetMapping("/cartorio/edit/{id}")
    public String editCartorioForm(@PathVariable("id") Long id, Model model) {
        Cartorio cartorio = cartorioService.findById(id);
        model.addAttribute("cartorio", cartorio);
        return "editCartorio";
    }
    
    /** Saves Cartorio details from edit template for an existing Cartorio in DB
    * @param id, cartorio
    * @param Cartorio details (of field values)
    * @return redirection to list view of all Cartorios
    */
    @PostMapping("/cartorio/update/{id}")
    public String updateCartorio(@PathVariable("id") Long id, @Validated Cartorio cartorio, BindingResult result, Model model) {
    	if(result.hasErrors()) {
    		return "index";
    	}
    	
    	cartorioService.update(id, cartorio);
    	model.addAttribute("cartorios", cartorioService.getAll());
    	return "index";
    }

    /**
     * deletes existing Cartorio from DB
     * @param id        Cartorio Id
     * @return          redirection to list view of all Cartorios
     */
    @GetMapping(path = "/cartorio/delete/{id}")
    public String deleteCartorio(@PathVariable("id") Long id, Model model) {
        cartorioService.delete(id);
    	model.addAttribute("cartorios", cartorioService.getAll());
    	return "index";
    }
}
