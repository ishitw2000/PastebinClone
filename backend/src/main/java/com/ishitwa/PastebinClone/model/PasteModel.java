package com.ishitwa.PastebinClone.model;

import com.ishitwa.PastebinClone.utils.RandomStringGenerator;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import lombok.Data;
import lombok.AllArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class PasteModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(columnDefinition = "LONGTEXT")
    private String text;
    private String title;
    private String url;
    private Long timestamp;
    private Long userid;
    public PasteModel(PasteDTO pasteDTO){
        this.text = pasteDTO.getText();
        this.title = pasteDTO.getTitle();
        this.url = RandomStringGenerator.generateUniqueRandomString();
        this.timestamp = System.currentTimeMillis();
    }

}
