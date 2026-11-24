package defpackage;

import android.os.Trace;
import android.view.KeyEvent;
import android.view.View;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class do0 implements ao0 {
    public final r7 a;
    public final r7 b;
    public final vn0 d;
    public sl1 f;
    public ko0 h;
    public final ko0 c = new ko0(2, null, 14);
    public final bo0 e = new bo0(this);
    public final yl1 g = new yl1(1);

    public do0(r7 r7Var, r7 r7Var2) {
        this.a = r7Var;
        this.b = r7Var2;
        this.d = new vn0(this, r7Var2);
    }

    public final boolean a(boolean z) {
        zn1 zn1Var;
        if (f() != null) {
            ko0 ko0VarF = f();
            i(null);
            if (ko0VarF != null) {
                jo0 jo0Var = jo0.a;
                jo0 jo0Var2 = jo0.c;
                ko0VarF.J0(jo0Var, jo0Var2);
                if (!ko0VarF.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var = ko0VarF.a.f;
                n71 n71VarG = cm4.g(ko0VarF);
                while (n71VarG != null) {
                    if ((n71VarG.o0.f.e & 1024) != 0) {
                        while (dk1Var != null) {
                            if ((dk1Var.c & 1024) != 0) {
                                dk1 dk1VarB = dk1Var;
                                pm1 pm1Var = null;
                                while (dk1VarB != null) {
                                    if (dk1VarB instanceof ko0) {
                                        ((ko0) dk1VarB).J0(jo0.b, jo0Var2);
                                    } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                        int i = 0;
                                        for (dk1 dk1Var2 = ((zb0) dk1VarB).H; dk1Var2 != null; dk1Var2 = dk1Var2.i) {
                                            if ((dk1Var2.c & 1024) != 0) {
                                                i++;
                                                if (i == 1) {
                                                    dk1VarB = dk1Var2;
                                                } else {
                                                    if (pm1Var == null) {
                                                        pm1Var = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB != null) {
                                                        pm1Var.b(dk1VarB);
                                                        dk1VarB = null;
                                                    }
                                                    pm1Var.b(dk1Var2);
                                                }
                                            }
                                        }
                                        if (i == 1) {
                                        }
                                    }
                                    dk1VarB = cm4.b(pm1Var);
                                }
                            }
                            dk1Var = dk1Var.f;
                        }
                    }
                    n71VarG = n71VarG.u();
                    dk1Var = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                }
            }
        }
        return true;
    }

    public final boolean b(boolean z, boolean z2, int i) {
        int iOrdinal;
        boolean z3 = true;
        if (z || (iOrdinal = wn4.b(this.c).ordinal()) == 0) {
            a(z);
        } else {
            if (iOrdinal != 1 && iOrdinal != 2 && iOrdinal != 3) {
                dk0.l();
                return false;
            }
            z3 = false;
        }
        if (z3 && z2) {
            c();
        }
        return z3;
    }

    public final void c() {
        r7 r7Var = this.a;
        if (r7Var.isFocused() || r7Var.hasFocus()) {
            r7Var.clearFocus();
        } else if (r7Var.hasFocus()) {
            View viewFindFocus = r7Var.findFocus();
            if (viewFindFocus != null) {
                viewFindFocus.clearFocus();
            }
            r7Var.clearFocus();
        }
    }

    /* JADX WARN: Code duplicated, block: B:116:0x0151 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x015f A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:124:0x0164  */
    /* JADX WARN: Code duplicated, block: B:314:0x00d4 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:315:0x0086 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0059  */
    /* JADX WARN: Code duplicated, block: B:321:0x00c2 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:32:0x005b A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:334:0x015a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:335:0x010c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:336:0x0158 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:343:0x0148 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:347:0x0143 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:34:0x0061 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x006c A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:39:0x0076 A[ADDED_TO_REGION, LOOP:12: B:39:0x0076->B:67:0x00c2, LOOP_START, PHI: r6
      0x0076: PHI (r6v27 dk1) = (r6v22 dk1), (r6v28 dk1) binds: [B:38:0x0074, B:67:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:40:0x0078 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:47:0x0087 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:77:0x00d9 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:78:0x00df A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:83:0x00f2 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x00fc A[ADDED_TO_REGION, LOOP:16: B:85:0x00fc->B:113:0x0148, LOOP_START, PHI: r12
      0x00fc: PHI (r12v13 dk1) = (r12v8 dk1), (r12v14 dk1) binds: [B:84:0x00fa, B:113:0x0148] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:86:0x00fe A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x0104  */
    /* JADX WARN: Code duplicated, block: B:90:0x0108 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:93:0x010d A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Code duplicated, block: B:95:0x0113 A[Catch: all -> 0x02de, TryCatch #0 {all -> 0x02de, blocks: (B:3:0x0007, B:5:0x000e, B:8:0x0019, B:12:0x0023, B:15:0x002f, B:17:0x0035, B:18:0x003a, B:20:0x0042, B:22:0x0047, B:24:0x004d, B:28:0x0053, B:126:0x0167, B:128:0x016d, B:129:0x0170, B:131:0x017b, B:134:0x0187, B:138:0x0191, B:141:0x0197, B:142:0x019c, B:162:0x01d6, B:143:0x01a0, B:145:0x01a6, B:147:0x01aa, B:149:0x01b2, B:151:0x01b8, B:155:0x01c0, B:157:0x01c9, B:158:0x01cd, B:159:0x01d0, B:163:0x01db, B:164:0x01de, B:166:0x01e4, B:168:0x01e8, B:171:0x01ef, B:173:0x01f7, B:180:0x020e, B:182:0x0213, B:184:0x0217, B:207:0x0259, B:188:0x0223, B:190:0x0229, B:192:0x022d, B:194:0x0235, B:196:0x023b, B:200:0x0243, B:202:0x024c, B:203:0x0250, B:204:0x0253, B:208:0x025e, B:212:0x026e, B:214:0x0273, B:216:0x0277, B:239:0x02b9, B:220:0x0283, B:222:0x0289, B:224:0x028d, B:226:0x0295, B:228:0x029b, B:232:0x02a3, B:234:0x02ac, B:235:0x02b0, B:236:0x02b3, B:241:0x02c0, B:243:0x02c7, B:32:0x005b, B:34:0x0061, B:35:0x0064, B:37:0x006c, B:40:0x0078, B:44:0x0082, B:75:0x00d5, B:77:0x00d9, B:47:0x0087, B:49:0x008d, B:51:0x0091, B:53:0x0099, B:55:0x009f, B:59:0x00a7, B:61:0x00b0, B:62:0x00b4, B:63:0x00b7, B:66:0x00bd, B:67:0x00c2, B:68:0x00c5, B:70:0x00cb, B:72:0x00cf, B:78:0x00df, B:80:0x00e5, B:81:0x00e8, B:83:0x00f2, B:86:0x00fe, B:90:0x0108, B:121:0x015b, B:123:0x015f, B:93:0x010d, B:95:0x0113, B:97:0x0117, B:99:0x011f, B:101:0x0125, B:105:0x012d, B:107:0x0136, B:108:0x013a, B:109:0x013d, B:112:0x0143, B:113:0x0148, B:114:0x014b, B:116:0x0151, B:118:0x0155), top: B:253:0x0007 }] */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v20, types: [pm1] */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v22 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24, types: [pm1] */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r12v23, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v24, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v28, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v29, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v33, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v34 */
    /* JADX WARN: Type inference failed for: r12v35, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v36 */
    /* JADX WARN: Type inference failed for: r12v37 */
    /* JADX WARN: Type inference failed for: r12v38 */
    /* JADX WARN: Type inference failed for: r12v39 */
    /* JADX WARN: Type inference failed for: r12v42, types: [dk1] */
    /* JADX WARN: Type inference failed for: r12v43 */
    /* JADX WARN: Type inference failed for: r12v44, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v45 */
    /* JADX WARN: Type inference failed for: r12v46 */
    /* JADX WARN: Type inference failed for: r12v47 */
    /* JADX WARN: Type inference failed for: r12v48 */
    /* JADX WARN: Type inference failed for: r12v62 */
    /* JADX WARN: Type inference failed for: r12v63 */
    /* JADX WARN: Type inference failed for: r12v64 */
    /* JADX WARN: Type inference failed for: r12v65 */
    /* JADX WARN: Type inference failed for: r14v1 */
    /* JADX WARN: Type inference failed for: r14v10, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v6, types: [pm1] */
    /* JADX WARN: Type inference failed for: r14v7 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r6v37 */
    public final boolean d(KeyEvent keyEvent, fq0 fq0Var) {
        dk1 dk1Var;
        n71 n71VarG;
        xb0 xb0Var;
        xb0 xb0Var2;
        dk1 dk1Var2;
        zn1 zn1Var;
        dk1 dk1VarB;
        pm1 pm1Var;
        dk1 dk1Var3;
        n71 n71VarG2;
        xb0 xb0Var3;
        xb0 xb0Var4;
        zn1 zn1Var2;
        pm1 pm1Var2;
        dk1 dk1VarB2;
        int size;
        zn1 zn1Var3;
        ko0 ko0Var = this.c;
        Trace.beginSection("FocusOwnerImpl:dispatchKeyEvent");
        try {
            if (this.d.e) {
                System.out.println((Object) "FocusRelatedWarning: Dispatching key event while focus system is invalidated.");
                Trace.endSection();
                return false;
            }
            if (!j(keyEvent)) {
                Trace.endSection();
                return false;
            }
            ko0 ko0VarA = xn4.a(ko0Var);
            if (ko0VarA != null) {
                if (!ko0VarA.a.w) {
                    z01.b("visitLocalDescendants called on an unattached node");
                }
                dk1 dk1Var4 = ko0VarA.a;
                if ((dk1Var4.e & 9216) != 0) {
                    dk1Var2 = null;
                    for (dk1 dk1Var5 = dk1Var4.i; dk1Var5 != null; dk1Var5 = dk1Var5.i) {
                        int i = dk1Var5.c;
                        if ((i & 9216) != 0) {
                            if ((i & 1024) != 0) {
                                break;
                            }
                            dk1Var2 = dk1Var5;
                        }
                    }
                } else {
                    dk1Var2 = null;
                }
                if (dk1Var2 == null) {
                    if (ko0VarA == null) {
                        if (!ko0Var.a.w) {
                            z01.b("visitAncestors called on an unattached node");
                        }
                        dk1Var = ko0Var.a.f;
                        n71VarG = cm4.g(ko0Var);
                        loop15: while (true) {
                            if (n71VarG != null) {
                                xb0Var = null;
                                break;
                            }
                            if ((n71VarG.o0.f.e & 8192) != 0) {
                                while (dk1Var != null) {
                                    if ((dk1Var.c & 8192) != 0) {
                                        dk1VarB = dk1Var;
                                        pm1Var = null;
                                        while (dk1VarB != null) {
                                            if (dk1VarB instanceof k51) {
                                                xb0Var = dk1VarB;
                                                break loop15;
                                            }
                                            if ((dk1VarB.c & 8192) == 0) {
                                            }
                                            dk1VarB = cm4.b(pm1Var);
                                        }
                                    }
                                    dk1Var = dk1Var.f;
                                }
                            }
                            n71VarG = n71VarG.u();
                            if (n71VarG != null) {
                            }
                        }
                        xb0Var2 = (k51) xb0Var;
                        if (xb0Var2 != null) {
                            dk1Var2 = ((dk1) xb0Var2).a;
                        } else {
                            dk1Var2 = null;
                        }
                    } else {
                        if (!ko0VarA.a.w) {
                            z01.b("visitAncestors called on an unattached node");
                        }
                        dk1Var3 = ko0VarA.a;
                        n71VarG2 = cm4.g(ko0VarA);
                        loop11: while (true) {
                            if (n71VarG2 != null) {
                                xb0Var3 = null;
                                break;
                            }
                            if ((n71VarG2.o0.f.e & 8192) != 0) {
                                while (dk1Var3 != null) {
                                    if ((dk1Var3.c & 8192) != 0) {
                                        pm1Var2 = null;
                                        dk1VarB2 = dk1Var3;
                                        while (dk1VarB2 != null) {
                                            if (dk1VarB2 instanceof k51) {
                                                xb0Var3 = dk1VarB2;
                                                break loop11;
                                            }
                                            if ((dk1VarB2.c & 8192) == 0) {
                                            }
                                            dk1VarB2 = cm4.b(pm1Var2);
                                        }
                                    }
                                    dk1Var3 = dk1Var3.f;
                                }
                            }
                            n71VarG2 = n71VarG2.u();
                            if (n71VarG2 != null) {
                            }
                        }
                        xb0Var4 = (k51) xb0Var3;
                        if (xb0Var4 != null) {
                            dk1Var2 = ((dk1) xb0Var4).a;
                        } else {
                            if (!ko0Var.a.w) {
                                z01.b("visitAncestors called on an unattached node");
                            }
                            dk1Var = ko0Var.a.f;
                            n71VarG = cm4.g(ko0Var);
                            loop15: while (true) {
                                if (n71VarG != null) {
                                    xb0Var = null;
                                    break;
                                }
                                if ((n71VarG.o0.f.e & 8192) != 0) {
                                    while (dk1Var != null) {
                                        if ((dk1Var.c & 8192) != 0) {
                                            dk1VarB = dk1Var;
                                            pm1Var = null;
                                            while (dk1VarB != null) {
                                                if (dk1VarB instanceof k51) {
                                                    xb0Var = dk1VarB;
                                                    break loop15;
                                                }
                                                if ((dk1VarB.c & 8192) == 0) {
                                                }
                                                dk1VarB = cm4.b(pm1Var);
                                            }
                                        }
                                        dk1Var = dk1Var.f;
                                    }
                                }
                                n71VarG = n71VarG.u();
                                if (n71VarG != null) {
                                }
                            }
                            xb0Var2 = (k51) xb0Var;
                            if (xb0Var2 != null) {
                                dk1Var2 = ((dk1) xb0Var2).a;
                            } else {
                                dk1Var2 = null;
                            }
                        }
                    }
                }
            } else if (ko0VarA == null) {
                if (!ko0Var.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1Var = ko0Var.a.f;
                n71VarG = cm4.g(ko0Var);
                loop15: while (true) {
                    if (n71VarG != null) {
                        xb0Var = null;
                        break;
                    }
                    if ((n71VarG.o0.f.e & 8192) != 0) {
                        while (dk1Var != null) {
                            if ((dk1Var.c & 8192) != 0) {
                                dk1VarB = dk1Var;
                                pm1Var = null;
                                while (dk1VarB != null) {
                                    if (dk1VarB instanceof k51) {
                                        xb0Var = dk1VarB;
                                        break loop15;
                                    }
                                    if ((dk1VarB.c & 8192) == 0 && (dk1VarB instanceof zb0)) {
                                        dk1 dk1Var6 = ((zb0) dk1VarB).H;
                                        int i2 = 0;
                                        dk1VarB = dk1VarB;
                                        pm1Var = pm1Var;
                                        while (dk1Var6 != null) {
                                            if ((dk1Var6.c & 8192) != 0) {
                                                i2++;
                                                pm1Var = pm1Var;
                                                if (i2 == 1) {
                                                    dk1VarB = dk1Var6;
                                                } else {
                                                    if (pm1Var == null) {
                                                        pm1Var = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB != null) {
                                                        pm1Var.b(dk1VarB);
                                                        dk1VarB = null;
                                                    }
                                                    pm1Var.b(dk1Var6);
                                                }
                                            }
                                            dk1Var6 = dk1Var6.i;
                                            dk1VarB = dk1VarB;
                                            pm1Var = pm1Var;
                                        }
                                        if (i2 == 1) {
                                        }
                                    }
                                    dk1VarB = cm4.b(pm1Var);
                                }
                            }
                            dk1Var = dk1Var.f;
                        }
                    }
                    n71VarG = n71VarG.u();
                    dk1Var = (n71VarG != null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
                }
                xb0Var2 = (k51) xb0Var;
                if (xb0Var2 != null) {
                    dk1Var2 = ((dk1) xb0Var2).a;
                } else {
                    dk1Var2 = null;
                }
            } else {
                if (!ko0VarA.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1Var3 = ko0VarA.a;
                n71VarG2 = cm4.g(ko0VarA);
                loop11: while (true) {
                    if (n71VarG2 != null) {
                        xb0Var3 = null;
                        break;
                    }
                    if ((n71VarG2.o0.f.e & 8192) != 0) {
                        while (dk1Var3 != null) {
                            if ((dk1Var3.c & 8192) != 0) {
                                pm1Var2 = null;
                                dk1VarB2 = dk1Var3;
                                while (dk1VarB2 != null) {
                                    if (dk1VarB2 instanceof k51) {
                                        xb0Var3 = dk1VarB2;
                                        break loop11;
                                    }
                                    if ((dk1VarB2.c & 8192) == 0 && (dk1VarB2 instanceof zb0)) {
                                        dk1 dk1Var7 = ((zb0) dk1VarB2).H;
                                        int i3 = 0;
                                        dk1VarB2 = dk1VarB2;
                                        pm1Var2 = pm1Var2;
                                        while (dk1Var7 != null) {
                                            if ((dk1Var7.c & 8192) != 0) {
                                                i3++;
                                                pm1Var2 = pm1Var2;
                                                if (i3 == 1) {
                                                    dk1VarB2 = dk1Var7;
                                                } else {
                                                    if (pm1Var2 == null) {
                                                        pm1Var2 = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB2 != null) {
                                                        pm1Var2.b(dk1VarB2);
                                                        dk1VarB2 = null;
                                                    }
                                                    pm1Var2.b(dk1Var7);
                                                }
                                            }
                                            dk1Var7 = dk1Var7.i;
                                            dk1VarB2 = dk1VarB2;
                                            pm1Var2 = pm1Var2;
                                        }
                                        if (i3 == 1) {
                                        }
                                    }
                                    dk1VarB2 = cm4.b(pm1Var2);
                                }
                            }
                            dk1Var3 = dk1Var3.f;
                        }
                    }
                    n71VarG2 = n71VarG2.u();
                    dk1Var3 = (n71VarG2 != null || (zn1Var2 = n71VarG2.o0) == null) ? null : zn1Var2.e;
                }
                xb0Var4 = (k51) xb0Var3;
                if (xb0Var4 != null) {
                    dk1Var2 = ((dk1) xb0Var4).a;
                } else {
                    if (!ko0Var.a.w) {
                        z01.b("visitAncestors called on an unattached node");
                    }
                    dk1Var = ko0Var.a.f;
                    n71VarG = cm4.g(ko0Var);
                    loop15: while (true) {
                        if (n71VarG != null) {
                            xb0Var = null;
                            break;
                        }
                        if ((n71VarG.o0.f.e & 8192) != 0) {
                            while (dk1Var != null) {
                                if ((dk1Var.c & 8192) != 0) {
                                    dk1VarB = dk1Var;
                                    pm1Var = null;
                                    while (dk1VarB != null) {
                                        if (dk1VarB instanceof k51) {
                                            xb0Var = dk1VarB;
                                            break loop15;
                                        }
                                        if ((dk1VarB.c & 8192) == 0) {
                                        }
                                        dk1VarB = cm4.b(pm1Var);
                                    }
                                }
                                dk1Var = dk1Var.f;
                            }
                        }
                        n71VarG = n71VarG.u();
                        if (n71VarG != null) {
                        }
                    }
                    xb0Var2 = (k51) xb0Var;
                    if (xb0Var2 != null) {
                        dk1Var2 = ((dk1) xb0Var2).a;
                    } else {
                        dk1Var2 = null;
                    }
                }
            }
            if (dk1Var2 != null) {
                if (!dk1Var2.a.w) {
                    z01.b("visitAncestors called on an unattached node");
                }
                dk1 dk1Var8 = dk1Var2.a.f;
                n71 n71VarG3 = cm4.g(dk1Var2);
                ArrayList arrayList = null;
                while (n71VarG3 != null) {
                    if ((n71VarG3.o0.f.e & 8192) != 0) {
                        while (dk1Var8 != null) {
                            if ((dk1Var8.c & 8192) != 0) {
                                dk1 dk1VarB3 = dk1Var8;
                                pm1 pm1Var3 = null;
                                while (dk1VarB3 != null) {
                                    if (dk1VarB3 instanceof k51) {
                                        if (arrayList == null) {
                                            arrayList = new ArrayList();
                                        }
                                        arrayList.add(dk1VarB3);
                                    } else if ((dk1VarB3.c & 8192) != 0 && (dk1VarB3 instanceof zb0)) {
                                        int i4 = 0;
                                        for (dk1 dk1Var9 = ((zb0) dk1VarB3).H; dk1Var9 != null; dk1Var9 = dk1Var9.i) {
                                            if ((dk1Var9.c & 8192) != 0) {
                                                i4++;
                                                if (i4 == 1) {
                                                    dk1VarB3 = dk1Var9;
                                                } else {
                                                    if (pm1Var3 == null) {
                                                        pm1Var3 = new pm1(new dk1[16]);
                                                    }
                                                    if (dk1VarB3 != null) {
                                                        pm1Var3.b(dk1VarB3);
                                                        dk1VarB3 = null;
                                                    }
                                                    pm1Var3.b(dk1Var9);
                                                }
                                            }
                                        }
                                        if (i4 == 1) {
                                        }
                                    }
                                    dk1VarB3 = cm4.b(pm1Var3);
                                }
                            }
                            dk1Var8 = dk1Var8.f;
                        }
                    }
                    n71VarG3 = n71VarG3.u();
                    dk1Var8 = (n71VarG3 == null || (zn1Var3 = n71VarG3.o0) == null) ? null : zn1Var3.e;
                }
                if (arrayList != null && (size = arrayList.size() - 1) >= 0) {
                    while (true) {
                        int i5 = size - 1;
                        if (((k51) arrayList.get(size)).k(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                        if (i5 < 0) {
                            break;
                        }
                        size = i5;
                    }
                }
                var B = dk1Var2.a;
                var pm1Var4 = 0;
                while (B != 0) {
                    if (B instanceof k51) {
                        if (((k51) B).k(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((B.c & 8192) != 0 && (B instanceof zb0)) {
                        dk1 dk1Var10 = ((zb0) B).H;
                        int i6 = 0;
                        pm1Var4 = pm1Var4;
                        B = B;
                        while (dk1Var10 != null) {
                            if ((dk1Var10.c & 8192) != 0) {
                                i6++;
                                pm1Var4 = pm1Var4;
                                if (i6 == 1) {
                                    B = dk1Var10;
                                } else {
                                    if (pm1Var4 == 0) {
                                        pm1Var4 = new pm1(new dk1[16]);
                                    }
                                    if (B != 0) {
                                        pm1Var4.b(B);
                                        B = 0;
                                    }
                                    pm1Var4.b(dk1Var10);
                                }
                            }
                            dk1Var10 = dk1Var10.i;
                            pm1Var4 = pm1Var4;
                            B = B;
                        }
                        if (i6 == 1) {
                        }
                    }
                    B = cm4.b(pm1Var4);
                }
                if (((Boolean) fq0Var.a()).booleanValue()) {
                    Trace.endSection();
                    return true;
                }
                var B2 = dk1Var2.a;
                var pm1Var5 = 0;
                while (B2 != 0) {
                    if (B2 instanceof k51) {
                        if (((k51) B2).U(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    } else if ((B2.c & 8192) != 0 && (B2 instanceof zb0)) {
                        dk1 dk1Var11 = ((zb0) B2).H;
                        int i7 = 0;
                        B2 = B2;
                        pm1Var5 = pm1Var5;
                        while (dk1Var11 != null) {
                            if ((dk1Var11.c & 8192) != 0) {
                                i7++;
                                pm1Var5 = pm1Var5;
                                if (i7 == 1) {
                                    B2 = dk1Var11;
                                } else {
                                    if (pm1Var5 == 0) {
                                        pm1Var5 = new pm1(new dk1[16]);
                                    }
                                    if (B2 != 0) {
                                        pm1Var5.b(B2);
                                        B2 = 0;
                                    }
                                    pm1Var5.b(dk1Var11);
                                }
                            }
                            dk1Var11 = dk1Var11.i;
                            B2 = B2;
                            pm1Var5 = pm1Var5;
                        }
                        if (i7 == 1) {
                        }
                    }
                    B2 = cm4.b(pm1Var5);
                }
                if (arrayList != null) {
                    int size2 = arrayList.size();
                    for (int i8 = 0; i8 < size2; i8++) {
                        if (((k51) arrayList.get(i8)).U(keyEvent)) {
                            Trace.endSection();
                            return true;
                        }
                    }
                }
            }
            Trace.endSection();
            return false;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public final Boolean e(int i, l42 l42Var, hq0 hq0Var) {
        boolean zA;
        ko0 ko0Var;
        zn1 zn1Var;
        ko0 ko0Var2 = this.c;
        ko0 ko0VarA = xn4.a(ko0Var2);
        int i2 = 4;
        r7 r7Var = this.b;
        boolean zBooleanValue = false;
        if (ko0VarA != null) {
            z61 layoutDirection = r7Var.getLayoutDirection();
            eo0 eo0VarK0 = ko0VarA.K0();
            fo0 fo0Var = eo0VarK0.h;
            fo0 fo0Var2 = eo0VarK0.i;
            if (i == 1) {
                fo0Var = eo0VarK0.b;
            } else if (i == 2) {
                fo0Var = eo0VarK0.c;
            } else if (i == 5) {
                fo0Var = eo0VarK0.d;
            } else if (i == 6) {
                fo0Var = eo0VarK0.e;
            } else if (i == 3) {
                int iOrdinal = layoutDirection.ordinal();
                if (iOrdinal != 0) {
                    if (iOrdinal != 1) {
                        dk0.l();
                        return null;
                    }
                    fo0Var = fo0Var2;
                }
                if (fo0Var == fo0.b) {
                    fo0Var = null;
                }
                if (fo0Var == null) {
                    fo0Var = eo0VarK0.f;
                }
            } else if (i == 4) {
                int iOrdinal2 = layoutDirection.ordinal();
                if (iOrdinal2 == 0) {
                    fo0Var = fo0Var2;
                } else if (iOrdinal2 != 1) {
                    dk0.l();
                    return null;
                }
                if (fo0Var == fo0.b) {
                    fo0Var = null;
                }
                if (fo0Var == null) {
                    fo0Var = eo0VarK0.g;
                }
            } else {
                if (i != 7 && i != 8) {
                    og.n("invalid FocusDirection");
                    return null;
                }
                do0 do0Var = (do0) ((r7) cm4.h(ko0VarA)).getFocusOwner();
                ko0 ko0VarF = do0Var.f();
                if (i == 7) {
                    eo0VarK0.j.getClass();
                } else {
                    eo0VarK0.k.getClass();
                }
                fo0Var = ko0VarF != do0Var.f() ? fo0.d : fo0.b;
            }
            fo0 fo0Var3 = fo0.c;
            if (!g31.a(fo0Var, fo0Var3)) {
                if (g31.a(fo0Var, fo0.d)) {
                    ko0 ko0VarA2 = xn4.a(ko0Var2);
                    if (ko0VarA2 != null) {
                        return (Boolean) hq0Var.j(ko0VarA2);
                    }
                } else {
                    fo0 fo0Var4 = fo0.b;
                    if (!g31.a(fo0Var, fo0Var4)) {
                        if (fo0Var == fo0Var4) {
                            og.n("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                            return null;
                        }
                        if (fo0Var == fo0Var3) {
                            og.n("\n    Please check whether the focusRequester is FocusRequester.Cancel or FocusRequester.Default\n    before invoking any functions on the focusRequester.\n");
                            return null;
                        }
                        pm1 pm1Var = fo0Var.a;
                        int i3 = pm1Var.c;
                        if (i3 == 0) {
                            System.out.println((Object) "FocusRelatedWarning: \n   FocusRequester is not initialized. Here are some possible fixes:\n\n   1. Remember the FocusRequester: val focusRequester = remember { FocusRequester() }\n   2. Did you forget to add a Modifier.focusRequester() ?\n   3. Are you attempting to request focus during composition? Focus requests should be made in\n   response to some event. Eg Modifier.clickable { focusRequester.requestFocus() }\n");
                        } else {
                            Object[] objArr = pm1Var.a;
                            boolean z = false;
                            for (int i4 = 0; i4 < i3; i4++) {
                                xb0 xb0Var = (ho0) objArr[i4];
                                if (!((dk1) xb0Var).a.w) {
                                    z01.b("visitChildren called on an unattached node");
                                }
                                pm1 pm1Var2 = new pm1(new dk1[16]);
                                dk1 dk1Var = ((dk1) xb0Var).a;
                                dk1 dk1Var2 = dk1Var.i;
                                if (dk1Var2 == null) {
                                    cm4.a(pm1Var2, dk1Var);
                                } else {
                                    pm1Var2.b(dk1Var2);
                                }
                                while (true) {
                                    int i5 = pm1Var2.c;
                                    if (i5 == 0) {
                                        break;
                                    }
                                    dk1 dk1VarB = (dk1) pm1Var2.l(i5 - 1);
                                    if ((dk1VarB.e & 1024) == 0) {
                                        cm4.a(pm1Var2, dk1VarB);
                                    } else {
                                        while (dk1VarB != null) {
                                            if ((dk1VarB.c & 1024) != 0) {
                                                pm1 pm1Var3 = null;
                                                while (dk1VarB != null) {
                                                    if (dk1VarB instanceof ko0) {
                                                        if (((Boolean) hq0Var.j((ko0) dk1VarB)).booleanValue()) {
                                                            z = true;
                                                            break;
                                                        }
                                                    } else if ((dk1VarB.c & 1024) != 0 && (dk1VarB instanceof zb0)) {
                                                        int i6 = 0;
                                                        for (dk1 dk1Var3 = ((zb0) dk1VarB).H; dk1Var3 != null; dk1Var3 = dk1Var3.i) {
                                                            if ((dk1Var3.c & 1024) != 0) {
                                                                i6++;
                                                                if (i6 == 1) {
                                                                    dk1VarB = dk1Var3;
                                                                } else {
                                                                    if (pm1Var3 == null) {
                                                                        pm1Var3 = new pm1(new dk1[16]);
                                                                    }
                                                                    if (dk1VarB != null) {
                                                                        pm1Var3.b(dk1VarB);
                                                                        dk1VarB = null;
                                                                    }
                                                                    pm1Var3.b(dk1Var3);
                                                                }
                                                            }
                                                        }
                                                        if (i6 == 1) {
                                                        }
                                                    }
                                                    dk1VarB = cm4.b(pm1Var3);
                                                }
                                                break;
                                            }
                                            dk1VarB = dk1VarB.i;
                                        }
                                    }
                                }
                            }
                            zBooleanValue = z;
                        }
                        return Boolean.valueOf(zBooleanValue);
                    }
                }
            }
            return null;
        }
        ko0VarA = null;
        z61 layoutDirection2 = r7Var.getLayoutDirection();
        ke0 ke0Var = new ke0(ko0VarA, this, hq0Var, 2);
        if (i == 1 || i == 2) {
            if (i == 1) {
                zA = wr4.b(ko0Var2, ke0Var);
            } else {
                if (i != 2) {
                    og.n("This function should only be used for 1-D focus search");
                    return null;
                }
                zA = wr4.a(ko0Var2, ke0Var);
            }
            return Boolean.valueOf(zA);
        }
        if (i == 3 || i == 4 || i == 5 || i == 6) {
            return nd4.l(i, ke0Var, ko0Var2, l42Var);
        }
        if (i == 7) {
            int iOrdinal3 = layoutDirection2.ordinal();
            if (iOrdinal3 != 0) {
                if (iOrdinal3 != 1) {
                    dk0.l();
                    return null;
                }
                i2 = 3;
            }
            ko0 ko0VarA3 = xn4.a(ko0Var2);
            if (ko0VarA3 != null) {
                return nd4.l(i2, ke0Var, ko0VarA3, l42Var);
            }
            return null;
        }
        if (i != 8) {
            throw new IllegalStateException(("Focus search invoked with invalid FocusDirection " + ((Object) qn0.a(i))).toString());
        }
        ko0 ko0VarA4 = xn4.a(ko0Var2);
        if (ko0VarA4 == null) {
            ko0Var = null;
            break;
        }
        if (!ko0VarA4.a.w) {
            z01.b("visitAncestors called on an unattached node");
        }
        dk1 dk1Var4 = ko0VarA4.a.f;
        n71 n71VarG = cm4.g(ko0VarA4);
        loop5: while (true) {
            if (n71VarG == null) {
                ko0Var = null;
                break;
            }
            if ((n71VarG.o0.f.e & 1024) != 0) {
                while (dk1Var4 != null) {
                    if ((dk1Var4.c & 1024) != 0) {
                        dk1 dk1VarB2 = dk1Var4;
                        pm1 pm1Var4 = null;
                        while (dk1VarB2 != null) {
                            if (dk1VarB2 instanceof ko0) {
                                ko0 ko0Var3 = (ko0) dk1VarB2;
                                if (ko0Var3.K0().a) {
                                    ko0Var = ko0Var3;
                                    break loop5;
                                }
                            } else if ((dk1VarB2.c & 1024) != 0 && (dk1VarB2 instanceof zb0)) {
                                int i7 = 0;
                                for (dk1 dk1Var5 = ((zb0) dk1VarB2).H; dk1Var5 != null; dk1Var5 = dk1Var5.i) {
                                    if ((dk1Var5.c & 1024) != 0) {
                                        i7++;
                                        if (i7 == 1) {
                                            dk1VarB2 = dk1Var5;
                                        } else {
                                            if (pm1Var4 == null) {
                                                pm1Var4 = new pm1(new dk1[16]);
                                            }
                                            if (dk1VarB2 != null) {
                                                pm1Var4.b(dk1VarB2);
                                                dk1VarB2 = null;
                                            }
                                            pm1Var4.b(dk1Var5);
                                        }
                                    }
                                }
                                if (i7 != 1) {
                                    dk1VarB2 = cm4.b(pm1Var4);
                                }
                            }
                            dk1VarB2 = cm4.b(pm1Var4);
                        }
                    }
                    dk1Var4 = dk1Var4.f;
                }
            }
            n71VarG = n71VarG.u();
            dk1Var4 = (n71VarG == null || (zn1Var = n71VarG.o0) == null) ? null : zn1Var.e;
        }
        if (ko0Var != null && ko0Var != ko0Var2) {
            zBooleanValue = ((Boolean) ke0Var.j(ko0Var)).booleanValue();
        }
        return Boolean.valueOf(zBooleanValue);
    }

    public final ko0 f() {
        ko0 ko0Var = this.h;
        if (ko0Var == null || !ko0Var.w) {
            return null;
        }
        return ko0Var;
    }

    public final boolean g(int i, boolean z) {
        t42 t42Var = new t42();
        t42Var.a = Boolean.FALSE;
        ko0 ko0VarF = f();
        Boolean boolE = e(i, this.a.getEmbeddedViewFocusRect(), new co0(i, t42Var));
        if (!g31.a(boolE, Boolean.TRUE) || ko0VarF == f()) {
            if (boolE != null && t42Var.a != null) {
                if (!boolE.booleanValue() || !((Boolean) t42Var.a).booleanValue()) {
                    if ((i == 1 || i == 2) && z && b(false, false, i)) {
                        Boolean boolE2 = e(i, null, new m7(i, 3));
                        if (boolE2 != null ? boolE2.booleanValue() : false) {
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final boolean h(int i) {
        if (!b(false, false, i)) {
            return false;
        }
        Boolean boolE = e(i, null, new m7(i, 2));
        boolean zBooleanValue = boolE != null ? boolE.booleanValue() : false;
        if (!zBooleanValue) {
            c();
        }
        return zBooleanValue;
    }

    public final void i(ko0 ko0Var) {
        ko0 ko0Var2 = this.h;
        this.h = ko0Var;
        yl1 yl1Var = this.g;
        Object[] objArr = yl1Var.a;
        int i = yl1Var.b;
        for (int i2 = 0; i2 < i; i2++) {
            ((wn0) objArr[i2]).a(ko0Var2, ko0Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r21v3, types: [int] */
    /* JADX WARN: Type inference failed for: r21v4 */
    /* JADX WARN: Type inference failed for: r21v5 */
    public final boolean j(KeyEvent keyEvent) {
        int iNumberOfTrailingZeros;
        boolean z;
        long j;
        int iNumberOfTrailingZeros2;
        long[] jArr;
        int i;
        long jA = h51.a(keyEvent);
        int iB = h51.b(keyEvent);
        int i2 = -862048943;
        long j2 = 0;
        char c = '\b';
        int i3 = 0;
        boolean z2 = true;
        if (iB != 2) {
            if (iB != 1) {
                return true;
            }
            sl1 sl1Var = this.f;
            if (sl1Var == null || !sl1Var.a(jA)) {
                return false;
            }
            sl1 sl1Var2 = this.f;
            if (sl1Var2 != null) {
                int iHashCode = Long.hashCode(jA) * (-862048943);
                int i4 = iHashCode ^ (iHashCode << 16);
                int i5 = i4 & 127;
                int i6 = sl1Var2.c;
                int i7 = i4 >>> 7;
                loop5: while (true) {
                    int i8 = i7 & i6;
                    long[] jArr2 = sl1Var2.a;
                    int i9 = i8 >> 3;
                    int i10 = (i8 & 7) << 3;
                    long j3 = ((jArr2[i9 + 1] << (64 - i10)) & ((-i10) >> 63)) | (jArr2[i9] >>> i10);
                    long j4 = (((long) i5) * 72340172838076673L) ^ j3;
                    for (long j5 = (~j4) & (j4 - 72340172838076673L) & (-9187201950435737472L); j5 != 0; j5 &= j5 - 1) {
                        iNumberOfTrailingZeros = ((Long.numberOfTrailingZeros(j5) >> 3) + i8) & i6;
                        if (sl1Var2.b[iNumberOfTrailingZeros] == jA) {
                            break loop5;
                        }
                    }
                    if ((j3 & ((~j3) << 6) & (-9187201950435737472L)) != 0) {
                        iNumberOfTrailingZeros = -1;
                        break;
                    }
                    i3 += 8;
                    i7 = i8 + i3;
                }
                if (iNumberOfTrailingZeros >= 0) {
                    sl1Var2.d--;
                    long[] jArr3 = sl1Var2.a;
                    int i11 = sl1Var2.c;
                    int i12 = iNumberOfTrailingZeros >> 3;
                    int i13 = (iNumberOfTrailingZeros & 7) << 3;
                    long j6 = (jArr3[i12] & (~(255 << i13))) | (254 << i13);
                    jArr3[i12] = j6;
                    jArr3[(((iNumberOfTrailingZeros - 7) & i11) + (i11 & 7)) >> 3] = j6;
                    return true;
                }
            }
            return true;
        }
        sl1 sl1Var3 = this.f;
        if (sl1Var3 == null) {
            sl1Var3 = new sl1(3);
            this.f = sl1Var3;
        }
        sl1 sl1Var4 = sl1Var3;
        int iHashCode2 = Long.hashCode(jA) * (-862048943);
        int i14 = iHashCode2 ^ (iHashCode2 << 16);
        int i15 = i14 >>> 7;
        int i16 = i14 & 127;
        int i17 = sl1Var4.c;
        int i18 = i15 & i17;
        int i19 = 0;
        loop0: while (true) {
            long[] jArr4 = sl1Var4.a;
            int i20 = i18 >> 3;
            int i21 = (i18 & 7) << 3;
            long j7 = (jArr4[i20] >>> i21) | ((jArr4[i20 + 1] << (64 - i21)) & ((-i21) >> 63));
            int i22 = i2;
            long j8 = i16;
            long j9 = j7 ^ (j8 * 72340172838076673L);
            long j10 = (j9 - 72340172838076673L) & (~j9) & (-9187201950435737472L);
            while (j10 != j2) {
                iNumberOfTrailingZeros2 = (i18 + (Long.numberOfTrailingZeros(j10) >> 3)) & i17;
                long j11 = j2;
                if (sl1Var4.b[iNumberOfTrailingZeros2] == jA) {
                    z = true;
                    break loop0;
                }
                j10 &= j10 - 1;
                j2 = j11;
            }
            long j12 = j2;
            if ((j7 & ((~j7) << 6) & (-9187201950435737472L)) != j12) {
                int iB2 = sl1Var4.b(i15);
                if (sl1Var4.e != 0 || ((sl1Var4.a[iB2 >> 3] >> ((iB2 & 7) << 3)) & 255) == 254) {
                    z = true;
                    j = 128;
                } else {
                    int i23 = sl1Var4.c;
                    if (i23 <= 8 || Long.compareUnsigned(((long) sl1Var4.d) * 32, ((long) i23) * 25) > 0) {
                        z = true;
                        j = 128;
                        int iB3 = ya2.b(sl1Var4.c);
                        long[] jArr5 = sl1Var4.a;
                        long[] jArr6 = sl1Var4.b;
                        int i24 = sl1Var4.c;
                        sl1Var4.c(iB3);
                        long[] jArr7 = sl1Var4.a;
                        long[] jArr8 = sl1Var4.b;
                        int i25 = sl1Var4.c;
                        int i26 = 0;
                        while (i26 < i24) {
                            if (((jArr5[i26 >> 3] >> ((i26 & 7) << 3)) & 255) < 128) {
                                long j13 = jArr6[i26];
                                int iHashCode3 = Long.hashCode(j13) * i22;
                                int i27 = iHashCode3 ^ (iHashCode3 << 16);
                                jArr = jArr7;
                                int iB4 = sl1Var4.b(i27 >>> 7);
                                long j14 = i27 & 127;
                                int i28 = iB4 >> 3;
                                int i29 = (iB4 & 7) << 3;
                                long j15 = (jArr[i28] & (~(255 << i29))) | (j14 << i29);
                                jArr[i28] = j15;
                                jArr[(((iB4 - 7) & i25) + (i25 & 7)) >> 3] = j15;
                                jArr8[iB4] = j13;
                            } else {
                                jArr = jArr7;
                            }
                            i26++;
                            jArr7 = jArr;
                            jArr5 = jArr5;
                            jArr6 = jArr6;
                        }
                    } else {
                        long[] jArr9 = sl1Var4.a;
                        int i30 = sl1Var4.c;
                        long[] jArr10 = sl1Var4.b;
                        int i31 = (i30 + 7) >> 3;
                        int i32 = 0;
                        while (i32 < i31) {
                            long j16 = jArr9[i32] & (-9187201950435737472L);
                            jArr9[i32] = ((~j16) + (j16 >>> 7)) & (-72340172838076674L);
                            i32++;
                            c = c;
                            i30 = i30;
                        }
                        char c2 = c;
                        int i33 = i30;
                        j = 128;
                        int iP = qg.p(jArr9);
                        int i34 = iP - 1;
                        long j17 = 72057594037927935L;
                        jArr9[i34] = (jArr9[i34] & 72057594037927935L) | (-72057594037927936L);
                        jArr9[iP] = jArr9[0];
                        int i35 = i33;
                        int i36 = 0;
                        while (i36 != i35) {
                            int i37 = i36 >> 3;
                            int i38 = (i36 & 7) << 3;
                            long j18 = (jArr9[i37] >> i38) & 255;
                            if (j18 != 128 && j18 == 254) {
                                int iHashCode4 = Long.hashCode(jArr10[i36]) * i22;
                                int i39 = iHashCode4 ^ (iHashCode4 << 16);
                                long j19 = j17;
                                int i40 = i39 >>> 7;
                                int iB5 = sl1Var4.b(i40);
                                int i41 = i40 & i35;
                                char c3 = c2;
                                if (((iB5 - i41) & i35) / 8 == ((i36 - i41) & i35) / 8) {
                                    jArr9[i37] = ((~(255 << i38)) & jArr9[i37]) | (((long) (i39 & 127)) << i38);
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36++;
                                } else {
                                    int i42 = iB5 >> 3;
                                    long j20 = jArr9[i42];
                                    int i43 = (iB5 & 7) << 3;
                                    if (((j20 >> i43) & 255) == 128) {
                                        int i44 = i36;
                                        jArr9[i42] = (j20 & (~(255 << i43))) | (((long) (i39 & 127)) << i43);
                                        jArr9[i37] = (jArr9[i37] & (~(255 << i38))) | (128 << i38);
                                        jArr10[iB5] = jArr10[i44];
                                        jArr10[i44] = j12;
                                        i = i44;
                                    } else {
                                        int i45 = i36;
                                        jArr9[i42] = (j20 & (~(255 << i43))) | (((long) (i39 & 127)) << i43);
                                        long j21 = jArr10[iB5];
                                        jArr10[iB5] = jArr10[i45];
                                        jArr10[i45] = j21;
                                        i = i45 - 1;
                                    }
                                    jArr9[jArr9.length - 1] = (jArr9[0] & j19) | Long.MIN_VALUE;
                                    i36 = i + 1;
                                    i35 = i35;
                                }
                                j17 = j19;
                                c2 = c3;
                                z2 = z2;
                            } else {
                                i36++;
                            }
                        }
                        z = z2;
                        sl1Var4.e = ya2.a(sl1Var4.c) - sl1Var4.d;
                    }
                    iB2 = sl1Var4.b(i15);
                }
                iNumberOfTrailingZeros2 = iB2;
                sl1Var4.d++;
                int i46 = sl1Var4.e;
                long[] jArr11 = sl1Var4.a;
                int i47 = iNumberOfTrailingZeros2 >> 3;
                long j22 = jArr11[i47];
                int i48 = (iNumberOfTrailingZeros2 & 7) << 3;
                sl1Var4.e = i46 - (((j22 >> i48) & 255) == j ? z : 0);
                int i49 = sl1Var4.c;
                long j23 = (j22 & (~(255 << i48))) | (j8 << i48);
                jArr11[i47] = j23;
                jArr11[(((iNumberOfTrailingZeros2 - 7) & i49) + (i49 & 7)) >> 3] = j23;
                break;
            }
            i19 += 8;
            i18 = (i18 + i19) & i17;
            i2 = i22;
            j2 = j12;
        }
        sl1Var4.b[iNumberOfTrailingZeros2] = jA;
        return z;
    }
}
