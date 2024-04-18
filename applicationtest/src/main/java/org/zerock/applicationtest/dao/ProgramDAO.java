package org.zerock.applicationtest.dao;

import lombok.Cleanup;
import org.zerock.applicationtest.dto.NoticeDTO;
import org.zerock.applicationtest.dto.ProgramDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProgramDAO {

    public List<ProgramDTO> selectAllProgram() throws Exception {
        String sql = "select * from program";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<ProgramDTO> list = new ArrayList<>();
        while (rs.next()) {
            ProgramDTO dto = ProgramDTO.builder()
                    .no(rs.getInt("no"))
                    .title(rs.getString("title"))
                    .text(rs.getString("text"))
                    .subtext(rs.getString("subtext"))
                    .schedule(rs.getString("schedule"))
                    .img(rs.getString("img"))
                    .create_date(rs.getDate("create_date"))
                    .build();
            list.add(dto);
        }
        return list;
    }

    public ProgramDTO selectOneProgram(String title) throws Exception {
        String sql = "select * from program where title=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, title);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        ProgramDTO dto = ProgramDTO.builder()
                .no(rs.getInt("no"))
                .title(rs.getString("title"))
                .text(rs.getString("text"))
                .subtext(rs.getString("subtext"))
                .schedule(rs.getString("schedule"))
                .img(rs.getString("img"))
                .build();

        return dto;
    }
}
