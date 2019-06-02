package sn.ucad.master2soir.NdiayeMamadou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ucad.master2soir.NdiayeMamadou.bo.Navire;
/**
 *
 * @author MAMADOU NDIAYE
 */
public interface NavireRepository extends JpaRepository<Navire, String> {
	@Query("select n from Navire n where n.nomNavire like :x")
	public Page<Navire> chercher(@Param("x")String mc,Pageable pageable);

}
