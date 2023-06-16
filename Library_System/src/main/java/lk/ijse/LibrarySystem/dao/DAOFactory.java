package lk.ijse.LibrarySystem.dao;

import lk.ijse.LibrarySystem.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory(){

    }
    private static DAOFactory getDaoFactory(){
        return(daoFactory == null ) ?daoFactory =new DAOFactory() : daoFactory;
    }
    public enum DAOTypes{
        AUTOR,BOOK,DONETION,EXIBITION,ISSUSE,MEMBER,PUBLISHER,RETURN,SUPPLIER,USER
    }
    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case AUTOR:
                return (SuperDAO) new AuthorDAOImpl();
            case BOOK:
                return (SuperDAO) new BookDAOImpl();
            case DONETION:
                return new DonetsDAOImpl();
            case EXIBITION:
                return new ExibitionDAOImpl();
            case ISSUSE:
                return new IssueDAOImpl();
            case MEMBER:
                return  new MemberDAOImpl();
            case PUBLISHER:
                return new PublisherDAOImpl();
            case RETURN:
                return new ReturnDAOImpl();
            case SUPPLIER:
                return new SuplierDAOImpl();
            case USER:
                return (SuperDAO) new UserDAOImpl();
            default:
                return null;
        }
    }
}
