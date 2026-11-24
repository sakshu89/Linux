package com.ibm.icu.text;

import com.ibm.icu.impl.Assert;
import com.ibm.icu.impl.RBBIDataWrapper;
import com.ibm.icu.impl.number.Padder;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;
import java.util.function.Predicate;

/* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
/* JADX INFO: loaded from: classes.dex */
class RBBITableBuilder {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final int MAX_STATE_FOR_8BITS_TABLE = 255;
    int[] fLookAheadRuleMap;
    private RBBIRuleBuilder fRB;
    private int fRootIx;
    private List<short[]> fSafeTable;
    int fLASlotsInUse = 1;
    private List<RBBIStateDescriptor> fDStates = new ArrayList();

    /* JADX INFO: compiled from: r8-map-id-052cfdc27f13693602f29a54f0f26da42a69e49534e5b71cf81005ba2b6d6d3d */
    public static class RBBIStateDescriptor {
        int fAccepting;
        int[] fDtran;
        int fLookAhead;
        boolean fMarked;
        int fTagsIdx;
        SortedSet<Integer> fTagVals = new TreeSet();
        Set<RBBINode> fPositions = new HashSet();

        public RBBIStateDescriptor(int i) {
            this.fDtran = new int[i + 1];
        }
    }

    public RBBITableBuilder(RBBIRuleBuilder rBBIRuleBuilder, int i) {
        this.fRootIx = i;
        this.fRB = rBBIRuleBuilder;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$buildSafeReverseTable$6(int i) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$buildSafeReverseTable$7(int i) {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$minimizeLookaheads$3(int i, Integer num) {
        return this.fDStates.get(num.intValue()).fAccepting == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ boolean lambda$minimizeLookaheads$4(int i, Integer num) {
        return this.fDStates.get(num.intValue()).fLookAhead == i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ int lambda$minimizeLookaheads$5(int i) {
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$minimizeStates$0(C1StateType c1StateType) {
        return new ArrayList();
    }

    private /* synthetic */ List lambda$minimizeStates$1(List list, Integer num) {
        RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(num.intValue());
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (true) {
            int[] iArr = rBBIStateDescriptor.fDtran;
            if (i >= iArr.length) {
                return arrayList;
            }
            int i2 = iArr[i];
            for (int i3 = 0; i3 < list.size(); i3++) {
                if (((List) list.get(i3)).contains(Integer.valueOf(i2))) {
                    arrayList.add(Integer.valueOf(i3));
                    break;
                }
            }
            i++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ List lambda$minimizeStates$2(List list) {
        return new ArrayList();
    }

    private boolean reachableByTransitions(int i, Predicate<Integer> predicate, Predicate<Integer> predicate2) {
        Stack stack = new Stack();
        for (int i2 : this.fDStates.get(i).fDtran) {
            if (i2 != 0) {
                stack.push(Integer.valueOf(i2));
            }
        }
        boolean[] zArr = new boolean[this.fDStates.size()];
        while (!stack.empty()) {
            Integer num = (Integer) stack.pop();
            int iIntValue = num.intValue();
            if (predicate.test(num)) {
                return true;
            }
            if (!zArr[iIntValue] && !predicate2.test(num)) {
                zArr[iIntValue] = true;
                for (int i3 : this.fDStates.get(iIntValue).fDtran) {
                    if (i3 != 0 && !zArr[i3]) {
                        stack.push(Integer.valueOf(i3));
                    }
                }
            }
        }
        return false;
    }

    public void addRuleRootNodes(List<RBBINode> list, RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        if (rBBINode.fRuleRoot) {
            list.add(rBBINode);
        } else {
            addRuleRootNodes(list, rBBINode.fLeftChild);
            addRuleRootNodes(list, rBBINode.fRightChild);
        }
    }

    public void buildForwardTable() {
        RBBINode[] rBBINodeArr = this.fRB.fTreeRoots;
        int i = this.fRootIx;
        RBBINode rBBINode = rBBINodeArr[i];
        if (rBBINode == null) {
            return;
        }
        rBBINodeArr[i] = rBBINode.flattenVariables(0);
        String str = this.fRB.fDebugEnv;
        if (str != null && str.indexOf("ftree") >= 0) {
            System.out.println("Parse tree after flattening variable references.");
            this.fRB.fTreeRoots[this.fRootIx].printTree(true);
        }
        RBBINode rBBINode2 = new RBBINode(8);
        RBBINode rBBINode3 = this.fRB.fTreeRoots[this.fRootIx];
        rBBINode2.fLeftChild = rBBINode3;
        rBBINode3.fParent = rBBINode2;
        RBBINode rBBINode4 = new RBBINode(6);
        rBBINode2.fRightChild = rBBINode4;
        rBBINode4.fParent = rBBINode2;
        this.fRB.fTreeRoots[this.fRootIx] = rBBINode2;
        rBBINode2.flattenSets();
        String str2 = this.fRB.fDebugEnv;
        if (str2 != null && str2.indexOf("stree") >= 0) {
            System.out.println("Parse tree after flattening Unicode Set references.");
            this.fRB.fTreeRoots[this.fRootIx].printTree(true);
        }
        calcNullable(this.fRB.fTreeRoots[this.fRootIx]);
        calcFirstPos(this.fRB.fTreeRoots[this.fRootIx]);
        calcLastPos(this.fRB.fTreeRoots[this.fRootIx]);
        calcFollowPos(this.fRB.fTreeRoots[this.fRootIx]);
        String str3 = this.fRB.fDebugEnv;
        if (str3 != null && str3.indexOf("pos") >= 0) {
            System.out.print("\n");
            printPosSets(this.fRB.fTreeRoots[this.fRootIx]);
        }
        RBBIRuleBuilder rBBIRuleBuilder = this.fRB;
        if (rBBIRuleBuilder.fChainRules) {
            calcChainedFollowPos(rBBIRuleBuilder.fTreeRoots[this.fRootIx], rBBINode4);
        }
        buildStateTable();
        mapLookAheadRules();
        flagAcceptingStates();
        flagLookAheadStates();
        flagTaggedStates();
        mergeRuleStatusVals();
    }

    public void buildSafeReverseTable() {
        int i;
        List<short[]> list;
        int i2;
        int[] iArr;
        int[] iArr2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        StringBuilder sb = new StringBuilder();
        int numCharCategories = this.fRB.fSetBuilder.getNumCharCategories();
        int size = this.fDStates.size();
        int i10 = this.fLASlotsInUse;
        int[] iArr3 = new int[i10 + 1];
        int i11 = 1;
        int[] iArr4 = new int[i10 + 1];
        int i12 = 1;
        while (i12 < numCharCategories) {
            if (this.fRB.fSetBuilder.getFirstChar(i12) >= 0) {
                int i13 = i11;
                while (i13 < numCharCategories) {
                    if (this.fRB.fSetBuilder.getFirstChar(i13) >= 0) {
                        int[] iArr5 = {i12, i13};
                        int i14 = i11;
                        int i15 = -1;
                        boolean z = false;
                        int i16 = -1;
                        while (true) {
                            if (i14 >= size) {
                                i2 = size;
                                iArr = iArr4;
                                iArr2 = iArr3;
                                if (!z) {
                                    sb.append((char) i12);
                                    sb.append((char) i13);
                                    break;
                                }
                                int i17 = this.fDStates.get(1).fDtran[i13];
                                if (i17 != i16) {
                                    break;
                                }
                                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i17);
                                int i18 = 2;
                                if (i15 != 2) {
                                    break;
                                }
                                int i19 = 2;
                                while (true) {
                                    if (i19 > this.fLASlotsInUse) {
                                        sb.append((char) i12);
                                        sb.append((char) i13);
                                        break;
                                        break;
                                    } else {
                                        if ((iArr[i19] == i18) != (rBBIStateDescriptor.fLookAhead == i19) && i16 != 1) {
                                            break;
                                        }
                                        i19++;
                                        i18 = 2;
                                    }
                                }
                            } else {
                                int i20 = i11;
                                while (i20 <= this.fLASlotsInUse) {
                                    Arrays.setAll(iArr3, new c(i11));
                                    if (i20 != i11) {
                                        iArr3[i20] = -2;
                                    }
                                    RBBIStateDescriptor rBBIStateDescriptor2 = this.fDStates.get(i14);
                                    i2 = size;
                                    int i21 = rBBIStateDescriptor2.fAccepting;
                                    if (i21 == i11) {
                                        i3 = 0;
                                    } else {
                                        if (i21 == i20) {
                                            iArr = iArr4;
                                            iArr2 = iArr3;
                                        } else {
                                            i3 = -2;
                                        }
                                        i20++;
                                        size = i2;
                                        iArr4 = iArr;
                                        iArr3 = iArr2;
                                        i11 = 1;
                                    }
                                    int i22 = rBBIStateDescriptor2.fLookAhead;
                                    if (i22 != 0) {
                                        iArr3[i22] = 0;
                                    }
                                    int i23 = i11;
                                    int i24 = i14;
                                    int i25 = 0;
                                    int i26 = -2;
                                    while (true) {
                                        if (i23 == 0) {
                                            i4 = 2;
                                            Arrays.setAll(iArr3, new c(i4));
                                            i25 = i26;
                                            i5 = 1;
                                        } else {
                                            i4 = 2;
                                            i5 = i24;
                                        }
                                        while (true) {
                                            if (i23 != 0) {
                                                i23 = 0;
                                            }
                                            iArr = iArr4;
                                            if (i25 == -2) {
                                                i6 = -2;
                                                break;
                                            }
                                            if (i25 == i4) {
                                                i6 = -2;
                                                break;
                                            }
                                            int i27 = iArr5[i25];
                                            i25++;
                                            int i28 = i5;
                                            int i29 = this.fDStates.get(i28).fDtran[i27];
                                            if (i29 == 0) {
                                                iArr2 = iArr3;
                                                int i30 = i26;
                                                if (i30 != -2 && i3 == i30) {
                                                    break;
                                                }
                                                i24 = i28;
                                                iArr4 = iArr;
                                                i26 = i3;
                                                iArr3 = iArr2;
                                                break;
                                            }
                                            RBBIStateDescriptor rBBIStateDescriptor3 = this.fDStates.get(i29);
                                            int[] iArr6 = iArr3;
                                            int i31 = rBBIStateDescriptor3.fAccepting;
                                            if (i31 == 1) {
                                                i3 = i25;
                                            } else if (i31 > 1 && (i9 = iArr6[i31]) != -1) {
                                                i26 = i9;
                                                iArr4 = iArr;
                                                iArr3 = iArr6;
                                                i24 = i29;
                                                break;
                                            }
                                            int i32 = rBBIStateDescriptor3.fLookAhead;
                                            if (i32 != 0) {
                                                iArr6[i32] = i25;
                                            }
                                            iArr4 = iArr;
                                            iArr3 = iArr6;
                                            i5 = i29;
                                            i4 = 2;
                                        }
                                    }
                                    int i33 = i5;
                                    iArr2 = iArr3;
                                    if (i25 != i6) {
                                        if (i16 >= 0) {
                                            if (i16 != i33 || i15 != i3) {
                                                break;
                                            }
                                        } else {
                                            int i34 = 2;
                                            while (i34 <= this.fLASlotsInUse) {
                                                int i35 = iArr2[i34];
                                                if (i35 == -1 || i35 == i6 || i35 == 0) {
                                                    iArr[i34] = -1;
                                                } else {
                                                    iArr[i34] = iArr2[i25];
                                                }
                                                i34++;
                                                i6 = -2;
                                            }
                                            i15 = i3;
                                            i16 = i33;
                                        }
                                        for (int i36 = 2; i36 <= this.fLASlotsInUse; i36++) {
                                            int i37 = iArr2[i36];
                                            if (i37 != -2 && i37 != 0 && i37 != (i7 = iArr[i36])) {
                                                if (i37 == 2 || i7 == 2) {
                                                    i8 = 1;
                                                    if (i16 != 1) {
                                                        break;
                                                    }
                                                } else {
                                                    i8 = 1;
                                                }
                                                if (i37 == i8 || i7 == i8) {
                                                    z = true;
                                                }
                                            }
                                        }
                                    }
                                    i20++;
                                    size = i2;
                                    iArr4 = iArr;
                                    iArr3 = iArr2;
                                    i11 = 1;
                                }
                                i14++;
                                i11 = 1;
                            }
                        }
                    } else {
                        i2 = size;
                        iArr = iArr4;
                        iArr2 = iArr3;
                    }
                    i13++;
                    size = i2;
                    iArr4 = iArr;
                    iArr3 = iArr2;
                    i11 = 1;
                }
            }
            i12++;
            size = size;
            iArr4 = iArr4;
            iArr3 = iArr3;
            i11 = 1;
        }
        int i38 = 0;
        this.fSafeTable = new ArrayList();
        int i39 = 0;
        while (true) {
            i = numCharCategories + 2;
            list = this.fSafeTable;
            if (i39 >= i) {
                break;
            }
            list.add(new short[numCharCategories]);
            i39++;
        }
        short[] sArr = list.get(1);
        for (int i40 = 0; i40 < numCharCategories; i40++) {
            sArr[i40] = (short) (i40 + 2);
        }
        int i41 = 2;
        while (i41 < i) {
            int i42 = i38;
            System.arraycopy(sArr, i42, this.fSafeTable.get(i41), i42, sArr.length);
            i41++;
            i38 = 0;
        }
        for (int i43 = 0; i43 < sb.length(); i43 += 2) {
            this.fSafeTable.get(sb.charAt(i43 + 1) + 2)[sb.charAt(i43)] = 0;
        }
        RBBIRuleBuilder.IntPair intPair = new RBBIRuleBuilder.IntPair(1, 0);
        while (findDuplicateSafeState(intPair)) {
            removeSafeState(intPair);
        }
    }

    public void buildStateTable() {
        RBBIStateDescriptor rBBIStateDescriptor;
        int numCharCategories = this.fRB.fSetBuilder.getNumCharCategories() - 1;
        this.fDStates.add(new RBBIStateDescriptor(numCharCategories));
        RBBIStateDescriptor rBBIStateDescriptor2 = new RBBIStateDescriptor(numCharCategories);
        rBBIStateDescriptor2.fPositions.addAll(this.fRB.fTreeRoots[this.fRootIx].fFirstPosSet);
        this.fDStates.add(rBBIStateDescriptor2);
        while (true) {
            int i = 1;
            while (true) {
                if (i >= this.fDStates.size()) {
                    rBBIStateDescriptor = null;
                    break;
                }
                rBBIStateDescriptor = this.fDStates.get(i);
                if (!rBBIStateDescriptor.fMarked) {
                    break;
                } else {
                    i++;
                }
            }
            if (rBBIStateDescriptor == null) {
                return;
            }
            rBBIStateDescriptor.fMarked = true;
            for (int i2 = 1; i2 <= numCharCategories; i2++) {
                Set<RBBINode> hashSet = null;
                for (RBBINode rBBINode : rBBIStateDescriptor.fPositions) {
                    if (rBBINode.fType == 3 && rBBINode.fVal == i2) {
                        if (hashSet == null) {
                            hashSet = new HashSet<>();
                        }
                        hashSet.addAll(rBBINode.fFollowPos);
                    }
                }
                if (hashSet != null) {
                    boolean z = false;
                    Assert.assrt(hashSet.size() > 0);
                    int size = 0;
                    while (true) {
                        if (size >= this.fDStates.size()) {
                            size = 0;
                            break;
                        }
                        RBBIStateDescriptor rBBIStateDescriptor3 = this.fDStates.get(size);
                        if (hashSet.equals(rBBIStateDescriptor3.fPositions)) {
                            hashSet = rBBIStateDescriptor3.fPositions;
                            z = true;
                            break;
                        }
                        size++;
                    }
                    if (!z) {
                        RBBIStateDescriptor rBBIStateDescriptor4 = new RBBIStateDescriptor(numCharCategories);
                        rBBIStateDescriptor4.fPositions = hashSet;
                        this.fDStates.add(rBBIStateDescriptor4);
                        size = this.fDStates.size() - 1;
                    }
                    rBBIStateDescriptor.fDtran[i2] = size;
                }
            }
        }
    }

    public void calcChainedFollowPos(RBBINode rBBINode, RBBINode rBBINode2) {
        ArrayList arrayList = new ArrayList();
        rBBINode.findNodes(arrayList, 3);
        ArrayList arrayList2 = new ArrayList();
        addRuleRootNodes(arrayList2, rBBINode);
        HashSet<RBBINode> hashSet = new HashSet();
        int size = arrayList2.size();
        int i = 0;
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            RBBINode rBBINode3 = (RBBINode) obj;
            if (rBBINode3.fChainIn) {
                hashSet.addAll(rBBINode3.fFirstPosSet);
            }
        }
        int size2 = arrayList.size();
        while (i < size2) {
            Object obj2 = arrayList.get(i);
            i++;
            RBBINode rBBINode4 = (RBBINode) obj2;
            if (rBBINode4.fFollowPos.contains(rBBINode2)) {
                for (RBBINode rBBINode5 : hashSet) {
                    if (rBBINode5.fType == 3 && rBBINode4.fVal == rBBINode5.fVal) {
                        rBBINode4.fFollowPos.addAll(rBBINode5.fFollowPos);
                    }
                }
            }
        }
    }

    public void calcFirstPos(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        int i = rBBINode.fType;
        if (i == 3 || i == 6 || i == 4 || i == 5) {
            rBBINode.fFirstPosSet.add(rBBINode);
            return;
        }
        calcFirstPos(rBBINode.fLeftChild);
        calcFirstPos(rBBINode.fRightChild);
        int i2 = rBBINode.fType;
        if (i2 == 9) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
            rBBINode.fFirstPosSet.addAll(rBBINode.fRightChild.fFirstPosSet);
            return;
        }
        if (i2 == 8) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
            if (rBBINode.fLeftChild.fNullable) {
                rBBINode.fFirstPosSet.addAll(rBBINode.fRightChild.fFirstPosSet);
                return;
            }
            return;
        }
        if (i2 == 10 || i2 == 12 || i2 == 11) {
            rBBINode.fFirstPosSet.addAll(rBBINode.fLeftChild.fFirstPosSet);
        }
    }

    public void calcFollowPos(RBBINode rBBINode) {
        int i;
        if (rBBINode == null || (i = rBBINode.fType) == 3 || i == 6) {
            return;
        }
        calcFollowPos(rBBINode.fLeftChild);
        calcFollowPos(rBBINode.fRightChild);
        if (rBBINode.fType == 8) {
            Iterator<RBBINode> it = rBBINode.fLeftChild.fLastPosSet.iterator();
            while (it.hasNext()) {
                it.next().fFollowPos.addAll(rBBINode.fRightChild.fFirstPosSet);
            }
        }
        int i2 = rBBINode.fType;
        if (i2 == 10 || i2 == 11) {
            Iterator<RBBINode> it2 = rBBINode.fLastPosSet.iterator();
            while (it2.hasNext()) {
                it2.next().fFollowPos.addAll(rBBINode.fFirstPosSet);
            }
        }
    }

    public void calcLastPos(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        int i = rBBINode.fType;
        if (i == 3 || i == 6 || i == 4 || i == 5) {
            rBBINode.fLastPosSet.add(rBBINode);
            return;
        }
        calcLastPos(rBBINode.fLeftChild);
        calcLastPos(rBBINode.fRightChild);
        int i2 = rBBINode.fType;
        if (i2 == 9) {
            rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
            rBBINode.fLastPosSet.addAll(rBBINode.fRightChild.fLastPosSet);
            return;
        }
        if (i2 == 8) {
            rBBINode.fLastPosSet.addAll(rBBINode.fRightChild.fLastPosSet);
            if (rBBINode.fRightChild.fNullable) {
                rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
                return;
            }
            return;
        }
        if (i2 == 10 || i2 == 12 || i2 == 11) {
            rBBINode.fLastPosSet.addAll(rBBINode.fLeftChild.fLastPosSet);
        }
    }

    public void calcNullable(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        int i = rBBINode.fType;
        boolean z = false;
        if (i == 0 || i == 6) {
            rBBINode.fNullable = false;
            return;
        }
        if (i == 4 || i == 5) {
            rBBINode.fNullable = true;
            return;
        }
        calcNullable(rBBINode.fLeftChild);
        calcNullable(rBBINode.fRightChild);
        int i2 = rBBINode.fType;
        if (i2 == 9) {
            rBBINode.fNullable = rBBINode.fLeftChild.fNullable || rBBINode.fRightChild.fNullable;
            return;
        }
        if (i2 == 8) {
            if (rBBINode.fLeftChild.fNullable && rBBINode.fRightChild.fNullable) {
                z = true;
            }
            rBBINode.fNullable = z;
            return;
        }
        if (i2 == 10 || i2 == 12) {
            rBBINode.fNullable = true;
        } else {
            rBBINode.fNullable = false;
        }
    }

    public RBBIDataWrapper.RBBIStateTable exportSafeTable() {
        RBBIDataWrapper.RBBIStateTable rBBIStateTable = new RBBIDataWrapper.RBBIStateTable();
        int size = this.fSafeTable.size();
        rBBIStateTable.fNumStates = size;
        boolean z = size <= 255;
        int length = this.fSafeTable.get(0).length;
        int i = length + 3;
        int safeTableSize = getSafeTableSize() - RBBIDataWrapper.RBBIStateTable.fHeaderSize;
        if (z) {
            rBBIStateTable.fFlags |= 4;
            rBBIStateTable.fTable = new char[safeTableSize];
            rBBIStateTable.fRowLen = i;
        } else {
            rBBIStateTable.fTable = new char[safeTableSize / 2];
            rBBIStateTable.fRowLen = i * 2;
        }
        for (int i2 = 0; i2 < rBBIStateTable.fNumStates; i2++) {
            short[] sArr = this.fSafeTable.get(i2);
            int i3 = i2 * i;
            for (int i4 = 0; i4 < length; i4++) {
                if (z) {
                    Assert.assrt(sArr[i4] <= 255);
                }
                rBBIStateTable.fTable[i3 + 3 + i4] = (char) sArr[i4];
            }
        }
        return rBBIStateTable;
    }

    public RBBIDataWrapper.RBBIStateTable exportTable() {
        RBBIDataWrapper.RBBIStateTable rBBIStateTable = new RBBIDataWrapper.RBBIStateTable();
        RBBIRuleBuilder rBBIRuleBuilder = this.fRB;
        if (rBBIRuleBuilder.fTreeRoots[this.fRootIx] != null) {
            Assert.assrt(rBBIRuleBuilder.fSetBuilder.getNumCharCategories() < 32767 && this.fDStates.size() < 32767);
            rBBIStateTable.fNumStates = this.fDStates.size();
            rBBIStateTable.fDictCategoriesStart = this.fRB.fSetBuilder.getDictCategoriesStart();
            int i = this.fLASlotsInUse;
            rBBIStateTable.fLookAheadResultsSize = i == 1 ? 0 : i + 1;
            boolean z = rBBIStateTable.fNumStates <= 255;
            int numCharCategories = this.fRB.fSetBuilder.getNumCharCategories() + 3;
            if (z) {
                rBBIStateTable.fTable = new char[getTableSize() - RBBIDataWrapper.RBBIStateTable.fHeaderSize];
                rBBIStateTable.fRowLen = numCharCategories;
            } else {
                rBBIStateTable.fTable = new char[(getTableSize() - RBBIDataWrapper.RBBIStateTable.fHeaderSize) / 2];
                rBBIStateTable.fRowLen = numCharCategories * 2;
            }
            RBBIRuleBuilder rBBIRuleBuilder2 = this.fRB;
            if (rBBIRuleBuilder2.fLookAheadHardBreak) {
                rBBIStateTable.fFlags |= 1;
            }
            if (z) {
                rBBIStateTable.fFlags |= 4;
            }
            int numCharCategories2 = rBBIRuleBuilder2.fSetBuilder.getNumCharCategories();
            for (int i2 = 0; i2 < rBBIStateTable.fNumStates; i2++) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i2);
                int i3 = i2 * numCharCategories;
                if (z) {
                    int i4 = rBBIStateDescriptor.fAccepting;
                    Assert.assrt(i4 >= 0 && i4 <= 255);
                    int i5 = rBBIStateDescriptor.fLookAhead;
                    Assert.assrt(i5 >= 0 && i5 <= 255);
                } else {
                    int i6 = rBBIStateDescriptor.fAccepting;
                    Assert.assrt(i6 >= 0 && i6 <= 65535);
                    int i7 = rBBIStateDescriptor.fLookAhead;
                    Assert.assrt(i7 >= 0 && i7 <= 65535);
                }
                char[] cArr = rBBIStateTable.fTable;
                cArr[i3] = (char) rBBIStateDescriptor.fAccepting;
                cArr[i3 + 1] = (char) rBBIStateDescriptor.fLookAhead;
                cArr[i3 + 2] = (char) rBBIStateDescriptor.fTagsIdx;
                for (int i8 = 0; i8 < numCharCategories2; i8++) {
                    if (z) {
                        int i9 = rBBIStateDescriptor.fDtran[i8];
                        Assert.assrt(i9 >= 0 && i9 <= 255);
                    }
                    rBBIStateTable.fTable[i3 + 3 + i8] = (char) rBBIStateDescriptor.fDtran[i8];
                }
            }
        }
        return rBBIStateTable;
    }

    public boolean findDuplCharClassFrom(RBBIRuleBuilder.IntPair intPair) {
        int size = this.fDStates.size();
        int numCharCategories = this.fRB.fSetBuilder.getNumCharCategories();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = intPair.first;
            if (i3 >= numCharCategories - 1) {
                return false;
            }
            int dictCategoriesStart = i3 < this.fRB.fSetBuilder.getDictCategoriesStart() ? this.fRB.fSetBuilder.getDictCategoriesStart() : numCharCategories;
            intPair.second = intPair.first + 1;
            while (intPair.second < dictCategoriesStart) {
                int i4 = 0;
                while (i4 < size) {
                    int[] iArr = this.fDStates.get(i4).fDtran;
                    int i5 = iArr[intPair.first];
                    int i6 = iArr[intPair.second];
                    if (i5 != i6) {
                        i2 = i6;
                        i = i5;
                        break;
                    }
                    i4++;
                    i2 = i6;
                    i = i5;
                }
                if (i == i2) {
                    return true;
                }
                intPair.second++;
            }
            intPair.first++;
        }
    }

