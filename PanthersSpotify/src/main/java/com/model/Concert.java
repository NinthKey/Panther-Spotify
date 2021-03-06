/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author yangxiang
 */
@Entity
@Table(name = "concert", catalog = "panthers", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Concert.findAll", query = "SELECT c FROM Concert c")
    , @NamedQuery(name = "Concert.findByCid", query = "SELECT c FROM Concert c WHERE c.cid = :cid")
    , @NamedQuery(name = "Concert.findByCtime", query = "SELECT c FROM Concert c WHERE c.ctime = :ctime")
    , @NamedQuery(name = "Concert.findByCname", query = "SELECT c FROM Concert c WHERE c.cname = :cname")
    , @NamedQuery(name = "Concert.findByAddress", query = "SELECT c FROM Concert c WHERE c.address = :address")})
public class Concert implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(name = "cid", nullable = false)
    private Integer cid;
    @Column(name = "ctime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ctime;
    @Column(name = "cname", length = 50)
    private String cname;
    @Column(name = "address", length = 200)
    private String address;
    @JoinColumn(name = "uemail", referencedColumnName = "email", nullable = false)
    @ManyToOne(optional = false)
    private User uemail;
    @JoinColumn(name = "lid", referencedColumnName = "lid")
    @ManyToOne
    private Location lid;

    public Concert() {
    }

    public Concert(Integer cid) {
        this.cid = cid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public User getUemail() {
        return uemail;
    }

    public void setUemail(User uemail) {
        this.uemail = uemail;
    }

    public Location getLid() {
        return lid;
    }

    public void setLid(Location lid) {
        this.lid = lid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cid != null ? cid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Concert)) {
            return false;
        }
        Concert other = (Concert) object;
        if ((this.cid == null && other.cid != null) || (this.cid != null && !this.cid.equals(other.cid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "javaapplication2.Concert[ cid=" + cid + " ]";
    }
    
}
