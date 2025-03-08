package com.code;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author gbl.huang
 * @date 2025/03/06 20:37
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntity {
    private Long id;
    private String name;
    private Long targetId;
}