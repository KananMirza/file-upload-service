package com.orient.fileupload.service;

import com.orient.fileupload.dto.FileRequestDto;
import com.orient.fileupload.dto.FileResponseDto;

public interface FileService {
    FileResponseDto uploadFile(FileRequestDto fileRequestDto) throws Exception;
    FileResponseDto downloadFile(String key)throws Exception;
}
