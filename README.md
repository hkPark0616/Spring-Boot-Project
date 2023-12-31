﻿# Spring-Boot-Project

## ⏳ 개발기간

약 13일 (2023.12.16 ~ 2023.12.28)

<br/>

## 📖 개요

Spring Boot를 활용한 개인 Portfolio 사이트 입니다. 저에 대한 정보와 개인 및 팀 프로젝트에 대한 세부 내용을 확인할 수 있습니다.<br>
summernote라는 웹 에디터를 활용하여, 개인 및 팀 프로젝트에 대한 정보를 손쉽게 작성하고 정리할 수 있도록 하였습니다.<br>
로그인, 회원가입 기능은 신원 확인용으로 구현되었으며, 프로젝트 게시글을 작성 권한은 관리자에게만 부여되어 있습니다.<br>


####  Front-end
  
* <img src="https://img.shields.io/badge/HTML5-E34F26?style=flat&logo=HTML5&logoColor=white"> <img src="https://img.shields.io/badge/CSS3-1572B6?style=flat&logo=CSS3&logoColor=white"> <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat&logo=jQuery&logoColor=white"> 
  <img src="https://img.shields.io/badge/Javascript-F7DF1E?style=flat&logo=Javascript&logoColor=white"> <img src="https://img.shields.io/badge/Thymeleaf-005F0F?style=flat&logo=Thymeleaf&logoColor=white"><br>

####  Back-end

* <img src="https://img.shields.io/badge/SpringBoot-success?style=flat&logo=Spring&logoColor=white"/> <img src="https://img.shields.io/badge/Java-ED8106?style=flat&logo=Spring&logoColor=white"/>

####  Database

* <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat&logo=MySQL&logoColor=white"><br>

<br/>

## 📄 웹페이지 구성

 * ### 메인화면
   간단한 정보를 확인할 수 있습니다.
     <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/f9a7bd01-d37e-4fd4-8e6b-d2d57095a219"  width="800" height="400"/>

 * ### 회원가입 및 로그인, 로그아웃
     <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/d4ea68ae-b432-4a9e-8beb-a8205d286e9f"  width="800" height="400"/>

 * ### 게시글
   | 목록 및 상세 페이지 | 페이징 |
   |------------|------------|
   | <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/bd5ed28d-963c-4ba2-a8b8-9ac07f6be7f1"  width="500" height="300"/> | <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/cb26cc73-516d-4fc3-bbd6-34bcf6911fcc"  width="500" height="300"/> | 

 * ### 게시글 작성
   summernote라는 웹 에디터를 이용하여 게시글을 작성할 수 있으며, 관리자만 작성 가능합니다.
    <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/6861e8ae-6dd6-4d23-8261-5061da336da4"  width="800" height="400"/>

 * ### 게시글 수정
   관리자만 수정 가능합니다.
    <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/ad62e763-e78c-4f5b-939d-7fa40d58577c"  width="800" height="400"/>

 * ### 게시글 삭제
   관리자만 삭제 가능합니다.
    <img src="https://github.com/hkPark0616/Spring-Boot-Project/assets/113004801/ecee60ef-9d22-41c5-816c-7cbfc4b4358f"  width="800" height="400"/>

<br/>

## 📃 아쉬운점
* 웹에디터를 사용하였으나 Tab 기능 사용 불가, 이미지 붙여넣기, 글머리 기호 종류 부족, 표 삽입 등 글을 작성 시 불편한 점이 존재합니다.
* 썸네일은 게시글의 첫번째 이미지로 사용되도록 하였으나, 따로 썸네일을 추가하는 기능이 있었으면 좋았을 것 같습니다.
* 현재 인증과 권한에 대한 부분은 따로 간단한 로직을 작성하여 구현하였으나, Spring Security를 이용하여 인증과 권한, 인가 등을 관리할 수 있었으면 좋았을 것 같습니다.

<br>


## 📰 참고
   #### 게시판 기능
   https://velog.io/@max9106/Spring-Boot-JPA-MySQL-%EA%B2%8C%EC%8B%9C%EA%B8%80-%EC%88%98%EC%A0%95-%EC%82%AD%EC%A0%9C
   #### 페이징
   https://magicmk.tistory.com/43
   #### 회원가입 및 로그인
   https://youngest-programming.tistory.com/324
   #### summernote
   https://sirobako.co.kr/detail/49
   https://youseong.me/auth/portboard/details?id=11

