package defpackage;

import com.ibm.icu.impl.number.Padder;
import com.ibm.icu.text.PluralRules;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class e60 implements nm0 {
    public final /* synthetic */ hq0 a;
    public final /* synthetic */ l11 b;
    public final /* synthetic */ x00 c;
    public final /* synthetic */ h60 e;
    public final /* synthetic */ x00 f;
    public final /* synthetic */ t42 i;

    public e60(hq0 hq0Var, l11 l11Var, x00 x00Var, h60 h60Var, x00 x00Var2, t42 t42Var) {
        this.a = hq0Var;
        this.b = l11Var;
        this.c = x00Var;
        this.e = h60Var;
        this.f = x00Var2;
        this.i = t42Var;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0041 A[EDGE_INSN: B:18:0x0041->B:69:0x021d BREAK  A[LOOP:1: B:53:0x01c4->B:91:?], PHI: r2
      0x0041: PHI (r2v11 java.lang.String) = 
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
      (r2v18 java.lang.String)
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
      (r2v10 java.lang.String)
     binds: [B:14:0x0038, B:17:0x003f, B:67:0x0219, B:35:0x0179, B:37:0x0181, B:39:0x0189, B:41:0x0191, B:43:0x0199, B:45:0x01a1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:55:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:90:0x01d6 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:91:? A[LOOP:1: B:53:0x01c4->B:91:?, LOOP_END, SYNTHETIC] */
    @Override // defpackage.nm0
    public final Object n(Object obj, x50 x50Var) throws IllegalAccessException, InvocationTargetException {
        String str;
        List listH;
        List listI;
        List listI2;
        Iterator it;
        fh1 fh1VarD;
        String str2;
        z83 z83Var = (z83) obj;
        this.a.j(z83Var);
        String str3 = null;
        if (z83Var instanceof w83) {
            str = ((w83) z83Var).a;
        } else {
            str = z83Var instanceof t83 ? ((t83) z83Var).a : null;
        }
        if (str != null) {
            String string = cs2.V(str).toString();
            if (!cs2.A(string)) {
                if (xy.q(string, false) || xy.o(string)) {
                    str3 = string;
                    break;
                }
                Locale locale = Locale.ROOT;
                locale.getClass();
                String lowerCase = string.toLowerCase(locale);
                lowerCase.getClass();
                String string2 = cs2.V(lowerCase).toString();
                Pattern patternCompile = Pattern.compile("\\s+");
                patternCompile.getClass();
                string2.getClass();
                cs2.L(0);
                Matcher matcher = patternCompile.matcher(string2);
                if (matcher.find()) {
                    ArrayList arrayList = new ArrayList(10);
                    int iEnd = 0;
                    do {
                        arrayList.add(string2.subSequence(iEnd, matcher.start()).toString());
                        iEnd = matcher.end();
                    } while (matcher.find());
                    arrayList.add(string2.subSequence(iEnd, string2.length()).toString());
                    listH = arrayList;
                } else {
                    listH = nz.h(string2.toString());
                }
                Set setC = wh2.c("first", "second", "third", "fourth", "fifth", "sixth", "seventh", "eighth", "ninth", "tenth", PluralRules.KEYWORD_ONE, PluralRules.KEYWORD_TWO, "three", "four", "five", "six", "seven", "eight", "nine", "ten", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "1st", "2nd", "3rd", "4th", "5th", "pehla", "pehle", "pehli", "dusra", "dusre", "dusri", "doosra", "doosre", "doosri", "teesra", "teesre", "teesri", "tisra", "tisre", "tisri", "chautha", "chauthe", "do", "don", "dono", "teen", "char", "chaar", "panch", "paanch", "पहला", "पहले", "पहली", "दूसरा", "दूसरे", "दूसरी", "तीसरा", "तीसरे", "तीसरी", "चौथा", "एक", "दो", "दोन", "तीन", "चार", "पांच", "पाँच", "१", "२", "३", "४", "५");
                if (listH.isEmpty()) {
                    listI = l11.I(string);
                    l11 l11Var = this.b;
                    listI2 = l11.I((String) l11Var.b);
                    if (!listI.isEmpty() && !listI.isEmpty()) {
                        it = listI.iterator();
                        while (it.hasNext()) {
                            if (!listI2.contains((String) it.next())) {
                                if (cs2.n(mz.C(listI2, Padder.FALLBACK_PADDING_STRING, null, null, null, 62), mz.C(listI, Padder.FALLBACK_PADDING_STRING, null, null, null, 62), false) && (fh1VarD = ((x42) l11Var.c).d(string)) != null && (str2 = (String) ((dh1) fh1VarD.a()).get(1)) != null && (string = cs2.V(str2).toString()) != null && !cs2.A(string)) {
                                    str3 = string;
                                    break;
                                }
                                break;
                                break;
                                break;
                                break;
                                break;
                            }
                        }
                    }
                } else {
                    Iterator it2 = listH.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (setC.contains((String) it2.next())) {
                                if (listH.size() <= 5 || js2.k(string2, "option ", false) || js2.k(string2, "number ", false) || js2.k(string2, "choose ", false) || js2.k(string2, "select ", false) || js2.k(string2, "play ", false)) {
                                    str3 = string;
                                    break;
                                }
                            }
                        }
                        listI = l11.I(string);
                        l11 l11Var2 = this.b;
                        listI2 = l11.I((String) l11Var2.b);
                        if (!listI.isEmpty()) {
                            it = listI.iterator();
                            while (it.hasNext()) {
                                if (!listI2.contains((String) it.next())) {
                                    if (cs2.n(mz.C(listI2, Padder.FALLBACK_PADDING_STRING, null, null, null, 62), mz.C(listI, Padder.FALLBACK_PADDING_STRING, null, null, null, 62), false)) {
                                        break;
                                    }
                                    str3 = string;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        q43 q43Var = q43.a;
        if (str3 != null) {
            this.c.b0(q43Var);
            this.e.b.c();
            if (z83Var instanceof t83) {
                this.f.b0(str3);
            }
        }
        if (!(z83Var instanceof t83) && !(z83Var instanceof x83) && !(z83Var instanceof s83) && !(z83Var instanceof y83)) {
            return q43Var;
        }
        this.i.a = z83Var;
        return q43Var;
    }
}
