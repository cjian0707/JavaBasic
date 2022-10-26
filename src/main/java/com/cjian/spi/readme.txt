什么是SPI？
    SPI的英文全称就是Service Provider Interface，这是一种将服务接口与服务实现分离以达到解耦、可拔插、以最大提升程序可扩展性的机制，
这个机制最大的优点就是无须在代码里指定，进而避免了代码污染，实现了模块的可拔插。在JDK、Spring、SpringBoot、Dubbo中都有着它的身影。

为什么会有SPI？
    java中加载类的方式使用的双亲委派，而在双亲委派模型中，子类加载器可以使用父类加载器已经加载的类，而父类加载器无法使用子类加载器已经加载的类。这就导致了双亲委派模型并不能解决所有的类加载器问题。
Java 提供了很多服务提供者接口(Service Provider Interface，SPI)，允许第三方为这些接口提供实现。
常见的 SPI 有 JDBC、JNDI、JAXP 等，这些SPI的接口由核心类库提供，却由第三方实现，这样就存在一个问题：SPI 的接口是 Java 核心库的一部分，是由BootstrapClassLoader加载的；
SPI实现的Java类一般是由AppClassLoader来加载的。BootstrapClassLoader是无法找到 SPI 的实现类的，因为它只加载Java的核心库。它也不能代理给AppClassLoader，因为它是最顶层的类加载器。
也就是说，双亲委派模型并不能解决这个问题。所以jdk为我们缇提供了SPI，来打破双亲委派模式。

如何使用SPI？
    使用线程上下文类加载器(ContextClassLoader)加载：如果不做任何的设置，Java应用的线程的上下文类加载器默认就是AppClassLoader。
在核心类库使用SPI接口时，传递的类加载器使用线程上下文类加载器，就可以成功的加载到SPI实现的类。线程上下文类加载器在很多SPI的实现中都会用到。
通常我们可以通过Thread.currentThread().getClassLoader()和Thread.currentThread().getContextClassLoader()获取线程上下文类加载器。

类加载机制、双亲委派以及spi介绍：
https://baijiahao.baidu.com/s?id=1718315759630025016&wfr=spider&for=pc