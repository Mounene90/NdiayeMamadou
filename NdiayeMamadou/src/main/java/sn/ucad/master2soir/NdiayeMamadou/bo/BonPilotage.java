package sn.ucad.master2soir.NdiayeMamadou.bo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
/**
 *
 * @author MAMADOU NDIAYE
 */
@Entity
public class BonPilotage implements Serializable{

	@Id 
//        @GeneratedValue(strategy=GenerationType.IDENTITY)
//	private int idMouvement;
        @NotNull
        private String codebon;
        @NotNull
	private String datedeBon;
        @NotNull
	private String posteaquai;
	@ManyToOne
	@JoinColumn(name="NUMERO_ESCALE")
	private Escale monEscale;
//	@ManyToOne
//	@JoinColumn(name="CodeTypeMvt")
//	private TypeMouvement mouvement;
        
        @ManyToOne
	@JoinColumn(name="NUM_MVT")
	private TypeMouvement mouvement;
	
	public BonPilotage() {
		// TODO Auto-generated constructor stub
	}

    public BonPilotage(String codebon, String datedeBon, String posteaquai, Escale monEscale, TypeMouvement mouvement) {
        this.codebon = codebon;
        this.datedeBon = datedeBon;
        this.posteaquai = posteaquai;
        this.monEscale = monEscale;
        this.mouvement = mouvement;
    }

    public String getCodebon() {
        return codebon;
    }

    public void setCodebon(String codebon) {
        this.codebon = codebon;
    }

    public String getDatedeBon() {
        return datedeBon;
    }

    public void setDatedeBon(String datedeBon) {
        this.datedeBon = datedeBon;
    }

    public String getPosteaquai() {
        return posteaquai;
    }

    public void setPosteaquai(String posteaquai) {
        this.posteaquai = posteaquai;
    }

    public Escale getMonEscale() {
        return monEscale;
    }

    public void setMonEscale(Escale monEscale) {
        this.monEscale = monEscale;
    }

    public TypeMouvement getMouvement() {
        return mouvement;
    }

    public void setMouvement(TypeMouvement mouvement) {
        this.mouvement = mouvement;
    }
    
    

   

}
