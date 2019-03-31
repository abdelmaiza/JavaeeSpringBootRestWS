package com.wiredbrain.friends.model;

import javax.persistence.*;
import java.util.Date;

@Embeddable
public class Degree {
    private String degreeName;
    private Date obtainedDate;

    public String getDegreeName() {
        return degreeName;
    }

    public void setDegreeName(String degreeName) {
        this.degreeName = degreeName;
    }

    public Date getObtainedDate() {
        return obtainedDate;
    }

    public void setObtainedDate(Date obtainedDate) {
        this.obtainedDate = obtainedDate;
    }
}
