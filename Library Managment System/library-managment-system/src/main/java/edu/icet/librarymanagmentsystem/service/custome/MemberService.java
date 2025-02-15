package edu.icet.librarymanagmentsystem.service.custome;

import edu.icet.librarymanagmentsystem.dto.Member;
import edu.icet.librarymanagmentsystem.service.SuperService;

import java.sql.SQLException;

public interface MemberService extends SuperService {

    boolean isAdded(Member member) throws SQLException;
    String genarateuserID();

}
