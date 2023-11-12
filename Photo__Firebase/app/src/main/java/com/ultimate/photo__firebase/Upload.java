package com.ultimate.photo__firebase;

public class Upload {
    private String Name;
    private String Url;
    private String Description;

    public Upload(){
        //empty constructor needed
    }

    public Upload(String name, String url){
        if (name.trim().equals("")){ name = "No Name"; }
        Name = name;
        Url = url;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getUrl() {
        return Url;
    }
    public void setUrl(String url) {
        Url = url;
    }
    public String getDescription() { return Description; }
    public void setDescription(String description) { Description = description; }
}
