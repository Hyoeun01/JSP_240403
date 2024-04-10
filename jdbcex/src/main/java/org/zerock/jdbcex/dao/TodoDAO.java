package org.zerock.jdbcex.dao;

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
}
