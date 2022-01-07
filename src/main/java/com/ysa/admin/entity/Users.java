package com.ysa.admin.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Users {
    private int id;
    private String name;
    private String email;
    private Timestamp emailVerifiedAt;
    private String password;
    private String rememberToken;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private String fotoprofil;
    private Siswa siswaBySiswaId;
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
    @Column(name = "name", nullable = false, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email", nullable = false, length = 191)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "email_verified_at", nullable = true)
    public Timestamp getEmailVerifiedAt() {
        return emailVerifiedAt;
    }

    public void setEmailVerifiedAt(Timestamp emailVerifiedAt) {
        this.emailVerifiedAt = emailVerifiedAt;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 255)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "remember_token", nullable = true, length = 100)
    public String getRememberToken() {
        return rememberToken;
    }

    public void setRememberToken(String rememberToken) {
        this.rememberToken = rememberToken;
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
    @Column(name = "fotoprofil", nullable = true, length = 100)
    public String getFotoprofil() {
        return fotoprofil;
    }

    public void setFotoprofil(String fotoprofil) {
        this.fotoprofil = fotoprofil;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(id, users.id) && Objects.equals(name, users.name) && Objects.equals(email, users.email) && Objects.equals(emailVerifiedAt, users.emailVerifiedAt) && Objects.equals(password, users.password) && Objects.equals(rememberToken, users.rememberToken) && Objects.equals(createdAt, users.createdAt) && Objects.equals(updatedAt, users.updatedAt) && Objects.equals(fotoprofil, users.fotoprofil);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, emailVerifiedAt, password, rememberToken, createdAt, updatedAt, fotoprofil);
    }

    @ManyToOne
    @JoinColumn(name = "siswa_id", referencedColumnName = "id")
    public Siswa getSiswaBySiswaId() {
        return siswaBySiswaId;
    }

    public void setSiswaBySiswaId(Siswa siswaBySiswaId) {
        this.siswaBySiswaId = siswaBySiswaId;
    }

    @ManyToOne
    @JoinColumn(name = "guru_id", referencedColumnName = "id")
    public Guru getGuruByGuruId() {
        return guruByGuruId;
    }

    public void setGuruByGuruId(Guru guruByGuruId) {
        this.guruByGuruId = guruByGuruId;
    }
}
