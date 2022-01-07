package com.ysa.admin.dao;

import com.ysa.admin.entity.Jadwal;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class JadwalDao implements daoInterface<Jadwal>{
    @Override
    public int addData(Jadwal data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Jadwal data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Jadwal data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Jadwal> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Jadwal> criteriaQuery= b.createQuery(Jadwal.class);
        criteriaQuery.from(Jadwal.class);
        List<Jadwal> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
