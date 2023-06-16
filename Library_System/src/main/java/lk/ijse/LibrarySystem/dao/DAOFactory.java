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
                return (SuperDAO) new DonetsDAOImpl();
            case EXIBITION:
                return (SuperDAO) new ExibitionDAOImpl();
            case ISSUSE:
                return (SuperDAO) new IssueDAOImpl();
            case MEMBER:
                return (SuperDAO) new MemberDAOImpl();
            case PUBLISHER:
                return (SuperDAO) new PublisherDAOImpl();
            case RETURN:
                return (SuperDAO) new ReturnDAOImpl();
            case SUPPLIER:
                return (SuperDAO) new SuplierDAOImpl();
            case USER:
                return (SuperDAO) new UserDAOImpl();
            default:
                return null;
        }
    }
}
