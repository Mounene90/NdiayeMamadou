package sn.ucad.master2soir.NdiayeMamadou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ucad.master2soir.NdiayeMamadou.bo.Escale;
/**
 *
 * @author MAMADOU NDIAYE
 */
public interface EscaleRepository extends JpaRepository<Escale, String>{
	@Query("select e from Escale e where   e.numEscale like :x")
	public Page<Escale> cherchers(@Param("x")String mc,Pageable pageable);
	

}
