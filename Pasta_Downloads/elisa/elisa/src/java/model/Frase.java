package model;

import dao.funcaoFrase;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "frase")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Frase.findAll", query = "SELECT f FROM Frase f"),
    @NamedQuery(name = "Frase.findById", query = "SELECT f FROM Frase f WHERE f.id = :id"),
    @NamedQuery(name = "Frase.findByFrase", query = "SELECT f FROM Frase f WHERE f.frase = :frase")})
public class Frase implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "frase")
    private String frase;
    @JoinColumn(name = "Significado_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Significado significadoid;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fraseId")
    private Collection<Resposta> respostaCollection;

    public Frase() {
    }

    public Frase(Integer id) {
        this.id = id;
    }

    public Frase(Integer id, String frase) {
        this.id = id;
        this.frase = frase;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }

    public Significado getSignificadoid() {
        return significadoid;
    }

    public void setSignificadoid(Significado significadoid) {
        this.significadoid = significadoid;
    }

    @XmlTransient
    public Collection<Resposta> getRespostaCollection() {
        return respostaCollection;
    }

    public void setRespostaCollection(Collection<Resposta> respostaCollection) {
        this.respostaCollection = respostaCollection;
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
        if (!(object instanceof Frase)) {
            return false;
        }
        Frase other = (Frase) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Significado[ id=" + id + " ]";
    }

    public void salvar(String fras, int SignificadoId) {
        new funcaoFrase().inserirFrase(fras, SignificadoId);
    }
}
