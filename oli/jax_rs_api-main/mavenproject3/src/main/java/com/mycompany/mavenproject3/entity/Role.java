package com.mycompany.mavenproject3.entity;

import static com.mycompany.mavenproject3.entity.User.emf;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "role")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Role.findAll", query = "SELECT r FROM Role r"),
    @NamedQuery(name = "Role.findById", query = "SELECT r FROM Role r WHERE r.id = :id"),
    @NamedQuery(name = "Role.findByName", query = "SELECT r FROM Role r WHERE r.name = :name"),
    @NamedQuery(name = "Role.findByCreatedAt", query = "SELECT r FROM Role r WHERE r.createdAt = :createdAt"),
    @NamedQuery(name = "Role.findByDeletedAt", query = "SELECT r FROM Role r WHERE r.deletedAt = :deletedAt"),
    @NamedQuery(name = "Role.findByIsDeleted", query = "SELECT r FROM Role r WHERE r.isDeleted = :isDeleted")})
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "is_deleted")
    private boolean isDeleted;

    public Role() {
    }

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_war_1.0-SNAPSHOTPU");
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public Role(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            Role role = em.find(Role.class, id);
            this.id = role.getId();
            this.name = role.getName();
            this.createdAt = role.getCreatedAt();
            this.deletedAt = role.getDeletedAt();
            this.isDeleted = role.getIsDeleted();
        } catch (Exception e) {
        }
    }

    public Role(Integer id, String name, Date createdAt, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
    }

    public Role(Integer id, String name, Date createdAt, Date deletedAt, boolean isDeleted) {
        this.id = id;
        this.name = name;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
        this.isDeleted = isDeleted;
    }

    public Role(String name) {
        this.name = name;
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Role)) {
            return false;
        }
        Role other = (Role) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.entity.Role[ id=" + id + " ]";
    }

    public static Role getRoleById(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getRoleById");
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.setParameter("idIN", id);
            spq.execute();

            List<Object[]> resultList = spq.getResultList();
            Role toReturn = new Role();

            for (Object[] record : resultList) {
                Role r = new Role(
                        Integer.valueOf(record[0].toString()),
                        record[1].toString(),
                        formatter.parse(record[2].toString()),
                        record[3] == null ? null : formatter.parse(record[3].toString()),
                        Boolean.valueOf(record[4].toString())
                );

                toReturn = r;
            }

            return toReturn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ArrayList<Role> getAllRole() {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllRole");
            spq.execute();

            List<Object[]> resultList = spq.getResultList();
            ArrayList<Role> toReturn = new ArrayList<Role>();

            for (Object[] record : resultList) {
                Role r = new Role(
                        Integer.valueOf(record[0].toString()),
                        record[1].toString(),
                        formatter.parse(record[2].toString()),
                        record[3] == null ? null : formatter.parse(record[3].toString()),
                        Boolean.valueOf(record[4].toString())
                );

                toReturn.add(r);
            }

            return toReturn;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean addRole(Role addedRole) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("addRole");
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);

            spq.setParameter("nameIN", addedRole.getName());
            spq.execute();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean deleteRole(Role theRole) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteRole");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.setParameter("idIN", theRole.getId());

            spq.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Boolean updateRole(Role theRole) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateRole");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);

            spq.setParameter("idIN", theRole.getId());
            spq.setParameter("nameIN", theRole.getName());

            spq.execute();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
