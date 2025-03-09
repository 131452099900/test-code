package com.code.mapper;

import com.code.UserDto;
import com.code.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author gbl.huang
 * @date 2025/03/06 20:45
 **/
@Mapper
public interface UserConverter {
    // aaa
    public static void main(String[] args) {
        UserDto userDto = new UserDto();
        userDto.setId(1L);
        userDto.setName("name");
        userDto.setTestId(2L);
        System.out.println(UserConverter.INSTANCT.dtoToDomain(userDto));
    }
    UserConverter INSTANCT  = Mappers.getMapper(UserConverter.class);

    @Mapping(source = "testId", target = "targetId")
    UserEntity dtoToDomain(UserDto userDto);
}