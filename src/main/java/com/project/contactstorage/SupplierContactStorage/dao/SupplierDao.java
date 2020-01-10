package com.project.contactstorage.SupplierContactStorage.dao;

import com.project.contactstorage.SupplierContactStorage.entity.Supplier;

import java.util.List;

public interface SupplierDao {
    public List<Supplier> getSuppliers();

    public void saveSupplier(Supplier theSupplier);

    public Supplier findById(int theId);

    public void deleteSupplier(int theId);
}
