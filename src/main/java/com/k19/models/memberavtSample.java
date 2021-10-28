package com.k19.models;

import javax.persistence.Entity;
import javax.persistence.Table;

//Sample entity
@Entity(name = "memberavtSample")
@Table(name = "memberavtSample")
public class memberavtSample {
    public class Employee {
        private String name;

        private String avt;

        // constructors
        public void memberavtSample() {
            this.name = "Default name";
            this.avt = "Default avt";
        }

        // standard getters and setters.
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAvt() {
            return avt;
        }

        public void setAvt(String avt) {
            this.avt = avt;
        }

    }
}
