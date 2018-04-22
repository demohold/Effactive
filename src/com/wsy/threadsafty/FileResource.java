package com.wsy.threadsafty;

public class FileResource {
    private int size;
    private String name;
    public int getSize() {

        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /****
     *
     * */
    public synchronized void updateFile(){
        System.out.println("update file");
    }
    public synchronized void appendFile(FileResource resource){
        System.out.println("addResource");
        resource.updateFile();
    }
}
