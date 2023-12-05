package com.orient.fileupload.service.impl;

import com.orient.fileupload.dto.FileRequestDto;
import com.orient.fileupload.dto.FileResponseDto;
import com.orient.fileupload.entity.File;
import com.orient.fileupload.exception.DataNotFoundException;
import com.orient.fileupload.repository.FileRepository;
import com.orient.fileupload.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
public class FileServiceImpl  implements FileService {
    private final FileRepository fileRepository;
    private final static String PATH = "C:\\Users\\kenan\\OneDrive\\Desktop\\e-library\\files/";
    private static final String ALLOWED_FILE_EXTENSIONS_PATTERN = "jpeg,jpg,png,webm,jfif";

    @Override
    public String uploadFile(FileRequestDto fileRequestDto) throws Exception{
        if (!isFileExtensionAllowed(fileRequestDto.getFileType())) {
            throw new Exception("FileType not supported!");
        }
        File file = new File();
        file.setFileType(fileRequestDto.getFileType());
        byte[] fileBytes = Base64.getDecoder().decode(fileRequestDto.getFileBase64());
        String fileName = fileRequestDto.getFileName();
        Path filePath = Path.of(PATH + fileName + "." + fileRequestDto.getFileType());
        Files.write(filePath,fileBytes);
        file.setFilePath(filePath.toString());
        fileRepository.save(file);
        return "File has been successfully";
    }
    @Override
    public FileResponseDto downloadFile(String key)throws Exception{
        File file = fileRepository.findFileByKey(key);
        if(file == null){
            throw new DataNotFoundException("File not found!");
        }
        FileResponseDto response = new FileResponseDto();
        response.setId(file.getId());
        response.setFilePath(file.getFilePath());
        return response;
    }

    private boolean isFileExtensionAllowed(String fileType) {
        return ALLOWED_FILE_EXTENSIONS_PATTERN.contains(fileType);
    }
}
