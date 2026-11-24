package com.ibm.icu.text;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class UnicodeDecompressor implements SCSU {
    private static final int BUFSIZE = 3;
    private int fCurrentWindow = 0;
    private int[] fOffsets = new int[8];
    private int fMode = 0;
    private byte[] fBuffer = new byte[3];
    private int fBufferLength = 0;

    public UnicodeDecompressor() {
        reset();
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:26:0x005c. Please report as an issue. */
    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not found exit edge by exit block: B:45:0x00f3
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.checkLoopExits(LoopRegionMaker.java:272)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.makeLoopRegion(LoopRegionMaker.java:237)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:80)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.LoopRegionMaker.process(LoopRegionMaker.java:162)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:92)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.IfRegionMaker.process(IfRegionMaker.java:117)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.traverse(RegionMaker.java:109)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeRegion(RegionMaker.java:69)
        	at jadx.core.dex.visitors.regions.maker.RegionMaker.makeMthRegion(RegionMaker.java:49)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:25)
        */
    public int decompress(byte[] r17, int r18, int r19, int[] r20, char[] r21, int r22, int r23) {
        /*
            Method dump skipped, instruction units count: 1058
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ibm.icu.text.UnicodeDecompressor.decompress(byte[], int, int, int[], char[], int, int):int");
    }

    public void reset() {
        int[] iArr = this.fOffsets;
        iArr[0] = 128;
        iArr[1] = 192;
        iArr[2] = 1024;
        iArr[3] = 1536;
        iArr[4] = 2304;
        iArr[5] = 12352;
        iArr[6] = 12448;
        iArr[7] = 65280;
        this.fCurrentWindow = 0;
        this.fMode = 0;
        this.fBufferLength = 0;
    }

    public static char[] decompress(byte[] bArr, int i, int i2) {
        UnicodeDecompressor unicodeDecompressor = new UnicodeDecompressor();
        int iMax = Math.max(2, (i2 - i) * 2);
        char[] cArr = new char[iMax];
        int iDecompress = unicodeDecompressor.decompress(bArr, i, i2, null, cArr, 0, iMax);
        char[] cArr2 = new char[iDecompress];
        System.arraycopy(cArr, 0, cArr2, 0, iDecompress);
        return cArr2;
    }

    public static String decompress(byte[] bArr) {
        return new String(decompress(bArr, 0, bArr.length));
    }
}
