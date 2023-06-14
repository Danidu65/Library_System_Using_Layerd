package lk.ijse.LibrarySystem.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.LibrarySystem.Model.*;
import lk.ijse.LibrarySystem.dto.IssueDTO;
import lk.ijse.LibrarySystem.dto.ReturnDTO;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ReturnFormController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtSearchIssuesId;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblIssuesDate;

    @FXML
    private JFXTextField txtReturnId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private TableView<ReturnDTO> table;

    @FXML
    private TableColumn<ReturnDTO,String> tblIssuesId;

    @FXML
    private TableColumn<ReturnDTO,String> tblReturnId;

    @FXML
    private TableColumn<ReturnDTO,String> tblBookId;

    @FXML
    private TableColumn<ReturnDTO,String> tblMemberId;

    @FXML
    private TableColumn<ReturnDTO,String> tblIssuesDate;

    @FXML
    private TableColumn<ReturnDTO,String> tblReturnDate;

    @FXML
    private TableColumn<ReturnDTO,String> tblQty;


    @FXML
    void onReturn(ActionEvent event) throws SQLException {
        String IssuseId = txtSearchIssuesId.getText();
        String BookQty = txtQty.getText();
        String ReturnId = txtReturnId.getText();
        String BookId = lblBookId.getText();
        String IssuseDate = lblIssuesDate.getText();

        ReturnDTO returns = new ReturnDTO();

        returns.setIssuseId(IssuseId);
        returns.setReturnDate(String.valueOf(LocalDate.now()));
        returns.setBookId(BookId);
        returns.setReturnId(ReturnId);
        returns.setRreturnQty(BookQty);
        returns.setIssuseId(IssuseDate);

        System.out.println(returns.getReturnId()+" "+returns.getReturnDate()+" "+returns.getIssuseId()+" "+returns.getRreturnQty());

        boolean R1 = ReturnModel.returnSet(returns,BookQty,BookId,IssuseId);
    }

    @FXML
    void search(ActionEvent event) throws SQLException {
        String searchId = txtSearchIssuesId.getText();

        IssueDTO issue = ReturnModel.Search(searchId);

        lblBookId.setText(issue.getMemberId());
        lblMemberId.setText(issue.getDueDate());
        lblIssuesDate.setText(issue.getIssusDate());

        System.out.println(lblBookId);
        System.out.println(lblMemberId);
    }

    private void setTurnId() {
        try {
            String newTurnId = ReturnModel.genarateTurnId();
            txtReturnId.setText(newTurnId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    @SneakyThrows
//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//

//    }



    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

//        table.getColumns().get(0) ).setCellValueFactory(new PropertyValueFactory("ReturnId"));
//        ( (TableColumn) this.table.getColumns().get(1) ).setCellValueFactory(new PropertyValueFactory("IssuseId"));
//        ( (TableColumn) this.table.getColumns().get(2) ).setCellValueFactory(new PropertyValueFactory("RreturnQty"));
//        ( (TableColumn) this.table.getColumns().get(3) ).setCellValueFactory(new PropertyValueFactory("ReturnDate"));
//        ( (TableColumn) this.table.getColumns().get(4) ).setCellValueFactory(new PropertyValueFactory("BookId"));
//        ( (TableColumn) this.table.getColumns().get(5) ).setCellValueFactory(new PropertyValueFactory("IssuseDate"));

        table.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("ReturnId"));
        table.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("IssuseId"));
        table.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("RreturnQty"));
        table.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("ReturnDate"));
        table.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("BookId"));
        table.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("IssuseDate"));

        txtReturnId.setEditable(false);
        LoadTable();
        setTurnId();

    }
    public void LoadTable() throws SQLException {
        ArrayList<ReturnDTO> returns = ReturnModel.loadAllReturns();
        this.table.setItems(FXCollections.observableArrayList(returns));
    }
}