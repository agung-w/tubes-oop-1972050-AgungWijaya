package com.ysa.admin.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Kelas {
    private int id;
    private String namakelas;
    private String tahunajaran;
    private String status;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private Guru guruByWkId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namakelas", nullable = false, length = 45)
    public String getNamakelas() {
        return namakelas;
    }

    public void setNamakelas(String namakelas) {
        this.namakelas = namakelas;
    }

    @Basic
    @Column(name = "tahunajaran", nullable = false, length = 45)
    public String getTahunajaran() {
        return tahunajaran;
    }

    public void setTahunajaran(String tahunajaran) {
        this.tahunajaran = tahunajaran;
    }

    @Basic
    @Column(name = "status", nullable = false, length = 45)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        Kelas kelas = (Kelas) o;
        return id == kelas.id && Objects.equals(namakelas, kelas.namakelas) && Objects.equals(tahunajaran, kelas.tahunajaran) && Objects.equals(status, kelas.status) && Objects.equals(createdAt, kelas.createdAt) && Objects.equals(updatedAt, kelas.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namakelas, tahunajaran, status, createdAt, updatedAt);
    }

    @ManyToOne
    @JoinColumn(name = "wk_id", referencedColumnName = "id", nullable = false)
    public Guru getGuruByWkId() {
        return guruByWkId;
    }

    public void setGuruByWkId(Guru guruByWkId) {
        this.guruByWkId = guruByWkId;
    }

    @Override
    public String toString() {
        return namakelas +" - "+ tahunajaran;
    }
}
