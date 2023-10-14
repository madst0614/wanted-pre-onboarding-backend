# 프리온보딩 백엔드 인턴십 선발과제

<aside>
💡 서비스 개요

- 본 서비스는 기업의 채용을 위한 웹 서비스 입니다.
- 회사는 채용공고를 생성하고, 이에 사용자는 지원합니다.
</aside>

# 🖥️ API 구현 방법

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%B5%E1%84%8B%E1%85%A9%E1%86%AB%E1%84%87%E1%85%A9%E1%84%83%E1%85%B5%E1%86%BC%20%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8B%E1%85%A6%E1%86%AB%E1%84%83%E1%85%B3%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%86%AB%E1%84%89%E1%85%B5%E1%86%B8%20%E1%84%89%E1%85%A5%E1%86%AB%E1%84%87%E1%85%A1%E1%86%AF%E1%84%80%E1%85%AA%E1%84%8C%E1%85%A6%20a9378d18b27a4ced870fa5fdbbe853b1/Untitled.png)

![Untitled](%E1%84%91%E1%85%B3%E1%84%85%E1%85%B5%E1%84%8B%E1%85%A9%E1%86%AB%E1%84%87%E1%85%A9%E1%84%83%E1%85%B5%E1%86%BC%20%E1%84%87%E1%85%A2%E1%86%A8%E1%84%8B%E1%85%A6%E1%86%AB%E1%84%83%E1%85%B3%20%E1%84%8B%E1%85%B5%E1%86%AB%E1%84%90%E1%85%A5%E1%86%AB%E1%84%89%E1%85%B5%E1%86%B8%20%E1%84%89%E1%85%A5%E1%86%AB%E1%84%87%E1%85%A1%E1%86%AF%E1%84%80%E1%85%AA%E1%84%8C%E1%85%A6%20a9378d18b27a4ced870fa5fdbbe853b1/Untitled%201.png)

**배포 <Maven>Server + <Docker>DB(MySQL)**

# ⌨️ 사용 스택

- JAVA 1.8
- Springboot
- Mybatis
- MySQL

# 📲 API 실행 방법

---

```c
**// DB**
**docker-compose up

// Server
mvnw.cmd clean install -Dmaven.test.skip=true
java -jar ./target/recruitAPI-0.0.1-SNAPSHOT.jar

// init data
http://localhost:8080/init**
```

# 📝 API 명세

1. **채용공고를 등록합니다.**
    
    <aside>
    ➡️ 회사는 아래 데이터와 같이 채용공고를 등록합니다.
    
    </aside>
    
    ```json
    POST http://localhost:8080/board/register
    BODY 
    {"cid":"cid","position":"채용 포지션", "content":"채용 내용"}
    ```
    
    1. 요청
        
        ```json
        POST http://localhost:8080/board/register
        {"cid":"1", "position":"Spring 개발자", "content":"신입 개발자 모집 합니다."}
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 201 Created>
            Success
            ```
            
        2. 실패
        
2. **채용공고를 수정합니다**
    
    <aside>
    ➡️ 회사는 아래 데이터와 같이 채용공고를 수정합니다. (회사 id 이외 모두 수정 가능합니다.)
    
    </aside>
    
    ```json
    PUT http://localhost:8080/board/{bno}
    BODY 
    {"position":"채용 포지션", "content":"채용 내용"}
    ```
    
    1. 요청
        
        ```json
        PUT http://localhost:8080/board/1		
        {"position":"백엔드 개발자", "content":"신입 백엔드 개발자 모집 합니다."}
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 200 OK>
            Success
            ```
            
        2. 실패
            
            ```json
            <HTTP status : 404 Not_Found>
            {
                "code": "BOARD_NOT_FOUND",
                "message": "Board Not Exists"
            }
            ```
            
        
3. **채용공고를 삭제합니다.**
    
    <aside>
    ➡️ DB에서 삭제됩니다.
    
    </aside>
    
    ```json
    DELETE http://localhost:8080/board/{bno}
    ```
    
    1. 요청
        
        ```json
        DELETE http://localhost:8080/board/1
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 200 OK>
            Success
            ```
            
        2. 실패
            
            ```json
            <HTTP status : 404 Not_Found>
            {
                "code": "BOARD_NOT_FOUND",
                "message": "Board Not Exists"
            }
            ```
            
        
