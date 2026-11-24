package com.ibm.icu.impl.number;

import com.ibm.icu.impl.StandardPlural;
import defpackage.og;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class AdoptingModifierStore implements ModifierStore {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    boolean frozen;
    final Modifier[] mods;
    private final Modifier negZero;
    private final Modifier negative;
    private final Modifier posZero;
    private final Modifier positive;

    /* JADX INFO: renamed from: com.ibm.icu.impl.number.AdoptingModifierStore$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum;

        static {
            int[] iArr = new int[Modifier.Signum.values().length];
            $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum = iArr;
            try {
                iArr[Modifier.Signum.POS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.POS_ZERO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.NEG_ZERO.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[Modifier.Signum.NEG.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public AdoptingModifierStore() {
        this.positive = null;
        this.posZero = null;
        this.negZero = null;
        this.negative = null;
        this.mods = new Modifier[StandardPlural.COUNT * 4];
        this.frozen = false;
    }

    private static int getModIndex(Modifier.Signum signum, StandardPlural standardPlural) {
        return signum.ordinal() + (standardPlural.ordinal() * Modifier.Signum.COUNT);
    }

    public void freeze() {
        this.frozen = true;
    }

    @Override // com.ibm.icu.impl.number.ModifierStore
    public Modifier getModifier(Modifier.Signum signum, StandardPlural standardPlural) {
        return this.mods[getModIndex(signum, standardPlural)];
    }

    public Modifier getModifierWithoutPlural(Modifier.Signum signum) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$number$Modifier$Signum[signum.ordinal()];
        if (i == 1) {
            return this.positive;
        }
        if (i == 2) {
            return this.posZero;
        }
        if (i == 3) {
            return this.negZero;
        }
        if (i == 4) {
            return this.negative;
        }
        og.m("Unreachable");
        return null;
    }

    public void setModifier(Modifier.Signum signum, StandardPlural standardPlural, Modifier modifier) {
        this.mods[getModIndex(signum, standardPlural)] = modifier;
    }

    public AdoptingModifierStore(Modifier modifier, Modifier modifier2, Modifier modifier3, Modifier modifier4) {
        this.positive = modifier;
        this.posZero = modifier2;
        this.negZero = modifier3;
        this.negative = modifier4;
        this.mods = null;
        this.frozen = true;
    }
}
