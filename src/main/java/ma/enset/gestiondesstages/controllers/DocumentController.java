package ma.enset.gestiondesstages.controllers;

import ma.enset.gestiondesstages.models.CahierStage;
import ma.enset.gestiondesstages.models.Document;
import ma.enset.gestiondesstages.repositories.DocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentController {
    @Autowired
    DocumentRepository documentRepository;

    @GetMapping("/documents")
    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }

    @GetMapping("/document/{idDocument}")
    public Document getDocumentById(String idDocument) {
        return documentRepository.findById(idDocument).get();
    }

    @PostMapping("/document")
    public Document createDocument(Document document) {
        return documentRepository.save(document);
    }

    @PutMapping("/document/{idDocument}")
    public Document updateDocument(String idDocument, Document document) {
        Document document1= documentRepository.findById(idDocument).get();
        if (document.getTitre()!=null) document1.setTitre(document.getTitre());
        if (document.getDescription()!=null) document1.setDescription(document.getDescription());
        if (document.getDateDepot()!=null) document1.setDateDepot(document.getDateDepot());
        if (document.getCahierStage()!=null) document1.setCahierStage(document.getCahierStage());
        return documentRepository.save(document1);
    }

    @DeleteMapping("/document/{idDocument}")
    public void deleteDocument(String idDocument) {
        documentRepository.deleteById(idDocument);
    }


}
