package org.zerock.applicationtest.dao;

import lombok.Cleanup;
import org.zerock.applicationtest.dto.MemberDTO;

import java.sql.*;

public class MemberDAO {

    public void insertMember(MemberDTO memberDTO) throws Exception{
        String sql = "insert into member(member_id,member_pw,name,phone,email1,email2,gender,agree) values(?,?,?,?,?,?,?,?)";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, memberDTO.getMember_id());
        pstmt.setString(2, memberDTO.getMember_pw());
        pstmt.setString(3, memberDTO.getName());
        pstmt.setString(4, memberDTO.getPhone());
        pstmt.setString(5, memberDTO.getEmail1());
        pstmt.setString(6, memberDTO.getEmail2());
        pstmt.setString(7, memberDTO.getGender());
        pstmt.setBoolean(8, memberDTO.isAgree());

        pstmt.executeUpdate();
    }

}
