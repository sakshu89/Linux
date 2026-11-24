package com.ibm.icu.impl.breakiter;

import com.ibm.icu.impl.ICUData;
import com.ibm.icu.impl.ICUResourceBundle;
import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.lang.UProperty;
import com.ibm.icu.lang.UScript;
import com.ibm.icu.text.BreakIterator;
import com.ibm.icu.text.UnicodeSet;
import com.ibm.icu.util.UResourceBundle;
import defpackage.cq;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.text.CharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public class LSTMBreakEngine extends DictionaryBreakEngine {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final byte MIN_WORD = 2;
    private static final byte MIN_WORD_SPAN = 4;
    private final LSTMData fData;
    private int fScript;
    private final Vectorizer fVectorizer;

    /* JADX INFO: renamed from: com.ibm.icu.impl.breakiter.LSTMBreakEngine$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$ibm$icu$impl$breakiter$LSTMBreakEngine$EmbeddingType;

        static {
            int[] iArr = new int[EmbeddingType.values().length];
            $SwitchMap$com$ibm$icu$impl$breakiter$LSTMBreakEngine$EmbeddingType = iArr;
            try {
                iArr[EmbeddingType.CODE_POINTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ibm$icu$impl$breakiter$LSTMBreakEngine$EmbeddingType[EmbeddingType.GRAPHEME_CLUSTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class CodePointsVectorizer extends Vectorizer {
        public CodePointsVectorizer(Map<String, Integer> map) {
            super(map);
        }

        @Override // com.ibm.icu.impl.breakiter.LSTMBreakEngine.Vectorizer
        public void vectorize(CharacterIterator characterIterator, int i, int i2, List<Integer> list, List<Integer> list2) {
            characterIterator.setIndex(i);
            char cCurrent = characterIterator.current();
            while (cCurrent != 65535 && characterIterator.getIndex() < i2) {
                list.add(Integer.valueOf(characterIterator.getIndex()));
                list2.add(Integer.valueOf(getIndex(String.valueOf(cCurrent))));
                cCurrent = characterIterator.next();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum EmbeddingType {
        UNKNOWN,
        CODE_POINTS,
        GRAPHEME_CLUSTER
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class GraphemeClusterVectorizer extends Vectorizer {
        public GraphemeClusterVectorizer(Map<String, Integer> map) {
            super(map);
        }

        private String substring(CharacterIterator characterIterator, int i, int i2) {
            int index = characterIterator.getIndex();
            characterIterator.setIndex(i);
            StringBuilder sb = new StringBuilder();
            char cCurrent = characterIterator.current();
            while (cCurrent != 65535 && characterIterator.getIndex() < i2) {
                sb.append(cCurrent);
                cCurrent = characterIterator.next();
            }
            characterIterator.setIndex(index);
            return sb.toString();
        }

        @Override // com.ibm.icu.impl.breakiter.LSTMBreakEngine.Vectorizer
        public void vectorize(CharacterIterator characterIterator, int i, int i2, List<Integer> list, List<Integer> list2) {
            BreakIterator characterInstance = BreakIterator.getCharacterInstance();
            characterInstance.setText(characterIterator);
            int next = characterInstance.next(i);
            int next2 = characterInstance.next();
            while (true) {
                int i3 = next2;
                int i4 = next;
                next = i3;
                if (next == -1 || next > i2) {
                    return;
                }
                list.add(Integer.valueOf(i4));
                list2.add(Integer.valueOf(getIndex(substring(characterIterator, i4, next))));
                next2 = characterInstance.next();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public enum LSTMClass {
        BEGIN,
        INSIDE,
        END,
        SINGLE
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class Vectorizer {
        private Map<String, Integer> fDict;

        public Vectorizer(Map<String, Integer> map) {
            this.fDict = map;
        }

        public int getIndex(String str) {
            Integer num = this.fDict.get(str);
            return num == null ? this.fDict.size() : num.intValue();
        }

        public abstract void vectorize(CharacterIterator characterIterator, int i, int i2, List<Integer> list, List<Integer> list2);
    }

    public LSTMBreakEngine(int i, UnicodeSet unicodeSet, LSTMData lSTMData) {
        setCharacters(unicodeSet);
        this.fScript = i;
        this.fData = lSTMData;
        this.fVectorizer = makeVectorizer(lSTMData);
    }

    private static void addDotProductTo(float[] fArr, float[][] fArr2, float[] fArr3) {
        for (int i = 0; i < fArr3.length; i++) {
            for (int i2 = 0; i2 < fArr.length; i2++) {
                fArr3[i] = (fArr[i2] * fArr2[i2][i]) + fArr3[i];
            }
        }
    }

    private static void addHadamardProductTo(float[] fArr, float[] fArr2, float[] fArr3) {
        for (int i = 0; i < fArr3.length; i++) {
            fArr3[i] = (fArr[i] * fArr2[i]) + fArr3[i];
        }
    }

    private float[] compute(float[][] fArr, float[][] fArr2, float[] fArr3, float[] fArr4, float[] fArr5, float[] fArr6) {
        float[] fArrCopyOf = Arrays.copyOf(fArr3, fArr3.length);
        addDotProductTo(fArr4, fArr, fArrCopyOf);
        float[] fArr7 = new float[fArr3.length];
        addDotProductTo(fArr5, fArr2, fArrCopyOf);
        int length = fArr3.length / 4;
        sigmoid(fArrCopyOf, 0, length);
        sigmoid(fArrCopyOf, length, length);
        int i = length * 2;
        tanh(fArrCopyOf, i, length);
        int i2 = length * 3;
        sigmoid(fArrCopyOf, i2, length);
        hadamardProductTo(Arrays.copyOfRange(fArrCopyOf, length, i), fArr6);
        addHadamardProductTo(Arrays.copyOf(fArrCopyOf, length), Arrays.copyOfRange(fArrCopyOf, i, i2), fArr6);
        float[] fArrCopyOf2 = Arrays.copyOf(fArr6, fArr6.length);
        tanh(fArrCopyOf2, 0, fArrCopyOf2.length);
        hadamardProductTo(Arrays.copyOfRange(fArrCopyOf, i2, length * 4), fArrCopyOf2);
        return fArrCopyOf2;
    }

    public static LSTMBreakEngine create(int i, LSTMData lSTMData) {
        String strV = cq.v("[[:", UScript.getShortName(i), ":]&[:LineBreak=SA:]]");
        UnicodeSet unicodeSet = new UnicodeSet();
        unicodeSet.applyPattern(strV);
        unicodeSet.compact();
        return new LSTMBreakEngine(i, unicodeSet, lSTMData);
    }

    public static LSTMData createData(int i) {
        if (i != 23 && i != 24 && i != 28 && i != 38) {
            return null;
        }
        String strDefaultLSTM = defaultLSTM(i);
        return createData(UResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME, strDefaultLSTM.substring(0, strDefaultLSTM.indexOf(".")), ICUResourceBundle.ICU_DATA_CLASS_LOADER));
    }

    private static String defaultLSTM(int i) {
        return ((ICUResourceBundle) UResourceBundle.getBundleInstance(ICUData.ICU_BRKITR_BASE_NAME)).getStringWithFallback("lstm/" + UScript.getShortName(i));
    }

    private static void hadamardProductTo(float[] fArr, float[] fArr2) {
        for (int i = 0; i < fArr2.length; i++) {
            fArr2[i] = fArr2[i] * fArr[i];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[] make1DArray(int[] iArr, int i, int i2) {
        float[] fArr = new float[i2];
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + 1;
            int i5 = iArr[i];
            fArr[i3] = ByteBuffer.wrap(new byte[]{(byte) (i5 >> 24), (byte) (i5 >> 16), (byte) (i5 >> 8), (byte) i5}).order(ByteOrder.BIG_ENDIAN).getFloat();
            i3++;
            i = i4;
        }
        return fArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static float[][] make2DArray(int[] iArr, int i, int i2, int i3) {
        float[][] fArr = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i2, i3);
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = 0;
            while (i5 < i3) {
                int i6 = i + 1;
                int i7 = iArr[i];
                fArr[i4][i5] = ByteBuffer.wrap(new byte[]{(byte) (i7 >> 24), (byte) (i7 >> 16), (byte) (i7 >> 8), (byte) i7}).order(ByteOrder.BIG_ENDIAN).getFloat();
                i5++;
                i = i6;
            }
        }
        return fArr;
    }

    private Vectorizer makeVectorizer(LSTMData lSTMData) {
        int i = AnonymousClass1.$SwitchMap$com$ibm$icu$impl$breakiter$LSTMBreakEngine$EmbeddingType[lSTMData.fType.ordinal()];
        if (i == 1) {
            return new CodePointsVectorizer(lSTMData.fDict);
        }
        if (i != 2) {
            return null;
        }
        return new GraphemeClusterVectorizer(lSTMData.fDict);
    }

    private static int maxIndex(float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < fArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        return i;
    }

    private static void sigmoid(float[] fArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            fArr[i3] = (float) (1.0d / (Math.exp(-fArr[i3]) + 1.0d));
        }
    }

    private static void tanh(float[] fArr, int i, int i2) {
        for (int i3 = i; i3 < i + i2; i3++) {
            fArr[i3] = (float) Math.tanh(fArr[i3]);
        }
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine
    public int divideUpDictionaryRange(CharacterIterator characterIterator, int i, int i2, DictionaryBreakEngine.DequeI dequeI, boolean z) {
        int size = dequeI.size();
        int i3 = i2 - i;
        if (i3 < 4) {
            return 0;
        }
        ArrayList arrayList = new ArrayList(i3);
        ArrayList arrayList2 = new ArrayList(i3);
        this.fVectorizer.vectorize(characterIterator, i, i2, arrayList, arrayList2);
        int size2 = arrayList2.size();
        int length = this.fData.fForwardU.length;
        float[] fArr = new float[length];
        float[][] fArr2 = (float[][]) Array.newInstance((Class<?>) Float.TYPE, size2, length);
        int i4 = size2 - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            if (i5 != i4) {
                fArr2[i5] = Arrays.copyOf(fArr2[i5 + 1], length);
            }
            LSTMData lSTMData = this.fData;
            fArr2[i5] = compute(lSTMData.fBackwardW, lSTMData.fBackwardU, lSTMData.fBackwardB, lSTMData.fEmbedding[((Integer) arrayList2.get(i5)).intValue()], fArr2[i5], fArr);
        }
        float[] fArr3 = new float[length];
        float[] fArr4 = new float[length * 2];
        float[] fArrCompute = new float[length];
        for (int i6 = 0; i6 < size2; i6++) {
            LSTMData lSTMData2 = this.fData;
            fArrCompute = compute(lSTMData2.fForwardW, lSTMData2.fForwardU, lSTMData2.fForwardB, lSTMData2.fEmbedding[((Integer) arrayList2.get(i6)).intValue()], fArrCompute, fArr3);
            System.arraycopy(fArrCompute, 0, fArr4, 0, length);
            System.arraycopy(fArr2[i6], 0, fArr4, length, length);
            float[] fArr5 = this.fData.fOutputB;
            float[] fArrCopyOf = Arrays.copyOf(fArr5, fArr5.length);
            addDotProductTo(fArr4, this.fData.fOutputW, fArrCopyOf);
            int iMaxIndex = maxIndex(fArrCopyOf);
            if ((iMaxIndex == LSTMClass.BEGIN.ordinal() || iMaxIndex == LSTMClass.SINGLE.ordinal()) && i6 != 0) {
                dequeI.push(((Integer) arrayList.get(i6)).intValue());
            }
        }
        return dequeI.size() - size;
    }

    @Override // com.ibm.icu.impl.breakiter.DictionaryBreakEngine, com.ibm.icu.impl.breakiter.LanguageBreakEngine
    public boolean handles(int i) {
        return this.fScript == UCharacter.getIntPropertyValue(i, UProperty.SCRIPT);
    }

    public int hashCode() {
        return getClass().hashCode();
    }

    public static LSTMData createData(UResourceBundle uResourceBundle) {
        return new LSTMData(uResourceBundle);
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class LSTMData {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        public float[] fBackwardB;
        public float[][] fBackwardU;
        public float[][] fBackwardW;
        public Map<String, Integer> fDict;
        public float[][] fEmbedding;
        public float[] fForwardB;
        public float[][] fForwardU;
        public float[][] fForwardW;
        public String fName;
        public float[] fOutputB;
        public float[][] fOutputW;
        public EmbeddingType fType;

        public LSTMData(UResourceBundle uResourceBundle) {
            int i = uResourceBundle.get("embeddings").getInt();
            int i2 = uResourceBundle.get("hunits").getInt();
            this.fType = EmbeddingType.UNKNOWN;
            this.fName = uResourceBundle.get("model").getString();
            String string = uResourceBundle.get("type").getString();
            if (string.equals("codepoints")) {
                this.fType = EmbeddingType.CODE_POINTS;
            } else if (string.equals("graphclust")) {
                this.fType = EmbeddingType.GRAPHEME_CLUSTER;
            }
            String[] stringArray = uResourceBundle.get("dict").getStringArray();
            int[] intVector = uResourceBundle.get("data").getIntVector();
            int length = intVector.length;
            int length2 = stringArray.length + 1;
            this.fDict = new HashMap(length2);
            int length3 = stringArray.length;
            int i3 = 0;
            int i4 = 0;
            while (i3 < length3) {
                this.fDict.put(stringArray[i3], Integer.valueOf(i4));
                i3++;
                i4++;
            }
            int i5 = length2 * i;
            int i6 = i * 4 * i2;
            int i7 = i2 * 4;
            int i8 = i7 * i2;
            this.fEmbedding = LSTMBreakEngine.make2DArray(intVector, 0, length2, i);
            this.fForwardW = LSTMBreakEngine.make2DArray(intVector, i5, i, i7);
            int i9 = i5 + i6;
            this.fForwardU = LSTMBreakEngine.make2DArray(intVector, i9, i2, i7);
            int i10 = i9 + i8;
            this.fForwardB = LSTMBreakEngine.make1DArray(intVector, i10, i7);
            int i11 = i10 + i7;
            this.fBackwardW = LSTMBreakEngine.make2DArray(intVector, i11, i, i7);
            int i12 = i11 + i6;
            this.fBackwardU = LSTMBreakEngine.make2DArray(intVector, i12, i2, i7);
            int i13 = i12 + i8;
            this.fBackwardB = LSTMBreakEngine.make1DArray(intVector, i13, i7);
            int i14 = i13 + i7;
            this.fOutputW = LSTMBreakEngine.make2DArray(intVector, i14, i2 * 2, 4);
            this.fOutputB = LSTMBreakEngine.make1DArray(intVector, i14 + (i2 * 8), 4);
        }

        private LSTMData() {
        }
    }
}
