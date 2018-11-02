/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package com.taxes.web;

import com.taxes.dao.TaxeRepository;
import com.taxes.entities.Entreprise;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.taxes.dao.EntrepriseRepository;


@Controller
public class TaxeController {
    @Autowired
    private EntrepriseRepository entrepriseRepository;

    @Autowired
    private TaxeRepository taxeRepository;
    
    @RequestMapping(value="/entreprises", method=RequestMethod.GET)
    public String index(Model model, 
            @RequestParam(name="motCle", defaultValue="") String mc,
            @RequestParam(name="page", defaultValue = "0") int p,
            @RequestParam(name="size", defaultValue="4") int s) {
        
        Page<Entreprise> pageEntreprises = entrepriseRepository.chercher("%"+mc+"%", new PageRequest(p, s));
        model.addAttribute("listEntreprises", pageEntreprises.getContent());
        int[] pages = new int[pageEntreprises.getTotalPages()];
        model.addAttribute("pages", pages);
        model.addAttribute("pageCourante", p);
        model.addAttribute("motCle", mc);
        return "entreprises";
    }
    
    @GetMapping("/formEntreprise")
    public String formEntreprise(Model model) {
        model.addAttribute("entreprise", new Entreprise());
        return "formEntreprise";
    }
    
    @PostMapping("/saveEntreprise")
    public String saveEntreprise(Model model, @Valid Entreprise entreprise, Errors errors) {
        if(errors.hasErrors()) {
            return "formEntreprise";
        }

        entrepriseRepository.save(entreprise);
        return "redirect:/entreprises";
    }
    
    @GetMapping("/taxes")
    public String getTaxes(Model model, @RequestParam(name="code") Long code) {
        Entreprise entreprise = new Entreprise();
        entreprise.setCode(code);
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("taxes", taxeRepository.findByEntreprise(entreprise));
        return "taxes";
    }
 
    
}
