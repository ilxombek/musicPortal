package com.uzs.services;

import com.uzs.Constants;
import com.uzs.dao.MusicDao;
import com.uzs.model.Music;
import com.uzs.to.FileTO;
import com.uzs.to.ResultTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServiceImpl implements MusicService, Constants {

    @Autowired
    private MusicDao musicDao;

    public List<FileTO> fileList() {
        List<Music> all = musicDao.findAll();
        List<FileTO> result = new ArrayList<>(all.size());
        all.forEach(m->result.add(m.toTO()));
        return result;
    }

    @Override
    public ResultTO uploadFile(MultipartFile file, String artist, String description) {
        try {
            Music music = new Music();
            music.setMusicName(file.getOriginalFilename());
            music.setArtist(artist);
            music.setUrlAddress(HOST + "/files/" + file.getOriginalFilename());
            music.setDescription(description);
            musicDao.save(music);

            Files.write(Paths.get("D:/Projects/musicPortal/src/main/webapp/files/" + file.getOriginalFilename()), file.getBytes());
            return new ResultTO(SUCCESS, "Успешно");
        } catch (IOException e) {
            e.printStackTrace();
            return new ResultTO(ERROR, "Ошибка");
        }
    }
}
