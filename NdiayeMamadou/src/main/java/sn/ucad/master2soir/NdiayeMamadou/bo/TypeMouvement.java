/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sn.ucad.master2soir.NdiayeMamadou.bo;

import java.io.Serializable;
import java.util.Collection;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
/**
 *
 * @author MAMADOU NDIAYE
 */
@Entity
public class TypeMouvement implements Serializable{
    @Id 
    @NotNull
   @Size(min=1,max=2)
    private String codeTypeMvt;
    @NotNull
    @Size(min=4,max=40)
    private String libelleTypeMvt;
    @NotNull
    private long prixTypeMvt;
    @OneToMany(mappedBy="mouvement"/*,fetch=FetchType.LAZY*/,cascade = ALL)
    private Collection<BonPilotage> bonpilotages;

    public TypeMouvement() {
    }

    public TypeMouvement(String codeTypeMvt, String libelleTypeMvt, long prixTypeMvt) {
        this.codeTypeMvt = codeTypeMvt;
        this.libelleTypeMvt = libelleTypeMvt;
        this.prixTypeMvt = prixTypeMvt;
        
    }
   
    public String getCodeTypeMvt() {
        return codeTypeMvt;
    }
    
    public String getLibelleTypeMvt() {
        return libelleTypeMvt;
    }

    public long getPrixTypeMvt() {
        return prixTypeMvt;
    }

    public Collection<BonPilotage> getBonPilotage() {
        return bonpilotages;
    }

    public void setCodeTypeMvt(String codeTypeMvt) {
        this.codeTypeMvt = codeTypeMvt;
    }

    public void setLibelleTypeMvt(String libelleTypeMvt) {
        this.libelleTypeMvt = libelleTypeMvt;
    }

    public void setPrixTypeMvt(long prixTypeMvt) {
        this.prixTypeMvt = prixTypeMvt;
    }

    public void setBonPilotage(Collection<BonPilotage> bonpilotages) {
        this.bonpilotages = bonpilotages;
    }
            
    
}
