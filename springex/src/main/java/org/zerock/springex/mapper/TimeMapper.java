package org.zerock.springex.mapper;

import org.apache.ibatis.annotations.Select;


public interface TimeMapper {

    // myBatis를 이용해서 코드를 간단하게 작성
    @Select("select now()")
    String getTime(); // 리턴할때 String 으로 반환/ getTime()은 실행하고 싶은 내용
    // Resultset이 필요가 없다

/* myBatis를 이용하지 않을때 코드 작성하려면 이렇게 길게 적어야한다

public String getTime2() throws Exception {

        @Cleanup Connection conn = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = conn.prepareStatement("select now()");
        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next();
        String now = rs.getString(1);
        return now;
    }
 */

}
