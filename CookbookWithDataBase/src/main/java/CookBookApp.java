import java.util.Optional;

public class CookBookApp {
    private static final RecipeDao DAO = new RecipeDao();

    public static void main(String[] args) {
        create();
        update();
    }

    private static void update() {
        Recipe recipe = DAO.findByTitle("Rosół").get();
        recipe.setPrepTime(666);
        DAO.update(recipe);
    }

    private static void create() {
        Recipe recipe = new Recipe("a","b","c",1);
        DAO.save(recipe);
    }
}
