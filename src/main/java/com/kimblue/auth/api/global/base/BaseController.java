package com.kimblue.auth.api.global.base;

import com.kimblue.auth.api.dto.AuthorityDTO;
import com.kimblue.auth.api.global.common.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.models.media.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface BaseController<T>{

    @GetMapping
    @Operation(summary = "Get Rows", description = "Returns All Rows")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json", schema = @Schema(type = "array"))}),
        @ApiResponse(responseCode = "204", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<Result> findAll();

    @GetMapping("{id}")
    @Operation(summary = "Get Row", description = "Returns Row")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "204", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<Result> findById(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id);

    @PostMapping
    @Operation(summary = "Insert Row", description = "Insert Row")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "204", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<Result> insert(@Parameter(name = "DTO", description = "DTO", in = ParameterIn.DEFAULT, content = {@Content(mediaType = "application/json")}) @RequestBody T t);

    @PutMapping("{id}")
    @Operation(summary = "Update Row", description = "Update Row")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "204", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<Result> update(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id, @Parameter(name = "DTO", description = "DTO", in = ParameterIn.DEFAULT, content = {@Content(mediaType = "application/json")}) @RequestBody T t);

    @DeleteMapping("{id}")
    @Operation(summary = "Delete Row", description = "Delete Row")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "204", content = {@Content(mediaType = "application/json")}),
        @ApiResponse(responseCode = "500", content = {@Content(mediaType = "application/json")})
    })
    ResponseEntity<Result> delete(@Parameter(name = "ID", description = "ID of Row", in = ParameterIn.PATH) @PathVariable String id);
}
