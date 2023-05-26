package pl.olointeria.assessment.service;



import org.springframework.stereotype.Service;
import pl.olointeria.assessment.dto.SupplierPSCPSDto;
import pl.olointeria.assessment.prima.SupplierPSCPSRepository;

import java.util.List;
import java.util.Optional;
@Service
public class SupplierPSCPSService {

    private final SupplierPSCPSRepository supplierPSCPSRepository;
    private final SupplierPSCPSDtoMapper supplierPSCPSDtoMapper;

    public SupplierPSCPSService(SupplierPSCPSRepository supplierPSCPSRepository, SupplierPSCPSDtoMapper supplierPSCPSDtoMapper) {
        this.supplierPSCPSRepository = supplierPSCPSRepository;
        this.supplierPSCPSDtoMapper = supplierPSCPSDtoMapper;
    }


    public Optional<SupplierPSCPSDto> getSupplierById(Integer id) {
        return supplierPSCPSRepository.findById(id)
                .map(supplierPSCPSDtoMapper::map);
    }



}


