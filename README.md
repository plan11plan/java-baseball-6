# 미션 - 숫자 야구

## 🔍 진행 방식

- 미션은 **기능 요구 사항, 프로그래밍 요구 사항, 과제 진행 요구 사항** 세 가지로 구성되어 있다.
- 세 개의 요구 사항을 만족하기 위해 노력한다. 특히 기능을 구현하기 전에 기능 목록을 만든다.
- 기능 요구 사항에 기재되지 않은 내용은 스스로 판단하여 구현한다.

## 📮 미션 제출 방법

- 미션 구현을 완료한 후 GitHub을 통해 제출해야 한다.
    - GitHub을 활용한 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고해
      제출한다.
- GitHub에 미션을 제출한 후 [우아한테크코스 지원](https://apply.techcourse.co.kr) 사이트에 접속하여 프리코스 과제를 제출한다.
    - 자세한 방법은 [제출 가이드](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse#제출-가이드) 참고
    - **Pull Request만 보내고 지원 플랫폼에서 과제를 제출하지 않으면 최종 제출하지 않은 것으로 처리되니 주의한다.**

## 🚨 과제 제출 전 체크 리스트 - 0점 방지

- 기능 구현을 모두 정상적으로 했더라도 **요구 사항에 명시된 출력값 형식을 지키지 않을 경우 0점으로 처리**한다.
- 기능 구현을 완료한 뒤 아래 가이드에 따라 테스트를 실행했을 때 모든 테스트가 성공하는지 확인한다.
- **테스트가 실패할 경우 0점으로 처리**되므로, 반드시 확인 후 제출한다.

### 테스트 실행 가이드

- 터미널에서 `java -version`을 실행하여 Java 버전이 17인지 확인한다.
  Eclipse 또는 IntelliJ IDEA와 같은 IDE에서 Java 17로 실행되는지 확인한다.
- 터미널에서 Mac 또는 Linux 사용자의 경우 `./gradlew clean test` 명령을 실행하고,
  Windows 사용자의 경우 `gradlew.bat clean test` 또는 `./gradlew.bat clean test` 명령을 실행할 때 모든 테스트가 아래와 같이 통과하는지 확인한다.

```
BUILD SUCCESSFUL in 0s
```

---

## 🚀 기능 요구 사항

기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.

- 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
    - 예) 상대방(컴퓨터)의 수가 425일 때
        - 123을 제시한 경우 : 1스트라이크
        - 456을 제시한 경우 : 1볼 1스트라이크
        - 789를 제시한 경우 : 낫싱
- 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 서로 다른 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한
  결과를 출력한다.
- 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
- 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 서로 다른 3자리의 수
- 게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

#### 출력

- 입력한 수에 대한 결과를 볼, 스트라이크 개수로 표시

```
1볼 1스트라이크
```

- 하나도 없는 경우

```
낫싱
```

- 3개의 숫자를 모두 맞힐 경우

```
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
```

- 게임 시작 문구 출력

```
숫자 야구 게임을 시작합니다.
``` 

#### 실행 결과 예시

```
숫자 야구 게임을 시작합니다.
숫자를 입력해주세요 : 123
1볼 1스트라이크
숫자를 입력해주세요 : 145
1볼
숫자를 입력해주세요 : 671
2볼
숫자를 입력해주세요 : 216
1스트라이크
숫자를 입력해주세요 : 713
3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요 : 123
1볼
...
```

---

## 🎯 프로그래밍 요구 사항

- JDK 17 버전에서 실행 가능해야 한다. **JDK 17에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Java 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/master/styleguide/java) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

```java
List<Integer> computer = new ArrayList<>();
while (computer.size() < 3) {
    int randomNumber = Randoms.pickNumberInRange(1, 9);
    if (!computer.contains(randomNumber)) {
        computer.add(randomNumber);
    }
}
```

---

## ✏️ 과제 진행 요구 사항

- 미션은 [java-baseball-6](https://github.com/woowacourse-precourse/java-baseball-6) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.

---

# Me. 고민됐던 부분들

## Infrastructure Layer
🔥 랜덤숫자생성기의 초기화 변수들을 어떻게 받을까? 생성자 vs 메서드 파라미터
> 생성자 초기화 방법을 권장합니다. 게임의 룰은 정하는 역할 특성상, 불변객체의 장점인 일관성과 상태 캡슐화의 장점이 반드시 필요하다고 판단됩니다.

### 1️⃣ 생성자로 변수 초기화
````java
public class RandomNumberGenerator {
    private final int count;
    private final int min;
    private final int max;

    public RandomNumberGenerator(int count, int min, int max) {
        this.count = count;
        this.min = min;
        this.max = max;
    }

    public List<Integer> generateUniqueNumbers() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() <count) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
````
### 2️⃣ 메서드 파라미터로 변수 초기화
````java
public class RandomNumberGenerator {
    
    public List<Integer> generateUniqueNumbers(int count, int min, int max) {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() <count) {
            int randomNumber = Randoms.pickNumberInRange(min, max);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
````

### ❓도메인 불변성(불변 객체)을 지키는가

1️⃣ 생성자로 변수 초기화
> 도메인 불변성을 지킵니다.  게임의 규칙(숫자의 개수,범위)이 게임 중에 변경되지 않아야 하므로, 객체 생성 시 이를 고정하는 것이 도메인 규칙을 더 잘 표현합니다.
> 객체가 생성될 때 도메인 규칙이 캡슐화되어, 도메인의 불변성과 일관성 원칙을 준수합니다. 즉, 의도가 명확하고 제약조건이 명확해집니다.

2️⃣ 메서드 파라미터로 변수 초기화
> 도메인 불변성을 못 지킵니다. 도메인 로직이 메서드 호출 시마다 달라질 수 있어, 불변성과 일관성 측면에서 약점이 있습니다.

생성자 초기화 방법이 더 도메인 규칙을 표현합니다. 
야구게임에서 룰이 바뀌는일은 잘 없기 때문에, 일관적이고 캡슐화가 되어있고 의도가 명확한 생성자 초기화가 좋다고 판단됩니다.

---

### ❓ 재사용성이 좋은가?
재사용성은  동일한 설정일때와 바뀐 설정일때의 재사용성으로 나눌 수 있습니다.

1️⃣ 생성자로 변수 초기화
>불변 객체 이므로, 동일한 설정일때의 재사용성은 좋지만, 바뀐 설정일때는 새로운 객체를 생성해야 합니다.

2️⃣ 메서드 파라미터로 변수 초기화
> 상태를 유지하지 않으므로, 바뀐 설정일때의 재사용성이 좋지만, 동일한 설정일때는 똑같은 숫자를 넣어줘야 하므로 재사용성이 좋지 않습니다.

생성자 초기화 방법이 이 야구게임에서 재사용성이 좋은 것 같습니다. 오히려 동적으로 바뀔 수 있으면 버그를 야기할 가능성이 있다고 생각됩니다.

