package org.zerock.jdbcex.dao;

import lombok.Cleanup;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TodoDAO {

    public String getTime(){
        // getTime()은 try-with -resource 기능을 이용해서 try()내에 선언된 변수가 자동으로 closd() 될수 있는 구조로 작성.
        // try()내에 선언된 변수들은 모두 autoCloseable이라는 인터페이스를 구현한 타입이어야한다
        String now = null;
        try(Connection conn = ConnectUtil.INSTANCE.getConnection();
            PreparedStatement pstmt = conn.prepareStatement("select now()");
            ResultSet rs = pstmt.executeQuery()) {
            rs.next();
            now = rs.getString(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    // getTime()의 try-catch부분이 모두 없어지고 선언부에 throws Exception으로 처리
    // @Cleanup은 중첩 try-catch를 이용해야할때 가독성이 떨어지는 문제를 해결할 수 있다.
    // @Cleanup이 추가된 변수는 해당 메소드가 끝날 때 close()가 호출되는 것을 보장한다.
    public String getTime2() throws Exception {

        @Cleanup Connection conn = ConnectUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();

        String now = rs.getString(1);

        return now;
    }

    // insert()는 파라미터로 입력된 TodoVO 객체의 정보를 이용해 DML을 실행하므로 executeUpdate()를 실행하도록 구성한다.
    // PreparedStatement는 ?를 이용해서 나중에 전달할 데이터를 지정하는데, setXXX()를 이용해 실제 값을 지정한다.

    public void insert(TodoVO vo) throws Exception {
        String sql = "insert into tbl_todo (title, dueDate, finished) values (?, ?, ?)";

        @Cleanup Connection conn = ConnectUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        // 인덱스 번호가 0이아닌 1부터 시작함에 주의하자.
        // sql의 ?가 3개이므로 pstmt의 setXXX()도 3개여야 한다
        pstmt.setString(1, vo.getTitle());
        pstmt.setDate(2, Date.valueOf(vo.getDueDate()));
        pstmt.setBoolean(3, vo.isFinished());

        pstmt.executeUpdate();
    }


    // 테이블의 각 행이 하나의 TodoVO의 객체가 되고, 모든 TodoVO를 담을 수 있도록 List<TodoVO> 타입을 리턴타입으로 지정
    public List<TodoVO> selectAll() throws Exception {

        String sql = "select * from tbl_todo";
        @Cleanup Connection conn = ConnectUtil.INSTANCE.getConnection();
        // 쿼리를 실행해야 하기 때문에 pstmt.executeQuery()를 이용해서 ResultSet을 구한다
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        List<TodoVO> list = new ArrayList<>();

        // ResultSet으로 각 행을 이동하면서 각 행의 데이터를 TodoVO로 변환한다.
        // next()의 결과 이동할 수 있는 행이 존재하면 true, 아니면 false 반환
        while(rs.next()) {
            // 빌더 패턴을 이용해서 간편하게 객체를 생성할 수 있는데,
            // tno/title 등의 속성값을 ResultSet에서 가져온 데이터로 처리한다. rs.getXXX()는 칼럼의 인덱스 번호를 이요하거나 칼럼의 이름을 지정해서 가져올 수 있고, 인덱스 번호를 이용할 경우 시작값이 1임을 기억해두자 ( 0이 아니다! )
            TodoVO vo = TodoVO.builder()
                    .tno(rs.getLong("tno"))
                    .title(rs.getString("title"))
                    .dueDate(rs.getDate("dueDate").toLocalDate())
                    .finished(rs.getBoolean("finished"))
                    .build();
            list.add(vo);
        }
        return list;
    }

    public TodoVO selectOne(Long tno) throws Exception {
        String sql = "select * from tbl_todo where tno = ?";

        @Cleanup Connection conn = ConnectUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setLong(1, tno);
        @Cleanup ResultSet rs = pstmt.executeQuery();

        rs.next();
        TodoVO vo = TodoVO.builder()
                .tno(rs.getLong("tno"))
                .title(rs.getString("title"))
                .dueDate(rs.getDate("dueDate").toLocalDate())
                .finished(rs.getBoolean("finished"))
                .build();

        return vo;
    }
}
