# JUnit5 new feature suburi.

## features

### Parallel test run
* src/test/resources/junit-platform.properties の `junit.jupiter.execution.parallel.enabled=true`をコメントアウトすると挙動が変わる
  * コメントアウトするとテストの実行が直列になり4sかかる
  * 並列化が有効な場合、スリープしていても1sで終わる

## reference sites.
* [JUnit User Guide](https://junit.org/junit5/docs/5.3.0/user-guide/index.html#writing-tests-parallel-execution)
*
