package com.ysa.admin.dao;

import com.ysa.admin.entity.Siswa;
import com.ysa.admin.entity.SiswaHasKelas;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SiswaHasKelasDao implements daoInterface<SiswaHasKelas>{
    @Override
    public int addData(SiswaHasKelas data) {
        int res=0;
        Session s=HibernateUtil.getSession();
        Transaction t=s.beginTransaction();
        try {
            res=s.createStoredProcedureQuery("storesiswakelas")
            .registerStoredProcedureParameter(1,Integer.class, ParameterMode.IN)
            .registerStoredProcedureParameter(2,Integer.class, ParameterMode.IN)
            .setParameter(1,data.getSiswaId())
            .setParameter(2,data.getKelasId()).executeUpdate();
            t.commit();
        }catch (HibernateException e){
            t.rollback();
        }
        s.close();
        return res;
    }

    @Override
    public int delData(SiswaHasKelas data) {
        int res=0;
        Session s=HibernateUtil.getSession();
        Transaction t=s.beginTransaction();
        try {
            res=s.createStoredProcedureQuery("deletesiswakelas")
                .registerStoredProcedureParameter(1,Integer.class, ParameterMode.IN)
                .registerStoredProcedureParameter(2,Integer.class, ParameterMode.IN)
                .setParameter(1,data.getSiswaId())
                .setParameter(2,data.getKelasId()).executeUpdate();
            t.commit();
        }catch (HibernateException e){
            t.rollback();
        }
        s.close();
        return res;
    }

    @Override
    public int updateData(SiswaHasKelas data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<SiswaHasKelas> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<SiswaHasKelas> criteriaQuery= b.createQuery(SiswaHasKelas.class);
        criteriaQuery.from(SiswaHasKelas.class);
        List<SiswaHasKelas> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
    public ObservableList kelasSiswa(int ids){
        Session s=HibernateUtil.getSession();
        List list=s.createStoredProcedureQuery("new_procedures").registerStoredProcedureParameter("id",Integer.class,ParameterMode.IN).setParameter("id",ids).
                getResultList();
        s.close();
        return FXCollections.observableArrayList(list);
    }
}
