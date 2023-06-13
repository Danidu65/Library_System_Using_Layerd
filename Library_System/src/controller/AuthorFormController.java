package controller;

import bo.BOFactory;
import bo.custom.AuthorBO;
import com.jfoenix.controls.JFXTextField;
import com.mysql.cj.x.protobuf.MysqlxDatatypes;
import dto.AuthorDTO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.LibrarySystem.Model.AuthorModel;
import lk.ijse.LibrarySystem.Model.BookModel;
import lk.ijse.LibrarySystem.Model.IssueModel;
import lk.ijse.LibrarySystem.Model.MemberModel;
import lk.ijse.LibrarySystem.dto.Author;
import lk.ijse.LibrarySystem.dto.Book;
import lk.ijse.LibrarySystem.util.Regx.Regx;
import lombok.SneakyThrows;

import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AuthorFormController implements Initializable {
    @FXML
    private AnchorPane root;


    @FXML
    private JFXTextField txtSearchAuthor;

    @FXML
    private JFXTextField txtAuthorId;

    @FXML
    private JFXTextField txtAuthorName;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private TableView<AuthorDTO> table;

    @FXML
    private TableColumn<AuthorDTO,String> tblAuthorId;

    @FXML
    private TableColumn<AuthorDTO,String> tblAuthorName;

    @FXML
    private TableColumn<AuthorDTO,String> tblBookName;

    AuthorBO authorBO;

    {
        try {
            authorBO = (AuthorBO) BOFactory.getBOFactory().getBO(BOFactory.BOTypes.AUTHOR);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void delete(ActionEvent event) throws SQLException {
        String searchId = txtSearchAuthor.getText();
        try {
            boolean delete = authorBO.deleteAuthor(searchId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        LoadTable();

        txtAuthorId.clear();
        txtAuthorName.clear();
        txtBookName.clear();
    }

    @FXML
    void save(ActionEvent event) throws SQLException {
        String authorId = txtAuthorId.getText();
        String name = txtAuthorName.getText();
        String bookName = txtBookName.getText();

        AuthorDTO author = new AuthorDTO();

        author.setId(authorId);
        author.setName(name);
        author.setBookName(bookName);

        try {
            boolean authors = authorBO.addAuthor(author);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        LoadTable();

        txtAuthorId.clear();
        txtAuthorName.clear();
        txtBookName.clear();
    }

    @FXML
    void search(ActionEvent event) throws SQLException {
        String searchId = txtSearchAuthor.getText();

        AuthorDTO author = null;
        try {
            author = authorBO.searchAuthor(searchId);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        txtAuthorId.setText(author.getId());
        txtAuthorName.setText(author.getName());
        txtBookName.setText(author.getBookName());
    }

    @FXML
    void update(ActionEvent event) throws SQLException {
        String id = txtAuthorId.getText();
        String Name = txtAuthorName.getText();
        String BookName = txtBookName.getText();

        AuthorDTO author = new AuthorDTO();

        author.setId(id);
        author.setName(Name);
        author.setBookName(BookName);

        try {
            boolean authors = authorBO.updateAuthor(author);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        LoadTable();
    }

    @SneakyThrows
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ((TableColumn)this.table.getColumns().get(0)).setCellValueFactory(new PropertyValueFactory("id"));
        ((TableColumn)this.table.getColumns().get(1)).setCellValueFactory(new PropertyValueFactory("name"));
        ((TableColumn)this.table.getColumns().get(2)).setCellValueFactory(new PropertyValueFactory("bookName"));

        txtAuthorId.setEditable(false);
        LoadTable();
        setTurnId();
//        table.refresh();
    }
    private void LoadTable() throws SQLException {
        ArrayList<AuthorDTO> authors = null;
        try {
            authors = authorBO.getAllAuthors();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        this.table.setItems(FXCollections.observableArrayList(authors));
    }
    private void setTurnId() {
        try {
            String newTurnId = authorBO.generateAuthorID();
            txtAuthorId.setText(newTurnId);

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void BookName(KeyEvent keyEvent) {
        Pattern compile = Regx.getNamePattern();
        Matcher matcher = compile.matcher(txtBookName.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtBookName.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtBookName.setUnFocusColor(Paint.valueOf("red"));
        }
    }

    public void AuthorName(KeyEvent keyEvent) {
        Pattern compile = Regx.getNamePattern();
        Matcher matcher = compile.matcher(txtAuthorName.getText());
        boolean matches = matcher.matches();
        if (matches){
            txtAuthorName.setUnFocusColor(Paint.valueOf("green"));
        }else{
            txtAuthorName.setUnFocusColor(Paint.valueOf("red"));
        }
    }
}
