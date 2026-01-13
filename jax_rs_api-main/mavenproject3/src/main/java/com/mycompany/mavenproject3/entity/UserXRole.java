/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject3.entity;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
//import javax.xml.bind.annot/ation.XmlRootElement;

/**
 *
 * @author bzhal
 */
@Entity
@Table(name = "user_x_role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserXRole.findAll", query = "SELECT u FROM UserXRole u"),
    @NamedQuery(name = "UserXRole.findById", query = "SELECT u FROM UserXRole u WHERE u.id = :id"),
    @NamedQuery(name = "UserXRole.findByUserId", query = "SELECT u FROM UserXRole u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserXRole.findByRoleId", query = "SELECT u FROM UserXRole u WHERE u.roleId = :roleId")})
public class UserXRole implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "role_id")
    private int roleId;

    public UserXRole() {
    }

    public UserXRole(Integer id) {
        this.id = id;
    }

    public UserXRole(Integer id, int userId, int roleId) {
        this.id = id;
        this.userId = userId;
        this.roleId = roleId;
    }

    public Integer getId() {
        return id;
    }

//    public void setId(Integer id) {
//        this.id = id;
//    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
        if (!(object instanceof UserXRole)) {
            return false;
        }
        UserXRole other = (UserXRole) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.entity.UserXRole[ id=" + id + " ]";
    }
    
}
