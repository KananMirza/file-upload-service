package com.orient.fileupload.response;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Component
public class ErrorResponse {
    LocalDateTime date;
    String traceId;
    String message;
    Integer status;
}
