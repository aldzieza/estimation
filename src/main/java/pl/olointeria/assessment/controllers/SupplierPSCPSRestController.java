package pl.olointeria.assessment.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.olointeria.assessment.dto.SupplierPSCPSDto;
import pl.olointeria.assessment.prima.*;
import pl.olointeria.assessment.service.SupplierPSCPSService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class SupplierPSCPSRestController {

    private final SupplierPSCPSService supplierPSCPSService;
    @Autowired
    private SupplierPSCPSRepository repoPSCPS;


    public SupplierPSCPSRestController(SupplierPSCPSService supplierPSCPSService) {
        this.supplierPSCPSService = supplierPSCPSService;
    }





     @GetMapping( value="api/SupPSCPSClassification", produces = MediaType.APPLICATION_JSON_VALUE)
    List<SupPSCPSClassification> getPSCPSSupClassification() {
        List<SupPSCPSClassification> listSupClass= new ArrayList<>();
        List<SupplierPSCPS> listSuppliers = repoPSCPS.findAll();

        int NumberSuppliersA=0;
        int NumberSuppliersB=0;
        int NumberSuppliersC=0;
        for (SupplierPSCPS supplier:listSuppliers) {

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
                new SupPSCPSClassification( "A", NumberSuppliersA),
                new SupPSCPSClassification( "B", NumberSuppliersB),
                new SupPSCPSClassification( "C", NumberSuppliersC)

        );


    }

    @GetMapping("/supplierPSCPS/{id}")
    Optional<SupplierPSCPSDto> getSupplierById(@PathVariable Integer id) {


        return supplierPSCPSService.getSupplierById(id);
    }



}

