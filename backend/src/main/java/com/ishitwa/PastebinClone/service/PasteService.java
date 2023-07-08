package com.ishitwa.PastebinClone.service;

import com.ishitwa.PastebinClone.model.PasteModel;

public interface PasteService {
    PasteModel save_paste(PasteModel pasteModel);

    PasteModel getPasteFromUrl(String pasteUrl);

    PasteModel deletePaste(Long pasteId);
}
