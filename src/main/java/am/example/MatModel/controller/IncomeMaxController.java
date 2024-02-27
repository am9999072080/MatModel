package am.example.MatModel.controller;


import am.example.MatModel.service.Impl.IncomeMaxServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/max")
public class IncomeMaxController {
    private final IncomeMaxServiceImpl service;

    public IncomeMaxController(IncomeMaxServiceImpl service) {
        this.service = service;
    }


    @Operation(summary = "Getting maximum income")
    @GetMapping("/mat")
    public String mat(@RequestParam int productQuantity,
                      @RequestParam int amountOfResources,
                      @RequestParam double[][] materialConsumptionInTheProduct,
                      @RequestParam double[] volumeOfMaterialByType,
                      @RequestParam double[] productRevenueByType) {
        return service.findMaxIncomeWithMinimumExpenses(productQuantity,
                amountOfResources, materialConsumptionInTheProduct,
                volumeOfMaterialByType, productRevenueByType);
    }
}
