package com.sky.test.stream;

import com.sky.test.entity.Student;
import com.sky.test.entity.Trader;
import com.sky.test.entity.Transaction;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Directions 流操作 - 练习
 * @Author H
 * @Date 2021/4/4 16:55
 * @Version 1.0
 */
public class Stream_07 {

    public static void main(String[] args) {

        List<Student> students = Arrays.asList(
                new Student("peter", 25, "man", Student.Status.BUSY),
                new Student("davi", 20, "man", Student.Status.VOCATION),
                new Student("jessie", 22, "man", Student.Status.FREE),
                new Student("anne", 18, "woman", Student.Status.BUSY),
                new Student("kate", 23, "woman", Student.Status.FREE),
                new Student("lady", 23, "woman", Student.Status.VOCATION)
        );

        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        // 把一个集合中的数据转换成平方数
        System.out.println(Arrays.asList(1, 2, 3, 4, 5).stream().map(x -> x * x).collect(Collectors.toList()));
        // 用 map 和 reduce 方法数一数流中有多少个对象
        System.out.println(students.stream().map(student -> 1).reduce(Integer::sum).get());
        // 找出 2011 年发生的所有交易，并按交易额排序（从低到高）
        transactions.stream().filter(transaction -> transaction.getYear() == 2011).sorted((t2, t1) -> Integer.compare(t1.getValue(), t2.getValue())).forEach(System.out::println);
        // 交易员都在哪些不同的城市工作过
        transactions.stream().map(transaction -> transaction.getTrader().getCity()).distinct().forEach(System.out::println);
        // 查出来自剑桥的交易员，并按姓名排序
        transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getTrader).distinct().sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).forEach(System.out::println);
        // 返回所有交易员的姓名字符串，按字母顺序排序
        transactions.stream().map(transaction -> transaction.getTrader().getName())
                .distinct().sorted().forEach(System.out::println);
        // 有没有交易员是在米兰工作的
        System.out.println(transactions.stream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan")));
        // 打印生活在剑桥交易员的所有交易额
        System.out.println(transactions.stream().filter(transaction -> transaction.getTrader().getCity().equals("Cambridge")).map(Transaction::getValue).reduce(Integer::sum).get());
        // 所有交易额中，最高的交易额是多少
        System.out.println(transactions.stream().map(Transaction::getValue).reduce(Integer::max).get());
        // 找到交易额最小的交易
        System.out.println(transactions.stream().min((t1, t2) -> Integer.compare(t1.getValue(), t2.getValue())).get());
    }

}
