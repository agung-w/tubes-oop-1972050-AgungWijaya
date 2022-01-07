package com.ysa.admin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Siswa {
    private int id;
    private String namasiswa;
    private String alamat;
    private String namaorangtua;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "namasiswa", nullable = false, length = 100)
    public String getNamasiswa() {
        return namasiswa;
    }

    public void setNamasiswa(String namasiswa) {
        this.namasiswa = namasiswa;
    }

    @Basic
    @Column(name = "alamat", nullable = true, length = 100)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Basic
    @Column(name = "namaorangtua", nullable = true, length = 100)
    public String getNamaorangtua() {
        return namaorangtua;
    }

    public void setNamaorangtua(String namaorangtua) {
        this.namaorangtua = namaorangtua;
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
        Siswa siswa = (Siswa) o;
        return id == siswa.id && Objects.equals(namasiswa, siswa.namasiswa) && Objects.equals(alamat, siswa.alamat) && Objects.equals(namaorangtua, siswa.namaorangtua) && Objects.equals(createdAt, siswa.createdAt) && Objects.equals(updatedAt, siswa.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, namasiswa, alamat, namaorangtua, createdAt, updatedAt);
    }

    @Override
    public String toString() {
        return namasiswa;
    }
}
