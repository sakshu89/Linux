package defpackage;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.text.BreakIterator;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class ye {
    public final /* synthetic */ int a = 1;
    public int b;
    public int c;
    public Object d;
    public Object e;

    public ye(CharSequence charSequence, int i, Locale locale) {
        this.d = charSequence;
        if (charSequence.length() < 0) {
            a11.a("input start index is outside the CharSequence");
        }
        if (i < 0 || i > charSequence.length()) {
            a11.a("input end index is outside the CharSequence");
        }
        BreakIterator wordInstance = BreakIterator.getWordInstance(locale);
        this.e = wordInstance;
        this.b = Math.max(0, -50);
        this.c = Math.min(charSequence.length(), i + 50);
        wordInstance.setText(new ox(charSequence, i));
    }

    public void a(int i) {
        new Handler(Looper.getMainLooper()).post(new c7(this, i));
    }

    public void b(int i) {
        int i2 = this.b;
        int i3 = this.c;
        boolean z = false;
        if (i <= i3 && i2 <= i) {
            z = true;
        }
        if (z) {
            return;
        }
        StringBuilder sbP = cq.p("Invalid offset: ", i, ". Valid range is [", i2, " , ");
        sbP.append(i3);
        sbP.append(']');
        a11.a(sbP.toString());
    }

    public int c() {
        iz izVar = (iz) this.e;
        String str = (String) this.d;
        if (izVar == null) {
            return str.length();
        }
        return (izVar.b - izVar.b()) + (str.length() - (this.c - this.b));
    }

    public boolean d(int i) {
        CharSequence charSequence = (CharSequence) this.d;
        int i2 = this.b + 1;
        if (i > this.c || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointBefore(charSequence, i))) {
            int i3 = i - 1;
            if (!Character.isSurrogate(charSequence.charAt(i3))) {
                if (!oh0.d()) {
                    return false;
                }
                oh0 oh0VarA = oh0.a();
                if (oh0VarA.c() != 1 || oh0VarA.b(charSequence, i3) == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean e(int i) {
        int i2 = this.b + 1;
        if (i > this.c || i2 > i) {
            return false;
        }
        return wf4.b(Character.codePointBefore((CharSequence) this.d, i));
    }

    public boolean f(int i) {
        b(i);
        if (!((BreakIterator) this.e).isBoundary(i)) {
            return false;
        }
        if (h(i) && h(i - 1) && h(i + 1)) {
            return false;
        }
        return i <= 0 || i >= ((CharSequence) this.d).length() - 1 || !(g(i) || g(i + 1));
    }

    public boolean g(int i) {
        CharSequence charSequence = (CharSequence) this.d;
        int i2 = i - 1;
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(charSequence.charAt(i2));
        Character.UnicodeBlock unicodeBlock = Character.UnicodeBlock.HIRAGANA;
        if (g31.a(unicodeBlockOf, unicodeBlock) && g31.a(Character.UnicodeBlock.of(charSequence.charAt(i)), Character.UnicodeBlock.KATAKANA)) {
            return true;
        }
        return g31.a(Character.UnicodeBlock.of(charSequence.charAt(i)), unicodeBlock) && g31.a(Character.UnicodeBlock.of(charSequence.charAt(i2)), Character.UnicodeBlock.KATAKANA);
    }

    public boolean h(int i) {
        CharSequence charSequence = (CharSequence) this.d;
        int i2 = this.b;
        if (i >= this.c || i2 > i) {
            return false;
        }
        if (!Character.isLetterOrDigit(Character.codePointAt(charSequence, i)) && !Character.isSurrogate(charSequence.charAt(i))) {
            if (!oh0.d()) {
                return false;
            }
            oh0 oh0VarA = oh0.a();
            if (oh0VarA.c() != 1 || oh0VarA.b(charSequence, i) == -1) {
                return false;
            }
        }
        return true;
    }

    public boolean i(int i) {
        int i2 = this.b;
        if (i >= this.c || i2 > i) {
            return false;
        }
        return wf4.b(Character.codePointAt((CharSequence) this.d, i));
    }

    public int j(int i) {
        b(i);
        int iFollowing = ((BreakIterator) this.e).following(i);
        return (h(iFollowing + (-1)) && h(iFollowing) && !g(iFollowing)) ? j(iFollowing) : iFollowing;
    }

    public void k(Typeface typeface) {
        int i;
        if (Build.VERSION.SDK_INT >= 28 && (i = this.b) != -1) {
            typeface = df.a(typeface, i, (this.c & 2) != 0);
        }
        ef efVar = (ef) this.e;
        WeakReference weakReference = (WeakReference) this.d;
        if (efVar.m) {
            efVar.l = typeface;
            TextView textView = (TextView) weakReference.get();
            if (textView != null) {
                int i2 = u73.a;
                boolean zIsAttachedToWindow = textView.isAttachedToWindow();
                int i3 = efVar.j;
                if (zIsAttachedToWindow) {
                    textView.post(new ze(textView, typeface, i3));
                } else {
                    textView.setTypeface(typeface, i3);
                }
            }
        }
    }

    public int l(int i) {
        b(i);
        int iPreceding = ((BreakIterator) this.e).preceding(i);
        return (h(iPreceding) && d(iPreceding) && !g(iPreceding)) ? l(iPreceding) : iPreceding;
    }

    public void m(int i, int i2, String str) {
        if (i > i2) {
            a11.a("start index must be less than or equal to end index: " + i + " > " + i2);
        }
        if (i < 0) {
            a11.a("start must be non-negative, but was " + i);
        }
        iz izVar = (iz) this.e;
        if (izVar == null) {
            int iMax = Math.max(255, str.length() + 128);
            char[] cArr = new char[iMax];
            int iMin = Math.min(i, 64);
            int iMin2 = Math.min(((String) this.d).length() - i2, 64);
            String str2 = (String) this.d;
            int i3 = i - iMin;
            str2.getClass();
            str2.getChars(i3, i, cArr, 0);
            String str3 = (String) this.d;
            int i4 = iMax - iMin2;
            int i5 = iMin2 + i2;
            str3.getClass();
            str3.getChars(i2, i5, cArr, i4);
            str.getChars(0, str.length(), cArr, iMin);
            int length = str.length() + iMin;
            iz izVar2 = new iz();
            izVar2.b = iMax;
            izVar2.e = cArr;
            izVar2.c = length;
            izVar2.d = i4;
            this.e = izVar2;
            this.b = i3;
            this.c = i5;
            return;
        }
        int i6 = this.b;
        int i7 = i - i6;
        int i8 = i2 - i6;
        if (i7 < 0 || i8 > izVar.b - izVar.b()) {
            this.d = toString();
            this.e = null;
            this.b = -1;
            this.c = -1;
            m(i, i2, str);
            return;
        }
        int length2 = str.length() - (i8 - i7);
        if (length2 > izVar.b()) {
            int iB = length2 - izVar.b();
            int i9 = izVar.b;
            do {
                i9 *= 2;
            } while (i9 - izVar.b < iB);
            char[] cArr2 = new char[i9];
            System.arraycopy((char[]) izVar.e, 0, cArr2, 0, izVar.c);
            int i10 = izVar.b;
            int i11 = izVar.d;
            int i12 = i10 - i11;
            int i13 = i9 - i12;
            System.arraycopy((char[]) izVar.e, i11, cArr2, i13, (i12 + i11) - i11);
            izVar.e = cArr2;
            izVar.b = i9;
            izVar.d = i13;
        }
        int i14 = izVar.c;
        if (i7 < i14 && i8 <= i14) {
            int i15 = i14 - i8;
            char[] cArr3 = (char[]) izVar.e;
            System.arraycopy(cArr3, i8, cArr3, izVar.d - i15, i15);
            izVar.c = i7;
            izVar.d -= i15;
        } else if (i7 >= i14 || i8 < i14) {
            int iB2 = izVar.b() + i7;
            int iB3 = izVar.b() + i8;
            int i16 = izVar.d;
            int i17 = iB2 - i16;
            char[] cArr4 = (char[]) izVar.e;
            System.arraycopy(cArr4, i16, cArr4, izVar.c, i17);
            izVar.c += i17;
            izVar.d = iB3;
        } else {
            izVar.d = izVar.b() + i8;
            izVar.c = i7;
        }
        str.getChars(0, str.length(), (char[]) izVar.e, izVar.c);
        izVar.c = str.length() + izVar.c;
    }

    public String toString() {
        switch (this.a) {
            case 1:
                iz izVar = (iz) this.e;
                String str = (String) this.d;
                if (izVar == null) {
                    return str;
                }
                StringBuilder sb = new StringBuilder();
                sb.append((CharSequence) str, 0, this.b);
                sb.append((char[]) izVar.e, 0, izVar.c);
                char[] cArr = (char[]) izVar.e;
                int i = izVar.d;
                sb.append(cArr, i, izVar.b - i);
                String str2 = (String) this.d;
                sb.append((CharSequence) str2, this.c, str2.length());
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public /* synthetic */ ye() {
    }

    public ye(ef efVar, int i, int i2, WeakReference weakReference) {
        this.e = efVar;
        this.b = i;
        this.c = i2;
        this.d = weakReference;
    }
}
