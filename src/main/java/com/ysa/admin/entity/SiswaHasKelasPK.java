package com.ysa.admin.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class SiswaHasKelasPK implements Serializable {
    private int siswaId;
    private int kelasId;

    @Column(name = "siswa_id", nullable = false)
    @Id
    public int getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(int siswaId) {
        this.siswaId = siswaId;
    }

    @Column(name = "kelas_id", nullable = false)
    @Id
    public int getKelasId() {
        return kelasId;
    }

    public void setKelasId(int kelasId) {
        this.kelasId = kelasId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SiswaHasKelasPK that = (SiswaHasKelasPK) o;
        return siswaId == that.siswaId && kelasId == that.kelasId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(siswaId, kelasId);
    }
}
