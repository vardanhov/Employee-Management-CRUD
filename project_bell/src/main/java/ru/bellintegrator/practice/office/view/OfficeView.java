package ru.bellintegrator.practice.office.view;


import com.fasterxml.jackson.annotation.JsonInclude;




public class OfficeView {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public long id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String address;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public boolean isActive;

    public OfficeView() {
    }

    public OfficeView(long id, String name, String address, String phone, boolean isActive) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.isActive = isActive;
    }
}
