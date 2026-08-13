package org.ibm.oops;

public class FileDocument implements Persistable {

    private String filePath;

    public FileDocument(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save() {
        System.out.println("Saving document to file: " + filePath);
        // Implement logic to save the document to a file
    }

    @Override
    public void load() {
        System.out.println("Loading document from file: " + filePath);
        // Implement logic to load the document from a file
    }

    @Override
    public void delete() {
        System.out.println("Deleting document from file: " + filePath);
        // Implement logic to delete the document from a file
    }

}
