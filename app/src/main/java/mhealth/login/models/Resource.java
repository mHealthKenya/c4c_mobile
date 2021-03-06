package mhealth.login.models;

import java.io.Serializable;
import java.util.ArrayList;

public class Resource implements Serializable {
    private int id;
    private String title;
    private String body;
    private String file;
    private String created_at;
    private ArrayList<ResourceFile> resourceFiles;

    public Resource(int id, String title, String body, String file, String created_at, ArrayList<ResourceFile> resourceFiles) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.file = file;
        this.created_at = created_at;
        this.resourceFiles = resourceFiles;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public ArrayList<ResourceFile> getResourceFiles() {
        return resourceFiles;
    }

    public void setResourceFiles(ArrayList<ResourceFile> resourceFiles) {
        this.resourceFiles = resourceFiles;
    }
}
