# TddStudy 프로젝트

이 프로젝트는 Spring Boot, JPA, Kotlin, Gradle을 기반으로 한 백엔드 애플리케이션입니다.

## 주요 기술 스택

- Java 17
- Kotlin
- Spring Boot 3.5.3
- Spring Data JPA
- H2 Database (개발/테스트용 인메모리 DB)
- Gradle (Kotlin DSL)
- JaCoCo (테스트 커버리지)
- Spotless (코드 포맷팅)
- PITest (Mutation Testing)

## 빌드 및 테스트

| 작업          | 명령어                       | 설명                                 |
|-------------|---------------------------|------------------------------------|
| 전체 빌드 및 테스트 | `./gradlew testAndBuild`  | 전체 빌드, 테스트, 커버리지 검증까지 수행           |
| 테스트만 실행     | `./gradlew test`          | 단위 테스트 실행 및 커버리지 리포트 생성            |
| 코드 포맷팅 체크   | `./gradlew spotlessCheck` | 코드 스타일 검사                          |
| 결함 삽입 테스트   | `./gradlew pitest -Doverride.pitest.reportDir=build/pitReport`                         | 코드를 변화시켜 테스트가 실패하도록 유도하여 테스트 결함 발견 |

### 전체 빌드 및 테스트 순서
`build` 명령어 실행 시 아래 순서로 작업이 자동 수행됩니다.
> build.gradle.kts에 task 순서가 설정되어 있습니다.

1. **코드 포맷팅 체크**  
   `spotlessCheck` 작업이 먼저 실행되어 코드 스타일이 올바른지 확인합니다.

2. **테스트 실행**  
   `test` 작업이 실행되어 모든 단위 테스트가 수행됩니다.   

3. **테스트 커버리지 리포트 생성**  
   테스트가 끝나면 `jacocoTestReport` 작업이 실행되어 커버리지 리포트가 생성됩니다.
   테스트 후 커버리지 리포트는 `build/reports/jacoco/test/html/index.html`에서 확인할 수 있습니다.
   CLI output에 파일 링크가 출력됩니다.

4. **테스트 커버리지 검증**  
   `jacocoTestCoverageVerification` 작업이 실행되어 커버리지가 80% 이상인지 검증합니다.  
   기준 미달 시 빌드가 실패합니다.

5. **빌드**  
   위 모든 작업이 성공적으로 완료되면 최종적으로 빌드가 진행됩니다.

## 개발 환경

- JDK 17 이상 필요
- 로컬 개발 시 H2 데이터베이스 사용

## 기타

- 테스트 커버리지는 80% 이상이어야 빌드가 통과합니다.
- 코드 스타일은 Google Java Style 및 Ktlint를 적용합니다.
- `com.koreaap.itdev2.TddStudyApplication` 클래스는 JaCoCo 커버리지에서 제외됩니다.

## CI(지속적 통합) 워크플로우

본 프로젝트는 GitHub Actions를 이용한 CI 파이프라인을 제공합니다.  
아래 브랜치에 대해 PR 또는 푸시가 발생하면 자동으로 테스트가 실행됩니다.<br>
> `.github/workflows/ci.yml` 파일에 정의되어 있습니다.

- main
- develop

### 주요 동작

1. **Gradle 컨테이너 환경에서 실행**  
   `gradle:8.7-jdk17` 이미지를 사용하여 일관된 빌드 환경을 제공합니다.

2. **Gradle 패키지 캐싱**  
   빌드 속도 향상을 위해 Gradle 캐시를 사용합니다.

3. **테스트 자동 실행**  
   `gradle test` 명령어로 모든 테스트가 자동으로 실행되어 코드 품질을 검증합니다.

CI 결과는 GitHub PR 및 커밋에서 확인할 수 있습니다.
