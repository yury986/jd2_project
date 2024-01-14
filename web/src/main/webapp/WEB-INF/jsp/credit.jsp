<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@include file="header.jsp"%>
<body>
<form role="credits" method="post" action="/web/credits" >
    <table style="with: 50%">

        <tr>
            <td>Sum of credit</td>
            <td><input type="text" name="sumcredit" /></td>
        </tr>
        <tr>
            <td>Persent of credit</td>
            <td><input type="text" name="percentcredit" /></td>
        </tr>
    </table>
    <input type="submit" value="Save" />
</form>
<a class="nav-link active" aria-current="page" href="/web/general"> To main</a>
<%@include file="footer.jsp"%>

