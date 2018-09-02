/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lukin
 */
@Entity
@Table(name = "carro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carro.findAll", query = "SELECT c FROM Carro c")
    , @NamedQuery(name = "Carro.findById", query = "SELECT c FROM Carro c WHERE c.id = :id")
    , @NamedQuery(name = "Carro.findByNome", query = "SELECT c FROM Carro c WHERE c.nome = :nome")
    , @NamedQuery(name = "Carro.findByMarca", query = "SELECT c FROM Carro c WHERE c.marca = :marca")
    , @NamedQuery(name = "Carro.findByChassis", query = "SELECT c FROM Carro c WHERE c.chassis = :chassis")
    , @NamedQuery(name = "Carro.findByPlaca", query = "SELECT c FROM Carro c WHERE c.placa = :placa")
    , @NamedQuery(name = "Carro.findByKilometragem", query = "SELECT c FROM Carro c WHERE c.kilometragem = :kilometragem")
    , @NamedQuery(name = "Carro.findByStatus", query = "SELECT c FROM Carro c WHERE c.status = :status")
    , @NamedQuery(name = "Carro.findByValorDia", query = "SELECT c FROM Carro c WHERE c.valorDia = :valorDia")
    , @NamedQuery(name = "Carro.findByDataRetirada", query = "SELECT c FROM Carro c WHERE c.dataRetirada = :dataRetirada")
    , @NamedQuery(name = "Carro.findByDataDevolucao", query = "SELECT c FROM Carro c WHERE c.dataDevolucao = :dataDevolucao")
    , @NamedQuery(name = "Carro.findByClienteId", query = "SELECT c FROM Carro c WHERE c.clienteId = :clienteId")})
public class Carro implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @Column(name = "chassis")
    private String chassis;
    @Basic(optional = false)
    @Column(name = "placa")
    private String placa;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "kilometragem")
    private Double kilometragem;
    @Basic(optional = false)
    @Column(name = "status")
    private Integer status;
    @Column(name = "valor_dia")
    private Double valorDia;
    @Column(name = "data_retirada")
    @Temporal(TemporalType.DATE)
    private Date dataRetirada;
    @Column(name = "data_devolucao")
    @Temporal(TemporalType.DATE)
    private Date dataDevolucao;
    @Basic(optional = false)
    @Column(name = "cliente_id")
    private Integer clienteId;

    public Carro() {
    }

    public Carro(Integer id) {
        this.id = id;
    }

    public Carro(Integer id, String nome, String marca, String placa, Integer status, Integer clienteId) {
        this.id = id;
        this.nome = nome;
        this.marca = marca;
        this.placa = placa;
        this.status = status;
        this.clienteId = clienteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Double getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(Double kilometragem) {
        this.kilometragem = kilometragem;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getValorDia() {
        return valorDia;
    }

    public void setValorDia(Double valorDia) {
        this.valorDia = valorDia;
    }

    public Date getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Date dataRetirada) {
        this.dataRetirada = dataRetirada;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Integer getClienteId() {
        return clienteId;
    }

    public void setClienteId(Integer clienteId) {
        this.clienteId = clienteId;
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
        if (!(object instanceof Carro)) {
            return false;
        }
        Carro other = (Carro) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entity.Carro[ id=" + id + " ]";
    }
    
}
