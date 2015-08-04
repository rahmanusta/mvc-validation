package org.istanbuljug;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;
import java.util.Date;

/**
 * Created by usta on 02.08.2015.
 */
@Named
@RequestScoped
public class PersonBean {

    @NotEmpty
    @FormParam("name")
    private String name;

    @NotEmpty
    @Email
    @FormParam("email")
    private String email;

    @Min(0) @Max(120)
    @FormParam("age")
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
