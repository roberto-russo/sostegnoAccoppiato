package it.csi.demetra.demetraws.zoo.model;
/*
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.util.List;

@Entity
@Table(name = "AUTHORITIES", schema = "gagrea")
public class Dmt_t_Authority {

    @Id
    @Column(name = "ID")
    @GeneratedValue
    private Long id;

    @Column(name = "NAME", length = 50)
    @NotNull
    @Enumerated(EnumType.STRING)
    private Dmt_t_AuthorityName name;

    @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    @JsonBackReference
    private List<Dmt_t_User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Dmt_t_AuthorityName getName() {
        return name;
    }

    public void setName(Dmt_t_AuthorityName name) {
        this.name = name;
    }

    public List<Dmt_t_User> getUsers() {
        return users;
    }

    public void setUsers(List<Dmt_t_User> users) {
        this.users = users;
    }
}
*/