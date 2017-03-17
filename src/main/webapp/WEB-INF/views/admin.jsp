<%--
  Created by IntelliJ IDEA.
  User: khyajubikram
  Date: 3/14/2017
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="/WEB-INF/views/template/header.jsp"%>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>Administrator page</h1>

            <p class="lead">This is the administrator page!</p>
        </div>
        <h3>
            <a href="<c:url value="/admin/productInventory"/>">Product Inventory</a>
        </h3>
        <p>Here you can check, view and modify product inventory!</p>


        <%@include file="/WEB-INF/views/template/footer.jsp"%>


