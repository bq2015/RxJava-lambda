package com.bq2015;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenD {

    private static Schema schema;

    public static void main(String[] args) throws Exception {
        schema = new Schema(1, "com.bq2015.greendaopractice");
        addPerson();
        new DaoGenerator().generateAll(schema,"../MyApplication/app/src/main/java-gen");
    }

    private static void addPerson() {
        Entity person = schema.addEntity("Person");
        person.addIdProperty().primaryKey();
        person.addStringProperty("name").notNull();
        person.addStringProperty("sex").columnName("_sex");
    }
}
