package edu.icet.librarymanagmentsystem.repository.custom.impl;

import edu.icet.librarymanagmentsystem.dbconnection.DBConnection;
import edu.icet.librarymanagmentsystem.entity.MemberEntity;
import edu.icet.librarymanagmentsystem.repository.custom.MemberDao;
import org.hibernate.engine.spi.ManagedEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDaoImpl implements MemberDao {
    @Override
    public boolean save(MemberEntity entity) throws SQLException {
        String sql="INSERT INTO libraryMembers (MemberID, Name, ContactInfo, MembershipDate) VALUES (?, ?, ?, ?)";

        try (Connection connection=DBConnection.getInstance().getConnection();
             PreparedStatement stmt=connection.prepareStatement(sql)) {

            stmt.setString(1, entity.getId());
            stmt.setString(2, entity.getName());
            stmt.setString(3, entity.getContact());
            stmt.setDate(4, entity.getDate()!=null ? java.sql.Date.valueOf(entity.getDate()) : null);

            return stmt.executeUpdate()>0;
        }
    }


    @Override
    public boolean update(MemberEntity entity) throws SQLException {
        return false;
    }

    @Override
    public MemberEntity search(String s) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(String s) throws SQLException {
        return false;
    }

    @Override
    public List<MemberEntity> getAll() {
        List<MemberEntity> members=new ArrayList<>();
        String sql="SELECT * FROM libraryMembers";

        try (Connection connection=DBConnection.getInstance().getConnection();
             PreparedStatement stmt=connection.prepareStatement(sql);
             ResultSet rs=stmt.executeQuery()) {

            while (rs.next()) {
                MemberEntity member=new MemberEntity();
                member.setId(rs.getString("MemberID"));
                member.setName(rs.getString("Name"));
                member.setContact(rs.getString("ContactInfo"));
                member.setDate(rs.getDate("MembershipDate").toLocalDate());
                members.add(member);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public MemberEntity genarateuserID() {
        String newUserId;
        try {
            Connection connection= DBConnection.getInstance().getConnection();
            PreparedStatement stmt=connection.prepareStatement("SELECT MemberID FROM libraryMembers ORDER BY MemberID DESC LIMIT 1");
            ResultSet rs=stmt.executeQuery();

            if (rs.next()) {
                String lastId=rs.getString("MemberID");
                int id=Integer.parseInt(lastId.substring(1));
                newUserId=String.format("M%04d",id+1);
            } else {
                newUserId="M0001";
            }

            MemberEntity member=new MemberEntity();
            member.setId(newUserId);
            return member;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
