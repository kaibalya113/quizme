package com.example.quiz;

public class CategoryModel {
    private String categoryId;
    private String categoryName;
    private String categoryImage;

    public CategoryModel(String categoryId, String categoryName, String categoryImage) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public CategoryModel(){}

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(String categoryImage) {
        this.categoryImage = categoryImage;
    }

    //toString

    @Override
    public String toString() {
        return "CategoryModel{" +
                "categoryId='" + categoryId + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", categoryImage='" + categoryImage + '\'' +
                '}';
    }
}
