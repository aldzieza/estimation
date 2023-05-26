package pl.olointeria.assessment.service;

import org.springframework.stereotype.Service;
import pl.olointeria.assessment.dto.SupplierPSCPSDto;
import pl.olointeria.assessment.prima.SupplierPSCPS;
import pl.olointeria.assessment.prima.SupplierPSCPSRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class SupplierPSCPSDtoMapper {
    private final SupplierPSCPSRepository supplierPSCPSRepo ;

    public SupplierPSCPSDtoMapper(SupplierPSCPSRepository supplierPSCPSRepo) {
        this.supplierPSCPSRepo = supplierPSCPSRepo;
    }

     SupplierPSCPSDto map(SupplierPSCPS supplier){
        SupplierPSCPSDto dto =new SupplierPSCPSDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }


}

