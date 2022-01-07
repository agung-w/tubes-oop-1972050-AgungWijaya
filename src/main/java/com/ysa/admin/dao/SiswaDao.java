package com.ysa.admin.dao;

import com.ysa.admin.entity.Siswa;
import com.ysa.admin.entity.Users;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class SiswaDao implements daoInterface<Siswa>{
    @Override
    public int addData(Siswa data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Siswa data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Siswa data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Siswa> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Siswa> criteriaQuery= b.createQuery(Siswa.class);
        criteriaQuery.from(Siswa.class);
        List<Siswa> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
