package com.kimblue.auth.api.dto;

import com.kimblue.auth.api.global.base.BaseDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDTO extends BaseDTO {

    @Schema(description = "PK String UUID", accessMode = Schema.AccessMode.READ_ONLY)
    private String userId;
    private String email;
    private String name;
    private String password;
    private LocalDateTime passwordUpdatedAt;
    private String phone;
    private Boolean enabled;
    private Integer failedAttempt;
    private Boolean locked;

}
