package controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.LibrarySystem.Model.EmailModel;
import lk.ijse.LibrarySystem.Model.MemberModel;
import lk.ijse.LibrarySystem.util.Regx.Regx;
import lombok.SneakyThrows;

import javax.mail.MessagingException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import view.*;

public class MemberFormController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField searchMemberId;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtMemberName;

    @FXML
    private JFXTextField txtMemberAddress;

    @FXML
    private JFXTextField txtMemberContact;

    @FXML
    private JFXTextField txtMemberEmail;

    @FXML
    private JFXComboBox cmbGender;

    @FXML
    private TableView<lk.ijse.LibrarySystem.dto.MemberDTO> table;

    @FXML
    private TableColumn<lk.ijse.LibrarySystem.dto.MemberDTO, String> tblMemberId;

    @FXML
    private TableColumn<lk.ijse.LibrarySystem.dto.MemberDTO, String> tblMemberName;

    @FXML
    private TableColumn<lk.ijse.LibrarySystem.dto.MemberDTO, String> tblMemberAddress;

    @FXML
    private TableColumn<lk.ijse.LibrarySystem.dto.MemberDTO, String> tblMemberContact;

    @FXML
    private TableColumn<lk.ijse.LibrarySystem.dto.MemberDTO, String> tblMemberEmail;

    @FXML
    void txtMemberAddress(KeyEvent event) {
        Pattern compile = Regx.getAddressPattern();
        Matcher matcher = compile.matcher(txtMemberAddress.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtMemberAddress.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtMemberAddress.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void txtMemberContact(KeyEvent event) {
        Pattern compile = Regx.getMobilePattern();
        Matcher matcher = compile.matcher(txtMemberContact.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtMemberContact.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtMemberContact.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void txtMemberName(KeyEvent event) {
        Pattern compile = Regx.getNamePattern();
        Matcher matcher = compile.matcher(txtMemberName.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtMemberName.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtMemberName.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void txtMemberEmail(KeyEvent event) {
        Pattern compile= Regx.getEmailPattern();
        Matcher matcher=compile.matcher(txtMemberEmail.getText());
        boolean matches= matcher.matches();
        if (matches){
            txtMemberEmail.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtMemberEmail.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    @FXML
    void DELETE(ActionEvent event) throws SQLException {
        String memberID = searchMemberId.getText();
        boolean delete = MemberModel.Delete(memberID);
        loadTable();
    }

    @FXML
    void SAVE(ActionEvent event) throws SQLException, MessagingException {
        String memberIdText = this.txtMemberId.getText();
        String memberNameText = this.txtMemberName.getText();
        String memberAddressText = this.txtMemberAddress.getText();
        String memberContactText = this.txtMemberContact.getText();
        String memberEmail = this.txtMemberEmail.getText();
        String memberGender = this.cmbGender.getSelectionModel().getSelectedItem().toString();

        lk.ijse.LibrarySystem.dto.MemberDTO member = new lk.ijse.LibrarySystem.dto.MemberDTO();

        member.setId(memberIdText);
        member.setName(memberNameText);
        member.setAddress(memberAddressText);
        member.setContact(memberContactText);
        member.setEmail(memberEmail);
        member.setGender(memberGender);

        boolean members = MemberModel.save(member);
        loadTable();
        EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , txtMemberEmail.getText(), "Hi "+txtMemberName.getText()+" You'r Details added Completed.");

        txtMemberId.clear();
        txtMemberName.clear();
        txtMemberAddress.clear();
        txtMemberContact.clear();
        txtMemberEmail.clear();
    }

    @FXML
    void SEARCH(ActionEvent event) throws SQLException {
        String searchId = searchMemberId.getText();

        lk.ijse.LibrarySystem.dto.MemberDTO member = MemberModel.Search(searchId);

        txtMemberId.setText(member.getId());
        txtMemberName.setText(member.getName());
        txtMemberAddress.setText(member.getAddress());
        txtMemberContact.setText(member.getContact());
        txtMemberEmail.setText(member.getEmail());
        cmbGender.setId(member.getGender());
    }

    @FXML
    void UPDATE(ActionEvent event) throws SQLException {
        String Id = this.txtMemberId.getText();
        String Name = this.txtMemberName.getText();
        String Address = this.txtMemberAddress.getText();
        String Contact = this.txtMemberContact.getText();
        String Email = this.txtMemberEmail.getText();
        String Gender = (String) this.cmbGender.getValue();

        lk.ijse.LibrarySystem.dto.MemberDTO member = new lk.ijse.LibrarySystem.dto.MemberDTO();

        member.setId(Id);
        member.setName(Name);
        member.setAddress(Address);
        member.setContact(Contact);
        member.setEmail(Email);
        member.setGender(Gender);

        boolean member1 = MemberModel.Update(member);
        loadTable();

        txtMemberId.clear();
        txtMemberName.clear();
        txtMemberAddress.clear();
        txtMemberContact.clear();
        txtMemberEmail.clear();
    }
    @SneakyThrows
    public void initialize(URL location, ResourceBundle resources) {
        txtMemberId.setEditable(false);

        setTurnId();
        loadTable();

        ObservableList <String> list = FXCollections.observableArrayList("MALE" , "FEMALE" , "CUSTOM");
        cmbGender.setItems(list);

        ( (TableColumn) this.table.getColumns().get(0) ).setCellValueFactory(new PropertyValueFactory("id"));
        ( (TableColumn) this.table.getColumns().get(1) ).setCellValueFactory(new PropertyValueFactory("name"));
        ( (TableColumn) this.table.getColumns().get(2) ).setCellValueFactory(new PropertyValueFactory("address"));
        ( (TableColumn) this.table.getColumns().get(3) ).setCellValueFactory(new PropertyValueFactory("contact"));
        ( (TableColumn) this.table.getColumns().get(4) ).setCellValueFactory(new PropertyValueFactory("Email"));

    }
    private void setTurnId() {
        try {
            String newTurnId = MemberModel.genarateTurnId();
            txtMemberId.setText(newTurnId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void loadTable() throws SQLException {
        ArrayList<lk.ijse.LibrarySystem.dto.MemberDTO> members = MemberModel.LoadAllMembers();
        this.table.setItems(FXCollections.observableArrayList(members));
    }
}
