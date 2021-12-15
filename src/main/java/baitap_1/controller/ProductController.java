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

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("")
public class ProductController {
    private final IProductService productService = new ProductService();

    @GetMapping("")
    public String home(Model model,String search) {
        List<Product> products = new ArrayList<>();
        if (search == null) {
            search = "";
        }
        if (search.equals("")) {
            products= productService.findAll();
        }else {
            products= productService.findByName(search);
        }
        model.addAttribute("products", products);
        return "home";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("create", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable int id) {
        model.addAttribute("product", productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product) {
        productService.update(product.getId(), product);
        return "redirect:/";
    }

    @GetMapping("{id}/delete")
    public String delete(@PathVariable int id) {
        productService.remove(id);
        return "redirect:/";
    }

    @GetMapping("{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "view";
    }
}
