package sn.ucad.master2soir.NdiayeMamadou.bo;

import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author MAMADOU NDIAYE
 */
@Entity
public class Escale implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Size(min=4,max=27)
	private String numEscale;
	@NotNull
       
	private String debutEscale;
	@NotNull
	private String finEsale;
	@ManyToOne
	@JoinColumn(name="NUMERO_NAVIRE")
	private Navire mynavire;
	@ManyToOne
	@JoinColumn(name="NUMERO_CONSIGNATAIRE")
	private Consignataire myconsignataire;
	@NotNull
	private long prixSejour; 
	@OneToMany(mappedBy="monEscale"/*,fetch=FetchType.LAZY*/,cascade = ALL)
	private Collection<BonPilotage> bonpilotages;
	
	

	public Escale() {
		// TODO Auto-generated constructor stub
	}
	public Escale(String numEscale, String debutEscale, String  finEsale, Navire mynavire, Consignataire myconsignataire,
			long prixSejour) {
		super();
		this.numEscale = numEscale;
		this.debutEscale = debutEscale;
		this.finEsale = finEsale;
		this.mynavire = mynavire;
		this.myconsignataire = myconsignataire;
		this.prixSejour = prixSejour;
	}

	

	public String getNumEscale() {
		return numEscale;
	}

	public void setNumEscale(String numEscale) {
		this.numEscale = numEscale;
	}

	public String  getDebutEscale() {
		return debutEscale;
	}

	public void setDebutEscale(String  debutEscale) {
		this.debutEscale = debutEscale;
	}

	public String  getFinEsale() {
		return finEsale;
	}

	public void setFinEsale(String  finEsale) {
		this.finEsale = finEsale;
	}

	public Navire getMynavire() {
		return mynavire;
	}

	public void setMynavire(Navire mynavire) {
		this.mynavire = mynavire;
	}

	public long getPrixSejour() {
		return prixSejour;
	}

	public void setPrixSejour(long prixSejour) {
		this.prixSejour = prixSejour;
	}

	public Consignataire getMyconsignataire() {
		return myconsignataire;
	}

	public void setMyconsignataire(Consignataire myconsignataire) {
		this.myconsignataire = myconsignataire;
	}

	public Collection<BonPilotage> getBonPilotage() {
		return bonpilotages;
	}

	public void setBonPilotage(Collection<BonPilotage> bonpilotages) {
		this.bonpilotages = bonpilotages;
	}
	
	
}
