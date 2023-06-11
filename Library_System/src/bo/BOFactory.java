package bo;

import bo.custom.impl.*;

import java.sql.SQLException;

import static javafx.css.StyleOrigin.AUTHOR;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory(){

    }

    public enum BOTypes {
        AUTHOR , BOOK , MEMBER , PUBLISHER , SUPLIER , USER

    }

    public static BOFactory getBOFactory(){
        return boFactory == null ? boFactory = new BOFactory() : boFactory;

    }

    public bo.custom.SuperBO getBO(BOTypes boTypes) throws SQLException, ClassNotFoundException {
        switch (boTypes){
            case AUTHOR :
                return (bo.custom.SuperBO) new AuthorBOImpl();
            case BOOK :
                return (bo.custom.SuperBO) new BookBOImpl();
            case MEMBER:
                return (bo.custom.SuperBO) new MemberBOImpl();
            case PUBLISHER:
                return (bo.custom.SuperBO) new PublisherBOImpl();
            case SUPLIER:
                return (bo.custom.SuperBO) new SuplierBOImpl();
            case USER:
                return (bo.custom.SuperBO) new UserBOImpl();
            default :
                return null;

        }


    }



}
