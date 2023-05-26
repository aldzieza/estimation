package pl.olointeria.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.assessment.component.ComponentPSAPT;
import pl.olointeria.assessment.component.ComponentPSAPTRepository;
import pl.olointeria.assessment.prima.SupplierRepository;
import pl.olointeria.assessment.prima.Supplier;


import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class ComponentPSAPTController {

    @Autowired
    private ComponentPSAPTRepository componentPSAPTRepo;
    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping("/componentsPSAPT/new")
    public  String showProductsForm(Model model){
        List<Supplier> listSuppliers = supplierRepository.findAll();
        model.addAttribute("product", new ComponentPSAPT());
       model.addAttribute("listSuppliers", listSuppliers);
        return "product_form";
    }

    @GetMapping("/components_PSAPT")
    public  String showListComponents(Model model){
        List<ComponentPSAPT> listPSAPTComponents = componentPSAPTRepo.findAll();

        model.addAttribute("listPSAPTComponents", listPSAPTComponents);
        return "components_PSAPT";
    }
    @GetMapping("/search_componentPSAPT")
    String home() {
        return "component/search_componentPSAPT";
    }
    @PostMapping("/components_PSAPT_BySapNumber")
//@ResponseBody
    public  String components_PSAPT_BySapNumber(String sapNumber,String customer,Model model){
        System.out.println("To jest sapNumber przekazany:  "+ sapNumber);
        System.out.println("To jest customer przekazany:  "+ customer);



// case #1 sap =" "  i customer=" "
        if(sapNumber.isEmpty()&&customer.isEmpty()){
            System.out.println("WARUNEK  SPEŁNIONY: customer= PUSTY  i  sapNumber =  PUSTY ");

        }else {
            System.out.println("WARUNEK #1 sapNumber.isEmpty()&&customer.isEmpty()  -- NIE SPEŁNIONY: customer= PUSTY  i  sapNumber =PUSTY");
        }
// case #2 sap =" "  lub customer=NIE " "

        if(sapNumber.isEmpty()||!customer.isEmpty()){
            List<ComponentPSAPT> listComponentsPSAPTWhith_Customer = componentPSAPTRepo.findAll();
            List<ComponentPSAPT> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSAPTWhith_Customer, customer );
            model.addAttribute("listPSAPTComponents", listaPSCPSbyCustomer);
            model.addAttribute("customer", customer);


        }else {
            System.out.println("WARUNEK #2  sapNumber.isEmpty()||!customer.isEmpty()  --    NIE SPEŁNIONY: customer= PUSTY  lub  sapNumber = NIEPUSTY ");
        }

// case #3 sap  =  NIE " "  lub  customer=" "

        if(customer.isEmpty()||!sapNumber.isEmpty()){
            List<ComponentPSAPT> listComponentsPSCPSWhith_sapNumber = componentPSAPTRepo.findAll();
            List<ComponentPSAPT> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
            model.addAttribute("listPSAPTComponents", listaPSCPS);
            model.addAttribute("sapNumber", sapNumber);

        }
        else {
            System.out.println("WARUNEK #3 customer.isEmpty()||!sapNumber.isEmpty()-- NIE SPEŁNIONY: customer= NIEPUSTY  lub  sapNumber =PUSTY ");
        }

        // case #4 sap  =  NIE " "  lub  customer=NIE" "

        if(!customer.isEmpty()&&!sapNumber.isEmpty()){
            List<ComponentPSAPT> listComponentsPSCPSWhith_sapNumber = componentPSAPTRepo.findAll();
            List<ComponentPSAPT> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_sapNumber, sapNumber );
            List<ComponentPSAPT> listaPSCPSbyCustomer = nowalistaPSCPSByCustmer(listComponentsPSCPSWhith_sapNumber, customer );
            model.addAttribute("listaPSCPSbyCustomer", listaPSCPSbyCustomer);
            model.addAttribute("listPSAPTComponents", listaPSCPS);
            model.addAttribute("sapNumber", sapNumber);
            model.addAttribute("customer", customer);

        }
        else {
            System.out.println("WARUNEK #4 !customer.isEmpty()&&!sapNumber.isEmpty()  --  NIE SPEŁNIONY: customer= NIEPUSTY  i  sapNumber =NIEPUSTY ");
        }

        //model.addAttribute("listPSCPSComponents", listaPSCPS);
        System.out.println("To jest customer:  "+ customer);
        System.out.println("To jest SapNumber:  "+ sapNumber);
        return "component/components_PSAPT_SapNumber";
    }

    private List<ComponentPSAPT> nowalistaPSCPS(List<ComponentPSAPT> lista, String sapNumber) {
        List<ComponentPSAPT> listaPSCPS =new ArrayList<>();

        for (ComponentPSAPT component:lista
        ) {
            String sapNumber2= component.getSapNumber();
            // System.out.println("To jest SapNumberdla componentu z listy repo:  "+ sapNumber2);
            // System.out.println("To jest SapNumber szukany:  "+sapNumber);
            if (sapNumber2.equals(sapNumber)){
                int i=1;i++;
                // System.out.println("czemu to jest wykonane:   "+i);
                //System.out.println("To jest id_sap: "+sapNumber);
                listaPSCPS.add(component);
            }
//
            // System.out.println("Nowa ListComponents:  "+listaPSCPS);
        }
        //  System.out.println("Nowa ListComponents_2:  "+listaPSCPS);
        return listaPSCPS;
    }

    private List<ComponentPSAPT> nowalistaPSCPSByCustmer(List<ComponentPSAPT> lista, String customer) {
        List<ComponentPSAPT> listaPSCPSbyCustomer =new ArrayList<>();

        ;
        for (ComponentPSAPT component:lista
        ) {

            String customer2 = component.getCustomer();
            // System.out.println("To jest customer2 dla componentu z listy repo:  "+ customer2);
            // System.out.println("To jest customer szukany:  "+customer);
            int i=1;
            if (customer2.equals(customer)){
                i++;
                // System.out.println("czemu to jest wykonane:   "+i);
                //  System.out.println("To jest customer: "+customer);
                listaPSCPSbyCustomer.add(component);
            }
//
            // System.out.println("Nowa ListComponents:  "+listaPSCPS);
        }
        // System.out.println("Nowa ListComponents_2:  "+listaPSCPSbyCustomer.toString());
        return listaPSCPSbyCustomer;
    }
}
