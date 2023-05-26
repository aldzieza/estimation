package pl.olointeria.assessment.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.olointeria.assessment.dto.SupplierDto;
import pl.olointeria.assessment.prima.SupClassification;
import pl.olointeria.assessment.prima.Supplier;
import pl.olointeria.assessment.prima.SupplierRepository;
import pl.olointeria.assessment.service.SupplierService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierRestController {

    private final SupplierService supplierService;
    @Autowired
    private SupplierRepository repo;
    public SupplierRestController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }





    @GetMapping( value="api/SupClassification", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupClassification> getSupClassification() {
        List<SupClassification> listSupClass= new ArrayList<>();
        List<Supplier> listSuppliers = repo.findAll();

        int NumberSuppliersA=0;
        int NumberSuppliersB=0;
        int NumberSuppliersC=0;
        for (Supplier supplier:listSuppliers) {

            if( supplier.getClassification().equals("A")){
                NumberSuppliersA++;
            }


            if( supplier.getClassification().equals("B")){
                NumberSuppliersB++;
                            }

            if( supplier.getClassification().equals("C")){
                NumberSuppliersC++;
                            }

        }System.out.println(NumberSuppliersA);
        return List.of(
                new SupClassification( "A", NumberSuppliersA),
                new SupClassification( "B", NumberSuppliersB),
                new SupClassification( "C", NumberSuppliersC)

        );


    }

    @GetMapping("/supplier/{id}")
    Optional<SupplierDto> getSupplierById(@PathVariable Integer id) {


        return supplierService.getSupplierById(id);
    }



}
