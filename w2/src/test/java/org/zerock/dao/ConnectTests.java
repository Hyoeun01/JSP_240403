package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectTests {

    @Test
    public void test1() {
        int v1 = 10;
        int v2 = 10;

        Assertions.assertEquals(v1, v2);
    }

    @Test
    public void testConnection() throws Exception {
        // mariaDB와의 연결을 확인하는 코드. 실행하면 단순히 실행의 성공여부 결과만 볼 수 있다.
        Class.forName("org.mariadb.jdbc.Driver");

        Connection conn = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3307/webdb",
                "webuser","webuser");

        Assertions.assertNotNull(conn);
        conn.close();
    }

    @Test
    public void testHikariCP() throws Exception{

        // HikariCP > 프로젝트에서 Connection의 생성
        // 데이터베이스 연결을 많이 할수록 HikariCP를 사용하는 것과 사용하지 않는 것에 성능의 차이가 생긴다. 특히 데이터베이스가 원격지에 떨어져 있는 경우 네트워크 연결에 더 많은 시간을 소비해야 하기 때문에 차이가 더욱 커진다.
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3307/webdb");
        config.setUsername("webuser");
        config.setPassword("webuser");
        // 아래 3개는 고정값이라고 생각하자
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection conn = ds.getConnection(); // 실행될 때 접속

        System.out.println(conn);

        conn.close();
    }
}
