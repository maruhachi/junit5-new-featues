# JUnit5 new feature suburi.

## features

### Parallel test run
* src
  * test/resources/junit-platform.properties
  * test/java/tech/yko/javaspock/service/HomeServiceImplTest.java
 
* .propertiesの `junit.jupiter.execution.parallel.enabled=true`をコメントアウトすると挙動が変わる
  * コメントアウトするとテストの実行が直列になり4sかかる
  * 並列化が有効な場合、スリープしていても1sで終わる

* もともとあった並列化として、`surefire-plugin`の機能 `forkCount` がある
  * JUnit5で試すとどうもうまくいかなかった(Tests run:0 となる...)
  * [JUnit4で検証。](https://github.com/maruhachi/kube-ope-test/commit/bc9b47450ae03894500edbdc76341bdb01a4c976)

**`$ mvn clean test -T 4`**
```bash
[INFO] Scanning for projects...
[INFO] 
[INFO] Using the MultiThreadedBuilder implementation with a thread count of 4

## 有効
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running me.ykon.kubeopetest.Parallel2Test
[INFO] Running me.ykon.kubeopetest.ParallelTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.299 s - in me.ykon.kubeopetest.ParallelTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.378 s - in me.ykon.kubeopetest.Parallel2Test
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 24.375 s (Wall Clock)
[INFO] Finished at: 2018-09-07T13:23:46+09:00
[INFO] Final Memory: 44M/454M
[INFO] ------------------------------------------------------------------------

## 無効
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running me.ykon.kubeopetest.Parallel2Test
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.141 s - in me.ykon.kubeopetest.Parallel2Test
[INFO] Running me.ykon.kubeopetest.ParallelTest
[INFO] Tests run: 4, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 3.938 s - in me.ykon.kubeopetest.ParallelTest
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 8, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 30.232 s (Wall Clock)
[INFO] Finished at: 2018-09-07T13:20:25+09:00
[INFO] Final Memory: 44M/469M
[INFO] ------------------------------------------------------------------------
```

### Catch system.out
* src
  * ??

* 標準出力を補足できるようになった
  * [12factor appのLogsの章](https://12factor.net/ja/logs)にはログは標準出力とすべし、とある
  * これを加味すると、テストで標準出力がテストできるのは心強い点となろう


## reference sites.
* [JUnit User Guide](https://junit.org/junit5/docs/5.3.0/user-guide/index.html#writing-tests-parallel-execution)
* [surefire-plugin - Fork option and parallel execution](https://maven.apache.org/surefire/maven-surefire-plugin/examples/fork-options-and-parallel-execution.html#)
