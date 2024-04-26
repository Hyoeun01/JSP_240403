package org.zerock.b01.repository.noticeSearch;

import com.querydsl.jpa.JPQLQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.zerock.b01.domain.Notice;
import org.zerock.b01.domain.QNotice;

import java.util.List;

public class NoticeSearchImpl extends QuerydslRepositorySupport implements NoticeSearch {
public NoticeSearchImpl() {
    super(Notice.class);
}

    @Override
    public Page<Notice> search1(Pageable pageable) {

        QNotice notice = QNotice.notice;
        JPQLQuery<Notice> query = from(notice);
        query.where(notice.title.contains("1"));
        List<Notice> list = query.fetch();

        long count = query.fetchCount();

        return null;
    }


}
