package br.com.ada.bookstore.model;

import java.time.LocalDate;

public class Customer {
    private String name;
    private String rg;
    private String cpf;
    private LocalDate birthdate;

    public Customer(String name, String rg, String cpf, LocalDate birthdate) {
        this.name = name;
        this.rg = rg;
        this.cpf = cpf;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", rg='" + rg + '\'' +
                ", cpf='" + cpf + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
