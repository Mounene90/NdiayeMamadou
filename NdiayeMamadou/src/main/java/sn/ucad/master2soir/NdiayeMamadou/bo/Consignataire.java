package sn.ucad.master2soir.NdiayeMamadou.bo;

import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
@Entity
public class Consignataire {
	@Id
	@NotNull
	@Size(min=4,max=10)
	private String numConsignataire;
	@NotNull
	@Size(min=2,max=30)
	private String libelleConsignataire;
	@NotNull
	private int TelephoneConsignataire;
	@OneToMany(mappedBy="myconsignataire"/*,fetch=FetchType.LAZY*/,cascade = ALL)
	private Collection<Escale> escales;
	
	public Consignataire() {
		// TODO Auto-generated constructor stub
	}

    public Consignataire(String numConsignataire, String libelleConsignataire, int TelephoneConsignataire) {
        this.numConsignataire = numConsignataire;
        this.libelleConsignataire = libelleConsignataire;
        this.TelephoneConsignataire = TelephoneConsignataire;
    }

	
        
	public String getNumConsignataire() {
		return numConsignataire;
	}

	public void setNumConsignataire(String numConsignataire) {
		this.numConsignataire = numConsignataire;
	}

    public String getLibelleConsignataire() {
        return libelleConsignataire;
    }

    public void setLibelleConsignataire(String libelleConsignataire) {
        this.libelleConsignataire = libelleConsignataire;
    }

	

	public int getTelephoneConsignataire() {
		return TelephoneConsignataire;
	}

	public void setTelephoneConsignataire(int telephoneConsignataire) {
		TelephoneConsignataire = telephoneConsignataire;
	}

	public Collection<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Collection<Escale> escales) {
		this.escales = escales;
	}
	
	

}
