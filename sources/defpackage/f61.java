package defpackage;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import java.io.OutputStream;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class f61 extends nu2 implements vq0 {
    public final /* synthetic */ int f;
    public /* synthetic */ Object i;
    public final /* synthetic */ Object j;
    public final /* synthetic */ Object k;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f61(u93 u93Var, Uri uri, String str, x50 x50Var) {
        super(2, x50Var);
        this.f = 3;
        this.i = u93Var;
        this.j = uri;
        this.k = str;
    }

    @Override // defpackage.vq0
    public final Object e(Object obj, Object obj2) {
        int i = this.f;
        q43 q43Var = q43.a;
        switch (i) {
            case 0:
                ((f61) q((x50) obj2, (dm1) obj)).s(q43Var);
                return q43Var;
            case 1:
                return ((f61) q((x50) obj2, (s70) obj)).s(q43Var);
            case 2:
                return ((f61) q((x50) obj2, (s70) obj)).s(q43Var);
            default:
                return ((f61) q((x50) obj2, (s70) obj)).s(q43Var);
        }
    }

    @Override // defpackage.pk
    public final x50 q(x50 x50Var, Object obj) {
        int i = this.f;
        Object obj2 = this.k;
        Object obj3 = this.j;
        switch (i) {
            case 0:
                f61 f61Var = new f61((h61) obj3, (String) obj2, x50Var, 0);
                f61Var.i = obj;
                return f61Var;
            case 1:
                f61 f61Var2 = new f61((ry1) obj3, (wx2) obj2, x50Var, 1);
                f61Var2.i = obj;
                return f61Var2;
            case 2:
                f61 f61Var3 = new f61((dd2) obj3, (Bitmap) obj2, x50Var, 2);
                f61Var3.i = obj;
                return f61Var3;
            default:
                return new f61((u93) this.i, (Uri) obj3, (String) obj2, x50Var);
        }
    }

    @Override // defpackage.pk
    public final Object s(Object obj) {
        long j;
        int i = this.f;
        int i2 = 1;
        x50 x50Var = null;
        Object obj2 = this.j;
        Object obj3 = this.k;
        switch (i) {
            case 0:
                dm1 dm1Var = (dm1) this.i;
                bz3.g(obj);
                String str = (String) obj3;
                str.getClass();
                dm1Var.d(new iz1(str));
                return q43.a;
            case 1:
                bz3.g(obj);
                s70 s70Var = (s70) this.i;
                ry1 ry1Var = (ry1) obj2;
                wx2 wx2Var = (wx2) obj3;
                uf4.b(s70Var, null, new y60(ry1Var, wx2Var, x50Var, i2), 1);
                return uf4.b(s70Var, null, new y60(ry1Var, wx2Var, x50Var, 2), 1);
            case 2:
                bz3.g(obj);
                ContentResolver contentResolver = ((dd2) obj2).a.getContentResolver();
                String str2 = "sonic_" + System.currentTimeMillis() + ".png";
                ContentValues contentValues = new ContentValues();
                contentValues.put("_display_name", str2);
                contentValues.put("mime_type", "image/png");
                int i3 = Build.VERSION.SDK_INT;
                if (i3 >= 29) {
                    contentValues.put("relative_path", "Pictures/Screenshots");
                    contentValues.put("is_pending", new Integer(1));
                }
                Uri uriInsert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                try {
                    if (uriInsert == null) {
                        return null;
                    }
                    try {
                        OutputStream outputStreamOpenOutputStream = contentResolver.openOutputStream(uriInsert);
                        if (outputStreamOpenOutputStream != null) {
                            try {
                                if (((Bitmap) obj3).compress(Bitmap.CompressFormat.PNG, 100, outputStreamOpenOutputStream)) {
                                    outputStreamOpenOutputStream.flush();
                                    j = 1;
                                } else {
                                    j = 0;
                                }
                                outputStreamOpenOutputStream.close();
                            } catch (Throwable th) {
                                try {
                                    throw th;
                                } catch (Throwable th2) {
                                    fi4.a(outputStreamOpenOutputStream, th);
                                    throw th2;
                                }
                            }
                        } else {
                            j = 0;
                        }
                        if (j <= 0) {
                            new Integer(contentResolver.delete(uriInsert, null, null));
                            return null;
                        }
                        if (i3 >= 29) {
                            ContentValues contentValues2 = new ContentValues();
                            contentValues2.put("is_pending", new Integer(0));
                            contentResolver.update(uriInsert, contentValues2, null, null);
                        }
                        return uriInsert;
                    } catch (Exception unused) {
                        new Integer(contentResolver.delete(uriInsert, null, null));
                        return null;
                    }
                } catch (Throwable unused2) {
                    return null;
                }
            default:
                bz3.g(obj);
                u93 u93Var = (u93) this.i;
                Uri uri = (Uri) obj2;
                uri.getClass();
                return u93Var.o(uri, cq.v("YouTube results for '", (String) obj3, "'"), "the results", null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f61(Object obj, Object obj2, x50 x50Var, int i) {
        super(2, x50Var);
        this.f = i;
        this.j = obj;
        this.k = obj2;
    }
}
