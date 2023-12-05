package com.orient.fileupload.controller;

import com.orient.fileupload.dto.FileRequestDto;
import com.orient.fileupload.dto.FileResponseDto;
import com.orient.fileupload.response.ResponseApi;
import com.orient.fileupload.service.FileService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/files")
public class FileController {
    private final FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<ResponseApi> uploadFile(@RequestBody @Valid FileRequestDto fileRequestDto) throws Exception {
        FileResponseDto response = fileService.uploadFile(fileRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(resp(HttpStatus.CREATED.value(),response ));
    }

    @GetMapping("/download/{key}")
    public ResponseEntity<ResponseApi> downloadFile(@PathVariable @Valid @NotNull(message = "Key is required") String key) throws Exception {
        return ResponseEntity.ok(resp(HttpStatus.OK.value(), fileService.downloadFile(key)));
    }
    private ResponseApi resp(Integer status, Object response){
        ResponseApi responseApi = new ResponseApi();
        responseApi.setStatus(status);
        responseApi.setMessage("Success");
        responseApi.setBody(response);
        return responseApi;
    }
}
