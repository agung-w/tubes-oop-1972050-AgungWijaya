package com.ysa.admin.controller;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import com.ysa.admin.controller.tools.YSAalert;
import com.ysa.admin.dao.*;
import com.ysa.admin.entity.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainController {
    /**
     * ===================================TOOLS=======================================
     */
    private final YSAalert ysa=new YSAalert();

    /**
     * ===================================TOOLS=======================================
     */
    private Stage new_stage = new Stage();
    public void initialize(){

    }
    /**
     * ===================================ON ACTIONS=======================================
     */
    @FXML
    private void toggle(){
        if(btnToggle.isSelected()){
            btnToggle.setText("INA");
        }else{
            btnToggle.setText("ENG");
        }
    }

    @FXML
    void shwHome(MouseEvent event) {
        judulBesar.setText("Tugas Besar PBO 2");
        pnlstatus.setBackground(new Background(new BackgroundFill(Color.rgb(101,	112,	94), CornerRadii.EMPTY, Insets.EMPTY)));
        Home.toFront();
        tableMain.setVisible(false);
        creditPage.setVisible(false);
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        paneStart.setVisible(false);
    }
    @FXML
    private void addSiswaKelas(){
        SiswaHasKelas x=new SiswaHasKelas();
        Siswa s=(Siswa) tableMain.getSelectionModel().getSelectedItem();
        Kelas k= comboBoxKelas.getSelectionModel().getSelectedItem();
        x.setSiswaId(s.getId());
        x.setKelasId(k.getId());
        if(siswaHasKelasDao.addData(x)==1){
            ysa.showAlertInf("Penambahan berhasil","Success");
            setTableToKelasJadwal();
            refreshData();
        }else{
            ysa.showAlertErr("Gagal Menambahkan data");
            setTableToKelasJadwal();
        }
        comboBoxKelas1.getSelectionModel().select(1);
    }
    @FXML
    private void addKelasJadwal(){
        Kelasmatpel x=new Kelasmatpel();
        x.setKelasByKelasId(comboBoxKelas.getSelectionModel().getSelectedItem());
        x.setMatpelByMatpelId(comboBoxMataPelajaran.getSelectionModel().getSelectedItem());
        x.setJadwalByJadwalId(comboBoxJadwal.getSelectionModel().getSelectedItem());
        if(kelasmatpelDao.addData(x)==1){
            ysa.showAlertInf("Penambahan berhasil","Success");
            setTableToKelasJadwal();
            refreshData();
        }else{
            ysa.showAlertErr("Gagal Menambahkan data");
            setTableToKelasJadwal();
        }
        comboBoxKelas.requestFocus();
    }
    @FXML
    private void updateKelasJadwal(){
        Kelasmatpel x=new Kelasmatpel();
        x.setKelasByKelasId(comboBoxKelas.getSelectionModel().getSelectedItem());
        x.setMatpelByMatpelId(comboBoxMataPelajaran.getSelectionModel().getSelectedItem());
        x.setJadwalByJadwalId(comboBoxJadwal.getSelectionModel().getSelectedItem());
        if(kelasmatpelDao.updateData(x)==1){
            ysa.showAlertInf("Update berhasil","Berhasil");
            setTableToKelasJadwal();
            refreshData();
        }
    }
    @FXML
    void shwClose(ActionEvent event) {
        Home.getScene().getWindow().hide();
    }

    @FXML
    void shwbtn1(ActionEvent event) {

    }
    /**
     * ===================================ON ACTIONS=======================================
     */

    /**
     * ===================================LISTENER=======================================
     */
    @FXML
    private void comboDetail(){
        tableMain.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observableValue, Object o, Object t1) {
                if (tableMain != null){
                    if(tableMain.getSelectionModel().getSelectedItem()!=null){
                        if (tableMain.getSelectionModel().getSelectedItem().getClass().getName().equals("com.ysa.admin.entity.Jadwal")) {
                            comboBoxJadwal.getSelectionModel().select((Jadwal) tableMain.getSelectionModel().getSelectedItem());
                        }else if(tableMain.getSelectionModel().getSelectedItem().getClass().getName().equals("com.ysa.admin.entity.Siswa")) {
                            Siswa s=(Siswa) tableMain.getSelectionModel().getSelectedItem();
                            txtNamaSiswa.setText(s.getNamasiswa());
                        }else if (tableMain.getSelectionModel().getSelectedItem().getClass().getName().equals("com.ysa.admin.entity.Kelas")) {
                            comboBoxKelas1.getSelectionModel().select((Kelas) tableMain.getSelectionModel().getSelectedItem());
                        }
                    }
                }
            }
        });
        if(comboBoxJadwal.isFocused()){
            setTableToJadwal();
        }else if (comboBoxKelas1.isFocused()){
            setTableToKelas();
        }else if(txtNamaSiswa.isFocused()){
            setTableToSiswa();
        }
    }
    @FXML
    void paneTabChange(Event event){
        if (pane1Tab1.isSelected()){
            setTableToKelasJadwal();
            comboBoxMataPelajaran.setItems(matpelList);
            comboBoxKelas.setItems(kelasList);
            comboBoxJadwal.setItems(jadwalList);
        }else if (pane1Tab2.isSelected()){
            setTableToKelas();
            comboBoxKelas1.setItems(kelasList);
        }else if (pane1Tab3.isSelected()){
            setTableToKelas();
        }else if (pane2Tab1.isSelected()){
            setTableToKelas();
        }else if (pane2Tab2.isSelected()){
            setTableToKelas();
        }else if (pane3Tab1.isSelected()){
            setTableToKelas();
        }else if (pane3Tab2.isSelected()){
            setTableToKelas();
        }
    }
    @FXML
    void changePage(ActionEvent event) {
        pane1.setVisible(false);
        pane2.setVisible(false);
        pane3.setVisible(false);
        paneStart.setVisible(false);
        creditPage.setVisible(false);
        if(event.getSource() == btnTulisan1){
            judulBesar.setText("Administrasi Kelas");
            pnlstatus.setBackground(new Background(new BackgroundFill(Color.rgb(134, 186, 148), CornerRadii.EMPTY, Insets.EMPTY)));
            pane1.setVisible(true);
            pane1.getSelectionModel().select(0);
            setTableToKelasJadwal();
        }else if(event.getSource() == btnTulisan2) {
            judulBesar.setText("Panel Guru");
            pnlstatus.setBackground(new Background(new BackgroundFill(Color.rgb(134, 186, 179), CornerRadii.EMPTY, Insets.EMPTY)));
            pane2.setVisible(true);

        }else if(event.getSource() == btnTulisan3){
            resetTable();
            judulBesar.setText("Panel Siswa");
            pnlstatus.setBackground(new Background(new BackgroundFill(Color.rgb(153, 186, 134), CornerRadii.EMPTY, Insets.EMPTY)));
            pane3.setVisible(true);
        }else{
            judulBesar.setText("Credit");
            pnlstatus.setBackground(new Background(new BackgroundFill(Color.rgb(101,	112,	94), CornerRadii.EMPTY, Insets.EMPTY)));
            creditPage.setVisible(true);
            tableMain.setVisible(false);
        }
    }

    /**
     * ===================================LISTENER=======================================
     */





    /**
     * ================================Table Controllers===================================
     */
    private void refreshData(){
        Alert loading = ysa.showLoading();
        loading.show();
        Task<Void> task=new Task<Void>(){
            @Override
            protected Void call() {
                jadwalList.clear();jadwalList.addAll(jadwalDao.showData());
                guruList.clear();guruList.addAll(guruDao.showData());
                kelasList.clear();kelasList.addAll(kelasDao.showData());
                matpelList.clear();matpelList.addAll(matpelDao.showData());
                siswaList.clear();siswaList.addAll(siswaDao.showData());
                siswaHasKelasList.clear();siswaHasKelasList.addAll(siswaHasKelasDao.showData());
                jadwalList.clear();jadwalList.addAll(jadwalDao.showData());
                usersList.clear();usersList.addAll(usersDao.showData());
                kelasmatpelList.clear();kelasmatpelList.addAll(kelasmatpelDao.showData());
                return null;
            }
        };
        ExecutorService exService= Executors.newCachedThreadPool();
        exService.execute(task);
        exService.shutdown();
        boolean isFinished= false;
        try {
            isFinished = exService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (isFinished){
            loading.close();
        }

    }
    private void resetTable(){
        tableMain.setItems(null);
        column1.setCellValueFactory(null);column2.setCellValueFactory(null);column3.setCellValueFactory(null);column4.setCellValueFactory(null);column5.setCellValueFactory(null);
        column1.setPrefWidth(100.0);column2.setPrefWidth(150.0);column3.setPrefWidth(100);column4.setPrefWidth(150);column5.setPrefWidth(100);
        column1.setText("");column2.setText("");column3.setText("");column4.setText("");column5.setText("");
    }
    private void setTableToKelas(){
        resetTable();tableMain.setVisible(true);tableMain.setItems(kelasList);
        column1.setText("No");column2.setText("Kelas");column3.setText("Tahun Ajaran");column4.setText("Wali Kelas");column5.setText("Status");
        column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Namakelas"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Tahunajaran"));
        column4.setCellValueFactory(new PropertyValueFactory<>("GuruByWkId"));
        column5.setCellValueFactory(new PropertyValueFactory<>("Status"));
    }
    private void setTableToUsers(){
        resetTable();tableMain.setVisible(true);tableMain.setItems(usersList);
        column1.setText("ID");column2.setText("Nama Lengkap");column3.setText("Email");column4.setText("ID Guru");
        column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Name"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Email"));
        column4.setCellValueFactory(new PropertyValueFactory<>("guruByGuruId"));
    }
    private void setTableToGuru(){
        resetTable();tableMain.setVisible(true);tableMain.setItems(guruList);
        column1.setText("ID Guru");column2.setText("");column3.setText("Nama Guru");column4.setText("Jabatan");
        column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Fotoprofil"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Namaguru"));
        column4.setCellValueFactory(new PropertyValueFactory<>("Jabatan"));
    }
    private void setTableToSiswa(){
        resetTable();tableMain.setVisible(true);tableMain.setItems(siswaList);
        column1.setText("NISN");column2.setText("Nama Siswa");column3.setText("Alamat");column4.setText("Nama Orang Tua");
        column1.setCellValueFactory(new PropertyValueFactory<>("Id"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Namasiswa"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Alamat"));
        column4.setCellValueFactory(new PropertyValueFactory<>("Namaorangtua"));
    }
    private void setTableToJadwalDet(){
        resetTable();
        tableMain.setVisible(true);
        column1.setText("Kode Jadwal");column2.setText("Hari");column3.setText("Jam Mulai");column4.setText("Jam Selesai");
        tableMain.setItems(jadwaldetList);
        column1.setCellValueFactory(new PropertyValueFactory<>("JadwalByJadwalId"));
        column2.setCellValueFactory(new PropertyValueFactory<>("Hari"));
        column3.setCellValueFactory(new PropertyValueFactory<>("Jammulai"));
        column4.setCellValueFactory(new PropertyValueFactory<>("Jamselesai"));
    }
    private void setTableToJadwal(){
        resetTable();
        tableMain.setVisible(true);
        column1.setText("Kode Jadwal");column2.setText("Jadwal");column2.setPrefWidth(500);
        tableMain.setItems(jadwalList);
        column1.setCellValueFactory(new PropertyValueFactory<>("Namajadwal"));
        column2.setCellValueFactory(new PropertyValueFactory<>("JadwaldetsById"));
    }
    private void setTableToKelasJadwal(){
        resetTable();
        tableMain.setVisible(true);tableMain.setItems(kelasmatpelList);
        column1.setText("Kelas");column2.setText("Mata Pelajaran");column3.setText("Jadwal");
        column1.setCellValueFactory(new PropertyValueFactory<>("KelasByKelasId"));
        column2.setCellValueFactory(new PropertyValueFactory<>("MatpelByMatpelId"));
        column3.setCellValueFactory(new PropertyValueFactory<>("JadwalByJadwalId"));

    }
    /**
     *===========================================================================
     */


    /**
     * Deklarasi variable dao
     */
    private final GuruDao guruDao=new GuruDao();
    private final JadwalDao jadwalDao=new JadwalDao();
    private final JadwaldetDao jadwaldetDao=new JadwaldetDao();
    private final KelasDao kelasDao=new KelasDao();
    private final KelasmatpelDao kelasmatpelDao=new KelasmatpelDao();
    private final MatpelDao matpelDao=new MatpelDao();
    private final SiswaDao siswaDao=new SiswaDao();
    private final SiswaHasKelasDao siswaHasKelasDao=new SiswaHasKelasDao();
    private final UsersDao usersDao=new UsersDao();
    /**
     * ************************
     */
    /**
     * variable penampung data
     */
    private final ObservableList<Jadwal>jadwalList= (ObservableList<Jadwal>) jadwalDao.showData();
    private final ObservableList<Guru>guruList= (ObservableList<Guru>) guruDao.showData();
    private final ObservableList<Kelas>kelasList= (ObservableList<Kelas>) kelasDao.showData();
    private final ObservableList<Matpel> matpelList=(ObservableList<Matpel>) matpelDao.showData();
    private final ObservableList<Siswa> siswaList=(ObservableList<Siswa>) siswaDao.showData();
    private final ObservableList<SiswaHasKelas> siswaHasKelasList=(ObservableList<SiswaHasKelas>) siswaHasKelasDao.showData();
    private final ObservableList<Jadwaldet> jadwaldetList=(ObservableList<Jadwaldet>) jadwaldetDao.showData();
    private final ObservableList<Users> usersList=(ObservableList<Users>) usersDao.showData();

    public ObservableList<Kelasmatpel> getKelasmatpelList() {
        return kelasmatpelList;
    }

    private final ObservableList<Kelasmatpel> kelasmatpelList=(ObservableList<Kelasmatpel>) kelasmatpelDao.showData();
    public ObservableList<Users> getUsersList() {
        return usersList;
    }


    public ObservableList<Jadwal> getJadwalList() {
        return jadwalList;
    }

    public ObservableList<Guru> getGuruList() {
        return guruList;
    }

    public ObservableList<Kelas> getKelasList() {
        return kelasList;
    }

    public ObservableList<Matpel> getMatpelList() {
        return matpelList;
    }

    public ObservableList<Siswa> getSiswaList() {
        return siswaList;
    }

    public ObservableList<SiswaHasKelas> getSiswaHasKelasList() {
        return siswaHasKelasList;
    }

    public ObservableList<Jadwaldet> getJadwaldetList() {
        return jadwaldetList;
    }

    /**
     *
     */
    /**
     * FXML
     */

    @FXML
    private Label Home;
    @FXML
    private Button btn1TahunAjaran;

    @FXML
    private Button btn2TahunAjaran;

    @FXML
    private Button btnAddInputGuru;

    @FXML
    private Button btnAddInputMataPelajaranBaru;

    @FXML
    private Button btnAddInputSiswa;

    @FXML
    private Button btnAddMasukkanSiswa;

    @FXML
    private Button btnAddPendaftaranJadwal;

    @FXML
    private Button btnCetakFormulirInputSiswa;

    @FXML
    private Button btnClose;

    @FXML
    private Button btnCredit;

    @FXML
    private Button btnDeleteInputGuru;

    @FXML
    private Button btnDeleteInputSiswa;

    @FXML
    private Button btnDeleteMasukkanSiswa;

    @FXML
    private Button btnEditInputGuru;

    @FXML
    private Button btnEditInputMataPelajaranBaru;

    @FXML
    private Button btnEditInputSiswa;

    @FXML
    private Button btnEditPendaftaranJadwal;

    @FXML
    private Button btnInputFormulirInputSiswa;

    @FXML
    private Button btnResetPendaftaranJadwal;

    @FXML
    private JFXToggleButton btnToggle;

    @FXML
    private Button btnTulisan1;

    @FXML
    private Button btnTulisan2;

    @FXML
    private Button btnTulisan3;
    @FXML
    private TableColumn<?, ?> column1=new TableColumn<>();
    @FXML
    private TableColumn<?, ?> column2=new TableColumn<>();
    @FXML
    private TableColumn<?, ?> column3=new TableColumn<>();
    @FXML
    private TableColumn<?, ?> column4=new TableColumn<>();
    @FXML
    private TableColumn<?, ?> column5=new TableColumn<>();

    @FXML
    private Label judulBesar;
    @FXML
    private TabPane pane1;
    @FXML
    private Tab pane1Tab1;
    @FXML
    private Tab pane1Tab2;
    @FXML
    private Tab pane1Tab3;
    @FXML
    private TabPane pane2;
    @FXML
    private StackPane stackPane;
    @FXML
    private Tab pane2Tab1;
    @FXML
    private Pane paneStart;
    @FXML
    private Tab pane2Tab2;
    @FXML
    private TabPane pane3;

    @FXML
    private Tab pane3Tab1;
    @FXML
    private Tab pane3Tab2;
    @FXML
    private Pane pnlmain;
    @FXML
    private Pane pnlstatus;
    @FXML
    private TableView tableMain=new TableView();
    @FXML
    private TextField txtAlamatDetil;
    @FXML
    private TextField txtAlamatInputSiswa;
    @FXML
    private TextField txtEmailInputGuru;
    @FXML
    private TextField txtJabatanInputGuru;
    @FXML
    private TextField txtMataPelajaranInputMataPelajaranBaru;
    @FXML
    private TextField txtNamaDetil;
    @FXML
    private TextField txtNamaGuruInputGuru;
    @FXML
    private TextField txtNamaGuruInputMataPelajaranBaru;
    @FXML
    private TextField txtNamaInputSiswa;
    @FXML
    private TextField txtNamaOrangtuaInputSiswa;
    @FXML
    private TextField txtNamaOrantuaDetil;
    @FXML
    private JFXComboBox<Jadwal> comboBoxJadwal;

    @FXML
    private JFXComboBox<Kelas> comboBoxKelas;

    @FXML
    private JFXComboBox<Matpel> comboBoxMataPelajaran;

    @FXML
    private JFXComboBox<?> cmbMasukkanSiswaKeKelas;

    @FXML
    private JFXComboBox<?> cmbToolKelas;
    @FXML
    private TextField txtNamaSiswa;
    @FXML
    private TextField txtPasswordInputGuru;
    @FXML
    private TextField txtTahunAjaran;
    @FXML
    private Pane creditPage;
    @FXML
    private ComboBox<Kelas> comboBoxKelas1;
    /**
     *
     */
}