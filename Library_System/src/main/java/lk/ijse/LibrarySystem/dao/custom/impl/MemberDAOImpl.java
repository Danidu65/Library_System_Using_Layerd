package lk.ijse.LibrarySystem.dao.custom.impl;

import lk.ijse.LibrarySystem.dao.custom.MemberDAO;
import lk.ijse.LibrarySystem.db.DBConnection;
import lk.ijse.LibrarySystem.dto.MemberDTO;
import lk.ijse.LibrarySystem.entity.Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAOImpl implements MemberDAO {

    @Override
    public boolean add(Member member) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "INSERT INTO member(memberId, name, address, contact, email ,gender ) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, member.getId());
        stm.setObject(2, member.getName());
        stm.setObject(3, member.getAddress());
        stm.setObject(4, member.getContact());
        stm.setObject(5, member.getEmail());
        stm.setObject(6,member.getGender());

        int result = stm.executeUpdate();
        return result > 0;
    }

    @Override
    public Boolean update(Member member) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "update member set name=?,address=?,contact=?,email=?,gender=? where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, member.getName());
        stm.setObject(2, member.getAddress());
        stm.setObject(3, member.getContact());
        stm.setObject(4, member.getEmail());

        System.out.println(member.getGender().length());
        System.out.println(member.getGender());

        stm.setObject(5, member.getGender());
        stm.setObject(6, member.getId());

        return stm.executeUpdate() > 0;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "delete from member where memberId = ?";

        PreparedStatement stm = con.prepareStatement(sql);
        stm.setObject(1, id);
        int result = stm.executeUpdate();
        return false;
    }

    @Override
    public Member search(String id) throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member where memberId=?";

        PreparedStatement stm = con.prepareStatement(sql);

        stm.setObject(1, id);

        ResultSet result = stm.executeQuery();

        if (result.next()) {
            MemberDTO member = new MemberDTO();
            member.setId(result.getString(1));
            member.setName(result.getString(2));
            member.setAddress(result.getString(3));
            member.setContact(result.getString(4));
            member.setEmail(result.getString(5));
            member.setGender(result.getString(6));
            return member;
        }

        return null;
    }

    @Override
    public ArrayList<String> loadAllIds() throws SQLException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select memberId from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> memberIds = new ArrayList<>();

        while (result.next()) {
            memberIds.add(result.getString(1));
        }
        return memberIds;
    }

    @Override
    public String generateNewID() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();

        PreparedStatement ps = con.prepareStatement("SELECT memberId FROM member ORDER BY memberId DESC LIMIT 1 ");

        ResultSet rs = ps.executeQuery();

        if (rs.next()){
            String lastMemberId = rs.getString(1);

            String[] temp = lastMemberId.split("M");

            int value = Integer.parseInt((temp[1]));
            String nextValue = (value+1) + "";

            if (nextValue.length() == 1 ){
                return "M00"+ nextValue;
            }else if (nextValue.length() == 2 ){
                return "M0" + nextValue;
            }else {
                return "M";
            }


        }
        return  "M001";
    }

    @Override
    public ArrayList<Member> loadAll() throws SQLException, ClassNotFoundException {
        Connection con = DBConnection.getInstance().getConnection();
        String sql = "select * from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<Member> members = new ArrayList<>();

        while (result.next()) {
            MemberDTO member = new MemberDTO();

            member.setId(result.getString(1));
            member.setName(result.getString(2));
            member.setAddress(result.getString(3));
            member.setContact(result.getString(4));
            member.setEmail(result.getString(5));

            members.add(member);
        }
        return members;
    }
    public static ArrayList<String> loadAllMemberEmails() throws SQLException {

        Connection con = DBConnection.getInstance().getConnection();

        String sql = "select Email from member";

        PreparedStatement stm = con.prepareStatement(sql);

        ResultSet result = stm.executeQuery();

        ArrayList<String> Email = new ArrayList<>();

        while (result.next()) {
            Email.add(result.getString(1));
        }
        return Email;
    }
}