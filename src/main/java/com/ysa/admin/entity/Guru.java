package com.ysa.admin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Guru {
    private int id;
    private String namaguru;
    private String fotoprofil;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String jabatan;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namaguru", nullable = false, length = 100)
    public String getNamaguru() {
        return namaguru;
    }

    public void setNamaguru(String namaguru) {
        this.namaguru = namaguru;
    }

    @Basic
    @Column(name = "fotoprofil", nullable = true, length = 100)
    public String getFotoprofil() {
        return fotoprofil;
    }

    public void setFotoprofil(String fotoprofil) {
        this.fotoprofil = fotoprofil;
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

    @Basic
    @Column(name = "jabatan", nullable = true, length = 45)
    public String getJabatan() {
        return jabatan;
    }

    public void setJabatan(String jabatan) {
        this.jabatan = jabatan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guru guru = (Guru) o;
        return id == guru.id && Objects.equals(namaguru, guru.namaguru) && Objects.equals(fotoprofil, guru.fotoprofil) && Objects.equals(createdAt, guru.createdAt) && Objects.equals(updatedAt, guru.updatedAt) && Objects.equals(jabatan, guru.jabatan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namaguru, fotoprofil, createdAt, updatedAt, jabatan);
    }

    @Override
    public String toString() {
        return namaguru ;
    }
}
