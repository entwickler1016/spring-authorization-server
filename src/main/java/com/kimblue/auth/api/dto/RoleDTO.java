package com.kimblue.auth.api.dto;

import com.kimblue.auth.api.global.base.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleDTO extends BaseDTO {

    @Schema(description = "PK String UUID", accessMode = Schema.AccessMode.READ_ONLY)
    private String roleId;

    @Schema(description = "이름", maxLength = 255, nullable = false)
    private String name;

    @Schema(description = "설명", maxLength = 255, nullable = false)
    private String description;

}
