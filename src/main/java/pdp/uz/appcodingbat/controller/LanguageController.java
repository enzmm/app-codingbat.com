package pdp.uz.appcodingbat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pdp.uz.appcodingbat.entity.Language;
import pdp.uz.appcodingbat.payload.LanguageDto;
import pdp.uz.appcodingbat.payload.Result;
import pdp.uz.appcodingbat.service.LanguageService;

import java.util.List;

@RestController
@RequestMapping("/language")
public class LanguageController {

    @Autowired
    LanguageService languageService;

    @PostMapping
    public HttpEntity<Result> addLanguage(@RequestBody Language language){
        Result result = languageService.addLanguage(language);
        return ResponseEntity.ok(result);
    }

    //Delete
    @DeleteMapping(value = "/api/language/{languageId}")
    public HttpEntity<Result> deleteLanguage(@PathVariable Integer languageId) {
        Result result = languageService.deleteLanguage(languageId);
        return ResponseEntity.ok(result);
    }

    //Update
    @PutMapping (value = "/api/languageId/{languageId}")
    public HttpEntity<Result> editLanguage(@PathVariable Integer languageId, @RequestBody LanguageDto languageDto) {
        Result result = languageService.editLanguage(languageId, languageDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public HttpEntity<List<Language>> getLanguages() {
        List<Language> languages = languageService.getLanguages();
        return ResponseEntity.ok(languages);
    }
}
