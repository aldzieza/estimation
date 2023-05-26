package pl.olointeria.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.assessment.component.Component;
import pl.olointeria.assessment.component.ComponentRepository;
import pl.olointeria.assessment.prima.SupplierRepository;
import pl.olointeria.assessment.prima.Supplier;


import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

@Controller
public class ComponentController {

    @Autowired
    private ComponentRepository componentRepo;
    @Autowired
    private SupplierRepository supplierRepository;
  public  ComponentController     (ComponentRepository componentRepo) {
       this.componentRepo = componentRepo;
   }
    @GetMapping("/components/new")
    public  String showProductsForm(Model model){
        List<Supplier> listSuppliers = supplierRepository.findAll();
        model.addAttribute("product", new Component());
       model.addAttribute("listSuppliers", listSuppliers);
        return "product_form";
    }

    @GetMapping("/components")
    public  String showListComponents(Model model){
        List<Component> listComponents =componentRepo.findAll();

        model.addAttribute("listComponents", listComponents);
        return "components";
    }

}
