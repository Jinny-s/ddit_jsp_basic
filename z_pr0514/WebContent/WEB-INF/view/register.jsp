<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/top.jsp" %>

 <!-- Content Header (Page header) -->
 <div class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6 mt-2">
       </div><!-- /.col -->
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="<c:url value='/main' />">Home</a></li>
           <li class="breadcrumb-item active">Register</li>
         </ol>
       </div><!-- /.col -->
     </div><!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content-header -->

 <!-- Main content -->
 <div class="content">
   <div class="container-fluid">
     <div class="row col-10 mt-2 mx-auto">
         <h1 class="m-0">회원 등록 페이지</h1>
       <div class="col-12 mt-2 mx-auto">
         <div class="card card-info">
           <div class="card-header">
             <h3 class="card-title">회원 정보</h3>
           </div>
           <!-- /.card-header -->
           <!-- form start -->
           <form class="form-horizontal" action="<c:url value='/register' />" method="post">
             <div class="card-body">
               <div class="form-group row">
                 <label for="memId" class="col-sm-2 col-form-label">아이디</label>
                 <div class="col-sm-10">
                   <input type="text" class="form-control" id="memId" name="memId" placeholder="아이디를 입력해주세요.">
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memPw" class="col-sm-2 col-form-label">비밀번호</label>
                 <div class="col-sm-10">
                   <input type="password" class="form-control" id="memPw" name="memPw" placeholder="비밀번호를 입력해주세요.">
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memEmail" class="col-sm-2 col-form-label">이메일</label>
                 <div class="col-sm-10">
                   <input type="email" class="form-control" id="memEmail" name="memEmail" placeholder="이메일을 입력해주세요.">
                 </div>
               </div>
               <div class="form-group row">
                 <label for="memHp" class="col-sm-2 col-form-label">전화번호</label>
                 <div class="col-sm-10">
                   <input type="text" class="form-control" id="memHp" name="memHp" placeholder="전화번호를 입력해주세요.">
                 </div>
               </div>
             </div>
             <!-- /.card-body -->
             <div class="card-footer">
               <button type="submit" class="btn btn-info">등록</button>
               <a type="submit" class="btn btn-default float-right" href="<c:url value='/main' />">메인</a>
             </div>
             <!-- /.card-footer -->
           </form>
         </div>
         <!-- /.card -->
       </div>
     </div>
     <!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content -->


<%@ include file="/WEB-INF/view/common/bottom.jsp" %>