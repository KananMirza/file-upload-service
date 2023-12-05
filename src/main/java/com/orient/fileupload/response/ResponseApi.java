package com.orient.fileupload.response;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Service
@AllArgsConstructor
@NoArgsConstructor
public class ResponseApi {
    Integer status;
    String message;
    Object body;
}
