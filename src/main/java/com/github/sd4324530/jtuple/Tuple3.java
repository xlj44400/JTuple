package com.github.sd4324530.jtuple;

import java.util.List;

import static java.util.Objects.requireNonNull;

/**
 * 表示有3个元素的元组类型
 * 可迭代
 * 不可变，线程安全
 *
 * @author peiyu
 */
public final class Tuple3<A, B, C> extends Tuple {

    public final A first;
    public final B second;
    public final C third;

    private Tuple3(final A first, final B second, final C third) {
        super(first, second, third);
        this.first = first;
        this.second = second;
        this.third = third;
    }

    /**
     * 创建一个包含3个元素的元组
     *
     * @param first  第一个元素
     * @param second 第二个元素
     * @param third  第三个元素
     * @param <A>    第一个元素类型
     * @param <B>    第二个元素类型
     * @param <C>    第三个元素类型
     * @return 元组
     * @see Tuples#tuple(Object, Object, Object)
     */
    public static <A, B, C> Tuple3<A, B, C> with(final A first, final B second, final C third) {
        return new Tuple3<>(first, second, third);
    }

    /**
     * 通过列表创建一个包含3个元素的元组
     * 包含的元素是列表的前三个元素，如果不存在，则为null
     *
     * @param list 列表
     * @param <A>  第一个元素类型
     * @param <B>  第二个元素类型
     * @param <C>  第三个元素类型
     * @return 元组
     */
    @SuppressWarnings("unchecked")
    public static <A, B, C> Tuple3<A, B, C> with(final List<Object> list) {
        requireNonNull(list, "list is null");
        switch (list.size()) {
            case 0:
                return new Tuple3<>(null, null, null);
            case 1:
                return new Tuple3<>((A) list.get(0), null, null);
            case 2:
                return new Tuple3<>((A) list.get(0), (B) list.get(1), null);
        }
        return new Tuple3((A) list.get(0), (B) list.get(1), (C) list.get(2));
    }

    /**
     * 反转元组
     *
     * @return 反转后的元组
     */
    @Override
    public Tuple3<C, B, A> swap() {
        return Tuple3.with(this.third, this.second, this.first);
    }
}
