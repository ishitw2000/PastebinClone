package com.ishitwa.PastebinClone.repository;

import com.ishitwa.PastebinClone.model.PasteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasteRepository extends JpaRepository<PasteModel, Long> {
    PasteModel getPasteModelById(Long id);
    PasteModel getPasteModelByUrl(String url);
    PasteModel getPasteModelByUserid(Long userid);
}
