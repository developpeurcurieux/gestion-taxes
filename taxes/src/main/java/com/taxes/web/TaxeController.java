/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taxes.web;

import com.taxes.dao.IEntrepriseRepository;
import com.taxes.entities.Entreprise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class TaxeController {
    @Autowired
    private IEntrepriseRepository entrepriseRepository;
    
    @RequestMapping(value="/entreprises", method=RequestMethod.GET)
    public String index(Model model, int page, int size) {
        Page<Entreprise> pageEntreprises = entrepriseRepository.findAll(new PageRequest(page, size));
        model.addAttribute("listEntreprises", pageEntreprises.getContent());
        int[] pages = new int[pageEntreprises.getTotalPages()];
        return "entreprises";
    }
    
    
}
