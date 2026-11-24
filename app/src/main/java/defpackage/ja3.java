package defpackage;

import android.content.Intent;
import android.net.Uri;
import com.ibm.icu.impl.number.Padder;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ja3 implements bl2 {
    public final b50 a;
    public final vw1 b;
    public final n21 c;
    public final r2 d;
    public final j5 e;
    public final bh f;
    public final Set g;
    public final l82 h;
    public final List i;
    public z93 j;
    public final an1 k;
    public aa3 l;
    public aa3 m;
    public boolean n;

    public ja3(b50 b50Var, vw1 vw1Var, n21 n21Var, r2 r2Var, j5 j5Var, bh bhVar) {
        b50Var.getClass();
        vw1Var.getClass();
        n21Var.getClass();
        r2Var.getClass();
        j5Var.getClass();
        bhVar.getClass();
        this.a = b50Var;
        this.b = vw1Var;
        this.c = n21Var;
        this.d = r2Var;
        this.e = j5Var;
        this.f = bhVar;
        this.g = wh2.c(new w3("message.whatsapp.draft"), new w3("message.whatsapp.send"));
        this.h = l82.c;
        this.i = nz.h("android.permission.READ_CONTACTS");
        this.k = new an1();
    }

    public static /* synthetic */ Object o(ja3 ja3Var, String str, String str2, String str3, String str4, y50 y50Var, int i) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        return ja3Var.n(str, str2, str3, str4, (i & 16) == 0, y50Var);
    }

    public static String q(List list) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ba3 ba3Var = (ba3) it.next();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("name", ba3Var.a);
            jSONObject.put("number", ba3Var.b);
            jSONArray.put(jSONObject);
        }
        String string = jSONArray.toString();
        string.getClass();
        return string;
    }

    public static hl2 r(z93 z93Var, String str) {
        return new hl2(ky0.k(str, Padder.FALLBACK_PADDING_STRING, w(z93Var), " Say 'send it' to try sending to the remaining recipients."), "Waiting for your 'send it' confirmation; completed recipients will not be sent again", new c73(z93Var.d + " of " + z93Var.b.size() + " send taps accepted"), null, true, 8);
    }

    public static boolean t(String str, String str2, String str3) {
        if (mf4.a(str, str2)) {
            return true;
        }
        return str3 != null && mf4.a(str, str3);
    }

    public static String w(z93 z93Var) {
        return cq.i("Confirmed ", z93Var.g.size(), " of ", z93Var.b.size(), ".");
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final Set b() {
        return this.g;
    }

    @Override // defpackage.bl2
    public final String d() {
        return "message.whatsapp";
    }

    @Override // defpackage.bl2
    public final String e() {
        return "Prepares messages for named recipients and sends after 'send it'.";
    }

    @Override // defpackage.bl2
    public final void f() {
        this.j = null;
        this.l = null;
        this.m = null;
        this.n = true;
    }

    /* JADX WARN: Code duplicated, block: B:106:0x0261 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:109:0x026a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0272 A[Catch: all -> 0x00c9, TRY_ENTER, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:113:0x028b A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:116:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:118:0x02b6  */
    /* JADX WARN: Code duplicated, block: B:120:0x02ba A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:122:0x02cf A[PHI: r0 r3 r11 r12 r13 r14 r15
      0x02cf: PHI (r0v16 ja3) = (r0v13 ja3), (r0v17 ja3) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r3v20 java.lang.String) = (r3v13 java.lang.String), (r3v21 java.lang.String) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r11v23 int) = (r11v17 int), (r11v24 int) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r12v17 an1) = (r12v10 an1), (r12v18 an1) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r13v25 boolean) = (r13v20 boolean), (r13v26 boolean) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r14v14 int) = (r14v9 int), (r14v15 int) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]
      0x02cf: PHI (r15v10 int) = (r15v5 int), (r15v11 int) binds: [B:110:0x0270, B:121:0x02ce] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:126:0x02d7 A[Catch: all -> 0x00c9, TRY_LEAVE, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:129:0x02f8  */
    /* JADX WARN: Code duplicated, block: B:132:0x0300 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:134:0x0308  */
    /* JADX WARN: Code duplicated, block: B:135:0x0309 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:139:0x0334  */
    /* JADX WARN: Code duplicated, block: B:141:0x0338 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:142:0x0377  */
    /* JADX WARN: Code duplicated, block: B:143:0x037a A[Catch: all -> 0x0041, PHI: r0 r1 r2 r11 r13 r14 r15
      0x037a: PHI (r0v19 ja3) = (r0v0 ja3), (r0v20 ja3) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r1v50 java.lang.String) = (r1v19 java.lang.String), (r1v52 java.lang.String) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r2v50 an1) = (r2v19 an1), (r2v51 an1) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r11v28 int) = (r11v10 int), (r11v29 int) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r13v28 boolean) = (r13v15 boolean), (r13v29 boolean) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r14v17 int) = (r14v5 int), (r14v18 int) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE]
      0x037a: PHI (r15v13 int) = (r15v1 int), (r15v14 int) binds: [B:142:0x0377, B:140:0x0336] A[DONT_GENERATE, DONT_INLINE], TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:145:0x0394  */
    /* JADX WARN: Code duplicated, block: B:148:0x03a9 A[Catch: all -> 0x0041, TRY_LEAVE, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:151:0x03ca  */
    /* JADX WARN: Code duplicated, block: B:154:0x03d5 A[Catch: all -> 0x0060, TryCatch #0 {all -> 0x0060, blocks: (B:19:0x0052, B:24:0x006e, B:152:0x03cf, B:154:0x03d5, B:157:0x03db), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:163:0x0405 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:168:0x0423  */
    /* JADX WARN: Code duplicated, block: B:59:0x014e  */
    /* JADX WARN: Code duplicated, block: B:60:0x0150  */
    /* JADX WARN: Code duplicated, block: B:63:0x0166 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:69:0x0180 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:71:0x0184 A[Catch: all -> 0x0041, TryCatch #1 {all -> 0x0041, blocks: (B:14:0x003c, B:166:0x0420, B:161:0x03ff, B:163:0x0405, B:27:0x0079, B:146:0x0396, B:130:0x02fc, B:132:0x0300, B:135:0x0309, B:141:0x0338, B:143:0x037a, B:137:0x0324, B:117:0x02af, B:120:0x02ba, B:104:0x025d, B:106:0x0261, B:61:0x0154, B:63:0x0166, B:67:0x0176, B:69:0x0180, B:71:0x0184, B:73:0x0190, B:147:0x039a, B:148:0x03a9, B:57:0x0135), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:79:0x01b9 A[Catch: all -> 0x00c9, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:80:0x01d5 A[Catch: all -> 0x00c9, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:82:0x01dd A[Catch: all -> 0x00c9, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:85:0x01e7 A[Catch: all -> 0x00c9, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code duplicated, block: B:87:0x020c  */
    /* JADX WARN: Code duplicated, block: B:88:0x020e  */
    /* JADX WARN: Code duplicated, block: B:8:0x001a  */
    /* JADX WARN: Code duplicated, block: B:91:0x0214 A[Catch: all -> 0x00c9, TryCatch #3 {all -> 0x00c9, blocks: (B:124:0x02d3, B:126:0x02d7, B:38:0x00c0, B:111:0x0272, B:113:0x028b, B:44:0x00db, B:89:0x0210, B:91:0x0214, B:94:0x021c, B:99:0x022d, B:100:0x0233, B:47:0x00f1, B:77:0x01b3, B:79:0x01b9, B:80:0x01d5, B:82:0x01dd, B:83:0x01e3, B:85:0x01e7, B:50:0x0104), top: B:174:0x002d }] */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x041d, code lost:
    
        if (r1 == r10) goto L165;
     */
    /* JADX WARN: Instruction removed from duplicated block: B:141:0x0338, please report this as an issue */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Not initialized variable reg: 11, insn: 0x0097: MOVE (r2 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:152), block:B:33:0x0097 */
    /* JADX WARN: Not initialized variable reg: 12, insn: 0x00ca: MOVE (r2 I:??[OBJECT, ARRAY]) = (r12 I:??[OBJECT, ARRAY]) (LINE:203), block:B:42:0x00ca */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v7 */
    @Override // defpackage.bl2
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object h(defpackage.f5 r19, defpackage.cl2 r20, defpackage.x50 r21) {
        /*
            Method dump skipped, instruction units count: 1098
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja3.h(f5, cl2, x50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        return a32.a;
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        return null;
    }

    @Override // defpackage.bl2
    public final List k() {
        return this.i;
    }

    @Override // defpackage.bl2
    public final l82 l() {
        return this.h;
    }

    @Override // defpackage.bl2
    public final String m() {
        return "WhatsApp";
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0094  */
    /* JADX WARN: Code duplicated, block: B:26:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:28:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:35:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:42:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:49:0x010b  */
    /* JADX WARN: Code duplicated, block: B:56:0x012a  */
    /* JADX WARN: Code duplicated, block: B:58:0x012e  */
    /* JADX WARN: Code duplicated, block: B:7:0x0017  */
    /* JADX WARN: Path cross not found for [B:28:0x00a6, B:34:0x00c7], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:35:0x00c9, B:41:0x00e7], limit reached: 57 */
    /* JADX WARN: Path cross not found for [B:42:0x00e9, B:48:0x0109], limit reached: 57 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x00c3 -> B:61:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00e4 -> B:61:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x0106 -> B:61:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:53:0x0126 -> B:61:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:57:0x012c -> B:61:0x0144). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x0141 -> B:61:0x0144). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object n(java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, boolean r22, defpackage.y50 r23) {
        /*
            Method dump skipped, instruction units count: 350
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja3.n(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0041  */
    /* JADX WARN: Code duplicated, block: B:19:0x0049  */
    /* JADX WARN: Code duplicated, block: B:21:0x0058  */
    /* JADX WARN: Code duplicated, block: B:37:0x008e  */
    /* JADX WARN: Code duplicated, block: B:39:0x00a2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:40:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x008c -> B:42:0x00a7). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00a3 -> B:41:0x00a5). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached at block B:43:0x00a9
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object p(defpackage.y93 r11, java.lang.String r12, java.lang.String r13, defpackage.y50 r14) {
        /*
            r10 = this;
            boolean r0 = r14 instanceof defpackage.da3
            if (r0 == 0) goto L13
            r0 = r14
            da3 r0 = (defpackage.da3) r0
            int r1 = r0.s
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.s = r1
            goto L18
        L13:
            da3 r0 = new da3
            r0.<init>(r10, r14)
        L18:
            java.lang.Object r14 = r0.k
            int r1 = r0.s
            r2 = 1
            if (r1 == 0) goto L35
            if (r1 != r2) goto L2e
            int r11 = r0.j
            java.lang.String r12 = r0.i
            java.lang.String r13 = r0.f
            y93 r1 = r0.e
            defpackage.bz3.g(r14)
            goto La5
        L2e:
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.og.n(r10)
            r10 = 0
            return r10
        L35:
            defpackage.bz3.g(r14)
            r14 = 0
            r9 = r12
            r12 = r11
            r11 = r14
            r14 = r13
            r13 = r9
        L3e:
            r1 = 7
            if (r11 >= r1) goto La9
            r2 r4 = r10.d
            y93 r1 = r4.g()
            if (r1 == 0) goto L8b
            java.lang.String r3 = r1.a
            java.lang.String r5 = r1.c
            java.lang.String r6 = r12.c
            r7 = r6
            java.lang.String r6 = r12.b
            boolean r5 = r5.equals(r7)
            if (r5 == 0) goto L88
            java.lang.String r1 = r1.b
            boolean r1 = r1.equals(r6)
            if (r1 == 0) goto L88
            boolean r1 = t(r3, r13, r14)
            if (r1 != 0) goto L67
            goto L88
        L67:
            boolean r1 = defpackage.mf4.a(r3, r13)
            if (r1 == 0) goto L6f
            r5 = r13
            goto L73
        L6f:
            r14.getClass()
            r5 = r14
        L73:
            java.lang.String r7 = r12.c
            g2 r3 = new g2
            r8 = 0
            r3.<init>(r4, r5, r6, r7, r8)
            java.lang.Object r1 = r4.s(r3)
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r1 = defpackage.g31.a(r1, r3)
            if (r1 == 0) goto L8b
            return r3
        L88:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        L8b:
            r1 = 6
            if (r11 >= r1) goto La7
            r0.e = r12
            r0.f = r13
            r0.i = r14
            r0.j = r11
            r0.s = r2
            r3 = 150(0x96, double:7.4E-322)
            java.lang.Object r1 = defpackage.bm4.b(r3, r0)
            t70 r3 = defpackage.t70.a
            if (r1 != r3) goto La3
            return r3
        La3:
            r1 = r12
            r12 = r14
        La5:
            r14 = r12
            r12 = r1
        La7:
            int r11 = r11 + r2
            goto L3e
        La9:
            java.lang.Boolean r10 = java.lang.Boolean.FALSE
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja3.p(y93, java.lang.String, java.lang.String, y50):java.lang.Object");
    }

    public final boolean s(y93 y93Var) {
        aa3 aa3Var = this.l;
        if (aa3Var == null) {
            return false;
        }
        y93 y93Var2 = aa3Var.a;
        if (!y93Var.c.equals(y93Var2.c) || !y93Var.b.equals(y93Var2.b)) {
            return false;
        }
        Set set = aa3Var.b;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (mf4.a(y93Var.a, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final fl2 u(ba3 ba3Var, String str) {
        String str2 = ba3Var.b;
        StringBuilder sb = new StringBuilder();
        int length = str2.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str2.charAt(i);
            if (Character.isDigit(cCharAt)) {
                sb.append(cCharAt);
            }
        }
        Uri uriBuild = Uri.parse("https://wa.me/".concat(sb.toString())).buildUpon().appendQueryParameter("text", str).build();
        Intent intent = new Intent("android.intent.action.VIEW", uriBuild);
        intent.setPackage("com.whatsapp");
        n21 n21Var = this.c;
        t61 t61VarA = n21Var.a(intent, "WhatsApp");
        if (t61VarA instanceof q61) {
            Intent intent2 = new Intent("android.intent.action.VIEW", uriBuild);
            intent2.setPackage("com.whatsapp.w4b");
            t61VarA = n21Var.a(intent2, "WhatsApp Business");
        }
        if (t61VarA instanceof p61) {
            return null;
        }
        if (t61VarA instanceof q61) {
            return new fl2("WhatsApp isn't available on this phone.", "no handler", null, false, 12);
        }
        if (t61VarA instanceof r61) {
            return new fl2("Android blocked WhatsApp.", "background launch blocked", null, false, 12);
        }
        if (t61VarA instanceof s61) {
            return new fl2("I won't open that link.", "launcher rejected uri", null, false, 12);
        }
        if (t61VarA instanceof o61) {
            return new fl2("I couldn't open WhatsApp.", "launch failed", null, false, 12);
        }
        dk0.l();
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:176:0x0390  */
    /* JADX WARN: Code duplicated, block: B:178:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:297:0x07be  */
    /* JADX WARN: Code duplicated, block: B:7:0x0019  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1, types: [java.util.ArrayList, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v14, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r11v16 */
    /* JADX WARN: Type inference failed for: r11v17 */
    /* JADX WARN: Type inference failed for: r11v18 */
    /* JADX WARN: Type inference failed for: r11v2 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21 */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v23 */
    /* JADX WARN: Type inference failed for: r11v24 */
    /* JADX WARN: Type inference failed for: r11v25 */
    /* JADX WARN: Type inference failed for: r11v26 */
    /* JADX WARN: Type inference failed for: r11v27 */
    /* JADX WARN: Type inference failed for: r11v3 */
    /* JADX WARN: Type inference failed for: r11v4, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v5, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r11v6 */
    /* JADX WARN: Type inference failed for: r11v7, types: [java.lang.Object, java.util.Collection, java.util.List] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:178:0x03ac -> B:179:0x03bb). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:183:0x03ec -> B:184:0x03f2). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object v(defpackage.f5 r36, defpackage.y50 r37) {
        /*
            Method dump skipped, instruction units count: 2103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja3.v(f5, y50):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:8:0x0014  */
    public final Object x(y93 y93Var, String str, String str2, String str3, y50 y50Var) {
        ha3 ha3Var;
        Object h72Var;
        String str4;
        String str5;
        String str6;
        String str7;
        if (y50Var instanceof ha3) {
            ha3Var = (ha3) y50Var;
            int i = ha3Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                ha3Var.s = i - Integer.MIN_VALUE;
            } else {
                ha3Var = new ha3(this, y50Var);
            }
        } else {
            ha3Var = new ha3(this, y50Var);
        }
        ha3 ha3Var2 = ha3Var;
        Object obj = ha3Var2.k;
        int i2 = ha3Var2.s;
        if (i2 == 0) {
            bz3.g(obj);
            try {
                h72Var = n61.a.d(y93Var.b);
            } catch (Throwable th) {
                h72Var = new h72(th);
            }
            if (h72Var instanceof h72) {
                h72Var = null;
            }
            String str8 = (String) h72Var;
            if (str8 != null) {
                if (str3 == null) {
                    str3 = y93Var.c;
                }
                String str9 = str3;
                boolean zEquals = str8.equals(y93Var.b);
                t70 t70Var = t70.a;
                if (zEquals) {
                    ha3Var2.e = null;
                    ha3Var2.f = null;
                    ha3Var2.i = null;
                    ha3Var2.j = null;
                    ha3Var2.s = 1;
                    Object objO = o(this, str, str2, str8, str9, ha3Var2, 16);
                    if (objO != t70Var) {
                        return objO;
                    }
                } else {
                    r2 r2Var = this.d;
                    r2Var.getClass();
                    if (g31.a(r2Var.s(new e2(r2Var, y93Var, str8)), Boolean.TRUE)) {
                        ha3Var2.e = str;
                        ha3Var2.f = str2;
                        ha3Var2.i = str8;
                        ha3Var2.j = str9;
                        ha3Var2.s = 2;
                        Object objO2 = o(this, str, str2, str8, str9, ha3Var2, 16);
                        if (objO2 != t70Var) {
                            obj = objO2;
                            str4 = str;
                            str5 = str2;
                            str6 = str8;
                            str7 = str9;
                        }
                    }
                }
                return t70Var;
            }
            return null;
        }
        if (i2 == 1) {
            bz3.g(obj);
            return obj;
        }
        if (i2 != 2) {
            og.n("call to 'resume' before 'invoke' with coroutine");
            return null;
        }
        str7 = ha3Var2.j;
        str6 = ha3Var2.i;
        str5 = ha3Var2.f;
        str4 = ha3Var2.e;
        bz3.g(obj);
        y93 y93Var2 = (y93) obj;
        if (y93Var2 != null && y93Var2.b.equals(str6) && y93Var2.c.equals(str7) && t(y93Var2.a, str4, str5)) {
            return y93Var2;
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:316:0x0808  */
    /* JADX WARN: Code duplicated, block: B:318:0x0816  */
    /* JADX WARN: Code duplicated, block: B:320:0x081c  */
    /* JADX WARN: Code duplicated, block: B:321:0x081f  */
    /* JADX WARN: Code duplicated, block: B:323:0x0822  */
    /* JADX WARN: Code duplicated, block: B:327:0x082b  */
    /* JADX WARN: Code duplicated, block: B:329:0x082e  */
    /* JADX WARN: Code duplicated, block: B:331:0x0832  */
    /* JADX WARN: Code duplicated, block: B:334:0x084f  */
    /* JADX WARN: Code duplicated, block: B:339:0x0866 A[PHI: r1
      0x0866: PHI (r1v146 int) = (r1v145 int), (r1v153 int) binds: [B:315:0x0806, B:328:0x082c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:341:0x0869  */
    /* JADX WARN: Code duplicated, block: B:345:0x0884  */
    /* JADX WARN: Code duplicated, block: B:348:0x088f  */
    /* JADX WARN: Code duplicated, block: B:349:0x0892  */
    /* JADX WARN: Code duplicated, block: B:351:0x0896  */
    /* JADX WARN: Code duplicated, block: B:353:0x08a5  */
    /* JADX WARN: Code duplicated, block: B:8:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:175:0x0494 -> B:176:0x04bd). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:198:0x0512 -> B:199:0x0514). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:200:0x0517 -> B:199:0x0514). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:334:0x084f -> B:335:0x0855). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:337:0x085e -> B:336:0x085b). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object y(java.lang.String r33, defpackage.y50 r34) {
        /*
            Method dump skipped, instruction units count: 2268
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.ja3.y(java.lang.String, y50):java.lang.Object");
    }

    @Override // defpackage.bl2
    public final void g() {
    }
}
