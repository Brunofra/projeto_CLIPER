/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bac.com.br.hibernate.entidade;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author bruno
 */
@Entity
@Table(name = "colaborador")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Colaborador.findAll", query = "SELECT c FROM Colaborador c"),
    @NamedQuery(name = "Colaborador.findById", query = "SELECT c FROM Colaborador c WHERE c.id = :id"),
    @NamedQuery(name = "Colaborador.findByDataAdm", query = "SELECT c FROM Colaborador c WHERE c.dataAdm = :dataAdm"),
    @NamedQuery(name = "Colaborador.findByDataNasc", query = "SELECT c FROM Colaborador c WHERE c.dataNasc = :dataNasc"),
    @NamedQuery(name = "Colaborador.findByNome", query = "SELECT c FROM Colaborador c WHERE c.nome = :nome"),
    @NamedQuery(name = "Colaborador.findByRegistro", query = "SELECT c FROM Colaborador c WHERE c.registro = :registro"),
    @NamedQuery(name = "Colaborador.findByStatus", query = "SELECT c FROM Colaborador c WHERE c.status = :status"),
    @NamedQuery(name = "Colaborador.findByPis", query = "SELECT c FROM Colaborador c WHERE c.pis = :pis"),
    @NamedQuery(name = "Colaborador.findBySexo", query = "SELECT c FROM Colaborador c WHERE c.sexo = :sexo"),
    @NamedQuery(name = "Colaborador.findByCtps", query = "SELECT c FROM Colaborador c WHERE c.ctps = :ctps"),
    @NamedQuery(name = "Colaborador.findBySerie", query = "SELECT c FROM Colaborador c WHERE c.serie = :serie"),
    @NamedQuery(name = "Colaborador.findByEstado", query = "SELECT c FROM Colaborador c WHERE c.estado = :estado")})
public class Colaborador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Column(name = "data_adm")
    @Temporal(TemporalType.DATE)
    private Date dataAdm;
    @Column(name = "data_nasc")
    @Temporal(TemporalType.DATE)
    private Date dataNasc;
    @Basic(optional = false)
    @Column(nullable = false, length = 200)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 50)
    private String registro;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String status;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String pis;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String sexo;
    @Column(length = 20)
    private String ctps;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String serie;
    @Basic(optional = false)
    @Column(nullable = false, length = 20)
    private String estado;
    @ManyToMany(mappedBy = "colaboradorList", fetch = FetchType.LAZY)
    private List<Treinamento> treinamentoList;
    @OneToMany(mappedBy = "idColaborador", fetch = FetchType.LAZY)
    private List<Historico> historicoList;
    @JoinColumn(name = "funcao_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Funcao funcaoId;
    @OneToMany(mappedBy = "colaboradorId", fetch = FetchType.LAZY)
    private List<Curso> cursoList;

    public Colaborador() {
    }

    public Colaborador(Long id) {
        this.id = id;
    }

    public Colaborador(Long id, String nome, String registro, String status, String pis, String sexo, String serie, String estado) {
        this.id = id;
        this.nome = nome;
        this.registro = registro;
        this.status = status;
        this.pis = pis;
        this.sexo = sexo;
        this.serie = serie;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAdm() {
        return dataAdm;
    }

    public void setDataAdm(Date dataAdm) {
        this.dataAdm = dataAdm;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRegistro() {
        return registro;
    }

    public void setRegistro(String registro) {
        this.registro = registro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPis() {
        return pis;
    }

    public void setPis(String pis) {
        this.pis = pis;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Treinamento> getTreinamentoList() {
        return treinamentoList;
    }

    public void setTreinamentoList(List<Treinamento> treinamentoList) {
        this.treinamentoList = treinamentoList;
    }

    @XmlTransient
    public List<Historico> getHistoricoList() {
        return historicoList;
    }

    public void setHistoricoList(List<Historico> historicoList) {
        this.historicoList = historicoList;
    }

    public Funcao getFuncaoId() {
        return funcaoId;
    }

    public void setFuncaoId(Funcao funcaoId) {
        this.funcaoId = funcaoId;
    }

    @XmlTransient
    public List<Curso> getCursoList() {
        return cursoList;
    }

    public void setCursoList(List<Curso> cursoList) {
        this.cursoList = cursoList;
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
        if (!(object instanceof Colaborador)) {
            return false;
        }
        Colaborador other = (Colaborador) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bac.com.br.hibernate.entidade.Colaborador[ id=" + id + " ]";
    }
    
}
