package com.ysa.admin.dao;

import com.ysa.admin.entity.Kelas;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class KelasDao implements daoInterface<Kelas>{
    @Override
    public int addData(Kelas data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Kelas data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Kelas data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Kelas> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Kelas> criteriaQuery= b.createQuery(Kelas.class);
        criteriaQuery.from(Kelas.class);
        List<Kelas> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
