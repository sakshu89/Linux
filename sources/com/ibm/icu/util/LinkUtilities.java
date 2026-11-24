package com.ibm.icu.util;

import com.ibm.icu.impl.links.LinkHandlingUtilities;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LinkUtilities {

    /* JADX INFO: renamed from: com.ibm.icu.util.LinkUtilities$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$util$LinkUtilities$Extent;

        static {
            int[] iArr = new int[Extent.values().length];
            $SwitchMap$com$ibm$icu$util$LinkUtilities$Extent = iArr;
            try {
                iArr[Extent.MINIMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$util$LinkUtilities$Extent[Extent.MAXIMAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum Extent {
        MINIMAL,
        MAXIMAL
    }

    private LinkUtilities() {
    }

    public static String escapePathQueryFragment(String str, Extent extent) {
        LinkHandlingUtilities.UrlInternals urlInternalsFrom = LinkHandlingUtilities.UrlInternals.from(str);
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$util$LinkUtilities$Extent[extent.ordinal()];
        if (i == 1) {
            return urlInternalsFrom.minimalEscape(LinkHandlingUtilities.UrlInternals.EndStatus.FINAL);
        }
        if (i == 2) {
            return urlInternalsFrom.fullEscape();
        }
        throw new InternalError();
    }

    public static int scanBackEmailLocalPart(CharSequence charSequence, int i, int i2) {
        return LinkHandlingUtilities.scanEmailBackwards(charSequence, i, i2);
    }

    public static int scanPathQueryFragment(CharSequence charSequence, int i, int i2) {
        return LinkHandlingUtilities.parsePathQueryFragment(charSequence.toString(), i);
    }
}
