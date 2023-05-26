package pl.olointeria.assessment.service;

import org.springframework.stereotype.Service;
import pl.olointeria.assessment.dto.SupplierDto;
import pl.olointeria.assessment.prima.Supplier;
import pl.olointeria.assessment.prima.SupplierRepository;

import java.util.LinkedList;
import java.util.List;

@Service
public class SupplierDtoMapper {
    private final SupplierRepository supplierRepo;

    public SupplierDtoMapper(SupplierRepository supplierRepo) {
        this.supplierRepo = supplierRepo;
    }

  //  onseBody, czyli adnotacja @ResponseBody zostanie dodana do wszystkich metod automatycznie.
    SupplierDto map(Supplier supplier){
        SupplierDto dto =new SupplierDto();
        dto.setId(supplier.getId());
        dto.setId_Sap(supplier.getId_Sap());
        dto.setName(supplier.getName());
        dto.setClassification(supplier.getClassification());
        dto.setTotalScore(supplier.getTotalScore());

        return dto;
    }

}
