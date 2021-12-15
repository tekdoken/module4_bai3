package baitap_1.controller;


import baitap_1.model.Product;
import baitap_1.service.IProductService;
import baitap_1.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import thuchanh1.model.Customer;
import thuchanh1.service.CustomerService;
import thuchanh1.service.ICustomerService;

import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String home(Model model){
        List<Product> products=productService.findAll();
        model.addAttribute("products",products);
        return "home";
    }
//    @GetMapping("/create")
//    public String create(Model model){
//        model.addAttribute("create",)
//    }
}
