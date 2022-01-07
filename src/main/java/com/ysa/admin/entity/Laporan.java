package com.ysa.admin.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Laporan {
    private int id;
    private String asallaporan;
    private String keluhan;
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
    @Column(name = "asallaporan", nullable = false, length = 100)
    public String getAsallaporan() {
        return asallaporan;
    }

    public void setAsallaporan(String asallaporan) {
        this.asallaporan = asallaporan;
    }

    @Basic
    @Column(name = "keluhan", nullable = true, length = 300)
    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
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
        Laporan laporan = (Laporan) o;
        return id == laporan.id && Objects.equals(asallaporan, laporan.asallaporan) && Objects.equals(keluhan, laporan.keluhan) && Objects.equals(createdAt, laporan.createdAt) && Objects.equals(updatedAt, laporan.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, asallaporan, keluhan, createdAt, updatedAt);
    }
}
