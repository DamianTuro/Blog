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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Gofer
 */
@Entity
@Table(name = "URZYTKOWNICY")
@NamedQueries({
    @NamedQuery(name = "Urzytkownicy.findAll", query = "SELECT u FROM Urzytkownicy u")})
public class Urzytkownicy implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 20)
    @Column(name = "IMIE")
    private String imie;
    @Size(max = 20)
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Size(max = 20)
    @Column(name = "USERNAME")
    private String username;
    @Size(max = 20)
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Konta konta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "urzytkownicyId")
    private Collection<Komentarze> komentarzeCollection;

    public Urzytkownicy() {
    }

    public Urzytkownicy(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Konta getKonta() {
        return konta;
    }

    public void setKonta(Konta konta) {
        this.konta = konta;
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
        if (!(object instanceof Urzytkownicy)) {
            return false;
        }
        Urzytkownicy other = (Urzytkownicy) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Baza.Urzytkownicy[ id=" + id + " ]";
    }
    
}
