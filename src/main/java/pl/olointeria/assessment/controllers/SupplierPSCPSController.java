package pl.olointeria.assessment.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.olointeria.assessment.component.ComponentPSCPS;
import pl.olointeria.assessment.component.ComponentPSAPT;
import pl.olointeria.assessment.component.ComponentPSCPSRepository;
import pl.olointeria.assessment.component.ComponentPSAPTRepository;
import pl.olointeria.assessment.component.ComponentRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import pl.olointeria.assessment.prima.*;

import javax.xml.XMLConstants;

@Controller
public class SupplierPSCPSController {
    @Autowired

    private SupplierPSCPSRepository repo;
    @Autowired
    private ComponentPSCPSRepository  componentPSCPSRepo;

    @Autowired
    private ComponentPSAPTRepository  componentPSAPTRepo;

    @Autowired
    private ComponentRepository  componentRepo;



    @GetMapping("/suppliersPSCPS")
    public String listSuppliers(Model model){
        List<SupplierPSCPS> listSuppliers = repo.findAll();

        model.addAttribute("listSuppliers",listSuppliers);


        return "supplier/suppliersPSCPS";
    }
    @GetMapping("/suppliersPSCPS/show2/{classification}")
    public  String showListSupWithClassification(@PathVariable("classification") String classification, Model model) {
        List<SupplierPSCPS> listSupPSCPSWhith_Class = repo.findAll();
        System.out.println("wydruk dla wartości classification"+classification);
        System.out.println("wydruk dla wartości classification to String "+classification.toString());
        System.out.println("sprawdzenie jak traktuje classification. toUpper" + classification.toUpperCase() );
        List<SupplierPSCPS> listaPSCPSwithClass = nowalistaPSCPSwithClass(listSupPSCPSWhith_Class, classification.toString() );
        model.addAttribute("listaPSCPSwithClass", listaPSCPSwithClass);
        model.addAttribute("classification", classification);
        return "supplier/suppliersPSCPSWithClass";
    }

    private List<SupplierPSCPS> nowalistaPSCPSwithClass(List<SupplierPSCPS> listComponentsPSCPSWhith_class, String classification) {
        List<SupplierPSCPS> listSppliers2 = new ArrayList<>();
        for (SupplierPSCPS supplierPSCPS : listComponentsPSCPSWhith_class
        ) {
            String classifi_2  =supplierPSCPS.getClassification();

            if (classifi_2.equals(classification)) {
                int i = 1;
                i++;
                  listSppliers2.add(supplierPSCPS);
            }
        }
        return listSppliers2;
    }

    @GetMapping("/suppliersPSCPS/show/{id_Sap}")
    public  String showEditComponentForm(@PathVariable("id_Sap") String id_Sap, Model model){

        List<ComponentPSCPS> listComponentsPSCPSWhith_Id_Sap = componentPSCPSRepo.findAll();
        List<ComponentPSCPS> listaPSCPS = nowalistaPSCPS(listComponentsPSCPSWhith_Id_Sap, id_Sap );//podaje listę Componnetów które mają id_Sap równe id_Sap jak Supplier

        List<SupplierPSCPS>       listSppliers   =     repo.findAll(); // lista wszystkich Suppliers
        List<SupplierPSCPS>   listSppliers2 =   nowalista2(listSppliers, id_Sap );
        String supplierName2 =  listSppliers2.stream().findFirst().get().getName();// podaje pierwszy element
        Long supplierTotalScore =  listSppliers2.stream().findFirst().get().getTotalScore();
        String supplierClass =  listSppliers2.stream().findFirst().get().getClassification();
        System.out.println("supplierTotalScore:"+supplierTotalScore.toString());
           System.out.println("SupplierName2:"+supplierName2);
              model.addAttribute("supplierName2", supplierName2);
        model.addAttribute("supplierTotalScore", supplierTotalScore);
        model.addAttribute("supplierClass", supplierClass);
        if(!listaPSCPS.isEmpty() && listaPSCPS !=null){
            model.addAttribute("listPSCPSComponents", listaPSCPS);
                    }else System.out.println("listaPSCPS  jest pusta");

        return "component/components_PSCPS_SapSUPPLIER.html";
    }

