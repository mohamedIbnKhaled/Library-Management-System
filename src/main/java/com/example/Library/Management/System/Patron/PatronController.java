package com.example.Library.Management.System.Patron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrons")
public class PatronController {
    @Autowired
    public PatronService patronService;
    @GetMapping
    public List<Patron> getAllPatrons() {
        return  patronService.getAllPatrons();
    }
    @GetMapping("/{id}")
    public ResponseEntity <Patron> getPatronById(Long id) {
        Optional<Patron> patron = patronService.getPatronById(id);
        return patron.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        Patron savePatron =patronService.addPatron(patron);
        return ResponseEntity.status(HttpStatus.CREATED).body(savePatron);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id ,@RequestBody Patron patronDetails) {
        return patronService.getPatronById(id).map(patron->ResponseEntity.ok(patronService.updatePatron(id,patronDetails))).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Patron> deletePatron(@PathVariable Long id) {
        patronService.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
