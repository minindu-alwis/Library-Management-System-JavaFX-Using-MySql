package edu.icet.librarymanagmentsystem.repository.custom;

import edu.icet.librarymanagmentsystem.entity.MemberEntity;
import edu.icet.librarymanagmentsystem.repository.CrudDao;

public interface MemberDao extends CrudDao<MemberEntity,String> {

    MemberEntity genarateuserID();
}
