package com.ysa.admin.controller;

import com.ysa.admin.MainController;
import com.ysa.admin.entity.Kelas;
import com.ysa.admin.entity.SiswaHasKelas;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class KelasDetailController {
    public TableView<SiswaHasKelas> tablePageModal1;
    public TableColumn<SiswaHasKelas,String> Kolom1ModalPage1;
    public TableColumn<SiswaHasKelas,String> Kolom2ModalPage1;
    public TableColumn<SiswaHasKelas,String> Kolom3ModalPage1;

    private MainController mainController;

    public void setMainController(MainController mainController) {
        this.mainController = mainController;
        tablePageModal1.setItems(mainController.getSiswaHasKelasDao().kelasSiswa(mainController.getSelectedid()));
        System.out.println(mainController.getSiswaHasKelasDao().kelasSiswa(1));
//        Kolom1ModalPage1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getSiswaBySiswaId().getNamasiswa())));
//        Kolom2ModalPage1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getSiswaBySiswaId().getAlamat())));
//        Kolom3ModalPage1.setCellValueFactory(data->new SimpleStringProperty(String.valueOf(data.getValue().getSiswaBySiswaId().getNamaorangtua())));
    }
}
