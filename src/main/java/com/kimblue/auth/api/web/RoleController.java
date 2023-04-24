package com.kimblue.auth.api.web;

import com.kimblue.auth.api.dto.RoleDTO;
import com.kimblue.auth.api.global.base.BaseController;
import com.kimblue.auth.api.global.common.Result;
import com.kimblue.auth.api.service.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Role", description = "역할")
@RestController
@RequestMapping("role")
@RequiredArgsConstructor
public class RoleController implements BaseController<RoleDTO> {

    private final RoleService roleService;

    @Override
    public ResponseEntity<Result> findAll() {

        List<RoleDTO> result = roleService.findAll();

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> findById(String id) {

        RoleDTO result = roleService.findById(id);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> insert(RoleDTO dto) {

        RoleDTO result = roleService.insert(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> update(String id, RoleDTO dto) {

        dto.setRoleId(id);

        RoleDTO result = roleService.update(dto);

        return ResponseEntity.ok(new Result(result));
    }

    @Override
    public ResponseEntity<Result> delete(String id) {

        roleService.delete(id);

        return ResponseEntity.ok(new Result());
    }
}
