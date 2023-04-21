package com.kimblue.auth.api.global.base;

import com.kimblue.auth.api.global.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
public interface BaseController<T>{

    @GetMapping
    @Operation(summary = "Get All List", description = "Returns All")
    ResponseEntity<Result> findAll();

    @GetMapping("{id}")
    @Operation(summary = "Get Row", description = "Returns Row")
    ResponseEntity<Result> findById(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id);

    @PostMapping
    @Operation(summary = "Insert Row", description = "Returns Row")
    ResponseEntity<Result> insert(@Parameter(name = "DTO", description = "DTO", in = ParameterIn.DEFAULT) @RequestBody T t);

    @PutMapping("{id}")
    @Operation(summary = "Update Row", description = "Returns Row")
    ResponseEntity<Result> update(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id, @Parameter(name = "DTO", description = "DTO", in = ParameterIn.DEFAULT) @RequestBody T t);

    @DeleteMapping("{id}")
    @Operation(summary = "Delete Row", description = "Returns Boolean")
    ResponseEntity<Result> delete(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id);
}
