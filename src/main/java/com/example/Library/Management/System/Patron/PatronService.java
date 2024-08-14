package com.example.Library.Management.System.Patron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatronService {
    @Autowired
    private PatronRepository patronRepository;
    public List<Patron> getAllPatrons(){
        return patronRepository.findAll();
    }
    public Optional<Patron> getPatronById(long id){
        return patronRepository.findById(id);
    }
    public Patron addPatron(Patron patron){
        return patronRepository.save(patron);
    }
    public Patron updatePatron(long id, Patron patronDetails){
        return patronRepository.findById(id).map(patron -> {
            patron.setName(patronDetails.getName());
            patron.setEmail(patronDetails.getEmail());
            patron.setPhone(patronDetails.getPhone());
            patron.setAddress(patronDetails.getAddress());
            return patronRepository.save(patron);
        }).orElseThrow(() -> new RuntimeException("Patron not found with id " + id));
    }
    public void deletePatron(Long id) {
        patronRepository.deleteById(id);
    }

}
