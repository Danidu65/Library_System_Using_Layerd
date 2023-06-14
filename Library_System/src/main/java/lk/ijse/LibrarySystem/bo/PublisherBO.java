package lk.ijse.LibrarySystem.bo;

import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public interface PublisherBO extends SuperBO {
    public boolean publisherAdd(PublisherDTO publisher)throws SQLException, ClassNotFoundException;
    public Publisher publisherSearch(String id)throws SQLException, ClassNotFoundException;
    public  boolean publisherDelete(String id)throws SQLException, ClassNotFoundException;
    public boolean publisherUpdate(PublisherDTO publisher)throws SQLException, ClassNotFoundException;
    public String publisherGenarateTurnID()throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllPublisherIds()throws SQLException, ClassNotFoundException;
    public ArrayList<PublisherDTO> loadAllPublishers()throws SQLException, ClassNotFoundException;
}
