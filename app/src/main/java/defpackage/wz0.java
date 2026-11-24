package defpackage;

import com.ibm.icu.text.DateFormat;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public abstract class wz0 {
    public static final String[] a = {"o", "t", "g", "ng", "l", "a", "k", DateFormat.HOUR, DateFormat.MINUTE, "w", "i", DateFormat.SECOND, "h", "ny", "r", "u", "ch", DateFormat.DAY, "nn", DateFormat.YEAR, "e", "p", "dd", "n", "rr", "o", "tt", "b", "wn", "h"};
    public static final Set b = wh2.c(7258, 7263, 7268, 7273, 7278, 7283);
    public static final Map c = bh1.c(new wt1(7260, "k'"), new wt1(7265, "ch'"), new wt1(7275, "t'"), new wt1(7285, "p'"));
    public static final String[] d = {"k", DateFormat.SECOND, "l", DateFormat.MINUTE, "p", "n", "ch", "t", "kh", "ng", "th", "w", DateFormat.YEAR, "h", "u", "i", "ph", "a", "g", "jh", "r", "b", DateFormat.HOUR, DateFormat.DAY, "gh", "dh", "bh"};
    public static final String[] e = {"k", "l", DateFormat.MINUTE, "p", "n", "t", "ng", "i"};
    public static final String[] f = {"chh", "ny", "tt", "tth", "dd", "ddh", "nn", "sh", "ss"};
    public static final String[] g = {"o", "i", "aa", "e", "ou", "u", "ei"};
    public static final String[] h = {"ii", "uu", "aai", "au", "aau"};

    public static void a() {
        throw new g53("This spelling cannot be fully written in Latin letters. Please provide its Roman spelling.");
    }
}
