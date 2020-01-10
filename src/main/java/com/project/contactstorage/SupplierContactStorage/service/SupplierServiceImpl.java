package com.project.contactstorage.SupplierContactStorage.service;

import com.project.contactstorage.SupplierContactStorage.dao.SupplierDao;
import com.project.contactstorage.SupplierContactStorage.entity.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {

    private SupplierDao theSupplierDao;

    @Autowired
    public SupplierServiceImpl(SupplierDao theSupplierDao) {
        this.theSupplierDao = theSupplierDao;
    }


    @Override
    @Transactional
    public List<Supplier> getSuppliers() {
        return theSupplierDao.getSuppliers();
    }

    @Override
    @Transactional
    public void saveSupplier(Supplier theSupplier) {
        theSupplierDao.saveSupplier(theSupplier);
    }

    @Override
    @Transactional
    public Supplier findById(int theId) {
        return theSupplierDao.findById(theId);
    }

    @Override
    @Transactional
    public void deleteSupplier(int theId) {
        theSupplierDao.deleteSupplier(theId);
    }
}
