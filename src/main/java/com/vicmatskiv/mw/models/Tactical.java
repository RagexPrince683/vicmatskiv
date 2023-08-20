package com.vicmatskiv.mw.models;

import net.minecraft.client.model.*;
import net.minecraft.entity.*;

public class Tactical extends ModelBiped
{
    ModelRenderer head;
    ModelRenderer body;
    ModelRenderer rightarm;
    ModelRenderer leftarm;
    ModelRenderer rightleg;
    ModelRenderer leftleg;
    ModelRenderer vest1;
    ModelRenderer vest2;
    ModelRenderer vest3;
    ModelRenderer vest4;
    ModelRenderer vest5;
    ModelRenderer vest6;
    ModelRenderer vest7;
    ModelRenderer vest8;
    ModelRenderer vest9;
    ModelRenderer vest10;
    ModelRenderer helmet1;
    ModelRenderer helmet2;
    ModelRenderer helmet3;
    ModelRenderer helmet4;
    ModelRenderer helmet5;
    ModelRenderer helmet6;
    ModelRenderer helmet7;
    ModelRenderer helmet8;
    ModelRenderer helmet9;
    ModelRenderer helmet10;
    ModelRenderer helmet11;
    ModelRenderer helmet12;
    ModelRenderer helmet13;
    ModelRenderer helmet14;
    ModelRenderer helmet16;
    ModelRenderer helmet17;
    ModelRenderer helmet18;
    ModelRenderer helmet19;
    ModelRenderer helmet20;
    ModelRenderer helmet21;
    ModelRenderer helmet22;
    ModelRenderer helmet23;
    ModelRenderer helmet24;
    ModelRenderer helmet25;
    ModelRenderer helmet26;
    ModelRenderer helmet27;
    ModelRenderer helmet28;
    ModelRenderer helmet29;
    ModelRenderer helmet30;
    ModelRenderer helmet31;
    ModelRenderer helmet32;
    ModelRenderer helmet33;
    ModelRenderer helmet34;
    ModelRenderer helmet35;
    ModelRenderer helmet36;
    ModelRenderer helmet37;
    ModelRenderer helmet38;
    ModelRenderer helmet39;
    ModelRenderer helmet40;
    ModelRenderer helmet41;
    ModelRenderer helmet42;
    ModelRenderer helmet43;
    ModelRenderer helmet44;
    ModelRenderer helmet45;
    ModelRenderer helmet46;
    ModelRenderer helmet47;
    ModelRenderer helmet48;
    ModelRenderer helmet49;
    ModelRenderer helmet50;
    ModelRenderer helmet51;
    ModelRenderer helmet52;
    ModelRenderer helmet53;
    ModelRenderer helmet54;
    ModelRenderer helmet55;
    ModelRenderer helmet56;
    
