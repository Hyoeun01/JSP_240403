package org.zerock.jdbcex.util;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

// ModelMapper의 설정을 변경하고 사용할수 있는 MapperUtil 추가
public enum MapperUtil {
    INSTANCE;

    private ModelMapper modelMapper;

    MapperUtil() {
        this.modelMapper = new ModelMapper();
        // getConfiguration()을 이용해서 private로 선언된 필드도 접근가능하도록 설정을 변경
        this.modelMapper.getConfiguration()
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(org.modelmapper.config.Configuration.AccessLevel.PRIVATE)
                .setMatchingStrategy(MatchingStrategies.STRICT);
    }

    // get()을 이용해서 ModelMapper를 사용가능
    // get()밖에 없으므로 modelMapper는 수정이 불가능
    public ModelMapper get(){
        return modelMapper;
    }
}
