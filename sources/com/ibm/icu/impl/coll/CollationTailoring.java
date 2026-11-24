package com.ibm.icu.impl.coll;

import com.ibm.icu.impl.Norm2AllModes;
import com.ibm.icu.impl.Trie2_32;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.ULocale;
import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.VersionInfo;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class CollationTailoring {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public CollationData data;
    public volatile Map<Integer, Integer> maxExpansions;
    CollationData ownedData;
    private String rules;
    private UResourceBundle rulesResource;
    public SharedObject.Reference<CollationSettings> settings;
    Trie2_32 trie;
    UnicodeSet unsafeBackwardSet;
    public ULocale actualLocale = ULocale.ROOT;
    public int version = 0;

    public CollationTailoring(SharedObject.Reference<CollationSettings> reference) {
        if (reference != null) {
            this.settings = new SharedObject.Reference<>(reference);
        } else {
            this.settings = new SharedObject.Reference<>(new CollationSettings());
        }
    }

    public static VersionInfo makeBaseVersion(VersionInfo versionInfo) {
        return VersionInfo.getInstance(VersionInfo.UCOL_BUILDER_VERSION.getMajor(), versionInfo.getMinor() + (versionInfo.getMajor() << 3), versionInfo.getMilli() << 6, 0);
    }

    public void ensureOwnedData() {
        if (this.ownedData == null) {
            this.ownedData = new CollationData(Norm2AllModes.getNFCInstance().impl);
        }
        this.data = this.ownedData;
    }

    public String getRules() {
        String str = this.rules;
        if (str != null) {
            return str;
        }
        UResourceBundle uResourceBundle = this.rulesResource;
        return uResourceBundle != null ? uResourceBundle.getString() : "";
    }

    public int getUCAVersion() {
        int i = this.version;
        return ((i >> 14) & 3) | ((i >> 12) & 4080);
    }

    public void setRules(String str) {
        this.rules = str;
    }

    public void setRulesResource(UResourceBundle uResourceBundle) {
        this.rulesResource = uResourceBundle;
    }

    public void setVersion(int i, int i2) {
        int i3 = i2 >> 16;
        int i4 = 65280 & i3;
        int i5 = i3 & 255;
        int i6 = (i2 >> 8) & 255;
        int i7 = i2 & 255;
        this.version = (i & 16760832) | (VersionInfo.UCOL_BUILDER_VERSION.getMajor() << 24) | ((i4 + (i4 >> 6)) & 16128) | (((i5 << 3) + (i5 >> 5) + i6 + (i7 << 4) + (i7 >> 4)) & 255);
    }
}