    public boolean findDuplicateSafeState(RBBIRuleBuilder.IntPair intPair) {
        int i;
        int size = this.fSafeTable.size();
        while (true) {
            int i2 = intPair.first;
            if (i2 >= size - 1) {
                return false;
            }
            short[] sArr = this.fSafeTable.get(i2);
            int i3 = intPair.first;
            while (true) {
                intPair.second = i3 + 1;
                int i4 = intPair.second;
                if (i4 < size) {
                    short[] sArr2 = this.fSafeTable.get(i4);
                    int length = sArr.length;
                    for (int i5 = 0; i5 < length; i5++) {
                        short s = sArr[i5];
                        short s2 = sArr2[i5];
                        if (s != s2 && ((s != (i = intPair.first) && s != intPair.second) || (s2 != i && s2 != intPair.second))) {
                            i3 = intPair.second;
                        }
                    }
                    return true;
                }
            }
            intPair.first++;
        }
    }

    public void flagAcceptingStates() {
        int i;
        ArrayList arrayList = new ArrayList();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 6);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            RBBINode rBBINode = (RBBINode) arrayList.get(i2);
            for (int i3 = 0; i3 < this.fDStates.size(); i3++) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i3);
                if (rBBIStateDescriptor.fPositions.contains(rBBINode)) {
                    if (rBBIStateDescriptor.fAccepting == 0) {
                        int i4 = this.fLookAheadRuleMap[rBBINode.fVal];
                        rBBIStateDescriptor.fAccepting = i4;
                        if (i4 == 0) {
                            rBBIStateDescriptor.fAccepting = 1;
                        }
                    }
                    if (rBBIStateDescriptor.fAccepting == 1 && (i = rBBINode.fVal) != 0) {
                        rBBIStateDescriptor.fAccepting = this.fLookAheadRuleMap[i];
                    }
                }
            }
        }
    }

    public void flagLookAheadStates() {
        ArrayList arrayList = new ArrayList();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 4);
        for (int i = 0; i < arrayList.size(); i++) {
            RBBINode rBBINode = (RBBINode) arrayList.get(i);
            for (int i2 = 0; i2 < this.fDStates.size(); i2++) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i2);
                if (rBBIStateDescriptor.fPositions.contains(rBBINode)) {
                    rBBIStateDescriptor.fLookAhead = this.fLookAheadRuleMap[rBBINode.fVal];
                }
            }
        }
    }

    public void flagTaggedStates() {
        ArrayList arrayList = new ArrayList();
        this.fRB.fTreeRoots[this.fRootIx].findNodes(arrayList, 5);
        for (int i = 0; i < arrayList.size(); i++) {
            RBBINode rBBINode = (RBBINode) arrayList.get(i);
            for (int i2 = 0; i2 < this.fDStates.size(); i2++) {
                RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i2);
                if (rBBIStateDescriptor.fPositions.contains(rBBINode)) {
                    rBBIStateDescriptor.fTagVals.add(Integer.valueOf(rBBINode.fVal));
                }
            }
        }
    }

    public int getSafeTableSize() {
        List<short[]> list = this.fSafeTable;
        if (list == null) {
            return 0;
        }
        int i = RBBIDataWrapper.RBBIStateTable.fHeaderSize;
        int size = list.size();
        return (((this.fSafeTable.get(0).length + 3) * (size <= 255 ? 1 : 2) * size) + i + 7) & (-8);
    }

    public int getTableSize() {
        if (this.fRB.fTreeRoots[this.fRootIx] == null) {
            return 0;
        }
        int i = RBBIDataWrapper.RBBIStateTable.fHeaderSize;
        int size = this.fDStates.size();
        return (((this.fRB.fSetBuilder.getNumCharCategories() + 3) * (size <= 255 ? 1 : 2) * size) + i + 7) & (-8);
    }

    public void mapLookAheadRules() {
        this.fLookAheadRuleMap = new int[this.fRB.fScanner.numRules() + 1];
        for (RBBIStateDescriptor rBBIStateDescriptor : this.fDStates) {
            boolean z = false;
            int i = 0;
            for (RBBINode rBBINode : rBBIStateDescriptor.fPositions) {
                if (rBBINode.fType == 4) {
                    int i2 = this.fLookAheadRuleMap[rBBINode.fVal];
                    if (i2 != 0 && i == 0) {
                        i = i2;
                    }
                    z = true;
                }
            }
            if (z) {
                if (i == 0) {
                    i = this.fLASlotsInUse + 1;
                    this.fLASlotsInUse = i;
                }
                for (RBBINode rBBINode2 : rBBIStateDescriptor.fPositions) {
                    if (rBBINode2.fType == 4) {
                        int i3 = rBBINode2.fVal;
                        int[] iArr = this.fLookAheadRuleMap;
                        int i4 = iArr[i3];
                        iArr[i3] = i;
                    }
                }
            }
        }
    }

    public void mergeRuleStatusVals() {
        if (this.fRB.fRuleStatusVals.size() == 0) {
            this.fRB.fRuleStatusVals.add(1);
            this.fRB.fRuleStatusVals.add(0);
            this.fRB.fStatusSets.put(new TreeSet(), 0);
            TreeSet treeSet = new TreeSet();
            treeSet.add(0);
            this.fRB.fStatusSets.put(treeSet, 0);
        }
        for (int i = 0; i < this.fDStates.size(); i++) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i);
            SortedSet<Integer> sortedSet = rBBIStateDescriptor.fTagVals;
            Integer numValueOf = this.fRB.fStatusSets.get(sortedSet);
            if (numValueOf == null) {
                numValueOf = Integer.valueOf(this.fRB.fRuleStatusVals.size());
                this.fRB.fStatusSets.put(sortedSet, numValueOf);
                this.fRB.fRuleStatusVals.add(Integer.valueOf(sortedSet.size()));
                this.fRB.fRuleStatusVals.addAll(sortedSet);
            }
            rBBIStateDescriptor.fTagsIdx = numValueOf.intValue();
        }
    }

    public void minimizeLookaheads() {
        int i;
        int i2 = this.fLASlotsInUse;
        final int i3 = 1;
        if (i2 == 1) {
            return;
        }
        int i4 = i2 - 1;
        final int i5 = 0;
        boolean[][] zArr = (boolean[][]) Array.newInstance((Class<?>) Boolean.TYPE, i4, i4);
        for (int i6 = 2; i6 <= this.fLASlotsInUse; i6++) {
            for (final int i7 = 2; i7 <= this.fLASlotsInUse; i7++) {
                if (i7 != i6) {
                    for (int i8 = 1; i8 < this.fDStates.size(); i8++) {
                        if (this.fDStates.get(i8).fLookAhead == i6 && reachableByTransitions(i8, new Predicate(this) { // from class: com.ibm.icu.text.b
                            public final /* synthetic */ RBBITableBuilder b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                int i9 = i5;
                                int i10 = i7;
                                RBBITableBuilder rBBITableBuilder = this.b;
                                Integer num = (Integer) obj;
                                switch (i9) {
                                    case 0:
                                        return rBBITableBuilder.lambda$minimizeLookaheads$3(i10, num);
                                    default:
                                        return rBBITableBuilder.lambda$minimizeLookaheads$4(i10, num);
                                }
                            }
                        }, new Predicate(this) { // from class: com.ibm.icu.text.b
                            public final /* synthetic */ RBBITableBuilder b;

                            {
                                this.b = this;
                            }

                            @Override // java.util.function.Predicate
                            public final boolean test(Object obj) {
                                int i9 = i3;
                                int i10 = i7;
                                RBBITableBuilder rBBITableBuilder = this.b;
                                Integer num = (Integer) obj;
                                switch (i9) {
                                    case 0:
                                        return rBBITableBuilder.lambda$minimizeLookaheads$3(i10, num);
                                    default:
                                        return rBBITableBuilder.lambda$minimizeLookaheads$4(i10, num);
                                }
                            }
                        })) {
                            zArr[i6 - 2][i7 - 2] = true;
                            break;
                        }
                    }
                }
            }
        }
        int[] iArr = new int[i4];
        int i9 = 1;
        loop3: while (true) {
            Arrays.setAll(iArr, new c(i5));
            do {
                int i10 = 0;
                while (true) {
                    if (i10 >= i4) {
                        break loop3;
                    }
                    int i11 = 0;
                    while (true) {
                        if (i11 >= i4) {
                            i10++;
                        } else if (!zArr[i10][i11] || iArr[i10] != iArr[i11]) {
                            i11++;
                        }
                    }
                }
                iArr[0] = iArr[0] + 1;
                int i12 = 0;
                while (true) {
                    i = i2 - 2;
                    if (i12 >= i || iArr[i12] != i9) {
                        break;
                    }
                    iArr[i12] = 0;
                    i12++;
                    iArr[i12] = iArr[i12] + 1;
                }
            } while (iArr[i] != i9);
            i9++;
        }
        for (RBBIStateDescriptor rBBIStateDescriptor : this.fDStates) {
            int i13 = rBBIStateDescriptor.fAccepting;
            if (i13 > 1) {
                rBBIStateDescriptor.fAccepting = iArr[i13 - 2] + 2;
            }
            int i14 = rBBIStateDescriptor.fLookAhead;
            if (i14 != 0) {
                rBBIStateDescriptor.fLookAhead = iArr[i14 - 2] + 2;
            }
        }
        this.fLASlotsInUse = i9 + 1;
    }

    public void minimizeStates() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 0;
        for (int i2 = 0; i2 < this.fDStates.size(); i2++) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i2);
            ((List) linkedHashMap.computeIfAbsent(new Object(rBBIStateDescriptor.fAccepting, rBBIStateDescriptor.fLookAhead, rBBIStateDescriptor.fTagsIdx) { // from class: com.ibm.icu.text.RBBITableBuilder.1StateType
                int fAccepting;
                int fLookAhead;
                int fTagsIdx;

                {
                    this.fAccepting = i;
                    this.fLookAhead = i;
                    this.fTagsIdx = i;
                }

                public boolean equals(Object obj) {
                    if (!(obj instanceof C1StateType)) {
                        return false;
                    }
                    C1StateType c1StateType = (C1StateType) obj;
                    return this.fAccepting == c1StateType.fAccepting && this.fLookAhead == c1StateType.fLookAhead && this.fTagsIdx == c1StateType.fTagsIdx;
                }

                public int hashCode() {
                    return Objects.hash(Integer.valueOf(this.fAccepting), Integer.valueOf(this.fLookAhead), Integer.valueOf(this.fTagsIdx));
                }
            }, new d(i))).add(Integer.valueOf(i2));
        }
        ArrayList arrayList = new ArrayList();
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add((List) it.next());
        }
        while (true) {
            ArrayList arrayList2 = new ArrayList();
            int size = arrayList.size();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                int i5 = 1;
                if (i4 >= size) {
                    break;
                }
                Object obj = arrayList.get(i4);
                i4++;
                LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                for (Integer num : (List) obj) {
                    num.getClass();
                    ((List) linkedHashMap2.computeIfAbsent(lambda$minimizeStates$1(arrayList, num), new d(i5))).add(num);
                }
                i3 |= linkedHashMap2.size() <= 1 ? 0 : 1;
                Iterator it2 = linkedHashMap2.values().iterator();
                while (it2.hasNext()) {
                    arrayList2.add((List) it2.next());
                }
            }
            if (i3 == 0) {
                break;
            }
            arrayList.clear();
            arrayList.addAll(arrayList2);
        }
        for (int i6 = 0; i6 < arrayList.size(); i6++) {
            List list = (List) arrayList.get(i6);
            if (list.contains(0)) {
                arrayList.set(i6, (List) arrayList.get(0));
                arrayList.set(0, list);
            } else if (list.contains(1)) {
                arrayList.set(i6, (List) arrayList.get(1));
                arrayList.set(1, list);
            }
        }
        int[] iArr = new int[this.fDStates.size()];
        for (int i7 = 0; i7 < arrayList.size(); i7++) {
            Iterator it3 = ((List) arrayList.get(i7)).iterator();
            while (it3.hasNext()) {
                iArr[((Integer) it3.next()).intValue()] = i7;
            }
        }
        List<RBBIStateDescriptor> list2 = this.fDStates;
        this.fDStates = new ArrayList();
        int size2 = arrayList.size();
        int i8 = 0;
        while (i8 < size2) {
            Object obj2 = arrayList.get(i8);
            i8++;
            RBBIStateDescriptor rBBIStateDescriptor2 = list2.get(((Integer) ((List) obj2).get(0)).intValue());
            this.fDStates.add(rBBIStateDescriptor2);
            int i9 = 0;
            while (true) {
                int[] iArr2 = rBBIStateDescriptor2.fDtran;
                if (i9 < iArr2.length) {
                    iArr2[i9] = iArr[iArr2[i9]];
                    i9++;
                }
            }
        }
    }

    public void printPosSets(RBBINode rBBINode) {
        if (rBBINode == null) {
            return;
        }
        RBBINode.printNode(rBBINode);
        System.out.print("         Nullable:  " + rBBINode.fNullable);
        System.out.print("         firstpos:  ");
        printSet(rBBINode.fFirstPosSet);
        System.out.print("         lastpos:   ");
        printSet(rBBINode.fLastPosSet);
        System.out.print("         followpos: ");
        printSet(rBBINode.fFollowPos);
        printPosSets(rBBINode.fLeftChild);
        printPosSets(rBBINode.fRightChild);
    }

    public void printReverseTable() {
        System.out.printf("    Safe Reverse Table \n", new Object[0]);
        List<short[]> list = this.fSafeTable;
        if (list == null) {
            System.out.printf("   --- nullptr ---\n", new Object[0]);
            return;
        }
        int length = list.get(0).length;
        System.out.printf("state |           i n p u t     s y m b o l s \n", new Object[0]);
        System.out.printf("      | Acc  LA    Tag", new Object[0]);
        for (int i = 0; i < length; i++) {
            System.out.printf(" %2d", Integer.valueOf(i));
        }
        System.out.printf("\n", new Object[0]);
        System.out.printf("      |---------------", new Object[0]);
        for (int i2 = 0; i2 < length; i2++) {
            System.out.printf("---", new Object[0]);
        }
        System.out.printf("\n", new Object[0]);
        for (int i3 = 0; i3 < this.fSafeTable.size(); i3++) {
            short[] sArr = this.fSafeTable.get(i3);
            System.out.printf("  %3d | ", Integer.valueOf(i3));
            System.out.printf("%3d %3d %5d ", 0, 0, 0);
            for (int i4 = 0; i4 < length; i4++) {
                System.out.printf(" %2d", Short.valueOf(sArr[i4]));
            }
            System.out.printf("\n", new Object[0]);
        }
        System.out.printf("\n\n", new Object[0]);
    }

    public void printRuleStatusTable() {
        List<Integer> list = this.fRB.fRuleStatusVals;
        System.out.print("index |  tags \n");
        System.out.print("-------------------\n");
        int i = 0;
        while (i < list.size()) {
            int iIntValue = list.get(i).intValue() + i + 1;
            RBBINode.printInt(i, 7);
            while (true) {
                i++;
                if (i < iIntValue) {
                    RBBINode.printInt(list.get(i).intValue(), 7);
                }
            }
            System.out.print("\n");
            i = iIntValue;
        }
        System.out.print("\n\n");
    }

    public void printSet(Collection<RBBINode> collection) {
        Iterator<RBBINode> it = collection.iterator();
        while (it.hasNext()) {
            RBBINode.printInt(it.next().fSerialNum, 8);
        }
        System.out.println();
    }

    public void printStates() {
        System.out.print("state |           i n p u t     s y m b o l s \n");
        System.out.print("      | Acc  LA    Tag");
        for (int i = 0; i < this.fRB.fSetBuilder.getNumCharCategories(); i++) {
            RBBINode.printInt(i, 4);
        }
        System.out.print("\n");
        System.out.print("      |---------------");
        for (int i2 = 0; i2 < this.fRB.fSetBuilder.getNumCharCategories(); i2++) {
            System.out.print("----");
        }
        System.out.print("\n");
        for (int i3 = 0; i3 < this.fDStates.size(); i3++) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i3);
            RBBINode.printInt(i3, 5);
            System.out.print(" | ");
            RBBINode.printInt(rBBIStateDescriptor.fAccepting, 3);
            RBBINode.printInt(rBBIStateDescriptor.fLookAhead, 4);
            RBBINode.printInt(rBBIStateDescriptor.fTagsIdx, 6);
            System.out.print(Padder.FALLBACK_PADDING_STRING);
            for (int i4 = 0; i4 < this.fRB.fSetBuilder.getNumCharCategories(); i4++) {
                RBBINode.printInt(rBBIStateDescriptor.fDtran[i4], 4);
            }
            System.out.print("\n");
        }
        System.out.print("\n\n");
    }

    public void removeColumn(int i) {
        int size = this.fDStates.size();
        for (int i2 = 0; i2 < size; i2++) {
            RBBIStateDescriptor rBBIStateDescriptor = this.fDStates.get(i2);
            int[] iArr = rBBIStateDescriptor.fDtran;
            int[] iArrCopyOf = Arrays.copyOf(iArr, iArr.length - 1);
            System.arraycopy(rBBIStateDescriptor.fDtran, i + 1, iArrCopyOf, i, iArrCopyOf.length - i);
            rBBIStateDescriptor.fDtran = iArrCopyOf;
        }
    }

    public int removeDuplicateStates() {
        int size = this.fDStates.size();
        minimizeStates();
        return this.fDStates.size() - size;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void removeSafeState(RBBIRuleBuilder.IntPair intPair) {
        int i = intPair.first;
        int i2 = intPair.second;
        this.fSafeTable.remove(i2);
        int size = this.fSafeTable.size();
        for (int i3 = 0; i3 < size; i3++) {
            short[] sArr = this.fSafeTable.get(i3);
            for (int i4 = 0; i4 < sArr.length; i4++) {
                short s = sArr[i4];
                if (s == i2) {
                    s = i;
                } else if (s > i2) {
                    s--;
                }
                sArr[i4] = (short) s;
            }
        }
    }
}
