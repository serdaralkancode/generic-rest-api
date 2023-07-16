package tr.salkan.code.java.genericApi.product.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tr.salkan.code.java.genericApi.generic.controller.GenericController;
import tr.salkan.code.java.genericApi.product.dto.ProductDTO;
import tr.salkan.code.java.genericApi.product.model.Product;
import tr.salkan.code.java.genericApi.product.service.IProductService;

@RestController
@RequestMapping("product-controller")
public class ProductController extends GenericController<Product, Long, ProductDTO, IProductService> {



    //NO CODE
}
