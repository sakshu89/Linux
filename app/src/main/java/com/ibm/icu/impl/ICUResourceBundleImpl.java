package com.ibm.icu.impl;

import com.ibm.icu.util.UResourceBundle;
import com.ibm.icu.util.UResourceTypeMismatchException;
import defpackage.og;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class ICUResourceBundleImpl extends ICUResourceBundle {
    protected int resource;

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ResourceInt extends ICUResourceBundleImpl {
        public ResourceInt(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getInt() {
            return ICUResourceBundleReader.RES_GET_INT(this.resource);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 7;
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getUInt() {
            return ICUResourceBundleReader.RES_GET_UINT(this.resource);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ResourceIntVector extends ICUResourceBundleImpl {
        public ResourceIntVector(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int[] getIntVector() {
            return this.wholeBundle.reader.getIntVector(this.resource);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 14;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ResourceString extends ICUResourceBundleImpl {
        private String value;

        public ResourceString(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
            String string = this.wholeBundle.reader.getString(i);
            if (string.length() < 12 || CacheValue.futureInstancesWillBeStrong()) {
                this.value = string;
            }
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public String getString() {
            String str = this.value;
            return str != null ? str : this.wholeBundle.reader.getString(this.resource);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 0;
        }
    }

    public ICUResourceBundleImpl(ICUResourceBundle.WholeBundle wholeBundle) {
        super(wholeBundle);
        this.resource = wholeBundle.reader.getRootResource();
    }

    public final ICUResourceBundle createBundleObject(String str, int i, HashMap<String, String> map, UResourceBundle uResourceBundle) {
        int iRES_GET_TYPE = ICUResourceBundleReader.RES_GET_TYPE(i);
        if (iRES_GET_TYPE == 14) {
            return new ResourceIntVector(this, str, i);
        }
        switch (iRES_GET_TYPE) {
            case 0:
            case 6:
                return new ResourceString(this, str, i);
            case 1:
                return new ResourceBinary(this, str, i);
            case 2:
            case 4:
            case 5:
                return new ResourceTable(this, str, i);
            case 3:
                return ICUResourceBundle.getAliasedResource(this, null, 0, str, i, map, uResourceBundle);
            case 7:
                return new ResourceInt(this, str, i);
            case 8:
            case 9:
                return new ResourceArray(this, str, i);
            default:
                og.n("The resource type is unknown");
                return null;
        }
    }

    public int getResource() {
        return this.resource;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static abstract class ResourceContainer extends ICUResourceBundleImpl {
        protected ICUResourceBundleReader.Container value;

        public ResourceContainer(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
        }

        public UResourceBundle createBundleObject(int i, String str, HashMap<String, String> map, UResourceBundle uResourceBundle) {
            int containerResource = getContainerResource(i);
            if (containerResource != -1) {
                return createBundleObject(str, containerResource, map, uResourceBundle);
            }
            throw new IndexOutOfBoundsException();
        }

        public int getContainerResource(int i) {
            return this.value.getContainerResource(this.wholeBundle.reader, i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getSize() {
            return this.value.getSize();
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public String getString(int i) {
            int containerResource = this.value.getContainerResource(this.wholeBundle.reader, i);
            if (containerResource == -1) {
                throw new IndexOutOfBoundsException();
            }
            String string = this.wholeBundle.reader.getString(containerResource);
            return string != null ? string : super.getString(i);
        }

        public ResourceContainer(ICUResourceBundle.WholeBundle wholeBundle) {
            super(wholeBundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResourceArray extends ResourceContainer {
        public ResourceArray(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
            this.value = this.wholeBundle.reader.getArray(i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public String[] getStringArray() {
            return handleGetStringArray();
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 8;
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public UResourceBundle handleGet(String str, HashMap<String, String> map, UResourceBundle uResourceBundle) {
            return createBundleObject(Integer.parseInt(str), str, map, uResourceBundle);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public String[] handleGetStringArray() {
            ICUResourceBundleReader iCUResourceBundleReader = this.wholeBundle.reader;
            int size = this.value.getSize();
            String[] strArr = new String[size];
            for (int i = 0; i < size; i++) {
                String string = iCUResourceBundleReader.getString(this.value.getContainerResource(iCUResourceBundleReader, i));
                if (string == null) {
                    throw new UResourceTypeMismatchException("");
                }
                strArr[i] = string;
            }
            return strArr;
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public UResourceBundle handleGet(int i, HashMap<String, String> map, UResourceBundle uResourceBundle) {
            return createBundleObject(i, Integer.toString(i), map, uResourceBundle);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static final class ResourceBinary extends ICUResourceBundleImpl {
        public ResourceBinary(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public ByteBuffer getBinary() {
            return this.wholeBundle.reader.getBinary(this.resource);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 1;
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public byte[] getBinary(byte[] bArr) {
            return this.wholeBundle.reader.getBinary(this.resource, bArr);
        }
    }

    public ICUResourceBundleImpl(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
        super(iCUResourceBundleImpl, str);
        this.resource = i;
    }

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class ResourceTable extends ResourceContainer {
        public ResourceTable(ICUResourceBundleImpl iCUResourceBundleImpl, String str, int i) {
            super(iCUResourceBundleImpl, str, i);
            this.value = this.wholeBundle.reader.getTable(i);
        }

        public String findString(String str) {
            ICUResourceBundleReader iCUResourceBundleReader = this.wholeBundle.reader;
            int iFindTableItem = ((ICUResourceBundleReader.Table) this.value).findTableItem(iCUResourceBundleReader, str);
            if (iFindTableItem < 0) {
                return null;
            }
            return iCUResourceBundleReader.getString(this.value.getContainerResource(iCUResourceBundleReader, iFindTableItem));
        }

        public String getKey(int i) {
            return ((ICUResourceBundleReader.Table) this.value).getKey(this.wholeBundle.reader, i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public int getType() {
            return 2;
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public UResourceBundle handleGet(int i, HashMap<String, String> map, UResourceBundle uResourceBundle) {
            String key = ((ICUResourceBundleReader.Table) this.value).getKey(this.wholeBundle.reader, i);
            if (key != null) {
                return createBundleObject(key, getContainerResource(i), map, uResourceBundle);
            }
            throw new IndexOutOfBoundsException();
        }

        @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
        public Object handleGetObject(String str) {
            ICUResourceBundleReader iCUResourceBundleReader = this.wholeBundle.reader;
            int iFindTableItem = ((ICUResourceBundleReader.Table) this.value).findTableItem(iCUResourceBundleReader, str);
            if (iFindTableItem >= 0) {
                int containerResource = this.value.getContainerResource(iCUResourceBundleReader, iFindTableItem);
                String string = iCUResourceBundleReader.getString(containerResource);
                if (string != null) {
                    return string;
                }
                ICUResourceBundleReader.Array array = iCUResourceBundleReader.getArray(containerResource);
                if (array != null) {
                    int size = array.getSize();
                    String[] strArr = new String[size];
                    for (int i = 0; i != size; i++) {
                        String string2 = iCUResourceBundleReader.getString(array.getContainerResource(iCUResourceBundleReader, i));
                        if (string2 != null) {
                            strArr[i] = string2;
                        }
                    }
                    return strArr;
                }
            }
            return super.handleGetObject(str);
        }

        @Override // com.ibm.icu.util.UResourceBundle, java.util.ResourceBundle
        public Set<String> handleKeySet() {
            ICUResourceBundleReader iCUResourceBundleReader = this.wholeBundle.reader;
            TreeSet treeSet = new TreeSet();
            ICUResourceBundleReader.Table table = (ICUResourceBundleReader.Table) this.value;
            for (int i = 0; i < table.getSize(); i++) {
                treeSet.add(table.getKey(iCUResourceBundleReader, i));
            }
            return treeSet;
        }

        public ResourceTable(ICUResourceBundle.WholeBundle wholeBundle, int i) {
            super(wholeBundle);
            this.value = wholeBundle.reader.getTable(i);
        }

        @Override // com.ibm.icu.util.UResourceBundle
        public UResourceBundle handleGet(String str, HashMap<String, String> map, UResourceBundle uResourceBundle) {
            int iFindTableItem = ((ICUResourceBundleReader.Table) this.value).findTableItem(this.wholeBundle.reader, str);
            if (iFindTableItem < 0) {
                return null;
            }
            return createBundleObject(str, getContainerResource(iFindTableItem), map, uResourceBundle);
        }
    }
}
