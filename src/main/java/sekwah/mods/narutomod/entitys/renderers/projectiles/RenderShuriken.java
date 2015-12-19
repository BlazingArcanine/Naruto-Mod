package sekwah.mods.narutomod.entitys.renderers.projectiles;

import sekwah.mods.narutomod.entitys.projectiles.EntityShuriken;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

@SideOnly(Side.CLIENT)
public class RenderShuriken extends Render {
    private static final ResourceLocation entityTexture = new ResourceLocation("narutomod:textures/entitys/shuriken_entity.png");

    public void renderShuriken(EntityShuriken par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.bindEntityTexture(par1Entity);
        GL11.glPushMatrix();
        GL11.glTranslatef((float) par2, (float) par4, (float) par6);
        GL11.glRotatef(par1Entity.prevRotationYaw + (par1Entity.rotationYaw - par1Entity.prevRotationYaw) * par9 - 90.0F, 0.0F, 1.0F, 0.0F);
        GL11.glRotatef(par1Entity.prevRotationPitch + (par1Entity.rotationPitch - par1Entity.prevRotationPitch) * par9, 0.0F, 0.0F, 1.0F);
        Tessellator tessellator = Tessellator.instance;
        byte b0 = 0;
        float f2 = 0.0F;
        float f3 = 0.5F;
        float f4 = (float) (0 + b0 * 10) / 32.0F;
        float f5 = (float) (5 + b0 * 10) / 32.0F;
        float f6 = 0.0F;
        float f7 = 0.15625F;
        float f8 = (float) (5 + b0 * 10) / 32.0F;
        float f9 = (float) (10 + b0 * 10) / 32.0F;
        float f10 = 0.10625F;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        float f11 = (float) par1Entity.arrowShake - par9;

        if (f11 > 0.0F) {
            float f12 = -MathHelper.sin(f11 * 3.0F) * f11;
            GL11.glRotatef(f12, 0.0F, 0.0F, 1.0F);
        }

        GL11.glRotatef(45.0F, 1.0F, 0.0F, 0.0F);
        GL11.glScalef(f10, f10, f10);
        GL11.glTranslatef(-4.0F, 0.0F, 0.0F);
        GL11.glNormal3f(f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(3.5D, -2.0D, -2.0D, (double) f6, (double) f8);
        tessellator.addVertexWithUV(3.5D, -2.0D, 2.0D, (double) f7, (double) f8);
        tessellator.addVertexWithUV(3.5D, 2.0D, 2.0D, (double) f7, (double) f9);
        tessellator.addVertexWithUV(3.5D, 2.0D, -2.0D, (double) f6, (double) f9);
        tessellator.draw();
        GL11.glNormal3f(-f10, 0.0F, 0.0F);
        tessellator.startDrawingQuads();
        tessellator.addVertexWithUV(3.5D, 2.0D, -2.0D, (double) f6, (double) f8);
        tessellator.addVertexWithUV(3.5D, 2.0D, 2.0D, (double) f7, (double) f8);
        tessellator.addVertexWithUV(3.5D, -2.0D, 2.0D, (double) f7, (double) f9);
        tessellator.addVertexWithUV(3.5D, -2.0D, -2.0D, (double) f6, (double) f9);
        tessellator.draw();

        for (int i = 0; i < 4; ++i) {
            GL11.glRotatef(90.0F, 1.0F, 0.0F, 0.0F);
            GL11.glNormal3f(0.0F, 0.0F, f10);
            tessellator.startDrawingQuads();
            tessellator.addVertexWithUV(-8.0D, -2.0D, 0.0D, (double) f2, (double) f4);
            tessellator.addVertexWithUV(8.0D, -2.0D, 0.0D, (double) f3, (double) f4);
            tessellator.addVertexWithUV(8.0D, 2.0D, 0.0D, (double) f3, (double) f5);
            tessellator.addVertexWithUV(-8.0D, 2.0D, 0.0D, (double) f2, (double) f5);
            tessellator.draw();
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    protected ResourceLocation entityTexture(EntityShuriken par1EntityShuriken) {
        return entityTexture;
    }

    protected ResourceLocation getEntityTexture(Entity par1Entity) {
        return this.entityTexture((EntityShuriken) par1Entity);
    }

    /**
     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is common
     * (Render<T extends Entity) and this method has signature public void doRender(T entity, double d, double d1,
     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
     */
    public void doRender(Entity par1Entity, double par2, double par4, double par6, float par8, float par9) {
        this.renderShuriken((EntityShuriken) par1Entity, par2, par4, par6, par8, par9);
    }
}