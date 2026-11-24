package defpackage;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class et0 extends nu2 implements vq0 {
    public final /* synthetic */ long H;
    public final /* synthetic */ hq0 X;
    public final /* synthetic */ hq0 Y;
    public dd1 f;
    public t42 i;
    public o42 j;
    public o42 k;
    public p6 n;
    public Throwable s;
    public int t;
    public /* synthetic */ Object u;
    public final /* synthetic */ mt0 v;
    public final /* synthetic */ String w;
    public final /* synthetic */ g5 x;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public et0(mt0 mt0Var, String str, g5 g5Var, long j, hq0 hq0Var, hq0 hq0Var2, x50 x50Var) {
        super(2, x50Var);
        this.v = mt0Var;
        this.w = str;
        this.x = g5Var;
        this.H = j;
        this.X = hq0Var;
        this.Y = hq0Var2;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        return ((et0) q((x50) obj2, (s70) obj)).s(q43.a);
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        et0 et0Var = new et0(this.v, this.w, this.x, this.H, this.X, this.Y, x50Var);
        et0Var.u = obj;
        return et0Var;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01dd  */
    /* JADX WARN: Code duplicated, block: B:103:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:104:0x01e2 A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:106:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:107:0x01ea  */
    /* JADX WARN: Code duplicated, block: B:111:0x0202  */
    /* JADX WARN: Code duplicated, block: B:118:0x022c  */
    /* JADX WARN: Code duplicated, block: B:123:0x0244  */
    /* JADX WARN: Code duplicated, block: B:124:0x0247  */
    /* JADX WARN: Code duplicated, block: B:132:0x0278  */
    /* JADX WARN: Code duplicated, block: B:134:0x027c  */
    /* JADX WARN: Code duplicated, block: B:138:0x028e  */
    /* JADX WARN: Code duplicated, block: B:143:0x02b5  */
    /* JADX WARN: Code duplicated, block: B:148:0x02ce  */
    /* JADX WARN: Code duplicated, block: B:149:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:156:0x0307  */
    /* JADX WARN: Code duplicated, block: B:159:0x0311  */
    /* JADX WARN: Code duplicated, block: B:164:0x0335  */
    /* JADX WARN: Code duplicated, block: B:166:0x033a  */
    /* JADX WARN: Code duplicated, block: B:168:0x0344  */
    /* JADX WARN: Code duplicated, block: B:169:0x0347  */
    /* JADX WARN: Code duplicated, block: B:174:0x035e  */
    /* JADX WARN: Code duplicated, block: B:176:0x036d  */
    /* JADX WARN: Code duplicated, block: B:179:0x0376  */
    /* JADX WARN: Code duplicated, block: B:183:0x037f  */
    /* JADX WARN: Code duplicated, block: B:40:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0135  */
    /* JADX WARN: Code duplicated, block: B:46:0x0138  */
    /* JADX WARN: Code duplicated, block: B:63:0x0179 A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:64:0x017f A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:66:0x0183 A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:69:0x018b  */
    /* JADX WARN: Code duplicated, block: B:71:0x018f A[Catch: all -> 0x0072, TRY_LEAVE, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:74:0x019b A[Catch: all -> 0x0072, TRY_ENTER, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:77:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:81:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:82:0x01ae A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:84:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:85:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:86:0x01b8 A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x01be A[Catch: all -> 0x0072, TryCatch #1 {all -> 0x0072, blocks: (B:13:0x0069, B:61:0x0175, B:63:0x0179, B:67:0x0185, B:108:0x01eb, B:71:0x018f, B:74:0x019b, B:82:0x01ae, B:83:0x01b3, B:86:0x01b8, B:88:0x01be, B:96:0x01cf, B:104:0x01e2, B:105:0x01e7, B:64:0x017f, B:66:0x0183, B:128:0x0264, B:130:0x026e, B:135:0x027f, B:24:0x00b6, B:25:0x00b8, B:27:0x00d0, B:29:0x00d9), top: B:203:0x000f, inners: #4 }] */
    /* JADX WARN: Code duplicated, block: B:90:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:91:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:93:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:94:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:95:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:98:0x01d8 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:99:0x01da  */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x03b6, code lost:
    
        if (defpackage.uf4.d(r2, r4, r26) == r3) goto L192;
     */
    @Override // defpackage.pk
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object s(java.lang.Object r27) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.et0.s(java.lang.Object):java.lang.Object");
    }
}
