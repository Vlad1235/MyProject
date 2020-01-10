package com.project.contactstorage.SupplierContactStorage.rest;


import com.project.contactstorage.SupplierContactStorage.entity.Supplier;
import com.project.contactstorage.SupplierContactStorage.service.SupplierService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SupplierRestController {

        private SupplierService theSupplierSurvice;

    @Autowired
    public SupplierRestController(SupplierService theSupplierSurvice) {
        this.theSupplierSurvice = theSupplierSurvice;
    }

    @ApiOperation(
            value = "Retrieve all supplier in stored in database",
            notes="Provide information in the list format about suppliers that are in database",
            response = Contact.class)
    @GetMapping("/suppliers")
    public List<Supplier> findAll(){
        return theSupplierSurvice.getSuppliers();
    }


    @ApiOperation(
            value = "Retrieve supplier via its Id",
            notes="Provide information about the specific supplier",
            response = Contact.class)
    @GetMapping("/supplier/{supplierId}")
    public Supplier getSupplier(@PathVariable int supplierId){
        Supplier theSupplier = theSupplierSurvice.findById(supplierId);

        // проверяем на возможные ошибки и на наличие в базе
        if (theSupplier == null || (supplierId>findAll().size()) || (supplierId<0)) {
            throw new SupplierNotFoundException("Данного поставщика нет в базе данных");
        }
        return theSupplier;
    }

    @ApiOperation(
            value = "Save a new supplier to database",
            notes="Saving supplier and have a echo with a information about its new provided Id",
            response = Contact.class)
    @PostMapping("/supplier")
    public Supplier addSupplier(@RequestBody Supplier theSupplier){

        // для использования метода saveOrUpdate() если передаем 0 то, это новый поставщик и будет запись в БД
        theSupplier.setId(0);
        theSupplierSurvice.saveSupplier(theSupplier);

        return theSupplier;
    }

    @ApiOperation(
            value = "Delete supplier via its Id",
            notes="Delete supplier from database",
            response = Contact.class)
    @DeleteMapping("/supplier/{supplierId}")
    public String deleteSupplier(@PathVariable int supplierId){
        Supplier temporalVariable = theSupplierSurvice.findById(supplierId);

        if (temporalVariable==null){
            throw new SupplierNotFoundException("Поставщика с указанным Id нет");
        }
        theSupplierSurvice.deleteSupplier(supplierId);

        return "Поставщик успешно удален";
    }

    @ApiOperation(
            value = "Update an information of a specific supplier already stored in database",
            notes="Updating information and then have a echo feedback with a new data relating to this supplier",
            response = Contact.class)
    @PutMapping("/supplier")
    public Supplier updateSupplier(@RequestBody Supplier theSupplier){

        theSupplierSurvice.saveSupplier(theSupplier);

        // эхо ответ получим
        return theSupplier;
    }
}
