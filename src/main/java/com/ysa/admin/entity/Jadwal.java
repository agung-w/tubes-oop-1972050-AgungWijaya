package com.ysa.admin.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Objects;

@Entity
public class Jadwal {
    private int id;
    private String namajadwal;
    private Collection<Jadwaldet> jadwaldetsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namajadwal", nullable = false, length = 45)
    public String getNamajadwal() {
        return namajadwal;
    }

    public void setNamajadwal(String namajadwal) {
        this.namajadwal = namajadwal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jadwal jadwal = (Jadwal) o;
        return id == jadwal.id && Objects.equals(namajadwal, jadwal.namajadwal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namajadwal);
    }

    @Override
    public String toString() {
        return  namajadwal;
    }

    @OneToMany(mappedBy = "jadwalByJadwalId" ,fetch = FetchType.EAGER,  cascade = CascadeType.ALL)
    public Collection<Jadwaldet> getJadwaldetsById() {
        return new LinkedHashSet<Jadwaldet>(jadwaldetsById);
    }

    public void setJadwaldetsById(Collection<Jadwaldet> jadwaldetsById) {
        this.jadwaldetsById = jadwaldetsById;
    }
}
