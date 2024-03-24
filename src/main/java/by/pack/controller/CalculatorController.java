package by.pack.controller;


import by.pack.dto.OperationDto;
import by.pack.entity.Operation;
import by.pack.entity.SessionUser;
import by.pack.service.CalculatorService;
import by.pack.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/calc")
public class CalculatorController {


    @Autowired
    private CalculatorService calculatorService;

    @Autowired
    private OperationService operationService;

    @GetMapping
    public String calc(Model model){
        model.addAttribute("newOperationDto", new OperationDto());
        return "calc";
    }

    @PostMapping
    public String calc(@ModelAttribute("newOperationDto") @Valid OperationDto operationDto,
                       BindingResult bindingResult,
                       HttpSession httpSession,
                       Model model){
        if(bindingResult.hasErrors()){
            return "cacl";
        }
        if(httpSession.getAttribute("userSession") != null){
            SessionUser sessionUser = (SessionUser) httpSession.getAttribute("userSession");
            operationDto.setUserId(sessionUser.getId());
            System.out.println(sessionUser);
        }
        else{
            operationDto.setUserId(0);
        }
        Optional<Operation> operation = calculatorService.calculate(operationDto);

        if(operation.isPresent()){
            model.addAttribute("result", operation.get().getResult());
            return "calc";
        }
        return "calc";
    }

}
