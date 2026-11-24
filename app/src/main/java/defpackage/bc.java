package defpackage;

import android.R;
import android.app.ActivityOptions;
import android.app.PendingIntent;
import android.app.RemoteAction;
import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.textclassifier.TextClassification;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
public final class bc {
    public final cc a;
    public final yb b;
    public final yb c;
    public final View d;

    public bc(cc ccVar, yb ybVar, yb ybVar2, View view) {
        this.a = ccVar;
        this.b = ybVar;
        this.c = ybVar2;
        this.d = view;
    }

    public final boolean a(Menu menu) {
        int i;
        cx2 cx2Var = (cx2) this.b.a();
        final int i2 = 0;
        if (g31.a(cx2Var, null)) {
            return false;
        }
        menu.clear();
        List list = cx2Var.a;
        int size = list.size();
        final int i3 = 1;
        int i4 = 0;
        int i5 = 1;
        int i6 = 1;
        while (i4 < size) {
            bx2 bx2Var = (bx2) list.get(i4);
            if (bx2Var instanceof jx2) {
                i = i5 + 1;
                final jx2 jx2Var = (jx2) bx2Var;
                MenuItem menuItemAdd = menu.add(i6, i5, i5, jx2Var.b);
                menuItemAdd.setShowAsAction(2);
                menuItemAdd.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: ac
                    @Override // android.view.MenuItem.OnMenuItemClickListener
                    public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                        int i7 = i2;
                        Object obj = this;
                        Object obj2 = jx2Var;
                        switch (i7) {
                            case 0:
                                ((jx2) obj2).d.j(((bc) obj).a);
                                break;
                            default:
                                Context context = (Context) obj2;
                                TextClassification textClassification = (TextClassification) obj;
                                String text = textClassification.getText();
                                PendingIntent activity = PendingIntent.getActivity(context, text != null ? text.hashCode() : 0, textClassification.getIntent(), 201326592);
                                if (Build.VERSION.SDK_INT < 34) {
                                    activity.send();
                                } else {
                                    try {
                                        activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                    } catch (PendingIntent.CanceledException e) {
                                        Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                                    }
                                }
                                break;
                        }
                        return true;
                    }
                });
            } else {
                if (bx2Var instanceof px2) {
                    if (Build.VERSION.SDK_INT >= 28) {
                        i = i5 + 1;
                        final Context context = this.d.getContext();
                        px2 px2Var = (px2) bx2Var;
                        final TextClassification textClassification = px2Var.b;
                        int i7 = px2Var.c;
                        if (i7 < 0) {
                            MenuItem menuItemAdd2 = menu.add(R.id.textAssist, R.id.textAssist, i5, textClassification.getLabel());
                            menuItemAdd2.setShowAsAction(2);
                            menuItemAdd2.setIcon(textClassification.getIcon());
                            menuItemAdd2.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: ac
                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                                    int i8 = i3;
                                    Object obj = textClassification;
                                    Object obj2 = context;
                                    switch (i8) {
                                        case 0:
                                            ((jx2) obj2).d.j(((bc) obj).a);
                                            break;
                                        default:
                                            Context context2 = (Context) obj2;
                                            TextClassification textClassification2 = (TextClassification) obj;
                                            String text = textClassification2.getText();
                                            PendingIntent activity = PendingIntent.getActivity(context2, text != null ? text.hashCode() : 0, textClassification2.getIntent(), 201326592);
                                            if (Build.VERSION.SDK_INT < 34) {
                                                activity.send();
                                            } else {
                                                try {
                                                    activity.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                                } catch (PendingIntent.CanceledException e) {
                                                    Log.e("TextClassification", "error sending pendingIntent: " + activity + " error: " + e);
                                                }
                                            }
                                            break;
                                    }
                                    return true;
                                }
                            });
                        } else {
                            int i8 = i7 == 0 ? 1 : i2;
                            final RemoteAction remoteAction = (RemoteAction) textClassification.getActions().get(i7);
                            MenuItem menuItemAdd3 = menu.add(R.id.textAssist, i8 != 0 ? 16908353 : i2, i5, remoteAction.getTitle());
                            menuItemAdd3.setShowAsAction(i8 == 0 ? 0 : 2);
                            if (i8 != 0 || remoteAction.shouldShowIcon()) {
                                menuItemAdd3.setIcon(remoteAction.getIcon().loadDrawable(context));
                            }
                            menuItemAdd3.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() { // from class: a03
                                @Override // android.view.MenuItem.OnMenuItemClickListener
                                public final boolean onMenuItemClick(MenuItem menuItem) throws PendingIntent.CanceledException {
                                    PendingIntent actionIntent = remoteAction.getActionIntent();
                                    if (Build.VERSION.SDK_INT < 34) {
                                        actionIntent.send();
                                        return true;
                                    }
                                    try {
                                        actionIntent.send(ActivityOptions.makeBasic().setPendingIntentBackgroundActivityStartMode(1).toBundle());
                                    } catch (PendingIntent.CanceledException e) {
                                        Log.e("TextClassification", "error sending pendingIntent: " + actionIntent + " error: " + e);
                                    }
                                    return true;
                                }
                            });
                        }
                    }
                } else if (bx2Var instanceof nx2) {
                    i6++;
                }
                i4++;
                i2 = 0;
            }
            i5 = i;
            i4++;
            i2 = 0;
        }
        return true;
    }
}
