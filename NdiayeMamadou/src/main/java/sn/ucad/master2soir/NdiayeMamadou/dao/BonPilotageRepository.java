package sn.ucad.master2soir.NdiayeMamadou.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import sn.ucad.master2soir.NdiayeMamadou.bo.BonPilotage;
/**
 *
 * @author MAMADOU NDIAYE
 */
public interface BonPilotageRepository extends JpaRepository<BonPilotage, String> {
//	@Query("select b from BonPilotage b where   b.idMouvement like :x")
        @Query("select b from BonPilotage b where   b.codebon like :x")
	public Page<BonPilotage> chercherbon(@Param("x")String mc,Pageable pageable);

}
