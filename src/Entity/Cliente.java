/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukin
 */
@Entity
@Table(name = "cliente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")
    , @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome")
    , @NamedQuery(name = "Cliente.findByRg", query = "SELECT c FROM Cliente c WHERE c.rg = :rg")
    , @NamedQuery(name = "Cliente.findByCpf", query = "SELECT c FROM Cliente c WHERE c.cpf = :cpf")
    , @NamedQuery(name = "Cliente.findByCnh", query = "SELECT c FROM Cliente c WHERE c.cnh = :cnh")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "Rg")
    private String rg;
    @Basic(optional = false)
    @Column(name = "Cpf")
    private String cpf;
    @Basic(optional = false)
    @Column(name = "CNH")
    private String cnh;

    public Cliente() {
    }

    public Cliente(String rg) {
        this.rg = rg;
    }

    public Cliente(String rg, String nome, String cpf, String cnh) {
        this.rg = rg;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (rg != null ? rg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.rg == null && other.rg != null) || (this.rg != null && !this.rg.equals(other.rg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Cliente[ rg=" + rg + " ]";
    }
    
}
