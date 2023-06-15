package lk.ijse.LibrarySystem.Controller;

import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import lk.ijse.LibrarySystem.dao.custom.impl.AuthorDAOImpl;
import lk.ijse.LibrarySystem.dto.AuthorDTO;
//import lk.ijse.LibrarySystem.Model.AuthorModel;
import lk.ijse.LibrarySystem.bo.impl.AutorBOImpl;
import lk.ijse.LibrarySystem.dto.AuthorDTO;
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

    AutorBOImpl autorBO = new AutorBOImpl();
    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        String searchId = txtSearchAuthor.getText();
        boolean delete = autorBO.autorDelete(searchId);
//        LoadTable();

        txtAuthorId.clear();
        txtAuthorName.clear();
        txtBookName.clear();
    }

    @FXML
    void save(ActionEvent event) throws SQLException, ClassNotFoundException {
        String authorId = txtAuthorId.getText();
        String name = txtAuthorName.getText();
        String bookName = txtBookName.getText();

        AuthorDTO author = new AuthorDTO();

        author.setId(authorId);
        author.setName(name);
        author.setBookName(bookName);

        /*boolean authors = autorBO.autorAdd(author);*/
        boolean a1 = autorBO.autorAdd(author);
//        LoadTable();

        txtAuthorId.clear();
        txtAuthorName.clear();
        txtBookName.clear();
    }

    @FXML
    void search(ActionEvent event) throws SQLException, ClassNotFoundException {
        String searchId = txtSearchAuthor.getText();

        AuthorDTO author = autorBO.autorsearchFrom(searchId);

        txtAuthorId.setText(author.getId());
        txtAuthorName.setText(author.getName());
        txtBookName.setText(author.getBookName());
    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        String id = txtAuthorId.getText();
        String Name = txtAuthorName.getText();
        String BookName = txtBookName.getText();

        AuthorDTO author = new AuthorDTO();

        author.setId(id);
        author.setName(Name);
        author.setBookName(BookName);

        boolean authors = autorBO.autorUpdate(author);
//        LoadTable();
    }


    private void setTurnId() {
        try {
            String newTurnId = autorBO.autorGenarateTurnId();
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
