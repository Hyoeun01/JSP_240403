package org.zerock.jdbcex.dao;

import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
}
