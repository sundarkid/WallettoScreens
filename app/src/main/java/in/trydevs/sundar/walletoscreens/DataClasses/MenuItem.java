package in.trydevs.sundar.walletoscreens.DataClasses;

/**
 * Created by Yash on 20-02-2016.
 */
public class MenuItem {
    String name;
    String image;
    String price;
    String recipe;

    public MenuItem(){

    }

    public MenuItem(String name, String price, String image,String recipe){
        this.name = name;
        this.price = price;
        this.image = image;
        this.recipe = recipe;
    }

    public String getRecipe() {
        return recipe;
    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
