package sn.ucad.master2soir.NdiayeMamadou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ucad.master2soir.NdiayeMamadou.bo.Consignataire;
/**
 *
 * @author MAMADOU NDIAYE
 */
public interface ConsignataireRepository extends JpaRepository<Consignataire, String>{
	@Query("select c from Consignataire c where c.libelleConsignataire like :x")
	public Page<Consignataire> cherchercon(@Param("x")String mc,Pageable pageable);

}
