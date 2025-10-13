package com.mycompany.mavenproject3.entity;

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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByFirstName", query = "SELECT u FROM User u WHERE u.firstName = :firstName"),
    @NamedQuery(name = "User.findByLastName", query = "SELECT u FROM User u WHERE u.lastName = :lastName"),
    @NamedQuery(name = "User.findByImg", query = "SELECT u FROM User u WHERE u.img = :img"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByAuthSecret", query = "SELECT u FROM User u WHERE u.authSecret = :authSecret"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findByGuid", query = "SELECT u FROM User u WHERE u.guid = :guid"),
    @NamedQuery(name = "User.findByCreatedAt", query = "SELECT u FROM User u WHERE u.createdAt = :createdAt"),
    @NamedQuery(name = "User.findByDeletedAt", query = "SELECT u FROM User u WHERE u.deletedAt = :deletedAt"),
    @NamedQuery(name = "User.findByIsDeleted", query = "SELECT u FROM User u WHERE u.isDeleted = :isDeleted"),
    @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "User.findByRegisterFinishedAt", query = "SELECT u FROM User u WHERE u.registerFinishedAt = :registerFinishedAt"),
    @NamedQuery(name = "User.findByRegToken", query = "SELECT u FROM User u WHERE u.regToken = :regToken")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "img")
    private String img;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Lob
    @Size(max = 16777215)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 16)
    @Column(name = "auth_secret")
    private String authSecret;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "phone")
    private String phone;
    @Size(max = 64)
    @Column(name = "guid")
    private String guid;
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
    @Column(name = "last_login")
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;
    @Column(name = "register_finished_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registerFinishedAt;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "reg_token")
    private String regToken;

    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_mavenproject3_war_1.0-SNAPSHOTPU");
    static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Transient
    private ArrayList<Role> roles = new ArrayList<>();

    public User() {
    }

    public User(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
            User user = em.find(User.class, id);
            this.id = user.getId();
            this.firstName = user.getFirstName();
            this.lastName = user.getLastName();
            this.img = user.getImg();
            this.email = user.getEmail();
            this.authSecret = user.getAuthSecret();
            this.phone = user.getPhone();
            this.createdAt = user.getCreatedAt();
            this.isDeleted = user.getIsDeleted();
            this.regToken = user.getRegToken();
            this.guid = user.getGuid();
            this.deletedAt = user.getDeletedAt();
            this.lastLogin = user.getLastLogin();
            this.registerFinishedAt = user.getRegisterFinishedAt();
            this.regToken = user.getRegToken();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public User(Integer id, String firstName, String lastName, String img, String email, String authSecret, String phone, Date createdAt, boolean isDeleted, String regToken) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.email = email;
        this.authSecret = authSecret;
        this.phone = phone;
        this.createdAt = createdAt;
        this.isDeleted = isDeleted;
        this.regToken = regToken;
    }

    public User(String firstName, String lastName, String email, String password, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    public User(String firstName, String lastName, String email, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public User(Integer id, String firstName, String lastName, String img, String email, String phone, String guid, Date createdAt, Date lastLogin, Date registerFinishedAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.email = email;
        this.phone = phone;
        this.guid = guid;
        this.createdAt = createdAt;
        this.lastLogin = lastLogin;
        this.registerFinishedAt = registerFinishedAt;
    }

    public User(Integer id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    //login request
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(Integer id, String firstName, String lastName, String img, String phone, Date lastLogin, ArrayList<Role> roles) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.img = img;
        this.phone = phone;
        this.lastLogin = lastLogin;
        this.roles = roles;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getAuthSecret() {
        return authSecret;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGuid() {
        return guid;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public boolean getIsDeleted() {
        return isDeleted;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getRegisterFinishedAt() {
        return registerFinishedAt;
    }

    public void setRegisterFinishedAt(Date registerFinishedAt) {
        this.registerFinishedAt = registerFinishedAt;
    }

    public String getRegToken() {
        return regToken;
    }

    public void setRegToken(String regToken) {
        this.regToken = regToken;
    }

    public ArrayList<Role> getRoles() {
        return roles;
    }

    public void setRoles(ArrayList<Role> roles) {
        this.roles = roles;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.mavenproject3.entity.User[ id=" + id + " ]";
    }

    //tarolt eljarasok
    public static Boolean registerUser(User registeredUser) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("registerUser");

            spq.registerStoredProcedureParameter("firstNameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastNameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);

            spq.setParameter("firstNameIN", registeredUser.getFirstName());
            spq.setParameter("lastNameIN", registeredUser.getLastName());
            spq.setParameter("emailIN", registeredUser.getEmail());
            spq.setParameter("passwordIN", registeredUser.getPassword());
            spq.setParameter("phoneIN", registeredUser.getPhone());

            spq.execute();

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static Boolean updateUer(User theUser) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUser");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("firstNameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("lastNameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);

            spq.setParameter("idIN", theUser.getId());
            spq.setParameter("firstNameIN", theUser.getFirstName());
            spq.setParameter("lastNameIN", theUser.getLastName());
            spq.setParameter("emailIN", theUser.getEmail());
            spq.setParameter("phoneIN", theUser.getPhone());

            spq.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static ArrayList<User> getAllUser() {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getAllUser");
            spq.execute();

            List<Object[]> resultList = spq.getResultList();
            ArrayList<User> toReturn = new ArrayList<User>();

            for (Object[] record : resultList) {
                User u = new User(
                        Integer.valueOf(record[0].toString()), //id
                        record[1].toString(), //first
                        record[2].toString(), //last
                        record[3].toString(), //img
                        record[4].toString(), //email
                        record[5].toString(), //phone
                        record[6].toString(), //guid
                        formatter.parse(record[7].toString()),
                        record[8] == null ? null : formatter.parse(record[8].toString()),
                        record[9] == null ? null : formatter.parse(record[9].toString())
                );

                toReturn.add(u);
            }

            return toReturn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Boolean deleteUser(User theUser) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteUser");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.setParameter("idIN", theUser.getId());

            spq.execute();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public static User getUserById(Integer id) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("getUserById");

            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.setParameter("idIN", id);
            spq.execute();

            List<Object[]> resultList = spq.getResultList();
            User toReturn = new User();
            for (Object[] record : resultList) {
                User u = new User(
                        Integer.valueOf(record[0].toString()), //id
                        record[1].toString(), //first
                        record[2].toString(), //last
                        record[3].toString(), //img
                        record[4].toString(), //email
                        record[5].toString(), //phone
                        record[6].toString(), //guid
                        formatter.parse(record[7].toString()), //createdAt
                        record[8] == null ? null : formatter.parse(record[8].toString()), //lastLogin
                        record[9] == null ? null : formatter.parse(record[9].toString()) //registerFinishedAt
                );

                toReturn = u;
            }

            return toReturn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static User login(User u2) {
        EntityManager em = emf.createEntityManager();

        try {
            StoredProcedureQuery loginQuery = em.createStoredProcedureQuery("login");

            loginQuery.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            loginQuery.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);

            loginQuery.setParameter("emailIN", u2.getEmail());
            loginQuery.setParameter("passwordIN", u2.getPassword());

            loginQuery.execute();

            List<Object[]> resultList = loginQuery.getResultList();
            User toReturn = new User();
            for (Object[] record : resultList) {
                User u = new User(
                        Integer.valueOf(record[0].toString()), //id
                        record[1].toString(), //first
                        record[2].toString(), //last
                        record[3].toString(), //img
                        record[4].toString(), //email
                        record[5] == null ? null : formatter.parse(record[5].toString()),
                        null
                );

                toReturn = u;
            }

            //
            StoredProcedureQuery userRolesQuery = em.createStoredProcedureQuery("getUserRoles");
            userRolesQuery.registerStoredProcedureParameter("userIdIN", Integer.class, ParameterMode.IN);
            userRolesQuery.setParameter("userIdIN", toReturn.getId());
            userRolesQuery.execute();

            List<Object> userRolesResultList = userRolesQuery.getResultList();
            ArrayList<Role> userRoles = new ArrayList<>();

            for (Object[] record : resultList) {
                Role r = new Role(
                        Integer.valueOf(record[0].toString()), //id
                        record[1].toString()
                );
                userRoles.add(r);
            }
            toReturn.setRoles(userRoles);

            return toReturn;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