    private List<SupplierPSCPS> nowalista2(List<SupplierPSCPS> listSppliers, String id_Sap) {
        List<SupplierPSCPS> listSppliers2 = new ArrayList<>();
        for (SupplierPSCPS supplier : listSppliers
        ) {
            String id_sap = supplier.getId_Sap();
            if (id_sap.toString().equals(id_Sap.toString())) {
                int i = 1;
                i++;
                listSppliers2.add(supplier);
            }
        }
        return listSppliers2;
    }

    private List<ComponentPSCPS> nowalistaPSCPS(List<ComponentPSCPS> lista, String id_Sap) {
        List<ComponentPSCPS> listaPSCPS =new ArrayList<>();
         for (ComponentPSCPS component:lista
        ) {
            String id_sap = component.getId_Sap();
            if (id_sap.toString().equals(id_Sap.toString())){
                int i=1;i++;
                listaPSCPS.add(component);
            }
      }
         return listaPSCPS;
    }



    private List<ComponentPSAPT> nowalistaPSAPT(List<ComponentPSAPT> lista, String id_Sap) {
        List<ComponentPSAPT> listaPSAPT =new ArrayList<>();
        for (ComponentPSAPT component:lista
        ) {
            String id_sap = component.getId_Sap();
              if (id_sap.toString().equals(id_Sap.toString())){
                int i=1;i++;
                listaPSAPT.add(component);
            }
        }
        return listaPSAPT;
    }




    @GetMapping("/suppliersPSCPS/new")
    public String showCategoryNewForm(Model model){

        model.addAttribute("category",new SupplierPSCPS());
        return "suppliers_pscps_form";
    }

    @PostMapping("/suppliersPSCPS/save")
    public String saveCategory(SupplierPSCPS category){
        repo.save(category);
        return "redirect:supplier/suppliersPSCPS";

    }
    @RequestMapping(value="classificationPSCPS", method = RequestMethod.GET)
    public String classificationPSCPS(Model model) {

        return "supplier/chartPSCPS";
    }
    @RequestMapping(value="getClassificationPSCPS", method = RequestMethod.GET)
    public String getClassificationPSCPS(Model model) {

        return "supplier/getClassificationPSCPS";
    }

    @RequestMapping(value={"/classification/classific","/suppliersPSCPS/classification/classific"})
    public String classification(Model model) {
               return "classification/classific";
    }
    @RequestMapping(value={"/classification/ppm","/suppliersPSCPS/classification/ppm"})
    public String ppm(Model model) {
        return "classification/ppm";}

    @RequestMapping(value={"/classification/certificate","/suppliersPSCPS/classification/certificate"})
        public String certificate(Model model) {
            return "classification/certificate";
        }
     @RequestMapping(value={"/classification/approval","/suppliersPSCPS/classification/approval"})
    public String approval(Model model) {
        return "classification/approval";
    }
    @RequestMapping(value={"/classification/audit_result","/suppliersPSCPS/classification/audit_result"})
    public String audit_result(Model model) {
        return "classification/audit_result";
    }
    @RequestMapping(value={"/classification/pscr","/suppliersPSCPS/classification/pscr"})
    public String pscr(Model model) {
        return "classification/pscr";
    }
    @RequestMapping(value={"/classification/location","/suppliersPSCPS/classification/location"})
    public String location(Model model) {
        return "classification/location";
    }
    @RequestMapping(value={"/classification/delays","/suppliersPSCPS/classification/delays"})
    public String delays(Model model) {
        return "classification/delays";
    }

    @GetMapping(value={"/classification/interference","/suppliersPSCPS/classification/interference"})
    public String interference(Model model) {
        return "classification/interference";
    }
    @RequestMapping(value={"/classification/collaboration","/suppliersPSCPS/classification/collaboration"})
    public String collaboration(Model model) {
        return "classification/collaboration";
    }
    @RequestMapping(value={"/classification/average_score","/suppliersPSCPS/classification/average_score"})
    public String average_score(Model model) {
        return "classification/average_score";
    }
}

