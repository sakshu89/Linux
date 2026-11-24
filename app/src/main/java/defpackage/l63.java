package defpackage;

import com.ibm.icu.impl.number.Padder;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class l63 implements hq0 {
    public final /* synthetic */ int a;

    public /* synthetic */ l63(int i) {
        this.a = i;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // defpackage.hq0
    public final Object j(Object obj) {
        switch (this.a) {
            case 0:
                long j = ((e21) obj).a;
                return new sd((int) (j >> 32), (int) (j & 4294967295L));
            case 1:
                sd sdVar = (sd) obj;
                return new e21((((long) Math.round(sdVar.b)) & 4294967295L) | (((long) Math.round(sdVar.a)) << 32));
            case 2:
                long j2 = ((l21) obj).a;
                return new sd((int) (j2 >> 32), (int) (j2 & 4294967295L));
            case 3:
                sd sdVar2 = (sd) obj;
                int iRound = Math.round(sdVar2.a);
                if (iRound < 0) {
                    iRound = 0;
                }
                int iRound2 = Math.round(sdVar2.b);
                return new l21((((long) iRound) << 32) | (((long) (iRound2 >= 0 ? iRound2 : 0)) & 4294967295L));
            case 4:
                l42 l42Var = (l42) obj;
                return new ud(l42Var.a, l42Var.b, l42Var.c, l42Var.d);
            case 5:
                ud udVar = (ud) obj;
                return new l42(udVar.a, udVar.b, udVar.c, udVar.d);
            case 6:
                return Float.valueOf(((rd) obj).a);
            case 7:
                ba3 ba3Var = (ba3) obj;
                ba3Var.getClass();
                return ba3Var.a;
            case 8:
                ba3 ba3Var2 = (ba3) obj;
                ba3Var2.getClass();
                return ba3Var2.a;
            case 9:
                return ((tb3) obj).e;
            case 10:
                return ((tb3) obj).f;
            case 11:
                return ((tb3) obj).c;
            default:
                fh1 fh1Var = (fh1) obj;
                fh1Var.getClass();
                String str = (String) ((dh1) fh1Var.a()).get(1);
                Locale locale = Locale.ROOT;
                String strO = cq.o(locale, str, locale);
                switch (strO.hashCode()) {
                    case 3309:
                        if (strO.equals("gt")) {
                            return ">";
                        }
                        break;
                    case 3464:
                        if (strO.equals("lt")) {
                            return "<";
                        }
                        break;
                    case 96708:
                        if (strO.equals("amp")) {
                            return "&";
                        }
                        break;
                    case 3000915:
                        if (strO.equals("apos")) {
                            return "'";
                        }
                        break;
                    case 3374865:
                        if (strO.equals("nbsp")) {
                            return Padder.FALLBACK_PADDING_STRING;
                        }
                        break;
                    case 3482377:
                        if (strO.equals("quot")) {
                            return "\"";
                        }
                        break;
                }
                Integer numL = js2.k(strO, "#x", false) ? js2.l(16, cs2.p(2, strO)) : js2.l(10, cs2.p(1, strO));
                if (numL == null || !Character.isValidCodePoint(numL.intValue())) {
                    return fh1Var.c();
                }
                char[] chars = Character.toChars(numL.intValue());
                chars.getClass();
                return new String(chars);
        }
    }
}