4. **채용공고 목록을 가져옵니다.**
    
    <aside>
    ➡️ 4-1. 사용자는 채용공고 목록을 아래와 같이 확인할 수 있습니다.
    
    </aside>
    
    ```json
    GET http://localhost:8080/board/
    ```
    
    1. 요청
        
        ```json
        GET http://localhost:8080/board/
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 200 OK>
            [
                {
                    "bno": 2,
                    "cid": 0,
                    "position": "자바 개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:13:25.000+00:00",
                    "companyBoardList": null,
                    "cname": "내이버"
                },
                {
                    "bno": 4,
                    "cid": 0,
                    "position": "프론트 개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:14:31.000+00:00",
                    "companyBoardList": null,
                    "cname": "카카으"
                },
                {
                    "bno": 3,
                    "cid": 0,
                    "position": "백엔드 개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:14:04.000+00:00",
                    "companyBoardList": null,
                    "cname": "원티드"
                },
                {
                    "bno": 7,
                    "cid": 0,
                    "position": "개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:40:03.000+00:00",
                    "companyBoardList": null,
                    "cname": "원티드"
                },
                {
                    "bno": 6,
                    "cid": 0,
                    "position": "개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:32:35.000+00:00",
                    "companyBoardList": null,
                    "cname": "쿠펑"
                }
            ]
            ```
            
        2. 실패
        
    
    <aside>
    ➡️ 4-2. 사용자는 원하는 키워드로 채용 공고를 검색할 수 있습니다.
    
    </aside>
    
    ```json
    GET http://localhost:8080/board/?keyword={keyword}
    ```
    
    1. 요청
        
        ```json
        GET http://localhost:8080/board/?keyword=원티드
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 200 OK>
            [
                {
                    "bno": 3,
                    "cid": 0,
                    "position": "백엔드 개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:14:04.000+00:00",
                    "companyBoardList": null,
                    "cname": "원티드"
                },
                {
                    "bno": 7,
                    "cid": 0,
                    "position": "개발자 구합니다",
                    "content": null,
                    "regDate": "2023-10-13T09:40:03.000+00:00",
                    "companyBoardList": null,
                    "cname": "원티드"
                }
            ]
            ```
            
        2. 실패
        
5. **채용 상세 페이지를 가져옵니다.**
    
    <aside>
    ➡️ 사용자는 채용상세 페이지를 아래와 같이 확인할 수 있습니다.
    
    - “채용내용”이 추가적으로 담겨있습니다.
    - 해당 회사가 올린 다른 채용공고를 확인할 수 있습니다.
    </aside>
    
    ```json
    GET http://localhost:8080/board/{bno}
    ```
    
    1. 요청
        
        ```json
        GET http://localhost:8080/board/3
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 200 OK>
            {
                "bno": 3,
                "cid": 0,
                "position": "백엔드 개발자 구합니다",
                "content": "Spring를 다룰 줄 알아야 합니다.",
                "regDate": "2023-10-13T09:14:04.000+00:00",
                "companyBoardList": [
                    7
                ],
                "cname": "원티드"
            }
            ```
            
        2. 실패
            
            ```json
            <HTTP status : 404 Not_Found>
            {
                "code": "BOARD_NOT_FOUND",
                "message": "Board Not Exists"
            }
            ```
            
        
6. **사용자는 채용공고에 지원합니다**
    
    <aside>
    ➡️ 사용자는 채용공고에 아래와 같이 지원합니다.
    
    - 사용자는 1회만 지원 가능합니다.
    </aside>
    
    ```json
    POST http://localhost:8080/apply/register
    {"uid":"uid", "bno":"bno"}
    ```
    
    1. 요청
        
        ```json
        POST http://localhost:8080/apply/register
        {"uid":"1", "bno":"3"}
        ```
        
    2. 리스폰스
        1. 성공
            
            ```json
            <HTTP status : 201 Created>
            Success
            ```
            
        2. 실패
            
            ```json
            <HTTP status : 409 Conflict>
            {
                "code": "ALREADY_APPLIED",
                "message": "Already Applied"
            }
            ```
            

# 📔 리뷰

공고 기능들은  cid 데이터 노출을 최소화 했으며 이에 따라 요청 전 상세한 인증 과정 구현이 필요할 수 있습니다.

1. 공고 등록
    
    공고 등록은 인증된 cid로 등록한다는 가정 하에 구현됐습니다.
    
2. 공고 수정
    
    공고 수정은 해당 bno를 작성한 cid로 수정한다는 가정 하에 구현됐습니다.
    
3. 공고 삭제
    
    공고 삭제는 해당 bno로 작성한 cid로 삭제한다는 가정 하에 구현됐습니다.
    
4. 공고 목록 가져오기 / 키워드 검색
    
    공고 목록 가져오기는 cid, content를 제외한 데이터를 가져옵니다.  TBL_BOARD와 TBL_COMPANY를 조인하여 필요한 데이터들을 가져오게 구현했습니다. 
    
    키워드 검색은 공고 목록 가져오기 쿼리에서 Mybatis 동적 쿼리 <if 문>을 사용하여 키워드가 NotNull이거나 “”가 아닌 경우 where절 추가를 통해 구현했습니다.
    
5. 공고 상세 페이지 가져오기
    
    공고 상세 페이지 가져오기는 공고 목록 가져오기에서 누락된 content 내용을 가져오며, 상세 페이지를 가져오는 도중 공고가 삭제될 경우를 고려하여 DB에서 한번 더 해당 Board를 가져오는 과정을 거쳤습니다. DB 접근이 늘어남에 따라 대량 사용자 요청이 있을 경우 성능 저하가 있을 수 있습니다. TBL_BOARD와 TBL_COMPANY를 조인하여 필요한 데이터들을 가져오게 구현했습니다.
    
