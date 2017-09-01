/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.taxes.dao;

import com.taxes.entities.Entreprise;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long> {

    @Query("SELECT e From Entreprise e WHERE e.nom like :x")
    public Page<Entreprise> chercher(@Param("x") String e, Pageable pageable);    
}
