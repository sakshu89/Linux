package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ReflectedParcelable;
import defpackage.a4;
import defpackage.jg1;
import defpackage.mz3;
import defpackage.x1;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class GoogleSignInAccount extends x1 implements ReflectedParcelable {
    public static final Parcelable.Creator<GoogleSignInAccount> CREATOR = new a4(11);
    public final int a;
    public final String b;
    public final String c;
    public final String e;
    public final String f;
    public final Uri i;
    public String j;
    public final long k;
    public final String n;
    public final List s;
    public final String t;
    public final String u;
    public final HashSet v = new HashSet();

    public GoogleSignInAccount(int i, String str, String str2, String str3, String str4, Uri uri, String str5, long j, String str6, ArrayList arrayList, String str7, String str8) {
        this.a = i;
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.f = str4;
        this.i = uri;
        this.j = str5;
        this.k = j;
        this.n = str6;
        this.s = arrayList;
        this.t = str7;
        this.u = str8;
    }

    public static GoogleSignInAccount a(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        String strOptString = jSONObject.optString("photoUrl");
        Uri uri = !TextUtils.isEmpty(strOptString) ? Uri.parse(strOptString) : null;
        long j = Long.parseLong(jSONObject.getString("expirationTime"));
        HashSet hashSet = new HashSet();
        JSONArray jSONArray = jSONObject.getJSONArray("grantedScopes");
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            hashSet.add(new Scope(1, jSONArray.getString(i)));
        }
        String strOptString2 = jSONObject.optString("id");
        String strOptString3 = jSONObject.has("tokenId") ? jSONObject.optString("tokenId") : null;
        String strOptString4 = jSONObject.has("email") ? jSONObject.optString("email") : null;
        String strOptString5 = jSONObject.has("displayName") ? jSONObject.optString("displayName") : null;
        String strOptString6 = jSONObject.has("givenName") ? jSONObject.optString("givenName") : null;
        String strOptString7 = jSONObject.has("familyName") ? jSONObject.optString("familyName") : null;
        String string = jSONObject.getString("obfuscatedIdentifier");
        jg1.b(string);
        GoogleSignInAccount googleSignInAccount = new GoogleSignInAccount(3, strOptString2, strOptString3, strOptString4, strOptString5, uri, null, j, string, new ArrayList(hashSet), strOptString6, strOptString7);
        googleSignInAccount.j = jSONObject.has("serverAuthCode") ? jSONObject.optString("serverAuthCode") : null;
        return googleSignInAccount;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GoogleSignInAccount)) {
            return false;
        }
        GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) obj;
        if (!googleSignInAccount.n.equals(this.n)) {
            return false;
        }
        HashSet hashSet = new HashSet(googleSignInAccount.s);
        hashSet.addAll(googleSignInAccount.v);
        HashSet hashSet2 = new HashSet(this.s);
        hashSet2.addAll(this.v);
        return hashSet.equals(hashSet2);
    }

    public final int hashCode() {
        int iHashCode = this.n.hashCode() + 527;
        HashSet hashSet = new HashSet(this.s);
        hashSet.addAll(this.v);
        return (iHashCode * 31) + hashSet.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = mz3.e(parcel, 20293);
        mz3.g(parcel, 1, 4);
        parcel.writeInt(this.a);
        mz3.b(parcel, 2, this.b);
        mz3.b(parcel, 3, this.c);
        mz3.b(parcel, 4, this.e);
        mz3.b(parcel, 5, this.f);
        mz3.a(parcel, 6, this.i, i);
        mz3.b(parcel, 7, this.j);
        mz3.g(parcel, 8, 8);
        parcel.writeLong(this.k);
        mz3.b(parcel, 9, this.n);
        mz3.d(parcel, 10, this.s);
        mz3.b(parcel, 11, this.t);
        mz3.b(parcel, 12, this.u);
        mz3.f(parcel, iE);
    }
}
