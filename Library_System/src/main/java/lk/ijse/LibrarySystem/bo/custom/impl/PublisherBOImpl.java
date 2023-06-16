package lk.ijse.LibrarySystem.bo.custom.impl;

import lk.ijse.LibrarySystem.bo.custom.PublisherBO;
import lk.ijse.LibrarySystem.dao.custom.impl.PublisherDAOImpl;
import lk.ijse.LibrarySystem.dto.PublisherDTO;
import lk.ijse.LibrarySystem.entity.Publisher;

import java.sql.SQLException;
import java.util.ArrayList;

public class PublisherBOImpl implements PublisherBO {
    PublisherDAOImpl publisherDAO = new PublisherDAOImpl();
    @Override
    public boolean publisherAdd(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        publisherDAO.add(new Publisher(publisher.getId(), publisher.getName(),
                publisher.getPublishedBook(), publisher.getYear()));
        return false;
    }

    @Override
    public Publisher publisherSearch(String id) throws SQLException, ClassNotFoundException {
        return publisherDAO.search(id);
    }

    @Override
    public boolean publisherDelete(String id) throws SQLException, ClassNotFoundException {
        return publisherDAO.delete(id);
    }

    @Override
    public boolean publisherUpdate(PublisherDTO publisher) throws SQLException, ClassNotFoundException {
        publisherDAO.update(new Publisher(publisher.getId(), publisher.getName(),
                publisher.getPublishedBook(), publisher.getYear()));
        return false;
    }

    @Override
    public String publisherGenarateTurnID() throws SQLException, ClassNotFoundException {
        return publisherDAO.generateNewID();
    }

    @Override
    public ArrayList<String> loadAllPublisherIds() throws SQLException, ClassNotFoundException {
        return publisherDAO.loadAllIds();
    }

    @Override
    public ArrayList<PublisherDTO> loadAllPublishers() throws SQLException, ClassNotFoundException {
        ArrayList<PublisherDTO> allPublisher = new ArrayList<>();
        ArrayList<Publisher> all = new PublisherDAOImpl().loadAll();
        for (Publisher b :  all) {
            allPublisher.add(new PublisherDTO());
        }
        return allPublisher;
    }
}
