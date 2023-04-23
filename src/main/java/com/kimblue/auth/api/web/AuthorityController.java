package com.kimblue.auth.api.web;

import com.kimblue.auth.api.dto.AuthorityDTO;
import com.kimblue.auth.api.global.base.BaseController;
import com.kimblue.auth.api.global.common.Result;
import com.kimblue.auth.api.service.AuthorityService;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Authority", description = "권한")
@RestController
@RequestMapping("authority")
@RequiredArgsConstructor
public class AuthorityController implements BaseController<AuthorityDTO> {

    private final AuthorityService authorityService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<AuthorityDTO> result = authorityService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        AuthorityDTO result = authorityService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(AuthorityDTO dto) {

        AuthorityDTO result = authorityService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, AuthorityDTO dto) {

        dto.setAuthorityId(id);

        AuthorityDTO result = authorityService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        authorityService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
