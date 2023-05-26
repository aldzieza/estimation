package pl.olointeria.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.assessment.component.ComponentPSCPS;
import pl.olointeria.assessment.component.ComponentPSCPSRepository;
import pl.olointeria.assessment.prima.SupplierRepository;
import pl.olointeria.assessment.prima.Supplier;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;


@Controller
public class ComponentPSCPSController {

    @Autowired
    private ComponentPSCPSRepository componentPSCPSRepo;
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/componentsPSCPS/new")
    public  String showProductsForm(Model model){
        List<Supplier> listSuppliers = supplierRepository.findAll();
        model.addAttribute("product", new ComponentPSCPS());
       model.addAttribute("listSuppliers", listSuppliers);
        return "product_form";
    }


    @GetMapping("/components_PSCPS")
    public  String showListPSCPSComponents(Model model){
        List<ComponentPSCPS> listPSCPSComponents =componentPSCPSRepo.findAll();

        model.addAttribute("listPSCPSComponents", listPSCPSComponents);
        return "components_PSCPS";
    }


@GetMapping("/search_component")
String home() {
return "component/search_component";
}


@PostMapping("/components_PSCPS_BySapNumber")
   public  String components_PSCPS_BySapNumber(String sapNumber,String customer,Model model){
    System.out.println("To jest sapNumber przekazany:  "+ sapNumber);
    System.out.println("To jest customer przekazany:  "+ customer);



   if(sapNumber.isEmpty()&&customer.isEmpty()){
        System.out.println("WARUNEK  SPEŁNIONY: customer= PUSTY  i  sapNumber =  PUSTY ");

    }else {
        System.out.println("WARUNEK #1 sapNumber.isEmpty()&&customer.isEmpty()  -- NIE SPEŁNIONY: customer= PUSTY  i  sapNumber =PUSTY");
    }

    if(sapNumber.isEmpty()||!customer.isEmpty()){
        List<ComponentPSCPS> listComponentsPSCPSWhith_Customer = componentPSCPSRepo.findAll();
        List<ComponentPSCPS> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSCPSWhith_Customer, customer );
        model.addAttribute("listPSCPSComponents", listaPSCPSbyCustomer);
        model.addAttribute("customer", customer);
        

    }else {
        System.out.println("WARUNEK #2  sapNumber.isEmpty()||!customer.isEmpty()  --    NIE SPEŁNIONY: customer= PUSTY  lub  sapNumber = NIEPUSTY ");
    }


    if(customer.isEmpty()||!sapNumber.isEmpty()){
         List<ComponentPSCPS> listComponentsPSCPSWhith_sapNumber = componentPSCPSRepo.findAll();
		List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
        model.addAttribute("listPSCPSComponents", listaPSCPS);
        model.addAttribute("sapNumber", sapNumber);
       
    }
    else {
        System.out.println("WARUNEK #3 customer.isEmpty()||!sapNumber.isEmpty()-- NIE SPEŁNIONY: customer= NIEPUSTY  lub  sapNumber =PUSTY ");
    }
    

    if(!customer.isEmpty()&&!sapNumber.isEmpty()){
        List<ComponentPSCPS> listComponentsPSCPSWhith_sapNumber = componentPSCPSRepo.findAll();
       List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
       List<ComponentPSCPS> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSCPSWhith_sapNumber, customer );
       model.addAttribute("listaPSCPSbyCustomer", listaPSCPSbyCustomer);
       model.addAttribute("listPSCPSComponents", listaPSCPS);
       model.addAttribute("sapNumber", sapNumber);
       model.addAttribute("customer", customer);
       
   }
   else {
       System.out.println("WARUNEK #4 !customer.isEmpty()&&!sapNumber.isEmpty()  --  NIE SPEŁNIONY: customer= NIEPUSTY  i  sapNumber =NIEPUSTY ");
   }
    
    System.out.println("To jest customer:  "+ customer);
    System.out.println("To jest SapNumber:  "+ sapNumber);
    return "component/components_PSCPS_SapNumber";
    }
    
    private List<ComponentPSCPS> nowalistaPSCPS(List<ComponentPSCPS> lista, String sapNumber) {
        List<ComponentPSCPS> listaPSCPS =new ArrayList<>();
       
        for (ComponentPSCPS component:lista
        ) {
           String sapNumber2= component.getSapNumber();
             if (sapNumber2.equals(sapNumber)){
                int i=1;i++;
              listaPSCPS.add(component);
           }
      }
         return listaPSCPS;
    }

    private List<ComponentPSCPS> nowalistaPSCPSByCustmer(List<ComponentPSCPS> lista, String customer) {
        List<ComponentPSCPS> listaPSCPSbyCustomer =new ArrayList<>();
       
        ;
        for (ComponentPSCPS component:lista
        ) {
           
        String customer2 = component.getCustomer();
            int i=1;
            if (customer2.equals(customer)){
                i++;
                 listaPSCPSbyCustomer.add(component);
           }
        }
        return listaPSCPSbyCustomer;
    }
}
