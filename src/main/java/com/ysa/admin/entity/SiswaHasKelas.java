package com.ysa.admin.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "siswa_has_kelas", schema = "sekolah_db", catalog = "")
@IdClass(SiswaHasKelasPK.class)
public class SiswaHasKelas {
    private int siswaId;
    private int kelasId;
    private Siswa siswaBySiswaId;
    private Kelas kelasByKelasId;

    @Id
    @Column(name = "siswa_id", nullable = false)
    public int getSiswaId() {
        return siswaId;
    }

    public void setSiswaId(int siswaId) {
        this.siswaId = siswaId;
    }

    @Id
    @Column(name = "kelas_id", nullable = false)
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
        SiswaHasKelas that = (SiswaHasKelas) o;
        return siswaId == that.siswaId && kelasId == that.kelasId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(siswaId, kelasId);
    }

    @ManyToOne
    @JoinColumn(name = "siswa_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public Siswa getSiswaBySiswaId() {
        return siswaBySiswaId;
    }

    public void setSiswaBySiswaId(Siswa siswaBySiswaId) {
        this.siswaBySiswaId = siswaBySiswaId;
    }

    @ManyToOne
    @JoinColumn(name = "kelas_id", referencedColumnName = "id", nullable = false,insertable = false,updatable = false)
    public Kelas getKelasByKelasId() {
        return kelasByKelasId;
    }

    public void setKelasByKelasId(Kelas kelasByKelasId) {
        this.kelasByKelasId = kelasByKelasId;
    }
}
