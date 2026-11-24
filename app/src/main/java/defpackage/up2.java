package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class up2 {
    public final r2 a;
    public final dt1 b;
    public final xp2 c;
    public final xj1 d;
    public final nb2 e;

    public up2(r2 r2Var, dt1 dt1Var, xp2 xp2Var, xj1 xj1Var, nb2 nb2Var) {
        r2Var.getClass();
        dt1Var.getClass();
        xp2Var.getClass();
        xj1Var.getClass();
        nb2Var.getClass();
        this.a = r2Var;
        this.b = dt1Var;
        this.c = xp2Var;
        this.d = xj1Var;
        this.e = nb2Var;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01dd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:102:0x01df A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:103:0x01e7 A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:105:0x01f0 A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:107:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:108:0x01f8 A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0214 A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:112:0x021a A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:115:0x022d A[Catch: all -> 0x004c, LOOP:0: B:113:0x0227->B:115:0x022d, LOOP_END, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:119:0x024e A[Catch: all -> 0x004c, LOOP:1: B:117:0x0248->B:119:0x024e, LOOP_END, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:123:0x0281  */
    /* JADX WARN: Code duplicated, block: B:125:0x0285 A[Catch: all -> 0x004c, TRY_ENTER, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:127:0x0292 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:133:0x02bf  */
    /* JADX WARN: Code duplicated, block: B:136:0x02c9  */
    /* JADX WARN: Code duplicated, block: B:137:0x02cb A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:139:0x02d9 A[ADDED_TO_REGION, REMOVE] */
    /* JADX WARN: Code duplicated, block: B:140:0x02da A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:145:0x02e7 A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:146:0x02f5 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:149:0x0300  */
    /* JADX WARN: Code duplicated, block: B:156:0x0313  */
    /* JADX WARN: Code duplicated, block: B:160:0x031d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0138  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:81:0x0173  */
    /* JADX WARN: Code duplicated, block: B:83:0x0179  */
    /* JADX WARN: Code duplicated, block: B:86:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:87:0x01a3 A[Catch: all -> 0x004c, PHI: r0 r1 r2 r5 r6 r7 r10 r11 r12
      0x01a3: PHI (r0v11 java.lang.Object) = (r0v9 java.lang.Object), (r0v33 java.lang.Object) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r1v18 android.graphics.Bitmap) = (r1v14 android.graphics.Bitmap), (r1v31 android.graphics.Bitmap) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r2v21 boolean) = (r2v17 boolean), (r2v43 boolean) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r5v15 int) = (r5v10 int), (r5v24 int) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r6v12 java.lang.String) = (r6v8 java.lang.String), (r6v20 java.lang.String) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r7v10 long) = (r7v8 long), (r7v20 long) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r10v5 java.lang.String) = (r10v3 java.lang.String), (r10v9 java.lang.String) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r11v12 java.util.List) = (r11v9 java.util.List), (r11v18 java.util.List) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE]
      0x01a3: PHI (r12v13 java.lang.String) = (r12v10 java.lang.String), (r12v20 java.lang.String) binds: [B:85:0x019f, B:23:0x006a] A[DONT_GENERATE, DONT_INLINE], TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x01a7 A[Catch: all -> 0x004c, TRY_LEAVE, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b6 A[Catch: all -> 0x004c, TRY_ENTER, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x01cd A[Catch: all -> 0x004c, TryCatch #5 {all -> 0x004c, blocks: (B:15:0x0046, B:134:0x02c1, B:153:0x0308, B:137:0x02cb, B:145:0x02e7, B:146:0x02f5, B:140:0x02da, B:143:0x02e1, B:87:0x01a3, B:89:0x01a7, B:94:0x01b6, B:96:0x01cd, B:100:0x01da, B:105:0x01f0, B:109:0x020e, B:111:0x0214, B:112:0x021a, B:113:0x0227, B:115:0x022d, B:116:0x023b, B:117:0x0248, B:119:0x024e, B:120:0x0268, B:108:0x01f8, B:125:0x0285, B:127:0x0292, B:102:0x01df, B:103:0x01e7, B:84:0x017f), top: B:177:0x0036 }] */
    /* JADX WARN: Code duplicated, block: B:98:0x01d8  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d9  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v19 */
    /* JADX WARN: Type inference failed for: r1v30 */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v24 */
    /* JADX WARN: Type inference failed for: r6v25 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v9, types: [jb] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object a(String str, String str2, int i, boolean z, List list, y50 y50Var) throws Throwable {
        sp2 sp2Var;
        String strH;
        String str3;
        String str4;
        boolean z2;
        List list2;
        int i2;
        String str5;
        int i3;
        jb jbVar;
        String str6;
        Object objN;
        List list3;
        String str7;
        Object obj;
        boolean z3;
        String str8;
        jb jbVar2;
        boolean z4;
        String str9;
        int i4;
        Bitmap bitmap;
        Object r6;
        String str10;
        long jElapsedRealtime;
        Object objA;
        List list4;
        List listD;
        hp1 hp1VarA;
        String str11;
        Bitmap bitmap2;
        hp1 hp1Var;
        String str12;
        List<hp1> listL;
        ArrayList arrayList;
        Iterator it;
        ArrayList arrayList2;
        Object r3Var;
        Object objZ;
        Rect rect;
        AccessibilityService accessibilityServiceI;
        boolean zC;
        Object t3Var;
        Bitmap bitmap3 = i;
        xp2 xp2Var = this.c;
        if (y50Var instanceof sp2) {
            sp2Var = (sp2) y50Var;
            int i5 = sp2Var.H;
            if ((i5 & Integer.MIN_VALUE) != 0) {
                sp2Var.H = i5 - Integer.MIN_VALUE;
            } else {
                sp2Var = new sp2(this, y50Var);
            }
        } else {
            sp2Var = new sp2(this, y50Var);
        }
        Object objB = sp2Var.w;
        int i6 = sp2Var.H;
        jb jbVar3 = 3;
        nb2 nb2Var = this.e;
        r2 r2Var = this.a;
        dt1 dt1Var = this.b;
        ii0 ii0Var = ii0.a;
        Object obj2 = t70.a;
        try {
            try {
                if (i6 == 0) {
                    bz3.g(objB);
                    strH = cs2.A(str) ? ky0.h(bitmap3, "Spotify result ") : str;
                    if (r2Var.i() == null || !r2Var.j()) {
                        return u3.a;
                    }
                    nb2Var.getClass();
                    if (!nb2Var.a.k("com.spotify.music")) {
                        return new t3(strH, ii0Var);
                    }
                    jb jbVarA = dt1Var.a();
                    str3 = str;
                    try {
                        sp2Var.e = str3;
                        str4 = str2;
                        try {
                            sp2Var.f = str4;
                            list2 = list;
                            try {
                                sp2Var.i = list2;
                                sp2Var.j = strH;
                                sp2Var.k = jbVarA;
                                sp2Var.t = bitmap3;
                                z2 = z;
                                try {
                                    sp2Var.u = z2;
                                    sp2Var.H = 1;
                                    if (bg4.b(sp2Var) != obj2) {
                                        str5 = str3;
                                        i3 = i;
                                        jbVar = jbVarA;
                                        sp2Var.e = str5;
                                        sp2Var.f = str4;
                                        sp2Var.i = list2;
                                        sp2Var.j = strH;
                                        sp2Var.k = jbVar;
                                        sp2Var.t = i3;
                                        sp2Var.u = z2;
                                        str6 = str5;
                                        sp2Var.H = 2;
                                        objN = r2Var.n(sp2Var);
                                        if (objN != obj2) {
                                            list3 = list2;
                                            str7 = str4;
                                            obj = objN;
                                            z3 = z2;
                                            str8 = str6;
                                            jbVar3 = jbVar;
                                            Bitmap bitmap4 = (Bitmap) obj;
                                            dt1Var.c(jbVar3);
                                            int i7 = i3;
                                            z4 = z3;
                                            bitmap = bitmap4;
                                            i4 = i7;
                                            str9 = str7;
                                            list2 = list3;
                                            str10 = strH;
                                            if (bitmap == null) {
                                                return new t3(str10, ii0Var);
                                            }
                                            jElapsedRealtime = SystemClock.elapsedRealtime();
                                            xj1 xj1Var = this.d;
                                            sp2Var.e = str8;
                                            sp2Var.f = str9;
                                            sp2Var.i = list2;
                                            sp2Var.j = str10;
                                            sp2Var.k = null;
                                            sp2Var.n = bitmap;
                                            sp2Var.t = i4;
                                            sp2Var.u = z4;
                                            sp2Var.v = jElapsedRealtime;
                                            sp2Var.H = 3;
                                            xj1Var.getClass();
                                            objA = xj1.a(bitmap, sp2Var);
                                            if (objA != obj2) {
                                                list4 = (List) objA;
                                                if (list4 == null) {
                                                    t3 t3Var2 = new t3(str10, ii0Var);
                                                    if (!bitmap.isRecycled()) {
                                                        bitmap.recycle();
                                                    }
                                                    return t3Var2;
                                                }
                                                int width = bitmap.getWidth();
                                                int height = bitmap.getHeight();
                                                xp2Var.getClass();
                                                listD = xp2.d(list4, width, height);
                                                if (cs2.A(str8)) {
                                                    objZ = mz.z(i4 - 1, listD);
                                                    if (i4 > 0) {
                                                        objZ = null;
                                                    }
                                                    hp1VarA = (hp1) objZ;
                                                } else if (z4) {
                                                    xp2Var.getClass();
                                                    hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                                                } else {
                                                    xp2Var.getClass();
                                                    hp1VarA = xp2.a(str8, str9, listD);
                                                }
                                                if (hp1VarA == null) {
                                                    if (cs2.A(str8)) {
                                                        listL = ii0Var;
                                                    } else {
                                                        listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                                    }
                                                    if (listL.isEmpty()) {
                                                        r3Var = new t3(str10, ii0Var);
                                                    } else {
                                                        arrayList = new ArrayList(nz.d(listL));
                                                        it = listL.iterator();
                                                        while (it.hasNext()) {
                                                            arrayList.add(((hp1) it.next()).a());
                                                        }
                                                        arrayList2 = new ArrayList(nz.d(listL));
                                                        for (hp1 hp1Var2 : listL) {
                                                            arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                                        }
                                                        r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                                    }
                                                    if (!bitmap.isRecycled()) {
                                                        bitmap.recycle();
                                                    }
                                                    return r3Var;
                                                }
                                                nb2Var.getClass();
                                                str11 = "com.spotify.music";
                                                if (nb2Var.a.k(str11)) {
                                                    Rect rect2 = hp1VarA.d;
                                                    sp2Var.e = null;
                                                    sp2Var.f = null;
                                                    sp2Var.i = null;
                                                    sp2Var.j = str10;
                                                    sp2Var.k = null;
                                                    sp2Var.n = bitmap;
                                                    sp2Var.s = hp1VarA;
                                                    sp2Var.t = i4;
                                                    sp2Var.u = z4;
                                                    sp2Var.v = jElapsedRealtime;
                                                    sp2Var.H = 4;
                                                    bitmap2 = bitmap;
                                                    objB = b(bitmap2, rect2, jElapsedRealtime, sp2Var);
                                                    bitmap = bitmap2;
                                                    if (objB != obj2) {
                                                        hp1Var = hp1VarA;
                                                        str12 = str10;
                                                        if (!((Boolean) objB).booleanValue()) {
                                                            rect = hp1Var.d;
                                                            nb2Var.getClass();
                                                            r2 r2Var2 = nb2Var.a;
                                                            accessibilityServiceI = r2Var2.i();
                                                            zC = false;
                                                            if (accessibilityServiceI != null) {
                                                                zC = nb2.C(accessibilityServiceI, rect);
                                                            }
                                                            if (zC) {
                                                                t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                                            } else {
                                                                t3Var = new t3(str12, ii0Var);
                                                            }
                                                            if (!bitmap.isRecycled()) {
                                                                bitmap.recycle();
                                                            }
                                                            return t3Var;
                                                        }
                                                        str10 = str12;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                } catch (Throwable unused) {
                                    i2 = i;
                                    jbVar2 = jbVarA;
                                    dt1Var.c(jbVar2);
                                    boolean z5 = z2;
                                    str8 = str3;
                                    z4 = z5;
                                    str9 = str4;
                                    i4 = i2;
                                    bitmap = null;
                                    str10 = strH;
                                    if (bitmap == null) {
                                        return new t3(str10, ii0Var);
                                    }
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    xj1 xj1Var2 = this.d;
                                    sp2Var.e = str8;
                                    sp2Var.f = str9;
                                    sp2Var.i = list2;
                                    sp2Var.j = str10;
                                    sp2Var.k = null;
                                    sp2Var.n = bitmap;
                                    sp2Var.t = i4;
                                    sp2Var.u = z4;
                                    sp2Var.v = jElapsedRealtime;
                                    sp2Var.H = 3;
                                    xj1Var2.getClass();
                                    objA = xj1.a(bitmap, sp2Var);
                                    if (objA != obj2) {
                                        list4 = (List) objA;
                                        if (list4 == null) {
                                            t3 t3Var3 = new t3(str10, ii0Var);
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            return t3Var3;
                                        }
                                        int width2 = bitmap.getWidth();
                                        int height2 = bitmap.getHeight();
                                        xp2Var.getClass();
                                        listD = xp2.d(list4, width2, height2);
                                        if (cs2.A(str8)) {
                                            objZ = mz.z(i4 - 1, listD);
                                            if (i4 > 0) {
                                                objZ = null;
                                            }
                                            hp1VarA = (hp1) objZ;
                                        } else if (z4) {
                                            xp2Var.getClass();
                                            hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                                        } else {
                                            xp2Var.getClass();
                                            hp1VarA = xp2.a(str8, str9, listD);
                                        }
                                        if (hp1VarA == null) {
                                            if (cs2.A(str8)) {
                                                listL = ii0Var;
                                            } else {
                                                listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                            }
                                            if (listL.isEmpty()) {
                                                r3Var = new t3(str10, ii0Var);
                                            } else {
                                                arrayList = new ArrayList(nz.d(listL));
                                                it = listL.iterator();
                                                while (it.hasNext()) {
                                                    arrayList.add(((hp1) it.next()).a());
                                                }
                                                arrayList2 = new ArrayList(nz.d(listL));
                                                while (r0.hasNext()) {
                                                    arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                                }
                                                r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                            }
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            return r3Var;
                                        }
                                        nb2Var.getClass();
                                        str11 = "com.spotify.music";
                                        if (nb2Var.a.k(str11)) {
                                            Rect rect3 = hp1VarA.d;
                                            sp2Var.e = null;
                                            sp2Var.f = null;
                                            sp2Var.i = null;
                                            sp2Var.j = str10;
                                            sp2Var.k = null;
                                            sp2Var.n = bitmap;
                                            sp2Var.s = hp1VarA;
                                            sp2Var.t = i4;
                                            sp2Var.u = z4;
                                            sp2Var.v = jElapsedRealtime;
                                            sp2Var.H = 4;
                                            bitmap2 = bitmap;
                                            objB = b(bitmap2, rect3, jElapsedRealtime, sp2Var);
                                            bitmap = bitmap2;
                                            if (objB != obj2) {
                                                hp1Var = hp1VarA;
                                                str12 = str10;
                                                if (!((Boolean) objB).booleanValue()) {
                                                    rect = hp1Var.d;
                                                    nb2Var.getClass();
                                                    r2 r2Var3 = nb2Var.a;
                                                    accessibilityServiceI = r2Var3.i();
                                                    zC = false;
                                                    if (accessibilityServiceI != null) {
                                                        zC = nb2.C(accessibilityServiceI, rect);
                                                    }
                                                    if (zC) {
                                                        t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                                    } else {
                                                        t3Var = new t3(str12, ii0Var);
                                                    }
                                                    if (!bitmap.isRecycled()) {
                                                        bitmap.recycle();
                                                    }
                                                    return t3Var;
                                                }
                                                str10 = str12;
                                            }
                                        }
                                        t3 t3Var4 = new t3(str10, ii0Var);
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                        return t3Var4;
                                    }
                                    return obj2;
                                }
                            } catch (Throwable unused2) {
                                z2 = z;
                            }
                        } catch (Throwable unused3) {
                            z2 = z;
                            list2 = list;
                            i2 = i;
                            jbVar2 = jbVarA;
                            dt1Var.c(jbVar2);
                            boolean z6 = z2;
                            str8 = str3;
                            z4 = z6;
                            str9 = str4;
                            i4 = i2;
                            bitmap = null;
                            str10 = strH;
                            if (bitmap == null) {
                                return new t3(str10, ii0Var);
                            }
                            jElapsedRealtime = SystemClock.elapsedRealtime();
                            xj1 xj1Var3 = this.d;
                            sp2Var.e = str8;
                            sp2Var.f = str9;
                            sp2Var.i = list2;
                            sp2Var.j = str10;
                            sp2Var.k = null;
                            sp2Var.n = bitmap;
                            sp2Var.t = i4;
                            sp2Var.u = z4;
                            sp2Var.v = jElapsedRealtime;
                            sp2Var.H = 3;
                            xj1Var3.getClass();
                            objA = xj1.a(bitmap, sp2Var);
                            if (objA != obj2) {
                                list4 = (List) objA;
                                if (list4 == null) {
                                    t3 t3Var5 = new t3(str10, ii0Var);
                                    if (!bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                    return t3Var5;
                                }
                                int width3 = bitmap.getWidth();
                                int height3 = bitmap.getHeight();
                                xp2Var.getClass();
                                listD = xp2.d(list4, width3, height3);
                                if (cs2.A(str8)) {
                                    objZ = mz.z(i4 - 1, listD);
                                    if (i4 > 0) {
                                        objZ = null;
                                    }
                                    hp1VarA = (hp1) objZ;
                                } else if (z4) {
                                    xp2Var.getClass();
                                    hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                                } else {
                                    xp2Var.getClass();
                                    hp1VarA = xp2.a(str8, str9, listD);
                                }
                                if (hp1VarA == null) {
                                    if (cs2.A(str8)) {
                                        listL = ii0Var;
                                    } else {
                                        listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                    }
                                    if (listL.isEmpty()) {
                                        r3Var = new t3(str10, ii0Var);
                                    } else {
                                        arrayList = new ArrayList(nz.d(listL));
                                        it = listL.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add(((hp1) it.next()).a());
                                        }
                                        arrayList2 = new ArrayList(nz.d(listL));
                                        while (r0.hasNext()) {
                                            arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                        }
                                        r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                    }
                                    if (!bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                    return r3Var;
                                }
                                nb2Var.getClass();
                                str11 = "com.spotify.music";
                                if (nb2Var.a.k(str11)) {
                                    Rect rect4 = hp1VarA.d;
                                    sp2Var.e = null;
                                    sp2Var.f = null;
                                    sp2Var.i = null;
                                    sp2Var.j = str10;
                                    sp2Var.k = null;
                                    sp2Var.n = bitmap;
                                    sp2Var.s = hp1VarA;
                                    sp2Var.t = i4;
                                    sp2Var.u = z4;
                                    sp2Var.v = jElapsedRealtime;
                                    sp2Var.H = 4;
                                    bitmap2 = bitmap;
                                    objB = b(bitmap2, rect4, jElapsedRealtime, sp2Var);
                                    bitmap = bitmap2;
                                    if (objB != obj2) {
                                        hp1Var = hp1VarA;
                                        str12 = str10;
                                        if (!((Boolean) objB).booleanValue()) {
                                            rect = hp1Var.d;
                                            nb2Var.getClass();
                                            r2 r2Var4 = nb2Var.a;
                                            accessibilityServiceI = r2Var4.i();
                                            zC = false;
                                            if (accessibilityServiceI != null) {
                                                zC = nb2.C(accessibilityServiceI, rect);
                                            }
                                            if (zC) {
                                                t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                            } else {
                                                t3Var = new t3(str12, ii0Var);
                                            }
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            return t3Var;
                                        }
                                        str10 = str12;
                                    }
                                }
                                t3 t3Var6 = new t3(str10, ii0Var);
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return t3Var6;
                            }
                            return obj2;
                        }
                    } catch (Throwable unused4) {
                        str4 = str2;
                    }
                    return obj2;
                }
                if (i6 == 1) {
                    boolean z7 = sp2Var.u;
                    int i8 = sp2Var.t;
                    jb jbVar4 = sp2Var.k;
                    String str13 = sp2Var.j;
                    List list5 = sp2Var.i;
                    String str14 = sp2Var.f;
                    str5 = sp2Var.e;
                    try {
                        bz3.g(objB);
                        i3 = i8;
                        str4 = str14;
                        strH = str13;
                        list2 = list5;
                        z2 = z7;
                        jbVar = jbVar4;
                        try {
                            sp2Var.e = str5;
                            sp2Var.f = str4;
                            sp2Var.i = list2;
                            sp2Var.j = strH;
                            sp2Var.k = jbVar;
                            sp2Var.t = i3;
                            sp2Var.u = z2;
                            str6 = str5;
                            try {
                                sp2Var.H = 2;
                                objN = r2Var.n(sp2Var);
                                if (objN != obj2) {
                                    list3 = list2;
                                    str7 = str4;
                                    obj = objN;
                                    z3 = z2;
                                    str8 = str6;
                                    jbVar3 = jbVar;
                                    Bitmap bitmap5 = (Bitmap) obj;
                                    dt1Var.c(jbVar3);
                                    int i9 = i3;
                                    z4 = z3;
                                    bitmap = bitmap5;
                                    i4 = i9;
                                    str9 = str7;
                                    list2 = list3;
                                    str10 = strH;
                                    if (bitmap == null) {
                                        return new t3(str10, ii0Var);
                                    }
                                    jElapsedRealtime = SystemClock.elapsedRealtime();
                                    xj1 xj1Var4 = this.d;
                                    sp2Var.e = str8;
                                    sp2Var.f = str9;
                                    sp2Var.i = list2;
                                    sp2Var.j = str10;
                                    sp2Var.k = null;
                                    sp2Var.n = bitmap;
                                    sp2Var.t = i4;
                                    sp2Var.u = z4;
                                    sp2Var.v = jElapsedRealtime;
                                    sp2Var.H = 3;
                                    xj1Var4.getClass();
                                    objA = xj1.a(bitmap, sp2Var);
                                    if (objA != obj2) {
                                        list4 = (List) objA;
                                        if (list4 == null) {
                                            t3 t3Var7 = new t3(str10, ii0Var);
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            return t3Var7;
                                        }
                                        int width4 = bitmap.getWidth();
                                        int height4 = bitmap.getHeight();
                                        xp2Var.getClass();
                                        listD = xp2.d(list4, width4, height4);
                                        if (cs2.A(str8)) {
                                            objZ = mz.z(i4 - 1, listD);
                                            if (i4 > 0) {
                                                objZ = null;
                                            }
                                            hp1VarA = (hp1) objZ;
                                        } else if (z4) {
                                            xp2Var.getClass();
                                            hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                                        } else {
                                            xp2Var.getClass();
                                            hp1VarA = xp2.a(str8, str9, listD);
                                        }
                                        if (hp1VarA == null) {
                                            if (cs2.A(str8)) {
                                                listL = ii0Var;
                                            } else {
                                                listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                            }
                                            if (listL.isEmpty()) {
                                                r3Var = new t3(str10, ii0Var);
                                            } else {
                                                arrayList = new ArrayList(nz.d(listL));
                                                it = listL.iterator();
                                                while (it.hasNext()) {
                                                    arrayList.add(((hp1) it.next()).a());
                                                }
                                                arrayList2 = new ArrayList(nz.d(listL));
                                                while (r0.hasNext()) {
                                                    arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                                }
                                                r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                            }
                                            if (!bitmap.isRecycled()) {
                                                bitmap.recycle();
                                            }
                                            return r3Var;
                                        }
                                        nb2Var.getClass();
                                        str11 = "com.spotify.music";
                                        if (nb2Var.a.k(str11)) {
                                            Rect rect5 = hp1VarA.d;
                                            sp2Var.e = null;
                                            sp2Var.f = null;
                                            sp2Var.i = null;
                                            sp2Var.j = str10;
                                            sp2Var.k = null;
                                            sp2Var.n = bitmap;
                                            sp2Var.s = hp1VarA;
                                            sp2Var.t = i4;
                                            sp2Var.u = z4;
                                            sp2Var.v = jElapsedRealtime;
                                            sp2Var.H = 4;
                                            bitmap2 = bitmap;
                                            objB = b(bitmap2, rect5, jElapsedRealtime, sp2Var);
                                            bitmap = bitmap2;
                                            if (objB != obj2) {
                                                hp1Var = hp1VarA;
                                                str12 = str10;
                                                if (!((Boolean) objB).booleanValue()) {
                                                    rect = hp1Var.d;
                                                    nb2Var.getClass();
                                                    r2 r2Var5 = nb2Var.a;
                                                    accessibilityServiceI = r2Var5.i();
                                                    zC = false;
                                                    if (accessibilityServiceI != null) {
                                                        zC = nb2.C(accessibilityServiceI, rect);
                                                    }
                                                    if (zC) {
                                                        t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                                    } else {
                                                        t3Var = new t3(str12, ii0Var);
                                                    }
                                                    if (!bitmap.isRecycled()) {
                                                        bitmap.recycle();
                                                    }
                                                    return t3Var;
                                                }
                                                str10 = str12;
                                            }
                                        }
                                    }
                                }
                            } catch (Throwable unused5) {
                                i2 = i3;
                                str3 = str6;
                                jbVar2 = jbVar;
                                dt1Var.c(jbVar2);
                                boolean z8 = z2;
                                str8 = str3;
                                z4 = z8;
                                str9 = str4;
                                i4 = i2;
                                bitmap = null;
                            }
                        } catch (Throwable unused6) {
                            str6 = str5;
                        }
                    } catch (Throwable unused7) {
                        str3 = str5;
                        i2 = i8;
                        str4 = str14;
                        strH = str13;
                        list2 = list5;
                        z2 = z7;
                        jbVar2 = jbVar4;
                        dt1Var.c(jbVar2);
                        boolean z9 = z2;
                        str8 = str3;
                        z4 = z9;
                        str9 = str4;
                        i4 = i2;
                        bitmap = null;
                        str10 = strH;
                        if (bitmap == null) {
                            return new t3(str10, ii0Var);
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        xj1 xj1Var5 = this.d;
                        sp2Var.e = str8;
                        sp2Var.f = str9;
                        sp2Var.i = list2;
                        sp2Var.j = str10;
                        sp2Var.k = null;
                        sp2Var.n = bitmap;
                        sp2Var.t = i4;
                        sp2Var.u = z4;
                        sp2Var.v = jElapsedRealtime;
                        sp2Var.H = 3;
                        xj1Var5.getClass();
                        objA = xj1.a(bitmap, sp2Var);
                        if (objA != obj2) {
                            list4 = (List) objA;
                            if (list4 == null) {
                                t3 t3Var8 = new t3(str10, ii0Var);
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return t3Var8;
                            }
                            int width5 = bitmap.getWidth();
                            int height5 = bitmap.getHeight();
                            xp2Var.getClass();
                            listD = xp2.d(list4, width5, height5);
                            if (cs2.A(str8)) {
                                objZ = mz.z(i4 - 1, listD);
                                if (i4 > 0) {
                                    objZ = null;
                                }
                                hp1VarA = (hp1) objZ;
                            } else if (z4) {
                                xp2Var.getClass();
                                hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                            } else {
                                xp2Var.getClass();
                                hp1VarA = xp2.a(str8, str9, listD);
                            }
                            if (hp1VarA == null) {
                                if (cs2.A(str8)) {
                                    listL = ii0Var;
                                } else {
                                    listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                }
                                if (listL.isEmpty()) {
                                    r3Var = new t3(str10, ii0Var);
                                } else {
                                    arrayList = new ArrayList(nz.d(listL));
                                    it = listL.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((hp1) it.next()).a());
                                    }
                                    arrayList2 = new ArrayList(nz.d(listL));
                                    while (r0.hasNext()) {
                                        arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                    }
                                    r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                }
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return r3Var;
                            }
                            nb2Var.getClass();
                            str11 = "com.spotify.music";
                            if (nb2Var.a.k(str11)) {
                                Rect rect6 = hp1VarA.d;
                                sp2Var.e = null;
                                sp2Var.f = null;
                                sp2Var.i = null;
                                sp2Var.j = str10;
                                sp2Var.k = null;
                                sp2Var.n = bitmap;
                                sp2Var.s = hp1VarA;
                                sp2Var.t = i4;
                                sp2Var.u = z4;
                                sp2Var.v = jElapsedRealtime;
                                sp2Var.H = 4;
                                bitmap2 = bitmap;
                                objB = b(bitmap2, rect6, jElapsedRealtime, sp2Var);
                                bitmap = bitmap2;
                                if (objB != obj2) {
                                    hp1Var = hp1VarA;
                                    str12 = str10;
                                    if (!((Boolean) objB).booleanValue()) {
                                        rect = hp1Var.d;
                                        nb2Var.getClass();
                                        r2 r2Var6 = nb2Var.a;
                                        accessibilityServiceI = r2Var6.i();
                                        zC = false;
                                        if (accessibilityServiceI != null) {
                                            zC = nb2.C(accessibilityServiceI, rect);
                                        }
                                        if (zC) {
                                            t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                        } else {
                                            t3Var = new t3(str12, ii0Var);
                                        }
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                        return t3Var;
                                    }
                                    str10 = str12;
                                }
                            }
                            t3 t3Var9 = new t3(str10, ii0Var);
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return t3Var9;
                        }
                        return obj2;
                    }
                    return obj2;
                }
                if (i6 == 2) {
                    z3 = sp2Var.u;
                    int i10 = sp2Var.t;
                    jb jbVar5 = sp2Var.k;
                    strH = sp2Var.j;
                    list3 = sp2Var.i;
                    str7 = sp2Var.f;
                    str8 = sp2Var.e;
                    try {
                        bz3.g(objB);
                        obj = objB;
                        i3 = i10;
                        jbVar3 = jbVar5;
                        try {
                            Bitmap bitmap6 = (Bitmap) obj;
                            dt1Var.c(jbVar3);
                            int i11 = i3;
                            z4 = z3;
                            bitmap = bitmap6;
                            i4 = i11;
                            str9 = str7;
                            list2 = list3;
                        } catch (Throwable unused8) {
                            String str15 = str8;
                            z2 = z3;
                            i2 = i3;
                            str3 = str15;
                            r6 = jbVar3;
                            str4 = str7;
                            list2 = list3;
                            jbVar2 = r6;
                            dt1Var.c(jbVar2);
                            boolean z10 = z2;
                            str8 = str3;
                            z4 = z10;
                            str9 = str4;
                            i4 = i2;
                            bitmap = null;
                        }
                    } catch (Throwable unused9) {
                        str3 = str8;
                        z2 = z3;
                        i2 = i10;
                        r6 = jbVar5;
                        str4 = str7;
                        list2 = list3;
                        jbVar2 = r6;
                        dt1Var.c(jbVar2);
                        boolean z11 = z2;
                        str8 = str3;
                        z4 = z11;
                        str9 = str4;
                        i4 = i2;
                        bitmap = null;
                        str10 = strH;
                        if (bitmap == null) {
                            return new t3(str10, ii0Var);
                        }
                        jElapsedRealtime = SystemClock.elapsedRealtime();
                        xj1 xj1Var6 = this.d;
                        sp2Var.e = str8;
                        sp2Var.f = str9;
                        sp2Var.i = list2;
                        sp2Var.j = str10;
                        sp2Var.k = null;
                        sp2Var.n = bitmap;
                        sp2Var.t = i4;
                        sp2Var.u = z4;
                        sp2Var.v = jElapsedRealtime;
                        sp2Var.H = 3;
                        xj1Var6.getClass();
                        objA = xj1.a(bitmap, sp2Var);
                        if (objA != obj2) {
                            list4 = (List) objA;
                            if (list4 == null) {
                                t3 t3Var10 = new t3(str10, ii0Var);
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return t3Var10;
                            }
                            int width6 = bitmap.getWidth();
                            int height6 = bitmap.getHeight();
                            xp2Var.getClass();
                            listD = xp2.d(list4, width6, height6);
                            if (cs2.A(str8)) {
                                objZ = mz.z(i4 - 1, listD);
                                if (i4 > 0) {
                                    objZ = null;
                                }
                                hp1VarA = (hp1) objZ;
                            } else if (z4) {
                                xp2Var.getClass();
                                hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                            } else {
                                xp2Var.getClass();
                                hp1VarA = xp2.a(str8, str9, listD);
                            }
                            if (hp1VarA == null) {
                                if (cs2.A(str8)) {
                                    listL = ii0Var;
                                } else {
                                    listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                                }
                                if (listL.isEmpty()) {
                                    r3Var = new t3(str10, ii0Var);
                                } else {
                                    arrayList = new ArrayList(nz.d(listL));
                                    it = listL.iterator();
                                    while (it.hasNext()) {
                                        arrayList.add(((hp1) it.next()).a());
                                    }
                                    arrayList2 = new ArrayList(nz.d(listL));
                                    while (r0.hasNext()) {
                                        arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                    }
                                    r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                                }
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return r3Var;
                            }
                            nb2Var.getClass();
                            str11 = "com.spotify.music";
                            if (nb2Var.a.k(str11)) {
                                Rect rect7 = hp1VarA.d;
                                sp2Var.e = null;
                                sp2Var.f = null;
                                sp2Var.i = null;
                                sp2Var.j = str10;
                                sp2Var.k = null;
                                sp2Var.n = bitmap;
                                sp2Var.s = hp1VarA;
                                sp2Var.t = i4;
                                sp2Var.u = z4;
                                sp2Var.v = jElapsedRealtime;
                                sp2Var.H = 4;
                                bitmap2 = bitmap;
                                objB = b(bitmap2, rect7, jElapsedRealtime, sp2Var);
                                bitmap = bitmap2;
                                if (objB != obj2) {
                                    hp1Var = hp1VarA;
                                    str12 = str10;
                                    if (!((Boolean) objB).booleanValue()) {
                                        rect = hp1Var.d;
                                        nb2Var.getClass();
                                        r2 r2Var7 = nb2Var.a;
                                        accessibilityServiceI = r2Var7.i();
                                        zC = false;
                                        if (accessibilityServiceI != null) {
                                            zC = nb2.C(accessibilityServiceI, rect);
                                        }
                                        if (zC) {
                                            t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                        } else {
                                            t3Var = new t3(str12, ii0Var);
                                        }
                                        if (!bitmap.isRecycled()) {
                                            bitmap.recycle();
                                        }
                                        return t3Var;
                                    }
                                    str10 = str12;
                                }
                            }
                            t3 t3Var11 = new t3(str10, ii0Var);
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return t3Var11;
                        }
                        return obj2;
                    }
                    str10 = strH;
                    if (bitmap == null) {
                        return new t3(str10, ii0Var);
                    }
                    jElapsedRealtime = SystemClock.elapsedRealtime();
                    xj1 xj1Var7 = this.d;
                    sp2Var.e = str8;
                    sp2Var.f = str9;
                    sp2Var.i = list2;
                    sp2Var.j = str10;
                    sp2Var.k = null;
                    sp2Var.n = bitmap;
                    sp2Var.t = i4;
                    sp2Var.u = z4;
                    sp2Var.v = jElapsedRealtime;
                    sp2Var.H = 3;
                    xj1Var7.getClass();
                    objA = xj1.a(bitmap, sp2Var);
                    if (objA != obj2) {
                        list4 = (List) objA;
                        if (list4 == null) {
                            t3 t3Var12 = new t3(str10, ii0Var);
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return t3Var12;
                        }
                        int width7 = bitmap.getWidth();
                        int height7 = bitmap.getHeight();
                        xp2Var.getClass();
                        listD = xp2.d(list4, width7, height7);
                        if (cs2.A(str8)) {
                            objZ = mz.z(i4 - 1, listD);
                            if (i4 > 0) {
                                objZ = null;
                            }
                            hp1VarA = (hp1) objZ;
                        } else if (z4) {
                            xp2Var.getClass();
                            hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                        } else {
                            xp2Var.getClass();
                            hp1VarA = xp2.a(str8, str9, listD);
                        }
                        if (hp1VarA == null) {
                            if (cs2.A(str8)) {
                                listL = ii0Var;
                            } else {
                                listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                            }
                            if (listL.isEmpty()) {
                                r3Var = new t3(str10, ii0Var);
                            } else {
                                arrayList = new ArrayList(nz.d(listL));
                                it = listL.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((hp1) it.next()).a());
                                }
                                arrayList2 = new ArrayList(nz.d(listL));
                                while (r0.hasNext()) {
                                    arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                }
                                r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                            }
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return r3Var;
                        }
                        nb2Var.getClass();
                        str11 = "com.spotify.music";
                        if (nb2Var.a.k(str11)) {
                            Rect rect8 = hp1VarA.d;
                            sp2Var.e = null;
                            sp2Var.f = null;
                            sp2Var.i = null;
                            sp2Var.j = str10;
                            sp2Var.k = null;
                            sp2Var.n = bitmap;
                            sp2Var.s = hp1VarA;
                            sp2Var.t = i4;
                            sp2Var.u = z4;
                            sp2Var.v = jElapsedRealtime;
                            sp2Var.H = 4;
                            bitmap2 = bitmap;
                            objB = b(bitmap2, rect8, jElapsedRealtime, sp2Var);
                            bitmap = bitmap2;
                            if (objB != obj2) {
                                hp1Var = hp1VarA;
                                str12 = str10;
                                if (!((Boolean) objB).booleanValue()) {
                                    rect = hp1Var.d;
                                    nb2Var.getClass();
                                    r2 r2Var8 = nb2Var.a;
                                    accessibilityServiceI = r2Var8.i();
                                    zC = false;
                                    if (accessibilityServiceI != null) {
                                        zC = nb2.C(accessibilityServiceI, rect);
                                    }
                                    if (zC) {
                                        t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                                    } else {
                                        t3Var = new t3(str12, ii0Var);
                                    }
                                    if (!bitmap.isRecycled()) {
                                        bitmap.recycle();
                                    }
                                    return t3Var;
                                }
                                str10 = str12;
                            }
                        }
                    }
                    return obj2;
                }
                if (i6 == 3) {
                    long j = sp2Var.v;
                    boolean z12 = sp2Var.u;
                    i4 = sp2Var.t;
                    Bitmap bitmap7 = sp2Var.n;
                    str10 = sp2Var.j;
                    list2 = sp2Var.i;
                    str9 = sp2Var.f;
                    String str16 = sp2Var.e;
                    try {
                        bz3.g(objB);
                        objA = objB;
                        z4 = z12;
                        str8 = str16;
                        bitmap = bitmap7;
                        jElapsedRealtime = j;
                        list4 = (List) objA;
                        if (list4 == null) {
                            t3 t3Var13 = new t3(str10, ii0Var);
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return t3Var13;
                        }
                        int width8 = bitmap.getWidth();
                        int height8 = bitmap.getHeight();
                        xp2Var.getClass();
                        listD = xp2.d(list4, width8, height8);
                        if (cs2.A(str8)) {
                            objZ = mz.z(i4 - 1, listD);
                            if (i4 > 0) {
                                objZ = null;
                            }
                            hp1VarA = (hp1) objZ;
                        } else if (z4) {
                            xp2Var.getClass();
                            hp1VarA = xp2.b(listD, str8, str9, list2, i4);
                        } else {
                            xp2Var.getClass();
                            hp1VarA = xp2.a(str8, str9, listD);
                        }
                        if (hp1VarA == null) {
                            if (cs2.A(str8)) {
                                listL = ii0Var;
                            } else {
                                listL = mz.L(mz.K(listD, new i2(23, new wp2(3))), 4);
                            }
                            if (listL.isEmpty()) {
                                r3Var = new t3(str10, ii0Var);
                            } else {
                                arrayList = new ArrayList(nz.d(listL));
                                it = listL.iterator();
                                while (it.hasNext()) {
                                    arrayList.add(((hp1) it.next()).a());
                                }
                                arrayList2 = new ArrayList(nz.d(listL));
                                while (r0.hasNext()) {
                                    arrayList2.add(new xv2(hp1Var2.a, hp1Var2.b, new Rect(hp1Var2.d)));
                                }
                                r3Var = new r3(str10, arrayList, null, arrayList2, 4);
                            }
                            if (!bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return r3Var;
                        }
                        nb2Var.getClass();
                        str11 = "com.spotify.music";
                        if (nb2Var.a.k(str11)) {
                            Rect rect9 = hp1VarA.d;
                            sp2Var.e = null;
                            sp2Var.f = null;
                            sp2Var.i = null;
                            sp2Var.j = str10;
                            sp2Var.k = null;
                            sp2Var.n = bitmap;
                            sp2Var.s = hp1VarA;
                            sp2Var.t = i4;
                            sp2Var.u = z4;
                            sp2Var.v = jElapsedRealtime;
                            sp2Var.H = 4;
                            bitmap2 = bitmap;
                            try {
                                objB = b(bitmap2, rect9, jElapsedRealtime, sp2Var);
                                bitmap = bitmap2;
                                if (objB != obj2) {
                                    hp1Var = hp1VarA;
                                    str12 = str10;
                                }
                                return obj2;
                            } catch (Throwable th) {
                                th = th;
                                bitmap3 = bitmap2;
                                if (!bitmap3.isRecycled()) {
                                    bitmap3.recycle();
                                }
                                throw th;
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bitmap3 = bitmap7;
                        if (!bitmap3.isRecycled()) {
                            bitmap3.recycle();
                        }
                        throw th;
                    }
                } else {
                    if (i6 != 4) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    hp1Var = sp2Var.s;
                    bitmap = sp2Var.n;
                    str12 = sp2Var.j;
                    bz3.g(objB);
                    str11 = "com.spotify.music";
                }
                if (!((Boolean) objB).booleanValue()) {
                    rect = hp1Var.d;
                    nb2Var.getClass();
                    r2 r2Var9 = nb2Var.a;
                    accessibilityServiceI = r2Var9.i();
                    zC = false;
                    if (accessibilityServiceI != null && r2Var9.k(str11)) {
                        zC = nb2.C(accessibilityServiceI, rect);
                    }
                    if (zC) {
                        t3Var = new s3(hp1Var.a(), hp1Var.a, hp1Var.b);
                    } else {
                        t3Var = new t3(str12, ii0Var);
                    }
                    if (!bitmap.isRecycled()) {
                        bitmap.recycle();
                    }
                    return t3Var;
                }
                str10 = str12;
                t3 t3Var14 = new t3(str10, ii0Var);
                if (!bitmap.isRecycled()) {
                    bitmap.recycle();
                }
                return t3Var14;
            } catch (CancellationException e) {
                try {
                    throw e;
                } catch (Throwable th3) {
                    dt1Var.c(jbVar3);
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    /* JADX WARN: Code duplicated, block: B:102:0x017e  */
    /* JADX WARN: Code duplicated, block: B:158:0x010b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:57:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:68:0x0108  */
    /* JADX WARN: Code duplicated, block: B:72:0x0115 A[Catch: all -> 0x0173, Exception -> 0x0177, TryCatch #13 {Exception -> 0x0177, all -> 0x0173, blocks: (B:70:0x010b, B:72:0x0115, B:75:0x0121, B:100:0x017a), top: B:158:0x010b }] */
    /* JADX WARN: Code duplicated, block: B:79:0x014d  */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    /* JADX WARN: Code duplicated, block: B:80:0x014f  */
    /* JADX WARN: Code duplicated, block: B:82:0x0152  */
    /* JADX WARN: Code duplicated, block: B:84:0x0157 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:87:0x015c  */
    /* JADX WARN: Code duplicated, block: B:89:0x0161  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v32 */
    /* JADX WARN: Type inference failed for: r0v34, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r0v35 */
    /* JADX WARN: Type inference failed for: r0v36 */
    /* JADX WARN: Type inference failed for: r0v37 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v9 */
    /* JADX WARN: Type inference failed for: r10v0, types: [dt1] */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r1v1, types: [jb] */
    /* JADX WARN: Type inference failed for: r1v2, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v29 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v31 */
    /* JADX WARN: Type inference failed for: r1v32 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8, types: [android.graphics.Rect] */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final Object b(Bitmap bitmap, Rect rect, long j, y50 y50Var) throws Throwable {
        tp2 tp2Var;
        Bitmap bitmap2;
        Object r1;
        jb jbVarA;
        Object r0;
        Bitmap bitmap3;
        jb jbVar;
        long j2;
        jb jbVar2;
        Object r2;
        Bitmap bitmap4;
        Object r3;
        Bitmap bitmapCreateBitmap;
        Bitmap bitmapCreateBitmap2;
        boolean zSameAs;
        Bitmap bitmap5;
        var r4 = rect;
        long j3 = j;
        if (y50Var instanceof tp2) {
            tp2Var = (tp2) y50Var;
            int i = tp2Var.s;
            if ((i & Integer.MIN_VALUE) != 0) {
                tp2Var.s = i - Integer.MIN_VALUE;
            } else {
                tp2Var = new tp2(this, y50Var);
            }
        } else {
            tp2Var = new tp2(this, y50Var);
        }
        Object objN = tp2Var.k;
        int i2 = tp2Var.s;
        var r10 = this.b;
        Bitmap bitmap6 = null;
        t70 t70Var = t70.a;
        try {
            try {
                if (i2 == 0) {
                    bz3.g(objN);
                    if (r4.isEmpty() || ((Rect) r4).left < 0 || ((Rect) r4).top < 0 || ((Rect) r4).right > bitmap.getWidth() || ((Rect) r4).bottom > bitmap.getHeight()) {
                        return Boolean.FALSE;
                    }
                    long jElapsedRealtime = 350 - (SystemClock.elapsedRealtime() - j3);
                    long j4 = jElapsedRealtime >= 0 ? jElapsedRealtime : 0L;
                    bitmap2 = bitmap;
                    tp2Var.e = bitmap2;
                    tp2Var.f = r4;
                    tp2Var.j = j3;
                    tp2Var.s = 1;
                    r1 = r4;
                    if (bm4.b(j4, tp2Var) != t70Var) {
                    }
                    return t70Var;
                }
                if (i2 == 1) {
                    long j5 = tp2Var.j;
                    Rect rect2 = tp2Var.f;
                    Bitmap bitmap7 = tp2Var.e;
                    bz3.g(objN);
                    r1 = rect2;
                    j3 = j5;
                    bitmap2 = bitmap7;
                } else if (i2 == 2) {
                    long j6 = tp2Var.j;
                    jbVar2 = tp2Var.i;
                    Rect rect3 = tp2Var.f;
                    Bitmap bitmap8 = tp2Var.e;
                    try {
                        try {
                            bz3.g(objN);
                            bitmap3 = bitmap8;
                            j2 = j6;
                            r2 = rect3;
                            try {
                                r2 r2Var = this.a;
                                tp2Var.e = bitmap3;
                                tp2Var.f = r2;
                                tp2Var.i = jbVar2;
                                tp2Var.j = j2;
                                tp2Var.s = 3;
                                objN = r2Var.n(tp2Var);
                                if (objN != t70Var) {
                                    r0 = r2;
                                    jbVar = jbVar2;
                                    bitmap4 = (Bitmap) objN;
                                    r10.c(jbVar);
                                    r3 = r0;
                                    if (bitmap4 == null) {
                                        return Boolean.FALSE;
                                    }
                                    if (bitmap4.getWidth() == bitmap3.getWidth()) {
                                        bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                                        bitmapCreateBitmap.getClass();
                                        bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap4, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                                        bitmapCreateBitmap2.getClass();
                                        zSameAs = bitmapCreateBitmap.sameAs(bitmapCreateBitmap2);
                                        if (bitmapCreateBitmap != bitmap3) {
                                            bitmap5 = bitmapCreateBitmap;
                                        } else {
                                            bitmap5 = null;
                                        }
                                        if (bitmap5 != null) {
                                            bitmap5.recycle();
                                        }
                                        if (bitmapCreateBitmap2 != bitmap4) {
                                            bitmap6 = bitmapCreateBitmap2;
                                        }
                                        if (bitmap6 != null) {
                                            bitmap6.recycle();
                                        }
                                        if (bitmap4 != bitmap3) {
                                            bitmap4.recycle();
                                        }
                                        return Boolean.valueOf(zSameAs);
                                    }
                                    Boolean bool = Boolean.FALSE;
                                    if (bitmap4 != bitmap3) {
                                        bitmap4.recycle();
                                    }
                                    return bool;
                                }
                                return t70Var;
                            } catch (Exception unused) {
                                r0 = r2;
                                jbVar = jbVar2;
                                r10.c(jbVar);
                                bitmap4 = null;
                                r3 = r0;
                            }
                        } catch (Exception unused2) {
                            jbVar = jbVar2;
                            r0 = rect3;
                            bitmap3 = bitmap8;
                            r10.c(jbVar);
                            bitmap4 = null;
                            r3 = r0;
                            if (bitmap4 == null) {
                                return Boolean.FALSE;
                            }
                            if (bitmap4.getWidth() == bitmap3.getWidth()) {
                                bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                                bitmapCreateBitmap.getClass();
                                bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap4, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                                bitmapCreateBitmap2.getClass();
                                zSameAs = bitmapCreateBitmap.sameAs(bitmapCreateBitmap2);
                                if (bitmapCreateBitmap != bitmap3) {
                                    bitmap5 = bitmapCreateBitmap;
                                } else {
                                    bitmap5 = null;
                                }
                                if (bitmap5 != null) {
                                    bitmap5.recycle();
                                }
                                if (bitmapCreateBitmap2 != bitmap4) {
                                    bitmap6 = bitmapCreateBitmap2;
                                }
                                if (bitmap6 != null) {
                                    bitmap6.recycle();
                                }
                                if (bitmap4 != bitmap3) {
                                    bitmap4.recycle();
                                }
                                return Boolean.valueOf(zSameAs);
                            }
                            Boolean bool2 = Boolean.FALSE;
                            if (bitmap4 != bitmap3) {
                                bitmap4.recycle();
                            }
                            return bool2;
                        }
                    } catch (CancellationException e) {
                        throw e;
                    } catch (Throwable th) {
                        th = th;
                        r4 = jbVar2;
                        r10.c(r4);
                        throw th;
                    }
                } else {
                    if (i2 != 3) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    jbVar = tp2Var.i;
                    r0 = tp2Var.f;
                    bitmap3 = tp2Var.e;
                    try {
                        bz3.g(objN);
                        r0 = r0;
                        bitmap4 = (Bitmap) objN;
                        r10.c(jbVar);
                        r3 = r0;
                    } catch (CancellationException e2) {
                        throw e2;
                    } catch (Exception unused3) {
                        r10.c(jbVar);
                        bitmap4 = null;
                        r3 = r0;
                    }
                    if (bitmap4 == null) {
                        return Boolean.FALSE;
                    }
                    try {
                        if (bitmap4.getWidth() == bitmap3.getWidth() && bitmap4.getHeight() == bitmap3.getHeight()) {
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                            bitmapCreateBitmap.getClass();
                            try {
                                bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap4, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                                bitmapCreateBitmap2.getClass();
                                try {
                                    zSameAs = bitmapCreateBitmap.sameAs(bitmapCreateBitmap2);
                                    if (bitmapCreateBitmap != bitmap3) {
                                        bitmap5 = bitmapCreateBitmap;
                                    } else {
                                        bitmap5 = null;
                                    }
                                    if (bitmap5 != null) {
                                        bitmap5.recycle();
                                    }
                                    if (bitmapCreateBitmap2 != bitmap4 && bitmapCreateBitmap2 != bitmapCreateBitmap) {
                                        bitmap6 = bitmapCreateBitmap2;
                                    }
                                    if (bitmap6 != null) {
                                        bitmap6.recycle();
                                    }
                                    if (bitmap4 != bitmap3 && !bitmap4.isRecycled()) {
                                        bitmap4.recycle();
                                    }
                                } catch (Exception unused4) {
                                    if (bitmapCreateBitmap != null) {
                                        Bitmap bitmap9 = bitmapCreateBitmap != bitmap3 ? bitmapCreateBitmap : null;
                                        if (bitmap9 != null) {
                                            bitmap9.recycle();
                                        }
                                    }
                                    if (bitmapCreateBitmap2 != null) {
                                        if (bitmapCreateBitmap2 != bitmap4 && bitmapCreateBitmap2 != bitmapCreateBitmap) {
                                            bitmap6 = bitmapCreateBitmap2;
                                        }
                                        if (bitmap6 != null) {
                                            bitmap6.recycle();
                                        }
                                    }
                                    if (bitmap4 != bitmap3 && !bitmap4.isRecycled()) {
                                        bitmap4.recycle();
                                    }
                                    zSameAs = false;
                                } catch (Throwable th2) {
                                    th = th2;
                                    if (bitmapCreateBitmap != null) {
                                        Bitmap bitmap10 = bitmapCreateBitmap != bitmap3 ? bitmapCreateBitmap : null;
                                        if (bitmap10 != null) {
                                            bitmap10.recycle();
                                        }
                                    }
                                    if (bitmapCreateBitmap2 != null) {
                                        if (bitmapCreateBitmap2 != bitmap4 && bitmapCreateBitmap2 != bitmapCreateBitmap) {
                                            bitmap6 = bitmapCreateBitmap2;
                                        }
                                        if (bitmap6 != null) {
                                            bitmap6.recycle();
                                        }
                                    }
                                    if (bitmap4 != bitmap3 && !bitmap4.isRecycled()) {
                                        bitmap4.recycle();
                                    }
                                    throw th;
                                }
                            } catch (Exception unused5) {
                                bitmapCreateBitmap2 = null;
                            } catch (Throwable th3) {
                                th = th3;
                                bitmapCreateBitmap2 = null;
                            }
                            return Boolean.valueOf(zSameAs);
                        }
                        Boolean bool3 = Boolean.FALSE;
                        if (bitmap4 != bitmap3 && !bitmap4.isRecycled()) {
                            bitmap4.recycle();
                        }
                        return bool3;
                    } catch (Exception unused6) {
                        bitmapCreateBitmap = null;
                        bitmapCreateBitmap2 = null;
                    } catch (Throwable th4) {
                        th = th4;
                        bitmapCreateBitmap = null;
                        bitmapCreateBitmap2 = null;
                    }
                }
                tp2Var.e = bitmap2;
                tp2Var.f = r1;
                tp2Var.i = jbVarA;
                tp2Var.j = j3;
                tp2Var.s = 2;
                if (bg4.b(tp2Var) != t70Var) {
                    j2 = j3;
                    bitmap3 = bitmap2;
                    jbVar2 = jbVarA;
                    r2 = r1;
                    r2 r2Var2 = this.a;
                    tp2Var.e = bitmap3;
                    tp2Var.f = r2;
                    tp2Var.i = jbVar2;
                    tp2Var.j = j2;
                    tp2Var.s = 3;
                    objN = r2Var2.n(tp2Var);
                    if (objN != t70Var) {
                        r0 = r2;
                        jbVar = jbVar2;
                        bitmap4 = (Bitmap) objN;
                        r10.c(jbVar);
                        r3 = r0;
                        if (bitmap4 == null) {
                            return Boolean.FALSE;
                        }
                        if (bitmap4.getWidth() == bitmap3.getWidth()) {
                            bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                            bitmapCreateBitmap.getClass();
                            bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap4, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                            bitmapCreateBitmap2.getClass();
                            zSameAs = bitmapCreateBitmap.sameAs(bitmapCreateBitmap2);
                            if (bitmapCreateBitmap != bitmap3) {
                                bitmap5 = bitmapCreateBitmap;
                            } else {
                                bitmap5 = null;
                            }
                            if (bitmap5 != null) {
                                bitmap5.recycle();
                            }
                            if (bitmapCreateBitmap2 != bitmap4) {
                                bitmap6 = bitmapCreateBitmap2;
                            }
                            if (bitmap6 != null) {
                                bitmap6.recycle();
                            }
                            if (bitmap4 != bitmap3) {
                                bitmap4.recycle();
                            }
                            return Boolean.valueOf(zSameAs);
                        }
                        Boolean bool4 = Boolean.FALSE;
                        if (bitmap4 != bitmap3) {
                            bitmap4.recycle();
                        }
                        return bool4;
                    }
                }
                return t70Var;
            } catch (CancellationException e3) {
                throw e3;
            } catch (Exception unused7) {
                r0 = r1;
                bitmap3 = bitmap2;
                jbVar = jbVarA;
                r10.c(jbVar);
                bitmap4 = null;
                r3 = r0;
                if (bitmap4 == null) {
                    return Boolean.FALSE;
                }
                if (bitmap4.getWidth() == bitmap3.getWidth()) {
                    bitmapCreateBitmap = Bitmap.createBitmap(bitmap3, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                    bitmapCreateBitmap.getClass();
                    bitmapCreateBitmap2 = Bitmap.createBitmap(bitmap4, ((Rect) r3).left, ((Rect) r3).top, r3.width(), r3.height());
                    bitmapCreateBitmap2.getClass();
                    zSameAs = bitmapCreateBitmap.sameAs(bitmapCreateBitmap2);
                    if (bitmapCreateBitmap != bitmap3) {
                        bitmap5 = bitmapCreateBitmap;
                    } else {
                        bitmap5 = null;
                    }
                    if (bitmap5 != null) {
                        bitmap5.recycle();
                    }
                    if (bitmapCreateBitmap2 != bitmap4) {
                        bitmap6 = bitmapCreateBitmap2;
                    }
                    if (bitmap6 != null) {
                        bitmap6.recycle();
                    }
                    if (bitmap4 != bitmap3) {
                        bitmap4.recycle();
                    }
                    return Boolean.valueOf(zSameAs);
                }
                Boolean bool5 = Boolean.FALSE;
                if (bitmap4 != bitmap3) {
                    bitmap4.recycle();
                }
                return bool5;
            } catch (Throwable th5) {
                th = th5;
                r4 = jbVarA;
                r10.c(r4);
                throw th;
            }
            jbVarA = r10.a();
        } catch (Throwable th6) {
            th = th6;
        }
    }
}
