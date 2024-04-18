package org.zerock.applicationtest.dao;

import lombok.Cleanup;
import org.zerock.applicationtest.dto.MemberDTO;
import org.zerock.applicationtest.dto.NoticeDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NoticeDAO {

    public void insertNotice(NoticeDTO noticeDTO) throws Exception {
        String sql = "insert into notice (title,content) values(?,?) ";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);

        pstmt.setString(1, noticeDTO.getTitle());
        pstmt.setString(2, noticeDTO.getContent());
        pstmt.executeUpdate();
    }

    public List<NoticeDTO> selectAllNotice() throws Exception {
        String sql = "select * from notice";

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<NoticeDTO> list = new ArrayList<>();
        while (rs.next()) {
            NoticeDTO dto = NoticeDTO.builder()
                    .no(rs.getInt("no"))
                    .title(rs.getString("title"))
                    .content(rs.getString("content"))
                    .count(rs.getInt("count"))
                    .create_date(rs.getDate("create_date"))
                    .build();
            list.add(dto);
        }
        return list;
    }

    public NoticeDTO selectOneNotice(int no) throws Exception {
        String sql = "select * from notice where no=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, no);
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();

        NoticeDTO dto = NoticeDTO.builder()
                .no(rs.getInt("no"))
                .title(rs.getString("title"))
                .content(rs.getString("content"))
                .count(rs.getInt("count"))
                .create_date(rs.getDate("create_date"))
                .build();

        return dto;
    }

    public void deleteOneNotice(int no) throws Exception {
        String sql = "delete from notice where no=?";
        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, no);

        pstmt.executeUpdate();
    }

}
