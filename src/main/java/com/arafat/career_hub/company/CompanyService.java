package com.arafat.career_hub.company;

import java.util.List;

public interface CompanyService {

    List<Company> findAllCompany();

    void createCompany(Company company);

    Company getCompanyById(Long id);

    Boolean updateCompany(Long id, Company updatedCompany);

    Boolean deleteCompany(Long id);
}
