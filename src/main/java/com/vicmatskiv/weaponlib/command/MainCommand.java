package com.vicmatskiv.weaponlib.command;

import net.minecraft.command.*;
import com.vicmatskiv.weaponlib.compatibility.*;
import net.minecraft.entity.*;
import com.vicmatskiv.weaponlib.*;
import net.minecraft.item.*;
import net.minecraft.block.*;
import java.util.*;

public class MainCommand extends CompatibleCommand
{
    private static final String SHOW_OPTION_RECIPE = "recipe";
    private static final String SHOW_OPTION_ATTACHMENTS = "attachments";
    private static final String ARG_SHOW = "show";
    private String modId;
    private String mainCommandName;
    private ModContext modContext;
    
    public MainCommand(final String modId, final ModContext modContext) {
        super();
        this.modId = modId;
        this.modContext = modContext;
        this.mainCommandName = modId;
    }
    
    public String getCompatibleName() {
        return this.modId;
    }
    
    public String getCompatibleUsage(final ICommandSender sender) {
        return "/" + this.mainCommandName + "<options>";
    }
    
    private String getSubCommandShowUsage() {
        return String.format("/%s %s recipe|attachments", this.mainCommandName, "show");
    }
    
    public void execCommand(final ICommandSender sender, final String[] args) {
        if (args.length > 0) {
            if ("show".indexOf(args[0].toLowerCase()) == 0) {
                this.processShowSubCommand(args);
            }
            else {
                CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getCompatibleUsage(sender));
            }
        }
        else {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getCompatibleUsage(sender));
        }
    }
    
    private void processShowSubCommand(final String[] args) {
        if (args.length < 2) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandShowUsage());
            return;
        }
        if ("recipe".indexOf(args[1].toLowerCase()) == 0) {
            this.showRecipe();
        }
        else if ("attachments".indexOf(args[1].toLowerCase()) == 0) {
            int page = 1;
            if (args.length == 3) {
                page = Integer.parseInt(args[2]);
            }
            this.showAttachments(page);
        }
        else {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), this.getSubCommandShowUsage());
        }
    }
    
    private void showAttachments(final int page) {
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)CompatibilityProvider.compatibility.clientPlayer());
        if (itemStack != null) {
            final Item item = itemStack.getItem();
            if (item instanceof AttachmentContainer) {
                final AttachmentContainer container = (AttachmentContainer)item;
                final Collection<CompatibleAttachment<? extends AttachmentContainer>> compatibleAttachments = container.getCompatibleAttachments(AttachmentCategory.BULLET, AttachmentCategory.GRIP, AttachmentCategory.MAGAZINE, AttachmentCategory.SCOPE, AttachmentCategory.SILENCER, AttachmentCategory.SKIN);
                final List<CompatibleAttachment<? extends AttachmentContainer>> sorted = new ArrayList<CompatibleAttachment<? extends AttachmentContainer>>(compatibleAttachments);
                sorted.sort((c1, c2) -> c1.getAttachment().getUnlocalizedName().compareTo(c2.getAttachment().getUnlocalizedName()));
                final int pageSize = 8;
                final int offset = pageSize * (page - 1);
                if (page < 1) {
                    CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Invalid page");
                }
                else if (sorted.size() == 0) {
                    CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "No attachments found for " + item.getItemStackDisplayName(itemStack));
                }
                else if (offset < sorted.size()) {
                    CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Attachments for " + item.getItemStackDisplayName(itemStack) + ", page " + page + " of " + (int)Math.ceil(sorted.size() / (double)pageSize));
                    for (int i = offset; i < offset + pageSize && i >= 0 && i < sorted.size(); ++i) {
                        CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), " - " + sorted.get(i).getAttachment().getItemStackDisplayName((ItemStack)null));
                    }
                }
                else {
                    CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Invalid page");
                }
            }
        }
    }
    
    public int getRequiredPermissionLevel() {
        return 0;
    }
    
    private void showRecipe() {
        final ItemStack itemStack = CompatibilityProvider.compatibility.getHeldItemMainHand((EntityLivingBase)CompatibilityProvider.compatibility.clientPlayer());
        if (itemStack != null) {
            final Item item = itemStack.getItem();
            this.showRecipe(item);
        }
    }
    
    private void showRecipe(final Item item) {
        if (item != null) {
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "");
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Recipe for " + item.getItemStackDisplayName((ItemStack)null));
            final List<Object> recipe = this.modContext.getRecipeManager().getRecipe(item);
            if (recipe != null) {
                this.formatRecipe(recipe);
            }
            else {
                CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "Recipe for " + item.getItemStackDisplayName((ItemStack)null) + " not found");
            }
        }
    }
    
    private String formatRecipe(final List<Object> recipe) {
        final StringBuilder output = new StringBuilder();
        final Map<Character, Object> decoder = new HashMap<Character, Object>();
        boolean inRow = true;
        for (int i = 0; i < recipe.size(); ++i) {
            final Object element = recipe.get(i);
            if (inRow && !(element instanceof String)) {
                inRow = false;
            }
            if (!inRow && element instanceof Character && recipe.size() > i + 1) {
                Object value = recipe.get(i + 1);
                if (value instanceof Item) {
                    value = ((Item)value).getItemStackDisplayName((ItemStack)null);
                }
                else if (value instanceof Block) {
                    value = ((Block)value).getLocalizedName();
                }
                decoder.put((Character)element, value);
                ++i;
            }
        }
        CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "");
        for (int i = 0; i < recipe.size(); ++i) {
            final Object element = recipe.get(i);
            if (!(element instanceof String)) {
                break;
            }
            final StringBuilder builder = new StringBuilder();
            for (final Character c : ((String)element).toCharArray()) {
                final Object decoded = decoder.get(c);
                builder.append(String.format("[%.20s] ", (decoded != null) ? decoded : "*"));
            }
            CompatibilityProvider.compatibility.addChatMessage((Entity)CompatibilityProvider.compatibility.clientPlayer(), "" + builder.toString());
        }
        return output.toString();
    }
    
    private static /* synthetic */ int lambda$showAttachments$243(final CompatibleAttachment c1, final CompatibleAttachment c2) {
        return c1.getAttachment().getUnlocalizedName().compareTo(c2.getAttachment().getUnlocalizedName());
    }
}
