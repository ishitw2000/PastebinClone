package com.ishitwa.PastebinClone.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PasteDTO {
    private String text;
    private String title;
    private String url;

    public boolean checkNonNull() {
        return text!=null && title!=null;
    }
}

