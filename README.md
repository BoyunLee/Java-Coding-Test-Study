# 자바 코테 스터디 (IT's your life 5기)
2024년 알고리즘 스터디: "[Do it! 알고리즘 코딩테스트 자바편]
<br>
<br>
필수 문법 정리 Notion: https://maddening-bowler-d9b.notion.site/2b5bf40acfd7482ea632c41bfd4646b5

<br>
<br>

## 📍팀원


|  | 박수빈 | 서석현 | 공희진 | 배광민 |
| --- | --- | --- | ---| ---|
| 이메일 | subin4420@gmail.com | 3 | gmlwls3379@naver.com | qoendqh@naver.com |
| Git | https://github.com/subin4420 | 6 | https://github.com/heejinkong | https://github.com/pangminwhere |

|  | 백도현 | 오상민 | 오수민 | 이보윤 |
| --- | --- | --- | ---| ---|
| 이메일 | dh1010a@naver.com | osm0348@naver.com |fivesoomin@gmail.com|qhdbs0802@naver.com|
| Git | https://github.com/dh1010a | https://github.com/Asthux |https://github.com/ssooomm|https://github.com/BoyunLee|


<br>

<br>


## 📍스터디 일정
### 총 기간 : 2024년 6월 4일 ~ 

- 스터디 언어 : Java
- 스터디 모임 : 주 2회(화, 목) 1시간 30분
- 참고 자료
  <br>
  [Do it! 알고리즘 코딩테스트 자바편]
 <br>
  https://www.inflearn.com/course/%EB%91%90%EC%9E%87-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EC%BD%94%EB%94%A9%ED%85%8C%EC%8A%A4%ED%8A%B8-%EC%9E%90%EB%B0%94/dashboard
   
<br>
<br>

## 2024년 6월

| 일 | 월 | 화 | 수 | 목 | 금 | 토 |
|----|----|----|----|----|----|----|
|    |    |    |    |    |    |  1 |
|  2 |  3 |  **4** |  5 |  6 |  7 |  8 |
|  9 | 10 | **11** | 12 | **13** | 14 | 15 |
| 16 | 17 | **18** | 19 | **20** | 21 | 22 |
| 23 | 24 | **25** | 26 | **27** | 28 | 29 |
| 30 |    |    |    |    |    |    |
<br>
<br>

## 2024년 7월

| 일 | 월 | 화 | 수 | 목 | 금 | 토 |
|----|----|----|----|----|----|----|
|    |  1 |  **2** |  3 |  **4** |  5 |  6 |
|  7 |  8 |  **9** | 10 | **11** | 12 | 13 |
| 14 | 15 | **16** | 17 | **18** | 19 | 20 |
| 21 | 22 | **23** | 24 | **25** | 26 | 27 |
| 28 | 29 | **30** | 31 |    |    |    |
<br>
<br>
<br>

## 📍스터디 룰
- 개인 학습
    - 매주 정해진 분량에 따라 학습 후 코딩테스트 문제 풀이하여 Github Repositiory에 push
    - 풀이에 있어서 주석은 꼼꼼히 작성하여 서로의 코드리뷰를 원활하게 한다.
    - 팀 미팅에서 막혔던 부분이나 이해가 안되는 부분을 준비해온다.
     
- 팀 미팅
    - 매주 화요일, 목요일에 진행
    - 문제 풀이 설명, 질의응답
    - 대면미팅을 기본으로 하고 강의실에서 진행

<br>
<br>

## 📍파일 관리
- 각자 이름으로 구성된 폴더 내에 개인 스터디 내용을 정리하는 방식으로 진행 <br>
  - 초기 설정
  1. ```
     git clone {현재 레포지터리 주소}
     ```
  2. ```
     git pull origin main
     ```
  3. ```
     git checkout -b {브랜치 이름(폴더 이름과 동일한 이름 권장)}
     ```
     <br>
     <br>

  - 그 후 사용
  1. ```
     git status //본인 이름으로 된 브랜치명이 뜨는지 반드시 확인할 것.
     ```
  2. 자유롭게 내용 추가
  3. ```
     git add .
     git commit -m "커밋 컨벤션을 지킨 내용으로 작성"
     git push origin {본인 브랜치}
     ```
  4. merge 진행<br>
     - 방법은 다음 링크 참조 : [Merge 진행 방법!](https://2l24algochallenge.notion.site/Merge-4f0f27f65df34f898e40a10a89041f14?pvs=4)
      
      
#### :ocean:Pull Request convention
- PR 제목 ```이름/n주차/푼 문제번호(여러개면 여러개)```

- <b>Add a description</b> : 문제 풀면서 어려웠던 점 or 접근 방법 or 풀지 못했다면 이유
  (ex. ~식으로 접근했는데 안됐다, 접근 방법을 모르겠다.) 를 남겨야 다른 팀원들의 코드 리뷰를 통해 해결할 수 있습니다!

#### :ocean:Directory convention
```
src/{이름}/{n}주차/{플랫폼}{문제번호}_{이니셜2자}.java
ex) src/박수빈/week1/boj1234_wh.java
```

#### :ocean:Source file convention
- 문제출처+문제번호_이름이니셜2자.java
  - 백준 - boj
  - 삼성 SW Expert Academy - swea
  - 프로그래머스 - pgs
  - ```ex) boj1234_wh.java```

#### :ocean:Commit convention
```
git commit -m"add : 이름/n주차/문제번호"
ex) git commit -m"add : 박수빈/week1/boj1234"

수정하는 경우
git commit -m"fix : 박수빈/week1/boj1234" 
```

#### :ocean:commit message convention
- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서
- style: 포맷팅, 누락된 세미콜론 등
- refactor: 코드 리팩토링
- test: 테스트 관련
- chore: 기타 수정
- build: 빌드 시스템 또는 외부 의존성에 영향을 주는 변경
- remove: 파일을 삭제

<br>
<br>
