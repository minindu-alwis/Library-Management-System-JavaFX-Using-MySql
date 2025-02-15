package edu.icet.librarymanagmentsystem.service.custome.impl;

import edu.icet.librarymanagmentsystem.dto.Member;
import edu.icet.librarymanagmentsystem.entity.MemberEntity;
import edu.icet.librarymanagmentsystem.repository.DaoFactory;
import edu.icet.librarymanagmentsystem.repository.custom.MemberDao;
import edu.icet.librarymanagmentsystem.service.custome.MemberService;
import edu.icet.librarymanagmentsystem.util.DaoType;
import org.modelmapper.ModelMapper;

import java.sql.SQLException;
import java.util.List;

public class MemberServiceImpl implements MemberService {

    MemberDao memberDao= DaoFactory.getInstance().getDaoType(DaoType.MEMBER);

    private static MemberServiceImpl instance;

    private MemberServiceImpl(){

    }

    public static MemberServiceImpl getInstance(){
        return instance == null ? new MemberServiceImpl():instance;
    }

    @Override
    public boolean isAdded(Member member) throws SQLException {
        ModelMapper modelMapper=new ModelMapper();
        MemberEntity memberEntity=modelMapper.map(member,MemberEntity.class);
        return memberDao.save(memberEntity);
    }

    @Override
    public String genarateuserID() {
        MemberEntity memberEntity = memberDao.genarateuserID();
        return memberEntity.getId();
    }

    @Override
    public List<Member> getAll() {
        List<MemberEntity> memberEntities = memberDao.getAll();
        return memberEntities.stream().map(entity -> new ModelMapper().map(entity, Member.class)).toList();
    }
}
