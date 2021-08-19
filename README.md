### Manifold -> Lombok NPE

This repo helps to reproduce NPE while using both Manifold and Lombok.

#### Installation

```bash
git clone https://github.com/sskorol/manifold-lombok-issue.git && cd manifold-lombok-issue
```

#### Running

```bash
./gradlew clean classes
```

It fails with the following exception:
```bash
Exception while resolving: NODE LOCAL (class com.sun.tools.javac.tree.JCTree$JCVariableDecl) @val()
final ___Lombok_VAL_Attrib__ estimatedSum = 100.0(SimpleFileObject[/projects/home/manifold-lombok-issue/model/src/main/java/io/github/sskorol/model/entity/InputEntity.java])
```
