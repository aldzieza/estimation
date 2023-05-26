package pl.olointeria.assessment.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.olointeria.assessment.dto.SupplierPSAPTDto;
import pl.olointeria.assessment.prima.*;
import pl.olointeria.assessment.service.SupplierPSAPTService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierPSAPTRestController {

    private final SupplierPSAPTService supplierPSAPTService;
    @Autowired
    private SupplierPSAPTRepository repoPSAPT;


    public SupplierPSAPTRestController(SupplierPSAPTService supplierPSAPTService) {
        this.supplierPSAPTService = supplierPSAPTService;
    }





    // @GetMapping( value="api/SupClassification", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @GetMapping( value="api/SupPSAPTClassification", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupPSAPTClassification> getPSAPTSupClassification() {
        List<SupPSAPTClassification> listSupClass= new ArrayList<>();
        List<SupplierPSAPT> listSuppliers = repoPSAPT.findAll();

        int NumberSuppliersA=0;
        int NumberSuppliersB=0;
        int NumberSuppliersC=0;
        for (SupplierPSAPT supplier:listSuppliers) {

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
                new SupPSAPTClassification( "A", NumberSuppliersA),
                new SupPSAPTClassification( "B", NumberSuppliersB),
                new SupPSAPTClassification( "C", NumberSuppliersC)

        );



    }

    @GetMapping("/supplierPSAPT/{id}")
    Optional<SupplierPSAPTDto> getSupplierById(@PathVariable Integer id) {


        return supplierPSAPTService.getSupplierById(id);
    }



}


