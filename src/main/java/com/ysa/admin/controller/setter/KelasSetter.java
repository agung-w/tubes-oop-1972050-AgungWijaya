package com.ysa.admin.controller.setter;

import com.ysa.admin.entity.*;

import java.sql.Timestamp;

public class KelasSetter {
    public Kelasmatpel kmSetter(Matpel mid, Kelas kid, Jadwal jid){
        Kelasmatpel k=new Kelasmatpel();
        k.setKelasByKelasId(kid);
        k.setJadwalByJadwalId(jid);
        k.setMatpelByMatpelId(mid);
        k.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        k.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        return k;
    }
    public SiswaHasKelas shkSetter(String sid,String kid){
        SiswaHasKelas s=new SiswaHasKelas();
        s.setSiswaId(Integer.parseInt(sid));
        s.setKelasId(Integer.parseInt(kid));
        return s;
    }
}
