package com.ishitwa.PastebinClone.service;

import com.ishitwa.PastebinClone.model.PasteModel;
import com.ishitwa.PastebinClone.repository.PasteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PasteServiceImpl implements PasteService{

    @Autowired
    private PasteRepository pasteRepository;
    public PasteModel save_paste(PasteModel pasteModel){
        return pasteRepository.save(pasteModel);
    }

    public PasteModel getPasteFromUrl(String url){
        return pasteRepository.getPasteModelByUrl(url);
    }

    public PasteModel deletePaste(Long pasteId){
        PasteModel pasteModel = pasteRepository.getPasteModelById(pasteId);
        pasteRepository.delete(pasteModel);
        return pasteModel;
    }
}
