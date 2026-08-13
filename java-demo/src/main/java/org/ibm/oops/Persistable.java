package org.ibm.oops;

public interface Persistable {

    String DB_NAME = "mydatabase";

    void save();

    void load();

    void delete();

}
