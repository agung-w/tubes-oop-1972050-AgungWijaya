package com.ysa.admin.dao;

import com.ysa.admin.entity.Guru;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GuruDao implements daoInterface<Guru>{
    @Override
    public int addData(Guru data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Guru data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Guru data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Guru> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Guru> criteriaQuery= b.createQuery(Guru.class);
        criteriaQuery.from(Guru.class);
        List<Guru> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
