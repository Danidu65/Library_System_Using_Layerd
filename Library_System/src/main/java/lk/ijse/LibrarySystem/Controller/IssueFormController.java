package lk.ijse.LibrarySystem.Controller;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import lk.ijse.LibrarySystem.tm.*;
import lk.ijse.LibrarySystem.dto.BookDTO;
import lk.ijse.LibrarySystem.dto.IssueDTO;
import lk.ijse.LibrarySystem.dto.MemberDTO;
import lombok.SneakyThrows;

import javax.mail.MessagingException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssueFormController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXComboBox<?> cmbSearchMember;

    @FXML
    private JFXComboBox<?> cmbSearchBook;

    @FXML
    private JFXTextField txtIssuesId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private Text memberName;

    @FXML
    private Text BookName;

    @FXML
    private Text memberEmail;

    @FXML
    private Text BookId;

    @FXML
    private TableView<IssueDTO> table;

    @FXML
    private TableColumn<IssueDTO,String> tblIssueId;

    @FXML
    private TableColumn<IssueDTO,String> tblMemberId;

    @FXML
    private TableColumn<IssueDTO,String> tblBookId;

    @FXML
    private TableColumn<IssueDTO,String> tblQty;

    @FXML
    private TableColumn<IssueDTO,String> tblIssuesDate;

    @FXML
    private TableColumn<IssueDTO,String> tblReturnDate;

    @FXML
    private DatePicker DueDate;


    @FXML
    void OnSelectBook(ActionEvent event) throws SQLException {
        BookDTO book = BookModel.Search((String) cmbSearchBook.getValue());
        BookName.setText(book.getName());
        BookId.setText(String.valueOf(book.getQty()));

       }

    @FXML
    void OnSelectMember(ActionEvent event) throws SQLException {
        MemberDTO member = MemberModel.Search((String)cmbSearchMember.getValue());
        memberName.setText(member.getName());
        memberEmail.setText(member.getEmail());
    }

    @FXML
    void onPlaceBook(ActionEvent event) throws SQLException, MessagingException {
        String IssuseID = txtIssuesId.getText();
        String memberID = String.valueOf(cmbSearchMember.getValue());
        String BookID = String.valueOf(cmbSearchBook.getValue());
        String Qty = txtQty.getText();
        String IssuseQty = txtQty.getText();
        String dueDate = String.valueOf(DueDate.getValue());

        IssueDTO issuse = new IssueDTO();

        issuse.setIssusId(IssuseID);
        issuse.setMemberId(memberID);
        issuse.setBookId(BookID);
        issuse.setIssuseQty(IssuseQty);
        issuse.setIssusDate(String.valueOf(LocalDate.now()));
        issuse.setDueDate(dueDate);

        System.out.println(Qty+" "+issuse.getIssusDate()+" "+issuse.getDueDate()+" "+issuse.getIssusId()+" "+issuse.getMemberId());

        boolean i1 = IssueModel.Issues(issuse,Qty,BookID);
        LoadTable();
        EmailModel.sendMail("librarys586@gmail.com" , "csaywdwsfqnjxjep" , memberEmail.getText(), "Hi "+memberName.getText()+" You'r Book is Issuse Sucses fully Completed \n"+"You'r IssuseId is : "+txtIssuesId.getText()+"\nBook Id : "+BookId.getText()+"\nDueDate is :"+DueDate.getValue()+"\nPlease return your book by the date we have notified. Otherwise, after that date, fines will be added.\n"+"Thank you...."+memberName.getText()+" for visiting our library.");

    }

    public void loadAllBookIds() throws SQLException {

        ArrayList<String> bookIds = BookModel.loadAllBookIds();

        ObservableList ids = FXCollections.observableArrayList();

        for(String id : bookIds){
            ids.add(id);
        }
        cmbSearchBook.setItems(ids);
    }

    public void loadAllMemberIds() throws SQLException {

        ArrayList <String> memberIds = MemberModel.loadAllMemberIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : memberIds){
            ids.add(id);
        }
        cmbSearchMember.setItems(ids);
    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ((TableColumn)this.table.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory("issusId"));
        ((TableColumn)this.table.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory("bookId"));
        ((TableColumn)this.table.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory("issusDate"));
        ((TableColumn)this.table.getColumns().get(3)).setCellValueFactory(new PropertyValueFactory("memberId"));
        ((TableColumn)this.table.getColumns().get(4)).setCellValueFactory(new PropertyValueFactory("dueDate"));
        ((TableColumn)this.table.getColumns().get(5)).setCellValueFactory(new PropertyValueFactory("issuseQty"));

        txtIssuesId.setEditable(false);
        LoadTable();
        setTurnId();

        try {
            loadAllBookIds();
            loadAllMemberIds();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void LoadTable() throws SQLException {
        ArrayList<IssueDTO> issue = IssueModel.loadAllIssuse();
        this.table.setItems(FXCollections.observableArrayList(issue));

    }

    private void setTurnId() {
        try {
            String newTurnId = IssueModel.genarateTurnId();
            txtIssuesId.setText(newTurnId);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