    public Tactical() {
        super(0.01f, 0.0f, 512, 256);
        this.textureWidth = 512;
        this.textureHeight = 256;
        (this.head = new ModelRenderer((ModelBase)this, 0, 0)).addBox(-4.0f, -8.0f, -4.0f, 8, 8, 8);
        this.head.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.head.setTextureSize(64, 32);
        this.head.mirror = true;
        this.setRotation(this.head, 0.0f, 0.0f, 0.0f);
        (this.body = new ModelRenderer((ModelBase)this, 16, 16)).addBox(-4.0f, 0.0f, -2.0f, 8, 12, 4);
        this.body.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.body.setTextureSize(64, 32);
        this.body.mirror = true;
        this.setRotation(this.body, 0.0f, 0.0f, 0.0f);
        (this.rightarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-3.0f, -2.0f, -2.0f, 4, 12, 4);
        this.rightarm.setRotationPoint(-5.0f, 2.0f, 0.0f);
        this.rightarm.setTextureSize(64, 32);
        this.rightarm.mirror = true;
        this.setRotation(this.rightarm, 0.0f, 0.0f, 0.0f);
        (this.leftarm = new ModelRenderer((ModelBase)this, 40, 16)).addBox(-1.0f, -2.0f, -2.0f, 4, 12, 4);
        this.leftarm.setRotationPoint(5.0f, 2.0f, 0.0f);
        this.leftarm.setTextureSize(64, 32);
        this.leftarm.mirror = true;
        this.setRotation(this.leftarm, 0.0f, 0.0f, 0.0f);
        (this.rightleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.rightleg.setRotationPoint(-2.0f, 12.0f, 0.0f);
        this.rightleg.setTextureSize(64, 32);
        this.rightleg.mirror = true;
        this.setRotation(this.rightleg, 0.0f, 0.0f, 0.0f);
        (this.leftleg = new ModelRenderer((ModelBase)this, 0, 16)).addBox(-2.0f, 0.0f, -2.0f, 4, 12, 4);
        this.leftleg.setRotationPoint(2.0f, 12.0f, 0.0f);
        this.leftleg.setTextureSize(64, 32);
        this.leftleg.mirror = true;
        this.setRotation(this.leftleg, 0.0f, 0.0f, 0.0f);
        (this.vest1 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-3.0f, 4.0f, -3.5f, 6, 2, 1);
        this.vest1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest1.setTextureSize(64, 32);
        this.vest1.mirror = true;
        this.setRotation(this.vest1, 0.0f, 0.0f, 0.0f);
        (this.vest2 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-4.0f, 3.0f, -3.0f, 8, 8, 1);
        this.vest2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest2.setTextureSize(64, 32);
        this.vest2.mirror = true;
        this.setRotation(this.vest2, 0.0f, 0.0f, 0.0f);
        (this.vest3 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-3.5f, 7.0f, -3.5f, 2, 4, 1);
        this.vest3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest3.setTextureSize(64, 32);
        this.vest3.mirror = true;
        this.setRotation(this.vest3, 0.0f, 0.0f, 0.0f);
        (this.vest4 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(1.5f, 7.0f, -3.5f, 2, 4, 1);
        this.vest4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest4.setTextureSize(64, 32);
        this.vest4.mirror = true;
        this.setRotation(this.vest4, 0.0f, 0.0f, 0.0f);
        (this.vest5 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-1.0f, 7.0f, -3.5f, 2, 4, 1);
        this.vest5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest5.setTextureSize(64, 32);
        this.vest5.mirror = true;
        this.setRotation(this.vest5, 0.0f, 0.0f, 0.0f);
        (this.vest6 = new ModelRenderer((ModelBase)this, 100, 70)).addBox(-4.0f, 0.8f, -1.8f, 2, 3, 0);
        this.vest6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest6.setTextureSize(64, 32);
        this.vest6.mirror = true;
        this.setRotation(this.vest6, -0.3346075f, 0.0f, 0.0f);
        (this.vest7 = new ModelRenderer((ModelBase)this, 100, 70)).addBox(2.0f, 0.8f, -1.8f, 2, 3, 0);
        this.vest7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest7.setTextureSize(64, 32);
        this.vest7.mirror = true;
        this.setRotation(this.vest7, -0.3346075f, 0.0f, 0.0f);
        (this.vest8 = new ModelRenderer((ModelBase)this, 0, 70)).addBox(-4.0f, 4.0f, 2.0f, 8, 7, 1);
        this.vest8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest8.setTextureSize(64, 32);
        this.vest8.mirror = true;
        this.setRotation(this.vest8, 0.0f, 0.0f, 0.0f);
        (this.vest9 = new ModelRenderer((ModelBase)this, 100, 100)).addBox(-4.0f, 0.6f, 2.0f, 2, 4, 0);
        this.vest9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest9.setTextureSize(64, 32);
        this.vest9.mirror = true;
        this.setRotation(this.vest9, 0.2230717f, 0.0f, 0.0f);
        (this.vest10 = new ModelRenderer((ModelBase)this, 100, 100)).addBox(2.0f, 0.6f, 2.0f, 2, 4, 0);
        this.vest10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.vest10.setTextureSize(64, 32);
        this.vest10.mirror = true;
        this.setRotation(this.vest10, 0.2230717f, 0.0f, 0.0f);
        (this.helmet1 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.5f, -5.0f, -7.0f, 1, 1, 3);
        this.helmet1.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet1.setTextureSize(64, 32);
        this.helmet1.mirror = true;
        this.setRotation(this.helmet1, 0.0f, 0.0f, 0.0f);
        (this.helmet2 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.5f, -4.5f, -7.0f, 1, 1, 3);
        this.helmet2.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet2.setTextureSize(64, 32);
        this.helmet2.mirror = true;
        this.setRotation(this.helmet2, 0.0f, 0.0f, 0.0f);
        (this.helmet3 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.7f, -4.75f, -7.0f, 1, 1, 3);
        this.helmet3.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet3.setTextureSize(64, 32);
        this.helmet3.mirror = true;
        this.setRotation(this.helmet3, 0.0f, 0.0f, 0.0f);
        (this.helmet4 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.3f, -4.75f, -7.0f, 1, 1, 3);
        this.helmet4.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet4.setTextureSize(64, 32);
        this.helmet4.mirror = true;
        this.setRotation(this.helmet4, 0.0f, 0.0f, 0.0f);
        (this.helmet5 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.0f, -4.0f, -7.5f, 1, 1, 4);
        this.helmet5.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet5.setTextureSize(64, 32);
        this.helmet5.mirror = true;
        this.setRotation(this.helmet5, 0.0f, 0.0f, 0.0f);
        (this.helmet6 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.5f, -4.0f, -7.5f, 1, 1, 4);
        this.helmet6.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet6.setTextureSize(64, 32);
        this.helmet6.mirror = true;
        this.setRotation(this.helmet6, 0.0f, 0.0f, 0.0f);
        (this.helmet7 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.5f, -4.5f, -7.5f, 1, 1, 4);
        this.helmet7.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet7.setTextureSize(64, 32);
        this.helmet7.mirror = true;
        this.setRotation(this.helmet7, 0.0f, 0.0f, 0.0f);
        (this.helmet8 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.0f, -4.5f, -7.5f, 1, 1, 4);
        this.helmet8.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet8.setTextureSize(64, 32);
        this.helmet8.mirror = true;
        this.setRotation(this.helmet8, 0.0f, 0.0f, 0.0f);
        (this.helmet9 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.25f, -4.6f, -7.5f, 1, 1, 4);
        this.helmet9.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet9.setTextureSize(64, 32);
        this.helmet9.mirror = true;
        this.setRotation(this.helmet9, 0.0f, 0.0f, 0.0f);
        (this.helmet10 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.25f, -3.9f, -7.5f, 1, 1, 4);
        this.helmet10.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet10.setTextureSize(64, 32);
        this.helmet10.mirror = true;
        this.setRotation(this.helmet10, 0.0f, 0.0f, 0.0f);
        (this.helmet11 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.6f, -4.25f, -7.5f, 1, 1, 4);
        this.helmet11.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet11.setTextureSize(64, 32);
        this.helmet11.mirror = true;
        this.setRotation(this.helmet11, 0.0f, 0.0f, 0.0f);
        (this.helmet12 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(0.9f, -4.25f, -7.5f, 1, 1, 4);
        this.helmet12.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet12.setTextureSize(64, 32);
        this.helmet12.mirror = true;
        this.setRotation(this.helmet12, 0.0f, 0.0f, 0.0f);
        (this.helmet13 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.0f, -4.5f, -7.5f, 1, 1, 4);
        this.helmet13.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet13.setTextureSize(64, 32);
        this.helmet13.mirror = true;
        this.setRotation(this.helmet13, 0.0f, 0.0f, 0.0f);
        (this.helmet14 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.0f, -4.0f, -7.5f, 1, 1, 4);
        this.helmet14.setRotationPoint(-3.0f, 0.0f, 0.0f);
        this.helmet14.setTextureSize(64, 32);
        this.helmet14.mirror = true;
        this.setRotation(this.helmet14, 0.0f, 0.0f, 0.0f);
        (this.helmet16 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.5f, -4.0f, -7.5f, 1, 1, 4);
        this.helmet16.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet16.setTextureSize(64, 32);
        this.helmet16.mirror = true;
        this.setRotation(this.helmet16, 0.0f, 0.0f, 0.0f);
        (this.helmet17 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.5f, -4.5f, -7.5f, 1, 1, 4);
        this.helmet17.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet17.setTextureSize(64, 32);
        this.helmet17.mirror = true;
        this.setRotation(this.helmet17, 0.0f, 0.0f, 0.0f);
        (this.helmet18 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.25f, -4.6f, -7.5f, 1, 1, 4);
        this.helmet18.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet18.setTextureSize(64, 32);
        this.helmet18.mirror = true;
        this.setRotation(this.helmet18, 0.0f, 0.0f, 0.0f);
        (this.helmet19 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.25f, -3.9f, -7.5f, 1, 1, 4);
        this.helmet19.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet19.setTextureSize(64, 32);
        this.helmet19.mirror = true;
        this.setRotation(this.helmet19, 0.0f, 0.0f, 0.0f);
        (this.helmet20 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-1.9f, -4.25f, -7.5f, 1, 1, 4);
        this.helmet20.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet20.setTextureSize(64, 32);
        this.helmet20.mirror = true;
        this.setRotation(this.helmet20, 0.0f, 0.0f, 0.0f);
        (this.helmet21 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.6f, -4.25f, -7.5f, 1, 1, 4);
        this.helmet21.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet21.setTextureSize(64, 32);
        this.helmet21.mirror = true;
        this.setRotation(this.helmet21, 0.0f, 0.0f, 0.0f);
        (this.helmet22 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-1.0f, -5.1f, -6.0f, 2, 1, 2);
        this.helmet22.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet22.setTextureSize(64, 32);
        this.helmet22.mirror = true;
        this.setRotation(this.helmet22, 0.0f, 0.0f, 0.0f);
        (this.helmet23 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(0.6f, -4.7f, -6.0f, 2, 1, 2);
        this.helmet23.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet23.setTextureSize(64, 32);
        this.helmet23.mirror = true;
        this.setRotation(this.helmet23, 0.0f, 0.0f, 0.0f);
        (this.helmet24 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.6f, -4.7f, -6.0f, 2, 1, 2);
        this.helmet24.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet24.setTextureSize(64, 32);
        this.helmet24.mirror = true;
        this.setRotation(this.helmet24, 0.0f, 0.0f, 0.0f);
        (this.helmet25 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.0f, -4.9f, -6.0f, 1, 1, 2);
        this.helmet25.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet25.setTextureSize(64, 32);
        this.helmet25.mirror = true;
        this.setRotation(this.helmet25, 0.0f, 0.0f, 0.0f);
        (this.helmet26 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.0f, -4.9f, -6.0f, 1, 1, 2);
        this.helmet26.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet26.setTextureSize(64, 32);
        this.helmet26.mirror = true;
        this.setRotation(this.helmet26, 0.0f, 0.0f, 0.0f);
        (this.helmet27 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.7f, -4.5f, -6.0f, 1, 1, 2);
        this.helmet27.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet27.setTextureSize(64, 32);
        this.helmet27.mirror = true;
        this.setRotation(this.helmet27, 0.0f, 0.0f, 0.0f);
        (this.helmet28 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.7f, -4.0f, -6.0f, 1, 1, 2);
        this.helmet28.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet28.setTextureSize(64, 32);
        this.helmet28.mirror = true;
        this.setRotation(this.helmet28, 0.0f, 0.0f, 0.0f);
        (this.helmet29 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.7f, -4.0f, -6.0f, 1, 1, 2);
        this.helmet29.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet29.setTextureSize(64, 32);
        this.helmet29.mirror = true;
        this.setRotation(this.helmet29, 0.0f, 0.0f, 0.0f);
        (this.helmet30 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.7f, -4.5f, -6.0f, 1, 1, 2);
        this.helmet30.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet30.setTextureSize(64, 32);
        this.helmet30.mirror = true;
        this.setRotation(this.helmet30, 0.0f, 0.0f, 0.0f);
        (this.helmet31 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-2.8f, -4.25f, -6.0f, 1, 1, 2);
        this.helmet31.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet31.setTextureSize(64, 32);
        this.helmet31.mirror = true;
        this.setRotation(this.helmet31, 0.0f, 0.0f, 0.0f);
        (this.helmet32 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(1.8f, -4.25f, -6.0f, 1, 1, 2);
        this.helmet32.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet32.setTextureSize(64, 32);
        this.helmet32.mirror = true;
        this.setRotation(this.helmet32, 0.0f, 0.0f, 0.0f);
        (this.helmet33 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(2.2f, -4.25f, -4.2f, 1, 1, 1);
        this.helmet33.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet33.setTextureSize(64, 32);
        this.helmet33.mirror = true;
        this.setRotation(this.helmet33, 0.0f, 0.0f, 0.0f);
        (this.helmet34 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-3.2f, -4.25f, -4.2f, 1, 1, 1);
        this.helmet34.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet34.setTextureSize(64, 32);
        this.helmet34.mirror = true;
        this.setRotation(this.helmet34, 0.0f, 0.0f, 0.0f);
        (this.helmet35 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.5f, -5.3f, -5.5f, 1, 1, 2);
        this.helmet35.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet35.setTextureSize(64, 32);
        this.helmet35.mirror = true;
        this.setRotation(this.helmet35, 0.0f, 0.0f, 0.0f);
        (this.helmet36 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -8.3f, 2.5f, 8, 2, 1);
        this.helmet36.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet36.setTextureSize(64, 32);
        this.helmet36.mirror = true;
        this.setRotation(this.helmet36, 0.0f, 0.0f, 0.0f);
        (this.helmet37 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.5f, -6.0f, -5.7f, 1, 1, 1);
        this.helmet37.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet37.setTextureSize(64, 32);
        this.helmet37.mirror = true;
        this.setRotation(this.helmet37, 0.0f, 0.0f, 0.0f);
        (this.helmet38 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -6.3f, -4.5f, 8, 1, 9);
        this.helmet38.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet38.setTextureSize(64, 32);
        this.helmet38.mirror = true;
        this.setRotation(this.helmet38, 0.0f, 0.0f, 0.0f);
        (this.helmet39 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -6.3f, -4.5f, 1, 1, 9);
        this.helmet39.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet39.setTextureSize(64, 32);
        this.helmet39.mirror = true;
        this.setRotation(this.helmet39, 0.0f, 0.0f, 0.0f);
        (this.helmet40 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-0.5f, -8.3f, -4.5f, 1, 3, 8);
        this.helmet40.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet40.setTextureSize(64, 32);
        this.helmet40.mirror = true;
        this.setRotation(this.helmet40, 0.0f, 0.0f, 0.0f);
        (this.helmet41 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -8.3f, 2.5f, 1, 2, 1);
        this.helmet41.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet41.setTextureSize(64, 32);
        this.helmet41.mirror = true;
        this.setRotation(this.helmet41, 0.0f, 0.0f, 0.0f);
        (this.helmet42 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -8.3f, -2.5f, 8, 2, 1);
        this.helmet42.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet42.setTextureSize(64, 32);
        this.helmet42.mirror = true;
        this.setRotation(this.helmet42, 0.0f, 0.0f, 0.0f);
        (this.helmet43 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -8.3f, -2.5f, 1, 2, 1);
        this.helmet43.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet43.setTextureSize(64, 32);
        this.helmet43.mirror = true;
        this.setRotation(this.helmet43, 0.0f, 0.0f, 0.0f);
        (this.helmet44 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -5.3f, 1.5f, 1, 1, 1);
        this.helmet44.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet44.setTextureSize(64, 32);
        this.helmet44.mirror = true;
        this.setRotation(this.helmet44, 0.0f, 0.0f, 0.0f);
        (this.helmet45 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -4.8f, 2.0f, 1, 1, 1);
        this.helmet45.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet45.setTextureSize(64, 32);
        this.helmet45.mirror = true;
        this.setRotation(this.helmet45, 0.0f, 0.0f, 0.0f);
        (this.helmet46 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -4.3f, 2.5f, 1, 1, 1);
        this.helmet46.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet46.setTextureSize(64, 32);
        this.helmet46.mirror = true;
        this.setRotation(this.helmet46, 0.0f, 0.0f, 0.0f);
        (this.helmet47 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -3.8f, 3.0f, 1, 1, 1);
        this.helmet47.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet47.setTextureSize(64, 32);
        this.helmet47.mirror = true;
        this.setRotation(this.helmet47, 0.0f, 0.0f, 0.0f);
        (this.helmet48 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -3.8f, 3.0f, 1, 1, 1);
        this.helmet48.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet48.setTextureSize(64, 32);
        this.helmet48.mirror = true;
        this.setRotation(this.helmet48, 0.0f, 0.0f, 0.0f);
        (this.helmet49 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -4.3f, 2.5f, 1, 1, 1);
        this.helmet49.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet49.setTextureSize(64, 32);
        this.helmet49.mirror = true;
        this.setRotation(this.helmet49, 0.0f, 0.0f, 0.0f);
        (this.helmet50 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -4.8f, 2.0f, 1, 1, 1);
        this.helmet50.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet50.setTextureSize(64, 32);
        this.helmet50.mirror = true;
        this.setRotation(this.helmet50, 0.0f, 0.0f, 0.0f);
        (this.helmet51 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -5.3f, 1.5f, 1, 1, 1);
        this.helmet51.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet51.setTextureSize(64, 32);
        this.helmet51.mirror = true;
        this.setRotation(this.helmet51, 0.0f, 0.0f, 0.0f);
        (this.helmet52 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(-4.3f, -3.3f, 3.5f, 8, 1, 1);
        this.helmet52.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet52.setTextureSize(64, 32);
        this.helmet52.mirror = true;
        this.setRotation(this.helmet52, 0.0f, 0.0f, 0.0f);
        (this.helmet53 = new ModelRenderer((ModelBase)this, 0, 200)).addBox(3.3f, -3.3f, 3.5f, 1, 1, 1);
        this.helmet53.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet53.setTextureSize(64, 32);
        this.helmet53.mirror = true;
        this.setRotation(this.helmet53, 0.0f, 0.0f, 0.0f);
        (this.helmet54 = new ModelRenderer((ModelBase)this, 50, 200)).addBox(1.25f, -4.25f, -7.6f, 1, 1, 1);
        this.helmet54.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet54.setTextureSize(64, 32);
        this.helmet54.mirror = true;
        this.setRotation(this.helmet54, 0.0f, 0.0f, 0.0f);
        (this.helmet55 = new ModelRenderer((ModelBase)this, 50, 200)).addBox(-2.25f, -4.25f, -7.6f, 1, 1, 1);
        this.helmet55.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet55.setTextureSize(64, 32);
        this.helmet55.mirror = true;
        this.setRotation(this.helmet55, 0.0f, 0.0f, 0.0f);
        (this.helmet56 = new ModelRenderer((ModelBase)this, 50, 200)).addBox(-0.5f, -4.75f, -7.1f, 1, 1, 1);
        this.helmet56.setRotationPoint(0.0f, 0.0f, 0.0f);
        this.helmet56.setTextureSize(64, 32);
        this.helmet56.mirror = true;
        this.setRotation(this.helmet56, 0.0f, 0.0f, 0.0f);
        this.bipedHead.addChild(this.helmet1);
        this.bipedHead.addChild(this.helmet2);
        this.bipedHead.addChild(this.helmet3);
        this.bipedHead.addChild(this.helmet4);
        this.bipedHead.addChild(this.helmet5);
        this.bipedHead.addChild(this.helmet6);
        this.bipedHead.addChild(this.helmet7);
        this.bipedHead.addChild(this.helmet8);
        this.bipedHead.addChild(this.helmet9);
        this.bipedHead.addChild(this.helmet10);
        this.bipedHead.addChild(this.helmet11);
        this.bipedHead.addChild(this.helmet12);
        this.bipedHead.addChild(this.helmet13);
        this.bipedHead.addChild(this.helmet14);
        this.bipedHead.addChild(this.helmet16);
        this.bipedHead.addChild(this.helmet17);
        this.bipedHead.addChild(this.helmet18);
        this.bipedHead.addChild(this.helmet19);
        this.bipedHead.addChild(this.helmet20);
        this.bipedHead.addChild(this.helmet21);
        this.bipedHead.addChild(this.helmet22);
        this.bipedHead.addChild(this.helmet23);
        this.bipedHead.addChild(this.helmet24);
        this.bipedHead.addChild(this.helmet25);
        this.bipedHead.addChild(this.helmet26);
        this.bipedHead.addChild(this.helmet27);
        this.bipedHead.addChild(this.helmet28);
        this.bipedHead.addChild(this.helmet29);
        this.bipedHead.addChild(this.helmet30);
        this.bipedHead.addChild(this.helmet31);
        this.bipedHead.addChild(this.helmet32);
        this.bipedHead.addChild(this.helmet33);
        this.bipedHead.addChild(this.helmet34);
        this.bipedHead.addChild(this.helmet35);
        this.bipedHead.addChild(this.helmet36);
        this.bipedHead.addChild(this.helmet37);
        this.bipedHead.addChild(this.helmet38);
        this.bipedHead.addChild(this.helmet39);
        this.bipedHead.addChild(this.helmet40);
        this.bipedHead.addChild(this.helmet41);
        this.bipedHead.addChild(this.helmet42);
        this.bipedHead.addChild(this.helmet43);
        this.bipedHead.addChild(this.helmet44);
        this.bipedHead.addChild(this.helmet45);
        this.bipedHead.addChild(this.helmet46);
        this.bipedHead.addChild(this.helmet47);
        this.bipedHead.addChild(this.helmet48);
        this.bipedHead.addChild(this.helmet49);
        this.bipedHead.addChild(this.helmet50);
        this.bipedHead.addChild(this.helmet51);
        this.bipedHead.addChild(this.helmet52);
        this.bipedHead.addChild(this.helmet53);
        this.bipedHead.addChild(this.helmet54);
        this.bipedHead.addChild(this.helmet55);
        this.bipedHead.addChild(this.helmet56);
        this.bipedBody.addChild(this.vest1);
        this.bipedBody.addChild(this.vest2);
        this.bipedBody.addChild(this.vest3);
        this.bipedBody.addChild(this.vest4);
        this.bipedBody.addChild(this.vest5);
        this.bipedBody.addChild(this.vest6);
        this.bipedBody.addChild(this.vest7);
        this.bipedBody.addChild(this.vest8);
        this.bipedBody.addChild(this.vest9);
        this.bipedBody.addChild(this.vest10);
    }
    
    public void render(final Entity entity, final float f, final float f1, final float f2, final float f3, final float f4, final float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }
    
    private void setRotation(final ModelRenderer model, final float x, final float y, final float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }
}
