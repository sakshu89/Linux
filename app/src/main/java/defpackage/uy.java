package defpackage;

import android.accessibilityservice.AccessibilityService;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.provider.ContactsContract;
import com.ibm.icu.impl.number.Padder;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class uy implements bl2 {
    public final /* synthetic */ int a = 1;
    public final Set b;
    public final l82 c;
    public final Object d;
    public final Object e;

    public uy(ii1 ii1Var, nb2 nb2Var) {
        ii1Var.getClass();
        nb2Var.getClass();
        this.d = ii1Var;
        this.e = nb2Var;
        this.b = wh2.c(new w3("media.play"), new w3("media.pause"), new w3("media.resume"), new w3("media.next"), new w3("media.previous"), new w3("media.stop"), new w3("media.identify"), new w3("youtube.mini_player.close"));
        this.c = l82.a;
    }

    public static String B(String str) {
        StringBuilder sb = new StringBuilder();
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (Character.isDigit(cCharAt) || cCharAt == '+') {
                sb.append(cCharAt);
            }
        }
        String string = sb.toString();
        if (string.length() < 6) {
            return str;
        }
        c44.a(3, 3);
        int length2 = string.length();
        ArrayList arrayList = new ArrayList((length2 / 3) + (length2 % 3 == 0 ? 0 : 1));
        while (i >= 0 && i < length2) {
            int i3 = i + 3;
            CharSequence charSequenceSubSequence = string.subSequence(i, (i3 < 0 || i3 > length2) ? length2 : i3);
            charSequenceSubSequence.getClass();
            arrayList.add(charSequenceSubSequence.toString());
            i = i3;
        }
        return mz.C(arrayList, Padder.FALLBACK_PADDING_STRING, null, null, null, 62);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:191:0x0371  */
    /* JADX WARN: Code duplicated, block: B:225:0x040b  */
    /* JADX WARN: Code duplicated, block: B:25:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:7:0x0021  */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x0189, code lost:
    
        if (r12.equals("youtube") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0194, code lost:
    
        if (r12.equals("spotify") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a0, code lost:
    
        if (r12.equals("com.google.android.youtube") == false) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01b8, code lost:
    
        r1 = "com.google.android.youtube";
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object n(defpackage.uy r29, defpackage.f5 r30, defpackage.cl2 r31, defpackage.y50 r32) {
        /*
            Method dump skipped, instruction units count: 1522
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.uy.n(uy, f5, cl2, y50):java.lang.Object");
    }

    public jl2 A(String str, String str2, String str3) {
        t61 t61VarA = ((n21) this.d).a(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0").buildUpon().appendQueryParameter("q", n61.a.d(str)).build()), str2);
        if (t61VarA instanceof p61) {
            p61 p61Var = (p61) t61VarA;
            String str4 = p61Var.b;
            if (str4 == null) {
                str4 = p61Var.a;
            }
            return new hl2(str2, str3, new c73(cq.v("SONIC handed the query to ", str4, ", which resolves it internally")), null, false, 24);
        }
        if (t61VarA instanceof q61) {
            return new fl2("There's no maps app on this phone.", "no activity resolved for the geo: scheme", null, true, 4);
        }
        if (t61VarA instanceof r61) {
            return new fl2("Android wouldn't let me open the map just now.", "startActivity refused: ".concat(((r61) t61VarA).a), null, false, 12);
        }
        if (t61VarA instanceof s61) {
            return new fl2("I didn't open that.", "rejected by IntentLauncher validation: ".concat(((s61) t61VarA).a), null, false, 4);
        }
        if (t61VarA instanceof o61) {
            return new fl2("I couldn't open the map.", ((o61) t61VarA).a, null, false, 12);
        }
        dk0.l();
        return null;
    }

    @Override // defpackage.bl2
    public final Object a(f5 f5Var, x50 x50Var) {
        int i = this.a;
        Object obj = this.d;
        switch (i) {
            case 0:
            case 1:
                return null;
            case 2:
                return ((r2) obj).l() ? new d73("keyguard state, via KeyguardManager.isKeyguardLocked", "lock screen is up") : new b73("keyguard state, via KeyguardManager.isKeyguardLocked", "locked", "still unlocked");
            case 3:
            case 4:
                return null;
            default:
                i93 i93VarE = ((c93) obj).e();
                Integer numB = f5Var.b("level_percent");
                String str = f5Var.a;
                if (g31.a(str, "device.volume.set") && numB != null) {
                    int i2 = i93VarE.b;
                    if (Math.abs(i93VarE.b() - numB.intValue()) > (i2 > 0 ? 1 + (100 / i2) : 1)) {
                        return new b73("media stream level", numB + "%", i93VarE.a());
                    }
                }
                return (!g31.a(str, "device.volume.mute") || i93VarE.c) ? new d73("media stream level", i93VarE.a()) : new b73("media stream mute state", "muted", i93VarE.a());
        }
    }

    @Override // defpackage.bl2
    public final Set b() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return this.b;
    }

    @Override // defpackage.bl2
    public final String d() {
        switch (this.a) {
            case 0:
                return "util.clipboard";
            case 1:
                return "contact.find";
            case 2:
                return "device.lock";
            case 3:
                return "maps.navigate";
            case 4:
                return "media.control";
            default:
                return "device.volume";
        }
    }

    @Override // defpackage.bl2
    public final String e() {
        switch (this.a) {
            case 0:
                return "Copies text to the clipboard so you can paste it anywhere.";
            case 1:
                return "Looks up someone's number in your contacts.";
            case 2:
                return "Locks the screen, and confirms the lock screen actually came up.";
            case 3:
                return "Starts directions, finds places nearby, or shows where you are.";
            case 4:
                return "Pauses, resumes and skips whatever is playing, in any music or video app.";
            default:
                return "Sets, raises, lowers or mutes the media volume.";
        }
    }

    @Override // defpackage.bl2
    public final void f() {
        int i = this.a;
    }

    @Override // defpackage.bl2
    public final void g() {
        int i = this.a;
    }

    /* JADX WARN: Code duplicated, block: B:124:0x038c  */
    /* JADX WARN: Code duplicated, block: B:242:0x06d2  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0, types: [x50] */
    /* JADX WARN: Type inference failed for: r10v36 */
    /* JADX WARN: Type inference failed for: r10v37 */
    /* JADX WARN: Type inference failed for: r10v38 */
    /* JADX WARN: Type inference failed for: r10v9 */
    @Override // defpackage.bl2
    public final Object h(f5 f5Var, cl2 cl2Var, x50 x50Var) throws Throwable {
        qy qyVar;
        Object pyVar;
        String string;
        ClipData.Item itemAt;
        CharSequence charSequenceCoerceToText;
        Object fl2Var;
        t40 t40Var;
        String str;
        fl2 fl2Var2;
        String str2;
        AccessibilityService accessibilityServiceI;
        Object fl2Var3;
        h93 h93VarC;
        Object el2Var;
        String strH;
        int i = this.a;
        boolean z = true;
        Object obj = this.d;
        String str3 = 0;
        str3 = 0;
        str3 = 0;
        str3 = 0;
        switch (i) {
            case 0:
                String strC = f5Var.c("text");
                if (strC == null && (strC = cl2Var.f.h) == null) {
                    return new fl2("What would you like me to copy?", "COPY_TO_CLIPBOARD with no text", null, false, 12);
                }
                String strD = n61.a.d(strC);
                Context context = ((vy) obj).a;
                if (strD.length() == 0) {
                    pyVar = new qy("there was nothing to copy");
                } else {
                    ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(ClipboardManager.class);
                    if (clipboardManager == null) {
                        pyVar = new qy("this device has no clipboard service");
                    } else {
                        try {
                            clipboardManager.setPrimaryClip(ClipData.newPlainText("SONIC", strD));
                            if (Build.VERSION.SDK_INT >= 29) {
                                pyVar = new ry(strD.length(), "Android hides clipboard contents from apps that aren't in the foreground, so I can't read it back to check");
                            } else {
                                ClipData primaryClip = clipboardManager.getPrimaryClip();
                                if (primaryClip == null) {
                                    string = null;
                                } else {
                                    if (primaryClip.getItemCount() <= 0) {
                                        primaryClip = null;
                                    }
                                    if (primaryClip == null || (itemAt = primaryClip.getItemAt(0)) == null || (charSequenceCoerceToText = itemAt.coerceToText(context)) == null) {
                                        string = null;
                                    } else {
                                        string = charSequenceCoerceToText.toString();
                                    }
                                }
                                pyVar = g31.a(string, strD) ? new py(strD.length()) : new ry(strD.length(), "the clipboard didn't read back what I put on it");
                            }
                        } catch (IllegalStateException e) {
                            String message = e.getMessage();
                            if (message == null) {
                                message = "the clipboard rejected the text";
                            }
                            qyVar = new qy(message);
                            pyVar = qyVar;
                        } catch (SecurityException e2) {
                            String message2 = e2.getMessage();
                            if (message2 == null) {
                                message2 = "Android blocked the clipboard write";
                            }
                            qyVar = new qy(message2);
                            pyVar = qyVar;
                        }
                    }
                }
                if (!(pyVar instanceof py)) {
                    if (pyVar instanceof ry) {
                        ry ryVar = (ry) pyVar;
                        StringBuilder sb = new StringBuilder();
                        sb.append(ryVar.a);
                        sb.append(" characters written via setPrimaryClip; ");
                        String str4 = ryVar.b;
                        sb.append(str4);
                        fl2Var = new hl2("Copied.", str4, new c73(sb.toString()), null, false, 24);
                    } else {
                        if (!(pyVar instanceof qy)) {
                            dk0.l();
                            return null;
                        }
                        fl2Var = new fl2("I couldn't copy that.", ((qy) pyVar).a, null, false, 12);
                    }
                    return fl2Var;
                }
                d73 d73Var = new d73("read the clipboard back after writing", ((py) pyVar).a + " characters, matching what was written");
                Pattern patternCompile = Pattern.compile("\\s+");
                patternCompile.getClass();
                String strReplaceAll = patternCompile.matcher(strD).replaceAll(Padder.FALLBACK_PADDING_STRING);
                strReplaceAll.getClass();
                String string2 = cs2.V(strReplaceAll).toString();
                return new il2("Copied.", d73Var, null, string2.length() <= 60 ? cq.v("\"", string2, "\"") : "\"" + cs2.T(60, string2) + "…\" (" + strD.length() + " characters)", 4);
            case 1:
                if (x50Var instanceof t40) {
                    t40Var = (t40) x50Var;
                    int i2 = t40Var.j;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        t40Var.j = i2 - Integer.MIN_VALUE;
                    } else {
                        t40Var = new t40(this, (y50) x50Var);
                    }
                } else {
                    t40Var = new t40(this, (y50) x50Var);
                }
                Object objD = t40Var.f;
                int i3 = t40Var.j;
                if (i3 == 0) {
                    bz3.g(objD);
                    String strC2 = f5Var.c("phone_number");
                    if (strC2 != null) {
                        b50 b50Var = (b50) obj;
                        if (!b50Var.b.c("android.permission.READ_CONTACTS")) {
                            return new el2("I need access to your contacts for that.", new z22(nz.h("android.permission.READ_CONTACTS")), new e52(nz.h("android.permission.READ_CONTACTS"), "Allow contact access"));
                        }
                        if (b50Var.b.c("android.permission.READ_CONTACTS")) {
                            ArrayList arrayList = new ArrayList(strC2.length());
                            for (int i4 = 0; i4 < strC2.length(); i4++) {
                                char cCharAt = strC2.charAt(i4);
                                if (2406 <= cCharAt && cCharAt < 2416) {
                                    cCharAt = (char) (cCharAt - 2358);
                                }
                                arrayList.add(Character.valueOf(cCharAt));
                            }
                            ArrayList arrayList2 = new ArrayList();
                            int size = arrayList.size();
                            int i5 = 0;
                            while (i5 < size) {
                                Object obj2 = arrayList.get(i5);
                                i5++;
                                char cCharValue = ((Character) obj2).charValue();
                                if (Character.isDigit(cCharValue) || cCharValue == '+' || cCharValue == '*' || cCharValue == '#') {
                                    arrayList2.add(obj2);
                                }
                            }
                            String strC3 = mz.C(arrayList2, "", null, null, null, 62);
                            if (strC3.length() != 0) {
                                Uri uriWithAppendedPath = Uri.withAppendedPath(ContactsContract.PhoneLookup.CONTENT_FILTER_URI, Uri.encode(strC3));
                                uriWithAppendedPath.getClass();
                                try {
                                    Cursor cursorQuery = b50Var.a.getContentResolver().query(uriWithAppendedPath, new String[]{"display_name"}, null, null, null);
                                    if (cursorQuery != null) {
                                        try {
                                            String string3 = cursorQuery.moveToFirst() ? cursorQuery.getString(0) : null;
                                            cursorQuery.close();
                                            str3 = string3;
                                            break;
                                        } catch (Throwable th) {
                                            try {
                                                throw th;
                                            } catch (Throwable th2) {
                                                fi4.a(cursorQuery, th);
                                                throw th2;
                                            }
                                        }
                                    }
                                } catch (IllegalArgumentException | SecurityException unused) {
                                }
                            }
                        }
                        return str3 == 0 ? new il2("That number isn't in your contacts.", new d73("PhoneLookup.CONTENT_FILTER_URI", "no row for the given number"), null, null, 12) : new il2(cq.v("That's ", str3, "."), new d73("PhoneLookup.CONTENT_FILTER_URI", cq.v("resolved to \"", str3, "\"")), null, cq.k(str3, "\n", strC2), 4);
                    }
                    String strC4 = f5Var.c("contact_name");
                    if (strC4 == null) {
                        str = cl2Var.f.c;
                        if (str == null) {
                            return new fl2("Whose number would you like?", "FIND_CONTACT with no contact_name", null, false, 12);
                        }
                    } else {
                        str = strC4;
                    }
                    xa0 xa0Var = ld0.a;
                    qa0 qa0Var = qa0.c;
                    y yVar = new y(this, str, str3, 8);
                    t40Var.e = str;
                    t40Var.j = 1;
                    objD = uf4.d(qa0Var, yVar, t40Var);
                    t70 t70Var = t70.a;
                    if (objD == t70Var) {
                        return t70Var;
                    }
                } else {
                    if (i3 != 1) {
                        og.n("call to 'resume' before 'invoke' with coroutine");
                        return null;
                    }
                    str = t40Var.e;
                    bz3.g(objD);
                }
                z40 z40Var = (z40) objD;
                if (z40Var instanceof y40) {
                    y40 y40Var = (y40) z40Var;
                    uw1 uw1Var = y40Var.a;
                    String str5 = uw1Var.b;
                    String str6 = uw1Var.d;
                    String str7 = uw1Var.c;
                    String strB = B(str7);
                    if (cs2.A(str6)) {
                        str2 = "";
                    } else {
                        String lowerCase = str6.toLowerCase(Locale.ROOT);
                        lowerCase.getClass();
                        str2 = " That's the " + lowerCase + ".";
                    }
                    return new il2(str5 + ": " + strB + "." + str2, new d73("ContactsContract phone lookup", "matched by ".concat(y40Var.b)), null, cq.k(uw1Var.a(), "\n", str7), 4);
                }
                if (!(z40Var instanceof u40)) {
                    if (z40Var instanceof w40) {
                        String str8 = ((w40) z40Var).a;
                        fl2Var2 = new fl2(cq.v("I don't have anyone called \"", str8, "\"."), cq.v("no contact matched \"", str8, "\""), null, false, 4);
                    } else {
                        if (!(z40Var instanceof v40)) {
                            if (g31.a(z40Var, x40.a)) {
                                return new el2("I need access to your contacts for that.", new z22(nz.h("android.permission.READ_CONTACTS")), new e52(nz.h("android.permission.READ_CONTACTS"), "Allow contact access"));
                            }
                            dk0.l();
                            return null;
                        }
                        fl2Var2 = new fl2(cq.v("Your contacts aren't responding yet, so I couldn't check ", str, "."), "Contact provider unavailable after fresh lookup retries", null, true, 4);
                    }
                    return fl2Var2;
                }
                u40 u40Var = (u40) z40Var;
                List list = u40Var.b;
                return new il2("I found " + list.size() + ": " + mz.C(list, "; ", null, null, new j(this), 30) + ".", new d73("ContactsContract phone lookup", list.size() + " matches for \"" + u40Var.a + "\""), null, mz.C(list, "\n", null, null, new j(19), 30), 4);
            case 2:
                r2 r2Var = (r2) obj;
                if (r2Var.l()) {
                    return new il2("It's already locked.", new d73("keyguard state, via KeyguardManager.isKeyguardLocked", "already locked"), null, null, 12);
                }
                return (Build.VERSION.SDK_INT < 28 || (accessibilityServiceI = r2Var.i()) == null || !accessibilityServiceI.performGlobalAction(8)) ? new fl2("I couldn't lock the screen.", "performGlobalAction(GLOBAL_ACTION_LOCK_SCREEN) was refused, or the device is below API 28 where the action does not exist", null, false, 4) : new hl2("Locking the screen.", "I'll confirm once the lock screen is up", new c73("the keyguard has not appeared yet at the moment execute returned"), null, false, 24);
            case 3:
                n21 n21Var = (n21) obj;
                String str9 = f5Var.a;
                if (!g31.a(str9, "maps.whereami")) {
                    if (g31.a(str9, "maps.nearby")) {
                        String strC5 = f5Var.c("place");
                        return (strC5 == null && (strC5 = f5Var.c("query")) == null && (strC5 = cl2Var.f.g) == null) ? new fl2("What should I look for nearby?", "FIND_NEARBY with no place", null, false, 12) : A(strC5, cq.v("Looking for ", strC5, " near you."), "I can't read the results — they're in the maps app");
                    }
                    String strC6 = f5Var.c("place");
                    if (strC6 == null && (strC6 = cl2Var.f.g) == null) {
                        return new fl2("Where would you like to go?", "NAVIGATE_TO with no place", null, false, 12);
                    }
                    Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("google.navigation:q=" + Uri.encode(n61.a.d(strC6))));
                    return (n21Var.b(intent) == null || !(n21Var.a(intent, "directions to ".concat(strC6)) instanceof p61)) ? A(strC6, cq.v("Here's ", strC6, " on the map."), "your maps app doesn't support starting directions from another app, so I could only show you the place") : new hl2(cq.v("Starting directions to ", strC6, "."), "I can't tell whether it found the right place — have a look before you set off", new c73("the maps app resolves the destination internally and reports nothing back to SONIC"), null, false, 24);
                }
                t61 t61VarA = n21Var.a(new Intent("android.intent.action.VIEW", Uri.parse("geo:0,0")), "the map");
                if (t61VarA instanceof p61) {
                    fl2Var3 = new hl2("Here's the map, centred on you.", "I can't read your address out — I don't have location access, and I'd rather not ask for it just to do that", new c73("SONIC has no location permission by design; the maps app supplies the position and does not report it back"), null, false, 24);
                } else if (t61VarA instanceof q61) {
                    fl2Var3 = new fl2("There's no maps app on this phone.", "no activity resolved for the geo: scheme", null, true, 4);
                } else if (t61VarA instanceof r61) {
                    fl2Var3 = new fl2("Android wouldn't let me open the map just now.", "startActivity refused: ".concat(((r61) t61VarA).a), null, false, 12);
                } else if (t61VarA instanceof s61) {
                    fl2Var3 = new fl2("I didn't open that.", "rejected by IntentLauncher validation: ".concat(((s61) t61VarA).a), null, false, 4);
                } else {
                    if (!(t61VarA instanceof o61)) {
                        dk0.l();
                        return null;
                    }
                    fl2Var3 = new fl2("I couldn't open the map.", ((o61) t61VarA).a, null, false, 12);
                }
                return fl2Var3;
            case 4:
                return uf4.d(ld0.a, new r0(this, f5Var, cl2Var, null, 12), x50Var);
            default:
                c93 c93Var = (c93) obj;
                i93 i93VarE = c93Var.e();
                int i6 = i93VarE.b;
                boolean z2 = i93VarE.c;
                String str10 = f5Var.a;
                if (g31.a(str10, "device.volume.set")) {
                    Integer numB = f5Var.b("level_percent");
                    if (numB == null) {
                        return new fl2("What volume would you like? Say a number between 0 and 100.", "SET_VOLUME with no level_percent slot", null, false, 12);
                    }
                    int iIntValue = numB.intValue();
                    AudioManager audioManager = c93Var.b;
                    if (audioManager == null) {
                        h93VarC = new g93("no audio service on this device");
                    } else if (audioManager.isVolumeFixed()) {
                        h93VarC = new g93("this device doesn't let apps change the volume");
                    } else {
                        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
                        int iC = ky3.c(hh1.f((ky3.c(iIntValue, 0, 100) * streamMaxVolume) / 100.0f), 0, streamMaxVolume);
                        try {
                            i93 i93VarE2 = c93Var.e();
                            audioManager.setStreamVolume(3, iC, 1);
                            if (iC <= i93VarE2.a) {
                                z = false;
                            }
                            h93VarC = c93Var.a(i93VarE2, iC, z);
                        } catch (SecurityException e3) {
                            h93VarC = c93Var.b(e3);
                        }
                    }
                    break;
                } else if (g31.a(str10, "device.volume.up")) {
                    if (z2) {
                        c93.d(c93Var, false);
                    }
                    h93VarC = c93.c(c93Var, true);
                } else {
                    h93VarC = g31.a(str10, "device.volume.down") ? c93.c(c93Var, false) : c93.d(c93Var, true);
                }
                if (h93VarC instanceof e93) {
                    String str11 = f5Var.a;
                    i93 i93Var = ((e93) h93VarC).a;
                    if (g31.a(str11, "device.volume.mute")) {
                        strH = "Muted.";
                    } else if (i93Var.c) {
                        strH = cq.h("Volume is at ", i93Var.b(), " percent, but the media stream is muted.");
                    } else {
                        int i7 = i93Var.a;
                        strH = i7 >= i93Var.b ? cq.h("That's as loud as it goes — ", i93Var.b(), " percent.") : i7 == 0 ? "Volume is all the way down." : cq.h("Volume is at ", i93Var.b(), " percent.");
                    }
                    el2Var = new il2(strH, new d73("AudioManager media stream level, read back after the change", i93Var.a()), i6 > 0 ? new n43(bh1.c(new wt1("previous_step", String.valueOf(i93VarE.a)), new wt1("previous_max", String.valueOf(i6)), new wt1("previous_muted", String.valueOf(z2))), "device.volume", cq.h("put the volume back to ", i93VarE.b(), " percent")) : null, "Media volume ".concat(i93Var.a()));
                } else {
                    if (h93VarC instanceof f93) {
                        f93 f93Var = (f93) h93VarC;
                        return new fl2("I tried, but the volume didn't move. Something else is holding it.", "requested step " + f93Var.a + ", read back " + f93Var.b.a(), null, false, 12);
                    }
                    if (!h93VarC.equals(d93.a)) {
                        if (h93VarC instanceof g93) {
                            return new fl2("This device doesn't let me change the volume.", ((g93) h93VarC).a, null, false, 4);
                        }
                        dk0.l();
                        return null;
                    }
                    ((zv1) this.e).getClass();
                    f52 f52VarD = zv1.d(np2.e);
                    el2Var = new el2("Do Not Disturb is on, and Android blocks volume changes from apps that don't have permission to work around it.", new c32("Do Not Disturb is active and SONIC lacks notification policy access", f52VarD), f52VarD);
                }
                return el2Var;
        }
    }

    /* JADX WARN: Code duplicated, block: B:20:0x0056  */
    @Override // defpackage.bl2
    public final Object i(y50 y50Var) {
        ve1 ve1Var;
        c32 c32Var;
        int i = this.a;
        Object obj = this.d;
        a32 a32Var = a32.a;
        switch (i) {
            case 0:
                return a32Var;
            case 1:
                return ((b50) obj).b.c("android.permission.READ_CONTACTS") ? a32Var : new z22(nz.h("android.permission.READ_CONTACTS"));
            case 2:
                r2 r2Var = (r2) obj;
                zv1 zv1Var = (zv1) this.e;
                if (y50Var instanceof ve1) {
                    ve1Var = (ve1) y50Var;
                    int i2 = ve1Var.i;
                    if ((i2 & Integer.MIN_VALUE) != 0) {
                        ve1Var.i = i2 - Integer.MIN_VALUE;
                    } else {
                        ve1Var = new ve1(this, y50Var);
                    }
                } else {
                    ve1Var = new ve1(this, y50Var);
                }
                Object objE = ve1Var.e;
                int i3 = ve1Var.i;
                if (i3 == 0) {
                    bz3.g(objE);
                    r2Var.getClass();
                    if (Build.VERSION.SDK_INT >= 28) {
                        np2 np2Var = np2.c;
                        if (!zv1Var.b(np2Var)) {
                            return new c32("SONIC needs Android's accessibility access to lock the screen", zv1.d(np2Var));
                        }
                        ve1Var.i = 1;
                        objE = r2Var.e(2000L, ve1Var);
                        t70 t70Var = t70.a;
                        if (objE == t70Var) {
                            return t70Var;
                        }
                    } else {
                        c32Var = new c32("Locking the screen requires Android 9 or newer", null);
                    }
                    return c32Var;
                }
                if (i3 != 1) {
                    og.n("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                bz3.g(objE);
                if (((Boolean) objE).booleanValue()) {
                    return a32Var;
                }
                c32Var = new c32("SONIC's screen service is still starting up", null);
                return c32Var;
            case 3:
                return a32Var;
            case 4:
                ii1 ii1Var = (ii1) obj;
                if (ii1Var.b.a()) {
                    return a32Var;
                }
                ii1Var.b.getClass();
                return new c32("Android only lets SONIC see other apps' playback if it's switched on in notification access", zv1.d(np2.b));
            default:
                AudioManager audioManager = ((c93) obj).b;
                return (audioManager == null || !audioManager.isVolumeFixed()) ? a32Var : new c32("this output doesn't let apps change the volume", null);
        }
    }

    @Override // defpackage.bl2
    public final String j(f5 f5Var) {
        switch (this.a) {
            case 0:
                return null;
            case 1:
                return null;
            case 2:
                return "Lock the screen?";
            case 3:
                return null;
            case 4:
                return null;
            default:
                return null;
        }
    }

    @Override // defpackage.bl2
    public final List k() {
        int i = this.a;
        Object obj = this.e;
        ii0 ii0Var = ii0.a;
        switch (i) {
            case 0:
                return (ii0) obj;
            case 1:
                return (List) obj;
            case 2:
                return ii0Var;
            case 3:
                return (ii0) obj;
            case 4:
            default:
                return ii0Var;
        }
    }

    @Override // defpackage.bl2
    public final l82 l() {
        switch (this.a) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
        return this.c;
    }

    @Override // defpackage.bl2
    public final String m() {
        switch (this.a) {
            case 0:
                return "Clipboard";
            case 1:
                return "Contact lookup";
            case 2:
                return "Lock screen";
            case 3:
                return "Maps";
            case 4:
                return "Playback control";
            default:
                return "Volume";
        }
    }

    private final void o() {
    }

    private final void p() {
    }

    private final void q() {
    }

    private final void r() {
    }

    private final void s() {
    }

    private final void t() {
    }

    private final void u() {
    }

    private final void v() {
    }

    private final void w() {
    }

    private final void x() {
    }

    private final void y() {
    }

    private final void z() {
    }

    public uy(b50 b50Var) {
        b50Var.getClass();
        this.d = b50Var;
        this.b = wh2.b(new w3("contact.find"));
        this.e = nz.h("android.permission.READ_CONTACTS");
        this.c = l82.b;
    }

    public uy(c93 c93Var, zv1 zv1Var) {
        c93Var.getClass();
        zv1Var.getClass();
        this.d = c93Var;
        this.e = zv1Var;
        this.b = wh2.c(new w3("device.volume.set"), new w3("device.volume.up"), new w3("device.volume.down"), new w3("device.volume.mute"));
        this.c = l82.a;
    }

    public uy(vy vyVar) {
        vyVar.getClass();
        this.d = vyVar;
        this.b = wh2.b(new w3("util.clipboard.copy"));
        this.e = ii0.a;
        this.c = l82.a;
    }

    public uy(r2 r2Var, zv1 zv1Var) {
        r2Var.getClass();
        zv1Var.getClass();
        this.d = r2Var;
        this.e = zv1Var;
        this.b = wh2.b(new w3("device.lock"));
        this.c = l82.b;
    }

    public uy(n21 n21Var) {
        n21Var.getClass();
        this.d = n21Var;
        this.b = wh2.c(new w3("maps.navigate"), new w3("maps.nearby"), new w3("maps.whereami"));
        this.e = ii0.a;
        this.c = l82.b;
    }
}
