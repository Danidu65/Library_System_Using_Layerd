package lk.ijse.LibrarySystem.bo.impl;

import lk.ijse.LibrarySystem.bo.PublisherBO;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherBOImpl implements PublisherBO {
    @Override
    public boolean publisherAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public Publisher publisherSearch(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean publisherDelete(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public boolean publisherUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public String publisherGenarateTurnID() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<String> loadAllPublisherIds() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public ArrayList<PublisherDTO> loadAllPublishers() throws SQLException, ClassNotFoundException {
        return null;
    }
}
