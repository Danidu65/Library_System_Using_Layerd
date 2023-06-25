package lk.ijse.LibrarySystem.bo.custom;

import lk.ijse.LibrarySystem.bo.SuperBO;
import lk.ijse.LibrarySystem.dto.MemberDTO;

import java.sql.SQLException;
import java.util.ArrayList;
public interface MemberBO extends SuperBO {
    public boolean memberAdd(MemberDTO member) throws SQLException, ClassNotFoundException;
    public MemberDTO membersearchFrom(String id) throws SQLException, ClassNotFoundException;
    public boolean memberDelete(String id) throws SQLException, ClassNotFoundException;
    public boolean memberUpdate(MemberDTO member) throws SQLException, ClassNotFoundException;
    public String memberGenarateTurnId() throws SQLException, ClassNotFoundException;
    public ArrayList<String> loadAllMemberIds() throws SQLException, ClassNotFoundException;
    public ArrayList<MemberDTO> loadAllMember() throws SQLException, ClassNotFoundException;
}
