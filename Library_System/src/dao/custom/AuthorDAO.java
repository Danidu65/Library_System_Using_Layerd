package dao.custom;

import java.util.ArrayList;

public interface AuthorDAO {
    static <Author> boolean add(Author author) {
        return false;
    }

    <Author> ArrayList<Author> getAll();

    String generateNewID();

    boolean delete(String id);

    boolean search(String id);

    boolean update(Author author);
}
