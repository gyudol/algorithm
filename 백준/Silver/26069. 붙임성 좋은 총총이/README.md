# [Silver IV] 붙임성 좋은 총총이 - 26069 

[문제 링크](https://www.acmicpc.net/problem/26069) 

### 성능 요약

메모리: 13580 KB, 시간: 112 ms

### 분류

자료 구조, 해시를 사용한 집합과 맵, 트리를 사용한 집합과 맵

### 제출 일자

2024년 6월 21일 21:46:56

### 문제 설명

<p style="text-align: center;"><img alt="무지개 댄스를 추는 총총과 그걸 보는 총총" src="https://upload.acmicpc.net/12d3d8d8-06c0-4b31-b661-0ce1bc935cf9/-/preview/" style="max-height:120px; object-fit:contain; display:inline-block;"></p>

<p>총총이는 친구 곰곰이의 소개로 <strong>제2회 곰곰컵</strong>에 출연할 기회를 얻었다!</p>

<p>총총이는 자신의 묘기인 <strong><span style="color:#8c00ff;">무</span><span style="color:#00b7ff;">지</span><span style="color:#ff0082;">개 </span></strong><span><strong><span style="color:#ff9000;">댄</span><span style="color:#00ff40;">스</span></strong>를 선보여, 여러분의 환심을 사려 한다. 이 댄스는 중독성이 강하기 때문에, 한번 보게 된 사람은 모두 따라 하게 돼버린다.</span></p>

<p style="text-align: center;"><img alt="무지개 댄스를 추는 총총 2마리" src="https://upload.acmicpc.net/4efdc327-804f-4929-8b6f-5b85577135c8/-/preview/" style="max-height:120px; object-fit:contain; display:inline-block;"></p>

<p>사람들이 만난 기록이 시간 순서대로 $N$개 주어진다. (총총이는 토끼이지만 이 문제에서는 편의상 사람이라고 가정한다.)</p>

<p>무지개 댄스를 추지 않고 있던 사람이 무지개 댄스를 추고 있던 사람을 만나게 된다면, 만난 시점 이후로 무지개 댄스를 추게 된다.</p>

<p>기록이 시작되기 이전 무지개 댄스를 추고 있는 사람은 총총이 뿐이라고 할 때, 마지막 기록 이후 무지개 댄스를 추는 사람이 몇 명인지 구해보자!</p>

### 입력 

 <p>첫번째 줄에는 사람들이 만난 기록의 수 $N\ (1 \le N \le 1\ 000)$이 주어진다.</p>

<p>두번째 줄부터 $N$개의 줄에 걸쳐 사람들이 만난 기록이 주어진다. $i + 1$번째 줄에는 $i$번째로 만난 사람들의 이름 $A_i$와 $B_i$가 공백을 사이에 두고 주어진다. $A_i$와 $B_i$는 숫자와 영문 대소문자로 이루어진 최대 길이 $20$의 문자열이며, 서로 같지 않다.</p>

<p>총총이의 이름은 <span style="color:#e74c3c;"><code>ChongChong</code></span>으로 주어지며, <strong>기록에서 1회 이상 주어진다.</strong></p>

<p>동명이인은 없으며, 사람의 이름은 대소문자를 구분한다. (<span style="color:#e74c3c;"><code>ChongChong</code></span>과 <span style="color:#e74c3c;"><code>chongchong</code></span>은 다른 이름이다.)</p>

### 출력 

 <p>마지막 기록 이후 무지개 댄스를 추는 사람의 수를 출력하라.</p>

