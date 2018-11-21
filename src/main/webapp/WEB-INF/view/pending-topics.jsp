<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="Dashboard">
  <meta name="keyword" content="Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
  <title>Forum - Admin Panel</title>

  <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/imports.jsp"/>
  <script>
      $(function () {
          $.ajax({
              url: '/ts?action=pendingTopics',
              method: 'GET',
              dataType: 'json',
              success: function (data) {
                  $('#pendingTopicsId').isEmpty();
                  data.forEach(function (topic) {
                      $('#pendingTopicsId').append('<tr>\n' +
                          '<td>'+topic.id+'</td>\n' +
                          '<td>'+topic.title+'</td>\n' +
                          '<td>'+topic.description+'</td>\n' +
                          '<td>'+topic.shareDate+'</td>\n' +
                          '<td>'+topic.viewCount+'</td>\n' +
                          '<td>'+topic.user.firstname+'</td>\n' +
                          '<td>'+topic.user.lastname+'</td>\n' +
                          '<td>'+topic.user.email+'</td>\n' +
                          '<td><a href="#" style="text-align: center">\n' +
                          '            <i class="fas fa-trash-alt" style="display: block"></i>\n' +
                          '        </a></td>\n' +
                          '<td><a href="#" style="text-align: center">\n' +
                          '            <i class="fas fa-check-circle" style="display: block"></i>\n' +
                          '        </a></td>\n' +
                          '</tr>');
                  })



              }



          })
      });
  </script>
</head>

<body>
  <section id="container">
    <!-- **********************************************************************************************************************************************************
        TOP BAR CONTENT & NOTIFICATIONS
        *********************************************************************************************************************************************************** -->
    <!--header start-->
    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/header.jsp"/>
    <!--header end-->
    <!-- **********************************************************************************************************************************************************
        MAIN SIDEBAR MENU
        *********************************************************************************************************************************************************** -->
    <!--sidebar start-->
    <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/sidebar.jsp"/>
    <!--sidebar end-->
    <!-- **********************************************************************************************************************************************************
        MAIN CONTENT
        *********************************************************************************************************************************************************** -->
    <!--main content start-->
    <section id="main-content">
      <section class="wrapper site-min-height">
        <h3><i class="fa fa-angle-right"></i> Pending Topics</h3>
        <div class="row mt">
          <div class="col-lg-12">

            <table id="example" class="display" style="width:100%">
              <thead>
              <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
                <th>Share date</th>
                <th>View count</th>
                <th>User's firstname</th>
                <th>User's lastname</th>
                <th>User's email</th>
                <th>Delete</th>
                <th>Activate</th>
              </tr>
              </thead>
              <tbody id="pendingTopicsId">

              </tbody>
            </table>

          </div>
        </div>
      </section>
      <!-- /wrapper -->
    </section>
    <!--main content end-->
    <!--footer start-->
      <c:import url="${pageContext.request.contextPath}/WEB-INF/fragment/footer.jsp"/>
    <!--footer end-->
  </section>
  <!-- js placed at the end of the document so the pages load faster -->
</body>

</html>
