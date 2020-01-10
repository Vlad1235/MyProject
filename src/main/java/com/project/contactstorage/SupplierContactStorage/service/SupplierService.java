package com.project.contactstorage.SupplierContactStorage.service;

import com.project.contactstorage.SupplierContactStorage.entity.Supplier;

import java.util.List;

public interface SupplierService {
    public List<Supplier> getSuppliers();

    public void saveSupplier(Supplier theSupplier);

    public Supplier findById(int theId);

    public void deleteSupplier(int theId);
}
