package com.example.practice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 函数式接口
 * 消费型8个 /Consumer<T>： Consumer<T>、IntConsumer、LongConsumer、DoubleConsumer
 *          BiConsumer    BiConsumer<T,U>、ObjIntConsumer、ObjLongConsumer、ObjDoubleConsumer
 * 生产型5个 /Supplier<T>：Supplier<T>、IntSupplier、LongSupplier、DoubleSupplier、BooleanSupplier
 * 函数型17个/Function<T,R>：Function<T,R>、IntFunction<R>、LongFunction<R>、DoubleFunction<R>、ToIntFunction<T>、ToLongFunction<T>、ToDoubleFunction<T>
 *                         IntToDoubleFunction、IntToLongFunction、LongToIntFunction、LongToDoubleFunction、DoubleToIntFunction、DoubleToLongFunction
 *           BiFunction    BiFunction<T,U,R>、ToDoubleBiFunction<T,U>、ToIntBiFunction<T,U>、ToLongBiFunction<T,U>
 * 断定型5个 /Predicate<T>:Predicate<T>、IntPredicate、LongPredicate、DoublePredicate
 *           BiPredicate BiPredicate<T,U>
 *
 * 生产型子接口8个（出入参类型一致）
 *              二元操作 BinaryOperator<T>、IntBinaryOperator、LongBinaryOperator、DoubleBinaryOperator
 *              一元操作 UnaryOperator<T>、IntUnaryOperator、LongUnaryOperator、DoubleUnaryOperator
 *
 */
public class FunctionalTest {
    public static void main(String[] args) {
        // ::关键字 表示 隐式的lamda表达式
        List<String> list = Arrays.asList("1","2","3");
        List collect = list.stream().map(String::toUpperCase).collect(Collectors.toList());
                // 等价于 入参String类型，返回值是toUpperCase的返回型
        List collect2 = list.stream().map(s ->s.toUpperCase()).collect(Collectors.toList());
    }
}
