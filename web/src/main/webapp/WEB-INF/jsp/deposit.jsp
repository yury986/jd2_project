<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>
<body>
<form role="credits" method="post" action="/web/deposits" >
    <table style="with: 50%">

        <tr>
            <td>Sum of deposit</td>
            <td><input type="text" name="sumdeposit" /></td>
        </tr>
        <tr>
            <td>Percent of deposit</td>
            <td><input type="text" name="percentdeposit" /></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form>
<a class="nav-link active" aria-current="page" href="/web/general"> To main</a>
<%@include file="footer.jsp"%>

