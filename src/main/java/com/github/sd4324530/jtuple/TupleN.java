package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有N个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class TupleN extends Tuple {

    private TupleN(final Object... args) {
        super(args);
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public TupleN swap() {
        final Object[] array = new Object[this.size()];
        this.forEachWithIndex((index, obj) -> array[array.length - 1 - index] = obj);
        return TupleN.with(array);
    }

    /**
     * 从一个数组生成一个元组
     *
     * @param args 数组
     * @return 元组
     * @see Tuples#tuple(Object...)
     */
    public static TupleN with(final Object... args) {
        requireNonNull(args, "args is null");
        return new TupleN(args);
    }

    /**
     * 从一个列表生成一个元组,元组大小等于列表大小
     *
     * @param list 列表
     * @return 元组
     * @see Tuples#tuple(List)
     */
    public static TupleN withList(final List<Object> list) {
        requireNonNull(list, "list is null");
        return TupleN.with(list.toArray());
    }
}
