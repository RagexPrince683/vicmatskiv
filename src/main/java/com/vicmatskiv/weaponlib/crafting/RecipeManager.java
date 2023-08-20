package com.vicmatskiv.weaponlib.crafting;

import net.minecraft.item.*;
import java.util.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import org.apache.logging.log4j.*;

public class RecipeManager
{
    private static final Logger logger;
    private RecipeGenerator recipeGenerator;
    private Map<Item, List<Object>> recipes;
    
    public RecipeManager() {
        super();
        this.recipeGenerator = new RecipeGenerator();
        this.recipes = new HashMap<Item, List<Object>>();
    }
    
    public List<Object> createShapedRecipe(final Item item, final String name, final OptionsMetadata optionsMetadata) {
        final List<Object> recipe = this.recipeGenerator.createShapedRecipe(name, optionsMetadata);
        if (this.recipes.put(item, recipe) != null) {
            RecipeManager.logger.warn("Duplicate recipe registered for item {}", new Object[] { item });
        }
        return recipe;
    }
    
    public List<Object> registerShapedRecipe(final Item item, final Object... recipe) {
        return this.registerShapedRecipe(new ItemStack(item), recipe);
    }
    
    public List<Object> registerShapedRecipe(final ItemStack itemStack, final Object... recipe) {
        final List<Object> recipeAslist = new ArrayList<Object>(recipe.length);
        boolean hasOres = false;
        for (Object option : recipe) {
            if (option instanceof CompatibleBlocks) {
                option = ((CompatibleBlocks)option).getBlock();
            }
            else if (option instanceof CompatibleItems) {
                option = ((CompatibleItems)option).getItem();
            }
            else if (option instanceof String) {
                hasOres = true;
            }
            recipeAslist.add(option);
        }
        if (hasOres) {
            CompatibilityProvider.compatibility.addShapedOreRecipe(itemStack, recipeAslist.toArray());
        }
        else {
            CompatibilityProvider.compatibility.addShapedRecipe(itemStack, recipeAslist.toArray());
        }
        if (this.recipes.put(itemStack.getItem(), recipeAslist) != null) {
            RecipeManager.logger.warn("Duplicate recipe registered for item {}", new Object[] { itemStack.getItem() });
        }
        return recipeAslist;
    }
    
    public List<Object> getRecipe(final Item item) {
        return this.recipes.get(item);
    }
    
    static {
        logger = LogManager.getLogger((Class)RecipeManager.class);
    }
}
