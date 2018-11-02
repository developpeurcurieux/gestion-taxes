/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.taxes.dao;

import com.taxes.entities.Entreprise;
import com.taxes.entities.Taxe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kakashi
 */
@Repository
public interface TaxeRepository extends JpaRepository<Taxe, Long> {
    public List<Taxe> findByEntreprise(Entreprise entreprise);
}
