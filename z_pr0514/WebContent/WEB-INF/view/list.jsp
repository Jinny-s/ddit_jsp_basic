<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/view/common/top.jsp" %>

 <!-- Content Header (Page header) -->
 <div class="content-header">
   <div class="container-fluid">
     <div class="row mb-2">
       <div class="col-sm-6 mt-2">
         <h1 class="m-0">전체 회원 목록</h1>
       </div><!-- /.col -->
       <div class="col-sm-6">
         <ol class="breadcrumb float-sm-right">
           <li class="breadcrumb-item"><a href="<c:url value='/main' />">Home</a></li>
           <li class="breadcrumb-item active">Member List</li>
         </ol>
       </div><!-- /.col -->
     </div><!-- /.row -->
   </div><!-- /.container-fluid -->
 </div>
 <!-- /.content-header -->

 <!-- Main content -->
 <div class="content">
   <div class="container-fluid">
     <div class="row">
       <div class="col-12 mt-2">
         <div class="card">
           <div class="card-body">
             <table id="memList" class="table table-bordered table-hover text-center">
               <thead>
               <tr class="bg-info">
                 <th class="bg-white" width="5%"><input type="checkbox" id="chkAll" name="memId"></th>
                 <th>아이디</th>
                 <th>비밀번호</th>
                 <th>이메일</th>
                 <th>전화번호</th>
                 <th>관리</th>
               </tr>
               </thead>
               <tbody>
               <c:if test="${empty list }">
				<tr>
					<td colspan="6">등록된 회원이 없습니다.</td>
				</tr>
			   </c:if>
			   <c:forEach items="${list }" var="list">
               <tr>
                 <td><input type="checkbox" name="memId" value="${list.memId }"></td>
                 <td>${list.memId }</td>
                 <td>${list.memPw }</td>
                 <td>${list.memEmail }</td>
				 <td>${list.memHp }</td>
                 <td>
					<a class="btn btn-outline-info btn-sm" onclick="fn_update('${list.memId }');">수정</a>
					<a class="btn btn-outline-danger btn-sm" onclick="fn_delete('${list.memId }');">삭제</a>
                 </td>
               </tr>
               </c:forEach>           
               </tbody>
               <tfoot>
                 <tr>
                   <td colspan="6" class="text-left">
                   	<a class="btn btn-outline-danger btn-sm" onclick="fn_deletes();">선택회원삭제</a>
                   </td>
                 </tr>
               </tfoot>
             </table>
           </div>
           <!-- /.card-body -->
         </div>
         <!-- /.card -->
       </div>
     </div>
     <!-- /.row -->
   </div><!-- /.container-fluid -->
 <form id="fm" method="post">
	<input type="hidden" id="memId" name="memId" />
 </form>
 </div>
 <!-- /.content -->

  </div>
  <!-- /.content-wrapper -->

  <footer class="main-footer">
    <div class="float-right d-none d-sm-inline">
      DDIT 2021.01 #403
    </div>
    Copyright &copy; 2021 <a href="https://github.com/Jinny-s">Jinny Jeong</a> All rights reserved.
  </footer>
</div>

<script src="<c:url value='/resources/bootstrap/plugins/jquery/jquery.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/dist/js/adminlte.min.js' />"></script>
<!-- DataTables  & Plugins -->
<script src="<c:url value='/resources/bootstrap/plugins/datatables/jquery.dataTables.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-bs4/js/dataTables.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-responsive/js/dataTables.responsive.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-responsive/js/responsive.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/dataTables.buttons.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.bootstrap4.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/jszip/jszip.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/pdfmake/pdfmake.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/pdfmake/vfs_fonts.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.html5.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.print.min.js' />"></script>
<script src="<c:url value='/resources/bootstrap/plugins/datatables-buttons/js/buttons.colVis.min.js' />"></script>
<script>
  $(document).ready(function(){
  	$("#chkAll").click(function(){
  		if($(this).prop("checked")) {
  			$(":checkbox").prop("checked", true);
  		} else {
  			$(":checkbox").prop("checked", false);
  		}
  	});
  	
  	$(":checkbox").not("#chkAll").click(function(){
  	var chkedBox = $(":checkbox:checked").not("#chkAll").length;
  		if(chkedBox == 5) {
  			$("#chkAll").prop("checked", true);
  		} else {
  			$("#chkAll").prop("checked", false);
  		}
  	});
  });
  
  $(function () {
    $("#memList").DataTable({
      "responsive": true, "lengthChange": false, "autoWidth": false,
      "buttons": ["copy", "csv", "excel", "pdf", "print", "colvis"]
    }).buttons().container().appendTo('#memList_wrapper .col-md-6:eq(0)');
    $('#example2').DataTable({
      "paging": true,
      "lengthChange": false,
      "searching": false,
      "ordering": true,
      "info": true,
      "autoWidth": false,
      "responsive": true,
    });
  });
  
  function fn_update(memId) {
	$('#memId').attr('value', memId);
	$('#fm').attr('method', 'get');
	$('#fm').attr('action', "<c:url value='/update'/>");
	$('#fm').submit();
  }

  function fn_delete(memId) {
	if(confirm('회원정보를 삭제하시겠습니까?')) {
		$('#memId').attr('value', memId);
		$('#fm').attr('action', "<c:url value='/delete'/>");
		$('#fm').submit();
	}
  }

  function fn_deletes() {
	if(confirm('선택하신 회원정보를 삭제하시겠습니까?')) {
		list="";
		$(":checkbox:checked").not("#chkAll").each(function(i,d){
		    list += d.value + ',';
		});
		list = list.substr(0, list.length-1);
		$('#memId').attr('value', list);
		$('#fm').attr('action', "<c:url value='/delete'/>");
		$('#fm').submit();
	}
  }
</script>
</body>
</html>