package sn.ucad.master2soir.NdiayeMamadou;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import sn.ucad.master2soir.NdiayeMamadou.bo.BonPilotage;
import sn.ucad.master2soir.NdiayeMamadou.bo.Consignataire;
import sn.ucad.master2soir.NdiayeMamadou.bo.Escale;
import sn.ucad.master2soir.NdiayeMamadou.bo.Navire;
import sn.ucad.master2soir.NdiayeMamadou.bo.TypeMouvement;
import sn.ucad.master2soir.NdiayeMamadou.dao.BonPilotageRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.ConsignataireRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.EscaleRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.NavireRepository;
import sn.ucad.master2soir.NdiayeMamadou.dao.TypeMouvementRepository;

@SpringBootApplication
public class NdiayeMamadouApplication {

	public static void main(String[] args) {
		SpringApplication.run(NdiayeMamadouApplication.class, args);
	}
	@Autowired
	private NavireRepository navireRepository;
        @Autowired
	private EscaleRepository escaleRepository;
        @Autowired
	private BonPilotageRepository bonPilotageRepository;
	@Autowired
	private ConsignataireRepository consignataireRepository;
        @Autowired
       private TypeMouvementRepository typemouvementRepository;

	
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Navire nav1 = navireRepository.save(new Navire("ALINE SITEO DIATTA", "P001", 76, 16, 3867, 3));
		Navire nav2 = navireRepository.save(new Navire("COUMBA CASTEL", "P002", 30, 10	, 100, 2));
		Navire nav3 = navireRepository.save(new Navire("TITA NIC", "P003", 760, 160, 386798, 20));
		Navire nav4 = navireRepository.save(new Navire("DJOLA", "P004", 20, 19, 1024, 5));
		Navire nav5 = navireRepository.save(new Navire("ALINE SITEO DIATTA-2", "P005", 24, 12, 900, 6));
		Navire nav6 = navireRepository.save(new Navire("ALINE SITEO DIATTA-3", "P006", 10, 9, 2300, 4));
		Navire nav7 = navireRepository.save(new Navire("ALINE SITEO DIATTA-4", "P007", 76, 16, 1990, 8));
		Navire nav8 = navireRepository.save(new Navire("ALINE SITEO DIATTA-5", "P008", 70, 18, 590, 10));
		
		Consignataire cons1=consignataireRepository.save(new Consignataire("C001", "Bollore senegal",778115257));
		Consignataire cons2=consignataireRepository.save(new Consignataire("C002", "UPS",772346700));
		Consignataire cons3=consignataireRepository.save(new Consignataire("C003", "AVS",770114530));
		
		Escale esc = escaleRepository.save(new Escale("2016001", "2018-10-12", "2018-10-04", nav1,cons1 ,10));
		Escale esc1 = escaleRepository.save(new Escale("2016002", "2018-10-10", "2018-10-13", nav2,cons2, 14));
		Escale esc2 = escaleRepository.save(new Escale("2016003", "2018-10-20", "2018-10-21", nav4,cons3, 16));
		TypeMouvement typ=typemouvementRepository.save(new TypeMouvement("E", "EntrÃ©e au port", 5));
		//BonPilotage b1 = bonPilotageRepository.save(new BonPilotage(new Date(), "101", esc, typ));
				TypeMouvement type= typemouvementRepository.save(new TypeMouvement("E", "EntrÃ©e au port",5));
		//BonPilotage b1 = bonPilotageRepository.save(new BonPilotage(Entre au port","2018-10-20", "101", 5, esc));
		BonPilotage b1 = bonPilotageRepository.save(new BonPilotage("P0897","2018-10-20","101", esc2, type));
               //TypemvtRepository.save(new BonPilotage("E", ,  5, new Date(),"101", esc));
		
		
		//BonPilotage b1 = bonPilotageRepository.save(new BonPilotage( new Date(), "101", esc));
		
		
	}
	

}
