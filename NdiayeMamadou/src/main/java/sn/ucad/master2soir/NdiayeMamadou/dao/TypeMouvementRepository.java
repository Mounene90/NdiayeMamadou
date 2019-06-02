/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ucad.master2soir.NdiayeMamadou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ucad.master2soir.NdiayeMamadou.bo.TypeMouvement;

/**
 *
 * @author MAMADOU NDIAYE
 */
public interface TypeMouvementRepository extends JpaRepository<TypeMouvement, String>{
    @Query("select t from TypeMouvement t where t.codeTypeMvt like :x")
	public Page<TypeMouvement> cherchert(@Param("x")String mc,Pageable pageable);
}
