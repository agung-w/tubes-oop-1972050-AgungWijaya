package com.ysa.admin.dao;

import com.ysa.admin.entity.Users;
import com.ysa.admin.util.HibernateUtil;
import javafx.collections.FXCollections;
import org.hibernate.Session;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UsersDao implements daoInterface<Users>{
    @Override
    public int addData(Users data) {
        return daoInterface.super.addData(data);
    }

    @Override
    public int delData(Users data) {
        return daoInterface.super.delData(data);
    }

    @Override
    public int updateData(Users data) {
        return daoInterface.super.updateData(data);
    }

    @Override
    public List<Users> showData() {
        Session session = HibernateUtil.getSession();
        CriteriaBuilder b=session.getCriteriaBuilder();
        CriteriaQuery<Users> criteriaQuery= b.createQuery(Users.class);
        criteriaQuery.from(Users.class);
        List<Users> list=session.createQuery(criteriaQuery).getResultList();
        session.close();
        return FXCollections.observableArrayList(list);
    }
}
