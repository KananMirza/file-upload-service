package com.orient.fileupload.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class FileRequestDto {
    @NotNull(message = "FileType is required!")
    String fileType;
    @NotNull(message = "FileContent is required!")
    String fileBase64;
}
