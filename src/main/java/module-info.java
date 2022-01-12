module com.ysa {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.persistence;
    requires java.sql;
    requires org.hibernate.orm.core;
    requires java.naming;
    requires jasperreports;
    requires com.jfoenix;
    requires mysql.connector.java;


    opens com.ysa.admin to javafx.fxml;
    exports com.ysa.admin;
    opens com.ysa.admin.controller to javafx.fxml;
    exports com.ysa.admin.entity;
}