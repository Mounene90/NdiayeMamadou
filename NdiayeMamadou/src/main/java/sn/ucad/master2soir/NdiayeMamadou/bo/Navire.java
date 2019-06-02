package sn.ucad.master2soir.NdiayeMamadou.bo;

import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Navire implements Serializable{
	
	/**
	 * 
	 */
	
	@NotNull
	@Size(min=4,max=27)
	private String nomNavire="";
	
	@Id 
	@NotNull
	@Size(min=4,max=10)
	private String numeroNavire="";
	
	private Long longueurNavire=(long) 0;
	
	private Long largeurNavire=(long) 0;
	

	private Long voulumeNavire=(long) 0;
	
	private Long tiranEauNavire=(long) 0;
	@OneToMany(mappedBy="mynavire"/*,fetch=FetchType.LAZY*/,cascade = ALL)
	private Collection<Escale> escales;

	public Navire() {
		// TODO Auto-generated constructor stub
	}

	public Navire(String nomNavire, String numeroNavire, long longueurNavire, long largeurNavire, long voulumeNavire,
			long tiranEauNavire) {
		super();
		this.nomNavire = nomNavire;
		this.numeroNavire = numeroNavire;
		this.longueurNavire = longueurNavire;
		this.largeurNavire = largeurNavire;
		this.voulumeNavire = voulumeNavire;
		this.tiranEauNavire = tiranEauNavire;
	}
	
	

	public String getNomNavire() {
		return nomNavire;
	}

	public void setNomNavire(String nomNavire) {
		this.nomNavire = nomNavire;
	}
	
	public String getNumeroNavire() {
		return numeroNavire;
	}

	public void setNumeroNavire(String numeroNavire) {
		this.numeroNavire = numeroNavire;
	}
	
	public long getLongueurNavire() {
		return longueurNavire;
	}

	public void setLongueurNavire(long longueurNavire) {
		this.longueurNavire = longueurNavire;
	}
	
	public long getLargeurNavire() {
		return largeurNavire;
	}

	public void setLargeurNavire(long largeurNavire) {
		this.largeurNavire = largeurNavire;
	}
	
	public long getVoulumeNavire() {
		return voulumeNavire;
	}

	public void setVoulumeNavire(long voulumeNavire) {
		this.voulumeNavire = voulumeNavire;
	}
	
	public long getTiranEauNavire() {
		return tiranEauNavire;
	}

	public void setTiranEauNavire(long tiranEauNavire) {
		this.tiranEauNavire = tiranEauNavire;
	}

	public Collection<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Collection<Escale> escales) {
		this.escales = escales;
	}

	
	
	
}
