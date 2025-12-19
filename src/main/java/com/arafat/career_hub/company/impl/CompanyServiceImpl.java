package com.arafat.career_hub.company.impl;

import com.arafat.career_hub.company.Company;
import com.arafat.career_hub.company.CompanyRepository;
import com.arafat.career_hub.company.CompanyService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {
    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> findAllCompany() {
        return companyRepository.findAll();
    }
}
