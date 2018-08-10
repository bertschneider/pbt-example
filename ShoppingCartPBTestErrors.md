# Shopping Cart PBT Errors

# The current model is to simple
```
java.lang.AssertionError: Property falsified after 3 example(s) 
Smallest found falsifying value(s) :-
[AddCommand{name='', cost=EUR 1, amount=1}, AddCommand{name='', cost=EUR 1, amount=1}]
Cause was :-
java.lang.AssertionError: Expected EUR 1 to be EUR 2 after AddCommand{name='', cost=EUR 1, amount=1}
 Ran 1 steps before before failure.
	at org.quicktheories.core.stateful.Sequential.modelCheck(Sequential.java:32)
	at de.codecentric.pbt.shoppingcart.ShoppingCartPBTest.lambda$sequential$2(ShoppingCartPBT.java:50)
	at org.quicktheories.dsl.TheoryBuilder.lambda$checkAssert$7(TheoryBuilder.java:145)
	at org.quicktheories.impl.Property.tryFalsification(Property.java:23)
	at org.quicktheories.impl.Core.shrink(Core.java:111)
	at org.quicktheories.impl.Core.run(Core.java:39)
	at org.quicktheories.impl.TheoryRunner.check(TheoryRunner.java:35)
	at org.quicktheories.dsl.TheoryBuilder.check(TheoryBuilder.java:132)
	at org.quicktheories.dsl.TheoryBuilder.checkAssert(TheoryBuilder.java:144)
	at de.codecentric.pbt.shoppingcart.ShoppingCartPBTest.sequential(ShoppingCartPBT.java:49)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:564)
	at org.junit.platform.commons.util.ReflectionUtils.invokeMethod(ReflectionUtils.java:513)
	at org.junit.jupiter.engine.execution.ExecutableInvoker.invoke(ExecutableInvoker.java:115)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.lambda$invokeTestMethod$6(TestMethodTestDescriptor.java:170)
	at org.junit.jupiter.engine.execution.ThrowableCollector.execute(ThrowableCollector.java:40)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.invokeTestMethod(TestMethodTestDescriptor.java:166)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:113)
	at org.junit.jupiter.engine.descriptor.TestMethodTestDescriptor.execute(TestMethodTestDescriptor.java:58)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.lambda$executeRecursively$3(HierarchicalTestExecutor.java:113)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.executeRecursively(HierarchicalTestExecutor.java:108)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.execute(HierarchicalTestExecutor.java:79)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.lambda$executeRecursively$2(HierarchicalTestExecutor.java:121)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177)
	at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133)
	at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1801)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:430)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.lambda$executeRecursively$3(HierarchicalTestExecutor.java:121)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.executeRecursively(HierarchicalTestExecutor.java:108)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.execute(HierarchicalTestExecutor.java:79)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.lambda$executeRecursively$2(HierarchicalTestExecutor.java:121)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:184)
	at java.base/java.util.stream.ReferencePipeline$2$1.accept(ReferencePipeline.java:177)
	at java.base/java.util.Iterator.forEachRemaining(Iterator.java:133)
	at java.base/java.util.Spliterators$IteratorSpliterator.forEachRemaining(Spliterators.java:1801)
	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:484)
	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:474)
	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:151)
	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:174)
	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:430)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.lambda$executeRecursively$3(HierarchicalTestExecutor.java:121)
	at org.junit.platform.engine.support.hierarchical.SingleTestExecutor.executeSafely(SingleTestExecutor.java:66)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.executeRecursively(HierarchicalTestExecutor.java:108)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor$NodeExecutor.execute(HierarchicalTestExecutor.java:79)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestExecutor.execute(HierarchicalTestExecutor.java:55)
	at org.junit.platform.engine.support.hierarchical.HierarchicalTestEngine.execute(HierarchicalTestEngine.java:43)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:170)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:154)
	at org.junit.platform.launcher.core.DefaultLauncher.execute(DefaultLauncher.java:90)
	at com.intellij.junit5.JUnit5IdeaTestRunner.startRunnerWithArgs(JUnit5IdeaTestRunner.java:74)
	at com.intellij.rt.execution.junit.IdeaTestRunner$Repeater.startRunnerWithArgs(IdeaTestRunner.java:47)
	at com.intellij.rt.execution.junit.JUnitStarter.prepareStreamsAndStart(JUnitStarter.java:242)
	at com.intellij.rt.execution.junit.JUnitStarter.main(JUnitStarter.java:70)

Other found falsifying value(s) :- 
[AddCommand{name='', cost=EUR 2, amount=1}, AddCommand{name='', cost=EUR 2, amount=1}]
[AddCommand{name='', cost=EUR 114, amount=1}, AddCommand{name='', cost=EUR 114, amount=1}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=1}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=1}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=1}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=1}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=5}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=6}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=10}]
[AddCommand{name='', cost=EUR 127, amount=1}, AddCommand{name='', cost=EUR 127, amount=10}]
 
Seed was 3418444384831
```

# Race condition on reset
```
```
