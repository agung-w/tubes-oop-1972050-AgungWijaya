package com.ysa.admin.dao;

import com.ysa.admin.entity.Jadwaldet;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JadwaldetDao implements daoInterface<Jadwaldet> {
    @Override
    public int addData(Jadwaldet data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Jadwaldet data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Jadwaldet data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Jadwaldet> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Jadwaldet> criteriaQuery= b.createQuery(Jadwaldet.class);
        criteriaQuery.from(Jadwaldet.class);
        List<Jadwaldet> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
