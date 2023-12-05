package com.orient.fileupload.repository;

import com.orient.fileupload.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File,Long> {
    File findFileByKey(String key);
}
