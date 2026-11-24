package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.textclassifier.TextClassification;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class km implements vq0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ Object c;

    public /* synthetic */ km(int i, int i2, Object obj, Object obj2) {
        this.a = i2;
        this.c = obj;
        this.b = obj2;
    }

    private final Object d(Object obj, Object obj2) {
        oz2 oz2Var;
        ny2 ny2Var = (ny2) this.c;
        s70 s70Var = (s70) this.b;
        ax2 ax2Var = (ax2) obj;
        Context context = (Context) obj2;
        boolean zJ = ny2Var.j();
        be beVarM = ny2Var.m();
        TextClassification textClassification = null;
        String str = beVarM != null ? beVarM.b : null;
        oz2 oz2Var2 = ny2Var.w;
        if (oz2Var2 != null) {
            long j = oz2Var2.a;
            mp1 mp1Var = ny2Var.b;
            oz2Var = new oz2(hc4.a(mp1Var.l((int) (j >> 32)), mp1Var.l((int) (j & 4294967295L))));
        } else {
            oz2Var = null;
        }
        sx1 sx1Var = ny2Var.j;
        e2 e2Var = new e2(ny2Var, s70Var, context, 14);
        sr2 sr2Var = ux1.a;
        if (Build.VERSION.SDK_INT < 28 || str == null || oz2Var == null || sx1Var == null || !(sx1Var instanceof sx1)) {
            e2Var.j(ax2Var);
            if (str != null && oz2Var != null) {
                pd3.a(ax2Var, context, zJ, str, oz2Var.a);
            }
        } else {
            long j2 = oz2Var.a;
            Object obj3 = sx1Var.h;
            an1 an1Var = sx1Var.e;
            if (an1Var.f()) {
                yw2 yw2Var = (yw2) sx1Var.g.getValue();
                TextClassification textClassification2 = (yw2Var != null && oz2.b(j2, yw2Var.b) && g31.a(str, yw2Var.a)) ? yw2Var.c : null;
                an1Var.h(null);
                textClassification = textClassification2;
            }
            if (textClassification == null) {
                e2Var.j(ax2Var);
            } else {
                if (!textClassification.getActions().isEmpty()) {
                    ax2Var.a.a(new px2(obj3, textClassification, 0));
                } else if ((textClassification.getIcon() != null || !TextUtils.isEmpty(textClassification.getLabel())) && (textClassification.getIntent() != null || textClassification.getOnClickListener() != null)) {
                    ax2Var.a.a(new px2(obj3, textClassification, -1));
                }
                e2Var.j(ax2Var);
                List actions = textClassification.getActions();
                int size = actions.size();
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        ax2Var.a.a(new px2(obj3, textClassification, i));
                    }
                }
            }
            pd3.a(ax2Var, context, zJ, str, oz2Var.a);
        }
        return q43.a;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x035b  */
    /* JADX WARN: Code duplicated, block: B:103:0x0364  */
    /* JADX WARN: Code duplicated, block: B:105:0x0373  */
    /* JADX WARN: Code duplicated, block: B:107:0x037f  */
    /* JADX WARN: Code duplicated, block: B:110:0x0393  */
    /* JADX WARN: Code duplicated, block: B:112:0x0399  */
    /* JADX WARN: Code duplicated, block: B:113:0x039d  */
    /* JADX WARN: Code duplicated, block: B:116:0x03ac  */
    /* JADX WARN: Code duplicated, block: B:118:0x03c2 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:120:0x03c5 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:127:0x03df A[LOOP:28: B:127:0x03df->B:129:0x03e8, LOOP_START, PHI: r3
      0x03df: PHI (r3v11 int) = (r3v10 int), (r3v12 int) binds: [B:126:0x03dd, B:129:0x03e8] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:129:0x03e8 A[LOOP:28: B:127:0x03df->B:129:0x03e8, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:132:0x03f1 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:135:0x0407  */
    /* JADX WARN: Code duplicated, block: B:139:0x0418  */
    /* JADX WARN: Code duplicated, block: B:142:0x0420  */
    /* JADX WARN: Code duplicated, block: B:145:0x042b  */
    /* JADX WARN: Code duplicated, block: B:147:0x044f  */
    /* JADX WARN: Code duplicated, block: B:149:0x0454  */
    /* JADX WARN: Code duplicated, block: B:151:0x049e  */
    /* JADX WARN: Code duplicated, block: B:153:0x04b1  */
    /* JADX WARN: Code duplicated, block: B:156:0x04bd A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:160:0x04cf  */
    /* JADX WARN: Code duplicated, block: B:162:0x04d4  */
    /* JADX WARN: Code duplicated, block: B:166:0x04e8 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:170:0x0508  */
    /* JADX WARN: Code duplicated, block: B:173:0x0516  */
    /* JADX WARN: Code duplicated, block: B:175:0x051a  */
    /* JADX WARN: Code duplicated, block: B:179:0x052b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:184:0x0549 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:192:0x0566  */
    /* JADX WARN: Code duplicated, block: B:194:0x056c  */
    /* JADX WARN: Code duplicated, block: B:195:0x0575  */
    /* JADX WARN: Code duplicated, block: B:199:0x058c  */
    /* JADX WARN: Code duplicated, block: B:201:0x0595 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:205:0x05bd  */
    /* JADX WARN: Code duplicated, block: B:206:0x05c3  */
    /* JADX WARN: Code duplicated, block: B:207:0x05c6  */
    /* JADX WARN: Code duplicated, block: B:210:0x05df  */
    /* JADX WARN: Code duplicated, block: B:213:0x05ef  */
    /* JADX WARN: Code duplicated, block: B:216:0x05f7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:223:0x0606  */
    /* JADX WARN: Code duplicated, block: B:226:0x0614 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:227:0x0616  */
    /* JADX WARN: Code duplicated, block: B:232:0x0628  */
    /* JADX WARN: Code duplicated, block: B:234:0x0636 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:240:0x065c  */
    /* JADX WARN: Code duplicated, block: B:242:0x065f  */
    /* JADX WARN: Code duplicated, block: B:245:0x066f A[LOOP:5: B:241:0x065d->B:245:0x066f, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:246:0x0674  */
    /* JADX WARN: Code duplicated, block: B:249:0x067f A[LOOP:6: B:249:0x067f->B:256:0x069e, LOOP_START, PHI: r1 r4
      0x067f: PHI (r1v120 ??) = (r1v177 ??), (r1v178 ??) binds: [B:248:0x067d, B:256:0x069e] A[DONT_GENERATE, DONT_INLINE]
      0x067f: PHI (r4v58 int) = (r4v34 int), (r4v62 int) binds: [B:248:0x067d, B:256:0x069e] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:251:0x068d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:252:0x068f  */
    /* JADX WARN: Code duplicated, block: B:256:0x069e A[LOOP:6: B:249:0x067f->B:256:0x069e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:258:0x06a2  */
    /* JADX WARN: Code duplicated, block: B:261:0x06ad A[LOOP:7: B:260:0x06ab->B:261:0x06ad, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:264:0x06de  */
    /* JADX WARN: Code duplicated, block: B:266:0x06e2  */
    /* JADX WARN: Code duplicated, block: B:269:0x06f6 A[LOOP:8: B:265:0x06e0->B:269:0x06f6, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:270:0x06ff  */
    /* JADX WARN: Code duplicated, block: B:272:0x0706  */
    /* JADX WARN: Code duplicated, block: B:277:0x071f  */
    /* JADX WARN: Code duplicated, block: B:279:0x072d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:280:0x072f  */
    /* JADX WARN: Code duplicated, block: B:281:0x073b  */
    /* JADX WARN: Code duplicated, block: B:283:0x0748  */
    /* JADX WARN: Code duplicated, block: B:287:0x0755  */
    /* JADX WARN: Code duplicated, block: B:288:0x0758  */
    /* JADX WARN: Code duplicated, block: B:291:0x0763 A[LOOP:10: B:290:0x0761->B:291:0x0763, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:294:0x077c  */
    /* JADX WARN: Code duplicated, block: B:299:0x078a  */
    /* JADX WARN: Code duplicated, block: B:302:0x0799  */
    /* JADX WARN: Code duplicated, block: B:303:0x079b  */
    /* JADX WARN: Code duplicated, block: B:305:0x079e A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:310:0x07c1  */
    /* JADX WARN: Code duplicated, block: B:312:0x07c7  */
    /* JADX WARN: Code duplicated, block: B:315:0x07ce  */
    /* JADX WARN: Code duplicated, block: B:318:0x07dc A[LOOP:11: B:317:0x07da->B:318:0x07dc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:321:0x07ed  */
    /* JADX WARN: Code duplicated, block: B:323:0x0802 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:324:0x0804 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:329:0x081d A[LOOP:12: B:327:0x0809->B:329:0x081d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:331:0x0825  */
    /* JADX WARN: Code duplicated, block: B:332:0x082d  */
    /* JADX WARN: Code duplicated, block: B:334:0x0838 A[LOOP:21: B:333:0x0836->B:334:0x0838, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:337:0x085d A[LOOP:22: B:336:0x085b->B:337:0x085d, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:340:0x0876 A[LOOP:23: B:339:0x0874->B:340:0x0876, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:343:0x089f  */
    /* JADX WARN: Code duplicated, block: B:345:0x08a4  */
    /* JADX WARN: Code duplicated, block: B:347:0x08b7  */
    /* JADX WARN: Code duplicated, block: B:349:0x08be A[LOOP:13: B:348:0x08bc->B:349:0x08be, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:353:0x08d0  */
    /* JADX WARN: Code duplicated, block: B:354:0x08d2  */
    /* JADX WARN: Code duplicated, block: B:357:0x08dc  */
    /* JADX WARN: Code duplicated, block: B:358:0x08df  */
    /* JADX WARN: Code duplicated, block: B:361:0x08e8  */
    /* JADX WARN: Code duplicated, block: B:362:0x08eb  */
    /* JADX WARN: Code duplicated, block: B:365:0x08f5  */
    /* JADX WARN: Code duplicated, block: B:433:0x0a38  */
    /* JADX WARN: Code duplicated, block: B:435:0x0a42  */
    /* JADX WARN: Code duplicated, block: B:437:0x0a4a  */
    /* JADX WARN: Code duplicated, block: B:438:0x0a51  */
    /* JADX WARN: Code duplicated, block: B:439:0x0a53  */
    /* JADX WARN: Code duplicated, block: B:441:0x0a59  */
    /* JADX WARN: Code duplicated, block: B:442:0x0a5b  */
    /* JADX WARN: Code duplicated, block: B:445:0x0a65  */
    /* JADX WARN: Code duplicated, block: B:447:0x0a6d  */
    /* JADX WARN: Code duplicated, block: B:449:0x0a75  */
    /* JADX WARN: Code duplicated, block: B:451:0x0a80  */
    /* JADX WARN: Code duplicated, block: B:452:0x0a86  */
    /* JADX WARN: Code duplicated, block: B:454:0x0a8e  */
    /* JADX WARN: Code duplicated, block: B:456:0x0a97 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:459:0x0a9d  */
    /* JADX WARN: Code duplicated, block: B:462:0x0ac0  */
    /* JADX WARN: Code duplicated, block: B:463:0x0ac5  */
    /* JADX WARN: Code duplicated, block: B:465:0x0ac8  */
    /* JADX WARN: Code duplicated, block: B:466:0x0acd  */
    /* JADX WARN: Code duplicated, block: B:469:0x0ad4  */
    /* JADX WARN: Code duplicated, block: B:470:0x0ad7  */
    /* JADX WARN: Code duplicated, block: B:472:0x0ae3  */
    /* JADX WARN: Code duplicated, block: B:474:0x0aed A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:557:0x0504 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:560:0x0533 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:561:0x052d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:571:0x0677 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:572:0x06a0 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:574:0x0704 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:580:0x0822 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:597:0x0af2 A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:603:0x061d A[ADDED_TO_REGION, REMOVE, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:608:0x0355 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:611:0x0380 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:617:0x03eb A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:81:0x0309  */
    /* JADX WARN: Code duplicated, block: B:82:0x030c  */
    /* JADX WARN: Code duplicated, block: B:88:0x0320  */
    /* JADX WARN: Code duplicated, block: B:90:0x032b  */
    /* JADX WARN: Code duplicated, block: B:92:0x0333  */
    /* JADX WARN: Code duplicated, block: B:94:0x0348  */
    /* JADX WARN: Code duplicated, block: B:96:0x0354  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [ii0] */
    /* JADX WARN: Type inference failed for: r11v39 */
    /* JADX WARN: Type inference failed for: r11v40, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r11v85 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r1v119 */
    /* JADX WARN: Type inference failed for: r1v120 */
    /* JADX WARN: Type inference failed for: r1v121 */
    /* JADX WARN: Type inference failed for: r1v122, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v124 */
    /* JADX WARN: Type inference failed for: r1v125 */
    /* JADX WARN: Type inference failed for: r1v126, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v127, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v176 */
    /* JADX WARN: Type inference failed for: r1v177 */
    /* JADX WARN: Type inference failed for: r1v178 */
    /* JADX WARN: Type inference failed for: r1v179 */
    /* JADX WARN: Type inference failed for: r1v180 */
    /* JADX WARN: Type inference failed for: r1v181 */
    /* JADX WARN: Type inference failed for: r1v182 */
    /* JADX WARN: Type inference failed for: r1v183 */
    /* JADX WARN: Type inference failed for: r1v53 */
    /* JADX WARN: Type inference failed for: r1v54 */
    /* JADX WARN: Type inference failed for: r1v55 */
    /* JADX WARN: Type inference failed for: r1v56, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r1v57, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v62 */
    /* JADX WARN: Type inference failed for: r25v16, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r25v7 */
    /* JADX WARN: Type inference failed for: r25v8, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r25v9 */
    /* JADX WARN: Type inference failed for: r2v52 */
    /* JADX WARN: Type inference failed for: r2v53, types: [java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r2v99 */
    /* JADX WARN: Type inference failed for: r41v3 */
    /* JADX WARN: Type inference failed for: r41v4 */
    /* JADX WARN: Type inference failed for: r9v21 */
    /* JADX WARN: Type inference failed for: r9v7, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r9v8, types: [java.util.Collection, java.util.List] */
    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i;
        x20 x20Var;
        boolean z;
        int i2;
        int iH;
        c91 c91Var;
        tm tmVar;
        pm1 pm1Var;
        boolean z2;
        Object r10;
        Object arrayList;
        h21 h21Var;
        int size;
        int i3;
        int i4;
        int i5;
        int iA;
        int i6;
        Object[] objArr;
        int i7;
        int i8;
        int i9;
        Object[] objArr2;
        int i10;
        int i11;
        int i12;
        int i13;
        float fFloatValue;
        t81 t81Var;
        boolean zS;
        s70 s70Var;
        mm1 mm1Var;
        nr4 nr4Var;
        ji0 ji0Var;
        t91 t91Var;
        float f;
        int i14;
        int i15;
        int i16;
        int iRound;
        int i17;
        int i18;
        hg hgVar;
        int i19;
        int i20;
        int i21;
        int iMax;
        long j;
        int i22;
        int i23;
        int i24;
        int i25;
        int i26;
        int i27;
        int i28;
        int i29;
        boolean z3;
        int iMax2;
        int i30;
        boolean z4;
        int i31;
        int i32;
        int i33;
        int i34;
        int i35;
        int i36;
        float f2;
        float f3;
        float f4;
        float f5;
        int i37;
        y91 y91Var;
        float f6;
        int iA2;
        float f7;
        int i38;
        int iMax3;
        int i39;
        int i40;
        Object arrayList2;
        int size2;
        int size3;
        int iMax4;
        int i41;
        int iMin;
        int i42;
        int i43;
        int i44;
        ArrayList arrayList3;
        int size4;
        int i45;
        ArrayList arrayList4;
        Object r2;
        int size5;
        int iMax5;
        int i46;
        boolean z5;
        int iG;
        int iF;
        boolean z6;
        boolean z7;
        ArrayList arrayList5;
        jc0 jc0Var;
        int size6;
        int i47;
        int i48;
        Object r1;
        int iA3;
        int i49;
        int i50;
        int size7;
        int i51;
        boolean z8;
        Object obj3;
        y91 y91Var2;
        int i52;
        y91 y91Var3;
        int i53;
        boolean z9;
        y91 y91Var4;
        int i54;
        Object r11;
        Object obj4;
        y91 y91Var5;
        Integer numValueOf;
        y91 y91Var6;
        Integer numValueOf2;
        boolean z10;
        xs2 xs2Var;
        int iIntValue;
        int iIntValue2;
        int size8;
        int i55;
        Object r25;
        int i56;
        x91 x91Var;
        y91 y91Var7;
        y91 y91Var8;
        int i57;
        ll1 ll1Var;
        int i58;
        Object obj5;
        int i59;
        int iMax6;
        int i60;
        int iC;
        int iF2;
        int size9;
        int i61;
        int iA4;
        int[] iArr;
        int i62;
        int[] iArr2;
        int i63;
        int i64;
        int i65;
        int i66;
        ArrayList arrayList6;
        int iIntValue3;
        ArrayList arrayList7;
        ArrayList arrayList8;
        Object r3;
        int i67;
        int iIntValue4;
        Object arrayList9;
        int i68;
        int i69;
        int i70;
        int i71;
        int iJ;
        int i72;
        int i73 = this.a;
        xy xyVar = r20.a;
        q43 q43Var = q43.a;
        Object obj6 = this.b;
        Object obj7 = this.c;
        switch (i73) {
            case 0:
                xs2 xs2Var2 = (xs2) obj;
                q40 q40Var = (q40) obj2;
                return ((oh1) obj7).f(xs2Var2, xs2Var2.F(new w10(-431986394, true, new km(1, (w10) obj6, (Object) new lm(xs2Var2, q40Var.a))), q43Var), q40Var.a);
            case 1:
                w10 w10Var = (w10) obj6;
                lm lmVar = (lm) obj7;
                x20 x20Var2 = (x20) obj;
                int iIntValue5 = ((Integer) obj2).intValue();
                if (x20Var2.O(iIntValue5 & 1, (iIntValue5 & 3) != 2)) {
                    w10Var.c(lmVar, x20Var2, 0);
                } else {
                    x20Var2.R();
                }
                return q43Var;
            case 2:
                i52 i52Var = (i52) obj7;
                rl2 rl2Var = (rl2) obj6;
                int iIntValue6 = ((Integer) obj).intValue();
                if (obj2 instanceof d20) {
                    ((pm1) i52Var.e).b((d20) obj2);
                } else if (!(obj2 instanceof s72)) {
                    if (obj2 instanceof k52) {
                        jy3.f(rl2Var, iIntValue6, obj2);
                        i52Var.e((k52) obj2);
                    } else if (obj2 instanceof a42) {
                        jy3.f(rl2Var, iIntValue6, obj2);
                        ((a42) obj2).c();
                    }
                }
                return q43Var;
            case 3:
                ((Integer) obj2).getClass();
                ((r50) obj7).a((q50) obj6, (x20) obj, ny3.c(1));
                return q43Var;
            case 4:
                dx2 dx2Var = (dx2) obj7;
                ox2 ox2Var = (ox2) obj6;
                x20 x20Var3 = (x20) obj;
                int iIntValue7 = ((Integer) obj2).intValue();
                if (x20Var3.O(iIntValue7 & 1, (iIntValue7 & 3) != 2)) {
                    boolean zF = x20Var3.f(dx2Var);
                    Object objL = x20Var3.L();
                    if (zF || objL == xyVar) {
                        objL = o44.b(new g7(0, dx2Var, dx2.class, "data", "data()Landroidx/compose/foundation/text/contextmenu/data/TextContextMenuData;", 0, 0, 1));
                        x20Var3.g0(objL);
                    }
                    jb0.a(ox2Var, (cx2) ((gr2) objL).getValue(), x20Var3, 0);
                } else {
                    x20Var3.R();
                }
                return q43Var;
            case 5:
                ((Integer) obj2).getClass();
                jb0.a((ox2) obj7, (cx2) obj6, (x20) obj, ny3.c(1));
                return q43Var;
            case 6:
                v81 v81Var = (v81) obj7;
                u81 u81Var = (u81) obj6;
                Object obj8 = u81Var.a;
                x20 x20Var4 = (x20) obj;
                int iIntValue8 = ((Integer) obj2).intValue();
                if (x20Var4.O(iIntValue8 & 1, (iIntValue8 & 3) != 2)) {
                    t91 t91Var2 = (t91) v81Var.b.a();
                    int iC2 = u81Var.c;
                    if (iC2 >= t91Var2.c() || !t91Var2.d(iC2).equals(obj8)) {
                        iC2 = t91Var2.d.c(obj8);
                        i = -1;
                        if (iC2 != -1) {
                            u81Var.c = iC2;
                        }
                    } else {
                        i = -1;
                    }
                    if (iC2 != i) {
                        x20Var4.W(-1664741271);
                        zp4.a(t91Var2, v81Var.a, iC2, obj8, x20Var4, 0);
                        x20Var = x20Var4;
                        z = false;
                    } else {
                        x20Var = x20Var4;
                        z = false;
                        x20Var.W(-1668376610);
                    }
                    x20Var.p(z);
                    boolean zH = x20Var.h(u81Var);
                    Object objL2 = x20Var.L();
                    if (zH || objL2 == xyVar) {
                        objL2 = new x0(14, u81Var);
                        x20Var.g0(objL2);
                    }
                    bz3.a(obj8, (hq0) objL2, x20Var);
                } else {
                    x20Var4.R();
                }
                return q43Var;
            case 7:
                boolean zA = l21.a(0L, 0L);
                w91 w91Var = (w91) obj6;
                xs2 xs2Var3 = (xs2) obj;
                y81 y81Var = new y81((v81) obj7, xs2Var3);
                long j2 = ((q40) obj2).a;
                w91Var.getClass();
                fg fgVar = w91Var.d;
                qt1 qt1Var = w91Var.b;
                float f8 = qt1Var.c;
                float f9 = qt1Var.a;
                ea1 ea1Var = w91Var.a;
                ea1Var.s.getValue();
                boolean z11 = ea1Var.b || xs2Var3.s();
                js1 js1Var = js1.a;
                rh4.a(j2, js1Var);
                z61 layoutDirection = xs2Var3.getLayoutDirection();
                z61 z61Var = z61.a;
                int iR = xs2Var3.R(layoutDirection == z61Var ? f9 : f8);
                if (xs2Var3.getLayoutDirection() != z61Var) {
                    f8 = f9;
                }
                int iR2 = xs2Var3.R(f8);
                int iR3 = xs2Var3.R(qt1Var.b);
                int iR4 = xs2Var3.R(qt1Var.d) + iR3;
                int i74 = iR2 + iR;
                int i75 = iR4 - iR3;
                long jI = r40.i(-i74, -iR4, j2);
                t91 t91Var3 = (t91) w91Var.c.a();
                k81 k81Var = t91Var3.c;
                int iH2 = q40.h(jI);
                int iG2 = q40.g(jI);
                k81Var.a.h(iH2);
                k81Var.b.h(iG2);
                if (fgVar != null) {
                    int iR5 = xs2Var3.R(fgVar.a());
                    int iC3 = t91Var3.c();
                    int iG3 = q40.g(j2) - iR4;
                    v91 v91Var = new v91(jI, t91Var3, y81Var, iC3, iR5, w91Var.g, iR3, i75, (((long) iR) << 32) | (((long) iR3) & 4294967295L), w91Var.a);
                    bm2 bm2VarA = i44.a();
                    hq0 hq0VarE = bm2VarA != null ? bm2VarA.e() : null;
                    bm2 bm2VarB = i44.b(bm2VarA);
                    try {
                        int iG4 = ea1Var.g();
                        ux uxVar = ea1Var.e;
                        int iA5 = aq4.a(iG4, t91Var3, uxVar.d);
                        if (iG4 != iA5) {
                            i2 = iR3;
                            ((hu1) uxVar.b).h(iA5);
                            z81 z81Var = (z81) uxVar.e;
                            if (iG4 != z81Var.b) {
                                z81Var.b = iG4;
                                int i76 = (iG4 / 30) * 30;
                                z81Var.a.setValue(ky3.f(Math.max(i76 - 100, 0), i76 + 130));
                            }
                            iH = ea1Var.h();
                            i44.e(bm2VarA, bm2VarB, hq0VarE);
                            c91Var = ea1Var.r;
                            tmVar = ea1Var.o;
                            pm1Var = tmVar.a;
                            if (pm1Var.c != 0) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            r10 = ii0.a;
                            if (z2 && c91Var.a.isEmpty()) {
                                iH = iH;
                                arrayList = r10;
                                r10 = arrayList;
                            } else {
                                arrayList = new ArrayList();
                                if (tmVar.a.c != 0) {
                                    i6 = pm1Var.c;
                                    if (i6 != 0) {
                                        objArr = pm1Var.a;
                                        i7 = ((l81) objArr[0]).a;
                                        i8 = 0;
                                        while (i8 < i6) {
                                            int i77 = i8;
                                            i13 = ((l81) objArr[i8]).a;
                                            if (i13 < i7) {
                                                i7 = i13;
                                            }
                                            i8 = i77 + 1;
                                        }
                                        if (i7 < 0) {
                                            c11.a("negative minIndex");
                                        }
                                        i9 = pm1Var.c;
                                        if (i9 != 0) {
                                            objArr2 = pm1Var.a;
                                            i10 = ((l81) objArr2[0]).b;
                                            i11 = 0;
                                            while (i11 < i9) {
                                                int i78 = i11;
                                                i12 = ((l81) objArr2[i11]).b;
                                                if (i12 > i10) {
                                                    i10 = i12;
                                                }
                                                i11 = i78 + 1;
                                            }
                                            h21Var = new h21(i7, Math.min(i10, t91Var3.c() - 1), 1);
                                        } else {
                                            kf2.g("MutableVector is empty.");
                                        }
                                    } else {
                                        kf2.g("MutableVector is empty.");
                                    }
                                } else {
                                    h21Var = h21.e;
                                }
                                size = c91Var.a.size();
                                i3 = 0;
                                while (i3 < size) {
                                    a91 a91Var = (a91) c91Var.get(i3);
                                    iA = aq4.a(a91Var.c, t91Var3, a91Var.a);
                                    int i79 = h21Var.a;
                                    c91 c91Var2 = c91Var;
                                    if ((iA <= h21Var.b || i79 > iA) && iA >= 0 && iA < t91Var3.c()) {
                                        arrayList.add(Integer.valueOf(iA));
                                    }
                                    i3++;
                                    c91Var = c91Var2;
                                }
                                i4 = h21Var.a;
                                i5 = h21Var.b;
                                if (i4 <= i5) {
                                    while (true) {
                                        arrayList.add(Integer.valueOf(i4));
                                        if (i4 != i5) {
                                            i4++;
                                        }
                                    }
                                }
                            }
                            if (xs2Var3.s() && z11) {
                                fFloatValue = ((Number) ((qd) ea1Var.w.c).b.getValue()).floatValue();
                            } else {
                                fFloatValue = ea1Var.h;
                            }
                            t81Var = ea1Var.n;
                            zS = xs2Var3.s();
                            s70Var = w91Var.e;
                            mm1Var = ea1Var.v;
                            nr4Var = w91Var.f;
                            if (i2 < 0) {
                                c11.a("invalid beforeContentPadding");
                            }
                            if (i75 < 0) {
                                c11.a("invalid afterContentPadding");
                            }
                            ji0Var = ji0.a;
                            t91Var = v91Var.b;
                            if (iC3 <= 0) {
                                iJ = q40.j(jI);
                                i72 = q40.i(jI);
                                t81Var.b(iJ, i72, new ArrayList(), t91Var.d, v91Var, zS, z11, 0, 0);
                                if (!zS) {
                                    t81Var.a();
                                    if (!zA) {
                                        iJ = r40.g(0, jI);
                                        i72 = r40.f(0, jI);
                                    }
                                }
                                xs2Var = xs2Var3;
                                x91Var = new x91(null, 0, false, 0.0f, xs2Var3.j0(r40.g(iJ + i74, j2), r40.f(i72 + iR4, j2), ji0Var, new j(7)), 0.0f, false, s70Var, y81Var, v91Var.d, r10, -i2, iG3 + i75, 0, js1Var, i75, iR5);
                            } else {
                                f = fFloatValue;
                                i14 = iA5;
                                boolean z12 = z11;
                                i15 = iC3;
                                i16 = i2;
                                if (i14 >= i15) {
                                    i14 = i15 - 1;
                                    iH = 0;
                                }
                                iRound = Math.round(f);
                                i17 = iH - iRound;
                                if (i14 == 0 && i17 < 0) {
                                    iRound += i17;
                                    i17 = 0;
                                }
                                i18 = i14;
                                hgVar = new hg();
                                int i80 = -i16;
                                if (iR5 < 0) {
                                    i19 = iR5;
                                } else {
                                    i19 = 0;
                                }
                                i20 = i80 + i19;
                                i21 = i17 + i20;
                                iMax = 0;
                                while (true) {
                                    j = v91Var.d;
                                    if (i21 >= 0 && i18 > 0) {
                                        mm1 mm1Var2 = mm1Var;
                                        int i81 = i18 - 1;
                                        y91 y91VarA = v91Var.a(i81, j);
                                        hgVar.add(0, y91VarA);
                                        iMax = Math.max(iMax, y91VarA.m);
                                        i21 += y91VarA.l;
                                        i18 = i81;
                                        mm1Var = mm1Var2;
                                    }
                                }
                                mm1 mm1Var3 = mm1Var;
                                if (i21 < i20) {
                                    iRound -= i20 - i21;
                                    i21 = i20;
                                }
                                i22 = iRound;
                                int i82 = i21 - i20;
                                i23 = iG3 + i75;
                                int i83 = iMax;
                                if (i23 < 0) {
                                    i24 = 0;
                                } else {
                                    i24 = i23;
                                }
                                i25 = i80;
                                i26 = -i82;
                                i27 = i82;
                                i28 = i18;
                                i29 = 0;
                                z3 = false;
                                while (i29 < hgVar.c) {
                                    if (i26 >= i24) {
                                        hgVar.b(i29);
                                        z3 = true;
                                    } else {
                                        i28++;
                                        i26 += ((y91) hgVar.get(i29)).l;
                                        i29++;
                                    }
                                }
                                iMax2 = i83;
                                i30 = i28;
                                z4 = z3;
                                while (i30 < i15 && (i26 < i24 || i26 <= 0 || hgVar.isEmpty())) {
                                    int i84 = i24;
                                    y91 y91VarA2 = v91Var.a(i30, j);
                                    i69 = i15;
                                    i70 = y91VarA2.l;
                                    i26 += i70;
                                    if (i26 <= i20) {
                                        i71 = i20;
                                        if (i30 != i69 - 1) {
                                            i27 -= i70;
                                            i18 = i30 + 1;
                                            z4 = true;
                                        }
                                        i30++;
                                        i24 = i84;
                                        i20 = i71;
                                        i15 = i69;
                                    } else {
                                        i71 = i20;
                                    }
                                    int iMax7 = Math.max(iMax2, y91VarA2.m);
                                    hgVar.addLast(y91VarA2);
                                    iMax2 = iMax7;
                                    i30++;
                                    i24 = i84;
                                    i20 = i71;
                                    i15 = i69;
                                }
                                i31 = i15;
                                if (i26 < iG3) {
                                    i68 = iG3 - i26;
                                    i26 += i68;
                                    i35 = i27 - i68;
                                    while (i35 < i16 && i18 > 0) {
                                        int i85 = i68;
                                        int i86 = i18 - 1;
                                        int i87 = i16;
                                        y91 y91VarA3 = v91Var.a(i86, j);
                                        i18 = i86;
                                        hgVar.add(0, y91VarA3);
                                        iMax2 = Math.max(iMax2, y91VarA3.m);
                                        i35 += y91VarA3.l;
                                        i68 = i85;
                                        i16 = i87;
                                    }
                                    i32 = i16;
                                    i33 = i22 + i68;
                                    if (i35 < 0) {
                                        i33 += i35;
                                        i26 += i35;
                                        i34 = i18;
                                        i35 = 0;
                                    } else {
                                        i34 = i18;
                                    }
                                } else {
                                    i32 = i16;
                                    i33 = i22;
                                    i34 = i18;
                                    i35 = i27;
                                }
                                int i88 = iMax2;
                                i36 = i30;
                                if (Integer.signum(Math.round(f)) == Integer.signum(i33) || Math.abs(Math.round(f)) < Math.abs(i33)) {
                                    f2 = f;
                                } else {
                                    f2 = i33;
                                }
                                f3 = f - f2;
                                f4 = 0.0f;
                                if (zS && i33 > i22 && f3 <= 0.0f) {
                                    f4 = (i33 - i22) + f3;
                                }
                                f5 = f4;
                                if (i35 < 0) {
                                    c11.a("negative currentFirstItemScrollOffset");
                                }
                                i37 = -i35;
                                y91Var = (y91) hgVar.first();
                                if (i32 <= 0 || iR5 < 0) {
                                    f6 = f5;
                                    iA2 = hgVar.a();
                                    f7 = f2;
                                    i38 = 0;
                                    while (i38 < iA2) {
                                        int i89 = iA2;
                                        int i90 = ((y91) hgVar.get(i38)).l;
                                        if (i35 == 0 && i90 <= i35 && i38 != hgVar.a() - 1) {
                                            i35 -= i90;
                                            i38++;
                                            y91Var = (y91) hgVar.get(i38);
                                            iA2 = i89;
                                        }
                                    }
                                } else {
                                    f6 = f5;
                                    f7 = f2;
                                }
                                iMax3 = Math.max(0, i34);
                                i39 = i34 - 1;
                                if (iMax3 <= i39) {
                                    arrayList2 = 0;
                                    while (true) {
                                        if (arrayList2 == 0) {
                                            arrayList2 = new ArrayList();
                                        }
                                        i40 = i37;
                                        arrayList2.add(v91Var.a(i39, j));
                                        if (i39 != iMax3) {
                                            i39--;
                                            i37 = i40;
                                            arrayList2 = arrayList2;
                                        }
                                    }
                                } else {
                                    i40 = i37;
                                    arrayList2 = 0;
                                }
                                size2 = arrayList.size() - 1;
                                r3 = arrayList2;
                                if (size2 >= 0) {
                                    while (true) {
                                        i67 = size2 - 1;
                                        iIntValue4 = ((Number) arrayList.get(size2)).intValue();
                                        arrayList9 = r3;
                                        arrayList2 = r3;
                                        if (iIntValue4 < iMax3) {
                                            if (r3 == 0) {
                                                arrayList9 = new ArrayList();
                                            }
                                            arrayList9.add(v91Var.a(iIntValue4, j));
                                            arrayList2 = arrayList9;
                                        }
                                        if (i67 >= 0) {
                                            size2 = i67;
                                            r3 = arrayList2;
                                        }
                                    }
                                }
                                if (arrayList2 == 0) {
                                    arrayList2 = r10;
                                }
                                iMax4 = i88;
                                i41 = 0;
                                for (size3 = arrayList2.size(); i41 < size3; size3 = size3) {
                                    iMax4 = Math.max(iMax4, ((y91) arrayList2.get(i41)).m);
                                    i41++;
                                }
                                iMin = Math.min(((y91) mz.D(hgVar)).a, i31 - 1);
                                i42 = ((y91) mz.D(hgVar)).a + 1;
                                if (i42 <= iMin) {
                                    arrayList8 = null;
                                    while (true) {
                                        if (arrayList8 == null) {
                                            arrayList8 = new ArrayList();
                                        }
                                        i43 = iMax4;
                                        i44 = i35;
                                        arrayList3 = arrayList8;
                                        arrayList3.add(v91Var.a(i42, j));
                                        if (i42 != iMin) {
                                            i42++;
                                            arrayList8 = arrayList3;
                                            iMax4 = i43;
                                            i35 = i44;
                                        }
                                    }
                                } else {
                                    i43 = iMax4;
                                    i44 = i35;
                                    arrayList3 = null;
                                }
                                if (arrayList3 != null && ((y91) mz.D(arrayList3)).a > iMin) {
                                    iMin = ((y91) mz.D(arrayList3)).a;
                                }
                                size4 = arrayList.size();
                                i45 = 0;
                                while (i45 < size4) {
                                    arrayList6 = arrayList3;
                                    iIntValue3 = ((Number) arrayList.get(i45)).intValue();
                                    if (iIntValue3 > iMin) {
                                        if (arrayList6 == null) {
                                            arrayList7 = new ArrayList();
                                        } else {
                                            arrayList7 = arrayList6;
                                        }
                                        arrayList7.add(v91Var.a(iIntValue3, j));
                                        arrayList3 = arrayList7;
                                    } else {
                                        iMin = iMin;
                                        arrayList3 = arrayList6;
                                    }
                                    i45++;
                                    iMin = iMin;
                                }
                                arrayList4 = arrayList3;
                                if (arrayList4 == null) {
                                    r2 = r10;
                                } else {
                                    r2 = arrayList4;
                                }
                                size5 = r2.size();
                                iMax5 = i43;
                                for (i46 = 0; i46 < size5; i46++) {
                                    iMax5 = Math.max(iMax5, ((y91) r2.get(i46)).m);
                                }
                                if (!g31.a(y91Var, hgVar.first()) && arrayList2.isEmpty() && r2.isEmpty()) {
                                    z5 = true;
                                } else {
                                    z5 = false;
                                }
                                iG = r40.g(iMax5, jI);
                                iF = r40.f(i26, jI);
                                if (i26 < Math.min(iF, iG3)) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6 && i40 != 0) {
                                    c11.c("non-zero itemsScrollOffset");
                                }
                                z7 = z5;
                                int i91 = i26;
                                arrayList5 = new ArrayList(r2.size() + arrayList2.size() + hgVar.a());
                                if (z6) {
                                    if (arrayList2.isEmpty() || !r2.isEmpty()) {
                                        c11.a("no extra items");
                                    }
                                    iA4 = hgVar.a();
                                    iArr = new int[iA4];
                                    for (i62 = 0; i62 < iA4; i62++) {
                                        iArr[i62] = ((y91) hgVar.get(i62)).k;
                                    }
                                    iArr2 = new int[iA4];
                                    if (fgVar != null) {
                                        fgVar.i(iF, r4, iArr, iArr2);
                                        jc0Var = r4;
                                        h21 h21Var2 = new h21(0, iA4 - 1, 1);
                                        i63 = h21Var2.b;
                                        i64 = h21Var2.c;
                                        if ((i64 <= 0 && i63 >= 0) || (i64 < 0 && i63 <= 0)) {
                                            i65 = 0;
                                            while (true) {
                                                int i92 = iArr2[i65];
                                                i66 = i64;
                                                y91 y91Var9 = (y91) hgVar.get(i65);
                                                y91Var9.c(i92, iG, iF);
                                                arrayList5.add(y91Var9);
                                                if (i65 != i63) {
                                                    i65 += i66;
                                                    i64 = i66;
                                                }
                                            }
                                        }
                                    } else {
                                        c11.b("null verticalArrangement when isVertical == true");
                                        og.k();
                                    }
                                } else {
                                    jc0Var = r4;
                                    size6 = arrayList2.size();
                                    i47 = i40;
                                    i48 = 0;
                                    r1 = arrayList2;
                                    while (i48 < size6) {
                                        var r17 = r1;
                                        y91 y91Var10 = (y91) r1.get(i48);
                                        i47 -= y91Var10.l;
                                        y91Var10.c(i47, iG, iF);
                                        arrayList5.add(y91Var10);
                                        i48++;
                                        size6 = size6;
                                        r1 = r17;
                                    }
                                    iA3 = hgVar.a();
                                    i49 = i40;
                                    for (i50 = 0; i50 < iA3; i50++) {
                                        y91 y91Var11 = (y91) hgVar.get(i50);
                                        y91Var11.c(i49, iG, iF);
                                        arrayList5.add(y91Var11);
                                        i49 += y91Var11.l;
                                    }
                                    size7 = r2.size();
                                    for (i51 = 0; i51 < size7; i51++) {
                                        y91 y91Var12 = (y91) r2.get(i51);
                                        y91Var12.c(i49, iG, iF);
                                        arrayList5.add(y91Var12);
                                        i49 += y91Var12.l;
                                    }
                                }
                                t81Var.b(iG, iF, arrayList5, t91Var.d, v91Var, zS, z12, i44, i91);
                                z8 = zS;
                                if (!z8) {
                                    t81Var.a();
                                    if (!zA) {
                                        iG = r40.g(Math.max(iG, 0), jI);
                                        iF2 = r40.f(Math.max(iF, 0), jI);
                                        if (iF2 != iF) {
                                            size9 = arrayList5.size();
                                            for (i61 = 0; i61 < size9; i61++) {
                                                ((y91) arrayList5.get(i61)).o = iF2;
                                            }
                                        }
                                        iF = iF2;
                                    }
                                }
                                if (hgVar.isEmpty()) {
                                    obj3 = null;
                                } else {
                                    obj3 = hgVar.b[hgVar.a];
                                }
                                y91Var2 = (y91) obj3;
                                if (y91Var2 != null) {
                                    i52 = y91Var2.a;
                                } else {
                                    i52 = 0;
                                }
                                y91Var3 = (y91) hgVar.h();
                                if (y91Var3 != null) {
                                    i53 = y91Var3.a;
                                } else {
                                    i53 = 0;
                                }
                                t91Var.b.getClass();
                                ll1 ll1Var2 = b21.a;
                                if (nr4Var != null || arrayList5.isEmpty() || (i57 = ll1Var2.b) == 0) {
                                    z9 = z8;
                                    y91Var4 = y91Var;
                                    i54 = i25;
                                    r11 = r10;
                                } else {
                                    if (i53 - i52 < 0 || i57 == 0) {
                                        y91Var4 = y91Var;
                                        ll1Var = ll1Var2;
                                    } else {
                                        h21 h21VarF = ky3.f(0, i57);
                                        int i93 = h21VarF.a;
                                        int i94 = h21VarF.b;
                                        y91Var4 = y91Var;
                                        if (i93 <= i94) {
                                            iC = -1;
                                            while (ll1Var2.c(i93) <= i52) {
                                                iC = ll1Var2.c(i93);
                                                if (i93 != i94) {
                                                    i93++;
                                                } else {
                                                    i60 = -1;
                                                }
                                            }
                                            i60 = -1;
                                        } else {
                                            i60 = -1;
                                            iC = -1;
                                        }
                                        if (iC == i60) {
                                            ll1Var = b21.a;
                                        } else {
                                            ll1Var = new ll1(1);
                                            ll1Var.a(iC);
                                        }
                                    }
                                    ArrayList arrayList10 = new ArrayList();
                                    ArrayList arrayList11 = new ArrayList(arrayList5.size());
                                    int size10 = arrayList5.size();
                                    int i95 = 0;
                                    while (i95 < size10) {
                                        int i96 = size10;
                                        Object obj9 = arrayList5.get(i95);
                                        int i97 = i95;
                                        int i98 = ((y91) obj9).a;
                                        boolean z13 = z8;
                                        int[] iArr3 = ll1Var2.a;
                                        int i99 = ll1Var2.b;
                                        ll1 ll1Var3 = ll1Var2;
                                        int i100 = 0;
                                        while (i100 < i99) {
                                            int i101 = i100;
                                            if (iArr3[i101] == i98) {
                                                arrayList11.add(obj9);
                                            }
                                            i100 = i101 + 1;
                                            break;
                                        }
                                        i95 = i97 + 1;
                                        size10 = i96;
                                        ll1Var2 = ll1Var3;
                                        z8 = z13;
                                    }
                                    z9 = z8;
                                    int[] iArr4 = ll1Var.a;
                                    int i102 = ll1Var.b;
                                    int i103 = 0;
                                    while (i103 < i102) {
                                        int i104 = iArr4[i103];
                                        int size11 = arrayList5.size();
                                        int[] iArr5 = iArr4;
                                        int i105 = 0;
                                        int i106 = 0;
                                        while (true) {
                                            if (i105 < size11) {
                                                Object obj10 = arrayList5.get(i105);
                                                int i107 = i105 + 1;
                                                if (((y91) obj10).a == i104) {
                                                    i58 = i106;
                                                } else {
                                                    i106++;
                                                    i105 = i107;
                                                }
                                            } else {
                                                i58 = -1;
                                            }
                                        }
                                        y91 y91VarA4 = i58 == -1 ? v91Var.a(i104, j) : (y91) arrayList5.remove(i58);
                                        int i108 = i102;
                                        int i109 = y91VarA4.l;
                                        int iA6 = i58 == -1 ? Integer.MIN_VALUE : (int) (y91VarA4.a(0) & 4294967295L);
                                        int size12 = arrayList11.size();
                                        int i110 = i103;
                                        int i111 = 0;
                                        while (true) {
                                            if (i111 < size12) {
                                                obj5 = arrayList11.get(i111);
                                                int i112 = size12;
                                                if (((y91) obj5).a == i104) {
                                                    i111++;
                                                    size12 = i112;
                                                }
                                            } else {
                                                obj5 = null;
                                            }
                                        }
                                        y91 y91Var13 = (y91) obj5;
                                        int iA7 = y91Var13 != null ? (int) (y91Var13.a(0) & 4294967295L) : Integer.MIN_VALUE;
                                        if (iA6 == Integer.MIN_VALUE) {
                                            iMax6 = i25;
                                            i59 = iMax6;
                                        } else {
                                            i59 = i25;
                                            iMax6 = Math.max(i59, iA6);
                                        }
                                        if (iA7 != Integer.MIN_VALUE) {
                                            iMax6 = Math.min(iMax6, iA7 - i109);
                                        }
                                        y91VarA4.n = true;
                                        y91VarA4.c(iMax6, iG, iF);
                                        arrayList10.add(y91VarA4);
                                        i103 = i110 + 1;
                                        i25 = i59;
                                        i102 = i108;
                                        iArr4 = iArr5;
                                        j = j;
                                    }
                                    i54 = i25;
                                    r11 = arrayList10;
                                }
                                if (z7) {
                                    y91Var8 = (y91) mz.y(arrayList5);
                                    if (y91Var8 != null) {
                                        numValueOf = Integer.valueOf(y91Var8.a);
                                    } else {
                                        numValueOf = null;
                                    }
                                } else {
                                    if (hgVar.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = hgVar.b[hgVar.a];
                                    }
                                    y91Var5 = (y91) obj4;
                                    if (y91Var5 != null) {
                                        numValueOf = Integer.valueOf(y91Var5.a);
                                    } else {
                                        numValueOf = null;
                                    }
                                }
                                if (z7) {
                                    y91Var7 = (y91) mz.E(arrayList5);
                                    if (y91Var7 != null) {
                                        numValueOf2 = Integer.valueOf(y91Var7.a);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                } else {
                                    y91Var6 = (y91) hgVar.h();
                                    if (y91Var6 != null) {
                                        numValueOf2 = Integer.valueOf(y91Var6.a);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                }
                                if (i36 >= i31 || i91 > iG3) {
                                    z10 = true;
                                } else {
                                    z10 = false;
                                }
                                xs2Var = xs2Var3;
                                ph1 ph1VarJ0 = xs2Var.j0(r40.g(iG + i74, j2), r40.f(iF + iR4, j2), ji0Var, new e2(mm1Var3, arrayList5, (List) r11, z9));
                                if (numValueOf != null) {
                                    iIntValue = numValueOf.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                if (numValueOf2 != null) {
                                    iIntValue2 = numValueOf2.intValue();
                                } else {
                                    iIntValue2 = 0;
                                }
                                if (arrayList5.isEmpty()) {
                                    r25 = r10;
                                } else {
                                    ArrayList arrayList12 = new ArrayList((Collection) r11);
                                    size8 = arrayList5.size();
                                    for (i55 = 0; i55 < size8; i55++) {
                                        y91 y91Var14 = (y91) arrayList5.get(i55);
                                        i56 = y91Var14.a;
                                        if (iIntValue > i56 && i56 <= iIntValue2) {
                                            arrayList12.add(y91Var14);
                                        }
                                    }
                                    qz.p(arrayList12, g24.a);
                                    r25 = arrayList12;
                                }
                                x91Var = new x91(y91Var4, i44, z10, f7, ph1VarJ0, f6, z4, s70Var, jc0Var, v91Var.d, r25, i54, i23, i31, js1Var, i75, iR5);
                            }
                            ea1Var.f(x91Var, xs2Var.s(), false);
                            return x91Var;
                        }
                        i2 = iR3;
                        iH = ea1Var.h();
                        i44.e(bm2VarA, bm2VarB, hq0VarE);
                        c91Var = ea1Var.r;
                        tmVar = ea1Var.o;
                        pm1Var = tmVar.a;
                        if (pm1Var.c != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        r10 = ii0.a;
                        if (z2) {
                            arrayList = new ArrayList();
                            if (tmVar.a.c != 0) {
                                i6 = pm1Var.c;
                                if (i6 != 0) {
                                    objArr = pm1Var.a;
                                    i7 = ((l81) objArr[0]).a;
                                    i8 = 0;
                                    while (i8 < i6) {
                                        int i710 = i8;
                                        i13 = ((l81) objArr[i8]).a;
                                        if (i13 < i7) {
                                            i7 = i13;
                                        }
                                        i8 = i710 + 1;
                                    }
                                    if (i7 < 0) {
                                        c11.a("negative minIndex");
                                    }
                                    i9 = pm1Var.c;
                                    if (i9 != 0) {
                                        objArr2 = pm1Var.a;
                                        i10 = ((l81) objArr2[0]).b;
                                        i11 = 0;
                                        while (i11 < i9) {
                                            int i711 = i11;
                                            i12 = ((l81) objArr2[i11]).b;
                                            if (i12 > i10) {
                                                i10 = i12;
                                            }
                                            i11 = i711 + 1;
                                        }
                                        h21Var = new h21(i7, Math.min(i10, t91Var3.c() - 1), 1);
                                    } else {
                                        kf2.g("MutableVector is empty.");
                                    }
                                } else {
                                    kf2.g("MutableVector is empty.");
                                }
                            } else {
                                h21Var = h21.e;
                            }
                            size = c91Var.a.size();
                            i3 = 0;
                            while (i3 < size) {
                                a91 a91Var2 = (a91) c91Var.get(i3);
                                iA = aq4.a(a91Var2.c, t91Var3, a91Var2.a);
                                int i712 = h21Var.a;
                                c91 c91Var3 = c91Var;
                                if (iA <= h21Var.b) {
                                    arrayList.add(Integer.valueOf(iA));
                                } else {
                                    arrayList.add(Integer.valueOf(iA));
                                }
                                i3++;
                                c91Var = c91Var3;
                            }
                            i4 = h21Var.a;
                            i5 = h21Var.b;
                            if (i4 <= i5) {
                                while (true) {
                                    arrayList.add(Integer.valueOf(i4));
                                    if (i4 != i5) {
                                        i4++;
                                    }
                                }
                            }
                            if (xs2Var3.s()) {
                                fFloatValue = ea1Var.h;
                            } else {
                                fFloatValue = ea1Var.h;
                            }
                            t81Var = ea1Var.n;
                            zS = xs2Var3.s();
                            s70Var = w91Var.e;
                            mm1Var = ea1Var.v;
                            nr4Var = w91Var.f;
                            if (i2 < 0) {
                                c11.a("invalid beforeContentPadding");
                            }
                            if (i75 < 0) {
                                c11.a("invalid afterContentPadding");
                            }
                            ji0Var = ji0.a;
                            t91Var = v91Var.b;
                            if (iC3 <= 0) {
                                iJ = q40.j(jI);
                                i72 = q40.i(jI);
                                t81Var.b(iJ, i72, new ArrayList(), t91Var.d, v91Var, zS, z11, 0, 0);
                                if (!zS) {
                                    t81Var.a();
                                    if (!zA) {
                                        iJ = r40.g(0, jI);
                                        i72 = r40.f(0, jI);
                                    }
                                }
                                xs2Var = xs2Var3;
                                x91Var = new x91(null, 0, false, 0.0f, xs2Var3.j0(r40.g(iJ + i74, j2), r40.f(i72 + iR4, j2), ji0Var, new j(7)), 0.0f, false, s70Var, y81Var, v91Var.d, r10, -i2, iG3 + i75, 0, js1Var, i75, iR5);
                            } else {
                                f = fFloatValue;
                                i14 = iA5;
                                boolean z14 = z11;
                                i15 = iC3;
                                i16 = i2;
                                if (i14 >= i15) {
                                    i14 = i15 - 1;
                                    iH = 0;
                                }
                                iRound = Math.round(f);
                                i17 = iH - iRound;
                                if (i14 == 0) {
                                    iRound += i17;
                                    i17 = 0;
                                }
                                i18 = i14;
                                hgVar = new hg();
                                int i810 = -i16;
                                if (iR5 < 0) {
                                    i19 = iR5;
                                } else {
                                    i19 = 0;
                                }
                                i20 = i810 + i19;
                                i21 = i17 + i20;
                                iMax = 0;
                                while (true) {
                                    j = v91Var.d;
                                    if (i21 >= 0) {
                                    }
                                    mm1 mm1Var4 = mm1Var;
                                    if (i21 < i20) {
                                        iRound -= i20 - i21;
                                        i21 = i20;
                                    }
                                    i22 = iRound;
                                    int i811 = i21 - i20;
                                    i23 = iG3 + i75;
                                    int i812 = iMax;
                                    if (i23 < 0) {
                                        i24 = 0;
                                    } else {
                                        i24 = i23;
                                    }
                                    i25 = i810;
                                    i26 = -i811;
                                    i27 = i811;
                                    i28 = i18;
                                    i29 = 0;
                                    z3 = false;
                                    while (i29 < hgVar.c) {
                                        if (i26 >= i24) {
                                            hgVar.b(i29);
                                            z3 = true;
                                        } else {
                                            i28++;
                                            i26 += ((y91) hgVar.get(i29)).l;
                                            i29++;
                                        }
                                    }
                                    iMax2 = i812;
                                    i30 = i28;
                                    z4 = z3;
                                    while (i30 < i15) {
                                        int i813 = i24;
                                        y91 y91VarA5 = v91Var.a(i30, j);
                                        i69 = i15;
                                        i70 = y91VarA5.l;
                                        i26 += i70;
                                        if (i26 <= i20) {
                                            i71 = i20;
                                            if (i30 != i69 - 1) {
                                                i27 -= i70;
                                                i18 = i30 + 1;
                                                z4 = true;
                                            }
                                            i30++;
                                            i24 = i813;
                                            i20 = i71;
                                            i15 = i69;
                                        } else {
                                            i71 = i20;
                                        }
                                        int iMax8 = Math.max(iMax2, y91VarA5.m);
                                        hgVar.addLast(y91VarA5);
                                        iMax2 = iMax8;
                                        i30++;
                                        i24 = i813;
                                        i20 = i71;
                                        i15 = i69;
                                    }
                                    i31 = i15;
                                    if (i26 < iG3) {
                                        i68 = iG3 - i26;
                                        i26 += i68;
                                        i35 = i27 - i68;
                                        while (i35 < i16) {
                                            int i814 = i68;
                                            int i815 = i18 - 1;
                                            int i816 = i16;
                                            y91 y91VarA6 = v91Var.a(i815, j);
                                            i18 = i815;
                                            hgVar.add(0, y91VarA6);
                                            iMax2 = Math.max(iMax2, y91VarA6.m);
                                            i35 += y91VarA6.l;
                                            i68 = i814;
                                            i16 = i816;
                                        }
                                        i32 = i16;
                                        i33 = i22 + i68;
                                        if (i35 < 0) {
                                            i33 += i35;
                                            i26 += i35;
                                            i34 = i18;
                                            i35 = 0;
                                        } else {
                                            i34 = i18;
                                        }
                                    } else {
                                        i32 = i16;
                                        i33 = i22;
                                        i34 = i18;
                                        i35 = i27;
                                    }
                                    int i817 = iMax2;
                                    i36 = i30;
                                    if (Integer.signum(Math.round(f)) == Integer.signum(i33)) {
                                        f2 = f;
                                    } else {
                                        f2 = f;
                                    }
                                    f3 = f - f2;
                                    f4 = 0.0f;
                                    if (zS) {
                                        f4 = (i33 - i22) + f3;
                                    }
                                    f5 = f4;
                                    if (i35 < 0) {
                                        c11.a("negative currentFirstItemScrollOffset");
                                    }
                                    i37 = -i35;
                                    y91Var = (y91) hgVar.first();
                                    if (i32 <= 0) {
                                        f6 = f5;
                                        iA2 = hgVar.a();
                                        f7 = f2;
                                        i38 = 0;
                                        while (i38 < iA2) {
                                            int i818 = iA2;
                                            int i910 = ((y91) hgVar.get(i38)).l;
                                            if (i35 == 0) {
                                            }
                                        }
                                    } else {
                                        f6 = f5;
                                        iA2 = hgVar.a();
                                        f7 = f2;
                                        i38 = 0;
                                        while (i38 < iA2) {
                                            int i819 = iA2;
                                            int i911 = ((y91) hgVar.get(i38)).l;
                                            if (i35 == 0) {
                                            }
                                        }
                                    }
                                    iMax3 = Math.max(0, i34);
                                    i39 = i34 - 1;
                                    if (iMax3 <= i39) {
                                        arrayList2 = 0;
                                        while (true) {
                                            if (arrayList2 == 0) {
                                                arrayList2 = new ArrayList();
                                            }
                                            i40 = i37;
                                            arrayList2.add(v91Var.a(i39, j));
                                            if (i39 != iMax3) {
                                                i39--;
                                                i37 = i40;
                                                arrayList2 = arrayList2;
                                            }
                                        }
                                    } else {
                                        i40 = i37;
                                        arrayList2 = 0;
                                    }
                                    size2 = arrayList.size() - 1;
                                    r3 = arrayList2;
                                    if (size2 >= 0) {
                                        while (true) {
                                            i67 = size2 - 1;
                                            iIntValue4 = ((Number) arrayList.get(size2)).intValue();
                                            arrayList9 = r3;
                                            arrayList2 = r3;
                                            if (iIntValue4 < iMax3) {
                                                if (r3 == 0) {
                                                    arrayList9 = new ArrayList();
                                                }
                                                arrayList9.add(v91Var.a(iIntValue4, j));
                                                arrayList2 = arrayList9;
                                            }
                                            if (i67 >= 0) {
                                                size2 = i67;
                                                r3 = arrayList2;
                                            }
                                        }
                                    }
                                    if (arrayList2 == 0) {
                                        arrayList2 = r10;
                                    }
                                    iMax4 = i817;
                                    i41 = 0;
                                    while (i41 < size3) {
                                        iMax4 = Math.max(iMax4, ((y91) arrayList2.get(i41)).m);
                                        i41++;
                                    }
                                    iMin = Math.min(((y91) mz.D(hgVar)).a, i31 - 1);
                                    i42 = ((y91) mz.D(hgVar)).a + 1;
                                    if (i42 <= iMin) {
                                        arrayList8 = null;
                                        while (true) {
                                            if (arrayList8 == null) {
                                                arrayList8 = new ArrayList();
                                            }
                                            i43 = iMax4;
                                            i44 = i35;
                                            arrayList3 = arrayList8;
                                            arrayList3.add(v91Var.a(i42, j));
                                            if (i42 != iMin) {
                                                i42++;
                                                arrayList8 = arrayList3;
                                                iMax4 = i43;
                                                i35 = i44;
                                            }
                                        }
                                    } else {
                                        i43 = iMax4;
                                        i44 = i35;
                                        arrayList3 = null;
                                    }
                                    if (arrayList3 != null) {
                                        iMin = ((y91) mz.D(arrayList3)).a;
                                    }
                                    size4 = arrayList.size();
                                    i45 = 0;
                                    while (i45 < size4) {
                                        arrayList6 = arrayList3;
                                        iIntValue3 = ((Number) arrayList.get(i45)).intValue();
                                        if (iIntValue3 > iMin) {
                                            if (arrayList6 == null) {
                                                arrayList7 = new ArrayList();
                                            } else {
                                                arrayList7 = arrayList6;
                                            }
                                            arrayList7.add(v91Var.a(iIntValue3, j));
                                            arrayList3 = arrayList7;
                                        } else {
                                            iMin = iMin;
                                            arrayList3 = arrayList6;
                                        }
                                        i45++;
                                        iMin = iMin;
                                    }
                                    arrayList4 = arrayList3;
                                    if (arrayList4 == null) {
                                        r2 = r10;
                                    } else {
                                        r2 = arrayList4;
                                    }
                                    size5 = r2.size();
                                    iMax5 = i43;
                                    while (i46 < size5) {
                                        iMax5 = Math.max(iMax5, ((y91) r2.get(i46)).m);
                                    }
                                    if (!g31.a(y91Var, hgVar.first())) {
                                        z5 = false;
                                    } else {
                                        z5 = false;
                                    }
                                    iG = r40.g(iMax5, jI);
                                    iF = r40.f(i26, jI);
                                    if (i26 < Math.min(iF, iG3)) {
                                        z6 = true;
                                    } else {
                                        z6 = false;
                                    }
                                    if (z6) {
                                        c11.c("non-zero itemsScrollOffset");
                                    }
                                    z7 = z5;
                                    int i912 = i26;
                                    arrayList5 = new ArrayList(r2.size() + arrayList2.size() + hgVar.a());
                                    if (z6) {
                                        if (arrayList2.isEmpty()) {
                                            c11.a("no extra items");
                                        } else {
                                            c11.a("no extra items");
                                        }
                                        iA4 = hgVar.a();
                                        iArr = new int[iA4];
                                        while (i62 < iA4) {
                                            iArr[i62] = ((y91) hgVar.get(i62)).k;
                                        }
                                        iArr2 = new int[iA4];
                                        if (fgVar != null) {
                                            fgVar.i(iF, r4, iArr, iArr2);
                                            jc0Var = r4;
                                            h21 h21Var3 = new h21(0, iA4 - 1, 1);
                                            i63 = h21Var3.b;
                                            i64 = h21Var3.c;
                                            if (i64 <= 0) {
                                                i65 = 0;
                                                while (true) {
                                                    int i913 = iArr2[i65];
                                                    i66 = i64;
                                                    y91 y91Var15 = (y91) hgVar.get(i65);
                                                    y91Var15.c(i913, iG, iF);
                                                    arrayList5.add(y91Var15);
                                                    if (i65 != i63) {
                                                        i65 += i66;
                                                        i64 = i66;
                                                    }
                                                }
                                            } else {
                                                i65 = 0;
                                                while (true) {
                                                    int i914 = iArr2[i65];
                                                    i66 = i64;
                                                    y91 y91Var16 = (y91) hgVar.get(i65);
                                                    y91Var16.c(i914, iG, iF);
                                                    arrayList5.add(y91Var16);
                                                    if (i65 != i63) {
                                                        i65 += i66;
                                                        i64 = i66;
                                                    }
                                                }
                                            }
                                        } else {
                                            c11.b("null verticalArrangement when isVertical == true");
                                            og.k();
                                        }
                                    } else {
                                        jc0Var = r4;
                                        size6 = arrayList2.size();
                                        i47 = i40;
                                        i48 = 0;
                                        r1 = arrayList2;
                                        while (i48 < size6) {
                                            var r18 = r1;
                                            y91 y91Var17 = (y91) r1.get(i48);
                                            i47 -= y91Var17.l;
                                            y91Var17.c(i47, iG, iF);
                                            arrayList5.add(y91Var17);
                                            i48++;
                                            size6 = size6;
                                            r1 = r18;
                                        }
                                        iA3 = hgVar.a();
                                        i49 = i40;
                                        while (i50 < iA3) {
                                            y91 y91Var18 = (y91) hgVar.get(i50);
                                            y91Var18.c(i49, iG, iF);
                                            arrayList5.add(y91Var18);
                                            i49 += y91Var18.l;
                                        }
                                        size7 = r2.size();
                                        while (i51 < size7) {
                                            y91 y91Var19 = (y91) r2.get(i51);
                                            y91Var19.c(i49, iG, iF);
                                            arrayList5.add(y91Var19);
                                            i49 += y91Var19.l;
                                        }
                                    }
                                    t81Var.b(iG, iF, arrayList5, t91Var.d, v91Var, zS, z14, i44, i912);
                                    z8 = zS;
                                    if (!z8) {
                                        t81Var.a();
                                        if (!zA) {
                                            iG = r40.g(Math.max(iG, 0), jI);
                                            iF2 = r40.f(Math.max(iF, 0), jI);
                                            if (iF2 != iF) {
                                                size9 = arrayList5.size();
                                                while (i61 < size9) {
                                                    ((y91) arrayList5.get(i61)).o = iF2;
                                                }
                                            }
                                            iF = iF2;
                                        }
                                    }
                                    if (hgVar.isEmpty()) {
                                        obj3 = null;
                                    } else {
                                        obj3 = hgVar.b[hgVar.a];
                                    }
                                    y91Var2 = (y91) obj3;
                                    if (y91Var2 != null) {
                                        i52 = y91Var2.a;
                                    } else {
                                        i52 = 0;
                                    }
                                    y91Var3 = (y91) hgVar.h();
                                    if (y91Var3 != null) {
                                        i53 = y91Var3.a;
                                    } else {
                                        i53 = 0;
                                    }
                                    t91Var.b.getClass();
                                    ll1 ll1Var4 = b21.a;
                                    if (nr4Var != null) {
                                        z9 = z8;
                                        y91Var4 = y91Var;
                                        i54 = i25;
                                        r11 = r10;
                                    } else {
                                        z9 = z8;
                                        y91Var4 = y91Var;
                                        i54 = i25;
                                        r11 = r10;
                                    }
                                    if (z7) {
                                        y91Var8 = (y91) mz.y(arrayList5);
                                        if (y91Var8 != null) {
                                            numValueOf = Integer.valueOf(y91Var8.a);
                                        } else {
                                            numValueOf = null;
                                        }
                                    } else {
                                        if (hgVar.isEmpty()) {
                                            obj4 = null;
                                        } else {
                                            obj4 = hgVar.b[hgVar.a];
                                        }
                                        y91Var5 = (y91) obj4;
                                        if (y91Var5 != null) {
                                            numValueOf = Integer.valueOf(y91Var5.a);
                                        } else {
                                            numValueOf = null;
                                        }
                                    }
                                    if (z7) {
                                        y91Var7 = (y91) mz.E(arrayList5);
                                        if (y91Var7 != null) {
                                            numValueOf2 = Integer.valueOf(y91Var7.a);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    } else {
                                        y91Var6 = (y91) hgVar.h();
                                        if (y91Var6 != null) {
                                            numValueOf2 = Integer.valueOf(y91Var6.a);
                                        } else {
                                            numValueOf2 = null;
                                        }
                                    }
                                    if (i36 >= i31) {
                                        z10 = true;
                                    } else {
                                        z10 = true;
                                    }
                                    xs2Var = xs2Var3;
                                    ph1 ph1VarJ1 = xs2Var.j0(r40.g(iG + i74, j2), r40.f(iF + iR4, j2), ji0Var, new e2(mm1Var4, arrayList5, (List) r11, z9));
                                    if (numValueOf != null) {
                                        iIntValue = numValueOf.intValue();
                                    } else {
                                        iIntValue = 0;
                                    }
                                    if (numValueOf2 != null) {
                                        iIntValue2 = numValueOf2.intValue();
                                    } else {
                                        iIntValue2 = 0;
                                    }
                                    if (arrayList5.isEmpty()) {
                                        r25 = r10;
                                    } else {
                                        ArrayList arrayList13 = new ArrayList((Collection) r11);
                                        size8 = arrayList5.size();
                                        while (i55 < size8) {
                                            y91 y91Var110 = (y91) arrayList5.get(i55);
                                            i56 = y91Var110.a;
                                            if (iIntValue > i56) {
                                            }
                                        }
                                        qz.p(arrayList13, g24.a);
                                        r25 = arrayList13;
                                    }
                                    x91Var = new x91(y91Var4, i44, z10, f7, ph1VarJ1, f6, z4, s70Var, jc0Var, v91Var.d, r25, i54, i23, i31, js1Var, i75, iR5);
                                    mm1 mm1Var5 = mm1Var;
                                    int i820 = i18 - 1;
                                    y91 y91VarA7 = v91Var.a(i820, j);
                                    hgVar.add(0, y91VarA7);
                                    iMax = Math.max(iMax, y91VarA7.m);
                                    i21 += y91VarA7.l;
                                    i18 = i820;
                                    mm1Var = mm1Var5;
                                }
                            }
                            ea1Var.f(x91Var, xs2Var.s(), false);
                            return x91Var;
                        }
                        arrayList = new ArrayList();
                        if (tmVar.a.c != 0) {
                            i6 = pm1Var.c;
                            if (i6 != 0) {
                                objArr = pm1Var.a;
                                i7 = ((l81) objArr[0]).a;
                                i8 = 0;
                                while (i8 < i6) {
                                    int i713 = i8;
                                    i13 = ((l81) objArr[i8]).a;
                                    if (i13 < i7) {
                                        i7 = i13;
                                    }
                                    i8 = i713 + 1;
                                }
                                if (i7 < 0) {
                                    c11.a("negative minIndex");
                                }
                                i9 = pm1Var.c;
                                if (i9 != 0) {
                                    objArr2 = pm1Var.a;
                                    i10 = ((l81) objArr2[0]).b;
                                    i11 = 0;
                                    while (i11 < i9) {
                                        int i714 = i11;
                                        i12 = ((l81) objArr2[i11]).b;
                                        if (i12 > i10) {
                                            i10 = i12;
                                        }
                                        i11 = i714 + 1;
                                    }
                                    h21Var = new h21(i7, Math.min(i10, t91Var3.c() - 1), 1);
                                } else {
                                    kf2.g("MutableVector is empty.");
                                }
                            } else {
                                kf2.g("MutableVector is empty.");
                            }
                        } else {
                            h21Var = h21.e;
                        }
                        size = c91Var.a.size();
                        i3 = 0;
                        while (i3 < size) {
                            a91 a91Var3 = (a91) c91Var.get(i3);
                            iA = aq4.a(a91Var3.c, t91Var3, a91Var3.a);
                            int i715 = h21Var.a;
                            c91 c91Var4 = c91Var;
                            if (iA <= h21Var.b) {
                                arrayList.add(Integer.valueOf(iA));
                            } else {
                                arrayList.add(Integer.valueOf(iA));
                            }
                            i3++;
                            c91Var = c91Var4;
                        }
                        i4 = h21Var.a;
                        i5 = h21Var.b;
                        if (i4 <= i5) {
                            while (true) {
                                arrayList.add(Integer.valueOf(i4));
                                if (i4 != i5) {
                                    i4++;
                                }
                            }
                        }
                        if (xs2Var3.s()) {
                            fFloatValue = ea1Var.h;
                        } else {
                            fFloatValue = ea1Var.h;
                        }
                        t81Var = ea1Var.n;
                        zS = xs2Var3.s();
                        s70Var = w91Var.e;
                        mm1Var = ea1Var.v;
                        nr4Var = w91Var.f;
                        if (i2 < 0) {
                            c11.a("invalid beforeContentPadding");
                        }
                        if (i75 < 0) {
                            c11.a("invalid afterContentPadding");
                        }
                        ji0Var = ji0.a;
                        t91Var = v91Var.b;
                        if (iC3 <= 0) {
                            iJ = q40.j(jI);
                            i72 = q40.i(jI);
                            t81Var.b(iJ, i72, new ArrayList(), t91Var.d, v91Var, zS, z11, 0, 0);
                            if (!zS) {
                                t81Var.a();
                                if (!zA) {
                                    iJ = r40.g(0, jI);
                                    i72 = r40.f(0, jI);
                                }
                            }
                            xs2Var = xs2Var3;
                            x91Var = new x91(null, 0, false, 0.0f, xs2Var3.j0(r40.g(iJ + i74, j2), r40.f(i72 + iR4, j2), ji0Var, new j(7)), 0.0f, false, s70Var, y81Var, v91Var.d, r10, -i2, iG3 + i75, 0, js1Var, i75, iR5);
                        } else {
                            f = fFloatValue;
                            i14 = iA5;
                            boolean z15 = z11;
                            i15 = iC3;
                            i16 = i2;
                            if (i14 >= i15) {
                                i14 = i15 - 1;
                                iH = 0;
                            }
                            iRound = Math.round(f);
                            i17 = iH - iRound;
                            if (i14 == 0) {
                                iRound += i17;
                                i17 = 0;
                            }
                            i18 = i14;
                            hgVar = new hg();
                            int i8110 = -i16;
                            if (iR5 < 0) {
                                i19 = iR5;
                            } else {
                                i19 = 0;
                            }
                            i20 = i8110 + i19;
                            i21 = i17 + i20;
                            iMax = 0;
                            while (true) {
                                j = v91Var.d;
                                if (i21 >= 0) {
                                }
                                mm1 mm1Var6 = mm1Var;
                                if (i21 < i20) {
                                    iRound -= i20 - i21;
                                    i21 = i20;
                                }
                                i22 = iRound;
                                int i8111 = i21 - i20;
                                i23 = iG3 + i75;
                                int i8112 = iMax;
                                if (i23 < 0) {
                                    i24 = 0;
                                } else {
                                    i24 = i23;
                                }
                                i25 = i8110;
                                i26 = -i8111;
                                i27 = i8111;
                                i28 = i18;
                                i29 = 0;
                                z3 = false;
                                while (i29 < hgVar.c) {
                                    if (i26 >= i24) {
                                        hgVar.b(i29);
                                        z3 = true;
                                    } else {
                                        i28++;
                                        i26 += ((y91) hgVar.get(i29)).l;
                                        i29++;
                                    }
                                }
                                iMax2 = i8112;
                                i30 = i28;
                                z4 = z3;
                                while (i30 < i15) {
                                    int i8113 = i24;
                                    y91 y91VarA8 = v91Var.a(i30, j);
                                    i69 = i15;
                                    i70 = y91VarA8.l;
                                    i26 += i70;
                                    if (i26 <= i20) {
                                        i71 = i20;
                                        if (i30 != i69 - 1) {
                                            i27 -= i70;
                                            i18 = i30 + 1;
                                            z4 = true;
                                        }
                                        i30++;
                                        i24 = i8113;
                                        i20 = i71;
                                        i15 = i69;
                                    } else {
                                        i71 = i20;
                                    }
                                    int iMax9 = Math.max(iMax2, y91VarA8.m);
                                    hgVar.addLast(y91VarA8);
                                    iMax2 = iMax9;
                                    i30++;
                                    i24 = i8113;
                                    i20 = i71;
                                    i15 = i69;
                                }
                                i31 = i15;
                                if (i26 < iG3) {
                                    i68 = iG3 - i26;
                                    i26 += i68;
                                    i35 = i27 - i68;
                                    while (i35 < i16) {
                                        int i8114 = i68;
                                        int i8115 = i18 - 1;
                                        int i8116 = i16;
                                        y91 y91VarA9 = v91Var.a(i8115, j);
                                        i18 = i8115;
                                        hgVar.add(0, y91VarA9);
                                        iMax2 = Math.max(iMax2, y91VarA9.m);
                                        i35 += y91VarA9.l;
                                        i68 = i8114;
                                        i16 = i8116;
                                    }
                                    i32 = i16;
                                    i33 = i22 + i68;
                                    if (i35 < 0) {
                                        i33 += i35;
                                        i26 += i35;
                                        i34 = i18;
                                        i35 = 0;
                                    } else {
                                        i34 = i18;
                                    }
                                } else {
                                    i32 = i16;
                                    i33 = i22;
                                    i34 = i18;
                                    i35 = i27;
                                }
                                int i8117 = iMax2;
                                i36 = i30;
                                if (Integer.signum(Math.round(f)) == Integer.signum(i33)) {
                                    f2 = f;
                                } else {
                                    f2 = f;
                                }
                                f3 = f - f2;
                                f4 = 0.0f;
                                if (zS) {
                                    f4 = (i33 - i22) + f3;
                                }
                                f5 = f4;
                                if (i35 < 0) {
                                    c11.a("negative currentFirstItemScrollOffset");
                                }
                                i37 = -i35;
                                y91Var = (y91) hgVar.first();
                                if (i32 <= 0) {
                                    f6 = f5;
                                    iA2 = hgVar.a();
                                    f7 = f2;
                                    i38 = 0;
                                    while (i38 < iA2) {
                                        int i8118 = iA2;
                                        int i915 = ((y91) hgVar.get(i38)).l;
                                        if (i35 == 0) {
                                        }
                                    }
                                } else {
                                    f6 = f5;
                                    iA2 = hgVar.a();
                                    f7 = f2;
                                    i38 = 0;
                                    while (i38 < iA2) {
                                        int i8119 = iA2;
                                        int i916 = ((y91) hgVar.get(i38)).l;
                                        if (i35 == 0) {
                                        }
                                    }
                                }
                                iMax3 = Math.max(0, i34);
                                i39 = i34 - 1;
                                if (iMax3 <= i39) {
                                    arrayList2 = 0;
                                    while (true) {
                                        if (arrayList2 == 0) {
                                            arrayList2 = new ArrayList();
                                        }
                                        i40 = i37;
                                        arrayList2.add(v91Var.a(i39, j));
                                        if (i39 != iMax3) {
                                            i39--;
                                            i37 = i40;
                                            arrayList2 = arrayList2;
                                        }
                                    }
                                } else {
                                    i40 = i37;
                                    arrayList2 = 0;
                                }
                                size2 = arrayList.size() - 1;
                                r3 = arrayList2;
                                if (size2 >= 0) {
                                    while (true) {
                                        i67 = size2 - 1;
                                        iIntValue4 = ((Number) arrayList.get(size2)).intValue();
                                        arrayList9 = r3;
                                        arrayList2 = r3;
                                        if (iIntValue4 < iMax3) {
                                            if (r3 == 0) {
                                                arrayList9 = new ArrayList();
                                            }
                                            arrayList9.add(v91Var.a(iIntValue4, j));
                                            arrayList2 = arrayList9;
                                        }
                                        if (i67 >= 0) {
                                            size2 = i67;
                                            r3 = arrayList2;
                                        }
                                    }
                                }
                                if (arrayList2 == 0) {
                                    arrayList2 = r10;
                                }
                                iMax4 = i8117;
                                i41 = 0;
                                while (i41 < size3) {
                                    iMax4 = Math.max(iMax4, ((y91) arrayList2.get(i41)).m);
                                    i41++;
                                }
                                iMin = Math.min(((y91) mz.D(hgVar)).a, i31 - 1);
                                i42 = ((y91) mz.D(hgVar)).a + 1;
                                if (i42 <= iMin) {
                                    arrayList8 = null;
                                    while (true) {
                                        if (arrayList8 == null) {
                                            arrayList8 = new ArrayList();
                                        }
                                        i43 = iMax4;
                                        i44 = i35;
                                        arrayList3 = arrayList8;
                                        arrayList3.add(v91Var.a(i42, j));
                                        if (i42 != iMin) {
                                            i42++;
                                            arrayList8 = arrayList3;
                                            iMax4 = i43;
                                            i35 = i44;
                                        }
                                    }
                                } else {
                                    i43 = iMax4;
                                    i44 = i35;
                                    arrayList3 = null;
                                }
                                if (arrayList3 != null) {
                                    iMin = ((y91) mz.D(arrayList3)).a;
                                }
                                size4 = arrayList.size();
                                i45 = 0;
                                while (i45 < size4) {
                                    arrayList6 = arrayList3;
                                    iIntValue3 = ((Number) arrayList.get(i45)).intValue();
                                    if (iIntValue3 > iMin) {
                                        if (arrayList6 == null) {
                                            arrayList7 = new ArrayList();
                                        } else {
                                            arrayList7 = arrayList6;
                                        }
                                        arrayList7.add(v91Var.a(iIntValue3, j));
                                        arrayList3 = arrayList7;
                                    } else {
                                        iMin = iMin;
                                        arrayList3 = arrayList6;
                                    }
                                    i45++;
                                    iMin = iMin;
                                }
                                arrayList4 = arrayList3;
                                if (arrayList4 == null) {
                                    r2 = r10;
                                } else {
                                    r2 = arrayList4;
                                }
                                size5 = r2.size();
                                iMax5 = i43;
                                while (i46 < size5) {
                                    iMax5 = Math.max(iMax5, ((y91) r2.get(i46)).m);
                                }
                                if (!g31.a(y91Var, hgVar.first())) {
                                    z5 = false;
                                } else {
                                    z5 = false;
                                }
                                iG = r40.g(iMax5, jI);
                                iF = r40.f(i26, jI);
                                if (i26 < Math.min(iF, iG3)) {
                                    z6 = true;
                                } else {
                                    z6 = false;
                                }
                                if (z6) {
                                    c11.c("non-zero itemsScrollOffset");
                                }
                                z7 = z5;
                                int i917 = i26;
                                arrayList5 = new ArrayList(r2.size() + arrayList2.size() + hgVar.a());
                                if (z6) {
                                    if (arrayList2.isEmpty()) {
                                        c11.a("no extra items");
                                    } else {
                                        c11.a("no extra items");
                                    }
                                    iA4 = hgVar.a();
                                    iArr = new int[iA4];
                                    while (i62 < iA4) {
                                        iArr[i62] = ((y91) hgVar.get(i62)).k;
                                    }
                                    iArr2 = new int[iA4];
                                    if (fgVar != null) {
                                        fgVar.i(iF, r4, iArr, iArr2);
                                        jc0Var = r4;
                                        h21 h21Var4 = new h21(0, iA4 - 1, 1);
                                        i63 = h21Var4.b;
                                        i64 = h21Var4.c;
                                        if (i64 <= 0) {
                                            i65 = 0;
                                            while (true) {
                                                int i918 = iArr2[i65];
                                                i66 = i64;
                                                y91 y91Var111 = (y91) hgVar.get(i65);
                                                y91Var111.c(i918, iG, iF);
                                                arrayList5.add(y91Var111);
                                                if (i65 != i63) {
                                                    i65 += i66;
                                                    i64 = i66;
                                                }
                                            }
                                        } else {
                                            i65 = 0;
                                            while (true) {
                                                int i919 = iArr2[i65];
                                                i66 = i64;
                                                y91 y91Var112 = (y91) hgVar.get(i65);
                                                y91Var112.c(i919, iG, iF);
                                                arrayList5.add(y91Var112);
                                                if (i65 != i63) {
                                                    i65 += i66;
                                                    i64 = i66;
                                                }
                                            }
                                        }
                                    } else {
                                        c11.b("null verticalArrangement when isVertical == true");
                                        og.k();
                                    }
                                } else {
                                    jc0Var = r4;
                                    size6 = arrayList2.size();
                                    i47 = i40;
                                    i48 = 0;
                                    r1 = arrayList2;
                                    while (i48 < size6) {
                                        var r19 = r1;
                                        y91 y91Var113 = (y91) r1.get(i48);
                                        i47 -= y91Var113.l;
                                        y91Var113.c(i47, iG, iF);
                                        arrayList5.add(y91Var113);
                                        i48++;
                                        size6 = size6;
                                        r1 = r19;
                                    }
                                    iA3 = hgVar.a();
                                    i49 = i40;
                                    while (i50 < iA3) {
                                        y91 y91Var114 = (y91) hgVar.get(i50);
                                        y91Var114.c(i49, iG, iF);
                                        arrayList5.add(y91Var114);
                                        i49 += y91Var114.l;
                                    }
                                    size7 = r2.size();
                                    while (i51 < size7) {
                                        y91 y91Var115 = (y91) r2.get(i51);
                                        y91Var115.c(i49, iG, iF);
                                        arrayList5.add(y91Var115);
                                        i49 += y91Var115.l;
                                    }
                                }
                                t81Var.b(iG, iF, arrayList5, t91Var.d, v91Var, zS, z15, i44, i917);
                                z8 = zS;
                                if (!z8) {
                                    t81Var.a();
                                    if (!zA) {
                                        iG = r40.g(Math.max(iG, 0), jI);
                                        iF2 = r40.f(Math.max(iF, 0), jI);
                                        if (iF2 != iF) {
                                            size9 = arrayList5.size();
                                            while (i61 < size9) {
                                                ((y91) arrayList5.get(i61)).o = iF2;
                                            }
                                        }
                                        iF = iF2;
                                    }
                                }
                                if (hgVar.isEmpty()) {
                                    obj3 = null;
                                } else {
                                    obj3 = hgVar.b[hgVar.a];
                                }
                                y91Var2 = (y91) obj3;
                                if (y91Var2 != null) {
                                    i52 = y91Var2.a;
                                } else {
                                    i52 = 0;
                                }
                                y91Var3 = (y91) hgVar.h();
                                if (y91Var3 != null) {
                                    i53 = y91Var3.a;
                                } else {
                                    i53 = 0;
                                }
                                t91Var.b.getClass();
                                ll1 ll1Var5 = b21.a;
                                if (nr4Var != null) {
                                    z9 = z8;
                                    y91Var4 = y91Var;
                                    i54 = i25;
                                    r11 = r10;
                                } else {
                                    z9 = z8;
                                    y91Var4 = y91Var;
                                    i54 = i25;
                                    r11 = r10;
                                }
                                if (z7) {
                                    y91Var8 = (y91) mz.y(arrayList5);
                                    if (y91Var8 != null) {
                                        numValueOf = Integer.valueOf(y91Var8.a);
                                    } else {
                                        numValueOf = null;
                                    }
                                } else {
                                    if (hgVar.isEmpty()) {
                                        obj4 = null;
                                    } else {
                                        obj4 = hgVar.b[hgVar.a];
                                    }
                                    y91Var5 = (y91) obj4;
                                    if (y91Var5 != null) {
                                        numValueOf = Integer.valueOf(y91Var5.a);
                                    } else {
                                        numValueOf = null;
                                    }
                                }
                                if (z7) {
                                    y91Var7 = (y91) mz.E(arrayList5);
                                    if (y91Var7 != null) {
                                        numValueOf2 = Integer.valueOf(y91Var7.a);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                } else {
                                    y91Var6 = (y91) hgVar.h();
                                    if (y91Var6 != null) {
                                        numValueOf2 = Integer.valueOf(y91Var6.a);
                                    } else {
                                        numValueOf2 = null;
                                    }
                                }
                                if (i36 >= i31) {
                                    z10 = true;
                                } else {
                                    z10 = true;
                                }
                                xs2Var = xs2Var3;
                                ph1 ph1VarJ2 = xs2Var.j0(r40.g(iG + i74, j2), r40.f(iF + iR4, j2), ji0Var, new e2(mm1Var6, arrayList5, (List) r11, z9));
                                if (numValueOf != null) {
                                    iIntValue = numValueOf.intValue();
                                } else {
                                    iIntValue = 0;
                                }
                                if (numValueOf2 != null) {
                                    iIntValue2 = numValueOf2.intValue();
                                } else {
                                    iIntValue2 = 0;
                                }
                                if (arrayList5.isEmpty()) {
                                    r25 = r10;
                                } else {
                                    ArrayList arrayList14 = new ArrayList((Collection) r11);
                                    size8 = arrayList5.size();
                                    while (i55 < size8) {
                                        y91 y91Var116 = (y91) arrayList5.get(i55);
                                        i56 = y91Var116.a;
                                        if (iIntValue > i56) {
                                        }
                                    }
                                    qz.p(arrayList14, g24.a);
                                    r25 = arrayList14;
                                }
                                x91Var = new x91(y91Var4, i44, z10, f7, ph1VarJ2, f6, z4, s70Var, jc0Var, v91Var.d, r25, i54, i23, i31, js1Var, i75, iR5);
                                mm1 mm1Var7 = mm1Var;
                                int i821 = i18 - 1;
                                y91 y91VarA10 = v91Var.a(i821, j);
                                hgVar.add(0, y91VarA10);
                                iMax = Math.max(iMax, y91VarA10.m);
                                i21 += y91VarA10.l;
                                i18 = i821;
                                mm1Var = mm1Var7;
                            }
                        }
                        ea1Var.f(x91Var, xs2Var.s(), false);
                        return x91Var;
                    } catch (Throwable th) {
                        i44.e(bm2VarA, bm2VarB, hq0VarE);
                        throw th;
                    }
                }
                c11.b("null verticalArrangement when isVertical == true");
                og.k();
                return null;
            case 8:
                w10 w10Var2 = (w10) obj6;
                ha1 ha1Var = (ha1) obj7;
                x20 x20Var5 = (x20) obj;
                int iIntValue9 = ((Integer) obj2).intValue();
                if (x20Var5.O(iIntValue9 & 1, (iIntValue9 & 3) != 2)) {
                    w10Var2.c(ha1Var, x20Var5, 0);
                } else {
                    x20Var5.R();
                }
                return q43Var;
            case 9:
                ((Integer) obj2).getClass();
                k34.h((String) obj7, (w10) obj6, (x20) obj, ny3.c(55));
                return q43Var;
            case 10:
                qj2 qj2Var = (qj2) obj7;
                fq0 fq0Var = (fq0) obj6;
                x20 x20Var6 = (x20) obj;
                int iIntValue10 = ((Integer) obj2).intValue();
                if (x20Var6.O(iIntValue10 & 1, (iIntValue10 & 3) != 2)) {
                    q44.d("REQUIRED PERMISSIONS", x20Var6, 6);
                    bk1 bk1Var = bk1.a;
                    k54.h(x20Var6, w44.c(bk1Var, 12.0f));
                    x20Var6.W(1002030961);
                    for (i92 i92Var : qj2Var.a) {
                        q44.c(i92Var.b, i92Var.c, i92Var.d, x20Var6, 0);
                    }
                    x20Var6.p(false);
                    k54.h(x20Var6, w44.c(bk1Var, 12.0f));
                    if (qj2Var.d) {
                        x20Var6.W(998409689);
                        dz2.b("All runtime permissions allowed.", null, uz.m, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var6.j(w33.a)).o, x20Var6, 390, 0, 131066);
                        x20Var6.p(false);
                    } else {
                        x20Var6.W(998630161);
                        q44.e("ALLOW ALL PERMISSIONS", fq0Var, x20Var6, 6);
                        x20Var6.p(false);
                    }
                    if (qj2Var.e) {
                        x20Var6.W(998777504);
                        k54.h(x20Var6, w44.c(bk1Var, 12.0f));
                        dz2.b("Some permissions were declined. You can enable them later in Settings.", null, uz.r, 0L, null, null, 0L, null, 0L, 0, false, 0, 0, ((v33) x20Var6.j(w33.a)).o, x20Var6, 390, 0, 131066);
                    } else {
                        x20Var6.W(995045941);
                    }
                    x20Var6.p(false);
                } else {
                    x20Var6.R();
                }
                return q43Var;
            case 11:
                ((Integer) obj2).getClass();
                q44.g((String) obj7, (fq0) obj6, (x20) obj, ny3.c(7));
                return q43Var;
            case 12:
                ((Integer) obj2).getClass();
                q44.h((op2) obj7, (fq0) obj6, (x20) obj, ny3.c(1));
                return q43Var;
            case 13:
                ((Integer) obj2).getClass();
                y34.a((ek1) obj7, (w10) obj6, (x20) obj, ny3.c(49));
                return q43Var;
            case 14:
                ((Integer) obj2).getClass();
                ((ak1) obj7).d((Drawable) obj6, (x20) obj, ny3.c(49));
                return q43Var;
            case 15:
                return d(obj, obj2);
            default:
                ((Integer) obj2).getClass();
                dz2.a((yz2) obj7, (w10) obj6, (x20) obj, ny3.c(1));
                return q43Var;
        }
    }

    public /* synthetic */ km(int i, w10 w10Var, Object obj) {
        this.a = i;
        this.b = w10Var;
        this.c = obj;
    }

    public /* synthetic */ km(int i, Object obj, Object obj2) {
        this.a = i;
        this.c = obj;
        this.b = obj2;
    }
}
