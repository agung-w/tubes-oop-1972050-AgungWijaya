package com.ysa.admin.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Kelasmatpel {
    private int id;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Matpel matpelByMatpelId;
    private Kelas kelasByKelasId;
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
    @Column(name = "created_at", nullable = true)
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    @Basic
    @Column(name = "updated_at", nullable = true)
    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kelasmatpel that = (Kelasmatpel) o;
        return id == that.id && Objects.equals(createdAt, that.createdAt) && Objects.equals(updatedAt, that.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createdAt, updatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "matpel_id", referencedColumnName = "id", nullable = false)
    public Matpel getMatpelByMatpelId() {
        return matpelByMatpelId;
    }

    public void setMatpelByMatpelId(Matpel matpelByMatpelId) {
        this.matpelByMatpelId = matpelByMatpelId;
    }

    @ManyToOne
    @JoinColumn(name = "kelas_id", referencedColumnName = "id", nullable = false)
    public Kelas getKelasByKelasId() {
        return kelasByKelasId;
    }

    public void setKelasByKelasId(Kelas kelasByKelasId) {
        this.kelasByKelasId = kelasByKelasId;
    }

    @ManyToOne
    @JoinColumn(name = "jadwal_id", referencedColumnName = "id", nullable = false)
    public Jadwal getJadwalByJadwalId() {
        return jadwalByJadwalId;
    }

    public void setJadwalByJadwalId(Jadwal jadwalByJadwalId) {
        this.jadwalByJadwalId = jadwalByJadwalId;
    }
}
