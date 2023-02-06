package com.example.museum4life;

public class Item {
    String Name, Description, imageUrl;

    public Item(){}

    public Item(String name, String description, String image) {
        Name = name;
        Description = description;
        imageUrl = image;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
