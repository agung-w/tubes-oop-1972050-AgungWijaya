package com.ysa.admin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Jadwaldet {
    private int id;
    private String hari;
    private String jammulai;
    private String jamselesai;
    private Jadwal jadwalByJadwalId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "hari", nullable = true, length = 45)
    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    @Basic
    @Column(name = "jammulai", nullable = true, length = 45)
    public String getJammulai() {
        return jammulai;
    }

    public void setJammulai(String jammulai) {
        this.jammulai = jammulai;
    }

    @Basic
    @Column(name = "jamselesai", nullable = true, length = 45)
    public String getJamselesai() {
        return jamselesai;
    }

    public void setJamselesai(String jamselesai) {
        this.jamselesai = jamselesai;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jadwaldet jadwaldet = (Jadwaldet) o;
        return id == jadwaldet.id && Objects.equals(hari, jadwaldet.hari) && Objects.equals(jammulai, jadwaldet.jammulai) && Objects.equals(jamselesai, jadwaldet.jamselesai);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, hari, jammulai, jamselesai);
    }

    @ManyToOne
    @JoinColumn(name = "jadwal_id", referencedColumnName = "id", nullable = false)
    public Jadwal getJadwalByJadwalId() {
        return jadwalByJadwalId;
    }

    public void setJadwalByJadwalId(Jadwal jadwalByJadwalId) {
        this.jadwalByJadwalId = jadwalByJadwalId;
    }

    @Override
    public String toString() {
        if (hari.isEmpty()){
            return "belum di assign";
        }
        return  hari + '-' +
                 jammulai + ':' +
                 jamselesai ;
    }
}
