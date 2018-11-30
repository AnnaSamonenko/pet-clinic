package com.samonenko.petclinic.controllers;

import com.samonenko.petclinic.model.Owner;
import com.samonenko.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping("/find")
    public String initFindForm(Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping
    public String proccessFindForm(Owner owner, BindingResult result, Model model) {
        if (owner.getLastName() == null)
            owner.setLastName("");

        List<Owner> results = ownerService.findAllByLastNameLike(owner.getLastName());

        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        } else if (results.size() == 1) {
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        } else {
            model.addAttribute("selections", results);
            return "owners/";
        }
    }

    @GetMapping("/{id}")
    public ModelAndView ownersDetailsPage(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(id));
        return mav;
    }

}
