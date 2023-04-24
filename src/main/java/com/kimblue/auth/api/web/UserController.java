package com.kimblue.auth.api.web;

import com.kimblue.auth.api.dto.UserDTO;
import com.kimblue.auth.api.global.base.BaseController;
import com.kimblue.auth.api.global.common.Result;
import com.kimblue.auth.api.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "User", description = "사용자")
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class UserController implements BaseController<UserDTO> {

    private final UserService userService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<UserDTO> result = userService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        UserDTO result = userService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(UserDTO dto) {

        UserDTO result = userService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, UserDTO dto) {

        dto.setUserId(id);

        UserDTO result = userService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        userService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
