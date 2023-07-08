package com.ishitwa.PastebinClone.controller;

import com.ishitwa.PastebinClone.model.PasteDTO;
import com.ishitwa.PastebinClone.model.PasteModel;
import com.ishitwa.PastebinClone.service.PasteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/")
@CrossOrigin(origins = "http://localhost:3000/")
public class PasteController {

    @Autowired
    private PasteService pasteService;

    @PostMapping("/savePaste")
    public ResponseEntity<?> savePaste(@RequestBody PasteDTO pasteDTO){
        try{
            if(pasteDTO.checkNonNull()) {
                PasteModel pasteModel = new PasteModel(pasteDTO);
                pasteService.save_paste(pasteModel);
                return ResponseEntity.ok(pasteModel);
            }else{
                return new ResponseEntity<>("Body can't be null", HttpStatus.BAD_REQUEST);
            }
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/getPaste/{pasteUrl}")
    public ResponseEntity<?> getPaste(@PathVariable String pasteUrl){
        try{
            if(!pasteUrl.equals("")) {
                PasteModel pasteModel = pasteService.getPasteFromUrl(pasteUrl);
                return ResponseEntity.ok(pasteModel);
            }else
                return new ResponseEntity<>("url can't be null", HttpStatus.BAD_REQUEST);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/updatePaste")
    public ResponseEntity<?> updatePaste(@RequestBody PasteDTO pasteDTO){
        try{
            PasteModel pasteModel = pasteService.getPasteFromUrl(pasteDTO.getUrl());
            pasteModel.setText(pasteDTO.getText());
            pasteModel.setTitle(pasteDTO.getTitle());
            pasteModel = pasteService.save_paste(pasteModel);
            return ResponseEntity.ok(pasteModel);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deletePaste/{pasteId}")
    public ResponseEntity<?> deletePaste(@PathVariable Long pasteId){
        try{
            return ResponseEntity.ok(pasteService.deletePaste(pasteId));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
