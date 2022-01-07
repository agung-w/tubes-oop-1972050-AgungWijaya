package com.ysa.admin.dao;

import com.ysa.admin.entity.Kelasmatpel;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.ParameterMode;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class KelasmatpelDao implements daoInterface<Kelasmatpel>{
    @Override
    public int addData(Kelasmatpel data) {
        int res=0;
        Session s=HibernateUtil.getSession();
        Transaction t=s.beginTransaction();
        try {
            res=s.createStoredProcedureQuery("storekelasmatpel").registerStoredProcedureParameter(1,Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2,Integer.class, ParameterMode.IN).registerStoredProcedureParameter(3,Integer.class,ParameterMode.IN)
                    .setParameter(1,data.getMatpelByMatpelId().getId())
                    .setParameter(2,data.getKelasByKelasId().getId())
                    .setParameter(3,data.getJadwalByJadwalId().getId())
                    .executeUpdate();
            t.commit();
        }catch (HibernateException e){
            t.rollback();
        }
        s.close();
        return res;
    }

    @Override
    public int delData(Kelasmatpel data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Kelasmatpel data) {
        int res=0;
        Session s=HibernateUtil.getSession();
        Transaction t=s.beginTransaction();
        try {
            res=s.createStoredProcedureQuery("updatekelasmatpel")
                    .registerStoredProcedureParameter(1,Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(2,Integer.class, ParameterMode.IN)
                    .registerStoredProcedureParameter(3,Integer.class,ParameterMode.IN)
                    .registerStoredProcedureParameter(4,Integer.class,ParameterMode.IN)
                    .setParameter(1,data.getId())
                    .setParameter(2,data.getMatpelByMatpelId().getId())
                    .setParameter(3,data.getKelasByKelasId().getId())
                    .setParameter(4,data.getJadwalByJadwalId().getId())
                    .executeUpdate();
            t.commit();
        }catch (HibernateException e){
            t.rollback();
        }
        s.close();
        return res;
    }

    @Override
    public List<Kelasmatpel> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Kelasmatpel> criteriaQuery= b.createQuery(Kelasmatpel.class);
        criteriaQuery.from(Kelasmatpel.class);
        List<Kelasmatpel> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
