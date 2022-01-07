package com.ysa.admin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Matpel {
    private int id;
    private String namamatpel;
    private Guru guruByGuruId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namamatpel", nullable = false, length = 100)
    public String getNamamatpel() {
        return namamatpel;
    }

    public void setNamamatpel(String namamatpel) {
        this.namamatpel = namamatpel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matpel matpel = (Matpel) o;
        return id == matpel.id && Objects.equals(namamatpel, matpel.namamatpel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namamatpel);
    }

    @ManyToOne
    @JoinColumn(name = "guru_id", referencedColumnName = "id", nullable = false)
    public Guru getGuruByGuruId() {
        return guruByGuruId;
    }

    public void setGuruByGuruId(Guru guruByGuruId) {
        this.guruByGuruId = guruByGuruId;
    }

    @Override
    public String toString() {
        return  namamatpel +" "+ guruByGuruId;
    }
}
