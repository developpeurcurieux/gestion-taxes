/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taxes.dao;

import com.taxes.entities.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;



public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {
    
}
