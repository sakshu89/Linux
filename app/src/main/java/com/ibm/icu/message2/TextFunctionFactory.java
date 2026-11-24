package com.ibm.icu.message2;

import defpackage.gb;
import defpackage.og;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class TextFunctionFactory implements FunctionFactory {
    @Override // com.ibm.icu.message2.FunctionFactory
    public Function create(Locale locale, Map<String, ?> map) {
        return new TextFunctionImpl(OptUtils.getDirectionality(map));
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class TextFunctionImpl implements Function {
        private final Directionality directionality;

        public TextFunctionImpl(Directionality directionality) {
            this.directionality = directionality == null ? Directionality.INHERIT : directionality;
        }

        @Override // com.ibm.icu.message2.Function
        public FormattedPlaceholder format(Object obj, Map<String, ?> map) {
            return new FormattedPlaceholder(obj, new PlainStringFormattedValue(Objects.toString(obj)), this.directionality, true);
        }

        @Override // com.ibm.icu.message2.Function
        public String formatToString(Object obj, Map<String, ?> map) {
            return format(obj, map).toString();
        }

        @Override // com.ibm.icu.message2.Function
        public List<String> matches(Object obj, List<String> list, Map<String, ?> map) {
            ArrayList arrayList = new ArrayList();
            if (obj == null) {
                if (!OptUtils.reportErrors(map)) {
                    return arrayList;
                }
                og.i("unresolved-variable: argument to match on can't be null");
                return null;
            }
            for (String str : list) {
                if (matches(obj, str)) {
                    arrayList.add(str);
                }
            }
            arrayList.sort(new gb(8));
            return arrayList;
        }

        private boolean matches(Object obj, String str) {
            if (MFDataModel.CatchallKey.isCatchAll(str)) {
                return true;
            }
            return str.equals(Objects.toString(obj));
        }
    }
}
