package com.gg.example.springExample.web;

import com.gg.example.springExample.model.*;
import com.gg.example.springExample.service.PetClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * User: adurmaz
 * Date: 5/11/13
 * Time: 4:40 PM
 */
@Controller
public class PetClinicServiceRestImpl implements PetClinicService {

    @Autowired
    private PetClinicService petClinicService;

    @Override
    @RequestMapping("/vet")
    public @ResponseBody Collection<Vet> getVets() {
        return petClinicService.getVets();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/owner")
    public @ResponseBody Collection<Owner> findOwners(@RequestBody String lastName) {
        return petClinicService.findOwners(lastName);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/visit/{petId}")
    public @ResponseBody Collection<Visit> findVisits(@PathVariable("petId") long petId) {
        return petClinicService.findVisits(petId);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/person")
    public @ResponseBody Collection<Person> findAllPersons() {
        return petClinicService.findAllPersons();  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/owner/{ownerId}")
    public @ResponseBody Owner loadOwner(@PathVariable("ownerId") long id) {
        return petClinicService.loadOwner(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/pet/{pedId}")
    public @ResponseBody Pet loadPet(@PathVariable("petId") long id) {
        return petClinicService.loadPet(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping("/vet/{vetId}")
    public @ResponseBody Vet loadVet(@PathVariable("vetId") long id) {
        return petClinicService.loadVet(id);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping(value = "/owner", method = RequestMethod.POST)
    public @ResponseBody long saveOwner(@RequestBody Owner owner) {
        return petClinicService.saveOwner(owner);  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    @RequestMapping(value = "/vet", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public void saveVet(@RequestBody Vet vet) {
        petClinicService.saveVet(vet);
    }

    @Override
    @RequestMapping(value = "/owner/{ownerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteOwner(@PathVariable("ownerId") long ownerId) {
        petClinicService.deleteOwner(ownerId);
    }

    @ExceptionHandler(Exception.class)
    public void handle(Exception e) {
        e.printStackTrace();
    }
}
