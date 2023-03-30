import objectClass.Person;

import java.util.Optional;

public class OptionalDemo {

    public static void main(String[] args) {

        //Optional 是个容器：它可以保存类型T的值，或者仅仅保存null。Optional提供很多有用的方法，这样我们就不用显式进行空值检测。
        //Optional 类的引入很好的解决空指针异常
        /**
         * Optional创建对象 三个静态方法  :
         *                          empty()创建一个空的Optional实例。
         *                          of(T t)创建一个Optional实例，t必须非空。
         *                          ofNullable(T t)创建一个Optional实力，t可以为空；
         * */

        Person p = new Person();
        p.setAge(18);
        p.setName("air jodrn");
        p.setSex("man");
        Optional.of(p);
        //报异常：java.util.Objects.requireNonNull
        //Optional.of(null);
        Optional.ofNullable(p);
        Optional.ofNullable(null);
        Optional.empty();

        /**
         * Optional判断容器是否包含对象方法：
         *                          boolean isPresent() : 判断是否包含对象（包含true;不包含false）
         *                          void ifPresent(Consumer<? super T> consumer) ：如果有值，就执行Consumer接口的实现代码，并且该值会作为参数传给它。
         * */
        Optional<Object> empty = Optional.empty();
        boolean present = empty.isPresent();
        System.out.println("没有添加对象 Optional.isPresent():" + present);
        Optional<Person> p1 = Optional.ofNullable(p);
        System.out.println("添加new对象 Optional.isPresent():" + p1.isPresent());


        /**
         * 获取Optional容器的对象：
         *                   T get(): 如果调用对象包含值，返回该值，否则抛异常
         *                   T orElse(T other) ：如果有值则将其返回，否则返回指定的other对象
         *                   T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
         *                   T orElseThrow(Supplier<? extends X> exceptionSupplier) ：如果有值则将其返回，否则抛出由Supplier接口实现提供的异常。
         * */
        //java.util.NoSuchElementException: No value present
        //empty.get();
        //System.out.println("空对象 Optional.isPresent():" + empty.get());
        p1.get();
        System.out.println("非空对象 Optional.isPresent():" + p1.get());
        System.out.println("非空对象 Optional.isPresent():" + p1.get().getName());
        System.out.println("非空对象 Optional.isPresent():" + p1.get().getSex());
        System.out.println("非空对象 Optional.isPresent():" + p1.get().getAge());


        //可以为空的情况
        Optional<Object> o = Optional.ofNullable(null);
        //java.util.NoSuchElementException: No value present
        //System.out.println(o.get());

        Person person = p1.orElse(p);
        System.out.println(person);


        //T orElse(T other) ：
        boolean present1 = Optional.ofNullable(p).isPresent();
        if (present1) {
            Object o1 = Optional.ofNullable(null).orElse(new Person("dog", 1, "women"));
            System.out.println(o1.toString());
        }
        //T orElseGet(Supplier<? extends T> other) ：如果有值则将其返回，否则返回由Supplier接口实现提供的对象。
        // orElseGet就是当student为空的时候，返回通过Supplier供应商函数创建的对象
        boolean present2 = Optional.ofNullable(p).isPresent();
        if (present2) {
            Object o2 = Optional.ofNullable(null).orElseGet(() -> new Person("dogggggggggg", 1, "women"));
            System.out.println(o2.toString());
        }


        /**
         * 过滤：
         *          Optional<T> filter(Predicate<? super <T> predicate)：如果值存在，并且这个值匹配给定的 predicate，返回一个Optional用以描述这个值，否则返回一个空的Optional。
         *
         *
         * 映射
         *
         * <U>Optional<U> map(Function<? super T,? extends U> mapper)：如果有值，则对其执行调用映射函数得到返回值。如果返回值不为 null，则创建包含映射返回值的Optional作为map方法返回值，否则返回空Optional。
         * <U> Optional<U> flatMap(Function<? super T, Optional<U>> mapper)：如果值存在，就对该值执行提供的mapping函数调用，返回一个Optional类型的值，否则就返回一个空的Optional对象\
         *
         * */

        Optional.ofNullable(null).isPresent();


    }








}
