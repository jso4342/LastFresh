<div align="center">

<h1 align="center">LastFresh</h1>
<h3 align="center"> 자영업자를 위한 오픈 마켓 플랫폼 </h3> 
<br />

</div>

- 팀 명 : 세미콜론(Semicolon)
- 팀 원 : 심창환(팀장), 장서영, 진세종, 공도윤, 최동영, 현진용 
- 개발 기간 : 2022/05/02 ~ 2022/06/01 (30일)
- [라스트프레시 바로가기](http://15.164.255.162:11111/main/main)
  <br />

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 📝 프로젝트 소개
라스트프레시는 소비자와 자영업자, 모두에게 win-win 관계를 위해 만들어진 남은 음식 오픈 마켓 플랫폼 입니다. 판매자는 유통기한이 얼마 남지 않은 제품을 마감 세일가로 판매할 수 있는 기회 제공을, 구매자게에게는 저렴한 가격으로 제품을 구매할 수 있다는 장점을 제공합니다. 또한 택배 배송뿐만 아니라 픽업 및 배달 및 라이더 매칭 서비스를 같이 지원하고 있기 때문에 다양한 타겟을 설정할 수 있습니다. 
<br>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 🙋‍♀️ [jso4342(장서영)](https://github.com/jso4342)이 프로젝트에서 맡은 역할 
- 서비스 기획부터 전반적인 페이지 프론트엔드 업무수행
- DB 설계 및 구축 
- Presentation Tier 설계 
- 장바구니 기능 REST API 개발  
- Open API를 이용한 결제 시스템 구현 
- 주문 및 관리(주문 상태, 배송 상태, 주문 취소 등) 기능 구현 및 상품 재고 관리 
- 구매한 상품의 리뷰 (작성 가능 리뷰 / 작성한 리뷰) 기능 구현 
- Spring Security를 이용한 비밀번호 인증, 회원 정보 수정 및 탈퇴 기능 구현
- AWS 서버 구축 및 배포 

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 🧐 기존 업체들의 문제점
<details>
<summary>본문 확인 (👈 Click)</summary>
<div markdown="1">
<br>
배달 중개 어플
  
- 배달 플랫폼의 배달 기사(라이더)를 필수로 이용해야된다는 단점

    - 인터뷰 결과, 자사 라이더가 있는 식당임에도 플랫폼을 이용하기 위해 라이더 해고 또는 라이더가 플랫폼 라이더러 등록을 해야하는 문제점 발생

- 주로 배달, 포장 서비스만 지원하고 택배 배송은 지원 X

- 조리 제품만 판매하여 농수산물 같은 원물 재료의 경우 판매 X

- 마감 할인 서비스 X

- 한 가게의 제품만 장바구니에 담을 수 있는 한계점 

오픈 마켓 플랫폼 

- 현재 서비스중인 오픈 마켓 플랫폼은, 픽업 및 배달 서비스 지원 X 

- 택배사 지원이 없기 때문에 배달 중개 어플들의 문제와는 다르게 배송 업무의 위탁 관리가 어려움 
</div>
</details>
    
![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
    
## 💡 Solution
<details>
<summary>본문 확인 (👈 Click)</summary>
<div markdown="1">
<br>
상품 판매 시스템 
- 상품 업로드 시, 배달 / 배송 / 픽업 카테고리를 1개 이상 선택해 해당 카테고리에 동시 노출 

- 판매 기간 및 할인 가격을 적어 자동으로 할인률을 계산하는 기능 

- 픽업 서비스 이용 시, 배달 가능 지역 3개 선택 및 목록에서 필터링 가능 

- 라스트프레시 라이더, 혹은 자가 라이더 전부 이용 가능 및 자가 라이더 이용 시에도 라스트프레시 포스기에 배달 및 배송 관련 현황 업데이트 가능 

- 판매 기간 종료 시, 상품을 자동으로 품절 상태로 전환하는 기능

- 입력한 재고와 판매량을 연동하여 자동으로 stock 관리

상품 구매 시스템 
- 장바구니에 상품을 담을 시, 선택한 배송 방법에 따라 카테고리에 맞게 담아주는 기능 

- 여러 가게에서 구매했어도 통합 주문 가능 및 주문 상태 확인, 개별 취소, 후기 작성 등, 개별 관리가 가능 

라이더 매칭 시스템
- 배달 지역(가게, 주문자), 시간, 주문 상품명 등을 기반으로 라이더들을 빠르게 매칭해주는 시스템 

- 일반 오토바이 라이더 뿐만 아니라, 화물차 등의 택배 기사 매칭 시스템도 지원
</div>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
    
## 📝 구현 기술 스택 
<details>
<summary>본문 확인 (👈 Click)</summary>
<div markdown="1">

- Java 11

- JavaScript

- SpringBoot

- MySQL

- JPA

- MyBatis

- MySQL

- AWS EC2, RDS

- Kakao 로그인, 지도 API 

- 이니시스 결제 API
</div>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 📈 ERD
<img width="750" src="https://user-images.githubusercontent.com/57066693/200187939-4a967f14-b120-40b8-bb50-0a494da38b24.png">

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 🖥️ 포트폴리오
<details>
<summary>담당 부분 포트폴리오 확인 (👈 Click)</summary>
<div markdown="1">
<img width="1261" alt="스크린샷 2022-12-23 오전 4 42 37" src="https://user-images.githubusercontent.com/57066693/209216583-9677cc60-8929-4156-be20-c381c55a544e.png">
<img width="1259" alt="스크린샷 2022-12-23 오전 4 42 48" src="https://user-images.githubusercontent.com/57066693/209216586-6b1d0b6c-7622-4908-bcca-612517468b70.png">
<img width="1262" alt="스크린샷 2022-12-23 오전 4 43 00" src="https://user-images.githubusercontent.com/57066693/209216588-8a46a8f2-8555-4dd7-afb8-f5af71e326d0.png">
<img width="1264" alt="스크린샷 2022-12-23 오전 4 43 18" src="https://user-images.githubusercontent.com/57066693/209216591-4497f44e-8779-49ff-aaac-925ff2b080a8.png">
<img width="1262" alt="스크린샷 2022-12-23 오전 4 43 30" src="https://user-images.githubusercontent.com/57066693/209216594-bb3d16a6-f25f-453f-91d0-b399d576c846.png">
<img width="1263" alt="스크린샷 2022-12-23 오전 4 43 40" src="https://user-images.githubusercontent.com/57066693/209216597-8f23cc35-f4f3-4eb7-ae81-534d8592f748.png">
<img width="1264" alt="스크린샷 2022-12-23 오전 4 43 51" src="https://user-images.githubusercontent.com/57066693/209216600-7e33a591-424e-4cfb-b65e-e62ffc5848f3.png">
<img width="1261" alt="스크린샷 2022-12-23 오전 4 44 07" src="https://user-images.githubusercontent.com/57066693/209216602-e6002329-df19-4b50-b080-398c325e54ec.png">
<img width="1261" alt="스크린샷 2022-12-23 오전 4 44 46" src="https://user-images.githubusercontent.com/57066693/209216606-b0a098d1-f836-4f23-8935-61b49ea71f01.png">
<img width="1191" alt="스크린샷 2022-12-23 오전 4 46 00" src="https://user-images.githubusercontent.com/57066693/209216609-12a54071-bb00-4326-944b-a295416a28d1.png">
<img width="1196" alt="스크린샷 2022-12-23 오전 4 46 11" src="https://user-images.githubusercontent.com/57066693/209216611-9a4485da-b7cf-4f13-bde3-ec611b8b62e7.png">
<img width="1194" alt="스크린샷 2022-12-23 오전 4 46 24" src="https://user-images.githubusercontent.com/57066693/209216613-d5a98702-e277-4348-be4b-e9c385a74e9e.png">
<img width="1194" alt="스크린샷 2022-12-23 오전 4 46 32" src="https://user-images.githubusercontent.com/57066693/209216615-d094fa13-54c7-4002-a1e6-fd512895440d.png">
<img width="1188" alt="스크린샷 2022-12-23 오전 5 02 18" src="https://user-images.githubusercontent.com/57066693/209216747-41be9433-2f21-4728-b286-c1c81d04d59a.png">
</div>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## ⏰ 팀의 개발 문화 
<details>
<summary>본문 확인 (👈 Click)</summary>
<div markdown="1">

### 수정에는 관대하게, 도움 요청을 망설이지 말자.
프로젝트 초기 설계가 미숙했기 때문에, 개발 중 추가적으로 받아야한다는 것을 인지한 경우가 다수 있었습니다. 데이터베이스에 새로운 정보를 추가할 시 수정해야하는 파트가 다수 있었고, 서로 연관되어 있는 파트도 존재 해, 간단한 기능 하나를 추가하기 위해서 다수의 팀원의 코드를 전체적으로 수정해야했습니다. 

팀원 모두가 초기 설계 시 능숙하지 않고 배워가는 과정이었기 때문에 개발 시 수정이 필요한 부분이 필연적으로 발생할 것이라 예상했었습니다. 따라서 이에 대해서는 껄끄러움이나 불만 없이 의견을 나누기로 사전에 소통할 수 있었습니다. 또한, 발생하는 오류에 대해 질책하기보다, 이유를 분석하고 보다 간단한 해결책이 있을지 같이 고민해보는 시간을 가졌습니다. 
 실제로 백엔드에서 주문서 상태 처리 시, 데이터베이스에 새로운 Column 추가가 필요했고 이에는 포스 기능과 라이더 기능의 수정이 뒤따랐습니다. 이를 해결하기 위해, 해당 기능을 담당했었던 팀원들끼 모여 왜 이러한 문제가 발생했고, 서로의 파트에 어떤 식으로 수정을 통해 해결할 수 있는지에 대해 소통하며, 해결 이후 자세한 내용을 팀원들끼리 공유하는 시간을 가졌습니다. 


### 백엔드 소통
기본적으로 저희 팀은, 프로젝트 초기에는 주 7일 풀타임, 프로젝트 중후반 부에는 주 6일 풀타임으로 온라인(디스코드)에 모여서 개발을 진행 및, 주 5일 진행상황을 보고하는 시간을 가졌습니다. 
따라서 도움이 필요한 부분이나 완성이 미흡한 부분에 대해서 매일 소통하며 서로에게 바로 도움을 줄 수 있었습니다. 또한 자기 전 매일 다음 날 개발 목표를 세워 공유하는 시간을 가져, 각 팀원들의 진행상황을 투명하게 공개 하였습니다. 


</div>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)

## 📌 회고 및 성과 

<details>
<summary>본문 확인 (👈 Click)</summary>
<div markdown="1">

### 이 프로젝트는 실패인가 성공인가?
프로젝트의 실패와 성공은 프로젝트를 보는 관점에 따라 다르다고 생각합니다. 따라서 저 [jso4342(장서영)](https://github.com/jso4342)은 라스트프레시라는 프로젝트에 대해 ‘상업적 관점’과 개발자라는 저의 ‘성장적 관점’에서 얘기해보려고 합니다. 

#### 상업적 관점에서
먼저 프로젝트의 상업적인 관점을 기준으로 봤을 때는 '실패' 라고 생각합니다. 
이 프로젝트는 비지니스 모델 상, 해당 서비스를 배포하기 전에 판매상품을 등록해야하는 판매자들을 사전에 모집해야 합니다. 하지만 마감 세일을 진행하는 플랫폼이다보니, 짧은 라이프사이클의 제품들로 비지니스를 성장시키기에은 무리가 있습니다. 고객의 충분한 유입 전 상품의 판매 기간이 끝나버릴 가능성이 높기 때문입니다. 
라이더의 경우도 마찬가지입니다. 판매자가 자가 라이더를 이용하지 않는 경우, 배달 및 배송을 위해서 라스트프레시의 자체 배달, 배송 라이더가 전국적으로 필요합니다. 
이 부분은 개발 영역과는 별개로 마케팅 및 판매자 및 라이더 컨택 등, 소비자의 유입 전에도 상당한 시간이 소요될 것으로 예상됩니다. 창업의 목표를 가지고 진행한 프로젝트가 아니었기에 혼자의 힘으로는 프로젝트를 실제 서비스되는 플랫폼으로 만들기는 버거웠습니다. 
(프로젝트는 출시 되었지만, 출시한 이유는 AWS에 대해 공부하고자 하는 목적이었고 실제 서비스되는 페이지에 올라온 데이터들은 실제 판매자가 아닌 출시 이후 제가 임의로 생성한 상품들입니다. )

#### 성장적 관점에서
둘째로 개발자로서의 성장 관점에서 보았을 때는 나름 성공이라고 생각합니다.
프로젝트를 진행하면서 기술적으로 많은 경험을 했을 뿐만 아니라, 비전공자로서 처음으로 개발해본 Spring 프로젝트 였습니다. Spring에 대해서는 아무것도 모르던 프로젝트 진행 전과 달리, 후에는 확실히 더 많은 것을 알게되었습니다. 또한 REST API, JPA, AWS 서버 구축 및 배포 등 개인적으로 다양한 기술을 사용하고자 했습니다. 
물론 프로젝트 이후 코드를 다시 돌아보면 아쉬운 점은 많이 보입니다. 클린 코드의 중요성을 알지 못했을 시절 작성했던 코드였기 때문에 가독성을 신경쓰지 못한 부분과, 레거시 코드를 사용한 부분 등이 개인적으로는 눈에 띄기도 합니다. 
특히 REST API를 JavaScript의 Ajax를 이용해서 호출하였기 때문에 아쉬움이 많이 남습니다. REST API에 관해서는 프로젝트가 끝나고 나서 꼭 다시 공부하고자 합니다.

**프로젝트 이후 공부한 내용** 

바로 앞서 언급했던 아쉬웠던 내용을 프로젝트가 끝난 이후에 공부하고 포스팅 및 토이 프로젝트를 진행했습니다.
- [REST API](https://kiyoung-noona.tistory.com/34)
- [REST API 토이 프로젝트](https://github.com/yewon9609/spring-week1-assignment-1/pull/1)
- [JPA와 MyBatis의 차이](https://kiyoung-noona.tistory.com/38)

</div>
</details>

![-----------------------------------------------------](https://raw.githubusercontent.com/andreasbm/readme/master/assets/lines/rainbow.png)
