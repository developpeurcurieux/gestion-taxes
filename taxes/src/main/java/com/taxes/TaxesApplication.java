package com.taxes;

import com.taxes.dao.IEntrepriseRepository;
import com.taxes.entities.Entreprise;
import com.taxes.entities.IR;
import com.taxes.entities.ITaxeRepository;
import com.taxes.entities.TVA;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class TaxesApplication implements CommandLineRunner {
    @Autowired
    private IEntrepriseRepository entrepriseRepository;
    
    @Autowired
    private ITaxeRepository taxeRepository;
    
    
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(TaxesApplication.class, args);
    }
    
    @Override
    public void run(String... arg0) throws Exception {
        Entreprise e1 = entrepriseRepository.save(
                new Entreprise("R1", "r1@gmail.com", "SARL"));
        Entreprise e2 = entrepriseRepository.save(
                new Entreprise("R2", "r2@gmail.com", "SASU"));
        
        taxeRepository.save(new TVA("TVA Habitation", new Date(), 900, e1));
        taxeRepository.save(new TVA("TVA Voiture", new Date(), 1200, e1));
        taxeRepository.save(new IR("IR 2016", new Date(), 4500, e1));
        taxeRepository.save(new IR("IR 2016", new Date(), 5000, e2));
    }
}
