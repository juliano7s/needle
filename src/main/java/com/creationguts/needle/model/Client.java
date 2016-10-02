package com.creationguts.needle.model;

import java.util.Objects;
import java.util.Set;

/**
 * Class to represent a client.
 * Created by Juliano on 10/1/16.
 */
public class Client extends BaseVO {

    private String name;
    private String cpf;
    private Set<String> phoneNumbers;
    private Set<String> adresses;

    public Client() {
        this(0);
    }

    public Client(long id) {
        super(id);
    }

    public Client(String name, String cpf) {
        this(0, name, cpf);
    }

    public Client(long id, String name, String cpf) {
        this(id);
        this.name = name;
        this.cpf = cpf;
    }

    @Override
    public Object clone() {
        Client clone = new Client();
        clone.setId(this.getId());
        clone.setName(this.getName());
        clone.setCpf(this.getCpf());
        clone.setAdresses(this.getAdresses());
        clone.setPhoneNumbers(this.getPhoneNumbers());
        return clone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Set<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Set<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public Set<String> getAdresses() {
        return adresses;
    }

    public void setAdresses(Set<String> adresses) {
        this.adresses = adresses;
    }
}
