/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gofer
 */
@Entity
@Table(name = "POSTY")
@NamedQueries({
    @NamedQuery(name = "Posty.findAll", query = "SELECT p FROM Posty p")})
public class Posty implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 100)
    @Column(name = "TYTU\u0141")
    private String tytuł;
    @Size(max = 1000)
    @Column(name = "TRESC")
    private String tresc;
    @JoinColumn(name = "ADMINI_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Admini adminiId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "postyId")
    private Collection<Komentarze> komentarzeCollection;

    public Posty() {
    }

    public Posty(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTytuł() {
        return tytuł;
    }

    public void setTytuł(String tytuł) {
        this.tytuł = tytuł;
    }

    public String getTresc() {
        return tresc;
    }

    public void setTresc(String tresc) {
        this.tresc = tresc;
    }

    public Admini getAdminiId() {
        return adminiId;
    }

    public void setAdminiId(Admini adminiId) {
        this.adminiId = adminiId;
    }

    public Collection<Komentarze> getKomentarzeCollection() {
        return komentarzeCollection;
    }

    public void setKomentarzeCollection(Collection<Komentarze> komentarzeCollection) {
        this.komentarzeCollection = komentarzeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Posty)) {
            return false;
        }
        Posty other = (Posty) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Posty[ id=" + id + " ]";
    }
    
}
