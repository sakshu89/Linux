package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Shader;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.os.Handler;
import android.util.Size;
import android.view.Surface;
import com.project.sonic.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class lj1 {
    public final /* synthetic */ int a;
    public Object b;
    public Object c;
    public Object d;
    public Object e;
    public Object f;
    public Object g;

    public lj1(ys ysVar, nd0 nd0Var, nq nqVar) {
        Size size;
        this.a = 0;
        it2 it2Var = new it2();
        Size size2 = null;
        this.g = null;
        this.d = new kj1();
        this.f = nqVar;
        Size[] sizeArrL = ysVar.b().l(34);
        if (sizeArrL == null) {
            xq4.a("MeteringRepeating", "Can not get output size list.");
            size = new Size(0, 0);
        } else {
            if (it2Var.a != null && "Huawei".equalsIgnoreCase(Build.BRAND) && "mha-l29".equalsIgnoreCase(Build.MODEL)) {
                ArrayList arrayList = new ArrayList();
                for (Size size3 : sizeArrL) {
                    if (it2.c.compare(size3, it2.b) >= 0) {
                        arrayList.add(size3);
                    }
                }
                sizeArrL = (Size[]) arrayList.toArray(new Size[0]);
            }
            List listAsList = Arrays.asList(sizeArrL);
            Collections.sort(listAsList, new gb(6));
            Size sizeE = nd0Var.e();
            long jMin = Math.min(((long) sizeE.getWidth()) * ((long) sizeE.getHeight()), 307200L);
            int length = sizeArrL.length;
            int i = 0;
            while (i < length) {
                Size size4 = sizeArrL[i];
                long width = ((long) size4.getWidth()) * ((long) size4.getHeight());
                if (width == jMin) {
                    size = size4;
                } else if (width <= jMin) {
                    i++;
                    size2 = size4;
                } else if (size2 != null) {
                    size = size2;
                }
            }
            size = (Size) listAsList.get(0);
        }
        this.e = size;
        Objects.toString(size);
        xq4.c(3, "MeteringRepeating");
        this.c = e();
    }

    public static boolean b(int i, int[] iArr) {
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static ColorStateList d(Context context, int i) {
        int iB = h03.b(context, R.attr.colorControlHighlight);
        int iA = h03.a(context, R.attr.colorButtonNormal);
        int[] iArr = h03.b;
        int[] iArr2 = h03.d;
        int iB2 = g00.b(iB, i);
        return new ColorStateList(new int[][]{iArr, iArr2, h03.c, h03.f}, new int[]{iA, iB2, g00.b(iB, i), i});
    }

    public static LayerDrawable h(s62 s62Var, Context context, int i) {
        BitmapDrawable bitmapDrawable;
        BitmapDrawable bitmapDrawable2;
        BitmapDrawable bitmapDrawable3;
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i);
        Drawable drawableD = s62Var.d(context, R.drawable.abc_star_black_48dp);
        Drawable drawableD2 = s62Var.d(context, R.drawable.abc_star_half_black_48dp);
        if ((drawableD instanceof BitmapDrawable) && drawableD.getIntrinsicWidth() == dimensionPixelSize && drawableD.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable = (BitmapDrawable) drawableD;
            bitmapDrawable2 = new BitmapDrawable(bitmapDrawable.getBitmap());
        } else {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            drawableD.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableD.draw(canvas);
            bitmapDrawable = new BitmapDrawable(bitmapCreateBitmap);
            bitmapDrawable2 = new BitmapDrawable(bitmapCreateBitmap);
        }
        bitmapDrawable2.setTileModeX(Shader.TileMode.REPEAT);
        if ((drawableD2 instanceof BitmapDrawable) && drawableD2.getIntrinsicWidth() == dimensionPixelSize && drawableD2.getIntrinsicHeight() == dimensionPixelSize) {
            bitmapDrawable3 = (BitmapDrawable) drawableD2;
        } else {
            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(bitmapCreateBitmap2);
            drawableD2.setBounds(0, 0, dimensionPixelSize, dimensionPixelSize);
            drawableD2.draw(canvas2);
            bitmapDrawable3 = new BitmapDrawable(bitmapCreateBitmap2);
        }
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{bitmapDrawable, bitmapDrawable3, bitmapDrawable2});
        layerDrawable.setId(0, android.R.id.background);
        layerDrawable.setId(1, android.R.id.secondaryProgress);
        layerDrawable.setId(2, android.R.id.progress);
        return layerDrawable;
    }

    public static void l(Drawable drawable, int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterF;
        int[] iArr = wf0.a;
        Drawable drawableMutate = drawable.mutate();
        if (mode == null) {
            mode = xe.b;
        }
        PorterDuff.Mode mode2 = xe.b;
        synchronized (xe.class) {
            porterDuffColorFilterF = s62.f(i, mode);
        }
        drawableMutate.setColorFilter(porterDuffColorFilterF);
    }

    public void a(String str, String str2) {
        HashMap map = (HashMap) this.g;
        if (map != null) {
            map.put(str, str2);
        } else {
            og.n("Property \"autoMetadata\" has not been set");
        }
    }

    public hi c() {
        String strConcat = ((String) this.b) == null ? " transportName" : "";
        if (((ni0) this.d) == null) {
            strConcat = strConcat.concat(" encodedPayload");
        }
        if (((Long) this.e) == null) {
            strConcat = strConcat.concat(" eventMillis");
        }
        if (((Long) this.f) == null) {
            strConcat = strConcat.concat(" uptimeMillis");
        }
        if (((HashMap) this.g) == null) {
            strConcat = strConcat.concat(" autoMetadata");
        }
        if (strConcat.isEmpty()) {
            return new hi((String) this.b, (Integer) this.c, (ni0) this.d, ((Long) this.e).longValue(), ((Long) this.f).longValue(), (HashMap) this.g);
        }
        og.n("Missing required properties:".concat(strConcat));
        return null;
    }

    public kh2 e() {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        Size size = (Size) this.e;
        surfaceTexture.setDefaultBufferSize(size.getWidth(), size.getHeight());
        Surface surface = new Surface(surfaceTexture);
        gh2 gh2VarD = gh2.d((kj1) this.d, size);
        int i = 1;
        gh2VarD.b.a = 1;
        nz0 nz0Var = new nz0(surface);
        this.b = nz0Var;
        wc1 wc1VarE = oz3.e(nz0Var.e);
        q91 q91Var = new q91(5, surface, surfaceTexture);
        wc1VarE.a(new or0(0, wc1VarE, q91Var), xg4.a());
        gh2VarD.b((nz0) this.b, ig0.d, -1);
        hh2 hh2Var = (hh2) this.g;
        if (hh2Var != null) {
            hh2Var.b();
        }
        hh2 hh2Var2 = new hh2(new ny0(i, this));
        this.g = hh2Var2;
        gh2VarD.f = hh2Var2;
        return gh2VarD.c();
    }

    public void f(bv2 bv2Var) {
        ArrayList arrayListI = i();
        int size = arrayListI.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListI.get(i);
            i++;
            bv2 bv2Var2 = (bv2) obj;
            if (bv2Var2 == bv2Var) {
                return;
            }
            synchronized (bv2Var2.a) {
                try {
                    List list = bv2Var2.k;
                    if (list != null) {
                        Iterator it = list.iterator();
                        while (it.hasNext()) {
                            ((ob0) it.next()).b();
                        }
                        bv2Var2.k = null;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            bv2Var2.u.i();
        }
    }

    public ArrayList g() {
        ArrayList arrayList;
        synchronized (this.c) {
            arrayList = new ArrayList((LinkedHashSet) this.d);
        }
        return arrayList;
    }

    public ArrayList i() {
        ArrayList arrayList;
        ArrayList arrayList2;
        synchronized (this.c) {
            arrayList = new ArrayList();
            arrayList.addAll(g());
            synchronized (this.c) {
                arrayList2 = new ArrayList((LinkedHashSet) this.f);
            }
            arrayList.addAll(arrayList2);
        }
        return arrayList;
    }

    public ColorStateList j(Context context, int i) {
        if (i == R.drawable.abc_edit_text_material) {
            return oe4.b(context, R.color.abc_tint_edittext);
        }
        if (i == R.drawable.abc_switch_track_mtrl_alpha) {
            return oe4.b(context, R.color.abc_tint_switch_track);
        }
        if (i != R.drawable.abc_switch_thumb_material) {
            if (i == R.drawable.abc_btn_default_mtrl_shape) {
                return d(context, h03.b(context, R.attr.colorButtonNormal));
            }
            if (i == R.drawable.abc_btn_borderless_material) {
                return d(context, 0);
            }
            if (i == R.drawable.abc_btn_colored_material) {
                return d(context, h03.b(context, R.attr.colorAccent));
            }
            if (i == R.drawable.abc_spinner_mtrl_am_alpha || i == R.drawable.abc_spinner_textfield_background_material) {
                return oe4.b(context, R.color.abc_tint_spinner);
            }
            if (b(i, (int[]) this.c)) {
                return h03.c(context, R.attr.colorControlNormal);
            }
            if (b(i, (int[]) this.f)) {
                return oe4.b(context, R.color.abc_tint_default);
            }
            if (b(i, (int[]) this.g)) {
                return oe4.b(context, R.color.abc_tint_btn_checkable);
            }
            if (i == R.drawable.abc_seekbar_thumb_material) {
                return oe4.b(context, R.color.abc_tint_seek_thumb);
            }
            return null;
        }
        int[][] iArr = new int[3][];
        int[] iArr2 = new int[3];
        ColorStateList colorStateListC = h03.c(context, R.attr.colorSwitchThumbNormal);
        if (colorStateListC == null || !colorStateListC.isStateful()) {
            iArr[0] = h03.b;
            iArr2[0] = h03.a(context, R.attr.colorSwitchThumbNormal);
            iArr[1] = h03.e;
            iArr2[1] = h03.b(context, R.attr.colorControlActivated);
            iArr[2] = h03.f;
            iArr2[2] = h03.b(context, R.attr.colorSwitchThumbNormal);
        } else {
            int[] iArr3 = h03.b;
            iArr[0] = iArr3;
            iArr2[0] = colorStateListC.getColorForState(iArr3, 0);
            iArr[1] = h03.e;
            iArr2[1] = h03.b(context, R.attr.colorControlActivated);
            iArr[2] = h03.f;
            iArr2[2] = colorStateListC.getDefaultColor();
        }
        return new ColorStateList(iArr, iArr2);
    }

    public cj k() {
        cj cjVar = new cj();
        cjVar.a = new LinkedHashMap();
        cjVar.b = (ey0) this.b;
        cjVar.c = (String) this.c;
        cjVar.f = (t9) this.e;
        Map map = (Map) this.f;
        cjVar.a = map.isEmpty() ? new LinkedHashMap() : new LinkedHashMap(map);
        cjVar.e = ((ew0) this.d).d();
        return cjVar;
    }

    public String toString() {
        switch (this.a) {
            case 5:
                Map map = (Map) this.f;
                StringBuilder sb = new StringBuilder("Request{method=");
                sb.append((String) this.c);
                sb.append(", url=");
                sb.append((ey0) this.b);
                ew0 ew0Var = (ew0) this.d;
                if (ew0Var.size() != 0) {
                    sb.append(", headers=[");
                    Iterator it = ew0Var.iterator();
                    int i = 0;
                    while (true) {
                        e1 e1Var = (e1) it;
                        if (e1Var.hasNext()) {
                            Object next = e1Var.next();
                            int i2 = i + 1;
                            if (i < 0) {
                                nz.n();
                                throw null;
                            }
                            wt1 wt1Var = (wt1) next;
                            String str = (String) wt1Var.a;
                            String str2 = (String) wt1Var.b;
                            if (i > 0) {
                                sb.append(", ");
                            }
                            sb.append(str);
                            sb.append(':');
                            sb.append(str2);
                            i = i2;
                        } else {
                            sb.append(']');
                        }
                    }
                }
                if (!map.isEmpty()) {
                    sb.append(", tags=");
                    sb.append(map);
                }
                sb.append('}');
                return sb.toString();
            default:
                return super.toString();
        }
    }

    public lj1(String str, String str2, Set set) {
        this.a = 4;
        Set setUnmodifiableSet = set == null ? Collections.EMPTY_SET : Collections.unmodifiableSet(set);
        this.b = setUnmodifiableSet;
        Map map = Collections.EMPTY_MAP;
        this.d = str;
        this.e = str2;
        this.f = ok2.b;
        HashSet hashSet = new HashSet(setUnmodifiableSet);
        Iterator it = map.values().iterator();
        if (!it.hasNext()) {
            this.c = Collections.unmodifiableSet(hashSet);
        } else {
            it.next().getClass();
            dk0.t();
            throw null;
        }
    }

    public lj1(ey0 ey0Var, String str, ew0 ew0Var, t9 t9Var, Map map) {
        this.a = 5;
        ey0Var.getClass();
        str.getClass();
        this.b = ey0Var;
        this.c = str;
        this.d = ew0Var;
        this.e = t9Var;
        this.f = map;
    }

    public lj1(ch2 ch2Var) {
        this.a = 3;
        this.c = new Object();
        this.d = new LinkedHashSet();
        this.e = new LinkedHashSet();
        this.f = new LinkedHashSet();
        this.g = new mt(this);
        this.b = ch2Var;
    }

    public lj1() {
        this.a = 1;
        this.b = new int[]{R.drawable.abc_textfield_search_default_mtrl_alpha, R.drawable.abc_textfield_default_mtrl_alpha, R.drawable.abc_ab_share_pack_mtrl_alpha};
        this.c = new int[]{R.drawable.abc_ic_commit_search_api_mtrl_alpha, R.drawable.abc_seekbar_tick_mark_material, R.drawable.abc_ic_menu_share_mtrl_alpha, R.drawable.abc_ic_menu_copy_mtrl_am_alpha, R.drawable.abc_ic_menu_cut_mtrl_alpha, R.drawable.abc_ic_menu_selectall_mtrl_alpha, R.drawable.abc_ic_menu_paste_mtrl_am_alpha};
        this.d = new int[]{R.drawable.abc_textfield_activated_mtrl_alpha, R.drawable.abc_textfield_search_activated_mtrl_alpha, R.drawable.abc_cab_background_top_mtrl_alpha, R.drawable.abc_text_cursor_material, R.drawable.abc_text_select_handle_left_mtrl, R.drawable.abc_text_select_handle_middle_mtrl, R.drawable.abc_text_select_handle_right_mtrl};
        this.e = new int[]{R.drawable.abc_popup_background_mtrl_mult, R.drawable.abc_cab_background_internal_bg, R.drawable.abc_menu_hardkey_panel_mtrl_mult};
        this.f = new int[]{R.drawable.abc_tab_indicator_material, R.drawable.abc_textfield_search_material};
        this.g = new int[]{R.drawable.abc_btn_check_material, R.drawable.abc_btn_radio_material, R.drawable.abc_btn_check_material_anim, R.drawable.abc_btn_radio_material_anim};
    }

    public /* synthetic */ lj1(int i) {
        this.a = i;
    }

    public lj1(cq0 cq0Var, cq0 cq0Var2, xv0 xv0Var, lj1 lj1Var, ch2 ch2Var, Handler handler) {
        this.a = 6;
        this.b = ch2Var;
        this.c = xv0Var;
        this.d = handler;
        this.e = lj1Var;
        this.f = cq0Var;
        this.g = cq0Var2;
    }
}
