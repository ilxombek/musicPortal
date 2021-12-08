package com.uzs.services;

import com.uzs.to.FileTO;
import com.uzs.to.ResultTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface MusicService {
    List<FileTO> fileList();

    ResultTO uploadFile(MultipartFile file, String artist, String description);
}
