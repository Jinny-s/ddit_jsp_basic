<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/top.jsp" %>

 <!-- Content Header (Page header) -->
 <div class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6">
         <h1 class="m-0">Admin Main Page</h1>
       </div><!-- /.col -->
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="#">Home</a></li>
           <li class="breadcrumb-item active">Admin Main Page</li>
         </ol>
       </div><!-- /.col -->
     </div><!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content-header -->

 <!-- Main content -->
 <div class="content">
   <div class="container-fluid">
     <div class="col-12">
       <div class="card">
         <div class="card-header">
           <h3 class="card-title">DataTable with default features</h3>
         </div>
         <!-- /.card-header -->
         <div class="card-body">
           <table id="example1" class="table table-bordered table-striped">
             <thead>
             <tr>
               <th>Rendering engine</th>
               <th>Browser</th>
               <th>Platform(s)</th>
               <th>Engine version</th>
               <th>CSS grade</th>
             </tr>
             </thead>
             <tbody>
             <tr>
               <td>Trident</td>
               <td>Internet
                 Explorer 4.0
               </td>
               <td>Win 95+</td>
               <td> 4</td>
               <td>X</td>
             </tr>           
             </tbody>
             <tfoot>
             <tr>
               <th>Rendering engine</th>
               <th>Browser</th>
               <th>Platform(s)</th>
               <th>Engine version</th>
               <th>CSS grade</th>
             </tr>
             </tfoot>
           </table>
         </div>
         <!-- /.card-body -->
       </div>
       <!-- /.card -->
       <h5 class="mb-2">Info Box</h5>
       <div class="row">
         <div class="col-md-3 col-sm-6 col-12">
           <div class="info-box">
             <span class="info-box-icon bg-info"><i class="far fa-envelope"></i></span>

             <div class="info-box-content">
               <span class="info-box-text">Messages</span>
               <span class="info-box-number">1,410</span>
             </div>
             <!-- /.info-box-content -->
           </div>
           <!-- /.info-box -->
         </div>
       </div>
     </div>
     <!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content -->




<%@ include file="/WEB-INF/view/common/bottom.jsp" %>