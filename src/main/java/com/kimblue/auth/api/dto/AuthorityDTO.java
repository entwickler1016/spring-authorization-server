package com.kimblue.auth.api.dto;

import com.kimblue.auth.api.global.base.BaseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorityDTO extends BaseDTO {
    private String authorityId;
    private String description;
    private String name;
}
