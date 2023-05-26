package pl.olointeria.assessment.service;



import org.springframework.stereotype.Service;
import pl.olointeria.assessment.dto.SupplierPSAPTDto;
import pl.olointeria.assessment.prima.SupplierPSAPTRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierPSAPTService {

    private final SupplierPSAPTRepository supplierPSAPTRepository;
    private final SupplierPSAPTDtoMapper supplierPSAPTDtoMapper;

    public SupplierPSAPTService(SupplierPSAPTRepository supplierPSAPTRepository, SupplierPSAPTDtoMapper supplierPSAPTDtoMapper) {
        this.supplierPSAPTRepository = supplierPSAPTRepository;
        this.supplierPSAPTDtoMapper = supplierPSAPTDtoMapper;
    }


    public Optional<SupplierPSAPTDto> getSupplierById(Integer id) {
        return supplierPSAPTRepository.findById(id)
                .map(supplierPSAPTDtoMapper::map);
    }


}



