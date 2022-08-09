<a name="readme-top"></a>
# HW2-1_Spring_restful_practice

8/5(Fri.) 的[回家作業](https://hackmd.io/@BillYang3416/H1b4j0nnq)，
運用 [07/29 HW 的 RESTful 應用情境](https://hackmd.io/@UKFIIS4gSEaZDh0SbfbkwQ/B1Rxi-rTq) :arrow_down:

聖誕節前，聖誕老人確認小朋友送禮清單

* Get 取得小朋友送禮清單
* Post 發現新生兒，加入送禮清單
* Put 察覺有小朋友地址錯誤，修改清單
* Delete 有小朋友剛剛亂丟垃圾，刪除清單


建立 RESTful Web Service 專案，使用 Spring Boot RestController 及多種 Annotation，再到Postman操作專案。

Dependencies內增加Lombok，自動生成getter, setter 和 AllArgsConstructor。

<!-- ABOUT THE PROJECT -->
## About The Project

<img width="307" alt="structure" src="https://user-images.githubusercontent.com/80444687/183571345-d35e69b1-ded8-45bd-901b-f4d0813944c8.png">



架構如上圖：

1.model:

* Kid 的屬性 :arrow_right: id, age, name, address, gift

2.KidService:

* 建構子內寫入假資料用於測試。
* 有增刪改查共五種方法：
    * 取得所有小朋友清單(getAllKids()) 
    * 根據ID取得小朋友資料(getKidById(int id))
    * 新增小朋友至清單(createKid(Kid kid)): age 大於等於18、id 重複、地址年紀及名字同時重複 無法新增 並拋出Exception
    * 修改小朋友資料(updateKid(int id, Kid kid))
    * 刪除小朋友資料(deleteKid(int id))

3.KidController 接收 KidService 的方法，使用 Mapping Annotation(GET, POST, PUT, DELETE)，並在方法內設計當資料錯誤時會拋出的 Exception。

4.application.properties 中，寫入server.error.include-message = always 

:arrow_right: 自定義的錯誤訊息會顯示於Postman response
  例如：當新增的小朋友 地址年紀及名字同時重複，會顯示如下
  
  <img width="417" alt="Screen Shot 2022-08-09 at 1 18 50 PM" src="https://user-images.githubusercontent.com/80444687/183574097-feaccb4e-5fe9-46d8-8978-9dcf5c2affbb.png">

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- GETTING STARTED -->
## Getting Started

1.將此專案下載或clone後，在 IDE 打開 pom.xml。

2.開啟 Postman，import HW2-restful-santa.postman_collection.json

3.回到 IDE ，執行src/main/java/com.example.hw2restfulsanta 內的 Hw2RestfulSantaApplication

4.至 Postman 操作此專案

* 取得所有小朋友清單 http://localhost:8080/kid
* 根據ID取得小朋友資料 http://localhost:8080/kid/:id
* 新增小朋友至清單 http://localhost:8080/kid
* 修改小朋友資料 http://localhost:8080/kid/:id
* 刪除小朋友資料 http://localhost:8080/kid/:id

<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- Improvements -->
## 之後可以改善的
將model.Kid 設為 abstract class， 再建立 class NiceKid 和 NaughtyKid 去繼承 model.Kid。 

讓 NaughtyKid 有機會返回 NiceKid 的 list 。
而真正需要從清單刪除的應該為大人( age >= 18)
<p align="right">(<a href="#readme-top">back to top</a>)</p>

<!-- CONTACT -->
## Contact

Huai Chiu - huaichiu@systex.com

<p align="right">(<a href="#readme-top">back to top</a>)</p>
