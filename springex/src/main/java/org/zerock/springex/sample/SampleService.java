package org.zerock.springex.sample;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@ToString
@RequiredArgsConstructor
public class SampleService {

    // @Qualifier( ) 내에 입력되는 이름을 가진 클래스가 주입된다.
    @Qualifier("normal")
    private final SampleDAO sampleDAO;
}
