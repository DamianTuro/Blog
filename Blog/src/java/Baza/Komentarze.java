/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baza;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gofer
 */
@Entity
@Table(name = "KOMENTARZE")
@NamedQueries({
    @NamedQuery(name = "Komentarze.findAll", query = "SELECT k FROM Komentarze k")})
public class Komentarze implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 500)
    @Column(name = "TRESC_KOM")
    private String trescKom;
    @JoinColumn(name = "POSTY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Posty postyId;
    @JoinColumn(name = "URZYTKOWNICY_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Urzytkownicy urzytkownicyId;

    public Komentarze() {
    }

    public Komentarze(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrescKom() {
        return trescKom;
    }

    public void setTrescKom(String trescKom) {
        this.trescKom = trescKom;
    }

    public Posty getPostyId() {
        return postyId;
    }

    public void setPostyId(Posty postyId) {
        this.postyId = postyId;
    }

    public Urzytkownicy getUrzytkownicyId() {
        return urzytkownicyId;
    }

    public void setUrzytkownicyId(Urzytkownicy urzytkownicyId) {
        this.urzytkownicyId = urzytkownicyId;
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
        if (!(object instanceof Komentarze)) {
            return false;
        }
        Komentarze other = (Komentarze) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Komentarze[ id=" + id + " ]";
    }
    
}
