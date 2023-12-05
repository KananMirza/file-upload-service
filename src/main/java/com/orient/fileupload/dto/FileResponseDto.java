package com.orient.fileupload.dto;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileResponseDto {
    Long id;
    String filePath;
    String key;
}