6. 공고 지원
    
    공고 지원은 추후 확장성을 고려하여 ApplyController와 ApplyService에서 처리될 수 있게 구현했습니다. 
    

# 💢 느낀 점

- 도커 배포 과정
    - 도커로 Compose Up하여 한번에 배포 과정을 처리할 수 있게 구현 할려 했었는데, 배포는 프로젝트 시작 전 고려한 사항이 아니다 보니 추가하는 과정에서 문제가 생겼다. 확실하지는 않지만 Maven으로 jar로 만들어서 구동 결과 성공했지만, 도커 파일로 빌드하고 컨테이너로 구동해서 네트워크 브릿지로 DB와 직접 연결까지 해봤지만 실패한 걸로 봐서 도커로 이식하는 과정에 문제가 있는 듯하다. 자바가 바이트 코드로 컴파일 하여 런타임 환경에서 구동한다고 해도 여러 코드들과 라이브러리의 종속 문제는 해결되지 않는 듯하다.  프로젝트 시작 전  사전  환경 구축 작업과 기능 구현 중간 중간에 이식 테스트 과정이 중요할 듯 하다.
    - 처음 도커로 배포 과정을 구현해봤는데, 프로젝트 마감일 전날 할려다 보니 과정이 많이 얽힌 것 같다. 하루동안 수 많은 도커 파일과 컴포즈 파일을 보며 많은 것을 배울 수 있었고, 도커로 개발 환경을 구성한다는게 얼마나 메리트가 있는지 느낄 수 있었다. 도커 개발 환경도 자바 개발 환경과 비슷하다는 느낌을 받았고 추상화와 인터페이스 개념을 통해 종속에서 벗어는 방법이 아름답다고 느꼈다. 별개로 도커 구동 방식과 컨테이너에 대해서 좀 더 공부를 해야할 듯 싶다.
    
- 서버 구현 과정
    - 처음 Springboot를 써봤는데 Parent까지 쓰니 라이브러리와 버전 호환을 생각안해도 되니 너무 편했다. 심지어 내부 톰캣까지 있어서 간단한 프로젝트는 톰캣 구동 과정까지 신경 안써도 된다. 이래서 스프링부트를 쓰는구나 했다.
    - 내가 알지 못하는 코드 구현 방법이 많았다. 클린 코드? 패턴? final, Setter, 빌더 패턴 등등 이렇게 코드를 짜면 더 좋은 코드가 될 수 있다는 글을 많이 봤다. 개발도 결국엔 Trial and Error, 시행 착오라고 생각한다. 수 많은 시행 착오에서 나온 방법들을 배우고 써먹어야겠다.
    - 유닛 테스팅도 처음 구현 해봤는데, Mybatis가 생각보다 정보가 없었다. 대부분 JPA를 써서 ORM을 구현한 경우가 많아서 따로 정보들을 찾아 구현했다. In-memory DB을 이용해서 테스팅 하는 경우도 고려해봤는데, 도커로 실제 구동 DB 환경과 비슷하게 테스트 하는 방법도 좋은 듯 하다. 이번 테스트는 도커로 실제 구동 DB 환경과 비슷하게 유닛 테스팅 했다.
    - 처음 Exception Handle 해봤는데 확실히 Spring이 AOP가 가능해서 그런지 되게 편했다. 관련 클래스들을 상속받아서 구현하고 Service 단에 필요한 부분에서 throw 해주면 구현됐다. Service 단에서 예외 처리를 한 이유는 요청을 Cotroller로 받아서 Service로 처리해주기에 코드 맥락을 고려하여 Service단에서 처리하는게 맞다 생각이 들었다. 최대한 코드 중복을 최소화 하는 방법으로 구현해봤다.
    - DTO, VO를 구분해서 구현해봤다. DTO는 컨트롤러, 서비스 단에서 VO는 DAO 용도로만 Fianl하게 썼다. Final을 쓰는게 변수 변경 가능성이 적고 더 안전한 듯하다. 다음 구현 때 써봐야겠다.
    
- 전체 구현 소감
    
    처음 해보는 과정들이 많아서 힘들었다. 하지만 상용 서비스에 비하면 아직 배울 점이 많고 너무 부족하다. 아주 작은 API Server 하나도 아는 만큼 구현할 수 있다는 걸 느꼈다. 대략 2주의 시간동안 발 한번 담가본 수준이지만 알아야 할게 많고 배워야 할게 많다고 생각이 들었다. 하지만 양질의 코드와 서비스들을 경험해보면 금방 배우겠구나 생각도 들었다.  
    
    사전 개발 환경 구성 신경 쓰기, Docker, JPA, 클린 코드, 디자인 패턴 공부