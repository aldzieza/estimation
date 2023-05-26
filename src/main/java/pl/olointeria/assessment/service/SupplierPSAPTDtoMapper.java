package pl.olointeria.assessment.service;

import org.springframework.stereotype.Service;
import pl.olointeria.assessment.dto.SupplierPSAPTDto;
import pl.olointeria.assessment.prima.*;

import java.util.LinkedList;
import java.util.List;

@Service
public class SupplierPSAPTDtoMapper {
    private final SupplierPSAPTRepository supplierPSAPTRepo ;

    public SupplierPSAPTDtoMapper(SupplierPSAPTRepository supplierPSAPTRepo) {
        this.supplierPSAPTRepo = supplierPSAPTRepo;
    }


    SupplierPSAPTDto map(SupplierPSAPT supplier){
        SupplierPSAPTDto dto =new SupplierPSAPTDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }


}


