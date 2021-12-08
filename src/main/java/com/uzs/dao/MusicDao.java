package com.uzs.dao;

import com.uzs.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicDao extends JpaRepository<Music, Integer> {

}
