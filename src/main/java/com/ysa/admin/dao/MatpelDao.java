package com.ysa.admin.dao;

import com.ysa.admin.entity.Matpel;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class MatpelDao implements daoInterface<Matpel>{
    @Override
    public int addData(Matpel data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Matpel data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Matpel data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Matpel> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Matpel> criteriaQuery= b.createQuery(Matpel.class);
        criteriaQuery.from(Matpel.class);
        List<Matpel> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
