package com.uzs.controller;

import com.uzs.Constants;
import com.uzs.services.MusicService;
import com.uzs.to.FileTO;
import com.uzs.to.ResultTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController()
@RequestMapping("/music")
public class MusicController implements Constants {

    @Autowired
    private MusicService musicService;

    @ResponseBody
    @GetMapping("/list")
    public List<FileTO> fileList() {
        return musicService.fileList();
    }

    @ResponseBody
    @PostMapping(value = "/upload")
    public Object uploadFile(
            @RequestParam(value = "file") MultipartFile file,
            @RequestParam(value = "artist") String artist,
            @RequestParam(value = "description", required = false) String description
    ) {
        if (file.isEmpty()) {
            return new ResultTO(ERROR, "Выберите файл");
        }
        if (artist == null || artist.trim().length() == 0) {
            return new ResultTO(ERROR, "Введите испольнителя");
        }
        return musicService.uploadFile(file, artist, description);
    }

}
